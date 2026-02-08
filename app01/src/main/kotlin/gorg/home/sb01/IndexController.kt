package gorg.home.sb01

import dev.openfeature.sdk.Client
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping

@Controller
class IndexController(private val client: Client) {

    @GetMapping("/")
    fun index(model: Model): String {
        model.addAttribute("client", client)
        return "index"
    }

}
