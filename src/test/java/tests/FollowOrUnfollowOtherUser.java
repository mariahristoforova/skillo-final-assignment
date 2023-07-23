package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Header;
import pages.HomePage;
import pages.LoginPage;

public class FollowOrUnfollowOtherUser extends BaseClass {

    final String baseUrl = "http://training.skillo-bg.com/";

    @Test
    public void followOrUnfollowOtherUser() {
            //Go to home page, find the Login button and click it
            HomePage homepage = new HomePage(driver);
            homepage.navigateTo();
            Header headerPage = new Header(driver);
            headerPage.goToLogin();
            // Enter credentials in the login form
            LoginPage loginPage = new LoginPage(driver);
            loginPage.enterUsernameOrEmail("soraya.ramirez");
            loginPage.enterPass("Ramirez5@hh");
            loginPage.clickSignInButton();

            // Load all posts and choose an user
            headerPage.goToHome();
            homepage.goToFirstUserPost(0);

            // Check if the button to Follow or Unfollow  is visible
            boolean isButtonVisible = homepage.checkButtonToFollowOrUnfollowIsVisible();
            Assert.assertTrue(isButtonVisible, "The button is not displayed");
            // Click on the button to "Follow" or Unfollow
            homepage.clickButton();
            // Get text of the button after following/unfollowing the user
        String buttonText = homepage.getButtonText();
    //    Assert.assertEquals(buttonText, "Unfollow");
        System.out.println(buttonText);
        if (buttonText.contains("Unfollow")) {
            homepage.clickButton();
            System.out.println(homepage.getToasMessageText());
        }


    }

}
