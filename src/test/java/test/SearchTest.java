package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import page.HomePage;
import page.SearchResultPage;

import java.util.List;

/**
 * Basic search test class.
 */
public class SearchTest extends BaseTest {


    /**
     * Basic test of the search function with checking the number of search results and the presence of the search text in the results
     */
    @Test
    public void basicSearchTest() {
        String userEmail = "lua@meta.ua";
        String userPassword = "111333";
        String searchTerm = "HR";

        Assert.assertTrue(loginPage.isPageLoaded(),
                "Login page was not loaded");

        HomePage homePage = loginPage.login(userEmail, userPassword);

        Assert.assertTrue(homePage.isPageLoaded(),
                "Home page is not loaded");

        SearchResultPage searchResultPage = homePage.search(searchTerm);

        Assert.assertTrue(searchResultPage.isPageLoaded(),
                "page.SearchResultPage is not loaded");

        Assert.assertEquals(searchResultPage.getSearchResultsCount(), 10,
                "Results count is wrong!");

        List<String> searchResults = searchResultPage.getSearchResult();

        for (String searchResult : searchResults) {
            Assert.assertTrue(searchResult.contains(searchTerm),
                    "SearchTerm: " +searchTerm+ " not found in:  \n" +searchResult);
        }

    }
}
