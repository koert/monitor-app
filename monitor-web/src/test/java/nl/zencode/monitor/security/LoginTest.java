package nl.zencode.monitor.security;

import org.junit.Test;

import javax.security.auth.Subject;
import javax.security.auth.login.LoginContext;
import javax.security.auth.login.LoginException;
import java.net.URL;

/**
 * @author Koert Zeilstra
 */
public class LoginTest {

    @Test
    public void test() {
        String jaasConfigFile = null;
        URL jaasConfigURL = this.getClass().getClassLoader().getResource("jaas.config");
        if(jaasConfigURL != null) {
            jaasConfigFile = jaasConfigURL.getFile();
        }
        System.setProperty("java.security.auth.login.config", jaasConfigFile);

        String name = "myName";
        String password = "myPassword";

        try {
            LoginContext lc = new LoginContext("Test", new AuthenticationCallbackHandler(name, password));
            lc.login();
            Subject subject = lc.getSubject();
            System.out.println("subject " + subject);
        } catch (LoginException e) {
            e.printStackTrace();
        }
    }

}
