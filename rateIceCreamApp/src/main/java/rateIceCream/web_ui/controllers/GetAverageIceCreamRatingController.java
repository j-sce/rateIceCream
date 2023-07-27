package rateIceCream.web_ui.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import rateIceCream.core.requests.ratingRequests.GetAverageIceCreamRatingRequest;
import rateIceCream.core.responses.ratingResponses.GetAverageIceCreamRatingResponse;
import rateIceCream.core.services.ratingServices.GetAverageIceCreamRatingService;

@Controller
public class GetAverageIceCreamRatingController {

    @Autowired
    GetAverageIceCreamRatingService getAverageIceCreamRatingService;

    @GetMapping(value = "/getAverageIceCreamRating")
    public String showSearchIceCreamPage(ModelMap modelMap) {
        modelMap.addAttribute("request", new GetAverageIceCreamRatingRequest());
        return "getAverageIceCreamRating";
    }

    @PostMapping(value = "/getAverageIceCreamRating")
    public String processSearchIceCreamRequest(@ModelAttribute(value = "request") GetAverageIceCreamRatingRequest request, ModelMap modelMap) {
        GetAverageIceCreamRatingResponse response = getAverageIceCreamRatingService.execute(request);

        if (response.hasErrors()) {
            modelMap.addAttribute("errors", response.getErrors());
        } else {
            modelMap.addAttribute("averageRating", response.getAverageRating());
        }
        return "getAverageIceCreamRating";
    }

}
