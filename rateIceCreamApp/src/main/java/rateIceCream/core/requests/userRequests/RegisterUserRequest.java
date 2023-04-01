package rateIceCream.core.requests.userRequests;

import rateIceCream.core.domain.UserRole;

public class RegisterUserRequest {

    private String login;
    private String password;

    private UserRole userRole;

    public RegisterUserRequest(String login, String password, UserRole userRole) {
        this.login = login;
        this.password = password;
        this.userRole = userRole;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public UserRole getUserRole() {
        return userRole;
    }
}
