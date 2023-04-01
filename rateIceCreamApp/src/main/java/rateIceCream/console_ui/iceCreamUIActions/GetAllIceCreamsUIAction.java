package rateIceCream.console_ui.iceCreamUIActions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import rateIceCream.console_ui.UIAction;
import rateIceCream.core.requests.iceCreamRequests.GetAllIceCreamsRequest;
import rateIceCream.core.responses.iceCreamResponses.GetAllIceCreamsResponse;
import rateIceCream.core.services.iceCreamServices.GetAllIceCreamsService;

@Component
public class GetAllIceCreamsUIAction implements UIAction {

    @Autowired
    private GetAllIceCreamsService getAllIceCreamsService;

    @Override
    public void execute() {
        System.out.println("Ice cream list: ");
        GetAllIceCreamsRequest request = new GetAllIceCreamsRequest();
        GetAllIceCreamsResponse response = getAllIceCreamsService.execute(request);
        response.getIceCreams().forEach(System.out::println);
        System.out.println("-------- End of ice cream list. --------");
    }
}
