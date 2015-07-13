package nl.zencode.monitor.site;

import javax.annotation.ManagedBean;
import javax.ejb.EJB;
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

    @EJB private SiteRepository siteRepository;

    @GET
    @Path("/all")
    @Produces({"application/xml", "application/json"})
    public List<SiteResource> allSites() {
        List<SiteResource> sites = new ArrayList<>();
        for (Site site : siteRepository.getAllSites()) {
            SiteResource resource = new SiteResource();
            resource.name = site.getName();
            resource.url = site.getUrl();
        }
        return sites;
    }

    @XmlRootElement(name = "site")
    public static class SiteResource {
        public String name;
        public String url;
    }
}
