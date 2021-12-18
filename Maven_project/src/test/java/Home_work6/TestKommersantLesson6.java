package Home_work6;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class TestKommersantLesson6 {

    static WebDriver driver;
    static ChromeOptions options;
    static PageOfAuthorization auPage;
    static Personal pers;
    static Profile prof;

    @BeforeAll
    static void precondition() {
        WebDriverManager.chromedriver().setup();
        options = new ChromeOptions();

        options.addArguments("--incognito")
                .addArguments("start-maximized");
    }

    @BeforeEach
    void setupDriver() {
        driver = new ChromeDriver(options);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3) ); //(3, TimeUnit.SECONDS);  //(Duration.ofSeconds(3) );

    }

    @Test
    void authorization () {
        driver.get("https://www.kommersant.ru/lk/login");
        auPage = new PageOfAuthorization(driver);
        pers = auPage.loginFill("a.ina@mail.ru").passwordFill("666666").enter();
        Assertions.assertEquals(pers.getProfileName().getText(),"666666");
    }

    @Test
    void position(){
        //предусловие
        driver.get("https://www.kommersant.ru/lk/login");
        auPage = new PageOfAuthorization(driver);
        pers = auPage.loginFill("a.ina@mail.ru").passwordFill("666666").enter();
        Assertions.assertEquals(pers.getProfileName().getText(),"666666");

        prof = pers.ProfileSet();
        prof.newPosition("Директор").goToBack();

        Assertions.assertEquals( pers.getPosition().getText(),"Директор");

    }








    @AfterEach
    void postcondition () {
        driver.quit();
    }

}
