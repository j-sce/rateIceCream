package rateIceCream.console_ui;

import rateIceCream.services.RemoveIceCreamService;

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
        Long iceCreamId = Long.parseLong(scanner.nextLine());
        removeIceCreamService.execute(iceCreamId);
        System.out.println("Your ice cream was successfully removed from list.");
    }
}
