package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Header;
import pages.HomePage;
import pages.LoginPage;

public class LikeOrDislikePublicPost extends BaseClass {

    @Test
    public void likeOrDislikePublicPost() {
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
        // Check if the button to like the post is visible
        boolean isButtonVisible = homepage.checkButtonToLikeAPostIsVisible();
        Assert.assertTrue(isButtonVisible, "The button is not displayed");
//        System.out.println("The button is visible");
        //Click on the heart button to like the post
        homepage.clickHeartButton();
//        System.out.println("You've clicked the button");
//        //Check the pop-up message and if it is written "Post liked"
//        Assert.assertEquals(homepage.getToasMessageText(), "Post liked");

        //Click the heart button again and check if the pop-up message is "You don't like this post anymore!"
        homepage.clickButton();
        System.out.println(homepage.getToasMessageText());

    }

}
