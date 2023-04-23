package rateIceCream.core.validators.iceCream;

import org.junit.jupiter.api.Test;
import rateIceCream.core.CoreError;
import rateIceCream.core.requests.iceCreamRequests.RemoveIceCreamRequest;
import rateIceCream.core.validators.iceCreamValidators.RemoveIceCreamRequestValidator;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RemoveIceCreamRequestValidatorTest {

    private RemoveIceCreamRequestValidator validator = new RemoveIceCreamRequestValidator();

    @Test
    public void shouldReturnErrorsWhenIdIsEmpty() {
        RemoveIceCreamRequest request = new RemoveIceCreamRequest(null);
        List<CoreError> errors = validator.validate(request);
        assertEquals(errors.size(), 1);
        assertEquals(errors.get(0).getField(), "ID");
        assertEquals(errors.get(0).getMessage(), "must not be empty!");
    }

    @Test
    public void shouldSuccess() {
        RemoveIceCreamRequest request = new RemoveIceCreamRequest(1L);
        List<CoreError> errors = validator.validate(request);
        assertEquals(errors.size(), 0);
    }

}