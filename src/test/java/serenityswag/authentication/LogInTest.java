package serenityswag.authentication;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@RunWith(SerenityRunner.class)
public class LogInTest {

    @Managed
    WebDriver driver;

    @Test
    public void withStandardUserCredentials() {
        driver.get("https://www.saucedemo.com/");

        driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys("standard_user");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("secret_sauce");
        driver.findElement(By.xpath("//input[@id='login-button']")).click();

        String result = driver.findElement(By.xpath("//span[text()='Products']")).getText();
        Assert.assertEquals("PRODUCTS", result);
    }

}
