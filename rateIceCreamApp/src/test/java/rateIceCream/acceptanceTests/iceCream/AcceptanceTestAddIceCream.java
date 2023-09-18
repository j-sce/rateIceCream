package rateIceCream.acceptanceTests.iceCream;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import rateIceCream.core.DatabaseCleaner;
import rateIceCream.config.SpringCoreConfiguration;
import rateIceCream.core.requests.iceCreamRequests.AddIceCreamRequest;
import rateIceCream.core.requests.iceCreamRequests.GetAllIceCreamsRequest;
import rateIceCream.core.responses.iceCreamResponses.AddIceCreamResponse;
import rateIceCream.core.responses.iceCreamResponses.GetAllIceCreamsResponse;
import rateIceCream.core.services.iceCreamServices.AddIceCreamService;
import rateIceCream.core.services.iceCreamServices.GetAllIceCreamsService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class AcceptanceTestAddIceCream {

    private ApplicationContext applicationContext;

    @BeforeEach
    public void setup() {
        applicationContext = new AnnotationConfigApplicationContext(SpringCoreConfiguration.class);
        getDatabaseCleaner().clean();
    }

    @Test
    public void shouldAddIceCreamToList() {
        AddIceCreamRequest addIceCreamRequest = new AddIceCreamRequest("Name1", "Producer1", "1234567890129");
        getAddIceCreamService().execute(addIceCreamRequest);

        GetAllIceCreamsResponse response = getAllIceCreamsService().execute(new GetAllIceCreamsRequest());
        assertEquals(response.getIceCreams().size(), 1);
    }

    @Test
    public void shouldNotAddIceCreamToList() {
        AddIceCreamRequest addIceCreamRequest = new AddIceCreamRequest(null, "Producer1", "1234567890130");
        getAddIceCreamService().execute(addIceCreamRequest);
        AddIceCreamResponse addIceCreamResponse = getAddIceCreamService().execute(addIceCreamRequest);
        GetAllIceCreamsResponse getAllIceCreamsResponse = getAllIceCreamsService().execute(new GetAllIceCreamsRequest());

        assertEquals(getAllIceCreamsResponse.getIceCreams().size(), 0);
        assertTrue(addIceCreamResponse.hasErrors());
        assertEquals(addIceCreamResponse.getErrors().size(), 1);
    }

    @Test
    public void shouldNotAddSecondIceCreamToList() {
        AddIceCreamRequest addIceCreamRequest = new AddIceCreamRequest("Name5", "Producer1", "1234567890132");
        getAddIceCreamService().execute(addIceCreamRequest);

        GetAllIceCreamsResponse getAllIceCreamsResponse = getAllIceCreamsService().execute(new GetAllIceCreamsRequest());
        assertEquals(getAllIceCreamsResponse.getIceCreams().size(), 1);


        AddIceCreamRequest addIceCreamRequest2 = new AddIceCreamRequest(null, "Producer1", "11111111111111");
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

    private DatabaseCleaner getDatabaseCleaner() {
        return applicationContext.getBean(DatabaseCleaner.class);
    }
}
