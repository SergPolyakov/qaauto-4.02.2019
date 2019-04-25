package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import page.LoginPage;

/**
 * Parent class for every test class.
 */
public class BaseTest {
    private WebDriver driver;
    protected LoginPage loginPage;

    /**
     * Before tests method to launch browser, go to "https://www.linkedin.com" and create new LoginPage.
     */
    @BeforeMethod
    public  void beforeMethod() {
        System.setProperty("webdriver.chrome.driver", "C:/MyDrivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.linkedin.com");

        loginPage = new LoginPage(driver);
    }

    /**
     * After tests method to close browser.
     */
    @AfterMethod
    public  void afterMethod() {
        driver.quit();
    }
}
