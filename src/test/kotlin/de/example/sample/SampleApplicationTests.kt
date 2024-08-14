package de.example.sample

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.cloud.stream.binder.test.EnableTestBinder
import org.springframework.cloud.stream.binder.test.OutputDestination

@SpringBootTest
@EnableTestBinder
class SampleApplicationTests(
    @Autowired private val outputDestination: OutputDestination,
) {

    @Test
    fun `should receive a message`() {
        // Given
        
        // When
        val message: String? = outputDestination.receive(1_000, "test")
            ?.payload
            ?.decodeToString()

        // Then
        assertThat(message).isEqualTo("Hello World!")
    }
}
