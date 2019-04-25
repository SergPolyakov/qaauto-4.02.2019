package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * PageObject class for loginPage.
 */
public class LoginPage extends BasePage {

    @FindBy(xpath = "//input[@id='login-email']")
    private WebElement emailField;

    @FindBy(xpath = "//input[@id='login-password']")
    private WebElement passwordField;

    @FindBy(xpath = "//input[@id='login-submit']")
    private WebElement signInButton;

    @FindBy(xpath = "//a[@class = 'link-forgot-password']")
    private WebElement forgotPasswordButton;


    /**
     * Constructor of LoginPage object.
     * @param driver Webdriver instance from baseTest.
     */
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    /**
     * Method to login in LinkedIn.
     * @param userEmail - user email for login in LinkedIn.
     * @param userPassword - user password for login in LinkedIn.
     * @param <GenericPage> - in the login method, checks the URL and, depending on the result, returns the corresponding page.
     * @return new HomePage or new LoginSubmitPage or new LoginPage.
     */
    public <GenericPage> GenericPage login(String userEmail, String userPassword) {
        emailField.sendKeys(userEmail);
        passwordField.sendKeys(userPassword);
        signInButton.click();
        if (driver.getCurrentUrl().contains("/feed")) {
            return (GenericPage) new HomePage(driver);
        } if (driver.getCurrentUrl().contains("/login-submit")) {
            return (GenericPage) new LoginSubmitPage(driver);
        } else {
            return (GenericPage) new LoginPage(driver);
        }
    }

    /**
     * Method to check if page was loaded.
     * @return true/false if page was loaded or not.
     */
    public boolean isPageLoaded() {
        return signInButton.isDisplayed();
    }

    /**
     * Method to click ForgotPassword button.
     * @return new ForgotPasswordPage.
     */
    public ForgotPasswordPage clickForgotPassButton() {
        forgotPasswordButton.click();
        return new ForgotPasswordPage(driver);

    }
}
