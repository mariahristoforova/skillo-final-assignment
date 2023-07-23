package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProfileUserInformationPage extends BasePage {

 //   private WebDriver driver;
    private WebDriverWait wait;

//    @FindBy(css = ".image-container")
    WebElement profilePhoto;

//    WebElement userPosts;

//    @FindBy(id = "followers")
    WebElement userFollowers;

//    @FindBy(id = "following")
    WebElement userFollowing;

//    @FindBy(id = "search-bar")  // header
    WebElement searchBar;

//    WebElement searchingIcon;  // header

    @FindBy(id = "nav-link-new-post")
    WebElement newPost;

//    WebElement allPosts;

//    WebElement publicPosts;

//    WebElement privatePosts;

//    @FindBy(css = "h2")
    WebElement userNameDetails;

    @FindBy(css = ".fa-user-edit")
    WebElement editProfileDetails;

    @FindBy(css = ".modal-content .form-header > h4")
    WebElement formHeaderText;

//    @FindBy(css = "textarea.form-control")
//    WebElement profileInfoField;

    @FindBy(css = ".profile-edit-container")
    WebElement editProfileModal;

    @FindBy(css = ".profile-edit-container textarea.form-control")
    WebElement publicInfoField;

    @FindBy(css = "app-profile-section p")
    WebElement updatedPublicInfo;

    @FindBy(css = "button.btn.btn-primary")
    WebElement saveButton;

    @FindBy(css = "toast-message")
    WebElement toastElement;

    public ProfileUserInformationPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, 5);
    }


//    public boolean checkTheUsername() {
//        wait.until(ExpectedConditions.visibilityOf(userNameDetails));
//        return true;
//    }

    public boolean verifyTheNewPostButtonIsVisible() {
        try{
            waitForVisibilityOfElement(newPost);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean verifyTheEditButtonIsVisible() {
        waitForVisibilityOfElement(editProfileDetails);
        return true;
    }

    public boolean checkEditingFormIsVisible() {
        waitForVisibilityOfElement(formHeaderText);
        return true;
    }
    public void clickTheEditingForm() {
        clickElement(editProfileDetails);
    }

    public String getHeaderFormText() {
       String editingFormHeader = formHeaderText.getText();
        return editingFormHeader;
    }

    public void enterInfoForTheUser(String text) {
        publicInfoField.clear();
        publicInfoField.sendKeys(text);
    }

    public void clickTheSaveButton() {
        clickElement(saveButton);
    }

//    public void waitTheModalToDisappear() {
//        wait.until(ExpectedConditions.invisibilityOf(editProfileModal));
//    }

    public String getNewProfileInfoText() {
        waitForVisibilityOfElement(updatedPublicInfo);
        return updatedPublicInfo.getText();
    }

//    public void getConfirmationMessage() {
//        wait.until(ExpectedConditions.visibilityOf(toastElement));
//        String toastMsg = toastElement.getText().trim();
//        Assert.assertEquals(toastMsg, "Profile updated");
//    }
}
