package rateIceCream.console_ui.ratingUIActions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import rateIceCream.console_ui.UIAction;
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

import java.util.Scanner;

@Component
public class AddIceCreamRatingUIAction implements UIAction {

    @Autowired
    private AddIceCreamRatingService addIceCreamRatingService;

    @Autowired
    private GetUserService getUserService;

    @Autowired
    private GetIceCreamService getIceCreamService;

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter User ID: ");
        Long userId = scanner.nextLong();
        System.out.println("Enter Ice Cream ID: ");
        Long iceCreamId = scanner.nextLong();
        System.out.println("Enter Rating > 0: ");
        Long rating = scanner.nextLong();

        GetUserRequest getUserRequest = new GetUserRequest(userId);
        GetUserResponse getUserResponse = getUserService.execute(getUserRequest);
        if (getUserResponse.hasErrors()) {
            getUserResponse.getErrors().forEach(coreError -> System.out.println("Error: " + coreError.getField() + " " + coreError.getMessage()));
        }
        User user = getUserResponse.getUser();

        GetIceCreamRequest getIceCreamRequest = new GetIceCreamRequest(iceCreamId);
        GetIceCreamResponse getIceCreamResponse = getIceCreamService.execute(getIceCreamRequest);
        if (getIceCreamResponse.hasErrors()) {
            getIceCreamResponse.getErrors().forEach(coreError -> System.out.println("Error: " + coreError.getField() + " " + coreError.getMessage()));
        }
        IceCream iceCream = getIceCreamResponse.getIceCream();

        AddIceCreamRatingRequest addIceCreamRatingRequest = new AddIceCreamRatingRequest(user, iceCream, rating);
        AddIceCreamRatingResponse addIceCreamRatingResponse = addIceCreamRatingService.execute(addIceCreamRatingRequest);
        if (addIceCreamRatingResponse.hasErrors()) {
            addIceCreamRatingResponse.getErrors().forEach(coreError -> System.out.println("Error: " + coreError.getField() + " " + coreError.getMessage()));
        } else {
            System.out.println("New ice cream rating was successfully added.");
            System.out.println("Rating ID: " + addIceCreamRatingResponse.getNewUserIceCreamRating().getId());
        }

    }

}
