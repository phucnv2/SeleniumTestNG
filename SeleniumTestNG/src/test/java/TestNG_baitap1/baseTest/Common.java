package TestNG_baitap1.baseTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.time.Duration;

public class Common {
    public WebDriver driver;

    @BeforeTest
    public void createDriver() {
        //WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
    }
    public static void sleep(double seconds) {
        try {
            Thread.sleep((long) (1000*seconds));
        }catch (InterruptedException e){
            throw new RuntimeException(e);
        }

    }
    @AfterTest
    public void closeDriver() {
        driver.quit();
    }
}
