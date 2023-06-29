package SeleniumTestNGPOM.pages.customers;

import SeleniumTestNGPOM.common.BaseTest;
import keyword.WebUI;
import static keyword.WebUI.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.AssertJUnit;

public class CustomersPage {
    private String PAGE_URL = "https://crm.anhtester.com/admin/clients";
    private String PAGE_TEXT = "Customers Summary";
// Location
    private By headerPageCustomers = By.xpath("(//div[@class='panel-body']//h4)[1]");
    private By buttonAddCustomer = By.xpath("//a[normalize-space()='New Customer']");
    private By buttonImportCustomer = By.xpath("//a[normalize-space()='Import Customers']");
    private By buttonContacts = By.xpath("//div[@class='_buttons']//a[normalize-space()='Contacts']");
    private By inputSearch = By.xpath("//div[@id='DataTables_Table_0_filter']//input");
    private By tdCustomerName = By.xpath("//table[@id='DataTables_Table_0']//tbody/tr[1]/td[3]/a");


// Hàm xây dụng
private WebDriver driver;
    public CustomersPage(WebDriver _driver){
        driver=_driver;
        new WebUI(driver);
    }

    public void verifyPageCustomer(){
        AssertJUnit.assertEquals("URL chua dung",PAGE_URL,driver.getCurrentUrl());
        AssertJUnit.assertTrue(checkElementExist(buttonAddCustomer));
        AssertJUnit.assertEquals("Sai Header roi",PAGE_TEXT,getTextElement(headerPageCustomers));
    }
    public AddCustomerPage clickBtnAddNewCustomer(){
//        waitForElementVisible(buttonAddCustomer,10);
        clickElement(buttonAddCustomer);
        return new AddCustomerPage(driver);
    }

    public void searchRecordAddNew(String companyName){
        waitForPageLoaded();
//        waitForElementVisible(inputSearch,10);
        senkeyText(inputSearch,companyName);
        sleep(3);
    }
    public CustomerDetailPage clickCustomerDetail(){
        waitForPageLoaded();
//        waitForElementVisible(tdCustomerName,10);
        clickElement(tdCustomerName);
        return new CustomerDetailPage(driver);
    }
}
