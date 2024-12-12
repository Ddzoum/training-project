package org.example.trainingproject.stepdefinitions

import io.cucumber.java8.En
import kotlinx.coroutines.runBlocking
import org.example.trainingproject.TestActions
import org.example.trainingproject.TestValidations

@Suppress("unused")
class StepDefinitions(
    actions: TestActions,
    validations: TestValidations
) :En {

    init {
        When("I print {string}") { text: String ->
            actions.printMessage(text)
        }

        Then("the message should be {string}") { expectedText: String ->
           validations.validateMessage(expectedText)
        }

        Given("there is a pet") {
            runBlocking { actions.createNewPet() }

        }
    }
}

