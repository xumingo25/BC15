package bc15.aramos.Unidad1;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class TestCases {
    private WebDriver driver; //inicializa el webdriver

    @Test
    public void CP01_CrearCuenta_Spotify() throws InterruptedException {
        driver.get("https://open.spotify.com/intl-es");
        Thread.sleep(2000);


      By byBotonRegistrarse = By.xpath("//button[contains(text(),'Reg')]");
        WebElement botonRegristrarse = driver.findElement(byBotonRegistrarse);

        botonRegristrarse.click();

        Thread.sleep(3000);

        driver.findElement(By.xpath("//input[@id='username']")).sendKeys("userBootc150@gmail.com");


        WebElement botonCerrarPopUp = driver.findElement(By.xpath("//button[@aria-label='Cerrar']"));
        if(botonCerrarPopUp.isDisplayed()){
            botonCerrarPopUp.click();
        }

        Thread.sleep(2000);

        driver.findElement(By.xpath("//button[@data-testid='submit']")).click();

        Thread.sleep(2000);

        driver.findElement(By.name("new-password")).sendKeys("holaa12345");

        Thread.sleep(2000);

        driver.findElement(By.xpath("//button[@data-testid='submit']")).click();

        Thread.sleep(2000);

        driver.findElement(By.name("displayName")).sendKeys("UserTest BC15");

        driver.findElement(By.xpath("//input[@placeholder='dd']")).sendKeys(("12"));

        Thread.sleep(2000);

        Select mes = new Select (driver.findElement(By.id("month")));
        mes.selectByVisibleText("Marzo");

        driver.findElement(By.xpath("//input[@placeholder='aaaa']")).sendKeys("2000");

        List<WebElement> generos = driver.findElements(By.xpath("//label[contains(@for,'gender')]"));

        generos.get(1).click();
        Thread.sleep(1000);


        driver.findElement(By.xpath("//button[@data-testid='submit']")).click();
        Thread.sleep(1000);

        List<WebElement> checks = driver.findElements(By.xpath("//label[contains(@for,'checkbox-')]"));

        checks.get(0).click();
        Thread.sleep(1000);
        checks.get(1).click();
        Thread.sleep(1000);

        driver.findElement(By.xpath("//button[@data-testid='submit']")).click();
        Thread.sleep(1000);
    }

    @BeforeEach
    public void preCondiciones (){
        String rutaDriver = System.getProperty("user.dir") + "//src//test//resources//drivers//chromedriver.exe";
        //enlazar el webdriver a traves de property
        System.setProperty("webdriver.chrome.driver", rutaDriver);
        //testing
         driver = new ChromeDriver();

        //maximizar el browser
        driver.manage().window().maximize();

        //driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        //driver.manage().timeouts().setScriptTimeout(30, TimeUnit.SECONDS);
        //driver.manage().timeouts().pageLoadTimeout(45, TimeUnit.SECONDS);


    }

    @AfterEach
    public void posCondiciones(){
        //driver.close();
    }



}