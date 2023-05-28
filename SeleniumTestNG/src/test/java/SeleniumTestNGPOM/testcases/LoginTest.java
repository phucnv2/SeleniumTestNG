package SeleniumTestNGPOM.testcases;

import SeleniumTestNGPOM.common.BaseTest;
import SeleniumTestNGPOM.pages.LoginPage;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {
    LoginPage loginPage; // khai báo loginPage từ package pages

    @Test
    public void loginPageSuccess() {
        //Khởi tạo đối tượng từ trang login
        // truyền driver từ BaseTest
        loginPage = new LoginPage(driver);

        // gọi hàm login để dùng

        loginPage.pageLogin("admin@example.com", "123456");
    }

    @Test
    public void loginPageEmailInvalid() {
        loginPage = new LoginPage(driver);
        loginPage.pageLoginEmailInvalid("adminn@example.com", "123456");
    }
}
