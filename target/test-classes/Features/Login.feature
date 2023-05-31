Feature: Login Functionalities


  @smoke5
  Scenario: Valid Admin Login
    #Given open the browser and launch HRMS application
    When user enters valid "admin" and valid "Hum@nhrm123"
    And click on login button
    Then user is logged in successfully
    #And Close the browser

  @smoke2
  Scenario: Valid Admin Login
     #Given open the browser and launch HRMS application
    When user enters valid "admin" and valid "Hum@nhrm123"
    And click on login button
    Then user is logged in successfully
    #And Close the browser



  #Parameterization/Data Driven
  @ScenarioOutline
  Scenario Outline: Login with different credentials using Scenario Outline
     #Given open the browser and launch HRMS application
    When user enters valid "<username>" and valid "<password>"
    And click on login button
    Then user is logged in successfully
        #And Close the browser

    Examples:
      | username | password    |
      | admin    | Hum@nhrm123 |
      | ADMIN    | Hum@nhrm123 |
      | Jason    | Hum@nhrm123 |


    @dataTable
Scenario: Login with multiple credentials using data table

When user enters username and password and verifies login

        | username | password    |
        | admin    | Hum@nhrm123 |
        | ADMIN    | Hum@nhrm123 |
        | Jason    | Hum@nhrm123 |

    # HOOKS: For defining pre and Post steps in any Cucumber framework
    #        This is always create d inside th StepDefinitions folder
    # Hooks always executed first in class or folder
    # HOOKS will take care (handle) of PRE and POST conditions

