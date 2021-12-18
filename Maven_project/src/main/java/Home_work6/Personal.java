package Home_work6;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Personal extends AbstractPage {
    @FindBy(xpath = "//div[contains(@class, 'hide_mobile')]//span[.='Настройки профиля']")
    private WebElement ProfileSetButton;

    @FindBy(xpath = "//div[@class=\"lk\"]//h1")
    private WebElement profileName;

    @FindBy(xpath = "//p[contains(., 'Должность:')]/span")
    private WebElement position;


    public Personal(WebDriver driver) {
        super(driver);
    }

    public Profile ProfileSet()  {
        ProfileSetButton.click();
        Profile profilePage = new Profile(getDriver());
        return profilePage;

    }

    public WebElement getPosition() {
        return position;
    }

    public WebElement getProfileName() {
        return profileName;
    }
}
