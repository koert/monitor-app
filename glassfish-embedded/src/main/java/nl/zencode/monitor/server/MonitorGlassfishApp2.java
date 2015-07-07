package nl.zencode.monitor.server;

import org.glassfish.embeddable.*;
import org.glassfish.embeddable.archive.ScatteredArchive;

import java.io.File;
import java.io.IOException;

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
        System.out.println(new File("").getAbsolutePath());
        MonitorGlassfishApp2 app = new MonitorGlassfishApp2();
        app.startServer();
        app.deploy();
    }

    public MonitorGlassfishApp2() throws GlassFishException {
        GlassFishProperties glassfishProperties = new GlassFishProperties();
        glassfishProperties.setPort("http-listener", 8888);
        this.glassfish = GlassFishRuntime.bootstrap().newGlassFish(glassfishProperties);
    }

    public void startServer() throws GlassFishException {
        glassfish.start();
    }

    public void deploy() {
        try {
            Deployer deployer = glassfish.getDeployer();
            ScatteredArchive archive = new ScatteredArchive("monitorApp", ScatteredArchive.Type.WAR,
                    new File("monitor-web/src/main/webapp"));
            archive.addMetadata(new File("monitor-web/src/main/webapp/WEB-INF/web.xml"));
            String appName = deployer.deploy(archive.toURI(), "--contextroot=/");
        } catch (GlassFishException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
