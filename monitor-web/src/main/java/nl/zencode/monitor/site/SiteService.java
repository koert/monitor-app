package nl.zencode.monitor.site;

import javax.annotation.ManagedBean;
import javax.ejb.EJB;
import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
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
            sites.add(resource);
        }
        return sites;
    }

    @GET
    @Path("/all2")
    @Produces({"application/xml", "application/json"})
    public Response allSites2() {
        JsonArrayBuilder siteArrayBuilder = Json.createArrayBuilder();
        List<SiteResource> sites = new ArrayList<>();
        for (Site site : siteRepository.getAllSites()) {
            siteArrayBuilder.add(Json.createObjectBuilder()
                .add("name", site.getName())
                .add("url", site.getUrl()));
        }
        return Response.ok(siteArrayBuilder.build()).build();
    }

    @GET
    @Path("/allStat")
    @Produces({"application/xml", "application/json"})
    public Response allSitesStats() {
        JsonArrayBuilder siteArrayBuilder = Json.createArrayBuilder();
        List<SiteResource> sites = new ArrayList<>();
        for (SiteStatistic siteStatistic : siteRepository.getAllSiteStatistics()) {
            Site site = siteStatistic.getSite();
            siteArrayBuilder.add(Json.createObjectBuilder()
                .add("name", site.getName())
                .add("url", site.getUrl())
                .add("responseTime", siteStatistic.getResponseTime()));
        }
        return Response.ok(siteArrayBuilder.build()).build();
    }

    @XmlRootElement(name = "site")
    public static class SiteResource {
        public String name;
        public String url;
    }
}
