package cz.ladicek.swarm.tiny.openshift;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/ready")
public class ReadyServlet extends HttpServlet {
    private volatile boolean ready = true;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Serving readiness check");
        if (req.getParameter("toggle") != null) {
            System.out.println("Toggling readiness from '" + ready + "' to ' " + !ready + "'");
            ready = !ready;

            resp.setStatus(200);
            return;
        }

        resp.setStatus(ready ? 200 : 500);
    }
}
