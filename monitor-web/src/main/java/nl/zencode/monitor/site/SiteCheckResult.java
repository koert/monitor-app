package nl.zencode.monitor.site;

/**
 * @author Koert Zeilstra
 */
public class SiteCheckResult {

    public enum Status {OK, ERROR}

    private Status status;
    private long responseTime;

    public SiteCheckResult(Status status, long responseTime) {
        this.status = status;
        this.responseTime = responseTime;
    }

    public Status getStatus() {
        return status;
    }

    public long getResponseTime() {
        return responseTime;
    }
}

