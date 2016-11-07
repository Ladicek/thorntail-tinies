package cz.ladicek.swarm.tiny.customMain;

import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.ClassLoaderAsset;
import org.wildfly.swarm.Swarm;
import org.wildfly.swarm.undertow.WARArchive;
import org.wildfly.swarm.undertow.descriptors.WebXmlAsset;

public class Main {
    public static void main(String[] args) throws Exception {
        Swarm swarm = new Swarm();
        WARArchive war = ShrinkWrap.create(WARArchive.class)
                .addClass(HelloServlet.class)
                .addAsWebInfResource(new ClassLoaderAsset("web.xml", Main.class.getClassLoader()), WebXmlAsset.NAME);
        swarm.start().deploy(war);
    }
}
