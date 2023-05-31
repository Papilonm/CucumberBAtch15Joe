package Pages;

import Utils.CommonMethods;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddEmployeePage extends CommonMethods {

@FindBy(id="menu_pim_viewPimModule")
public WebElement pimtab;

@FindBy(id="menu_pim_addEmployee")
    public WebElement addEmp;

@FindBy(id="firstName")
    public WebElement firstnameTextBox;

@FindBy(id="middleName")
    public WebElement middlenameTextBox;

@FindBy(id="lastName")
    public WebElement lastNameTextBox;

@FindBy(id="btnSave")
    public WebElement SaveBtn;
    @FindBy(id="employeeId")
    public WebElement empIdLocator;


        public AddEmployeePage(){
            PageFactory.initElements(driver,this);
        }
}
