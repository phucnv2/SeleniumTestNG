package SeleniumTestNGPOM.pages;

import SeleniumTestNGPOM.common.BaseTest;
import SeleniumTestNGPOM.pages.customers.CustomersPage;
import keyword.WebUI;

import static keyword.WebUI.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.AssertJUnit;

public class DashboardPage {
    // lấy data trong nội bộ page
    private String PAGE_URL = "https://crm.anhtester.com/admin/";
    private String PAGE_TEXT = "Dashboard Options";

    //các object
    By menuCustomer = By.xpath("//span[normalize-space()='Customers']");
    By btnOptionDashboard = By.xpath("//div[@class='screen-options-btn']");
    // hamm xây dụng
    private WebDriver driver;

    public DashboardPage(WebDriver _driver) {
        driver = _driver;
        new WebUI(driver);
    }

    // ham xu li
    public void verifyDashboardPage() {
        AssertJUnit.assertEquals("URL chua dung", PAGE_URL, getCurrentUrl());
        AssertJUnit.assertTrue(checkElementExist(btnOptionDashboard));
    }

    public CustomersPage openCustomerPage() {
        waitForPageLoaded();
//        driver.findElement(menuCustomer).click();
        clickElement(menuCustomer);
        return new CustomersPage(driver);
    }
}
