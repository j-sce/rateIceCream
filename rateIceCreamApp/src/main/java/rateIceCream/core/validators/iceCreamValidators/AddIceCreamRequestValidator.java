package rateIceCream.core.validators.iceCreamValidators;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import rateIceCream.core.CoreError;
import rateIceCream.core.database.IceCreamRepository;
import rateIceCream.core.requests.iceCreamRequests.AddIceCreamRequest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class AddIceCreamRequestValidator {

    @Autowired
    IceCreamRepository iceCreamRepository;

    public List<CoreError> validate(AddIceCreamRequest request) {
        List<CoreError> errors = new ArrayList<>();
        validateName(request).ifPresent(errors::add);
        validateProducer(request).ifPresent(errors::add);
        validateBarcode(request).ifPresent(errors::add);
        validateUnique(request).ifPresent(errors::add);
        return errors;
    }

    private Optional<CoreError> validateName(AddIceCreamRequest request) {
        return (request.getName() == null || request.getName().isEmpty())
                ? Optional.of(new CoreError("Name", "must not be empty!"))
                : Optional.empty();
    }

    private Optional<CoreError> validateProducer(AddIceCreamRequest request) {
        return (request.getProducer() == null || request.getProducer().isEmpty())
                ? Optional.of(new CoreError("Producer", "must not be empty!"))
                : Optional.empty();
    }

    private Optional<CoreError> validateBarcode(AddIceCreamRequest request) {
        return (request.getBarcode() == null || request.getBarcode().isEmpty())
                ? Optional.of(new CoreError("Barcode", "must not be empty!"))
                : Optional.empty();
    }
    private Optional<CoreError> validateUnique(AddIceCreamRequest request) {
        return (iceCreamRepository.findByBarcode(request.getBarcode()).size() > 0)
                ? Optional.of(new CoreError("Barcode", "is not unique!"))
                : Optional.empty();
    }
}
