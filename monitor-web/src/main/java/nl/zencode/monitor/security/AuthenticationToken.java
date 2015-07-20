package nl.zencode.monitor.security;

import java.time.LocalDateTime;

/**
 * @author Koert Zeilstra
 */
public class AuthenticationToken {
    private String id;
    private LocalDateTime expiration;

    public AuthenticationToken(String id, LocalDateTime expiration) {
        this.id = id;
        this.expiration = expiration;
    }

    public String getId() {
        return id;
    }

    public LocalDateTime getExpiration() {
        return expiration;
    }
}
