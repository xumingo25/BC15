package bc15.gAcevedo.TestCaseBci;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestCaseBCI {

    private WebDriver driver;
    private WebDriverWait wait;
    @Test
    public void TP01_Register() throws InterruptedException{
        driver.get("https://www.bci.cl/personas");
        //wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='closeModalHome']"))).click();
        /*WebElement btnCerrarPopUp1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='closeModalHome']")));
        if(btnCerrarPopUp1.isDisplayed()){
            btnCerrarPopUp1.click();
        }*/
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'Hazte Cliente')]"))).click();
        WebElement iframe = driver.findElement(By.id("myFrame"));
        //Switch to the frame
        driver.switchTo().frame(iframe);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@placeholder='Ingresa tu RUT']"))).sendKeys("10.863.075-2");
        Thread.sleep(500);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@placeholder='Ingresa número']"))).sendKeys("100.000.000");
        Thread.sleep(500);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@placeholder='Ingresa tu teléfono']"))).sendKeys("3456345420");
        Thread.sleep(500);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@placeholder='Ingresa tu email']"))).sendKeys("user123321@user.com");
        Thread.sleep(500);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@placeholder='Vuelve a ingresar tu email']"))).sendKeys("user123321@user.com");
        Thread.sleep(500);
        WebElement btnCheckbox = driver.findElement(By.id("bci-wk-checkbox0"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", btnCheckbox);
        Thread.sleep(1000);// Adjust timeout as needed
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'Continuar')]"))).submit();
        String textFail = driver.findElement(By.xpath("//p[contains(text(),'Acceso bloqueado temporalmente')]")).getText();
        Assertions.assertEquals("Acceso bloqueado temporalmente",textFail);
    }

    @BeforeEach
    public void preCondiciones() {
        String rutaDriver = System.getProperty("user.dir") + "\\src\\test\\resources\\drivers\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", rutaDriver);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver,20);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(30,TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(45,TimeUnit.SECONDS);
    }
}
