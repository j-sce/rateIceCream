package rateIceCream.console_ui;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

@Component
public class AppMenu {

    private Map<Integer, UIAction> menuNumberToUIActionMap;

    @Autowired
    public AppMenu(List<UIAction> uiActions) {
        menuNumberToUIActionMap = new HashMap<>();
        menuNumberToUIActionMap.put(1, findUIAction(uiActions, AddIceCreamUIAction.class));
        menuNumberToUIActionMap.put(2, findUIAction(uiActions, RemoveIceCreamUIAction.class));
        menuNumberToUIActionMap.put(3, findUIAction(uiActions, GetAllIceCreamsUIAction.class));
        menuNumberToUIActionMap.put(4, findUIAction(uiActions, SearchIceCreamUIAction.class));
        menuNumberToUIActionMap.put(5, findUIAction(uiActions, ExitUIAction.class));
    }

    private UIAction findUIAction(List<UIAction> uiActions, Class uiActionClass) {
        return uiActions.stream()
                .filter(uiAction -> uiAction.getClass().equals(uiActionClass))
                .findFirst()
                .get();
    }

    public void printAppMenu() {
        System.out.println("Application menu:");
        System.out.println("1. Add ice cream to the list");
        System.out.println("2. Delete ice cream from the list");
        System.out.println("3. Show all ice creams in the list");
        System.out.println("4. Search ice creams in the list");
        System.out.println("5. Exit");
        System.out.println();
    }

    public int getMenuNumberFromUser() {
        System.out.println("Enter menu item number to execute:");
        Scanner scanner = new Scanner(System.in);
        return Integer.parseInt(scanner.nextLine()); // TODO NumberFormatException
    }

    public void executeSelectedMenuItem(int userChoice){
        menuNumberToUIActionMap.get(userChoice).execute();
    }

}
