package bc15.gAcevedo;
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

public class TestCaseRegistro {

    private WebDriver driver;
    public WebDriverWait wait;

    @Test
    public void TC01_IncorrectUsername() throws InterruptedException{
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@data-testid='login-button']"))).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='login-username']"))).sendKeys("pruebauser151515@cuenta.com");
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='login-password']"))).sendKeys("Contrasena123");
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='login-button']"))).click();
        String respuestaEsperada = "Incorrect username or password.";
        Assertions.assertEquals(respuestaEsperada,wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[contains(text(),'Incorrect username or password.')]"))).getText());
    }

    @Test
    public void TC02_Register() throws InterruptedException{
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@data-testid='signup-button']"))).click();
        driver.findElement(By.xpath("//input[@id='username']")).sendKeys("pruebauser151515@cuenta.com");
        //Duda-----------------------------------------------

        WebElement btnSubmit = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@data-testid='submit']")));
        Thread.sleep(1000);
        btnSubmit.click();
        driver.findElement(By.xpath("//input[@id='new-password']")).sendKeys("Contrasena1234");
        Thread.sleep(1000);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@data-testid='submit']"))).submit();
        //btnSubmit.submit();
        driver.findElement(By.xpath("//input[@id='displayName']")).sendKeys("namepublic");
        driver.findElement(By.xpath("//input[@id='day']")).sendKeys("11");
        Select month = new Select(driver.findElement(By.id("month")));
        month.selectByVisibleText("December");
        driver.findElement(By.xpath("//input[@id='year']")).sendKeys("1990");
        List<WebElement> generos = driver.findElements(By.xpath("//div[@data-encore-id='formRadio']"));
        generos.get(2).click();
        Thread.sleep(1000);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@data-testid='submit']"))).submit();
        driver.findElement(By.xpath("//span[contains(text(),'I would prefer not to receive ma')]")).click();
        driver.findElement(By.xpath("//span[contains(text(),'Share my registration data with')]")).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@data-testid='submit']"))).submit();
    }

    @BeforeEach
    public void preCondiciones(){
        String rutaDriver = System.getProperty("user.dir")+"\\src\\test\\resources\\drivers\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver",rutaDriver);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver,20);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(30,TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(45,TimeUnit.SECONDS);
        driver.get("https://open.spotify.com/");
        WebElement btnPopUp = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@aria-label='Close']")));
        if(btnPopUp.isDisplayed()) btnPopUp.click();
    }

}