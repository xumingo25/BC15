package bc15.fmartinez.Unidad1;

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

public class TestCase1 {
    private WebDriver driver;
    private WebDriverWait wait;

    @Test
    public void TC001_CreateAccaunt_Spotify() throws InterruptedException {

    driver.get("https://open.spotify.com/intl-es");

    By byClosePopup = By.xpath("//button[@aria-label='Cerrar']");
    if (!driver.findElements(byClosePopup).isEmpty()) {
        WebElement btnClosePopup = wait.until(ExpectedConditions.elementToBeClickable(byClosePopup));
        btnClosePopup.click();
    }

    By byBtnRegistrarse = By.xpath("//button[@data-testid='signup-button']");
    WebElement btnRegistrarse = driver.findElement(byBtnRegistrarse);
    btnRegistrarse.click();

    driver.findElement(By.xpath("//input[@id='username']")).sendKeys("bc1602prueba@gmail.com");

    WebElement btnSubmit = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@data-testid='submit']")));
    Thread.sleep(2000);
    btnSubmit.click();

    driver.findElement(By.id("new-password")).sendKeys("Prueba1000!");
    Thread.sleep(2000);
    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@data-testid='submit']"))).submit();

    driver.findElement(By.id("displayName")).sendKeys("bc1602prueba");

    driver.findElement(By.xpath("//input[@placeholder='dd']")).sendKeys("16");

    Select ddlMes =new Select(driver.findElement(By.id("month")));
    ddlMes.selectByVisibleText("Febrero");

    driver.findElement(By.xpath("//input[@placeholder='aaaa']")).sendKeys("2002");

    List<WebElement> gender = driver.findElements(By.xpath("//label[contains(@for,'gender')]"));

    gender.get(0).click();
    Thread.sleep(1000);

    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@data-testid='submit']"))).submit();

    List<WebElement> checks = driver.findElements(By.xpath("//label[contains(@for,'checkbox-')]"));

    checks.get(0).click();
    Thread.sleep(1000);
    checks.get(1).click();
    Thread.sleep(1000);

    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@data-testid='submit']"))).submit();
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

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(30, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(45, TimeUnit.SECONDS);

        wait = new WebDriverWait(driver,20);

    }

}