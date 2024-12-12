package org.example.trainingproject.services

import org.example.trainingproject.models.PetDto
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.client.WebClient
import org.springframework.web.reactive.function.client.awaitBody

@Component
class TestApiClient(
    private val webClient: WebClient
) {

    suspend fun postPet(req:PetDto) : PetDto {
        return webClient.post().uri("/pet").bodyValue(req).retrieve().awaitBody()
    }
}