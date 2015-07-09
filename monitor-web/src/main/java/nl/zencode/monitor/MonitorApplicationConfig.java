package nl.zencode.monitor;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

/**
 * Configuration for REST (JAX RS) services.
 * @author Koert Zeilstra
 */
@ApplicationPath("/service")
public class MonitorApplicationConfig extends Application {
}
