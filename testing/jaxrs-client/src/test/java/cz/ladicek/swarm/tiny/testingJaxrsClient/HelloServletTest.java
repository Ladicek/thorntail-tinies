package cz.ladicek.swarm.tiny.testingJaxrsClient;

import org.jboss.arquillian.container.test.api.RunAsClient;
import org.jboss.arquillian.junit.Arquillian;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.wildfly.swarm.arquillian.DefaultDeployment;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import java.io.IOException;

import static org.junit.Assert.assertEquals;

@RunWith(Arquillian.class)
@DefaultDeployment
public class HelloServletTest {
    @Test
    @RunAsClient
    public void test() throws IOException {
        Client client = ClientBuilder.newClient();
        try {
            WebTarget target = client.target("http://localhost:8080");
            Response response = target.request().get();
            assertEquals("Hello from testing servlet with JAX-RS Client\n", response.readEntity(String.class));
        } finally {
            client.close();
        }
    }
}
