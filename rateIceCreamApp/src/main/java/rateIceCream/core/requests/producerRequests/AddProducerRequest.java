package rateIceCream.core.requests.producerRequests;

public class AddProducerRequest {

    private String name;

    public AddProducerRequest(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
