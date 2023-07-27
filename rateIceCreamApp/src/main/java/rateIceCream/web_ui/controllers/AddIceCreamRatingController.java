package rateIceCream.web_ui.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import rateIceCream.core.domain.IceCream;
import rateIceCream.core.domain.User;
import rateIceCream.core.requests.iceCreamRequests.GetIceCreamRequest;
import rateIceCream.core.requests.ratingRequests.AddIceCreamRatingRequest;
import rateIceCream.core.requests.userRequests.GetUserRequest;
import rateIceCream.core.responses.iceCreamResponses.GetIceCreamResponse;
import rateIceCream.core.responses.ratingResponses.AddIceCreamRatingResponse;
import rateIceCream.core.responses.userResponses.GetUserResponse;
import rateIceCream.core.services.iceCreamServices.GetIceCreamService;
import rateIceCream.core.services.ratingServices.AddIceCreamRatingService;
import rateIceCream.core.services.userServices.GetUserService;

@Controller
public class AddIceCreamRatingController {

    @Autowired
    private AddIceCreamRatingService addIceCreamRatingService;

    @Autowired
    private GetUserService getUserService;

    @Autowired
    private GetIceCreamService getIceCreamService;

    @GetMapping(value = "/addIceCreamRating")
    public String showAddIceCreamRatingPage(ModelMap modelMap) {
        modelMap.addAttribute("getUserRequest", new GetUserRequest());
        modelMap.addAttribute("getIceCreamRequest", new GetIceCreamRequest());
        modelMap.addAttribute("addIceCreamRatingRequest", new AddIceCreamRatingRequest());
        return "addIceCreamRating";
    }

    @PostMapping("/addIceCreamRating")
    public String processAddIceCreamRatingRequest(@ModelAttribute(value = "getUserRequest") GetUserRequest getUserRequest,
                                                  @ModelAttribute(value = "getIceCreamRequest") GetIceCreamRequest getIceCreamRequest,
                                                  @ModelAttribute(value = "addIceCreamRatingRequest") AddIceCreamRatingRequest addIceCreamRatingRequest,
                                                  ModelMap modelMap) {
        GetUserResponse getUserResponse = getUserService.execute(getUserRequest);
        if (getUserResponse.hasErrors()) {
            modelMap.addAttribute("errors", getUserResponse.getErrors());
            return "addIceCreamRating";
        }
        User user = getUserResponse.getUser();

        GetIceCreamResponse getIceCreamResponse = getIceCreamService.execute(getIceCreamRequest);
        if (getIceCreamResponse.hasErrors()) {
            modelMap.addAttribute("errors", getIceCreamResponse.getErrors());
            return "addIceCreamRating";
        }
        IceCream iceCream = getIceCreamResponse.getIceCream();

        addIceCreamRatingRequest.setUser(user);
        addIceCreamRatingRequest.setIceCream(iceCream);

        AddIceCreamRatingResponse addIceCreamRatingResponse = addIceCreamRatingService.execute(addIceCreamRatingRequest);
        if (addIceCreamRatingResponse.hasErrors()) {
            modelMap.addAttribute("errors", addIceCreamRatingResponse.getErrors());
            return "addIceCreamRating";
        } else {
            return "redirect:/";
        }
    }
}
