package nl.zencode.monitor.site;

import javax.annotation.ManagedBean;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.xml.bind.annotation.XmlRootElement;
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
    public List<Site> allSites() {
        List<Site> sites = new ArrayList<>();
        Site site = new Site();
        site.name = "Google";
        site.url = "http://www.google.com";
        sites.add(site);
        return sites;
    }

    @XmlRootElement(name = "site")
    public static class Site {
        public String name;
        public String url;
    }
}
