package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UserPostPage extends BasePage {

    private WebDriver driver;
    private WebDriverWait wait;

    private final String URL = "http://training.skillo-bg.com/posts/all";

    public UserPostPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, 5);
    }

    @FindBy(css = ".post-modal-container")
    WebElement modalContainer;

    @FindBy(css = "app-comment-form input") // .post-modal-container .comment-form
    WebElement commentFormInTheModalContainer;

//    @FindBy(css = ".comment-container")
//    WebElement commentFIeld;

//    @FindBy(css = ".comment-form")
//    WebElement newCommentFromAnotherUser;

//    @FindBy(css = ".comment-form .form-control")
    WebElement newCommentFromAnotherUser;

    @FindBy(css = "app-comment-list > app-comment .comment-content")
    WebElement firstUserComment;

    public boolean checkVisibilityOfModalContainerOfAPost() {
        waitForVisibilityOfElement(modalContainer);
        return true;
    }

    public void clickCommentForm() {
        clickElement(commentFormInTheModalContainer);
    }

    public boolean checkVisibilityOfCommentField() {
        waitForVisibilityOfElement(commentFormInTheModalContainer);
        return true;
    }

    public void writeAComment(String text) {
        commentFormInTheModalContainer.clear();
        commentFormInTheModalContainer.sendKeys(text);
        commentFormInTheModalContainer.sendKeys(Keys.RETURN);

    }

    public String getTextOfFirstComment() {
        waitForVisibilityOfElement(firstUserComment);
        return firstUserComment.getText().trim();
    }
}
