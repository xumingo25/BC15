package bc15.agusVilla.unidad1;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class TC002 {
    private WebDriver driver;
    private WebDriverWait wait;

    @Test
    public void CP001_registro() throws InterruptedException{
        //Datos Test
        String email = "mailEjemplo@gmail.com";
        String contrasena = "123contrasena!";
        String nombre = "Juan Perez";

        By byRegisterButton = By.xpath("//button[@data-testid='signup-button']");
        By byClosePopUp = By.xpath("//button[@aria-label='Cerrar']");
        By byInputEmail = By.xpath("//input[@id='username']");
        Thread.sleep(1000);
        //By byButtonSiguiente = By.xpath("//button[@data-testid='submit']");
        By byInputContra = By.id("new-password");
        By byInputNombre = By.xpath("input[@data-encore-id='formInput']");


        driver.get("https://open.spotify.com/intl-es");
        Thread.sleep(2000);

        WebElement registrarse = driver.findElement(byRegisterButton);
        registrarse.click();
        Thread.sleep(1000);

        WebElement btnCerrarPopUp = wait.until(ExpectedConditions.presenceOfElementLocated(byClosePopUp));
        btnCerrarPopUp.click();

        WebElement inputEmail = wait.until(ExpectedConditions.presenceOfElementLocated(byInputEmail));
        inputEmail.sendKeys(email);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@data-encore-id='buttonPrimary']"))).click();
        Thread.sleep(1000);

        WebElement inputContra = wait.until(ExpectedConditions.presenceOfElementLocated(byInputContra));
        inputContra.sendKeys(contrasena);
        WebElement siguientePsswd = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@data-testid='submit']")));
        Thread.sleep(1000);
        siguientePsswd.click();
        Thread.sleep(1000);

        wait.until(ExpectedConditions.presenceOfElementLocated(By.name("displayName"))).sendKeys("UsuarioDePrueba34");
        driver.findElement(By.xpath("//input[@placeholder='dd']")).sendKeys("16");
        Thread.sleep(1000);

        Select selector = new Select(driver.findElement(By.name("month")));
        selector.selectByVisibleText("Junio");
        driver.findElement(By.xpath("//input[@placeholder='aaaa']")).sendKeys("2005");

        List<WebElement> generos = driver.findElements(By.xpath("//label[contains(@for,'gender')]"));
        generos.get(0).click();
        driver.findElement(By.xpath("//button[@data-testid='submit']")).submit();

        List<WebElement> checks = driver.findElements(By.xpath("//label[contains(@for,'checkbox-')]"));
        checks.get(0).click();
        checks.get(1).click();
        driver.findElement(By.xpath("//button[@data-testid='submit']")).submit();

        String resultadoEsperado = "UsuarioDePrueba34";
        String resultadoActual = driver.findElement(By.xpath("//button[@data-testid='user-widget-link']")).getAttribute("aria-label");

        Assertions.assertEquals(resultadoEsperado,resultadoActual);

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

