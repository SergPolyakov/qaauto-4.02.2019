import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LinkedinLoginTest {

    @Test
    public void successfulLoginTest() {

        System.setProperty("webdriver.chrome.driver", "C:/MyDrivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.linkedin.com");

        LoginPage loginPage = new LoginPage(driver);
        Assert.assertTrue(loginPage.isPageLoaded(),
                "Login page was not loaded");

        loginPage.login("testerok111333@gmail.com", "111333");

        HomePage homePage = new HomePage(driver);
        Assert.assertTrue(homePage.isPageLoaded(),
                "Home page is not loaded");

        driver.quit();

    }

    @Test
    public void emptyEmailField() {
        System.setProperty("webdriver.chrome.driver", "C:/MyDrivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.linkedin.com");

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("", "111333");

        Assert.assertTrue(loginPage.isPageLoaded(),
                "User logged in with an empty login field!");

        driver.quit();

    }

    @Test
    public void incorrectPassword() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:/MyDrivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.linkedin.com");

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("testerok111333@gmail.com", "qwerty");

        LoginSubmitPage forgotPassPage = new LoginSubmitPage(driver);
        Assert.assertTrue(forgotPassPage.isPageLoaded(),
                "Forgot password page is not loaded!");

        Thread.sleep(1000);

        driver.quit();
    }

}
