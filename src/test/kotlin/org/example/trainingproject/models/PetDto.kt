package org.example.trainingproject.models

    data class PetDto(
        val id: Long = 0,
        val category: CategoryDto,
        val name: String,
        val photoUrls: List<String>,
        val tags: List<TagDto>,
        val status: String
    )


    data class CategoryDto(
        val id: Long = 0,
        val name: String
    )

    data class TagDto(
        val id: Long = 0,
        val name: String
    )
