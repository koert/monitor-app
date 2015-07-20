package nl.zencode.monitor.security;

import javax.annotation.ManagedBean;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import javax.xml.bind.annotation.XmlRootElement;
import java.time.LocalDateTime;

/**
 * @author Koert Zeilstra
 */
@Path("/login")
@ManagedBean
public class LoginService {

    @Inject
    private AuthenticationRepository authenticationRepository;

    @POST
    @Consumes("application/x-www-form-urlencoded")
    public Response login(@FormParam("username") String userName, @FormParam("password") String password) {
        AuthenticationToken authenticationToken = authenticationRepository.createAuthenticationToken();
        AuthTokenResource resource = new AuthTokenResource();
        resource.token = authenticationToken.getId();
        resource.expiration = authenticationToken.getExpiration();
        return Response.ok(resource).build();

    }

    @XmlRootElement(name = "site")
    public static class AuthTokenResource {
        public LocalDateTime expiration;
        public String token;
    }

}
