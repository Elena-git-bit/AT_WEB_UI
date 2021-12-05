package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;


public class App 
{
    public static void main( String[] args )
    {

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();

        options.addArguments("--incognito")
                .addArguments("start-maximized");
        WebDriver driver = new ChromeDriver(options);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3) ); //(3, TimeUnit.SECONDS);  //(Duration.ofSeconds(3) );

        driver.get("https://www.kommersant.ru/lk/login");


        WebElement login = driver.findElement(By.xpath("//input[@id=\"email\"]"));
        new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOf(login));
        login.click();
        login.sendKeys("a.ina@mail.ru");
        WebElement password = driver.findElement(By.xpath("//input[@id=\"password\"]"));
        password.click();
        password.sendKeys("666666");

        driver.findElement(By.xpath("//button[@type=\"submit\"]")).click();

        // Устанавливаем паузу 10 секунд
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        driver.quit();
    }
}
