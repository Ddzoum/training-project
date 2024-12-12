package org.example.trainingproject

import org.example.trainingproject.models.CategoryDto
import org.example.trainingproject.models.PetDto
import org.example.trainingproject.models.TagDto
import org.example.trainingproject.services.TestApiClient
import org.springframework.stereotype.Component

@Component
class TestActions (
    val world: TestWorld,
    val client: TestApiClient,
)
{

    fun printMessage(message: String) {
        println(message)
        world.message = message
    }

    suspend fun createNewPet() {
        val request = PetDto (
            id = 1,
            category = CategoryDto(
                id = 1,
                name = "dog",
            ),
            name = "Peter",
            photoUrls = listOf("http://example.com"),
            tags = listOf(
                TagDto(
                id = 1,
                name = "Tag 1",
            )
            ),
            status = "available"
        )


      world.pet = client.postPet(request)
      println(world.pet.name)

    }
}