package nl.zencode.monitor.security;

import org.junit.Test;

import javax.security.auth.Subject;
import javax.security.auth.login.LoginContext;
import javax.security.auth.login.LoginException;
import java.net.URL;

/**
 * @author Koert Zeilstra
 * http://www.avajava.com/tutorials/lessons/how-do-i-create-a-login-module.html
 * https://docs.oracle.com/javase/1.5.0/docs/guide/security/jaas/JAASLMDevGuide.html
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
