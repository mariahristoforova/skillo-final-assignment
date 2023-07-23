package tests;

import org.testng.Assert;
import org.testng.annotations.*;
import pages.Header;
import pages.HomePage;
import pages.LoginPage;


public class LoginTests extends BaseClass {

    final String baseUrl = "http://training.skillo-bg.com/";
//    HomePage homepage;
//    Header headerPage;
//    LoginPage loginPage;

//    @BeforeTest
//    public void navigateToLoginPage() {
//        System.out.println("1.Navigate to Home page");
//        homepage = new HomePage(driver);
//        homepage.navigateTo();
//
//        System.out.println("2. Navigate to Login page");
//        headerPage = new Header(driver);
//        headerPage.goToLogin();
//
//        System.out.println("3. Check url is correct");
//        loginPage = new LoginPage(driver);
//        loginPage.checkUrl();
//
//        System.out.println("4. Sign in is displayed");
//        boolean isSignInTextPresent = loginPage.checkSignInTextIsDisplayed();
//        Assert.assertTrue(isSignInTextPresent, "The Sign In text is not visible");
//    }
//
//    @AfterTest
//    public void clearTestData() {
//        headerPage.clickTheLogoutButton();
//        driver.quit();
//    }

    @Test
    public void loginSuccessfully() {
        System.out.println("1.Navigate to Home page");
        HomePage homepage = new HomePage(driver);
        homepage.navigateTo();

        System.out.println("2. Navigate to Login page");
        Header headerPage = new Header(driver);
        headerPage.goToLogin();

        System.out.println("3. Check url is correct");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.checkUrl();

        System.out.println("4. Sign in is displayed");
        boolean isSignInTextPresent = loginPage.checkSignInTextIsDisplayed();
        Assert.assertTrue(isSignInTextPresent, "The Sign In text is not visible");

        System.out.println("5. Enter username");
        loginPage.enterUsernameOrEmail("soraya.ramirez");

        System.out.println("6. Enter pass");
        loginPage.enterPass("Ramirez5@hh");

        System.out.println("7. Click the Sign in button");
        loginPage.clickSignInButton();

        System.out.println("8. Check url is correct");
        homepage.verifyUrl();

        System.out.println("9. Profile section is visible");
        boolean isProfileSectionPresent = headerPage.checkProfileSectionIsVisible();
        Assert.assertTrue(isProfileSectionPresent, "Profile Section is not visible");

//        System.out.println("10. Pop-up message for successful login shows up");
//        WebElement toastElement = driver.findElement(By.cssSelector(".toast-message ng-star-inserted"));
//        wait.until(ExpectedConditions.visibilityOf(toastElement));
//        String toastMsg = toastElement.getText().trim();
//        Assert.assertEquals(toastMsg, "Sucessful login!", "Login is not successful");

        System.out.println("11. Check that the Sign out button is visible");
        boolean isLogoutButtonPresent = headerPage.checkLogOutIsVisible();
        Assert.assertTrue(isLogoutButtonPresent, "Logout button is not visible");
    }

    @Test
    public void loginWithoutEnteringPassword() {
        System.out.println("1.Navigate to Home page");
        HomePage homepage = new HomePage(driver);
        homepage.navigateTo();

        System.out.println("2. Navigate to Login page");
        Header headerPage = new Header(driver);
        headerPage.goToLogin();

        System.out.println("3. Enter username");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUsernameOrEmail("soraya.ramirez");

        System.out.println("4. Click the Sign in button");
        loginPage.clickSignInButton();

        System.out.println("5. Pop-up message that the password cannot be empty shows up");
        String popUpMessage = loginPage.getToasMessageTextInLoginForm();
        Assert.assertEquals(popUpMessage, "Password cannot be empty");
    }

    @Test
    public void loginWithoutEnteringUsername() {
        HomePage homepage = new HomePage(driver);
        homepage.navigateTo();

        Header headerPage = new Header(driver);
        headerPage.goToLogin();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.checkUrl();

        System.out.println("4. Click the Sign in button");
        loginPage.clickSignInButton();

        System.out.println("5. Pop-up message that the username or the email cannot be empty shows up");
        String popUpMessage = loginPage.getToasMessageTextInLoginForm();
        Assert.assertEquals(popUpMessage, "UsernameOrEmail cannot be empty");
    }

    @Test
    public void loginWithIncorrectCredentials() {
        System.out.println("1.Navigate to Home page");
        HomePage homepage = new HomePage(driver);
        homepage.navigateTo();

        System.out.println("2. Navigate to Login page");
        Header headerPage = new Header(driver);
        headerPage.goToLogin();

        System.out.println("3. Check url is correct");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.checkUrl();

        System.out.println("4. Sign in is displayed");
        boolean isSignInTextPresent = loginPage.checkSignInTextIsDisplayed();
        Assert.assertTrue(isSignInTextPresent, "The Sign In text is not visible");

        System.out.println("5. Enter username");
        loginPage.enterUsernameOrEmail("123hbsdfy63v");

        System.out.println("6. Enter pass");
        loginPage.enterPass("iUjjt56773KJSFyo.");

        System.out.println("7. Click the Sign in button");
        loginPage.clickSignInButton();

        System.out.println("8. Pop-up message that the user is not found shows up");
        String popUpMessage = loginPage.getToasMessageTextInLoginForm();
        Assert.assertEquals(popUpMessage, "User not found");
    }
}
