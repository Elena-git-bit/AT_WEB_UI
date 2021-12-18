package Home_work6;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Profile extends PageOfAuthorization{

    @FindBy (xpath = "//input[@name=\"Position\"]")
    private WebElement positionField;

    @FindBy (xpath = "//div[contains(@class, 'hide_mobile')]//span[.='Мой профиль']")
    private  WebElement myProfileButton;


    public Profile(WebDriver driver) {
        super(driver);
    }

    public Profile newPosition(String position){

        positionField.clear();
        positionField.sendKeys(position);
        positionField.submit();
        return this;
    }


    public void goToBack() {
        myProfileButton.click();
//        Personal personalPage = new Personal(getDriver());
//        return personalPage;
    }

}
