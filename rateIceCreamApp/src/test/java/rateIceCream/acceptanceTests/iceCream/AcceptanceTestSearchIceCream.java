package rateIceCream.acceptanceTests.iceCream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import rateIceCream.DatabaseCleaner;
import rateIceCream.config.IceCreamListConfiguration;
import rateIceCream.core.requests.iceCreamRequests.AddIceCreamRequest;
import rateIceCream.core.requests.Ordering;
import rateIceCream.core.requests.Paging;
import rateIceCream.core.requests.iceCreamRequests.SearchIceCreamRequest;
import rateIceCream.core.responses.iceCreamResponses.SearchIceCreamResponse;
import rateIceCream.core.services.iceCreamServices.AddIceCreamService;
import rateIceCream.core.services.iceCreamServices.SearchIceCreamService;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AcceptanceTestSearchIceCream {

    private ApplicationContext applicationContext;

    @BeforeEach
    public void setup() {
        applicationContext = new AnnotationConfigApplicationContext(IceCreamListConfiguration.class);
        getDatabaseCleaner().clean();
    }

    @Test
    public void searchIceCreams() {
        AddIceCreamRequest addIceCreamRequest1 = new AddIceCreamRequest("Name1", "Producer1", "1234567890123");
        getAddIceCreamService().execute(addIceCreamRequest1);
        AddIceCreamRequest addIceCreamRequest2 = new AddIceCreamRequest("Name1", "Producer2", "2345678901234");
        getAddIceCreamService().execute(addIceCreamRequest2);

        SearchIceCreamRequest searchIceCreamRequest = new SearchIceCreamRequest("Name1", null, null);
        SearchIceCreamResponse searchIceCreamResponse = getSearchIceCreamService().execute(searchIceCreamRequest);

        assertEquals(searchIceCreamResponse.getIceCreams().size(), 2);
        assertEquals(searchIceCreamResponse.getIceCreams().get(0).getName(), "Name1");
        assertEquals(searchIceCreamResponse.getIceCreams().get(1).getName(), "Name1");
        assertEquals(searchIceCreamResponse.getIceCreams().get(0).getProducer(), "Producer1");
        assertEquals(searchIceCreamResponse.getIceCreams().get(1).getProducer(), "Producer2");
        assertEquals(searchIceCreamResponse.getIceCreams().get(0).getBarcode(), "1234567890123");
        assertEquals(searchIceCreamResponse.getIceCreams().get(1).getBarcode(), "2345678901234");
    }

    @Test
    public void searchIceCreamsAscendingOrdering() {
        AddIceCreamRequest addIceCreamRequest1 = new AddIceCreamRequest("Name1", "Producer1", "1234567890123");
        getAddIceCreamService().execute(addIceCreamRequest1);
        AddIceCreamRequest addIceCreamRequest2 = new AddIceCreamRequest("Name1", "Producer2", "2345678901234");
        getAddIceCreamService().execute(addIceCreamRequest2);

        Ordering ordering = new Ordering("producer", "ASC");
        SearchIceCreamRequest searchIceCreamRequest = new SearchIceCreamRequest("Name1", null, null, ordering);
        SearchIceCreamResponse searchIceCreamResponse = getSearchIceCreamService().execute(searchIceCreamRequest);

        assertEquals(searchIceCreamResponse.getIceCreams().size(), 2);
        assertEquals(searchIceCreamResponse.getIceCreams().get(0).getName(), "Name1");
        assertEquals(searchIceCreamResponse.getIceCreams().get(1).getName(), "Name1");
        assertEquals(searchIceCreamResponse.getIceCreams().get(0).getProducer(), "Producer1");
        assertEquals(searchIceCreamResponse.getIceCreams().get(1).getProducer(), "Producer2");
        assertEquals(searchIceCreamResponse.getIceCreams().get(0).getBarcode(), "1234567890123");
        assertEquals(searchIceCreamResponse.getIceCreams().get(1).getBarcode(), "2345678901234");
    }

    @Test
    public void searchIceCreamsDescendingOrdering() {
        AddIceCreamRequest addIceCreamRequest1 = new AddIceCreamRequest("Name1", "Producer1", "1234567890123");
        getAddIceCreamService().execute(addIceCreamRequest1);
        AddIceCreamRequest addIceCreamRequest2 = new AddIceCreamRequest("Name1", "Producer2", "2345678901234");
        getAddIceCreamService().execute(addIceCreamRequest2);

        Ordering ordering = new Ordering("producer", "DESC");
        SearchIceCreamRequest searchIceCreamRequest = new SearchIceCreamRequest("Name1", null, null, ordering);
        SearchIceCreamResponse searchIceCreamResponse = getSearchIceCreamService().execute(searchIceCreamRequest);

        assertEquals(searchIceCreamResponse.getIceCreams().size(), 2);
        assertEquals(searchIceCreamResponse.getIceCreams().get(0).getName(), "Name1");
        assertEquals(searchIceCreamResponse.getIceCreams().get(1).getName(), "Name1");
        assertEquals(searchIceCreamResponse.getIceCreams().get(0).getProducer(), "Producer2");
        assertEquals(searchIceCreamResponse.getIceCreams().get(1).getProducer(), "Producer1");
        assertEquals(searchIceCreamResponse.getIceCreams().get(0).getBarcode(), "2345678901234");
        assertEquals(searchIceCreamResponse.getIceCreams().get(1).getBarcode(), "1234567890123");
    }

    @Test
    public void searchIceCreamsOrderingPaging() {
        AddIceCreamRequest addIceCreamRequest1 = new AddIceCreamRequest("Name1", "Producer1", "1234567890123");
        getAddIceCreamService().execute(addIceCreamRequest1);
        AddIceCreamRequest addIceCreamRequest2 = new AddIceCreamRequest("Name1", "Producer2", "2345678901234");
        getAddIceCreamService().execute(addIceCreamRequest2);

        Ordering ordering = new Ordering("producer", "DESC");
        Paging paging = new Paging(1, 1);
        SearchIceCreamRequest searchIceCreamRequest = new SearchIceCreamRequest("Name1", null, null, ordering, paging);
        SearchIceCreamResponse searchIceCreamResponse = getSearchIceCreamService().execute(searchIceCreamRequest);

        assertEquals(searchIceCreamResponse.getIceCreams().size(), 1);
        assertEquals(searchIceCreamResponse.getIceCreams().get(0).getName(), "Name1");
        assertEquals(searchIceCreamResponse.getIceCreams().get(0).getProducer(), "Producer2");
        assertEquals(searchIceCreamResponse.getIceCreams().get(0).getBarcode(), "2345678901234");
    }

    private AddIceCreamService getAddIceCreamService() {
        return applicationContext.getBean(AddIceCreamService.class);
    }

    private SearchIceCreamService getSearchIceCreamService() {
        return applicationContext.getBean(SearchIceCreamService.class);
    }

    private DatabaseCleaner getDatabaseCleaner() {
        return applicationContext.getBean(DatabaseCleaner.class);
    }
}
