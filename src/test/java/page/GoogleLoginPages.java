package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GoogleLoginPages {
    private WebDriver driver;

    @FindBy(id = "identifierId")
    private WebElement emailField;

    @FindBy(xpath = "//*[@id='identifierNext']/content/span")
    private WebElement emailNextButton;

    @FindBy(xpath = "//input[@name='password']")
    private WebElement passwordField;

    @FindBy(xpath = "//*[@id='passwordNext']/content/span")
    private WebElement passwordNextButton;

    public GoogleLoginPages(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    public GoogleHomePage login(String userEmail, String googlePassword) throws InterruptedException {
        emailField.sendKeys(userEmail);
        emailNextButton.click();
        Thread.sleep(3000);
        passwordField.sendKeys(googlePassword);
        passwordNextButton.click();
        return new GoogleHomePage(driver);

    }
}
