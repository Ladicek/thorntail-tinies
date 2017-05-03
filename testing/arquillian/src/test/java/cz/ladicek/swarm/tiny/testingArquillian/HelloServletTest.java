package cz.ladicek.swarm.tiny.testingArquillian;

import org.apache.http.client.fluent.Request;
import org.jboss.arquillian.container.test.api.RunAsClient;
import org.jboss.arquillian.junit.Arquillian;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.wildfly.swarm.arquillian.DefaultDeployment;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

@RunWith(Arquillian.class)
@DefaultDeployment
public class HelloServletTest {
    @Test
    @RunAsClient
    public void test() throws IOException {
        String response = Request.Get("http://localhost:8080/").execute().returnContent().asString();
        assertEquals("Hello from testing servlet with Arquillian\n", response);
    }
}
