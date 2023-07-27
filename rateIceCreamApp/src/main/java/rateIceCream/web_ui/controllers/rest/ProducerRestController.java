package rateIceCream.web_ui.controllers.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rateIceCream.core.requests.producerRequests.AddProducerRequest;
import rateIceCream.core.responses.producerResponses.AddProducerResponse;
import rateIceCream.core.services.producerServices.AddProducerService;

@RestController
@RequestMapping("/producer")
public class ProducerRestController {

    @Autowired
    private AddProducerService addProducerService;

    @PostMapping(path = "/",
            consumes = "application/json",
            produces = "application/json")
    public AddProducerResponse addProducer(@RequestBody AddProducerRequest request) {
        return addProducerService.execute(request);
    }
}
