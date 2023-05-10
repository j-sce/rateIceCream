package rateIceCream.core.requests.userRequests;

public class GetUserRequest {

    private Long userId;

    public GetUserRequest() {
    }

    public GetUserRequest(Long userId) {
        this.userId = userId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
