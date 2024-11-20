package bc15.aramos.Unidad2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class TestRegistroBCI {
    private WebDriver driver;
    private WebDriverWait wait;


    @Test
    public void CP001_CrearCuenta_BCI() throws InterruptedException {
        driver.get("https://www.bci.cl/personas");

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(), 'Hazte Cli')]"))).click();
        Thread.sleep(3000);
        WebElement iframe = driver.findElement(By.id("myFrame"));
        driver.switchTo().frame(iframe);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//bci-wk-input-text//input[@placeholder='Ingresa tu RUT']"))).sendKeys("5766985-3");
        //documento no valido
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//bci-wk-input-text//input[@placeholder='Ingresa número']"))).sendKeys("300.000.000");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[contains(@placeholder, 'Ingresa tu teléfono')]"))).sendKeys("354685831");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@formcontrolname='primaryEmail']"))).sendKeys("usertest123@gmail.com");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@formcontrolname='secondaryEmail']"))).sendKeys("usertest123@gmail.com");

        WebElement botonCheck = driver.findElement(By.xpath("//label[@for='bci-wk-checkbox0']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;

        // Hacer clic sobre el checkbox usando JavaScript
        js.executeScript("arguments[0].click();", botonCheck);

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Continuar']"))).click();


    }


    @BeforeEach
    public void preCondiciones(){
        String rutaDriver = System.getProperty("user.dir") +"\\src\\test\\resources\\drivers\\chromedriver.exe";
        //enlazar el webdriver a traves de property
        System.setProperty("webdriver.chrome.driver",rutaDriver);

        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 20);
        //maximizar el browser
        driver.manage().window().maximize();
    }

}

