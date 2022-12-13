package rateIceCream.console_ui;

import rateIceCream.services.AddIceCreamService;

import java.util.Scanner;

public class AddIceCreamUIAction implements UIAction {
    private AddIceCreamService addIceCreamService;

    public AddIceCreamUIAction(AddIceCreamService addIceCreamService) {
        this.addIceCreamService = addIceCreamService;
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter ice cream name: ");
        String iceCreamName = scanner.nextLine();
        System.out.println("Enter ice cream producer: ");
        String iceCreamProducer = scanner.nextLine();
        System.out.println("Enter ice cream volume in ml: ");
        long iceCreamVolume = Long.parseLong(scanner.nextLine());
        addIceCreamService.execute(iceCreamName, iceCreamProducer, iceCreamVolume);
        System.out.println("Your ice cream was successfully added to the list.");
    }
}
