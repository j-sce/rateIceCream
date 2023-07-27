package rateIceCream.console_ui.ratingUIActions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import rateIceCream.console_ui.UIAction;
import rateIceCream.core.requests.ratingRequests.GetAverageIceCreamRatingRequest;
import rateIceCream.core.responses.ratingResponses.GetAverageIceCreamRatingResponse;
import rateIceCream.core.services.ratingServices.GetAverageIceCreamRatingService;

import java.util.Scanner;

@Component
public class GetAverageIceCreamRatingUIAction implements UIAction {

    @Autowired
    private GetAverageIceCreamRatingService getAverageIceCreamRatingService;

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter ice cream ID: ");
        Long iceCreamId= scanner.nextLong();
        GetAverageIceCreamRatingRequest request = new GetAverageIceCreamRatingRequest(iceCreamId);
        GetAverageIceCreamRatingResponse response = getAverageIceCreamRatingService.execute(request);

        if (response.hasErrors()) {
            response.getErrors().forEach(coreError -> System.out.println("Error: " + coreError.getField() + " " + coreError.getMessage()));
        } else {

            System.out.println("Average Rating: " + response.getAverageRating());
        }
    }
}
