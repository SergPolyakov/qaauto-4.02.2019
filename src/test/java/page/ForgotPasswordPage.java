package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ForgotPasswordPage {
    private WebDriver driver;

    @FindBy(xpath = "//button[@id='reset-password-submit-button']")
    private WebElement resetPasswordSubmitButton;

    @FindBy(xpath = "//input[@id='username']")
    private WebElement userEmailField;

    public ForgotPasswordPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean isPageLoaded() {
        return resetPasswordSubmitButton.isDisplayed();
    }

    public FindAccountPage findAccount(String userEmail){
        userEmailField.sendKeys(userEmail);
        resetPasswordSubmitButton.click();
        return new FindAccountPage(driver);

    }


}
