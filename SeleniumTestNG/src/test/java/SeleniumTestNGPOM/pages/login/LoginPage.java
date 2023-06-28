package SeleniumTestNGPOM.pages.login;

import SeleniumTestNGPOM.common.BaseTest;
import SeleniumTestNGPOM.pages.DashboardPage;
import keyword.WebUI;
import static keyword.WebUI.*;
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
        new WebUI(driver);
    }

    //hàm xử lí cho login
    public void verifyHeaderPage() {
        Assert.assertEquals(getTextElement(headerPage), "Login", "Fail!");
    }

    // cái này để thực hiện truyền text và click thôi
    public void inputValueEmailPassword(String email, String password) {
        senkeyText(inputEmail,email);
        senkeyText(inputPassword,password);
        clickElement(buttonLogin);
    }

    // check Err message null
    public void checkErrorMessageEmailNull() {
        Assert.assertTrue(driver.findElement(messageErrorNull).isDisplayed(), "Fail!");
        Assert.assertEquals(getTextElement(messageErrorNull), "The Email Address field is required.", "Fail!");
    }

    public void checkErrorMessagePasswordNull() {
        Assert.assertTrue(driver.findElement(messageErrorNull).isDisplayed(), "Fail!");
        Assert.assertEquals(getTextElement(messageErrorNull), "The Password field is required.", "Fail!");
    }

    public void checkErrorMessageEmailAndPasswordNull() {
        Assert.assertTrue(driver.findElement(messEmailNull).isDisplayed(), "Fail!");
        Assert.assertTrue(driver.findElement(messPasswordNull).isDisplayed(), "Fail!");
        Assert.assertEquals(getTextElement(messPasswordNull), "The Password field is required.", "Fail!");
        Assert.assertEquals(getTextElement(messEmailNull), "The Email Address field is required.", "Fail!");
    }

    // check Err message invalid
    public void checkErrorMessageInvalidDisplay() {
        Assert.assertTrue(driver.findElement(messageErrorInvalid).isDisplayed(), "Fail!");
        Assert.assertEquals(getTextElement(messageErrorInvalid), "Invalid email or password", "Fail!");
    }

    public void pageLoginEmailInvalid(String email, String password) {
        openURL(URL);
        verifyHeaderPage();
        inputValueEmailPassword(email, password);
        checkErrorMessageInvalidDisplay();
    }

    public void pageLoginPasswordInvalid(String email, String password) {
        openURL(URL);
        verifyHeaderPage();
        inputValueEmailPassword(email, password);
        checkErrorMessageInvalidDisplay();
    }

    public void pageLoginEmailAndPasswordInvalid(String email, String password) {
        openURL(URL);
        verifyHeaderPage();
        inputValueEmailPassword(email, password);
        checkErrorMessageInvalidDisplay();
    }

    public void pageLoginEmailNull(String email, String password) {
        openURL(URL);
        verifyHeaderPage();
        inputValueEmailPassword(email, password);
        checkErrorMessageEmailNull();
    }

    public void pageLoginPasswordNull(String email, String password) {
        openURL(URL);
        verifyHeaderPage();
        inputValueEmailPassword(email, password);
        checkErrorMessagePasswordNull();
    }

    public void pageLoginEmaiAndPasswordNull(String email, String password) {
        openURL(URL);
        verifyHeaderPage();
        inputValueEmailPassword(email, password);
        checkErrorMessageEmailAndPasswordNull();
    }

    public DashboardPage pageLoginSuccess(String email, String password) {
        openURL(URL);
        verifyHeaderPage();
        inputValueEmailPassword(email, password);
        return new DashboardPage(driver);
    }
}
