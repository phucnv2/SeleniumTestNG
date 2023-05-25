package TestNG;

import TestNG_baitap1.baseTest.Common;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class RunTestNG extends Common {
    @Test
    public void testAnhTesterBlog() throws InterruptedException {
        driver.get("https://anhtester.com");
        driver.findElement(By.xpath("//a[normalize-space()='blog']")).click();
        Thread.sleep(2000);
    }
}
