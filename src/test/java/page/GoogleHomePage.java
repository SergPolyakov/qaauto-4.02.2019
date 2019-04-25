package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GoogleHomePage {
    private WebDriver driver;

    @FindBy(xpath = "//div[@class='gb_gf']")
    private WebElement googleAppButton;

    @FindBy(xpath = "//*[@id='gb23']/span[1]")
    private WebElement gmailButton;

    public GoogleHomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    public GmailPage goToGmail() throws InterruptedException {
        googleAppButton.click();
        Thread.sleep(2000);
        gmailButton.click();
        return new GmailPage(driver);

    }
}
