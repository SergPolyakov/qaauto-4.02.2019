package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FindAccountPage {
    private WebDriver driver;

    @FindBy(xpath = "//header[@class='content__header']")
    private WebElement MessageafterSendLink;


    public FindAccountPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean isPageLoaded() {
        return MessageafterSendLink.isDisplayed();
    }
}
