package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class HomePage extends BasePage {
   private  WebDriver driver;
    private WebDriverWait wait;

    private final String URL = "http://training.skillo-bg.com/posts/all";

    public HomePage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, 5);
    }

    public void navigateTo() {
        driver.get(URL);
    }

    public void verifyUrl() {
        wait.until(ExpectedConditions.urlToBe(URL));
    }


    @FindBy(css = ".post-feed-container")
    List<WebElement> posts;

    @FindBy(css = "button.btn.btn-primary")
    WebElement buttonToFollowOrUnFollow;

    @FindBy(css = ".toast-message")
    WebElement toastMessage;

    @FindBy(css = ".fa-heart")
    WebElement likeButton;

    @FindBy(css = ".post-feed-container")
    WebElement postOfAnUser;

//    @FindBy(css = ".post-modal-container")
//    WebElement modalContainer;
//
//    @FindBy(css = ".post-modal-container .comment-form")
//    WebElement commentFormInTheModalContainer;

    public void goToFirstUserPost(int index) {
        posts.get(index);
    }

    public void clickButton() {
        clickElement(buttonToFollowOrUnFollow);
    }

    public boolean checkButtonToFollowOrUnfollowIsVisible() {
        waitForVisibilityOfElement(buttonToFollowOrUnFollow);
        return true;
    }

    public String getButtonText() {
        String followUnfollowButtonText = buttonToFollowOrUnFollow.getText();
        return followUnfollowButtonText;
    }

    public String getToasMessageText() {
        waitForVisibilityOfElement(toastMessage);
        String toastMessageTxt = toastMessage.getText().trim();
        return toastMessageTxt;
    }

    public boolean checkButtonToLikeAPostIsVisible() {
        waitForVisibilityOfElement(likeButton);
        return true;
    }

    public void clickHeartButton() {
        clickElement(likeButton);
    }

    public void clickPost() {
        clickElement(postOfAnUser);
    }


//    public boolean checkVisibilityOfModalContainerOfAPost() {
//        wait.until(ExpectedConditions.visibilityOf(modalContainer));
//        return true;
//    }

//    public void clickTheCommentForm() {
//        wait.until(ExpectedConditions.elementToBeClickable(commentFormInTheModalContainer));
//        likeButton.click();
//    }

//    public void writeAComment(String text) {
//        commentFormInTheModalContainer.sendKeys(text);
//    }

}
