package rateIceCream.web_ui.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import rateIceCream.core.requests.iceCreamRequests.RemoveIceCreamRequest;
import rateIceCream.core.responses.iceCreamResponses.RemoveIceCreamResponse;
import rateIceCream.core.services.iceCreamServices.RemoveIceCreamService;

@Controller
public class RemoveIceCreamController {

    @Autowired
    private RemoveIceCreamService removeIceCreamService;

    @GetMapping(value = "/removeIceCream")
    public String showRemoveIceCreamPage(ModelMap modelMap) {
        modelMap.addAttribute("request", new RemoveIceCreamRequest());
        return "removeIceCream";
    }

    @PostMapping("/removeIceCream")
    public String processRemoveIceCreamRequest(@ModelAttribute(value = "request") RemoveIceCreamRequest request, ModelMap modelMap) {
        RemoveIceCreamResponse response = removeIceCreamService.execute(request);

        if (response.hasErrors()) {
            modelMap.addAttribute("errors", response.getErrors());
            return "removeIceCream";
        } else {
            return "redirect:/";
        }
    }
}
