package nl.zencode.monitor.security;

import java.time.LocalDateTime;

/**
 * @author Koert Zeilstra
 */
public class AuthenticationToken {
    private String id;
    private LocalDateTime expiration;
    private User user;

    public AuthenticationToken(String id, LocalDateTime expiration, User user) {
        this.id = id;
        this.expiration = expiration;
        this.user = user;
    }

    public String getId() {
        return id;
    }

    public LocalDateTime getExpiration() {
        return expiration;
    }

    public User getUser() {
        return user;
    }
}
