package SeleniumTestNGPOM.pages.customers;

import SeleniumTestNGPOM.common.BaseTest;
import keyword.WebUI;
import static keyword.WebUI.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.AssertJUnit;

public class CustomerDetailPage extends AddCustomerPage{


    private WebDriver driver;
    public CustomerDetailPage(WebDriver _driver){
        super(_driver);
        driver=_driver;
        new WebUI(driver);
    }
    public void checkCustomerDetail(String customerName){
        System.out.println(getAttribute(inputCompany,"value"));
        AssertJUnit.assertEquals("Fail",getAttribute(inputCompany,"value"),customerName);

    }


}
