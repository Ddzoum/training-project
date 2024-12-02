package org.example.trainingproject

import assertk.assertThat
import assertk.assertions.isEqualTo
import org.springframework.stereotype.Component

@Component
class TestValidations(
    private val world: TestWorld
)
{

    fun validateMessage(expectedMessage: String) {
        val actualMessage = world.message
        assertThat(actualMessage).isEqualTo(expectedMessage)
    }
}