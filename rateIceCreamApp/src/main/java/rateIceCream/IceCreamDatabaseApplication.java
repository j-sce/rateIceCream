package rateIceCream;

import rateIceCream.console_ui.*;
import rateIceCream.database.Database;
import rateIceCream.database.InMemoryDatabaseImpl;
import rateIceCream.services.AddIceCreamService;
import rateIceCream.services.GetAllIceCreamsService;
import rateIceCream.services.RemoveIceCreamService;

import java.util.Scanner;

public class IceCreamDatabaseApplication {

    private static Database database = new InMemoryDatabaseImpl();
    private static AddIceCreamService addIceCreamService = new AddIceCreamService(database);
    private static RemoveIceCreamService removeIceCreamService = new RemoveIceCreamService(database);
    private static GetAllIceCreamsService getAllIceCreamsService = new GetAllIceCreamsService(database);
    private static UIAction addIceCreamUIAction = new AddIceCreamUIAction(addIceCreamService);
    private static UIAction removeIceCreamUIAction = new RemoveIceCreamUIAction(removeIceCreamService);
    private static UIAction getAllIceCreamsUIAction = new GetAllIceCreamsUIAction(getAllIceCreamsService);
    private static UIAction exitUIAction = new ExitUIAction();


    public static void main(String[] args) {
        Database database = new InMemoryDatabaseImpl();

        while (true) {
            printAppMenu();
            int userChoice = getMenuNumberFromUser();
            executeSelectedMenuItem(database, userChoice);
        }
    }

    private static void printAppMenu() {
        System.out.println("Application menu:");
        System.out.println("1. Add ice cream to the list");
        System.out.println("2. Delete ice cream from the list");
        System.out.println("3. Show all ice creams in the list");
        System.out.println("4. Exit");
        System.out.println();
    }

    private static int getMenuNumberFromUser() {
        System.out.println("Enter menu item number to execute:");
        Scanner scanner = new Scanner(System.in);
        return Integer.parseInt(scanner.nextLine());
    }

    public static void executeSelectedMenuItem(Database database, int userChoice) {
        switch (userChoice) {
            case 1 -> {
                addIceCreamUIAction.execute();
                break;
            }
            case 2 -> {
                removeIceCreamUIAction.execute();
                break;
            }
            case 3 -> {
                getAllIceCreamsUIAction.execute();
                break;
            }
            case 4 -> {
                exitUIAction.execute();
                break;
            }
        }
    }
}
