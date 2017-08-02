package cz.ladicek.swarm.tiny.topologyWebapp;

import org.wildfly.swarm.topology.Advertise;
import org.wildfly.swarm.topology.Topology;

import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Advertise("hello")
@WebServlet("/hello")
public class HelloServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            resp.getWriter().print("Hello, topology is " + Topology.lookup().asMap().keySet());
        } catch (NamingException e) {
            throw new ServletException(e);
        }
    }
}
