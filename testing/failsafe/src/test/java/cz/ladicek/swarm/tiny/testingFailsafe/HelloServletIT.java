package cz.ladicek.swarm.tiny.testingFailsafe;

import java.io.IOException;

import org.apache.http.client.fluent.Request;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class HelloServletIT {
    @Test
    public void test() throws IOException {
        String response = Request.Get("http://localhost:8080/").execute().returnContent().asString();
        assertEquals("Hello from testing servlet with Failsafe\n", response);
    }
}
