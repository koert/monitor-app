package nl.zencode.monitor.security;

import java.time.LocalDateTime;

/**
 * @author Koert Zeilstra
 */
public class AuthenticationToken {
    private String id;
    private LocalDateTime expiration;
    private String userName;

    public AuthenticationToken(String id, LocalDateTime expiration, String userName) {
        this.id = id;
        this.expiration = expiration;
        this.userName = userName;
    }

    public String getId() {
        return id;
    }

    public LocalDateTime getExpiration() {
        return expiration;
    }

    public String getUserName() {
        return userName;
    }
}
