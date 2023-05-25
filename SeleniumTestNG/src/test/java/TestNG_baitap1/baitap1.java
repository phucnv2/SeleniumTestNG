package TestNG_baitap1;

import TestNG_baitap1.baseTest.Common;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class baitap1 extends Common {
    @Test(priority = 1)
    public void loginCMS(){
        driver.get("https://rise.fairsketch.com/");
        WebElement inputEmail = driver.findElement(By.xpath("//input[@id='email']"));
        inputEmail.clear();
        inputEmail.click();
        inputEmail.sendKeys("admin@demo.com");
        WebElement inputPassword = driver.findElement(By.xpath("//input[@id='password']"));
        inputPassword.clear();
        inputPassword.click();
        inputPassword.sendKeys("riseDemo");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
    }
    @Test(priority = 2)
    public void addCategory(){
        driver.findElement(By.xpath("//span[normalize-space()='Clients']")).click();
        sleep(1);
        driver.findElement(By.xpath("//a[contains(text(),'Clients')]")).click();
        driver.findElement(By.xpath("//a[normalize-space()='Add client']")).click();
        sleep(2);
        driver.findElement(By.xpath("//input[@id='company_name']")).sendKeys("Phuc NA");
        driver.findElement(By.xpath("//div[@id='s2id_created_by']//a")).click();
        driver.findElement(By.xpath("//div[@id='select2-drop']//input")).sendKeys("Michael Wood", Keys.ENTER);
        driver.findElement(By.xpath("//textarea[@id='address']")).sendKeys("Phúc test");
        driver.findElement(By.xpath("//input[@id='city']")).sendKeys("Phúc test");
        driver.findElement(By.xpath("//input[@id='state']")).sendKeys("Phúc test");
        driver.findElement(By.xpath("//input[@id='zip']")).sendKeys("Phúc test");
        driver.findElement(By.xpath("//input[@id='country']")).sendKeys("Phúc test");
        driver.findElement(By.xpath("//input[@id='phone']")).sendKeys("0965330909");
        driver.findElement(By.xpath("//input[@id='website']")).sendKeys("phuc.com");
        driver.findElement(By.xpath("//input[@id='vat_number']")).sendKeys("Phúc test");
        driver.findElement(By.xpath("//input[@id='gst_number']")).sendKeys("Phúc test");
        driver.findElement(By.xpath("//li[@class='select2-search-field']//input")).click();
        driver.findElement(By.xpath("//li[@class='select2-search-field']//input")).sendKeys("VIP",Keys.ENTER);

        // scroll xuống dưới
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(false);",driver.findElement(By.xpath("//label[normalize-space()='Disable online payment']")));


        driver.findElement(By.xpath("//div[@id='s2id_currency']")).click();
        driver.findElement(By.xpath("//div[@id='select2-drop']//div[@class='select2-search']//input")).sendKeys("XTS",Keys.ENTER);

//        driver.findElement(By.xpath("//button[@type='submit']")).click();

    }
}
