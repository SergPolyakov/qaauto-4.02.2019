package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GmailPage {
    private WebDriver driver;

    @FindBy(xpath = "//div[@class = 'UI']//div[contains(@id, ':dg')]")
    private WebElement likedinMessage;

    @FindBy(xpath = "//div[@role='main']//a[contains(@href, 'checkpoint-password-reset')]")
    private  WebElement linkToChangePass;

    public GmailPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    public boolean isPageLoaded() {
        return driver.getTitle().contains("Входящие");

    }

    public NewPasswordPage clickLinkInLetter() throws InterruptedException {
        Thread.sleep(3000);
        likedinMessage.click();
        Thread.sleep(3000);
        linkToChangePass.click();
        return new NewPasswordPage(driver);

    }
}
