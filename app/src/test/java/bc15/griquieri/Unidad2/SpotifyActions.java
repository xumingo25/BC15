package bc15.griquieri.Unidad2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;

public class SpotifyActions {
    private WebDriver driver;
    private WebDriverWait wait;

    public SpotifyActions(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
    }

    public void clickWhenClickable(By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
    }

    public void sendKeysWhenVisible(By locator, String text) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).sendKeys(text);
    }

    public void selectFromDropdownByVisibleText(By locator, String text) {
        Select dropdown = new Select(wait.until(ExpectedConditions.visibilityOfElementLocated(locator)));
        dropdown.selectByVisibleText(text);
    }

    public void clickOnAllElements(By locator) {
        List<WebElement> elements = driver.findElements(locator);
        for (WebElement element : elements) {
            element.click();
        }
    }
}

