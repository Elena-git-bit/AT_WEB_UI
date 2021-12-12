package Home_work5;

import Home_work4.FunctionTriangle;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TestKommersant {

    static WebDriver driver;

    @BeforeAll
    static void precondition() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();

        options.addArguments("--incognito")
                .addArguments("start-maximized");
        driver = new ChromeDriver(options);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3) ); //(3, TimeUnit.SECONDS);  //(Duration.ofSeconds(3) );

    }

    @Test
    void authorization (){
        driver.get("https://www.kommersant.ru/lk/login");
        WebElement login = driver.findElement(By.xpath("//input[@id=\"email\"]"));
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOf(login));
        login.click();
        login.sendKeys("a.ina@mail.ru");
        WebElement password = driver.findElement(By.xpath("//input[@id=\"password\"]"));
        password.click();
        password.sendKeys("666666");

        driver.findElement(By.xpath("//button[@type=\"submit\"]")).click();
        WebElement result = driver.findElement(By.xpath("//div[@class=\"lk\"]//h1"));

        Assertions.assertEquals(result.getText(),"666666");
    }

    @Test
    void position (){
        //предусловие
        driver.get("https://www.kommersant.ru/lk/login");
        WebElement login = driver.findElement(By.xpath("//input[@id=\"email\"]"));
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOf(login));
        login.click();
        login.sendKeys("a.ina@mail.ru");
        WebElement password = driver.findElement(By.xpath("//input[@id=\"password\"]"));
        password.click();
        password.sendKeys("666666");

        driver.findElement(By.xpath("//button[@type=\"submit\"]")).click();
        WebElement result = driver.findElement(By.xpath("//div[@class=\"lk\"]//h1"));
        Assertions.assertEquals(result.getText(),"666666");

        driver.findElement(By.xpath("//div[contains(@class, 'hide_mobile')]//span[.='Настройки профиля']")).click();
        driver.findElement(By.xpath("//input[@name=\"Position\"]")).clear();
        driver.findElement(By.xpath("//input[@name=\"Position\"]")).sendKeys("Директор");
       // driver.findElement(By.xpath("//button[.='Сохранить настройки']")).click();
        driver.findElement(By.xpath("//div[contains(@class, 'hide_mobile')]//span[.='Мой профиль']")).click();
        WebElement result2 = driver.findElement(By.xpath("//p[contains(., 'Должность:')]/span"));
        Assertions.assertEquals(result2.getText(),"Директор");


    }



    @AfterEach
    void postcondition () {
        driver.quit();
    }

}
