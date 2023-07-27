package rateIceCream.core.requests.ratingRequests;

public class GetAverageIceCreamRatingRequest {

    private Long iceCreamId;

    public GetAverageIceCreamRatingRequest() {
    }

    public GetAverageIceCreamRatingRequest(Long iceCreamId) {
        this.iceCreamId = iceCreamId;
    }

    public Long getIceCreamId() {
        return iceCreamId;
    }

    public void setIceCreamId(Long iceCreamId) {
        this.iceCreamId = iceCreamId;
    }
}
