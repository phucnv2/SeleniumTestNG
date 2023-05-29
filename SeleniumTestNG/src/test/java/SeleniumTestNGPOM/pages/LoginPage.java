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

    By messEmailNull = By.xpath("//div[normalize-space()='The Email Address field is required.']");
    By messPasswordNull = By.xpath("//div[normalize-space()='The Password field is required.']");


    // hàm xây dưng để truyền driver


    public LoginPage(WebDriver _driver) {
        driver = _driver;
    }

    //hàm xử lí cho login
    public void verifyHeaderPage() {
        Assert.assertEquals(driver.findElement(headerPage).getText(), "Login", "Fail!");
    }

    // cái này để thực hiện truyền text và click thôi
    public void inputValueEmailPassword(String email, String password) {
        driver.findElement(inputEmail).sendKeys(email);
        driver.findElement(inputPassword).sendKeys(password);
        driver.findElement(buttonLogin).click();
    }

    // check Err message null
    public void checkErrorMessageEmailNull() {
        Assert.assertTrue(driver.findElement(messageErrorNull).isDisplayed(), "Fail!");
        Assert.assertEquals(driver.findElement(messageErrorNull).getText(), "The Email Address field is required.", "Fail!");
    }

    public void checkErrorMessagePasswordNull() {
        Assert.assertTrue(driver.findElement(messageErrorNull).isDisplayed(), "Fail!");
        Assert.assertEquals(driver.findElement(messageErrorNull).getText(), "The Password field is required.", "Fail!");
    }

    public void checkErrorMessageEmailAndPasswordNull() {
        Assert.assertTrue(driver.findElement(messEmailNull).isDisplayed(), "Fail!");
        Assert.assertTrue(driver.findElement(messPasswordNull).isDisplayed(), "Fail!");
        Assert.assertEquals(driver.findElement(messPasswordNull).getText(), "The Password field is required.", "Fail!");
        Assert.assertEquals(driver.findElement(messEmailNull).getText(), "The Email Address field is required.", "Fail!");
    }

    // check Err message invalid
    public void checkErrorMessageInvalidDisplay() {
        Assert.assertTrue(driver.findElement(messageErrorInvalid).isDisplayed(), "Fail!");
        Assert.assertEquals(driver.findElement(messageErrorInvalid).getText(), "Invalid email or password", "Fail!");
    }

    public void pageLoginEmailInvalid(String email, String password) {
        driver.get(URL);
        verifyHeaderPage();
        inputValueEmailPassword(email, password);
        checkErrorMessageInvalidDisplay();
    }

    public void pageLoginPasswordInvalid(String email, String password) {
        driver.get(URL);
        verifyHeaderPage();
        inputValueEmailPassword(email, password);
        checkErrorMessageInvalidDisplay();
    }

    public void pageLoginEmailAndPasswordInvalid(String email, String password) {
        driver.get(URL);
        verifyHeaderPage();
        inputValueEmailPassword(email, password);
        checkErrorMessageInvalidDisplay();
    }

    public void pageLoginEmailNull(String email, String password) {
        driver.get(URL);
        verifyHeaderPage();
        inputValueEmailPassword(email, password);
        checkErrorMessageEmailNull();
    }

    public void pageLoginPasswordNull(String email, String password) {
        driver.get(URL);
        verifyHeaderPage();
        inputValueEmailPassword(email, password);
        checkErrorMessagePasswordNull();
    }

    public void pageLoginEmaiAndPasswordNull(String email, String password) {
        driver.get(URL);
        verifyHeaderPage();
        inputValueEmailPassword(email, password);
        checkErrorMessageEmailAndPasswordNull();
    }

    public void pageLoginSuccess(String email, String password) {
        driver.get(URL);
        verifyHeaderPage();
        inputValueEmailPassword(email, password);
    }
}
