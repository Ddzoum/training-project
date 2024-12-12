Feature: Hello World Feature

  Scenario: Print Hello World
    When I print "Hello World"
    Then the message should be "Hello World"

  Scenario: An existing pet can be updated successfully
    Given there is a pet
#    When the pet is updated
#    Then pet data are updated properly

