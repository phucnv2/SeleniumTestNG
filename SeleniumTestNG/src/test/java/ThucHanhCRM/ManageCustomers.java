package ThucHanhCRM;

import TestNG_baitap1.baseTest.Common;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ManageCustomers extends Common {
    @Test(priority = 1)
    public void validateEmailNull() {
        driver.get("https://crm.anhtester.com/admin/authentication");
        driver.findElement(By.xpath("//input[@id='email']")).sendKeys("");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("123456");
        driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
        String getTextEmail = driver.findElement(By.xpath("//div[@class='alert alert-danger text-center']")).getText();
        Assert.assertEquals(getTextEmail, "The Email Address field is required.");
    }

    @Test(priority = 2)
    public void validateEmailWrong() {
        driver.get("https://crm.anhtester.com/admin/authentication");
        driver.findElement(By.xpath("//input[@id='email']")).sendKeys("admi@example.com");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("123456");
        driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
        String getTextEmail = driver.findElement(By.xpath("//div[@class='text-center alert alert-danger']")).getText();
        Assert.assertEquals(getTextEmail, "Invalid email or password");
    }

    @Test(priority = 3)
    public void validatePassNull() {
        driver.get("https://crm.anhtester.com/admin/authentication");
        driver.findElement(By.xpath("//input[@id='email']")).sendKeys("admin@example.com");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("");
        driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
        String getTextError = driver.findElement(By.xpath("//div[@class='alert alert-danger text-center']")).getText();
        Assert.assertEquals(getTextError, "The Password field is required.");
    }
    @Test(priority = 4)
    public void validatePassWrong() {
        driver.get("https://crm.anhtester.com/admin/authentication");
        driver.findElement(By.xpath("//input[@id='email']")).sendKeys("admin@example.com");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("12345");
        driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
        String checkPass = driver.findElement(By.xpath("//div[@class='text-center alert alert-danger']")).getText();
        Assert.assertEquals(checkPass,"Invalid email or password");
    }

    @Test(priority = 5)
    public void validateEmailPassNull() {
        driver.get("https://crm.anhtester.com/admin/authentication");
        driver.findElement(By.xpath("//input[@id='email']")).sendKeys("");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("");
        driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
        String checkEmail = driver.findElement(By.xpath("//div[normalize-space()='The Password field is required.']")).getText();
        String checkPass = driver.findElement(By.xpath("//div[normalize-space()='The Email Address field is required.']")).getText();
        Assert.assertEquals(checkEmail,"The Password field is required.","Password không đc để trống");
        Assert.assertEquals(checkPass,"The Email Address field is required.","Email không đc để trống");
    }

    @Test(priority = 6)
    public void loginCRMSuccess() {
        driver.get("https://crm.anhtester.com/admin/authentication");
        driver.findElement(By.xpath("//input[@id='email']")).sendKeys("admin@example.com");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("123456");
        driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
        String checkDashboard = driver.findElement(By.xpath("//div[@class='screen-options-btn']")).getText();
        Assert.assertEquals(checkDashboard,"Dashboard Options");
    }
    private String companyName = "CMC Global";
    private String website = "https://cmcglobal.com.vn/vi/home-vi/";
    @Test(priority = 7)
    public void addCustomer() {

        waitForPageLoaded(driver);
        driver.findElement(By.xpath("//a[@href='https://crm.anhtester.com/admin/clients']")).click();
        String checkTitlePageCustomer = driver.findElement(By.xpath("//span[normalize-space()='Customers Summary']")).getText();
        Assert.assertEquals(checkTitlePageCustomer,"Customers Summary","FAIL. Not page Customer!");

        waitForPageLoaded(driver);
        driver.findElement(By.xpath("//a[normalize-space()='New Customer']")).click();
        waitForPageLoaded(driver);
        driver.findElement(By.xpath("//input[@id='company']")).sendKeys(companyName);


        driver.findElement(By.xpath("//input[@id='vat']")).sendKeys("1000");
        driver.findElement(By.xpath("//input[@id='phonenumber']")).sendKeys("0965339606");
        driver.findElement(By.xpath("//input[@id='website']")).sendKeys(website);
        driver.findElement(By.xpath("//label[@for='groups_in[]']/following-sibling::div")).click();
//        driver.findElement(By.xpath("")).sendKeys("");
//        driver.findElement(By.xpath("")).sendKeys("");
//        driver.findElement(By.xpath("")).sendKeys("");
    }

//    @Test(priority = 8)
//    public void checkLoginSuccess() {
//
//    }
}
