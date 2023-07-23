package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage {
    private final String urlLogin = "http://training.skillo-bg.com/users/login";
    WebDriverWait wait;

    @FindBy(css = "form .h4")
    WebElement signInText;

    @FindBy(name = "usernameOrEmail")
    WebElement userNameField;

    @FindBy(name = "password")
    WebElement passField;

    @FindBy(id = "sign-in-button")
    WebElement signInButton;

    @FindBy(css = ".toast-message")
    WebElement toastMessageInLoginForm;

    public LoginPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, 5);
    }

    public void enterUsernameOrEmail(String username) {
        waitForVisibilityOfElement(userNameField);
        userNameField.sendKeys(username);
    }

    public void enterPass(String pass) {
        waitForVisibilityOfElement(passField);
        passField.sendKeys(pass);
    }

    public void clickSignInButton() {
        clickElement(signInButton);
    }

    public void checkUrl() {
        wait.until(ExpectedConditions.urlToBe(urlLogin));
    }

    public boolean checkSignInTextIsDisplayed() {
        try{
            waitForVisibilityOfElement(signInText);
            return true;
        } catch (Exception e) {
         return false;
        }

    }

    public String getToasMessageTextInLoginForm() {
            waitForVisibilityOfElement(toastMessageInLoginForm);
            String toastMessageTxt = toastMessageInLoginForm.getText().trim();
            return toastMessageTxt;
        }
}
