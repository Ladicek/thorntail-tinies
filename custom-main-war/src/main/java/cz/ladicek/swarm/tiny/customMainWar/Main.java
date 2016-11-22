package cz.ladicek.swarm.tiny.customMainWar;

import org.wildfly.swarm.Swarm;

public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("Starting custom main in WAR");

        new Swarm().start().deploy();
    }
}
