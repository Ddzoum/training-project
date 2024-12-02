package org.example.trainingproject

import org.springframework.stereotype.Component

@Component
class TestActions (
    val world: TestWorld
)
{

    fun printMessage(message: String) {
        println(message)
        world.message = message
    }
}