package cz.ladicek.swarm.tiny.testingArquillian;

import org.apache.http.client.fluent.Request;
import org.jboss.arquillian.container.test.api.Deployer;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.container.test.api.RunAsClient;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.File;
import java.io.IOException;

import static org.junit.Assert.assertEquals;

@RunWith(Arquillian.class)
//@DefaultDeployment
public class HelloServletTest {
    @Deployment(name = "cz.ladicek.swarm.tiny.testingArquillian.HelloServletTest", managed = false)
    public static Archive<?> deployment() {
        return ShrinkWrap.create(WebArchive.class)
                .addClass(HelloServlet.class)
                .addAsWebInfResource(new File("src/main/webapp/WEB-INF/web.xml"));
    }

    @ArquillianResource
    Deployer deployer;

    @Test
    @RunAsClient
    public void test() throws IOException {
        for (int i = 0; i < 3; i++) {
            deployer.deploy("cz.ladicek.swarm.tiny.testingArquillian.HelloServletTest");

            String response = Request.Get("http://localhost:8080/").execute().returnContent().asString();
            assertEquals("Hello from testing servlet with Arquillian\n", response);

            deployer.undeploy("cz.ladicek.swarm.tiny.testingArquillian.HelloServletTest");
        }
    }
}
