package SeleniumTestNGPOM.pages.login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageFactory {
    private String PAGE_URL = "https://crm.anhtester.com/admin/authentication";
    private String PAGE_TEXT = "Login";

    //Khai báo object - là đối tượng WenElement
    @FindBy(xpath = "//input[@id='email']")
    private WebElement inputEmail;

    @FindBy(xpath = "//input[@id='password']")
    private WebElement inputPassword;

    @FindBy(xpath = "//button[normalize-space()='Login']")
    private WebElement buttonLogin;
    @FindBy(xpath = "//h1")
    private WebElement headerTitle;

    //khai bao ham xay dung
    private WebDriver driver;

    public LoginPageFactory(WebDriver _driver) {
        driver = _driver;
    // goi ham initElement cua class PageFactory de khoi tao cac WebElement treen
        PageFactory.initElements(driver, this);
    }

    // viet cac ham xu li

    // dung ham trung gian cung duoc
    public void pageURL(){
        driver.get(PAGE_URL);
    }
    public void inputValueEmailPassword(String email, String password) {
        inputEmail.sendKeys(email);
        inputPassword.sendKeys(password);
        buttonLogin.click();
    }

    public void login(String email, String pass) {
//        driver.get(PAGE_URL);
        pageURL();
//        inputEmail.sendKeys(email);
//        inputPassword.sendKeys(pass);
//        buttonLogin.click();
        inputValueEmailPassword(email, pass);
    }
}
