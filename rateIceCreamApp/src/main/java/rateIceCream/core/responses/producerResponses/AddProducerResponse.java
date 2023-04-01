package rateIceCream.core.responses.producerResponses;

import rateIceCream.core.CoreError;
import rateIceCream.core.CoreResponse;
import rateIceCream.core.domain.Producer;

import java.util.List;

public class AddProducerResponse extends CoreResponse {

    private Producer newProducer;

    public AddProducerResponse(List<CoreError> errors) {
        super(errors);
    }

    public AddProducerResponse(Producer newProducer) {
        this.newProducer = newProducer;
    }

    public Producer getNewProducer() {
        return newProducer;
    }
}
