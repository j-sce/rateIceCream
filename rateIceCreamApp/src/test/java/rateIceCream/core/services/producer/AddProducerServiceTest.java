package rateIceCream.core.services.producer;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import rateIceCream.core.CoreError;
import rateIceCream.core.database.jpa.JpaProducerRepository;
import rateIceCream.core.requests.producerRequests.AddProducerRequest;
import rateIceCream.core.responses.producerResponses.AddProducerResponse;
import rateIceCream.core.services.producerServices.AddProducerService;
import rateIceCream.core.validators.producerValidators.AddProducerRequestValidator;
import rateIceCream.matchers.ProducerMatcher;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.argThat;

@ExtendWith(MockitoExtension.class)
class AddProducerServiceTest {

    @Mock
    private JpaProducerRepository producerRepository;

    @Mock
    private AddProducerRequestValidator validator;

    @InjectMocks
    private AddProducerService addProducerService;


    @Test
    public void shouldReturnResponseWithErrorsWhenValidationFails() {
        AddProducerRequest request = new AddProducerRequest(null);
        List<CoreError> errors = new ArrayList<>();
        errors.add(new CoreError("Name", "must not be empty!"));
        Mockito.when(validator.validate(request)).thenReturn(errors);

        AddProducerResponse response = addProducerService.execute(request);
        assertTrue(response.hasErrors());
        assertEquals(response.getErrors().size(), 1);
        assertEquals(response.getErrors().get(0).getField(), "Name");
        assertEquals(response.getErrors().get(0).getMessage(), "must not be empty!");

        Mockito.verifyNoInteractions(producerRepository);
    }

    @Test
    public void shouldAddProducerToDatabase() {
        Mockito.when(validator.validate(any())).thenReturn(new ArrayList<>());
        AddProducerRequest request = new AddProducerRequest("Name");
        AddProducerResponse response = addProducerService.execute(request);
        assertFalse(response.hasErrors());
        Mockito.verify(producerRepository).save(
                argThat(new ProducerMatcher("Name")));
    }

}