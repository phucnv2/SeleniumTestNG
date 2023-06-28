package keyword;

import com.ibm.icu.impl.Assert;
import io.appium.java_client.functions.ExpectedCondition;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class WebUI {
    public static WebDriver driver;

    public WebUI(WebDriver _driver) {
        driver = _driver;
    }

    public static void openURL(String URL){
        driver.get(URL);
        waitForPageLoaded();
    }
    public static String getCurrentUrl(){
        return driver.getCurrentUrl();
    }
    public static WebElement getWebElement(By by){
        return driver.findElement(by);
    }
    public static void clickElement(By by){
        getWebElement(by).click();
    }
    public static void senkeyText(By by,String value){
        getWebElement(by).sendKeys(value);
    }
    public static String getTextElement(By by) {
        return getWebElement(by).getText();
    }
    public static String getAttribute(By by,String attributeName){
        return getWebElement(by).getAttribute(attributeName);
    }

    public static void scrollToElement(By by){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", getWebElement(by));
    }

    public static void sleep(double seconds) {
        try {
            Thread.sleep((long) (1000*seconds));
        }catch (InterruptedException e){
            throw new RuntimeException(e);
        }

    }
    public static void waitForElementVisible(By by, int second) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(second), Duration.ofMillis(500));

        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public static void waitForElementPresent(By by, int second) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(second));

        wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public static void waitForElementClickable(By by, int second) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(second));

        wait.until(ExpectedConditions.elementToBeClickable(by));
    }

    public static Boolean checkElementExist(By by) {
        List<WebElement> listElement = driver.findElements(by);

        if (listElement.size() > 0) {
            System.out.println("Element " + by + " existing.");
            return true;
        } else {
            System.out.println("Element " + by + " NOT exist.");
            return false;
        }
    }

    public static Boolean checkElementExist(String xpath) {
        List<WebElement> listElement = driver.findElements(By.xpath(xpath));

        if (listElement.size() > 0) {
            System.out.println("Element " + xpath + " existing.");
            return true;
        } else {
            System.out.println("Element " + xpath + " NOT exist.");
            return false;
        }
    }
    /**
     * Wait for Page loaded
     * Chờ đợi trang tải xong (Javascript tải xong)
     */
    public static void waitForPageLoaded() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30), Duration.ofMillis(500));
        JavascriptExecutor js = (JavascriptExecutor) driver;

        //Wait for Javascript to load
        ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver webDriver) {
                return js.executeScript("return document.readyState").toString().equals("complete");
            }
        };

        //Check JS is Ready
        boolean jsReady = js.executeScript("return document.readyState").toString().equals("complete");

        //Wait Javascript until it is Ready!
        if (!jsReady) {
            System.out.println("Javascript is NOT Ready.");
            //Wait for Javascript to load
            try {
                wait.until(jsLoad);
            } catch (Throwable error) {
                error.printStackTrace();
                Assert.fail("FAILED. Timeout waiting for page load.");
            }
        }
    }
}
