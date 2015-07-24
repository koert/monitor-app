package nl.zencode.monitor.security;

import javax.inject.Inject;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.http.HttpServletRequest;

/**
 * @author Koert Zeilstra
 */
public class AuthenticationRequestListener implements ServletRequestListener {

//    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Inject
    private AuthenticationRepository authenticationRepository;

    @Inject
    private AuthenticationContext authenticationContext;


    @Override
    public void requestInitialized(ServletRequestEvent event) {
//        log.debug("requestInitialized {}", event);
        System.out.println("requestInitialized {}" + event);

        HttpServletRequest request = (HttpServletRequest) event.getServletRequest();
        String authenticationTokenId = request.getHeader("x-authentication-token-id");
        if (authenticationTokenId != null) {
            AuthenticationToken token = authenticationRepository.getToken(authenticationTokenId);
            if (token != null) {
                authenticationContext.setUser(token.getUser());
            }
        }
    }

    @Override
    public void requestDestroyed(ServletRequestEvent event) {
        System.out.println("requestDestroyed {}" + event);
        authenticationContext.reset();
    }
}
