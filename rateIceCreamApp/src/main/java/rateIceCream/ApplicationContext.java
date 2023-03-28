package rateIceCream;

import rateIceCream.console_ui.*;
import rateIceCream.core.database.Database;
import rateIceCream.core.database.InMemoryDatabaseImpl;
import rateIceCream.core.services.AddIceCreamService;
import rateIceCream.core.services.GetAllIceCreamsService;
import rateIceCream.core.services.RemoveIceCreamService;
import rateIceCream.core.services.SearchIceCreamService;
import rateIceCream.core.validators.AddIceCreamRequestValidator;
import rateIceCream.core.validators.RemoveIceCreamRequestValidator;
import rateIceCream.core.validators.SearchIceCreamRequestValidator;

import java.util.HashMap;
import java.util.Map;

public class ApplicationContext {

    private Map<Class, Object> beans = new HashMap<>();

    public ApplicationContext() {
        beans.put(Database.class, new InMemoryDatabaseImpl());

        beans.put(AddIceCreamRequestValidator.class, new AddIceCreamRequestValidator());
        beans.put(RemoveIceCreamRequestValidator.class, new RemoveIceCreamRequestValidator());
        beans.put(SearchIceCreamRequestValidator.class, new SearchIceCreamRequestValidator());

        beans.put(AddIceCreamService.class, new AddIceCreamService(getBean(Database.class), getBean(AddIceCreamRequestValidator.class)));
        beans.put(GetAllIceCreamsService.class, new GetAllIceCreamsService(getBean(Database.class)));
        beans.put(RemoveIceCreamService.class, new RemoveIceCreamService(getBean(Database.class), getBean(RemoveIceCreamRequestValidator.class)));
        beans.put(SearchIceCreamService.class, new SearchIceCreamService(getBean(Database.class), getBean(SearchIceCreamRequestValidator.class)));

        beans.put(AddIceCreamUIAction.class, new AddIceCreamUIAction(getBean(AddIceCreamService.class)));
        beans.put(ExitUIAction.class, new ExitUIAction());
        beans.put(GetAllIceCreamsUIAction.class, new GetAllIceCreamsUIAction(getBean(GetAllIceCreamsService.class)));
        beans.put(RemoveIceCreamUIAction.class, new RemoveIceCreamUIAction(getBean(RemoveIceCreamService.class)));
        beans.put(SearchIceCreamUIAction.class, new SearchIceCreamUIAction(getBean(SearchIceCreamService.class)));
    }

    public <T extends Object> T getBean(Class c) {
        return (T) beans.get(c);
    }
}
