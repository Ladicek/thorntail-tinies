package cz.ladicek.swarm.tiny.openshift;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/live")
public class LiveServlet extends HttpServlet {
    private volatile boolean live = true;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Serving liveness check");
        if (req.getParameter("toggle") != null) {
            System.out.println("Toggling liveness from '" + live + "' to ' " + !live + "'");
            live = !live;

            resp.setStatus(200);
            return;
        }

        resp.setStatus(live ? 200 : 500);
    }
}
