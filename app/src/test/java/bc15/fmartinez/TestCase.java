package bc15.fmartinez;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class TestCase {
    private WebDriver driver;

    @Test
    public void TC1_crearCuenta() throws InterruptedException {

        driver.get("https://open.spotify.com/intl-es");

        WebElement btnCerrarPopUp = driver.findElement(By.xpath("//button[@aria-label='Cerrar']"));

        if(btnCerrarPopUp.isDisplayed()){
            btnCerrarPopUp.click();
        }

        Thread.sleep(3000);

        By byBtnRegistrarse = By.xpath("//button[contains(text(), 'Regístrate')]");

        WebElement btnRegistrarse = driver.findElement(byBtnRegistrarse);

        btnRegistrarse.click();

        Thread.sleep(3000);

        driver.findElement(By.xpath("//input[@data-encore-id='formInput']")).sendKeys("user123bc15@gmail.com");

        Thread.sleep(3000);

        driver.findElement(By.xpath("//button[@data-encore-id='buttonPrimary']")).click();

        Thread.sleep(3000);

        driver.findElement(By.id("new-password")).sendKeys("Prueba12345!");

        Thread.sleep(3000);

        driver.findElement(By.xpath("//button[@data-encore-id='buttonPrimary']")).click();

        Thread.sleep(3000);

        driver.findElement(By.id("displayName")).sendKeys("Prueba12345");

        driver.findElement(By.id("day")).sendKeys("16");

        Select ddlMes = new Select(driver.findElement(By.id("month")));
        ddlMes.selectByVisibleText("Febrero");

        driver.findElement(By.id("year")).sendKeys("2002");

        List<WebElement> generos = driver.findElements(By.xpath("//label[contains(@for,'gender')]"));

        generos.get(0).click();
        Thread.sleep(1000);
        generos.get(1).click();
        Thread.sleep(1000);
        generos.get(2).click();
        Thread.sleep(1000);
        generos.get(3).click();
        Thread.sleep(1000);
        generos.get(4).click();
        Thread.sleep(1000);
        generos.get(0).click();
        Thread.sleep(1000);

        driver.findElement(By.xpath("//button[@data-testid='submit']")).click();

        Thread.sleep(1000);

        driver.findElement(By.xpath("//button[@data-encore-id='buttonPrimary']")).click();








        


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
    }

    @AfterEach
    public void posCondiciones(){
        //driver.close();
    }
}