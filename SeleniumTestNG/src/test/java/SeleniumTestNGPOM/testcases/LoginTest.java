package SeleniumTestNGPOM.testcases;

import SeleniumTestNGPOM.common.BaseTest;
import SeleniumTestNGPOM.pages.LoginPage;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {
    LoginPage loginPage; // khai báo loginPage từ package pages

    @Test(priority = 1)
    public void loginPageEmailInvalid() {
        loginPage = new LoginPage(driver);
        loginPage.pageLoginEmailInvalid("adminn@example.com", "123456");
    }
    @Test(priority = 2)
    public void loginPagePasswordInvalid() {
        loginPage = new LoginPage(driver);
        loginPage.pageLoginPasswordInvalid("admin@example.com", "12345");
    }
    @Test(priority = 3)
    public void pageLoginEmailAndPasswordInvalid() {
        loginPage = new LoginPage(driver);
        loginPage.pageLoginEmailAndPasswordInvalid("adminn@example.com", "12345");
    }
    @Test(priority = 4)
    public void pageLoginEmailNull() {
        loginPage = new LoginPage(driver);
        loginPage.pageLoginEmailNull("", "123456");
    }
    @Test(priority = 5)
    public void pageLoginPasswordNull() {
        loginPage = new LoginPage(driver);
        loginPage.pageLoginPasswordNull("admin@example.com", "");
    }
    @Test(priority = 6)
    public void pageLoginEmailAndPasswordNull() {
        loginPage = new LoginPage(driver);
        loginPage.pageLoginEmaiAndPasswordNull("", "");
    }
    @Test(priority = 7)
    public void loginPageSuccess() {
        //Khởi tạo đối tượng từ trang login
        // truyền driver từ BaseTest
        loginPage = new LoginPage(driver);
        // gọi hàm login để dùng
        loginPage.pageLoginSuccess("admin@example.com", "123456");
    }
}
