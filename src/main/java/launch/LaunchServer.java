package launch;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.handler.AbstractHandler;

public class LaunchServer extends AbstractHandler {
    @Override
    public void handle(final String target, final Request baseRequest, final HttpServletRequest request,
            final HttpServletResponse response) throws IOException, ServletException {
        // Declare response encoding and types
        response.setContentType("text/html; charset=utf-8");

        // Declare response status code
        response.setStatus(HttpServletResponse.SC_OK);

        // Write back response
        final String path = request.getPathInfo();
        System.out.println(new File("./" + path).getAbsolutePath());
        final byte[] content = Files.readAllBytes(Paths.get(".", path));
        response.getOutputStream().write(content);

        // Inform jetty that this request has now been handled
        baseRequest.setHandled(true);
    }
}