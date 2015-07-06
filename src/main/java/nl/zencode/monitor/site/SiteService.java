package nl.zencode.monitor.site;

import javax.annotation.ManagedBean;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.util.ArrayList;
import java.util.List;

/**
 * REST service for sites.
 * @author Koert Zeilstra
 */
@Path("/site")
@ManagedBean
public class SiteService {

    @GET
    @Path("/all")
    @Produces({"application/xml", "application/json"})
    public List<String> allSites() {
        List<String> sites = new ArrayList<String>();
        sites.add("www.google.com");
        return sites;
    }
}
