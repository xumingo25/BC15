package bc15.dsaavedra;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestCases {
    private WebDriver driver;

    @Test
    public void CP001_CreacionCta_Spotify() throws InterruptedException {
        driver.get("https://open.spotify.com/intl-es");
        Thread.sleep(3000);
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

        String resultadoEsperado = "Este correo electrónico no es válido. Asegúrate de que tenga un formato como este: ejemplo@email.com";
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
