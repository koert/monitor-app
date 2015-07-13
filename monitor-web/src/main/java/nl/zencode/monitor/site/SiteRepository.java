package nl.zencode.monitor.site;

import javax.ejb.Stateless;
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
            new Site("Youtube", "http://www.youtube.com")
    );

    /**
     * @return All sites.
     */
    public List<Site> getAllSites() {
        return sites;
    }
}
