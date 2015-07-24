package nl.zencode.monitor.security;

import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import java.io.Serializable;

/**
 * @author Koert Zeilstra
 */
@RequiresLoggedInUser
@Interceptor
public class SecurityInterceptor implements Serializable {

    @Inject
    private AuthenticationContext authenticationContext;

    @AroundInvoke
    public Object logMethodEntry(InvocationContext invocationContext)
            throws Exception {
        System.out.println("Entering method: "
                + invocationContext.getMethod().getName() + " in class "
                + invocationContext.getMethod().getDeclaringClass().getName());

        System.out.println("security: " + authenticationContext.getUser());

        return invocationContext.proceed();
    }
}
