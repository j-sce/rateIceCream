package rateIceCream.console_ui.iceCreamUIActions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import rateIceCream.console_ui.UIAction;
import rateIceCream.core.domain.IceCream;
import rateIceCream.core.requests.Ordering;
import rateIceCream.core.requests.Paging;
import rateIceCream.core.requests.iceCreamRequests.SearchIceCreamRequest;
import rateIceCream.core.responses.iceCreamResponses.SearchIceCreamResponse;
import rateIceCream.core.services.iceCreamServices.SearchIceCreamService;

import java.util.Scanner;

@Component
public class SearchIceCreamUIAction implements UIAction {

    @Autowired
    private SearchIceCreamService searchIceCreamService;

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter ice cream name:");
        String name = scanner.nextLine();
        System.out.println("Enter ice cream producer");
        String producer = scanner.nextLine();
        System.out.println("Enter ice cream barcode");
        String barcode = scanner.nextLine();

        System.out.println("Do you wish to add ordering and paging? O|P|OP|N (Ordering|Paging|Ordering and Paging|None):");
        String orderChoice = scanner.nextLine();
        SearchIceCreamResponse response;
        if (orderChoice.equals("O")) {
            System.out.println("Enter orderBy (name||producer):");
            String orderBy = scanner.nextLine();
            System.out.println("Enter orderDirection (ASC||DESC):");
            String orderDirection = scanner.nextLine();
            Ordering ordering = new Ordering(orderBy, orderDirection);
            SearchIceCreamRequest request = new SearchIceCreamRequest(name, producer, barcode, ordering);
            response = searchIceCreamService.execute(request);
        } else if (orderChoice.equals("P")) {
            System.out.println("Enter page number:");
            Integer pageNumber = Integer.parseInt(scanner.nextLine());
            System.out.println("Enter pageSize:");
            Integer pageSize = Integer.parseInt(scanner.nextLine());
            Paging paging = new Paging(pageNumber, pageSize);
            SearchIceCreamRequest request = new SearchIceCreamRequest(name, producer, barcode, paging);
            response = searchIceCreamService.execute(request);
        } else if (orderChoice.equals("OP")) {
            System.out.println("Enter orderBy (name||producer):");
            String orderBy = scanner.nextLine();
            System.out.println("Enter orderDirection (ASC||DESC):");
            String orderDirection = scanner.nextLine();
            Ordering ordering = new Ordering(orderBy, orderDirection);
            System.out.println("Enter page number:");
            Integer pageNumber = Integer.parseInt(scanner.nextLine());
            System.out.println("Enter pageSize:");
            Integer pageSize = Integer.parseInt(scanner.nextLine());
            Paging paging = new Paging(pageNumber, pageSize);
            SearchIceCreamRequest request = new SearchIceCreamRequest(name, producer, barcode, ordering, paging);
            response = searchIceCreamService.execute(request);
        } else {
            SearchIceCreamRequest request = new SearchIceCreamRequest(name, producer, barcode);
            response = searchIceCreamService.execute(request);
        }

        if (response.hasErrors()) {
            response.getErrors().forEach(coreError -> System.out.println("Error: " + coreError.getField() + " " + coreError.getMessage()));
        } else {
            response.getIceCreams().forEach(IceCream::toString);
            System.out.println("Search results: ");
            response.getIceCreams().forEach(System.out::println);
            System.out.println("-------- End of ice cream list. --------");
        }
    }
}
