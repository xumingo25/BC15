package bc15.fmartinez.Unidad1;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;


public class TC2 {
    private WebDriver driver;  //inicializar el webdriver
    private WebDriverWait wait;

    public void enviarInfo( By locator, String info) {

        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));

        element.clear();
        element.sendKeys(info);
    }


    @Test
    public void CP01_CreacionCuenta_PCI() {
        driver.get("https://www.bci.cl/personas");

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'Hazte Cliente')]"))).click();
        WebElement iframe = driver.findElement(By.id("myFrame"));

        driver.switchTo().frame(iframe);
        enviarInfo(By.xpath("//input[@placeholder='Ingresa tu RUT']"),"10477985-9");
        enviarInfo(By.xpath("//input[@placeholder='Ingresa número']"), "380.000.000");
        enviarInfo(By.xpath("//input[@placeholder='Ingresa tu teléfono']"),"20000000");
        enviarInfo(By.xpath("//input[@placeholder='Ingresa tu email']"),"tc1000@gmail.com");
        enviarInfo(By.xpath("//input[@placeholder='Vuelve a ingresar tu email']"),"tc1000@gmail.com");

        WebElement btnCheckbox = driver.findElement(By.id("bci-wk-checkbox0"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", btnCheckbox);

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'Continuar')]"))).submit();

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

    @AfterEach
    public void posCondiciones(){
        //driver.close();
    }
}
