package rateIceCream.console_ui;

import rateIceCream.core.requests.RemoveIceCreamRequest;
import rateIceCream.core.responses.RemoveIceCreamResponse;
import rateIceCream.core.services.RemoveIceCreamService;

import java.util.Scanner;

public class RemoveIceCreamUIAction implements UIAction {

    private RemoveIceCreamService removeIceCreamService;

    public RemoveIceCreamUIAction(RemoveIceCreamService removeIceCreamService) {
        this.removeIceCreamService = removeIceCreamService;
    }

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
