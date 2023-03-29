package rateIceCream.acceptanceTests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import rateIceCream.config.IceCreamListConfiguration;
import rateIceCream.core.requests.AddIceCreamRequest;
import rateIceCream.core.requests.GetAllIceCreamsRequest;
import rateIceCream.core.responses.GetAllIceCreamsResponse;
import rateIceCream.core.services.AddIceCreamService;
import rateIceCream.core.services.GetAllIceCreamsService;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AcceptanceTestGetAllIceCreams {

    private ApplicationContext applicationContext;

    @BeforeEach
    public void setup() {
        applicationContext = new AnnotationConfigApplicationContext(IceCreamListConfiguration.class);
    }

    @Test
    public void shouldReturnCorrectIceCreamList() {
        AddIceCreamRequest addIceCreamRequest1 = new AddIceCreamRequest("Name1", "Producer1", "1234567890123");
        getAddIceCreamService().execute(addIceCreamRequest1);

        AddIceCreamRequest addIceCreamRequest2 = new AddIceCreamRequest("Name1", "Producer1", "2345678901234");
        getAddIceCreamService().execute(addIceCreamRequest2);

        GetAllIceCreamsResponse response = getAllIceCreamsService().execute(new GetAllIceCreamsRequest());
        assertEquals(response.getIceCreams().size(), 2);
    }

    private AddIceCreamService getAddIceCreamService() {
        return applicationContext.getBean(AddIceCreamService.class);
    }

    private GetAllIceCreamsService getAllIceCreamsService() {
        return applicationContext.getBean(GetAllIceCreamsService.class);
    }

}