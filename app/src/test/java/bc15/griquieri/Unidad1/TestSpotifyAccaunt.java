package bc15.griquieri.Unidad1;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class TestSpotifyAccaunt {

    private WebDriver driver;

    public void EsperayClick(By locator){

        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.elementToBeClickable(locator));
        driver.findElement(locator).click();

    }

    @Test
    public void TC001_CreateAccaunt_Spotify() throws InterruptedException{

        //Manage Waits
        WebDriverWait wait = new WebDriverWait(driver, 5);
        driver.get("https://open.spotify.com/intl-es");

        //Looking for the "Singup button"
        EsperayClick(By.xpath("//button[@data-testid='signup-button']"));

        //By byBtnRegister = By.xpath("//button[@data-testid='signup-button']");
        //WebElement btnRegister = driver.findElement(byBtnRegister);
        //btnRegister.click();

        //looking for the "username" Input
        driver.findElement(By.xpath("//input[@id='username']")).sendKeys("userbc150004@gmail.com");

        //Close PopUp

        By byClosePopup = By.xpath("//button[@aria-label='Cerrar']");
        if (!driver.findElements(byClosePopup).isEmpty()) {
            WebElement btnClosePopup = wait.until(ExpectedConditions.elementToBeClickable(byClosePopup));
            btnClosePopup.click();
        }

        //Send the form
        EsperayClick(By.xpath("//button[@data-testid='submit']"));
        //driver.findElement(By.xpath("//button[@data-testid='submit']")).click();

        //complete password
        driver.findElement(By.xpath("//input[@id='new-password']")).sendKeys("Contraseña123.");
        Thread.sleep(2000);
        EsperayClick(By.xpath("//button[@data-testid='submit']"));

        //Charging data to Personal Info
        driver.findElement(By.name("displayName")).sendKeys("UserBC150004");

        driver.findElement(By.xpath("//input[@placeholder='dd']")).sendKeys("06");

        Select ddlMes =new Select(driver.findElement(By.id("month")));
        ddlMes.selectByVisibleText("Septiembre");

        driver.findElement(By.xpath("//input[@placeholder='aaaa']")).sendKeys("1994");

        List<WebElement> gender = driver.findElements(By.xpath("//label[contains(@for,'gender')]"));
        gender.get(0).click();
        EsperayClick(By.xpath("//button[@data-testid='submit']"));

        //Accepting terms
        List<WebElement> checks = driver.findElements(By.xpath("//label[contains(@for,'checkbox-')]"));
        checks.get(0).click();
        checks.get(1).click();
        EsperayClick(By.xpath("//button[@data-testid='submit']"));

        String expectedResult = "UserBC150004";
        String actualResult = driver.findElement(By.xpath("//button[@data-testid='user-widget-link']")).getAttribute("aria-label");

        Assertions.assertEquals(expectedResult,actualResult);


    }

    @BeforeEach

    public void preCondiciones(){

        String rutaDriver = System.getProperty("user.dir") +"\\src\\test\\resources\\drivers\\chromedriver.exe";
        //enlazar el webdriver a traves de property
        System.setProperty("webdriver.chrome.driver",rutaDriver);

        //testing
        driver = new ChromeDriver();

        //maximizar el browser
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(40,TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(40,TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(40,TimeUnit.SECONDS);
    }

    @AfterEach

    public void posCondiciones(){
        driver.close();
    }

}
