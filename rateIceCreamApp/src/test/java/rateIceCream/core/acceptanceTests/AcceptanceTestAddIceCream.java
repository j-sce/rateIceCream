package rateIceCream.core.acceptanceTests;

import org.junit.jupiter.api.Test;
import rateIceCream.ApplicationContext;
import rateIceCream.core.requests.AddIceCreamRequest;
import rateIceCream.core.requests.GetAllIceCreamsRequest;
import rateIceCream.core.responses.AddIceCreamResponse;
import rateIceCream.core.responses.GetAllIceCreamsResponse;
import rateIceCream.core.services.AddIceCreamService;
import rateIceCream.core.services.GetAllIceCreamsService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AcceptanceTestAddIceCream {

    private ApplicationContext applicationContext = new ApplicationContext();

    @Test
    public void shouldAddIceCreamToList() {
        AddIceCreamRequest addIceCreamRequest = new AddIceCreamRequest("Name1", "Producer1", "1234567890123");
        getAddIceCreamService().execute(addIceCreamRequest);

        GetAllIceCreamsResponse response = getAllIceCreamsService().execute(new GetAllIceCreamsRequest());
        assertEquals(response.getIceCreams().size(), 1);
    }

    @Test
    public void shouldNotAddIceCreamToList() {
        AddIceCreamRequest addIceCreamRequest = new AddIceCreamRequest(null, "Producer1", "1234567890123");
        getAddIceCreamService().execute(addIceCreamRequest);
        AddIceCreamResponse addIceCreamResponse = getAddIceCreamService().execute(addIceCreamRequest);
        GetAllIceCreamsResponse getAllIceCreamsResponse = getAllIceCreamsService().execute(new GetAllIceCreamsRequest());

        assertEquals(getAllIceCreamsResponse.getIceCreams().size(), 0);
        assertTrue(addIceCreamResponse.hasErrors());
        assertEquals(addIceCreamResponse.getErrors().size(), 1);
    }

    @Test
    public void shouldNotAddSecondIceCreamToList() {
        AddIceCreamRequest addIceCreamRequest = new AddIceCreamRequest("Name1", "Producer1", "1234567890123");
        getAddIceCreamService().execute(addIceCreamRequest);

        GetAllIceCreamsResponse getAllIceCreamsResponse = getAllIceCreamsService().execute(new GetAllIceCreamsRequest());
        assertEquals(getAllIceCreamsResponse.getIceCreams().size(), 1);


        AddIceCreamRequest addIceCreamRequest2 = new AddIceCreamRequest(null, "Producer1", "1234567890123");
        getAddIceCreamService().execute(addIceCreamRequest2);
        AddIceCreamResponse addIceCreamResponse = getAddIceCreamService().execute(addIceCreamRequest2);
        getAllIceCreamsResponse = getAllIceCreamsService().execute(new GetAllIceCreamsRequest());

        assertEquals(getAllIceCreamsResponse.getIceCreams().size(), 1);
        assertTrue(addIceCreamResponse.hasErrors());
        assertEquals(addIceCreamResponse.getErrors().size(), 1);
    }

    private AddIceCreamService getAddIceCreamService() {
        return applicationContext.getBean(AddIceCreamService.class);
    }

    private GetAllIceCreamsService getAllIceCreamsService() {
        return applicationContext.getBean(GetAllIceCreamsService.class);
    }
}
