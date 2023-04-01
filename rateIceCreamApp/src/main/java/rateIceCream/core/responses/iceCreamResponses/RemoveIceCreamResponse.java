package rateIceCream.core.responses.iceCreamResponses;

import rateIceCream.core.CoreError;
import rateIceCream.core.CoreResponse;

import java.util.List;

public class RemoveIceCreamResponse extends CoreResponse {

    private boolean iceCreamRemoved;

    public RemoveIceCreamResponse(List<CoreError> errors) {
        super(errors);
    }

    public RemoveIceCreamResponse(boolean iceCreamRemoved) {
        this.iceCreamRemoved = iceCreamRemoved;
    }

    public boolean isIceCreamRemoved() {
        return iceCreamRemoved;
    }
}
