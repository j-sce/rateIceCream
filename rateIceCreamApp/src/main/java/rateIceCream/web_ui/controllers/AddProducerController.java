package rateIceCream.web_ui.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import rateIceCream.core.requests.producerRequests.AddProducerRequest;
import rateIceCream.core.responses.producerResponses.AddProducerResponse;
import rateIceCream.core.services.producerServices.AddProducerService;

@Controller
public class AddProducerController {

    @Autowired
    private AddProducerService addProducerService;

    @GetMapping(value = "/addProducer")
    public String showAddProducerPage(ModelMap modelMap) {
        modelMap.addAttribute("request", new AddProducerRequest());
        return "addProducer";
    }

    @PostMapping("/addProducer")
    public String processAddProducerRequest(@ModelAttribute(value = "request") AddProducerRequest request, ModelMap modelMap) {
        AddProducerResponse response = addProducerService.execute(request);

        if (response.hasErrors()) {
            modelMap.addAttribute("errors", response.getErrors());
            return "addProducer";
        } else {
            return "redirect:/";
        }
    }
}
