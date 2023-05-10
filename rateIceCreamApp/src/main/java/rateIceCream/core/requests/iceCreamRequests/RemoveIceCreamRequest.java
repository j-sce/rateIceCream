package rateIceCream.core.requests.iceCreamRequests;

public class RemoveIceCreamRequest {

    private Long iceCreamIdToRemove;

    public RemoveIceCreamRequest() {
    }

    public RemoveIceCreamRequest(Long iceCreamIdToRemove) {
        this.iceCreamIdToRemove = iceCreamIdToRemove;
    }

    public Long getIceCreamIdToRemove() {
        return iceCreamIdToRemove;
    }

    public void setIceCreamIdToRemove(Long iceCreamIdToRemove) {
        this.iceCreamIdToRemove = iceCreamIdToRemove;
    }
}
