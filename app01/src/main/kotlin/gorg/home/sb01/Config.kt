package gorg.home.sb01

import dev.openfeature.contrib.providers.flagd.Config
import dev.openfeature.contrib.providers.flagd.FlagdOptions
import dev.openfeature.contrib.providers.flagd.FlagdProvider
import dev.openfeature.sdk.Client
import dev.openfeature.sdk.OpenFeatureAPI
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class Config {
    @Value("\${openfeature.flagd.host:localhost}")
    lateinit var host: String

    @Value("\${openfeature.flagd.port:8013}")
    var port: Int = 8013

    @Value("\${openfeature.flagd.resolver-type:RPC}")
    lateinit var resolverType: String

    @Bean
    fun client(): Client? {
        val api = OpenFeatureAPI.getInstance()
        api.setProviderAndWait(FlagdProvider(
            FlagdOptions.builder()
                .host(host)
                .port(port)
                .resolverType(Config.Resolver.valueOf(resolverType))
                .build()
        ))
        return api.getClient()
    }
}