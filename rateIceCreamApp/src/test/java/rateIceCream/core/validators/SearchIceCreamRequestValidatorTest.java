package rateIceCream.core.validators;

import org.junit.jupiter.api.Test;
import rateIceCream.core.CoreError;
import rateIceCream.core.requests.Ordering;
import rateIceCream.core.requests.Paging;
import rateIceCream.core.requests.iceCreamRequests.SearchIceCreamRequest;
import rateIceCream.core.validators.iceCreamValidators.SearchIceCreamRequestValidator;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SearchIceCreamRequestValidatorTest {
    private SearchIceCreamRequestValidator validator = new SearchIceCreamRequestValidator();

    @Test
    public void shouldNotReturnErrorsWhenNameIsProvided() {
        SearchIceCreamRequest request = new SearchIceCreamRequest("name", null, null);
        List<CoreError> errors = validator.validate(request);
        assertEquals(errors.size(), 0);
    }

    @Test
    public void shouldNotReturnErrorsWhenProducerIsProvided() {
        SearchIceCreamRequest request = new SearchIceCreamRequest(null, "producer", null);
        List<CoreError> errors = validator.validate(request);
        assertEquals(errors.size(), 0);
    }

    @Test
    public void shouldNotReturnErrorsWhenBarcodeIsProvided() {
        SearchIceCreamRequest request = new SearchIceCreamRequest(null, null, "1234567890123");
        List<CoreError> errors = validator.validate(request);
        assertEquals(errors.size(), 0);
    }

    @Test
    public void shouldNotReturnErrorsWhenNameProducerBarcodeAreProvided() {
        SearchIceCreamRequest request = new SearchIceCreamRequest("Name", "Producer", "1234567890123");
        List<CoreError> errors = validator.validate(request);
        assertEquals(errors.size(), 0);
    }

    @Test
    public void shouldReturnErrorWhenOrderByIsEmpty() {
        Ordering ordering = new Ordering(null, "ASC");
        SearchIceCreamRequest request = new SearchIceCreamRequest("Name", "Producer", "1234567890123", ordering);
        List<CoreError> errors = validator.validate(request);
        assertEquals(errors.size(), 1);
        assertEquals(errors.get(0).getField(), "Order by");
        assertEquals(errors.get(0).getMessage(), "must not be empty!");
    }

    @Test
    public void shouldReturnErrorWhenOrderDirectionIsEmpty() {
        Ordering ordering = new Ordering("name", null);
        SearchIceCreamRequest request = new SearchIceCreamRequest("Name", "Producer", "1234567890123", ordering);
        List<CoreError> errors = validator.validate(request);
        assertEquals(errors.size(), 1);
        assertEquals(errors.get(0).getField(), "Order direction");
        assertEquals(errors.get(0).getMessage(), "must not be empty!");
    }

    @Test
    public void shouldReturnErrorWhenOrderByContainInvalidValue() {
        Ordering ordering = new Ordering("InvalidValue", "ASC");
        SearchIceCreamRequest request = new SearchIceCreamRequest("Name", "Producer", "1234567890123", ordering);
        List<CoreError> errors = validator.validate(request);
        assertEquals(errors.size(), 1);
        assertEquals(errors.get(0).getField(), "Order by");
        assertEquals(errors.get(0).getMessage(), "must contain 'name' or 'producer' only!");
    }

    @Test
    public void shouldReturnErrorWhenOrderDirectionContainInvalidValue() {
        Ordering ordering = new Ordering("producer", "InvalidValue");
        SearchIceCreamRequest request = new SearchIceCreamRequest("Name", "Producer", "1234567890123", ordering);
        List<CoreError> errors = validator.validate(request);
        assertEquals(errors.size(), 1);
        assertEquals(errors.get(0).getField(), "Order direction");
        assertEquals(errors.get(0).getMessage(), "must contain 'ASC' or 'DESC' only!");
    }

    @Test
    public void shouldReturnErrorWhenPageNumberContainInvalidValue() {
        Paging paging = new Paging(0, 2);
        SearchIceCreamRequest request = new SearchIceCreamRequest("Name", "Producer", "1234567890123", paging);
        List<CoreError> errors = validator.validate(request);
        assertEquals(errors.size(), 1);
        assertEquals(errors.get(0).getField(), "Page number");
        assertEquals(errors.get(0).getMessage(), "must be greater than 0!");
    }
    @Test
    public void shouldReturnErrorWhenPageSizeContainInvalidValue() {
        Paging paging = new Paging(1, 0);
        SearchIceCreamRequest request = new SearchIceCreamRequest("Name", "Producer", "1234567890123", paging);
        List<CoreError> errors = validator.validate(request);
        assertEquals(errors.size(), 1);
        assertEquals(errors.get(0).getField(), "Page size");
        assertEquals(errors.get(0).getMessage(), "must be greater than 0!");
    }

    @Test
    public void shouldReturnErrorWhenPageNumberIsEmpty() {
        Paging paging = new Paging(null, 1);
        SearchIceCreamRequest request = new SearchIceCreamRequest("Name", "Producer", "1234567890123", paging);
        List<CoreError> errors = validator.validate(request);
        assertEquals(errors.size(), 1);
        assertEquals(errors.get(0).getField(), "Page number");
        assertEquals(errors.get(0).getMessage(), "must not be empty!");
    }

    @Test
    public void shouldReturnErrorWhenPageSizeIsEmpty() {
        Paging paging = new Paging(1, null);
        SearchIceCreamRequest request = new SearchIceCreamRequest("Name", "Producer", "1234567890123", paging);
        List<CoreError> errors = validator.validate(request);
        assertEquals(errors.size(), 1);
        assertEquals(errors.get(0).getField(), "Page size");
        assertEquals(errors.get(0).getMessage(), "must not be empty!");
    }


}