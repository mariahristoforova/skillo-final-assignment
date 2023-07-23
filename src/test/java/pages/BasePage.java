package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

    protected WebDriver driver;
    protected WebDriverWait smallWait;
    protected WebDriverWait mediumWait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        smallWait = new WebDriverWait(driver, 5);
        mediumWait = new WebDriverWait(driver, 10);
    }

    protected void clickElement(WebElement element) {
        smallWait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

    public void waitForVisibilityOfElement(WebElement element) {
        smallWait.until(ExpectedConditions.visibilityOf(element));
    }

}
