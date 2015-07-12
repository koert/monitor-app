package nl.zencode.monitor.site;

import org.apache.http.HttpStatus;
import org.apache.http.StatusLine;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.IOException;

/**
 * @author Koert Zeilstra
 */
public class Site {

    private int timeout = 10000;
    private int requestTimeout = 30000;
    private String url;

    public SiteCheckResult test() {
        SiteCheckResult result = null;
        RequestConfig config = RequestConfig.custom()
                .setConnectTimeout(timeout).setConnectionRequestTimeout(requestTimeout).setSocketTimeout(timeout).build();
        CloseableHttpClient httpClient = HttpClientBuilder.create().setDefaultRequestConfig(config).build();
        long start = System.currentTimeMillis();
        try {
            HttpGet httpGet = new HttpGet(url);
//            httpGet.addHeader("Accept", "application/json");
//            log.debug("httpGet: {}", httpGet.toString());
            CloseableHttpResponse response = httpClient.execute(httpGet);
            StatusLine statusLine = response.getStatusLine();
            if (statusLine.getStatusCode() == HttpStatus.SC_OK) {
                result = new SiteCheckResult(SiteCheckResult.Status.OK, System.currentTimeMillis() - start);
            } else {
                result = new SiteCheckResult(SiteCheckResult.Status.ERROR, System.currentTimeMillis() - start);
            }
        } catch (IOException e) {
            result = new SiteCheckResult(SiteCheckResult.Status.ERROR, System.currentTimeMillis() - start);
        } finally {
            try {
                httpClient.close();
            } catch (IOException e) {
                // ignore
            }
        }
        return result;
    }

}
