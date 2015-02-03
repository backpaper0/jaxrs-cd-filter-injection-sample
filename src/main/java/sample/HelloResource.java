package sample;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * こんにちは、世界。
 *
 */
@RequestScoped
@Path("")
public class HelloResource {

    @Inject
    private User user;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String get() {
        return String.format("Hello, %s!", user.getUsername());
    }
}
