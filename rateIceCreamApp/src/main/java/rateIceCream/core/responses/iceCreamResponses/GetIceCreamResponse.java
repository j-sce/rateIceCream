package rateIceCream.core.responses.iceCreamResponses;

import rateIceCream.core.CoreError;
import rateIceCream.core.CoreResponse;
import rateIceCream.core.domain.IceCream;

import java.util.List;

public class GetIceCreamResponse extends CoreResponse {

    private IceCream iceCream;

    public GetIceCreamResponse(List<CoreError> errors) {
        super(errors);
    }

    public GetIceCreamResponse(IceCream iceCream) {
        this.iceCream = iceCream;
    }

    public IceCream getIceCream() {
        return iceCream;
    }
}
