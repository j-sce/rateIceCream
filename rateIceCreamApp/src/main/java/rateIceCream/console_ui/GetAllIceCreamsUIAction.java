package rateIceCream.console_ui;

import rateIceCream.core.requests.GetAllIceCreamsRequest;
import rateIceCream.core.responses.GetAllIceCreamsResponse;
import rateIceCream.core.services.GetAllIceCreamsService;

public class GetAllIceCreamsUIAction implements UIAction {

    private GetAllIceCreamsService getAllIceCreamsService;

    public GetAllIceCreamsUIAction(GetAllIceCreamsService getAllIceCreamsService) {
        this.getAllIceCreamsService = getAllIceCreamsService;
    }

    @Override
    public void execute() {
        System.out.println("Ice cream list: ");
        GetAllIceCreamsRequest request = new GetAllIceCreamsRequest();
        GetAllIceCreamsResponse response = getAllIceCreamsService.execute(request);
        response.getIceCreams().forEach(System.out::println);
        System.out.println("-------- End of ice cream list. --------");
    }
}
