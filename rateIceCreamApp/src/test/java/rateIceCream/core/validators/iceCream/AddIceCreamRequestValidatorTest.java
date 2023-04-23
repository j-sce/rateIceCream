package rateIceCream.core.validators.iceCream;

import org.junit.jupiter.api.Test;
import rateIceCream.core.CoreError;

import rateIceCream.core.requests.iceCreamRequests.AddIceCreamRequest;
import rateIceCream.core.validators.iceCreamValidators.AddIceCreamRequestValidator;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AddIceCreamRequestValidatorTest {

    private AddIceCreamRequestValidator validator = new AddIceCreamRequestValidator();

    @Test
    public void shouldReturnErrorWhenNameIsEmpty() {
        AddIceCreamRequest request = new AddIceCreamRequest(null, "Producer", "1234567890123");
        List<CoreError> errors = validator.validate(request);
        assertEquals(errors.size(), 1);
        assertEquals(errors.get(0).getField(), "Name");
        assertEquals(errors.get(0).getMessage(), "must not be empty!");
    }

    @Test
    public void shouldReturnErrorWhenProducerIsEmpty() {
        AddIceCreamRequest request = new AddIceCreamRequest("Name", null, "1234567890123");
        List<CoreError> errors = validator.validate(request);
        assertEquals(errors.size(), 1);
        assertEquals(errors.get(0).getField(), "Producer");
        assertEquals(errors.get(0).getMessage(), "must not be empty!");
    }

    @Test
    public void shouldReturnErrorWhenBarcodeIsEmpty() {
        AddIceCreamRequest request = new AddIceCreamRequest("Name", "Producer", null);
        List<CoreError> errors = validator.validate(request);
        assertEquals(errors.size(), 1);
        assertEquals(errors.get(0).getField(), "Barcode");
        assertEquals(errors.get(0).getMessage(), "must not be empty!");
    }

    @Test
    public void shouldSuccess() {
        AddIceCreamRequest request = new AddIceCreamRequest("Name", "Producer", "1234567890123");
        List<CoreError> errors = validator.validate(request);
        assertEquals(errors.size(), 0);
    }
}