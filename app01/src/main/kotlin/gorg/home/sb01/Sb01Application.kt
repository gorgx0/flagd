package gorg.home.sb01

import dev.openfeature.sdk.OpenFeatureAPI
import dev.openfeature.contrib.providers.flagd.FlagdProvider
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.ConfigurableApplicationContext

@SpringBootApplication
class Sb01Application

fun main(args: Array<String>) {
	val context: ConfigurableApplicationContext = runApplication<Sb01Application>(*args)
	val api = OpenFeatureAPI.getInstance()
	api.setProvider(FlagdProvider())

	val client = api.getClient()
	val myNewFeature = client.getBooleanValue("my-new-feature", false)
	println("my-new-feature: $myNewFeature")
}
