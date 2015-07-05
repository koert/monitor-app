package nl.zencode.monitor.server;

import org.glassfish.embeddable.GlassFish;
import org.glassfish.embeddable.GlassFishException;
import org.glassfish.embeddable.GlassFishProperties;
import org.glassfish.embeddable.GlassFishRuntime;

/**
 * Main test app to start embedded Glassfish.
 * @author Koert Zeilstra
 */
public class MonitorGlassfishApp2 {

    private GlassFish glassfish;

    /**
     * Main.
     * @param args Arguments.
     * @throws Exception Failed to run.
     */
    public static void main(String[] args) throws Exception {
        MonitorGlassfishApp2 app = new MonitorGlassfishApp2();
        app.startServer();
    }

    public MonitorGlassfishApp2() throws GlassFishException {
        GlassFishProperties glassfishProperties = new GlassFishProperties();
        glassfishProperties.setPort("http-listener", 8888);
        this.glassfish = GlassFishRuntime.bootstrap().newGlassFish(glassfishProperties);
    }

    public void startServer() throws GlassFishException {
        glassfish.start();
    }
}
