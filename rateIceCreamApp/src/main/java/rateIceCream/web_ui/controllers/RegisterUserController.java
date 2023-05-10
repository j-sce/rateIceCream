package rateIceCream.web_ui.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import rateIceCream.core.requests.userRequests.RegisterUserRequest;
import rateIceCream.core.responses.userResponses.RegisterUserResponse;
import rateIceCream.core.services.userServices.RegisterUserService;

@Controller
public class RegisterUserController {

    @Autowired
    private RegisterUserService registerUserService;

    @GetMapping(value = "/registerUser")
    public String showRegisterUserPage(ModelMap modelMap) {
        modelMap.addAttribute("request", new RegisterUserRequest());
        return "registerUser";
    }

    @PostMapping("/registerUser")
    public String processRegisterUserRequest(@ModelAttribute(value = "request") RegisterUserRequest request, ModelMap modelMap) {
        RegisterUserResponse response = registerUserService.execute(request);

        if (response.hasErrors()) {
            modelMap.addAttribute("errors", response.getErrors());
            return "registerUser";
        } else {
            return "redirect:/";
        }
    }

}
