package nl.zencode.monitor.server;

import org.glassfish.embeddable.GlassFish;
import org.glassfish.embeddable.GlassFishException;
import org.glassfish.embeddable.GlassFishProperties;
import org.glassfish.embeddable.GlassFishRuntime;
import org.junit.Test;

/**
 * Main test app to start embedded Glassfish.
 * @author Koert Zeilstra
 */
public class MonitorGlassfishApp {

    private GlassFish glassfish;

    /**
     * Main.
     * @param args Arguments.
     * @throws Exception Failed to run.
     */
    public static void main(String[] args) throws Exception {
        MonitorGlassfishApp app = new MonitorGlassfishApp();
        app.startServer();
        Thread.sleep(10000);
    }

    public MonitorGlassfishApp() throws GlassFishException {
        GlassFishProperties glassfishProperties = new GlassFishProperties();
        glassfishProperties.setPort("http-listener", 8888);
        this.glassfish = GlassFishRuntime.bootstrap().newGlassFish(glassfishProperties);
    }

    public void startServer() throws GlassFishException {
        glassfish.start();
    }

    @Test
    public void start() throws Exception {
        GlassFishProperties glassfishProperties = new GlassFishProperties();
        this.glassfish = GlassFishRuntime.bootstrap().newGlassFish(glassfishProperties);
        glassfish.start();
    }
}
