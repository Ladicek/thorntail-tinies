package cz.ladicek.swarm.tiny.kotlin

import io.swagger.jaxrs.config.BeanConfig
import javax.ws.rs.ApplicationPath
import javax.ws.rs.core.Application

@ApplicationPath("/")
class RestApplication : Application() {
    init {
        val beanConfig = BeanConfig()
        beanConfig.schemes = arrayOf("http")
        beanConfig.host = "localhost:8080"
        beanConfig.basePath = "/"

        beanConfig.resourcePackage = "cz.ladicek.swarm.tiny.kotlin"
        beanConfig.scan = true
    }

    override fun getProperties(): Map<String, Any> = mapOf(
            "resteasy.scan" to "true"
    )
}
