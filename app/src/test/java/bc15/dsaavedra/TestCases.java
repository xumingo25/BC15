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

public class TestCases {
    private WebDriver driver;  //inicializar el webdriver

    @Test //crear test
    public void CP001_CreacionCta_Spotify() throws InterruptedException { // Thread.sleep
        driver.get("https://open.spotify.com/intl-es");
        Thread.sleep(2000);

        By byBtnRegistrarse = By.xpath("//button[@data-testid='signup-button']");

        WebElement btnRegistrarse = driver.findElement(byBtnRegistrarse);

        btnRegistrarse.click();

        Thread.sleep(2000);

        driver.findElement(By.id("username")).sendKeys("userbc1500001@gmail.com");

        WebElement btnCerrarPopUp = driver.findElement(By.xpath("//button[@aria-label='Cerrar']"));

        if(btnCerrarPopUp.isDisplayed()){
            btnCerrarPopUp.click();
        }

        driver.findElement(By.xpath("//button[@data-testid='submit']")).click();

        Thread.sleep(2000);

        driver.findElement(By.name("new-password")).sendKeys("qwerty12345@");

        Thread.sleep(2000);

        driver.findElement(By.xpath("//button[@data-testid='submit']")).click();

    }

    @Test
    public void CP002_CreacionCta_SpotifyNOOK_MailVacio() throws InterruptedException {
        driver.get("https://open.spotify.com/intl-es");
        Thread.sleep(3000);
        By byBtnRegistrarse = By.xpath("//button[contains(text(),'Regis')]");

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
