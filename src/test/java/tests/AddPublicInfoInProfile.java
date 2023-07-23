package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Header;
import pages.HomePage;
import pages.LoginPage;
import pages.ProfileUserInformationPage;

public class AddPublicInfoInProfile extends BaseClass {

    // 1. Go to the website
    // Click on Login
    // Enter credentials (username and password)
    // Go to profile button and click it
    // Go to the icon to edit profile and click it
    // Check if the form for editing of a profile is visible
    // Find "Public info" section and write something for the user
    // Click on Save button
    // Go back to the Edit profile icon
    // Verify the information and if the text in "Public info" text is saved

    final String baseUrl = "http://training.skillo-bg.com/";

    @Test
    public void addPublicInfoInTheProfileOfTheUser() {
        HomePage homepage = new HomePage(driver);
        homepage.navigateTo();
        Header headerPage = new Header(driver);
        headerPage.goToLogin();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUsernameOrEmail("soraya.ramirez");
        loginPage.enterPass("Ramirez5@hh");
        loginPage.clickSignInButton();

        headerPage.goToProfile();

        System.out.println("Verify that you are in the profile page of an user");
        boolean isProfileSectionPresent = headerPage.checkProfileSectionIsVisible();
        Assert.assertTrue(isProfileSectionPresent, "Profile Section is not visible");

        ProfileUserInformationPage profilePage = new ProfileUserInformationPage(driver);
        boolean isNewPostButtonPresent = profilePage.verifyTheNewPostButtonIsVisible();
        Assert.assertTrue(isNewPostButtonPresent, "New Post Section is not visible");

        headerPage.goToProfile();

        System.out.println("Check if the form for editing of a profile is visible");
        boolean isEditProfileButtonPresent = profilePage.verifyTheEditButtonIsVisible();
        Assert.assertTrue(isEditProfileButtonPresent, "Edit Profile Button is not visible");
        profilePage.clickTheEditingForm();

        System.out.println("Check the form for editing profile is visible");
        boolean isEditingFormnPresent = profilePage.checkEditingFormIsVisible();
        Assert.assertTrue(isEditingFormnPresent, "Editing form is not visible");

        System.out.println("Check the form Name and if it is written to Modify your Profile");
        String actualEditingFormText = profilePage.getHeaderFormText().trim();
        Assert.assertEquals(actualEditingFormText, "Modify Your Profile", "Expected header text is not displayed");

        System.out.println("Find the Public info section and write something for the user");
        profilePage.enterInfoForTheUser("A las personas apasionadas las distingue el entusiasmo y el saber aprovechar la vida al máximo");

        System.out.println("Click on Save button");
        profilePage.clickTheSaveButton();

//        System.out.println("Wait the form to disappear and check the info field");
 //       profilePage.waitTheModalToDisappear();

        System.out.println("Verify the information and if the text in \"Public info\" text is saved");
        String updatedProfileInfo = profilePage.getNewProfileInfoText();
        Assert.assertTrue(updatedProfileInfo.contains("A las personas apasionadas las distingue el entusiasmo"));

   //     profilePage.getConfirmationMessage();


    }

}
