package rateIceCream.core.requests.iceCreamRequests;

import rateIceCream.core.requests.Ordering;
import rateIceCream.core.requests.Paging;

public class SearchIceCreamRequest {
    private String name;
    private String producer;
    private String barcode;
    private Ordering ordering;
    private Paging paging;

    public SearchIceCreamRequest() {
    }

    public SearchIceCreamRequest(String name, String producer, String barcode) {
        this.name = name;
        this.producer = producer;
        this.barcode = barcode;
    }

    public SearchIceCreamRequest(String name, String producer, String barcode, Ordering ordering) {
        this.name = name;
        this.producer = producer;
        this.barcode = barcode;
        this.ordering = ordering;
    }

    public SearchIceCreamRequest(String name, String producer, String barcode, Paging paging) {
        this.name = name;
        this.producer = producer;
        this.barcode = barcode;
        this.paging = paging;
    }

    public SearchIceCreamRequest(String name, String producer, String barcode, Ordering ordering, Paging paging) {
        this.name = name;
        this.producer = producer;
        this.barcode = barcode;
        this.ordering = ordering;
        this.paging = paging;
    }

    public String getName() {
        return name;
    }

    public String getProducer() {
        return producer;
    }

    public String getBarcode() {
        return barcode;
    }

    public boolean isNameProvided() {
        return this.name != null && !this.name.isEmpty();
    }

    public boolean isProducerProvided() {
        return this.producer != null && !this.producer.isEmpty();
    }

    public boolean isBarcodeProvided() {
        return this.barcode != null && !this.barcode.isEmpty();
    }

    public Ordering getOrdering() {
        return ordering;
    }

    public Paging getPaging() {
        return paging;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public void setOrdering(Ordering ordering) {
        this.ordering = ordering;
    }

    public void setPaging(Paging paging) {
        this.paging = paging;
    }
}
