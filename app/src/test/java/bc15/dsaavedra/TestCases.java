package bc15.dsaavedra;

import bc15.dsaavedra.utils.Encoding;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class TestCases {
    private WebDriver driver;  //inicializar el webdriver

    @Test //crear test
    public void CP001_CreacionCta_Spotify() throws InterruptedException { // Thread.sleep
        driver.get("https://open.spotify.com/intl-es");
        Thread.sleep(1000);

        By byBtnRegistrarse = By.xpath("//button[@data-testid='signup-button']");

        WebElement btnRegistrarse = driver.findElement(byBtnRegistrarse);

        btnRegistrarse.click();

        Thread.sleep(1000);

        driver.findElement(By.name("username")).sendKeys("userbc1500101@gmail.com");

        Thread.sleep(1000);

        WebElement btnCerrarPopUp = driver.findElement(By.xpath("//button[@aria-label='Cerrar']"));

        if(btnCerrarPopUp.isDisplayed()){
            btnCerrarPopUp.click();
        }

        Thread.sleep(1000);


        driver.findElement(By.xpath("//button[@data-testid='submit']")).click();

        Thread.sleep(2000);

        driver.findElement(By.name("new-password")).sendKeys("qwerty12345@");

        Thread.sleep(1000);

        driver.findElement(By.xpath("//button[@data-testid='submit']")).click();

        Thread.sleep(1000);

        driver.findElement(By.name("displayName")).sendKeys("User BC 00001");

        driver.findElement(By.xpath("//input[@placeholder='dd']")).sendKeys("31");


        Thread.sleep(1000);

        Select ddlMes =new Select(driver.findElement(By.id("month")));
        ddlMes.selectByVisibleText("Diciembre");

        driver.findElement(By.xpath("//input[@placeholder='aaaa']")).sendKeys("1999");

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

        List<WebElement> checks = driver.findElements(By.xpath("//label[contains(@for,'checkbox-')]"));

        checks.get(0).click();
        Thread.sleep(1000);
        checks.get(1).click();
        Thread.sleep(1000);
        checks.get(0).click();
        Thread.sleep(1000);
        checks.get(1).click();
        checks.get(0).click();
        Thread.sleep(1000);
        checks.get(1).click();
        Thread.sleep(1000);

        driver.findElement(By.xpath("//button[@data-testid='submit']")).click();
        Thread.sleep(1000);

        String resultadoEsperado = "User BC 00001";
        String resultadoActual = driver.findElement(By.xpath("//button[@data-testid='user-widget-link']")).getAttribute("aria-label");

        Assertions.assertEquals(resultadoEsperado,resultadoActual);

    }

    @Test
    public void CP002_CreacionCta_SpotifyNOOK_MailVacio() throws InterruptedException {
        driver.get("https://open.spotify.com/intl-es");
        Thread.sleep(3000);
        By byBtnRegistrarse = By.xpath("//button[contains(text(),'Reg')]");

        WebElement btnRegistrarse = driver.findElement(byBtnRegistrarse);

        btnRegistrarse.click();

        Thread.sleep(3000);

        WebElement btnCerrarPopUp = driver.findElement(By.xpath("//button[@aria-label='Cerrar']"));

        if(btnCerrarPopUp.isDisplayed()){
            btnCerrarPopUp.click();
        }

        driver.findElement(By.xpath("//button[@data-encore-id='buttonPrimary']")).click();

        Thread.sleep(3000);

        String resultadoEsperado = Encoding.corregirEncoding("Este correo electrónico no es válido. Asegúrate de que tenga un formato como este: ejemplo@email.com");
        String resultadoActual = driver.findElement(By.xpath("//span[contains(text(),'Este correo')]")).getText();

        Assertions.assertEquals(resultadoEsperado,resultadoActual);



    }

    //Esta dirección ya está vinculada a una cuenta. Para continuar, inicia sesión.

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
