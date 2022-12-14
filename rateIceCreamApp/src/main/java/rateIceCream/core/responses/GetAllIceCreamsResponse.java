package rateIceCream.core.responses;

import rateIceCream.IceCream;
import rateIceCream.core.CoreResponse;

import java.util.List;

public class GetAllIceCreamsResponse extends CoreResponse {

    private List<IceCream> iceCreams;

    public GetAllIceCreamsResponse(List<IceCream> iceCreams) {
        this.iceCreams = iceCreams;
    }

    public List<IceCream> getIceCreams() {
        return iceCreams;
    }
}
