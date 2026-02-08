package gorg.home.sb01

import dev.openfeature.sdk.Client
import dev.openfeature.sdk.FlagEvaluationDetails
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.RequestMapping

@RestController
@RequestMapping("/ff")
class FeatureFlagController(
    val client: Client
) {

    @RequestMapping("/test")
    fun test(): FlagEvaluationDetails<String?>? {
        val evaluationContext = client.getEvaluationContext()
        return client.getStringDetails("welcomeMessage", "defaultValue", )
    }
}
