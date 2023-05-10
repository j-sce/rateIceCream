package rateIceCream.core.requests.iceCreamRequests;

public class AddIceCreamRequest {

    private String name;
    private String producer;
    private String barcode;

    public AddIceCreamRequest() {
    }

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

    public void setName(String name) {
        this.name = name;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }
}
