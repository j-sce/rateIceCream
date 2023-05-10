package rateIceCream.core.requests.iceCreamRequests;

public class GetIceCreamRequest {

    private Long iceCreamId;

    public GetIceCreamRequest() {
    }

    public GetIceCreamRequest(Long iceCreamId) {
        this.iceCreamId = iceCreamId;
    }

    public Long getIceCreamId() {
        return iceCreamId;
    }

    public void setIceCreamId(Long iceCreamId) {
        this.iceCreamId = iceCreamId;
    }
}
