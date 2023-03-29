package rateIceCream.console_ui;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import rateIceCream.core.requests.GetAllIceCreamsRequest;
import rateIceCream.core.responses.GetAllIceCreamsResponse;
import rateIceCream.core.services.GetAllIceCreamsService;

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
