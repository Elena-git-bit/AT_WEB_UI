package Home_work6;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

public class PageOfAuthorization extends AbstractPage {
    @FindBy(xpath = "//input[@id=\"email\"]")
    private WebElement emailField;

    @FindBy(xpath = "//input[@id=\"password\"]")
    private WebElement passwordField;

    @FindBy(xpath = "//button[@type=\"submit\"]")
    private WebElement enterButton;

    public PageOfAuthorization(WebDriver driver) {
        super(driver);
    }
    // a.ina@mail.ru
    public PageOfAuthorization loginFill(String login){
        emailField.click();
        emailField.sendKeys(login);
        return this;
    }


    public PageOfAuthorization passwordFill(String password){
        passwordField.click();
        passwordField.sendKeys(password);
        return this;
    }

    public Personal enter() {
        enterButton.click();
        Personal personalPage = new Personal(getDriver());
        return personalPage;
    }


}
