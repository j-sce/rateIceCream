package rateIceCream.web_ui.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import rateIceCream.core.requests.iceCreamRequests.GetAllIceCreamsRequest;
import rateIceCream.core.responses.iceCreamResponses.GetAllIceCreamsResponse;
import rateIceCream.core.services.iceCreamServices.GetAllIceCreamsService;

@Controller
public class GetAllIceCreamsController {

    @Autowired
    private GetAllIceCreamsService getAllIceCreamsService;

    @GetMapping(value = "/getAllIceCreams")
    public String getAllIceCreams(ModelMap modelMap) {
        GetAllIceCreamsResponse response = getAllIceCreamsService.execute(new GetAllIceCreamsRequest());
        modelMap.addAttribute("iceCreams", response.getIceCreams());
        return "/getAllIceCreams";
    }

}
