package nl.zencode.monitor.security;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Optional;

/**
 * @author Koert Zeilstra
 */
@RunWith(MockitoJUnitRunner.class)
public class AuthenticationRepositoryTest {

    private static final String USER_NAME = "test";
    private static final String PASSWORD_INCORRECT = "password";
    private static final String PASSWORD = "welcome";

    @InjectMocks private AuthenticationRepository authenticationRepository;

//    @Mock AuthenticationToken authenticationToken;

    @Test
    public void authenticateUserIncorrect() {

        Optional<AuthenticationToken> authentication = authenticationRepository.authenticateUser(USER_NAME,
                PASSWORD_INCORRECT);
        String result = authentication.map(token -> "correct").orElse("incorrect");
        System.out.println("result: " + result);
    }

}
