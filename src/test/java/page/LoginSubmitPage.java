package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * PageObject class for loginSubmitPage.
 */
public class LoginSubmitPage extends BasePage {

    @FindBy(xpath = "//form[@action='/checkpoint/lg/login-submit']")
    private WebElement loginSubmitForm;

    @FindBy(xpath = "//div[@id='error-for-username']")
    private WebElement userEmailValidationMessage;

    @FindBy(xpath = "//div[@id='error-for-password']")
    private WebElement userPasswordValidationMessage;


    /**
     * Constructor of LoginSubmitPage object.
     * @param driver Webdriver instance from baseTest.
     */
    public LoginSubmitPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    /**
     * Method to check if page was loaded.
     * @return true/false if page was loaded or not.
     */
    public boolean isPageLoaded() {
        return loginSubmitForm.isDisplayed();
    }

    /**
     * Method to get text from EmailValidationMessage.
     * @return text from EmailValidationMessage.
     */
    public String getUserEmailValidationMessage() {
            return userEmailValidationMessage.getText();
    }

    /**
     * Method to get text from PasswordValidationMessage.
     * @return text from PasswordValidationMessage.
     */
    public String getUserPasswordValidationMessage() {
        return userPasswordValidationMessage.getText();
    }
}
