package nl.zencode.monitor.site;

import javax.ejb.Stateless;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Repository for Site objects.
 * @author Koert Zeilstra
 */
@Stateless
public class SiteRepository {

    private static final List<Site> sites = Arrays.asList(
            new Site("Google", "http://www.google.com"),
            new Site("Youtube", "http://www.youtube.com"),
            new Site("Yahoo", "http://www.yahoo.com")
    );

    /**
     * @return All sites.
     */
    public List<Site> getAllSites() {
        return sites;
    }

    /**
     * @return All site statistics.
     */
    public List<SiteStatistic> getAllSiteStatistics() {
        List<SiteStatistic> siteStatistics = new ArrayList<>();
        for (Site site : sites) {
            SiteCheckResult result = site.test();
            SiteStatistic statistic = new SiteStatistic(site, result.getResponseTime());
            siteStatistics.add(statistic);
        }
        return siteStatistics;
    }
}
