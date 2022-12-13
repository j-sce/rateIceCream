import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class IceCreamDatabaseApplication {

    public static void main(String[] args) {
        List<IceCream> iceCreams = new ArrayList<>();

        while (true) {
            printAppMenu();
            int userChoice = getMenuNumberFromUser();
            executeSelectedMenuItem(iceCreams, userChoice);
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

    public static void executeSelectedMenuItem(List<IceCream> iceCreams, int userChoice) {
        switch (userChoice) {
            case 1 -> {
                addIceCreamAction(iceCreams);
                break;
            }
            case 2 -> {
                removeIceCreamAction(iceCreams);
                break;
            }
            case 3 -> {
                printAllIceCreamsAction(iceCreams);
                break;
            }
            case 4 -> {
                exitAppAction();
                break;
            }
        }
    }

    private static int getMenuNumberFromUser() {
        System.out.println("Enter menu item number to execute:");
        Scanner scanner = new Scanner(System.in);
        return Integer.parseInt(scanner.nextLine());
    }

    private static void addIceCreamAction(List<IceCream> iceCreams) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter ice cream name: ");
        String iceCreamName = scanner.nextLine();
        System.out.println("Enter ice cream producer: ");
        String iceCreamProducer = scanner.nextLine();
        System.out.println("Enter ice cream volume in ml: ");
        int iceCreamVolume = Integer.parseInt(scanner.nextLine());
        IceCream iceCream = new IceCream(iceCreamName, iceCreamProducer, iceCreamVolume);
        iceCreams.add(iceCream);
        System.out.println("Your ice cream was successfully added to the list.");
    }

    private static void removeIceCreamAction(List<IceCream> iceCreams) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter ice cream name: ");
        String iceCreamName = scanner.nextLine();
        System.out.println("Enter ice cream producer: ");
        String iceCreamProducer = scanner.nextLine();
        System.out.println("Enter ice cream volume in ml: ");
        int iceCreamVolume = Integer.parseInt(scanner.nextLine());
        iceCreams.remove(new IceCream(iceCreamName, iceCreamProducer, iceCreamVolume));
        System.out.println("Your ice cream was successfully removed from list.");
    }

    private static void printAllIceCreamsAction(List<IceCream> iceCreams) {
        System.out.println("Ice cream list: ");
        for (IceCream iceCream : iceCreams) {
            System.out.println(iceCream);
        }
        System.out.println("-------- End of ice cream list. --------");
    }

    private static void exitAppAction() {
        System.out.println("Good bye!");
        System.exit(0);
    }
}
