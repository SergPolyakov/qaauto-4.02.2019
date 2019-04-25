package test;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import page.HomePage;
import page.LoginPage;
import page.LoginSubmitPage;

/**
 * Login tests class.
 */
public class LinkedinLoginTest extends BaseTest {


    /**
     * Data provider for successfulLoginTest.
     * @return valid user email and user password.
     */
    @DataProvider
    public Object[][] validDataProvider() {
        return new Object[][]{
                //{ "TESTEROK111333@gmail.com", "111333" },
               // { "testerok111333@gmail.com", "111333" }
                { "reabilitolog1988@gmail.com", "stsvadba05102013" }
        };
    }

    /**
     * Verification test successful login to Linkedin.com
     * @param userEmail - user email from validDataProvider.
     * @param userPassword - user password from validDataProvider.
     */
    @Test(dataProvider = "validDataProvider")
    public void successfulLoginTest(String userEmail, String userPassword) {

        Assert.assertTrue(loginPage.isPageLoaded(),
                "Login page was not loaded");

        HomePage homePage = loginPage.login(userEmail, userPassword);

        Assert.assertTrue(homePage.isPageLoaded(),
                "Home page is not loaded");
    }


    /**
     * Data provider for emptyOneOfLoginFields test.
     * @return empty user email and/or empty user password.
     */
    @DataProvider
    public  Object [][] emptyLoginFieldsProvider() {
        return new Object[][]{
                //{"", "111333"},
                //{"testerok111333@gmail.com", ""},
                {"",""}
        };
    }

    /**
     * Login verification test with an empty user email or user password.
     * @param userEmail - user email from emptyLoginFieldsProvider
     * @param userPass - user password from emptyLoginFieldsProvider
     */
    @Test (dataProvider = "emptyLoginFieldsProvider")
    public void emptyOneOfLoginFields(String userEmail, String userPass) {

        LoginPage newLoginPage = loginPage.login(userEmail, userPass);

        Assert.assertTrue(newLoginPage.isPageLoaded(),
                "User logged in with an empty login field!");
    }


    /**
     * Login verification test with incorrect user email or user password.
     * @return error messages, incorrect user email or incorrect user password.
     */
    @DataProvider
    public Object [][] invalidDataProvider() {
        return new Object[][]{
               // {"testerok111333@gmail.com", "qwerty", "", "Это неверный пароль. Повторите попытку или измените пароль."},
                {"testerok111333@@gmail.com", "111333", "Этот адрес эл. почты не зарегистрирован в LinkedIn. Повторите попытку.", ""}
        };
    }

    /**
     * Login verification test with incorrect user email or incorrect user password.
     * @param userEmail - user email from invalidDataProvider.
     * @param userPass - user password from invalidDataProvider.
     * @param emailValidation - error message when user email is incorrect.
     * @param passwordValidation - error message when user password is incorrect.
     */
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
