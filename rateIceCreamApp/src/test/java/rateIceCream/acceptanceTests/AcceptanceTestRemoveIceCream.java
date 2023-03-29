package rateIceCream.acceptanceTests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import rateIceCream.config.IceCreamListConfiguration;
import rateIceCream.core.requests.AddIceCreamRequest;
import rateIceCream.core.requests.GetAllIceCreamsRequest;
import rateIceCream.core.requests.RemoveIceCreamRequest;
import rateIceCream.core.responses.GetAllIceCreamsResponse;
import rateIceCream.core.services.AddIceCreamService;
import rateIceCream.core.services.GetAllIceCreamsService;
import rateIceCream.core.services.RemoveIceCreamService;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AcceptanceTestRemoveIceCream {

    private ApplicationContext applicationContext;

    @BeforeEach
    public void setup() {
        applicationContext = new AnnotationConfigApplicationContext(IceCreamListConfiguration.class);
    }

    @Test
    public void shouldRemoveIceCreamFromList() {
        AddIceCreamRequest addIceCreamRequest1 = new AddIceCreamRequest("Name1", "Producer1", "1234567890123");
        getAddIceCreamService().execute(addIceCreamRequest1);
        AddIceCreamRequest addIceCreamRequest2 = new AddIceCreamRequest("Name1", "Producer2", "2345678901234");
        getAddIceCreamService().execute(addIceCreamRequest2);

        GetAllIceCreamsResponse response = getAllIceCreamsService().execute(new GetAllIceCreamsRequest());
        assertEquals(response.getIceCreams().size(), 2);

        RemoveIceCreamRequest removeIceCreamRequest = new RemoveIceCreamRequest(1L);
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
}
