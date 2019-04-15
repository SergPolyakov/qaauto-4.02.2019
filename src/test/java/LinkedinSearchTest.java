import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LinkedinSearchTest {

    WebDriver driver;
    LoginPage loginPage;

    @BeforeMethod
    public  void beforeMethod() {
        System.setProperty("webdriver.chrome.driver", "C:/MyDrivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.linkedin.com");

        loginPage = new LoginPage(driver);
    }

    @AfterMethod
    public  void afterMethod() {
        driver.quit();
    }

    @DataProvider
    public Object[][] validLoginDataProvider() {
        return new Object[][]{
                { "testerok111333@gmail.com", "111333", "HR" }

        };
    }

    @Test(dataProvider = "validLoginDataProvider")
    public void basicSearchTest(String userEmail,
                                String userPassword,
                                String searchText) throws InterruptedException {

        Assert.assertTrue(loginPage.isPageLoaded(),
                "Login page was not loaded");

        HomePage homePage = loginPage.login(userEmail, userPassword);
        SearchResultPage searchResultPage = homePage.Search(searchText);

        Thread.sleep(3000);

        Assert.assertTrue(searchResultPage.isSearchResultPageLoaded(),"Search result page was not loaded");

        int numberOfSearchResults = driver.findElements(By.xpath("//*[@class='search-result__title t-16 t-black t-bold']")).size();
        Assert.assertEquals(numberOfSearchResults, 10, "The number of search results on the page is less than 10!");

        Assert.assertTrue(searchResultPage.foundResultsContainsHR("HR"), "Results not contains text 'HR'");

    }
}
