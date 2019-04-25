package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewPasswordPage {
    private WebDriver driver;

    @FindBy(xpath = "//input[@id='newPassword']")
    private WebElement fieldOneNewUserPassword;

    @FindBy(xpath = "//input[@id='confirmPassword']")
    private WebElement fieldTwoNewUserPassword;

    @FindBy(xpath = "//button[@id='reset-password-submit-button']")
    private WebElement resetPasswordSubmitButton;

    public NewPasswordPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean isPageLoaded() {
        return driver.getTitle().contains("Изменить пароль");
    }

    public HomePage enterNewPassword(String newUserPassword) {
        fieldOneNewUserPassword.sendKeys(newUserPassword);
        fieldTwoNewUserPassword.sendKeys(newUserPassword);
        resetPasswordSubmitButton.click();
        return new HomePage(driver);



    }
}
