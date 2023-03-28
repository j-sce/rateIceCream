package rateIceCream;

import rateIceCream.console_ui.*;
import rateIceCream.core.database.Database;
import rateIceCream.core.database.InMemoryDatabaseImpl;
import rateIceCream.core.services.*;
import rateIceCream.core.validators.AddIceCreamRequestValidator;
import rateIceCream.core.validators.RemoveIceCreamRequestValidator;
import rateIceCream.core.validators.SearchIceCreamRequestValidator;

import java.util.Scanner;

public class IceCreamDatabaseApplication {

    private static Database database = new InMemoryDatabaseImpl();
    private static AddIceCreamRequestValidator addIceCreamValidator = new AddIceCreamRequestValidator();
    private static AddIceCreamService addIceCreamService = new AddIceCreamService(database, addIceCreamValidator);
    private static RemoveIceCreamRequestValidator removeIceCreamValidator = new RemoveIceCreamRequestValidator();
    private static RemoveIceCreamService removeIceCreamService = new RemoveIceCreamService(database, removeIceCreamValidator);
    private static GetAllIceCreamsService getAllIceCreamsService = new GetAllIceCreamsService(database);
    private static SearchIceCreamRequestValidator searchIceCreamValidator = new SearchIceCreamRequestValidator();
    private static SearchIceCreamService searchIceCreamService = new SearchIceCreamService(database, searchIceCreamValidator);
    private static UIAction addIceCreamUIAction = new AddIceCreamUIAction(addIceCreamService);
    private static UIAction removeIceCreamUIAction = new RemoveIceCreamUIAction(removeIceCreamService);
    private static UIAction getAllIceCreamsUIAction = new GetAllIceCreamsUIAction(getAllIceCreamsService);
    private static UIAction searchIceCreamUIAction = new SearchIceCreamUIAction(searchIceCreamService);
    private static UIAction exitUIAction = new ExitUIAction();


    public static void main(String[] args) {

        while (true) {
            printAppMenu();
            int userChoice = getMenuNumberFromUser();
            executeSelectedMenuItem(userChoice);
        }
    }

    private static void printAppMenu() {
        System.out.println("Application menu:");
        System.out.println("1. Add ice cream to the list");
        System.out.println("2. Delete ice cream from the list");
        System.out.println("3. Show all ice creams in the list");
        System.out.println("4. Search ice creams in the list");
        System.out.println("5. Exit");
        System.out.println();
    }

    private static int getMenuNumberFromUser() {
        System.out.println("Enter menu item number to execute:");
        Scanner scanner = new Scanner(System.in);
        return Integer.parseInt(scanner.nextLine()); // TODO NumberFormatException
    }

    public static void executeSelectedMenuItem(int userChoice) {
        switch (userChoice) {
            case 1 -> {
                addIceCreamUIAction.execute();
            }
            case 2 -> {
                removeIceCreamUIAction.execute();
            }
            case 3 -> {
                getAllIceCreamsUIAction.execute();
            }
            case 4 -> {
                searchIceCreamUIAction.execute();
            }
            case 5 -> {
                exitUIAction.execute();
            }
        }
    }
}
