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
import java.util.Optional;

/**
 * @author Koert Zeilstra
 */
@Path("/authentication")
@ManagedBean
public class LoginService {

    @Inject
    private AuthenticationRepository authenticationRepository;

    @Path("/login")
    @POST
    @Consumes("application/x-www-form-urlencoded")
    public Response login(@FormParam("username") String userName, @FormParam("password") String password) {
        Response response = null;
        Optional<AuthenticationToken> authentication = authenticationRepository.authenticateUser(userName, password);
        if (authentication.isPresent()) {
            AuthenticationToken authenticationToken = authenticationRepository.createAuthenticationToken(userName);
            AuthTokenResource resource = new AuthTokenResource();
            resource.token = authenticationToken.getId();
            resource.expiration = authenticationToken.getExpiration();
            response = Response.ok(resource).build();
        } else {
            response = Response.status(Response.Status.NOT_ACCEPTABLE).build();
        }

        return response;

    }

    @XmlRootElement(name = "site")
    public static class AuthTokenResource {
        public LocalDateTime expiration;
        public String token;
    }

}
