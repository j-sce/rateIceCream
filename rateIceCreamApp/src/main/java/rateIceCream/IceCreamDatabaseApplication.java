package rateIceCream;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import rateIceCream.config.IceCreamListConfiguration;
import rateIceCream.console_ui.*;

import java.util.Scanner;

public class IceCreamDatabaseApplication {

    private static ApplicationContext applicationContext = new AnnotationConfigApplicationContext(IceCreamListConfiguration.class);

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
            case 1: {
                AddIceCreamUIAction addIceCreamUIAction = applicationContext.getBean(AddIceCreamUIAction.class);
                addIceCreamUIAction.execute();
                break;
            }
            case 2: {
                RemoveIceCreamUIAction removeIceCreamUIAction = applicationContext.getBean(RemoveIceCreamUIAction.class);
                removeIceCreamUIAction.execute();
                break;
            }
            case 3: {
                GetAllIceCreamsUIAction getAllIceCreamsUIAction = applicationContext.getBean(GetAllIceCreamsUIAction.class);
                getAllIceCreamsUIAction.execute();
                break;
            }
            case 4: {
                SearchIceCreamUIAction searchIceCreamUIAction = applicationContext.getBean(SearchIceCreamUIAction.class);
                searchIceCreamUIAction.execute();
                break;
            }
            case 5: {
                ExitUIAction exitUIAction = applicationContext.getBean(ExitUIAction.class);
                exitUIAction.execute();
                break;
            }
        }
    }
}
