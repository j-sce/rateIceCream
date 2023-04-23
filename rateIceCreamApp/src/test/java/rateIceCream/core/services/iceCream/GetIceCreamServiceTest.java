package rateIceCream.core.services.iceCream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import rateIceCream.core.CoreError;
import rateIceCream.core.database.IceCreamRepository;
import rateIceCream.core.domain.IceCream;
import rateIceCream.core.requests.iceCreamRequests.GetIceCreamRequest;
import rateIceCream.core.responses.iceCreamResponses.GetIceCreamResponse;
import rateIceCream.core.services.iceCreamServices.GetIceCreamService;
import rateIceCream.core.validators.iceCreamValidators.GetIceCreamRequestValidator;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
class GetIceCreamServiceTest {

    @Mock
    private IceCreamRepository iceCreamRepository;

    @Mock
    private GetIceCreamRequestValidator validator;

    @InjectMocks
    private GetIceCreamService service;

    @Test
    public void shouldReturnErrorWhenIceCreamIdNotProvided() {
        GetIceCreamRequest request = new GetIceCreamRequest(null);
        List<CoreError> errors = new ArrayList<>();
        errors.add(new CoreError("ID", "must not be empty!"));
        Mockito.when(validator.validate(request)).thenReturn(errors);
        GetIceCreamResponse response = service.execute(request);
        assertTrue(response.hasErrors());
        assertEquals(response.getErrors().size(), 1);
        assertEquals(response.getErrors().get(0).getField(), "ID");
        assertEquals(response.getErrors().get(0).getMessage(), "must not be empty!");
    }

    @Test
    public void shouldGetIceCreamByIdFromDatabase() {
        Mockito.when(validator.validate(any())).thenReturn(new ArrayList<>());
        Mockito.when(iceCreamRepository.findById(1L)).thenReturn(new IceCream("IceCream1", "Producer1", "1234567890123"));
        GetIceCreamRequest request = new GetIceCreamRequest(1L);
        GetIceCreamResponse response = service.execute(request);
        assertFalse(response.hasErrors());
        assertEquals(response.getIceCream().getName(), "IceCream1");
        assertEquals(response.getIceCream().getProducer(), "Producer1");
        assertEquals(response.getIceCream().getBarcode(), "1234567890123");
    }
}