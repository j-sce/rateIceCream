package rateIceCream.core.validators.producer;

import org.junit.jupiter.api.Test;
import rateIceCream.core.CoreError;
import rateIceCream.core.requests.producerRequests.AddProducerRequest;
import rateIceCream.core.validators.producerValidators.AddProducerRequestValidator;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AddProducerRequestValidatorTest {

    private AddProducerRequestValidator validator = new AddProducerRequestValidator();

    @Test
    public void shouldReturnErrorWhenNameIsEmpty() {
        AddProducerRequest request = new AddProducerRequest(null);
        List<CoreError> errors = validator.validate(request);
        assertEquals(errors.size(), 1);
        assertEquals(errors.get(0).getField(), "Name");
        assertEquals(errors.get(0).getMessage(), "must not be empty!");
    }

    @Test
    public void shouldSuccess() {
        AddProducerRequest request = new AddProducerRequest("Name");
        List<CoreError> errors = validator.validate(request);
        assertEquals(errors.size(), 0);
    }
}