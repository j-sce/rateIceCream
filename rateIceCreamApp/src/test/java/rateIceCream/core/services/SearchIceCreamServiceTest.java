package rateIceCream.core.services;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import rateIceCream.IceCream;
import rateIceCream.core.CoreError;
import rateIceCream.core.database.Database;
import rateIceCream.core.requests.Ordering;
import rateIceCream.core.requests.Paging;
import rateIceCream.core.requests.SearchIceCreamRequest;
import rateIceCream.core.responses.SearchIceCreamResponse;
import rateIceCream.core.validators.SearchIceCreamRequestValidator;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;


@ExtendWith(MockitoExtension.class)
public class SearchIceCreamServiceTest {

    @Mock
    private Database database;
    @Mock
    private SearchIceCreamRequestValidator validator;
    @InjectMocks
    private SearchIceCreamService service;

    @Test
    public void shouldReturnResponseWithErrorWhenValidatorFails() {
        SearchIceCreamRequest request = new SearchIceCreamRequest(null, null, null);
        List<CoreError> errors = new ArrayList<>();
        errors.add(new CoreError("Fields", "must not be empty!"));
        Mockito.when(validator.validate(request)).thenReturn(errors);

        SearchIceCreamResponse response = service.execute(request);
        assertTrue(response.hasErrors());
        assertEquals(response.getErrors().size(), 1);

        Mockito.verify(validator).validate(request);
        Mockito.verify(validator).validate(any());
        Mockito.verifyNoInteractions(database);
    }

    @Test
    public void shouldSearchByName() {
        SearchIceCreamRequest request = new SearchIceCreamRequest("Name", null, null);
        Mockito.when(validator.validate(request)).thenReturn(new ArrayList<>());

        List<IceCream> iceCreams = new ArrayList<>();
        iceCreams.add(new IceCream("Name", "Producer", "1234567890123"));
        Mockito.when(database.findByName("Name")).thenReturn(iceCreams);

        SearchIceCreamResponse response = service.execute(request);
        assertFalse(response.hasErrors());
        assertEquals(response.getIceCreams().size(), 1);
        assertEquals(response.getIceCreams().get(0).getName(), "Name");
        assertEquals(response.getIceCreams().get(0).getProducer(), "Producer");
        assertEquals(response.getIceCreams().get(0).getBarcode(), "1234567890123");
    }

    @Test
    public void shouldSearchByProducer() {
        SearchIceCreamRequest request = new SearchIceCreamRequest(null, "Producer", null);
        Mockito.when(validator.validate(request)).thenReturn(new ArrayList<>());

        List<IceCream> iceCreams = new ArrayList<>();
        iceCreams.add(new IceCream("Name", "Producer", "1234567890123"));
        Mockito.when(database.findByProducer("Producer")).thenReturn(iceCreams);

        SearchIceCreamResponse response = service.execute(request);
        assertFalse(response.hasErrors());
        assertEquals(response.getIceCreams().size(), 1);
        assertEquals(response.getIceCreams().get(0).getName(), "Name");
        assertEquals(response.getIceCreams().get(0).getProducer(), "Producer");
        assertEquals(response.getIceCreams().get(0).getBarcode(), "1234567890123");
    }

    @Test
    public void shouldSearchByNameAndProducer() {
        SearchIceCreamRequest request = new SearchIceCreamRequest("Name", "Producer", null);
        Mockito.when(validator.validate(request)).thenReturn(new ArrayList<>());

        List<IceCream> iceCreams = new ArrayList<>();
        iceCreams.add(new IceCream("Name", "Producer", "1234567890123"));
        Mockito.when(database.findByNameAndProducer("Name", "Producer")).thenReturn(iceCreams);

        SearchIceCreamResponse response = service.execute(request);
        assertFalse(response.hasErrors());
        assertEquals(response.getIceCreams().size(), 1);
        assertEquals(response.getIceCreams().get(0).getName(), "Name");
        assertEquals(response.getIceCreams().get(0).getProducer(), "Producer");
        assertEquals(response.getIceCreams().get(0).getBarcode(), "1234567890123");
    }

