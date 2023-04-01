package rateIceCream.core.responses.iceCreamResponses;

import rateIceCream.core.domain.IceCream;
import rateIceCream.core.CoreError;
import rateIceCream.core.CoreResponse;

import java.util.List;

public class SearchIceCreamResponse extends CoreResponse {

    private List<IceCream> iceCreams;

    public SearchIceCreamResponse(List<IceCream> iceCreams,List<CoreError> errors) {
        super(errors);
        this.iceCreams = iceCreams;
    }

    public List<IceCream> getIceCreams() {
        return iceCreams;
    }
}

