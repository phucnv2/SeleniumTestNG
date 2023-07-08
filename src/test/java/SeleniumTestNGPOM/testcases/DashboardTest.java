package SeleniumTestNGPOM.testcases;

import SeleniumTestNGPOM.common.BaseTest;
import SeleniumTestNGPOM.pages.customers.CustomersPage;
import SeleniumTestNGPOM.pages.DashboardPage;
import SeleniumTestNGPOM.pages.login.LoginPage;
import org.testng.annotations.Test;

public class DashboardTest extends BaseTest {
    LoginPage loginPage;
    DashboardPage dashboardPage;
    CustomersPage customersPage;
    @Test
    public void testOpenMenuDashboad(){
        loginPage = new LoginPage(driver);
        dashboardPage = loginPage.pageLoginSuccess("admin@example.com","123456"); // lien kêt trang

        dashboardPage.verifyDashboardPage();

        customersPage = dashboardPage.openCustomerPage();

        customersPage.verifyPageCustomer();
        customersPage.clickBtnAddNewCustomer();
    }

}
