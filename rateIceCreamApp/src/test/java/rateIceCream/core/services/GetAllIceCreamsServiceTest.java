package rateIceCream.core.services;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import rateIceCream.core.domain.IceCream;
import rateIceCream.core.database.IceCreamRepository;
import rateIceCream.core.requests.iceCreamRequests.GetAllIceCreamsRequest;
import rateIceCream.core.responses.iceCreamResponses.GetAllIceCreamsResponse;
import rateIceCream.core.services.iceCreamServices.GetAllIceCreamsService;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class GetAllIceCreamsServiceTest {
    @Mock
    private IceCreamRepository iceCreamRepository;
    @InjectMocks
    private GetAllIceCreamsService service;


    @Test
    public void shouldGetIceCreamsFromDatabase() {
        List<IceCream> iceCreams = new ArrayList<>();
        iceCreams.add(new IceCream("Name", "Producer", "1234567890123"));
        iceCreams.add(new IceCream("Name2", "Producer2", "2345678901234"));
        Mockito.when(iceCreamRepository.getAllIceCreams()).thenReturn(iceCreams);

        GetAllIceCreamsRequest request = new GetAllIceCreamsRequest();
        GetAllIceCreamsResponse response = service.execute(request);
        assertFalse(response.hasErrors());
        assertEquals(response.getIceCreams().size(), 2);
        assertEquals(response.getIceCreams().get(0).getName(), "Name");
        assertEquals(response.getIceCreams().get(0).getProducer(), "Producer");
        assertEquals(response.getIceCreams().get(0).getBarcode(), "1234567890123");
        assertEquals(response.getIceCreams().get(1).getName(), "Name2");
        assertEquals(response.getIceCreams().get(1).getProducer(), "Producer2");
        assertEquals(response.getIceCreams().get(1).getBarcode(), "2345678901234");
    }


}