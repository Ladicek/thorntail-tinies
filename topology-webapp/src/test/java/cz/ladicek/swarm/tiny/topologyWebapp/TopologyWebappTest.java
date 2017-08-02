package cz.ladicek.swarm.tiny.topologyWebapp;

import org.apache.http.client.fluent.Request;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.container.test.api.RunAsClient;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.msc.service.ServiceActivator;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.wildfly.swarm.spi.api.JARArchive;

import java.io.File;
import java.io.IOException;

@RunWith(Arquillian.class)
public class TopologyWebappTest {
    @Deployment
    public static Archive deployment() {
        Archive war = ShrinkWrap.create(WebArchive.class)
                .addPackage(HelloServlet.class.getPackage())
                .addAsServiceProvider(ServiceActivator.class, MockTopologyConnectorServiceActivator.class)
                .addAsWebResource(new File("src/main/webapp/index.html"), "index.html");
        war.as(JARArchive.class).addModule("org.wildfly.swarm.topology", "runtime");
        war.as(JARArchive.class).addModule("org.jboss.as.network");
        return war;
    }

    @Test
    @RunAsClient
    public void servlet() throws IOException {
        String response = Request.Get("http://localhost:8080/hello").execute().returnContent().asString();
        Assert.assertEquals("Hello, topology is [hello]", response);
    }

    @Test
    @RunAsClient
    public void webpage() throws IOException {
        String response = Request.Get("http://localhost:8080/").execute().returnContent().asString();
        Assert.assertTrue(response.contains("current-topology"));
    }
}
