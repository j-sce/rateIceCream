package rateIceCream.core.domain;

import java.io.Serializable;

public enum UserRole implements Serializable {

    ADMIN("Administrator"),
    USER("User");

    private String role;

    UserRole(String role) {
        this.role = role;
    }
}
