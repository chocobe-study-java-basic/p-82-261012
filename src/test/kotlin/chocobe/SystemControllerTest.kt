package chocobe

import org.assertj.core.api.Assertions.assertThat
import kotlin.test.Test

class SystemControllerTest {

    @Test
    fun `종료`() {
        val out: String = TestRunner.run("")
        assertThat(out).contains("=== 명언 앱 종료 ===")
    }
}