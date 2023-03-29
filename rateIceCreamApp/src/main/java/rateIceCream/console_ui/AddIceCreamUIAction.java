package rateIceCream.console_ui;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import rateIceCream.core.requests.AddIceCreamRequest;
import rateIceCream.core.responses.AddIceCreamResponse;
import rateIceCream.core.services.AddIceCreamService;

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
        String iceCreamBarcoder = scanner.nextLine();
        AddIceCreamRequest request = new AddIceCreamRequest(iceCreamName, iceCreamProducer, iceCreamBarcoder);
        AddIceCreamResponse response = addIceCreamService.execute(request);
        if (response.hasErrors()) {
            response.getErrors().forEach(coreError -> System.out.println("Error: " + coreError.getField() + " " + coreError.getMessage()));
        } else {
            System.out.println("Your ice cream was successfully added to the list.");
            System.out.println("New ice cream ID: " + response.getNewIceCream().getId());
        }
    }
}
