package utils;

import pages.AddEmployeeErrorMessageValidationPage;
import pages.AddEmployeePage;
import pages.DashboardPage;
import pages.LoginPage;

public class PageObjectInitializer {

    public static LoginPage loginPage;
    public static AddEmployeePage addEmployeePage;
    public static DashboardPage dashboardPage;
    public static AddEmployeeErrorMessageValidationPage addEmployeeErrorMessageValidationPage;

    public static void initializeObject(){
        loginPage = new LoginPage();
        addEmployeePage = new AddEmployeePage();
        dashboardPage = new DashboardPage();
        addEmployeeErrorMessageValidationPage = new AddEmployeeErrorMessageValidationPage();
    }
}
