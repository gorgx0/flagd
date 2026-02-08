package gorg.home.sb01

import dev.openfeature.contrib.providers.flagd.Config
import dev.openfeature.contrib.providers.flagd.FlagdOptions
import dev.openfeature.contrib.providers.flagd.FlagdProvider
import dev.openfeature.sdk.Client
import dev.openfeature.sdk.OpenFeatureAPI
import gorg.home.sb01.ConfigType.IN_PROCESS
import gorg.home.sb01.ConfigType.RPC
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import kotlin.math.log

@Configuration
class Config(
    val flagdConfig: FlagdConfig
) {

    companion object {
        val log = org.slf4j.LoggerFactory.getLogger(Config::class.java)
    }

    @Bean
    fun client(): Client {
        val api = OpenFeatureAPI.getInstance()

        log.info("Configuring Flagd provider with config type: ${flagdConfig}")
        when (flagdConfig.configType) {
            IN_PROCESS -> {
                api.setProviderAndWait(
                    FlagdProvider(
                        FlagdOptions.builder()
                            .host(flagdConfig.inProcess.host)
                            .port(flagdConfig.inProcess.port)
                            .resolverType(Config.Resolver.IN_PROCESS)
                            .build()
                    )
                )
            }

            RPC -> {
                api.setProviderAndWait(
                    FlagdProvider(
                        FlagdOptions.builder()
                            .host(flagdConfig.rpc.host)
                            .port(flagdConfig.rpc.port)
                            .resolverType(Config.Resolver.RPC)
                            .build()
                    )
                )
            }
        }

        return api.client
    }
}