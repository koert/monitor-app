package nl.zencode.monitor.security;

import javax.enterprise.context.ApplicationScoped;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Repository for authentication.
 * @author Koert Zeilstra
 */
@ApplicationScoped
public class AuthenticationRepository {

//    private Map<String, AuthenticationToken> tokenCache = new HashMap<>();

    public void authenticateUser(String userName, String password) {
        System.out.println("authenticateUser " + userName);
    }

    public AuthenticationToken createAuthenticationToken() {
        UUID uuid = UUID.randomUUID();
        LocalDateTime date = LocalDateTime.now().plusHours(8);
        return new AuthenticationToken(uuid.toString(), date);
    }
}
