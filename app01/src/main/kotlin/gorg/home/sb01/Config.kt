package gorg.home.sb01

import dev.openfeature.contrib.providers.flagd.Config
import dev.openfeature.contrib.providers.flagd.FlagdOptions
import dev.openfeature.contrib.providers.flagd.FlagdProvider
import dev.openfeature.sdk.Client
import dev.openfeature.sdk.OpenFeatureAPI
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class Config {
    @Bean
    fun client(): Client? {
        val api = OpenFeatureAPI.getInstance()
        api.setProviderAndWait(FlagdProvider(
            FlagdOptions.builder()
                .host("flagd.localhost")
                .port(30080)
                .resolverType(Config.Resolver.RPC)
                .build()
        ))
        return api.getClient()
    }
}