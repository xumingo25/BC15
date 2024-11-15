package bc15.agusVilla;

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

public class TC001 {
    private WebDriver driver;

    @Test
    public void CP001_registro() throws InterruptedException{
        //driver.findElement(By.xpath());
        driver.get("https://open.spotify.com/intl-es");
        Thread.sleep(3000);
        WebElement registrarse = driver.findElement(By.xpath("//*[@id='global-nav-bar']/div[3]/div/button[1]"));
        if (registrarse.isDisplayed()){
            registrarse.click();
        }

        //Datos Test
        String email = "mailEjemplo@gmail.com";
        String contrasena = "123contrasena!";
        String nombre = "Juan Perez";
        WebElement btnCerrarPopUp = driver.findElement(By.xpath("//button[@aria-label='Cerrar']"));

        if(btnCerrarPopUp.isDisplayed()){
            btnCerrarPopUp.click();
        }

        //Email class="Input-sc-1gbx9xe-0 hRUqRg encore-text-body-medium"
        Thread.sleep(2000);
        WebElement inputEmail = driver.findElement(By.xpath("//input[@id='username']"));
        if (inputEmail.isDisplayed()){
            inputEmail.sendKeys(email);
        }
        driver.findElement(By.xpath("//button[@data-testid='submit']")).click();

        Thread.sleep(2000);
        //Contraseña
        WebElement inputContra = driver.findElement(By.xpath("//*[@id='new-password']"));
        if (inputContra.isDisplayed()){
            inputContra.sendKeys(contrasena);
        }
        driver.findElement(By.xpath("/html/body/div[1]/main/main/section/div/form/button/span[1]")).click();

        //Nombre
        WebElement inputNombre = driver.findElement(By.xpath("//*[@id='displayName']"));
        if (inputNombre.isDisplayed()){
            inputNombre.sendKeys(nombre);
        }

        //Nacimiento
        //Dia


        //Mes
        WebElement comboMes = driver.findElement(By.id("month"));
        Select selector = new Select(comboMes);
        selector.selectByVisibleText("Enero");

        List<WebElement> list = driver.findElement(By.xpath());
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
