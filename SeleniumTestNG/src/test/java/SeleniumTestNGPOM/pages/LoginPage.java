package SeleniumTestNGPOM.pages;

import org.testng.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private String URL = "https://crm.anhtester.com/admin/authentication";
    private String pageText = "Login";
    private WebDriver driver;

    //lưu Object của login. khai báo cái này để cho ngắn gọn và dễ chỉnh sửa. khai báo location
    By headerPage = By.xpath("//h1");
    By inputEmail = By.xpath("//input[@id='email']");
    By inputPassword = By.xpath("//input[@id='password']");
    By buttonLogin = By.xpath("//button[normalize-space()='Login']");
    By messageErrorNull = By.xpath("//div[@class='alert alert-danger text-center']");

    By messageErrorInvalid = By.xpath("//div[@class='text-center alert alert-danger']");


    // hàm xây dưng để truyền driver



    public LoginPage(WebDriver _driver) {
        driver = _driver;
    }

    //hàm xử lí cho login
    public void verifyHeaderPage() {
        Assert.assertEquals(driver.findElement(headerPage).getText(), "Login", "Fail!");
    }

    public void inputValueEmailPassword(String email, String password){
        driver.findElement(inputEmail).sendKeys(email);
        driver.findElement(inputPassword).sendKeys(password);
        driver.findElement(buttonLogin).click();
    }
    public void checkErrorMessageDisplay(){
        Assert.assertTrue(driver.findElement(messageErrorInvalid).isDisplayed(),"Fail!");
        Assert.assertEquals(driver.findElement(messageErrorInvalid).getText(),"Invalid email or password","Fail!");
    }
    public void pageLogin(String email,String password){
        driver.get(URL);
        verifyHeaderPage();
        inputValueEmailPassword(email,password);
    }

    public void pageLoginEmailInvalid(String email,String password){
        driver.get(URL);
        verifyHeaderPage();
        inputValueEmailPassword(email,password);
        checkErrorMessageDisplay();
    }
}
