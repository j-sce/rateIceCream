package rateIceCream.core.services.producerServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import rateIceCream.core.CoreError;
import rateIceCream.core.database.ProducerRepository;
import rateIceCream.core.domain.Producer;
import rateIceCream.core.requests.producerRequests.AddProducerRequest;
import rateIceCream.core.responses.producerResponses.AddProducerResponse;
import rateIceCream.core.validators.producerValidators.AddProducerRequestValidator;

import java.util.List;

@Component
@Transactional
public class AddProducerService {

    @Autowired
    ProducerRepository producerRepository;

    @Autowired
    AddProducerRequestValidator validator;

    public AddProducerResponse execute(AddProducerRequest request) {
        List<CoreError> errors = validator.validate(request);
        if (!errors.isEmpty()) {
            return new AddProducerResponse(errors);
        }
        Producer producer = new Producer(request.getName());
        producerRepository.save(producer);
        return new AddProducerResponse(producer);
    }
}
