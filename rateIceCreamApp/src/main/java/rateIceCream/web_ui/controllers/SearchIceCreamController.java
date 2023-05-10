package rateIceCream.web_ui.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import rateIceCream.core.requests.iceCreamRequests.SearchIceCreamRequest;
import rateIceCream.core.responses.iceCreamResponses.SearchIceCreamResponse;
import rateIceCream.core.services.iceCreamServices.SearchIceCreamService;

@Controller
public class SearchIceCreamController {

    @Autowired
    private SearchIceCreamService searchIceCreamService;

    @GetMapping(value = "/searchIceCream")
    public String showSearchIceCreamPage(ModelMap modelMap) {
        modelMap.addAttribute("request", new SearchIceCreamRequest());
        return "searchIceCream";
    }

    @PostMapping(value = "/searchIceCream")
    public String processSearchIceCreamRequest(@ModelAttribute(value = "request") SearchIceCreamRequest request, ModelMap modelMap) {
        SearchIceCreamResponse response = searchIceCreamService.execute(request);

        if (response.hasErrors()) {
            modelMap.addAttribute("errors", response.getErrors());
        } else {
            modelMap.addAttribute("iceCreams", response.getIceCreams());
        }
        return "searchIceCream";
    }

}
