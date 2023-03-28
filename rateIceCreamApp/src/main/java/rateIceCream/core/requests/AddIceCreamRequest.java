package rateIceCream.core.requests;

public class AddIceCreamRequest {

    private String name;
    private String producer;
    private String barcode;

    public AddIceCreamRequest(String name, String producer, String barcode) {
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

    public String getBarcode() {
        return barcode;
    }
}
