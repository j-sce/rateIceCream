package rateIceCream.console_ui.iceCreamUIActions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import rateIceCream.console_ui.UIAction;
import rateIceCream.core.requests.iceCreamRequests.AddIceCreamRequest;
import rateIceCream.core.responses.iceCreamResponses.AddIceCreamResponse;
import rateIceCream.core.services.iceCreamServices.AddIceCreamService;

import java.util.Scanner;

@Component
public class AddIceCreamUIAction implements UIAction {
    @Autowired
    private AddIceCreamService addIceCreamService;

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter ice cream name: ");
        String iceCreamName = scanner.nextLine();
        System.out.println("Enter ice cream producer: ");
        String iceCreamProducer = scanner.nextLine();
        System.out.println("Enter ice cream barcode: ");
        String iceCreamBarcode = scanner.nextLine();
        AddIceCreamRequest request = new AddIceCreamRequest(iceCreamName, iceCreamProducer, iceCreamBarcode);
        AddIceCreamResponse response = addIceCreamService.execute(request);
        if (response.hasErrors()) {
            response.getErrors().forEach(coreError -> System.out.println("Error: " + coreError.getField() + " " + coreError.getMessage()));
        } else {
            System.out.println("Your ice cream was successfully added to the list.");
            System.out.println("New ice cream ID: " + response.getNewIceCream().getId());
        }
    }
}
