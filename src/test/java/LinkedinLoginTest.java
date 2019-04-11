import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LinkedinLoginTest {

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
//---------------------------------------------------------------------
    @DataProvider
    public Object[][] validDataProvider() {
        return new Object[][]{
                //{ "TESTEROK111333@gmail.com", "111333" },
               // { "testerok111333@gmail.com", "111333" },
                { " testerok111333@gmail.com ", "111333" }
        };
    }

    @Test(dataProvider = "validDataProvider")
    public void successfulLoginTest(String userEmail, String userPassword) {

        Assert.assertTrue(loginPage.isPageLoaded(),
                "Login page was not loaded");

        HomePage homePage = loginPage.login(userEmail, userPassword);

        Assert.assertTrue(homePage.isPageLoaded(),
                "Home page is not loaded");
    }
//----------------------------------------------------------------------
    @DataProvider
    public  Object [][] emptyLoginFieldsProvider() {
        return new Object[][]{
                //{"", "111333"},
                //{"testerok111333@gmail.com", ""},
                {"",""}
        };
    }

    @Test (dataProvider = "emptyLoginFieldsProvider")
    public void emptyOneOfLoginFields(String userEmail, String userPass) {

        LoginPage newLoginPage = loginPage.login(userEmail, userPass);

        Assert.assertTrue(newLoginPage.isPageLoaded(),
                "User logged in with an empty login field!");
    }
//-----------------------------------------------------------------------
    @DataProvider
    public Object [][] invalidDataProvider() {
        return new Object[][]{
               // {"testerok111333@gmail.com", "qwerty", "", "Это неверный пароль. Повторите попытку или измените пароль."},
                {"testerok111333@@gmail.com", "111333", "Этот адрес эл. почты не зарегистрирован в LinkedIn. Повторите попытку.", ""}
        };
    }

    @Test (dataProvider = "invalidDataProvider")
    public void enterIncorrectValues(String userEmail,
                                     String userPass,
                                     String emailValidation,
                                     String passwordValidation) {

        LoginSubmitPage loginSubmitPage = loginPage.login(userEmail, userPass);

        Assert.assertTrue(loginSubmitPage.isPageLoaded(),
                "Login submit page is not loaded!");

        Assert.assertEquals(loginSubmitPage.getUserEmailValidationMessage(), emailValidation,
                "userEmail validation message is incorrect");

        Assert.assertEquals(loginSubmitPage.getUserPasswordValidationMessage(), passwordValidation,
                "userPassword validation message is incorrect");
    }
}
