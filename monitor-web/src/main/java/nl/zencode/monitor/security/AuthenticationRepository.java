package nl.zencode.monitor.security;

import javax.enterprise.context.ApplicationScoped;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * Repository for authentication.
 * @author Koert Zeilstra
 */
@ApplicationScoped
public class AuthenticationRepository {

    private Map<String, AuthenticationToken> tokenCache = new HashMap<>();

    public void authenticateUser(String userName, String password) {
        System.out.println("authenticateUser " + userName);
    }

    public AuthenticationToken getToken(String tokenId) {
        AuthenticationToken token = tokenCache.get(tokenId);
        return token;
    }

    public AuthenticationToken createAuthenticationToken(String userName) {
        UUID uuid = UUID.randomUUID();
        LocalDateTime date = LocalDateTime.now().plusHours(8);
        AuthenticationToken token = new AuthenticationToken(uuid.toString(), date);
        tokenCache.put(token.getId(), token);
        return token;
    }
}
