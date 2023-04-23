package rateIceCream.console_ui.userUIActions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import rateIceCream.console_ui.UIAction;
import rateIceCream.core.domain.UserRole;
import rateIceCream.core.requests.userRequests.RegisterUserRequest;
import rateIceCream.core.responses.userResponses.RegisterUserResponse;
import rateIceCream.core.services.userServices.RegisterUserService;

import java.util.Scanner;

@Component
public class RegisterUserUIAction implements UIAction {

    @Autowired
    RegisterUserService registerUserService;

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter login: ");
        String userLogin = scanner.nextLine();
        System.out.println("Enter password: ");
        String userPassword = scanner.nextLine();
        System.out.println("Enter user role (ADMIN|USER): ");
        String userRole = scanner.nextLine();

        RegisterUserRequest request;
        if (userRole.equals("ADMIN")) {
            request = new RegisterUserRequest(userLogin, userPassword, UserRole.ADMIN);
        } else {
            request = new RegisterUserRequest(userLogin, userPassword, UserRole.USER);
        }

        RegisterUserResponse response = registerUserService.execute(request);
        if (response.hasErrors()) {
            response.getErrors().forEach(coreError -> System.out.println("Error: " + coreError.getField() + " " + coreError.getMessage()));
        } else {
            System.out.println("New user was successfully added to the list.");
            System.out.println("User ID: " + response.getNewUser().getId());
        }
    }
}

