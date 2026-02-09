package gorg.home.sb01

import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties("openfeature.flagd")
data class FlagdConfig(
    val configType: ConfigType = ConfigType.IN_PROCESS,
    val rpc: RpcConfig,
    val inProcess: InProcessConfig,
    val deadline: Int = 1000
) {
}

enum class ConfigType {
    IN_PROCESS,
    RPC
}

data class InProcessConfig(
    val host: String = "localhost",
    val port: Int = 8015,
)

data class RpcConfig(
    val host: String = "localhost",
    val port: Int = 8013,
)
