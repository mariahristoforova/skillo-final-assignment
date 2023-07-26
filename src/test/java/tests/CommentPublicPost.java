package tests;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Header;
import pages.HomePage;
import pages.LoginPage;
import pages.UserPostPage;

import java.util.concurrent.TimeUnit;

public class CommentPublicPost extends BaseClass {

    final String baseUrl = "http://training.skillo-bg.com/";

    @Test
    public void commentPublicPostOfAnUser() {
        //Go to home page, find the Login button and click it
        HomePage homepage = new HomePage(driver);
        homepage.navigateTo();
        Header headerPage = new Header(driver);
        headerPage.goToLogin();
        // Enter credentials in the login form
        LoginPage loginPage = new LoginPage(driver);
        String username = "soraya.ramirez";
        loginPage.enterUsernameOrEmail(username);
        loginPage.enterPass("Ramirez5@hh");
        loginPage.clickSignInButton();

        // Load all posts and choose an user
        headerPage.goToHome();
        homepage.goToFirstUserPost(0);

        // Click the post
        System.out.println("Click the post");
        homepage.clickPost();

        // Check if the modal container of the post is loaded
        System.out.println("Check if the modal container of the post is loaded");
        UserPostPage userPostPage = new UserPostPage(driver);
        boolean isModalContainerVisible = userPostPage.checkVisibilityOfModalContainerOfAPost();
        Assert.assertTrue(isModalContainerVisible, "The modal container of the post is not displayed");

        //Check visibility of the comment field
        System.out.println("Check visibility of the comment field");
        userPostPage.checkVisibilityOfCommentField();
        boolean isCommentFieldVisible = userPostPage.checkVisibilityOfCommentField();
        Assert.assertTrue(isCommentFieldVisible, "The modal container of the post is not displayed");

        // Click the comment field
        System.out.println("Click the comment field ");
        userPostPage.clickCommentForm();

        // WebDriverWait wait = new WebDriverWait(driver, 10);
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        // Write a text in the field
        System.out.println("Write a text in the field ");
        String comment = "Impresionante!";
        userPostPage.writeAComment(comment);

        // Go to the comment in the all comments container and verify it is visible or check the text
        //String writtenComment = userPostPage.getTextOfFirstComment();
        String writtenComment = userPostPage.getTextOfAComment(username);
        Assert.assertEquals(writtenComment, comment);
    }
}
