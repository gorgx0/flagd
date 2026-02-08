package gorg.home.sb01

import dev.openfeature.contrib.providers.flagd.Config
import dev.openfeature.contrib.providers.flagd.FlagdOptions
import dev.openfeature.sdk.OpenFeatureAPI
import dev.openfeature.contrib.providers.flagd.FlagdProvider
import dev.openfeature.sdk.Client
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.ConfigurableApplicationContext
import org.springframework.context.annotation.Bean

@SpringBootApplication
class Sb01Application

fun main(args: Array<String>) {
	val context: ConfigurableApplicationContext = runApplication<Sb01Application>(*args)
	val client = context.getBean(Client::class.java)
	val myNewFeature = client.getBooleanValue("my-new-feature", false)
	println("my-new-feature: $myNewFeature")
}
