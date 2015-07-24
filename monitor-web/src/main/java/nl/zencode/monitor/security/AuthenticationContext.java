package nl.zencode.monitor.security;

import javax.enterprise.context.RequestScoped;
import javax.security.auth.Subject;

/**
 * Context for authentication.
 * @author Koert Zeilstra
 */
@RequestScoped
public class AuthenticationContext {

    private static final ThreadLocal<Subject> SUBJECT = new ThreadLocal<Subject>();

//    private Subject subject;
//    private String name;
    private User user;

//    public void setSubject(Subject subject) {
//        this.subject = subject;
//    }
//
//    public void setName(String name) {
//        LoginContext context = new LoginContext()
//        this.name = name;
//    }
//
//    public String getName() {
//        return name;
//    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void reset() {
//        subject = null;
//        name = null;
        user = null;
    }

}
