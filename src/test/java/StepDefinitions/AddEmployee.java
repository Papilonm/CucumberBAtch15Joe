package StepDefinitions;

import Utils.*;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static Utils.CommonMethods.driver;

public class AddEmployee extends CommonMethods {

    @When("user clicks on PIM option")
    public void user_clicks_on_pim_option() {
//       WebElement pimtab= driver.findElement(By.id("menu_pim_viewPimModule"));
        doClick(addEmployeePage.pimtab);

    }

    @When("user clicks on add employee button")
    public void user_clicks_on_add_employee_button() {
        driver.findElement(By.id("menu_pim_addEmployee")).click();
    }

    @When("user enters firstname and middlename and lastname")
    public void user_enters_firstname_and_middlename_and_lastname() {
//       WebElement firstnameTextBox= driver.findElement(By.id("firstName"));
        sentTextTo(addEmployeePage.firstnameTextBox, ConfigReader.getPropertyValues("firstname"));


//      WebElement middlename= driver.findElement(By.id("middleName"));
        sentTextTo(addEmployeePage.middlenameTextBox, ConfigReader.getPropertyValues("middlename"));

//      WebElement lastname=driver.findElement(By.id("lastName"));
        sentTextTo(addEmployeePage.lastNameTextBox, ConfigReader.getPropertyValues("lastname"));
    }

    @When("user clicks on save button")
    public void user_clicks_on_save_button() {
//       WebElement saveBtn= driver.findElement(By.id("btnSave"));
        doClick(addEmployeePage.SaveBtn);

    }

    @When("user enter {string} and {string} and {string}")
    public void user_enter_and_and(String fname, String mname, String lname) {
        sentTextTo(addEmployeePage.firstnameTextBox, fname);
        sentTextTo(addEmployeePage.middlenameTextBox, mname);
        sentTextTo(addEmployeePage.lastNameTextBox, lname);
    }

    @When("user captures employee id")
    public void user_captures_employee_id() {
        GlobalVariables.emp_id = addEmployeePage.empIdLocator.getAttribute("value");
        System.out.println("The employee ID is : " + GlobalVariables.emp_id);

    }

    @When("query the information in backend")
    public void query_the_information_in_backend() {
        String query = "select * from hs_hr_employees where employee_id='" + GlobalVariables.emp_id+"'";
        GlobalVariables.tabledata = DBUtility.getListOfMapsFromRset(query);
    }

    @Then("verify the results from front and back end")
    public void verify_the_results_from_front_and_back_end() {
        String firstNamefromDB = GlobalVariables.tabledata.get(0).get("emp_firstname");
        System.out.println(firstNamefromDB);


    }
}
