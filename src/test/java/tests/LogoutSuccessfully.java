package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Header;
import pages.HomePage;
import pages.LoginPage;


public class LogoutSuccessfully extends BaseClass {

    final String baseUrl = "http://training.skillo-bg.com/";

    @Test
    public void logOutSuccessfullyTest() {
        HomePage homepage = new HomePage(driver);
        homepage.navigateTo();
        Header headerPage = new Header(driver);
        headerPage.goToLogin();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.checkUrl();

        boolean isSignInTextPresent = loginPage.checkSignInTextIsDisplayed();
        Assert.assertTrue(isSignInTextPresent, "The Sign In text is not visible");

        loginPage.enterUsernameOrEmail("soraya.ramirez");
        loginPage.enterPass("Ramirez5@hh");
        loginPage.clickSignInButton();

        homepage.verifyUrl();

        boolean isProfileSectionPresent = headerPage.checkProfileSectionIsVisible();
        Assert.assertTrue(isProfileSectionPresent, "Profile Section is not visible");

        headerPage.clickTheLogoutButton();

        boolean isLoginButtonPresent = headerPage.verifyTheLogInButtonIsVisible();
        Assert.assertTrue(isLoginButtonPresent, "Login button is not visible");
    }

}