    @Test
    public void shouldSearchByBarcode() {
        SearchIceCreamRequest request = new SearchIceCreamRequest(null, null, "1234567890123");
        Mockito.when(validator.validate(request)).thenReturn(new ArrayList<>());

        List<IceCream> iceCreams = new ArrayList<>();
        iceCreams.add(new IceCream("Name", "Producer", "1234567890123"));
        Mockito.when(database.findByBarcode("1234567890123")).thenReturn(iceCreams);

        SearchIceCreamResponse response = service.execute(request);
        assertFalse(response.hasErrors());
        assertEquals(response.getIceCreams().size(), 1);
        assertEquals(response.getIceCreams().get(0).getName(), "Name");
        assertEquals(response.getIceCreams().get(0).getProducer(), "Producer");
        assertEquals(response.getIceCreams().get(0).getBarcode(), "1234567890123");
    }

    @Test
    public void shouldSearchByNameWithOrderingDescending() {
        Ordering ordering = new Ordering("producer", "DESC");
        SearchIceCreamRequest request = new SearchIceCreamRequest("Name", null, null, ordering);
        Mockito.when(validator.validate(request)).thenReturn(new ArrayList<>());

        List<IceCream> iceCreams = new ArrayList<>();
        iceCreams.add(new IceCream("Name", "Producer1", "1234567890123"));
        iceCreams.add(new IceCream("Name", "Producer2", "2345678901234"));
        Mockito.when(database.findByName("Name")).thenReturn(iceCreams);

        SearchIceCreamResponse response = service.execute(request);
        assertFalse(response.hasErrors());
        assertEquals(response.getIceCreams().size(), 2);
        assertEquals(response.getIceCreams().get(0).getProducer(), "Producer2");
        assertEquals(response.getIceCreams().get(1).getProducer(), "Producer1");
        assertEquals(response.getIceCreams().get(0).getBarcode(), "2345678901234");
        assertEquals(response.getIceCreams().get(1).getBarcode(), "1234567890123");
    }

    @Test
    public void shouldSearchByProducerWithOrderingAscending() {
        Ordering ordering = new Ordering("name", "ASC");
        SearchIceCreamRequest request = new SearchIceCreamRequest(null, "Producer", null, ordering);
        Mockito.when(validator.validate(request)).thenReturn(new ArrayList<>());

        List<IceCream> iceCreams = new ArrayList<>();
        iceCreams.add(new IceCream("Name1", "Producer", "1234567890123"));
        iceCreams.add(new IceCream("Name2", "Producer", "2345678901234"));
        Mockito.when(database.findByProducer("Producer")).thenReturn(iceCreams);

        SearchIceCreamResponse response = service.execute(request);
        assertFalse(response.hasErrors());
        assertEquals(response.getIceCreams().size(), 2);
        assertEquals(response.getIceCreams().get(0).getName(), "Name1");
        assertEquals(response.getIceCreams().get(1).getName(), "Name2");
        assertEquals(response.getIceCreams().get(0).getBarcode(), "1234567890123");
        assertEquals(response.getIceCreams().get(1).getBarcode(), "2345678901234");
    }

    @Test
    public void shouldSearchByProducerWithPagingSecondPage() {
        Paging paging = new Paging(2, 1);
        SearchIceCreamRequest request = new SearchIceCreamRequest(null, "Producer", null, paging);
        Mockito.when(validator.validate(request)).thenReturn(new ArrayList<>());

        List<IceCream> iceCreams = new ArrayList<>();
        iceCreams.add(new IceCream("Name1", "Producer", "1234567890123"));
        iceCreams.add(new IceCream("Name2", "Producer", "2345678901234"));
        Mockito.when(database.findByProducer("Producer")).thenReturn(iceCreams);

        SearchIceCreamResponse response = service.execute(request);
        assertFalse(response.hasErrors());
        assertEquals(response.getIceCreams().size(), 1);
        assertEquals(response.getIceCreams().get(0).getName(), "Name2");
        assertEquals(response.getIceCreams().get(0).getBarcode(), "2345678901234");
    }

}