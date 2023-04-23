package rateIceCream.matchers;

import org.mockito.ArgumentMatcher;
import rateIceCream.core.domain.User;
import rateIceCream.core.domain.UserRole;

public class UserMatcher implements ArgumentMatcher<User> {

    private String login;
    private String password;
    private UserRole userRole;

    public UserMatcher(String login, String password, UserRole userRole) {
        this.login = login;
        this.password = password;
        this.userRole = userRole;
    }

    @Override
    public boolean matches(User user) {
        return user.getLogin().equals(login)
                && user.getPassword().equals(password)
                && user.getUserRole().equals(userRole);
    }
}
