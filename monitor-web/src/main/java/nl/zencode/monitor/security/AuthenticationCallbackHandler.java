package nl.zencode.monitor.security;

import javax.security.auth.callback.*;
import java.io.IOException;

/**
 * Callback for authentication.
 * @author Koert Zeilstra
 */
public class AuthenticationCallbackHandler implements CallbackHandler {
    private String name;
    private String password;

    /**
     * Constructor.
     * @param name User name.
     * @param password Password.
     */
    public AuthenticationCallbackHandler(String name, String password) {
        this.name = name;
        this.password = password;
    }

    @Override
    public void handle(Callback[] callbacks) throws IOException, UnsupportedCallbackException {
        for (int i = 0; i < callbacks.length; i++) {
            if (callbacks[i] instanceof NameCallback) {
                NameCallback nameCallback = (NameCallback) callbacks[i];
                nameCallback.setName(name);
            } else if (callbacks[i] instanceof PasswordCallback) {
                PasswordCallback passwordCallback = (PasswordCallback) callbacks[i];
                passwordCallback.setPassword(password.toCharArray());
            } else {
                throw new UnsupportedCallbackException(callbacks[i], "The submitted Callback is unsupported");
            }
        }
    }
}
