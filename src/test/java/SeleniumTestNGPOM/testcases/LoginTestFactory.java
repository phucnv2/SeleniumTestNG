package SeleniumTestNGPOM.testcases;

import SeleniumTestNGPOM.common.BaseTest;
import SeleniumTestNGPOM.pages.login.LoginPageFactory;
import org.testng.annotations.Test;

public class LoginTestFactory extends BaseTest {
    LoginPageFactory loginPageFactory;
    @Test
    public void testLoginSuccess(){
        loginPageFactory = new LoginPageFactory(driver);
        loginPageFactory.login("admin@example.com","123456");
    }
}
