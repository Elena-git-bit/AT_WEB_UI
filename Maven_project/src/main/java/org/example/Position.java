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

public class Position {
           public static void main( String[] args )
        {
//предусловие: авторизация.
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();

            options.addArguments("--incognito")
                    .addArguments("start-maximized");
            WebDriver driver = new ChromeDriver(options);

            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3) ); //(3, TimeUnit.SECONDS);  //(Duration.ofSeconds(3) );

            driver.get("https://www.kommersant.ru/lk/login");
            WebElement login = driver.findElement(By.xpath("//input[@id=\"email\"]"));
            new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOf(login));
            login.click();
            login.sendKeys("a.ina@mail.ru");
            WebElement password = driver.findElement(By.xpath("//input[@id=\"password\"]"));
            password.click();
            password.sendKeys("666666");
            driver.findElement(By.xpath("//button[@type=\"submit\"]")).click();
            new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@class=\"lk\"]"))));

//основной тест. Проверка изменения должности. Необходимо убрать прежнюю должность и ввести новую.
            driver.findElement(By.xpath("//div[contains(@class, 'hide_mobile')]//span[.='Настройки профиля']")).click();
            driver.findElement(By.xpath("//input[@name=\"Position\"]")).clear();
            driver.findElement(By.xpath("//input[@name=\"Position\"]")).sendKeys("Директор");

            driver.quit();
        }
    }

