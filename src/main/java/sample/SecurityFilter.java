package sample;

import java.io.IOException;
import java.util.Objects;

import javax.annotation.Priority;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.Priorities;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.PreMatching;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

/**
 * ログイン認証を行うフィルター。
 *
 */
@ApplicationScoped
@Provider
@PreMatching
@Priority(Priorities.AUTHENTICATION)
public class SecurityFilter implements ContainerRequestFilter {

    @Inject
    private User user;

    @Override
    public void filter(ContainerRequestContext requestContext)
            throws IOException {

        if (user.isLoggedin()) {
            return;
        }

        //簡易的にusernameだけで認証の代わりにしてる。
        String username = requestContext.getUriInfo().getQueryParameters()
                .getFirst("username");
        if (Objects.equals(username, "sample")) {
            user.login(username);
            return;
        }

        //ログインしていないかつ認証失敗したら401
        requestContext.abortWith(Response.status(Response.Status.UNAUTHORIZED)
                .build());
    }
}
