package rateIceCream.core.requests.producerRequests;

public class AddProducerRequest {

    private String name;

    public AddProducerRequest() {
    }

    public AddProducerRequest(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
