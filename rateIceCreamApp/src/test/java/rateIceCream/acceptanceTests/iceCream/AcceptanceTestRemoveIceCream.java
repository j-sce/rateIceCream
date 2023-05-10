package rateIceCream.acceptanceTests.iceCream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import rateIceCream.DatabaseCleaner;
import rateIceCream.config.SpringCoreConfiguration;
import rateIceCream.core.requests.iceCreamRequests.AddIceCreamRequest;
import rateIceCream.core.requests.iceCreamRequests.GetAllIceCreamsRequest;
import rateIceCream.core.requests.iceCreamRequests.RemoveIceCreamRequest;
import rateIceCream.core.responses.iceCreamResponses.GetAllIceCreamsResponse;
import rateIceCream.core.services.iceCreamServices.AddIceCreamService;
import rateIceCream.core.services.iceCreamServices.GetAllIceCreamsService;
import rateIceCream.core.services.iceCreamServices.RemoveIceCreamService;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AcceptanceTestRemoveIceCream {

    private ApplicationContext applicationContext;

    @BeforeEach
    public void setup() {
        applicationContext = new AnnotationConfigApplicationContext(SpringCoreConfiguration.class);
        getDatabaseCleaner().clean();
    }

    @Test
    public void shouldRemoveIceCreamFromList() {
        AddIceCreamRequest addIceCreamRequest1 = new AddIceCreamRequest("Name1", "Producer1", "1234567890123");
        getAddIceCreamService().execute(addIceCreamRequest1);
        AddIceCreamRequest addIceCreamRequest2 = new AddIceCreamRequest("Name1", "Producer2", "2345678901234");
        getAddIceCreamService().execute(addIceCreamRequest2);

        GetAllIceCreamsResponse response = getAllIceCreamsService().execute(new GetAllIceCreamsRequest());
        assertEquals(response.getIceCreams().size(), 2);

        RemoveIceCreamRequest removeIceCreamRequest = new RemoveIceCreamRequest(1005L);
        getRemoveIceCreamService().execute(removeIceCreamRequest);
        response = getAllIceCreamsService().execute(new GetAllIceCreamsRequest());
        assertEquals(response.getIceCreams().size(), 1);
        assertEquals(response.getIceCreams().get(0).getProducer(), "Producer2");
    }

    private AddIceCreamService getAddIceCreamService() {
        return applicationContext.getBean(AddIceCreamService.class);
    }

    private RemoveIceCreamService getRemoveIceCreamService() {
        return applicationContext.getBean(RemoveIceCreamService.class);
    }

    private GetAllIceCreamsService getAllIceCreamsService() {
        return applicationContext.getBean(GetAllIceCreamsService.class);
    }

    private DatabaseCleaner getDatabaseCleaner() {
        return applicationContext.getBean(DatabaseCleaner.class);
    }
}
