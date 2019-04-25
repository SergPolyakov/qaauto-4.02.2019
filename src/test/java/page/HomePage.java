package page;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static java.lang.Thread.sleep;

/**
 * PageObject class for homePage.
 */
public class HomePage extends BasePage {


    @FindBy(xpath = "//li[@id='profile-nav-item']")
    private WebElement profileNavigationItem;

    @FindBy(xpath = "//form[@id='extended-nav-search']//input")
    private WebElement searchField;

    /**
     * Constructor of HomePage object.
     * @param driver Webdriver instance from baseTest.
     */
    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    /**
     * Method to enter search term in the search field and press enter button.
     * @param searchTerm - text to be entered in the search field.
     * @return New SearchResult page.
     */
    public SearchResultPage search(String searchTerm){
        searchField.sendKeys(searchTerm);
        searchField.sendKeys(Keys.ENTER);
        try {
            sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new SearchResultPage(driver);
    }

    /**
     * Method to check if page was loaded.
     * @return true/false if page was loaded or not.
     */
    public boolean isPageLoaded() {
        return profileNavigationItem.isDisplayed()
                && driver.getTitle().equals("LinkedIn");

            }
}
