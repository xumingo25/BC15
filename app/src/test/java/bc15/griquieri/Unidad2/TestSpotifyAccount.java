package bc15.griquieri.Unidad2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestSpotifyAccount {

    private WebDriver driver;
    private SpotifyActions actions;

    @BeforeEach
    public void setup() {
        String rutaDriver = System.getProperty("user.dir") + "\\src\\test\\resources\\drivers\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", rutaDriver);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        actions = new SpotifyActions(driver);
    }

    @Test
    public void TC001_CreateAccount_Spotify() {
        driver.get("https://open.spotify.com/intl-es");

        // Click on Sign Up button
        By btnRegister = By.xpath("//button[@data-testid='signup-button']");
        actions.clickWhenClickable(btnRegister);

        // Enter username
        By usernameInput = By.xpath("//input[@id='username']");
        actions.sendKeysWhenVisible(usernameInput, "userbc150004@gmail.com");

        // Close Pop-up if exists
        By closePopup = By.xpath("//button[@aria-label='Cerrar']");
        if (!driver.findElements(closePopup).isEmpty()) {
            actions.clickWhenClickable(closePopup);
        }

        // Submit the form
        By submitButton = By.xpath("//button[@data-testid='submit']");
        actions.clickWhenClickable(submitButton);

        // Complete password
        By passwordInput = By.xpath("//input[@id='new-password']");
        actions.sendKeysWhenVisible(passwordInput, "Contraseña123.");
        actions.clickWhenClickable(submitButton);

        // Fill in personal info
        actions.sendKeysWhenVisible(By.name("displayName"), "UserBC150004");
        actions.sendKeysWhenVisible(By.xpath("//input[@placeholder='dd']"), "06");
        actions.selectFromDropdownByVisibleText(By.id("month"), "Septiembre");
        actions.sendKeysWhenVisible(By.xpath("//input[@placeholder='aaaa']"), "1994");

        // Click gender options
        actions.clickOnAllElements(By.xpath("//label[contains(@for,'gender')]"));

        // Accept terms
        actions.clickOnAllElements(By.xpath("//label[contains(@for,'checkbox-')]"));

        // Final Submit
        actions.clickWhenClickable(submitButton);

        // Verify user creation
        By userWidget = By.xpath("//button[@data-testid='user-widget-link']");
        String actualResult = driver.findElement(userWidget).getAttribute("aria-label");
        Assertions.assertEquals("UserBC150004", actualResult);
    }

    @AfterEach
    public void tearDown() {
        driver.close();
    }
}
