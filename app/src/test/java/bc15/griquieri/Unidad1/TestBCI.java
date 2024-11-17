package bc15.griquieri.Unidad1;

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
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;
import java.util.zip.Checksum;

public class TestBCI {
    private WebDriver driver;
    private WebDriverWait wait;

    //funciones
    public void sendInfo(By locator,String info){

        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));

        element.clear();
        element.sendKeys(info);
    }
    public void EsperaYEnvio(By locator){

        wait.until(ExpectedConditions.elementToBeClickable(locator));
        driver.findElement(locator).submit();

    }

    public void ValidCkeck(By locator, String arg){
        WebElement btnCheckbox = driver.findElement(locator);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript(arg, btnCheckbox);
    }

    public void failText(By locator, String txt){
        String textFail = driver.findElement(locator).getText();

        Assertions.assertEquals(txt,textFail);
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

        wait = new WebDriverWait(driver,20);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(30,TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(45,TimeUnit.SECONDS);
    }
    @Test
    public void TC0001_BCIReg(){
        driver.get("https://www.bci.cl/personas");

        //Experar a que aparezca el boton
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'Hazte Cliente')]"))).click();

        //Se cambia el foco del HTML al iFrame
        WebElement iframe = driver.findElement(By.id("myFrame"));
        driver.switchTo().frame(iframe);

        //completar los datos

        sendInfo(By.xpath("//input[@placeholder='Ingresa tu RUT']"),"17567561-2");
        sendInfo(By.xpath("//input[@placeholder='Ingresa número']"),"333666666");
        sendInfo(By.xpath("//input[@placeholder='Ingresa tu teléfono']"),"34566666");
        sendInfo(By.xpath("//input[@placeholder='Ingresa tu email']"),"TCBC12@test.ong");
        sendInfo(By.xpath("//input[@placeholder='Vuelve a ingresar tu email']"),"TCBC12@test.ong");

        //Click en el Checkbox
        ValidCkeck(By.id("bci-wk-checkbox0"),"arguments[0].click();");

        //Enviar el formulario
        EsperaYEnvio(By.xpath("//button[contains(text(),'Continuar')]"));

        //Mensaje si falla
        failText(By.xpath("//p[contains(text(),'Hubo un error intentando enviar tus datos')]"),"Hubo un error intentando enviar tus datos");
    }

    @AfterEach
    public void posCondiciones(){
        //driver.close();
    }}
