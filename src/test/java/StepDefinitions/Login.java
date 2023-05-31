package StepDefinitions;

import Pages.LoginPage;
import Utils.CommonMethods;
import Utils.ConfigReader;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.time.Duration;
import java.util.List;
import java.util.Map;


public class Login extends CommonMethods {


    @Given("open the browser and launch HRMS application")
    public void open_the_browser_and_launch_hrms_application() {

        openBrowserAndLaunchApplication();

    }

    @When("user enters valid email and valid password")
    public void user_enters_valid_email_and_valid_password() {
//        LoginPage login = new LoginPage();

        //driver.findElement(By.id("txtUsername")).sendKeys(ConfigReader.getPropertyValue("username"));

//        WebElement usernameTextBox = driver.findElement(By.id("txtUsername"));
        sentTextTo(login.usernameTextBox, ConfigReader.getPropertyValues("Username"));

        //driver.findElement(By.id("txtPassword")).sendKeys(ConfigReader.getPropertyValue("password"));
//        WebElement passwordTextBox = driver.findElement(By.id("txtPassword"));
        sentTextTo(login.passwordTextBox, ConfigReader.getPropertyValues("Password"));
    }

    @When("click on login button")
    public void click_on_login_button() {
//        LoginPage login = new LoginPage();

//        WebElement loginbton = driver.findElement(By.xpath("//input[@type='submit']"));
        doClick(login.loginbton);
    }

    @Then("user is logged in successfully")
    public void user_is_logged_in_successfully() {
        boolean userLoggedIn = driver.findElement(By.xpath("//a[@id='welcome']")).isDisplayed();
        if (userLoggedIn) {
            System.out.println("User logged in Successfully");
        }
    }

    @Then("Close the browser")
    public void close_the_browser() {
        closebrowser();

    }

    @When("user enters valid {string} and valid {string}")
    public void user_enters_valid_and_valid(String username, String password) {
//        LoginPage login = new LoginPage();

//        WebElement usernameTextBox = driver.findElement(By.id("txtUsername"));
        sentTextTo(login.usernameTextBox, username);

//        WebElement passwordTextBox = driver.findElement(By.id("txtPassword"));
        sentTextTo(login.passwordTextBox, password);
    }

    @When("user enters username and password and verifies login")
    public void user_enters_username_and_password_and_verifies_login(DataTable dataTable) {
//        LoginPage login = new LoginPage();

        List<Map<String, String>> UserCredentials = dataTable.asMaps();
        for (Map<String, String> userCreds : UserCredentials) {

            String username = userCreds.get("username");
            String password = userCreds.get("password");

//            WebElement usernameTextBox = driver.findElement(By.id("txtUsername"));
            sentTextTo(login.usernameTextBox, username);

//            WebElement passwordTextBox = driver.findElement(By.id("txtPassword"));
            sentTextTo(login.passwordTextBox, password);

//            WebElement loginbton = driver.findElement(By.xpath("//input[@type='submit']"));
            doClick(login.loginbton);

//            WebElement welcome = driver.findElement(By.id("welcome"));
            doClick(login.welcome);

//            WebElement logOff = driver.findElement(By.xpath("//a[text()='Logout']"));
            doClick(login.logOff);
        }

    }
}
