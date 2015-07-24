package nl.zencode.monitor.security;

import javax.interceptor.InterceptorBinding;
import java.lang.annotation.*;

/**
 * @author Koert Zeilstra
 */
@Inherited
@InterceptorBinding
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.TYPE})
public @interface RequiresLoggedInUser {
}