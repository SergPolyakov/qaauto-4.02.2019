import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SuccessfulPasswordResetTest {
    WebDriver driver;
    LoginPage loginPage;
    GoogleLoginPages googleLoginPage;

    @BeforeMethod
    public void beforeMethod() {
        System.setProperty("webdriver.chrome.driver", "C:/MyDrivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.linkedin.com");

        loginPage = new LoginPage(driver);
        driver.manage().window().maximize();
    }
    @Test
    public  void PasswordResetTest () throws InterruptedException {
        String userEmail = "reabilitolog1988@gmail.com";
        String googlePassword = "stsvadba05102013";
        String newUserPassword = "tolik111333";

        Assert.assertTrue(loginPage.isPageLoaded(),
                "Login page was not loaded");

        ForgotPasswordPage forgotPasswordPage = loginPage.clickForgotPassButton();

        Assert.assertTrue(forgotPasswordPage.isPageLoaded(),
                "ForgotPasswordPage is not loaded!");

        FindAccountPage findAccountPage = forgotPasswordPage.findAccount(userEmail);

        Assert.assertTrue(findAccountPage.isPageLoaded(),
                "FindAccountPage is not loaded!");

        driver.get("https://accounts.google.com");

        googleLoginPage = new GoogleLoginPages(driver);

        GoogleHomePage googleHomePage = googleLoginPage.login(userEmail, googlePassword);

        Thread.sleep(3000);

        GmailPage gmailPage = googleHomePage.goToGmail();

        Assert.assertTrue(gmailPage.isPageLoaded(),
                "GmailPage is not loaded!");

        NewPasswordPage newPasswordPage = gmailPage.clickLinkInLetter();

        Assert.assertTrue(newPasswordPage.isPageLoaded(),
                "NewPasswordPage is not loaded!");

        HomePage homePage = newPasswordPage.enterNewPassword(newUserPassword);

        Assert.assertTrue(homePage.isPageLoaded(),
                "HomePage is not loaded!");



    }
}
