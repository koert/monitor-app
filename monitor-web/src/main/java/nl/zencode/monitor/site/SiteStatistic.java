package nl.zencode.monitor.site;

/**
 * Statistics for site.
 * @author Koert Zeilstra
 */
public class SiteStatistic {

    private Site site;
    private long responseTime;

    /**
     * Constructor.
     * @param site Site.
     * @param responseTime Response time in milliseconds.
     */
    public SiteStatistic(Site site, long responseTime) {
        this.site = site;
        this.responseTime = responseTime;
    }

    public Site getSite() {
        return site;
    }

    public long getResponseTime() {
        return responseTime;
    }
}
