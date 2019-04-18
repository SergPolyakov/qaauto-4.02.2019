import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class SearchTest {

    WebDriver driver;
    LoginPage loginPage;

    @BeforeMethod
    public void beforeMethod() {
        System.setProperty("webdriver.chrome.driver", "C:/MyDrivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.linkedin.com");

        loginPage = new LoginPage(driver);
    }

    @AfterMethod
    public void afterMethod() {
        driver.quit();
    }

    @Test
    public void basicSearchTest() {
        String userEmail = "testerok111333@gmail.com";
        String userPassword = "111333";
        String searchTerm = "HR";

        Assert.assertTrue(loginPage.isPageLoaded(),
                "Login page was not loaded");

        HomePage homePage = loginPage.login(userEmail, userPassword);

        Assert.assertTrue(homePage.isPageLoaded(),
                "Home page is not loaded");

        SearchResultPage searchResultPage = homePage.search(searchTerm);

        Assert.assertTrue(searchResultPage.isPageLoaded(),
                "SearchResultPage is not loaded");

        Assert.assertEquals(searchResultPage.getSearchResultsCount(), 10,
                "Results count is wrong!");

        List<String> searchResults = searchResultPage.getSearchResult();

        for (String searchResult : searchResults) {
            Assert.assertTrue(searchResult.contains(searchTerm),
                    "SearchTerm: " +searchTerm+ " not found in:  \n" +searchResult);
        }



    }
}
