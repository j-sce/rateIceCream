package rateIceCream.core.requests;

public class AddIceCreamRequest {

    private String name;
    private String producer;
    private long barcode;

    public AddIceCreamRequest(String name, String producer, Long barcode) {
        this.name = name;
        this.producer = producer;
        this.barcode = barcode;
    }

    public String getName() {
        return name;
    }

    public String getProducer() {
        return producer;
    }

    public long getBarcode() {
        return barcode;
    }
}
