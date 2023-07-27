package rateIceCream.web_ui.controllers.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import rateIceCream.core.requests.ratingRequests.AddIceCreamRatingRequest;
import rateIceCream.core.requests.ratingRequests.GetAverageIceCreamRatingRequest;
import rateIceCream.core.responses.ratingResponses.AddIceCreamRatingResponse;
import rateIceCream.core.responses.ratingResponses.GetAverageIceCreamRatingResponse;
import rateIceCream.core.services.ratingServices.AddIceCreamRatingService;
import rateIceCream.core.services.ratingServices.GetAverageIceCreamRatingService;

@RestController
@RequestMapping("/rating")
public class RatingRestController {

    @Autowired
    private AddIceCreamRatingService addIceCreamRatingService;

    @Autowired
    private GetAverageIceCreamRatingService getAverageIceCreamRatingService;

    @PostMapping(path = "/",
            consumes = "application/json",
            produces = "application/json")
    public AddIceCreamRatingResponse addRating(@RequestBody AddIceCreamRatingRequest request) {
        return addIceCreamRatingService.execute(request);
    }

    @GetMapping(path = "/{id}",
            produces = "application/json")
    public GetAverageIceCreamRatingResponse getAverageIceCreamRating(@PathVariable Long id) {
        GetAverageIceCreamRatingRequest request = new GetAverageIceCreamRatingRequest(id);
        return getAverageIceCreamRatingService.execute(request);
    }

}
