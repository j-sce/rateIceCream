package rateIceCream.core.responses.iceCreamResponses;

import rateIceCream.core.domain.IceCream;
import rateIceCream.core.CoreError;
import rateIceCream.core.CoreResponse;

import java.util.List;

public class AddIceCreamResponse extends CoreResponse {

    private IceCream newIceCream;

    public AddIceCreamResponse(List<CoreError> errors) {
        super(errors);
    }

    public AddIceCreamResponse(IceCream newIceCream) {
        this.newIceCream = newIceCream;
    }

    public IceCream getNewIceCream() {
        return newIceCream;
    }
}
