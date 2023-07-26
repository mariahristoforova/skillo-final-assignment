package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

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

    @FindBy(css = ".comment-container")
    WebElement commentContainer;

    @FindBy(css = ".comment-container > .row")
    List<WebElement> commentRow;

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

//    public String getTextOfFirstComment() {
//        waitForVisibilityOfElement(firstUserComment);
//        return firstUserComment.getText().trim();
//    }

    public String getTextOfAComment(String username) {
        waitForVisibilityOfElement(commentContainer);
        List<WebElement> listOfCommentRows = new ArrayList<>(commentRow);
        for (WebElement comment : listOfCommentRows) {
            String commentAuthor = comment.findElement(By.cssSelector(".comment-user")).getText();

            if (commentAuthor.equals(username)) {
                return comment.findElement(By.cssSelector(".comment-content")).getText();
            }
        }

        return "";
    }
}
