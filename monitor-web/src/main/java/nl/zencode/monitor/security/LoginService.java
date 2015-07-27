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
 * Service to authenticate user with functional style.
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
        Optional<AuthenticationToken> authentication = authenticationRepository.authenticateUser(userName, password);
        Response response = authentication.map(token -> Response.ok(createResource(token)).build())
                .orElse(Response.status(Response.Status.NOT_ACCEPTABLE).build());
        return response;
    }

    private AuthTokenResource createResource(AuthenticationToken token) {
        AuthTokenResource resource = new AuthTokenResource();
        resource.token = token.getId();
        resource.expiration = token.getExpiration();
        return resource;
    }

    @XmlRootElement(name = "site")
    public static class AuthTokenResource {
        public LocalDateTime expiration;
        public String token;
    }

}
