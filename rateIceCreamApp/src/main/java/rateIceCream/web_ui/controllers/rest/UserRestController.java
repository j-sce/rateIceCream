package rateIceCream.web_ui.controllers.rest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import rateIceCream.core.requests.userRequests.GetUserRequest;
import rateIceCream.core.requests.userRequests.RegisterUserRequest;
import rateIceCream.core.responses.userResponses.GetUserResponse;
import rateIceCream.core.responses.userResponses.RegisterUserResponse;
import rateIceCream.core.services.userServices.GetUserService;
import rateIceCream.core.services.userServices.RegisterUserService;

@RestController
@RequestMapping("/user")
public class UserRestController {

    @Autowired
    private GetUserService getUserService;

    @Autowired
    private RegisterUserService registerUserService;

    @GetMapping(path = "/{id}", produces = "application/json")
    public GetUserResponse getUser(@PathVariable Long id) {
        GetUserRequest request = new GetUserRequest(id);
        return getUserService.execute(request);
    }

    @PostMapping(path = "/",
            consumes = "application/json",
            produces = "application/json")
    public RegisterUserResponse registerUser(@RequestBody RegisterUserRequest request) {
        return registerUserService.execute(request);
    }
}
