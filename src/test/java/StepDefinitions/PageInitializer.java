package StepDefinitions;

import Pages.AddEmployeePage;
import Pages.LoginPage;

public class PageInitializer {
    public static LoginPage login;
    public static AddEmployeePage addEmployeePage;
    public static EmployeeSearch employeeSearch;

    public static void initializePageObjects(){
        login=new LoginPage();
        addEmployeePage=new AddEmployeePage();
        employeeSearch=new EmployeeSearch();



    }
}
