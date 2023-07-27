package rateIceCream.web_ui.controllers.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import rateIceCream.core.requests.iceCreamRequests.*;
import rateIceCream.core.responses.iceCreamResponses.*;
import rateIceCream.core.services.iceCreamServices.*;

@RestController
@RequestMapping("/iceCream")
public class IceCreamRestController {

    @Autowired
    private GetIceCreamService getIceCreamService;

    @Autowired
    private AddIceCreamService addIceCreamService;

    @Autowired
    private RemoveIceCreamService removeIceCreamService;

    @Autowired
    private GetAllIceCreamsService getAllIceCreamsService;

    @Autowired
    private SearchIceCreamService searchIceCreamService;

    @GetMapping(path = "/{id}", produces = "application/json")
    public GetIceCreamResponse getIceCream(@PathVariable Long id) {
        GetIceCreamRequest request = new GetIceCreamRequest(id);
        return getIceCreamService.execute(request);
    }

    @PostMapping(path = "/",
            consumes = "application/json",
            produces = "application/json")
    public AddIceCreamResponse addIceCream(@RequestBody AddIceCreamRequest request) {
        return addIceCreamService.execute(request);
    }

    @DeleteMapping(path = "/{id}", produces = "application/json")
    public RemoveIceCreamResponse removeIceCream(@PathVariable Long id) {
        RemoveIceCreamRequest request = new RemoveIceCreamRequest(id);
        return removeIceCreamService.execute(request);
    }

    @GetMapping(path = "/allIceCreams", produces = "application/json")
    public GetAllIceCreamsResponse getAllIceCreams() {
        GetAllIceCreamsRequest request = new GetAllIceCreamsRequest();
        return getAllIceCreamsService.execute(request);
    }

    @GetMapping(path = "/searchIceCream",
            consumes = "application/json",
            produces = "application/json")
    public SearchIceCreamResponse searchIceCream(@RequestBody SearchIceCreamRequest request) {
        return searchIceCreamService.execute(request);
    }
}
