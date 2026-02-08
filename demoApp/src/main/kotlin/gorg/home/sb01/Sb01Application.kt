package gorg.home.sb01

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.runApplication

@SpringBootApplication
@EnableConfigurationProperties(FlagdConfig::class)
class Sb01Application

fun main(args: Array<String>) {
	runApplication<Sb01Application>(*args)
}
