package rateIceCream.matchers;

import org.mockito.ArgumentMatcher;
import rateIceCream.core.domain.User;

public class UserMatcher implements ArgumentMatcher<User> {

    private String login;
    private String password;


    public UserMatcher(String login, String password) {
        this.login = login;
        this.password = password;
    }

    @Override
    public boolean matches(User user) {
        return user.getUsername().equals(login)
                && user.getPassword().equals(password);
    }
}
