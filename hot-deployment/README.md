# Howto

The project uses [standalone.xml](hot-deployment/src/main/resources/standalone.xml) for configuring the deployment scanner, 
but you don't have to specify it anywhere. Thorntail detects its presence and uses it automatically.

(Please ignore the project-defaults.yml bit, it doesn't work and is useless.)

## Building and starting up the app

```bash
mvn clean package
java -jar target/hot-deployment-thorntail.jar
```

Notice it prints "WFLYDS0013: Started FileSystemDeploymentService for directory ...".

## Send an HTTP request to the app

```bash
curl http://localhost:8080
```

## Change something to try the Hot Deploy

Modify [HelloServlet.java](hot-deployment/src/main/java/cz/ladicek/swarm/tiny/hotDeployment/HelloServlet.java) in some way and then:

```bash
mvn clean package -Predeploy
```

Notice the running app prints "Replaced deployment ... with deployment ...".

You can send another HTTP request to check the changes took place.

```bash
curl http://localhost:8080
```

The `-Predeploy` profile only uses the Maven Dependency plugin to copy the WAR into the scanned directory, otherwise it's the same build as normal. 
I guess it could be made faster by not running the Thorntail Maven plugin, but that might have some consequences.
