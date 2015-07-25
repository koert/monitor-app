package nl.zencode.monitor.security;

import javax.enterprise.context.ApplicationScoped;
import java.time.LocalDateTime;
import java.util.*;

/**
 * Repository for authentication.
 * @author Koert Zeilstra
 */
@ApplicationScoped
public class AuthenticationRepository {

    private Map<String, AuthenticationToken> tokenCache = new HashMap<>();

    public Optional<AuthenticationToken> authenticateUser(String userName, String password) {
        Optional<AuthenticationToken> result = Optional.empty();
        System.out.println("authenticateUser " + userName);
        if ("test".equals(userName) && "welcome".equals(password)) {
            AuthenticationToken token = createAuthenticationToken(userName);
            result = Optional.of(token);
        }
        return result;
    }

    /** Token ID.
     * @param tokenId
     * @return Authentication token, may be null.
     */
    public AuthenticationToken getToken(String tokenId) {
        AuthenticationToken token = tokenCache.get(tokenId);
        return token;
    }

    /**
     * @param userName User name.
     * @return New authentication token.
     */
    public AuthenticationToken createAuthenticationToken(String userName) {
        UUID uuid = UUID.randomUUID();
        LocalDateTime date = LocalDateTime.now().plusHours(8);
        Set<String> roles = new HashSet<>();
        User user = new User(userName, "Test", roles);
        AuthenticationToken token = new AuthenticationToken(uuid.toString(), date, user);
        tokenCache.put(token.getId(), token);
        return token;
    }
}
