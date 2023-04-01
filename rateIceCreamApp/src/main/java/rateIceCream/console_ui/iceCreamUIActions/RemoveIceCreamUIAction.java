package rateIceCream.console_ui.iceCreamUIActions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import rateIceCream.console_ui.UIAction;
import rateIceCream.core.requests.iceCreamRequests.RemoveIceCreamRequest;
import rateIceCream.core.responses.iceCreamResponses.RemoveIceCreamResponse;
import rateIceCream.core.services.iceCreamServices.RemoveIceCreamService;

import java.util.Scanner;

@Component
public class RemoveIceCreamUIAction implements UIAction {

    @Autowired
    private RemoveIceCreamService removeIceCreamService;

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter ice cream ID to remove: ");
        Long iceCreamId = Long.parseLong(scanner.nextLine());//TODO NumberFormatException, NullPointerException
        RemoveIceCreamRequest request = new RemoveIceCreamRequest(iceCreamId);
        RemoveIceCreamResponse response = removeIceCreamService.execute(request);

        if (response.hasErrors()) {
            response.getErrors().forEach(coreError -> System.out.println("Error: " + coreError.getField() + " " + coreError.getMessage()));
        } else {
            if (response.isIceCreamRemoved()) {
                System.out.println("Ice Cream successfully removed from the list.");
            } else {
                System.out.println("Ice Cream successfully removed from the list.");
            }
        }
    }
}
