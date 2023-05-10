package rateIceCream.web_ui.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import rateIceCream.core.requests.iceCreamRequests.AddIceCreamRequest;
import rateIceCream.core.responses.iceCreamResponses.AddIceCreamResponse;
import rateIceCream.core.services.iceCreamServices.AddIceCreamService;

@Controller
public class AddIceCreamController {

    @Autowired
    private AddIceCreamService addIceCreamService;

    @GetMapping(value = "/addIceCream")
    public String showAddIceCreamPage(ModelMap modelMap) {
        modelMap.addAttribute("request", new AddIceCreamRequest());
        return "addIceCream";
    }

    @PostMapping("/addIceCream")
    public String processAddIceCreamRequest(@ModelAttribute(value = "request") AddIceCreamRequest request, ModelMap modelMap) {
        AddIceCreamResponse response = addIceCreamService.execute(request);

        if (response.hasErrors()) {
            modelMap.addAttribute("errors", response.getErrors());
            return "addIceCream";
        } else {
            return "redirect:/";
        }
    }

}
