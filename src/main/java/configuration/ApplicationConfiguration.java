package configuration;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashMap;
import java.util.Map;
@ApplicationPath("api")
public class ApplicationConfiguration extends Application {
    public Map<String, Object> getProperties() {
        Map<String, Object> properties = new HashMap<String, Object>();
        properties.put("jersey.config.server.provider.packages", "controller");
        JPAConfiguration.getEntityManager();
        return properties;
    }
}
