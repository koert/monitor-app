package nl.zencode.monitor.security;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import javax.ws.rs.core.Response;
import java.util.Optional;

/**
 * @author Koert Zeilstra
 * http://www.avajava.com/tutorials/lessons/how-do-i-create-a-login-module.html
 * https://docs.oracle.com/javase/1.5.0/docs/guide/security/jaas/JAASLMDevGuide.html
 * http://arjan-tijms.omnifaces.org/2014/02/jaas-in-java-ee-is-not-universal.html
 */
@RunWith(MockitoJUnitRunner.class)
public class LoginServiceTest {

    private static final String USER_NAME = "test";
    private static final String PASSWORD = "password";

    @InjectMocks private LoginService loginService;

    @Mock private AuthenticationRepository authenticationRepository;

    @Mock AuthenticationToken authenticationToken;

    @Test
    @Ignore
    public void loginWithIncorrectPassword() {

        Optional<AuthenticationToken> authentication = Optional.empty();
        Mockito.when(authenticationRepository.authenticateUser(USER_NAME, PASSWORD)).thenReturn(authentication);

        Response login = loginService.login(USER_NAME, PASSWORD);

    }

}
