package rateIceCream.console_ui;

import rateIceCream.database.Database;
import rateIceCream.services.GetAllIceCreamsService;

public class GetAllIceCreamsUIAction implements UIAction {

    private GetAllIceCreamsService getAllIceCreamsService;

    public GetAllIceCreamsUIAction(GetAllIceCreamsService getAllIceCreamsService) {
        this.getAllIceCreamsService = getAllIceCreamsService;
    }

    @Override
    public void execute() {
        System.out.println("Ice cream list: ");
        getAllIceCreamsService.execute().forEach(System.out::println);
        System.out.println("-------- End of ice cream list. --------");
    }
}
