package nl.zencode.monitor.security;

import javax.security.auth.Subject;
import javax.security.auth.callback.*;
import javax.security.auth.login.FailedLoginException;
import javax.security.auth.login.LoginException;
import java.io.IOException;
import java.util.Map;

/**
 * Login module.
 * @author Koert Zeilstra
 */
public class LoginModule implements javax.security.auth.spi.LoginModule {

    private Subject subject;
    private CallbackHandler callbackHandler;
    private Map sharedState;
    private Map options;

    private boolean succeeded = false;

    public LoginModule() {
        System.out.println("Login Module - constructor called");
    }

    @Override
    public void initialize(Subject subject, CallbackHandler callbackHandler, Map<String, ?> sharedState,
                           Map<String, ?> options) {

        System.out.println("Login Module - initialize called");
        this.subject = subject;
        this.callbackHandler = callbackHandler;
        this.sharedState = sharedState;
        this.options = options;

        System.out.println("testOption value: " + (String) options.get("testOption"));

        succeeded = false;
    }

    @Override
    public boolean login() throws LoginException {
        System.out.println("Login Module - login called");
        if (callbackHandler == null) {
            throw new LoginException("Oops, callbackHandler is null");
        }

        Callback[] callbacks = new Callback[2];
        callbacks[0] = new NameCallback("name:");
        callbacks[1] = new PasswordCallback("password:", false);

        try {
            callbackHandler.handle(callbacks);
        } catch (IOException e) {
            throw new LoginException("Oops, IOException calling handle on callbackHandler");
        } catch (UnsupportedCallbackException e) {
            throw new LoginException("Oops, UnsupportedCallbackException calling handle on callbackHandler");
        }

        NameCallback nameCallback = (NameCallback) callbacks[0];
        PasswordCallback passwordCallback = (PasswordCallback) callbacks[1];

        String name = nameCallback.getName();
        String password = new String(passwordCallback.getPassword());

        if ("myName".equals(name) && "myPassword".equals(password)) {
            System.out.println("Success! You get to log in!");
            succeeded = true;
            return succeeded;
        } else {
            System.out.println("Failure! You don't get to log in");
            succeeded = false;
            throw new FailedLoginException("Sorry! No login for you.");
        }
    }

    @Override
    public boolean abort() throws LoginException {
        System.out.println("Login Module - abort called");
        return false;
    }

    @Override
    public boolean commit() throws LoginException {
        System.out.println("Login Module - commit called");
        return succeeded;
    }

    public boolean logout() throws LoginException {
        System.out.println("Login Module - logout called");
        return false;
    }

}