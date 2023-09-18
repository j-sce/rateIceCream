package rateIceCream.core.services.iceCreamServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import rateIceCream.core.CoreError;
import rateIceCream.core.database.jpa.JpaIceCreamRepository;
import rateIceCream.core.domain.IceCream;
import rateIceCream.core.requests.Ordering;
import rateIceCream.core.requests.Paging;
import rateIceCream.core.requests.iceCreamRequests.SearchIceCreamRequest;
import rateIceCream.core.responses.iceCreamResponses.SearchIceCreamResponse;
import rateIceCream.core.validators.iceCreamValidators.SearchIceCreamRequestValidator;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Component
@Transactional
public class SearchIceCreamService {

    @Autowired
    private JpaIceCreamRepository iceCreamRepository;
    @Autowired
    private SearchIceCreamRequestValidator validator;

    public SearchIceCreamResponse execute(SearchIceCreamRequest request) {
        List<CoreError> errors = validator.validate(request);
        if (!errors.isEmpty()) {
            return new SearchIceCreamResponse(null, errors);
        }

        List<IceCream> iceCreams = search(request);
        iceCreams = order(iceCreams, request.getOrdering());
        iceCreams = paging(iceCreams, request.getPaging());
        return new SearchIceCreamResponse(iceCreams, null);
    }

    private List<IceCream> order(List<IceCream> IceCreams, Ordering ordering) {
        if (ordering != null) {
            Comparator<IceCream> comparator = ordering.getOrderBy().equals("name")
                    ? Comparator.comparing(IceCream::getName)
                    : Comparator.comparing(IceCream::getProducer);
            if (ordering.getOrderDirection().equals("DESC")) {
                comparator = comparator.reversed();
            }
            return IceCreams.stream().sorted(comparator).collect(Collectors.toList());
        } else {
            return IceCreams;
        }
    }

    private List<IceCream> search(SearchIceCreamRequest request) {
        List<IceCream> iceCreams = new ArrayList<>();
        if (request.isNameProvided() && !request.isProducerProvided()) {
            iceCreams = iceCreamRepository.findByName(request.getName());
        }
        if (!request.isNameProvided() && request.isProducerProvided()) {
            iceCreams = iceCreamRepository.findByProducer(request.getProducer());
        }
        if (request.isNameProvided() && request.isProducerProvided()) {
            iceCreams = iceCreamRepository.findByNameAndProducer(request.getName(), request.getProducer());
        }
        if (request.isBarcodeProvided()) {
            iceCreams = iceCreamRepository.findByBarcode(request.getBarcode());
        }
        return iceCreams;
    }

    private List<IceCream> paging(List<IceCream> books, Paging paging) {
        if (paging != null) {
            int skip = (paging.getPageNumber() - 1) * paging.getPageSize();
            return books.stream()
                    .skip(skip)
                    .limit(paging.getPageSize())
                    .collect(Collectors.toList());
        } else {
            return books;
        }
    }
}
