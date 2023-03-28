package rateIceCream.core.services;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import rateIceCream.core.CoreError;
import rateIceCream.core.database.Database;
import rateIceCream.core.requests.RemoveIceCreamRequest;
import rateIceCream.core.responses.RemoveIceCreamResponse;
import rateIceCream.core.validators.RemoveIceCreamRequestValidator;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
class RemoveIceCreamServiceTest {
    @Mock
    private Database database;
    @Mock
    private RemoveIceCreamRequestValidator validator;
    @InjectMocks
    private RemoveIceCreamService service;

    @Test
    public void shouldReturnErrorWhenIceCreamIdNotProvided() {
        RemoveIceCreamRequest request = new RemoveIceCreamRequest(null);
        List<CoreError> errors = new ArrayList<>();
        errors.add(new CoreError("ID", "must not be empty!"));
        Mockito.when(validator.validate(request)).thenReturn(errors);
        RemoveIceCreamResponse response = service.execute(request);
        assertTrue(response.hasErrors());
        assertEquals(response.getErrors().size(), 1);
        assertEquals(response.getErrors().get(0).getField(), "ID");
        assertEquals(response.getErrors().get(0).getMessage(), "must not be empty!");
    }

    @Test
    public void shouldDeleteIceCreamByIdFromDatabase() {
        Mockito.when(validator.validate(any())).thenReturn(new ArrayList<>());
        Mockito.when(database.deleteById(1L)).thenReturn(true);
        RemoveIceCreamRequest request = new RemoveIceCreamRequest(1L);
        RemoveIceCreamResponse response = service.execute(request);
        assertFalse(response.hasErrors());
        assertTrue(response.isIceCreamRemoved());
    }

}