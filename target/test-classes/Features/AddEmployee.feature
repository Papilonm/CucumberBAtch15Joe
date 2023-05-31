Feature:Employee
  @testcase @smoke1
  Scenario:Adding a new Employee

    #Given open the browser and launch HRMS application
    When user enters valid email and valid password
    And click on login button
    When user clicks on PIM option
    And user clicks on add employee button
    And user enters firstname and middlename and lastname
    And user clicks on save button



  @database
    Scenario: Adding the employee through the front end and checking it through the backend.
      When user enters valid email and valid password
      And click on login button
      When user clicks on PIM option
      And user clicks on add employee button
      And user enter 'nesha' and 'sania' and 'namee'
      And user captures employee id
      And user clicks on save button
      And query the information in backend
      Then verify the results from front and back end
