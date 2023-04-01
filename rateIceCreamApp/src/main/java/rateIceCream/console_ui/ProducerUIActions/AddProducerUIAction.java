package rateIceCream.console_ui.ProducerUIActions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import rateIceCream.console_ui.UIAction;
import rateIceCream.core.requests.producerRequests.AddProducerRequest;
import rateIceCream.core.responses.producerResponses.AddProducerResponse;
import rateIceCream.core.services.producerServices.AddProducerService;

import java.util.Scanner;

@Component
public class AddProducerUIAction implements UIAction {

    @Autowired
    AddProducerService addProducerService;

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter producer name: ");
        String producerName = scanner.nextLine();
        AddProducerRequest request = new AddProducerRequest(producerName);
        AddProducerResponse response = addProducerService.execute(request);
        if (response.hasErrors()) {
            response.getErrors().forEach(coreError -> System.out.println("Error: " + coreError.getField() + " " + coreError.getMessage()));
        } else {
            System.out.println("New producer was successfully added to the list.");
            System.out.println("NProducer ID: " + response.getNewProducer().getId());
        }
    }
}
