import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RateIceCreamApplication {

    public static void main(String[] args) {
        List<IceCream> iceCreams = new ArrayList<>();


        while (true) {
            System.out.println("Application menu:");
            System.out.println("1. Add ice cream to the list");
            System.out.println("2. Delete ice cream from the list");
            System.out.println("3. Show all ice creams in the list");
            System.out.println("4. Exit");

            System.out.println();

            System.out.println("Enter menu item number to execute:");
            Scanner scanner = new Scanner(System.in);
            int userChoice = Integer.parseInt(scanner.nextLine());

            switch (userChoice) {
                case 1 -> {
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
                case 2 -> {
                    System.out.println("Enter ice cream name: ");
                    String iceCreamName = scanner.nextLine();
                    System.out.println("Enter ice cream producer: ");
                    String iceCreamProducer = scanner.nextLine();
                    System.out.println("Enter ice cream volume in ml: ");
                    int iceCreamVolume = Integer.parseInt(scanner.nextLine());
                    iceCreams.remove(new IceCream(iceCreamName, iceCreamProducer, iceCreamVolume));
                    System.out.println("Your ice cream was successfully removed from list.");
                }
                case 3 -> {
                    System.out.println("Ice cream list: ");
                    for (IceCream iceCream : iceCreams) {
                        System.out.println(iceCream);
                    }
                    System.out.println("-------- End of ice cream list. --------");
                }
                case 4 -> {
                    System.out.println("Good bye!");
                    System.exit(0);
                }
            }
            System.out.println();
        }
    }

}
