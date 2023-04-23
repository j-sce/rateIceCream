package rateIceCream.core.validators.iceCream;

import org.junit.jupiter.api.Test;
import rateIceCream.core.CoreError;
import rateIceCream.core.requests.iceCreamRequests.GetIceCreamRequest;
import rateIceCream.core.validators.iceCreamValidators.GetIceCreamRequestValidator;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GetIceCreamRequestValidatorTest {

    private GetIceCreamRequestValidator validator = new GetIceCreamRequestValidator();

    @Test
    public void shouldReturnErrorWhenIdIsEmpty() {
        GetIceCreamRequest request = new GetIceCreamRequest(null);
        List<CoreError> errors = validator.validate(request);
        assertEquals(errors.size(), 1);
        assertEquals(errors.get(0).getField(), "ID");
        assertEquals(errors.get(0).getMessage(), "must not be empty!");
    }

    @Test
    public void shouldSuccess() {
        GetIceCreamRequest request = new GetIceCreamRequest(1L);
        List<CoreError> errors = validator.validate(request);
        assertEquals(errors.size(), 0);
    }

}