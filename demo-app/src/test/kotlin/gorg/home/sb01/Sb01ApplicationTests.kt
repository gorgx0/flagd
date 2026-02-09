package gorg.home.sb01

import dev.openfeature.sdk.Client
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.bean.override.mockito.MockitoBean

@SpringBootTest()
class Sb01ApplicationTests {

    @MockitoBean
    private lateinit var client: Client // Replace 'Client' with your actual client type

    @Test
    fun contextLoads() {
    }
}
