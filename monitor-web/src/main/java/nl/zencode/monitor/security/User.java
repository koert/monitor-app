package nl.zencode.monitor.security;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Koert Zeilstra
 */
public class User {
    private String userName;
    private String name;

    private Set<String> roles = new HashSet<>();

    public User(String userName, String name, Set<String> roles) {
        this.userName = userName;
        this.name = name;
        this.roles = roles;
    }

    public String getUserName() {
        return userName;
    }

    public String getName() {
        return name;
    }

    public Set<String> getRoles() {
        return roles;
    }
}
