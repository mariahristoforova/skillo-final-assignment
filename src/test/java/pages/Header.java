package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Header extends BasePage {

    WebDriverWait wait;

    public Header(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, 5);
    }

    @FindBy(id="homeIcon")
    WebElement logoButton;

    @FindBy(id="nav-link-home")
    WebElement homeButton;

    @FindBy(id="nav-link-login")
    WebElement loginButton;

    @FindBy(id = "nav-link-profile")
    WebElement profileButton;

    @FindBy(css = ".fa-sign-out-alt")
    WebElement logoutButton;

//    public void clickToLogo() {
//        clickElement(logoButton);
//    }

    public void goToHome() {
        clickElement(homeButton);
    }

    public void goToLogin() {
        clickElement(loginButton);
    }

    public boolean checkProfileSectionIsVisible() {
        try{
            waitForVisibilityOfElement(profileButton);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public void goToProfile() {
        clickElement(profileButton);
    }

    public boolean checkLogOutIsVisible() {
        waitForVisibilityOfElement(profileButton);
        return true;
    }

    public void clickTheLogoutButton() {
        clickElement(logoutButton);
    }

    public boolean verifyTheLogInButtonIsVisible() {
        waitForVisibilityOfElement(loginButton);
        return true;
    }

}
