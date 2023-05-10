package rateIceCream;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import rateIceCream.console_ui.AppMenu;
import rateIceCream.web_ui.config.SpringWebConfiguration;


@SpringBootApplication(exclude = HibernateJpaAutoConfiguration.class)
public class WebRateIceCreamApplication {

    public static void main(String[] args) {

        ConfigurableApplicationContext context = SpringApplication.run(SpringWebConfiguration.class);

        AppMenu appMenu = context.getBean(AppMenu.class);
        while (true) {
            appMenu.printAppMenu();
            int userChoice = appMenu.getMenuNumberFromUser();
            appMenu.executeSelectedMenuItem(userChoice);
        }
    }
}
