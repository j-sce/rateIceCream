package rateIceCream;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import rateIceCream.config.IceCreamListConfiguration;
import rateIceCream.console_ui.*;


public class IceCreamDatabaseApplication {

    public static void main(String[] args) {
        ApplicationContext applicationContext = createApplicationContext();
        AppMenu appMenu = applicationContext.getBean(AppMenu.class);
        while (true) {
            appMenu.printAppMenu();
            int userChoice = appMenu.getMenuNumberFromUser();
            appMenu.executeSelectedMenuItem(userChoice);
        }
    }

    private static ApplicationContext createApplicationContext() {
        return new AnnotationConfigApplicationContext(IceCreamListConfiguration.class);
    }
}
