package bc15.Mmercado;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class TestCases {
 private WebDriver driver;

    @Test
    public void CP001_CreacionCta_Spotify() throws InterruptedException {
        // Abre la página principal de Spotify
        driver.get("https://open.spotify.com/intl-es");
        Thread.sleep(3000);

        // Busca y hace clic en el botón de "Registrarse"
        By byBtnRegistrarse = By.xpath("//button[contains(text(),'Reg')]");

        WebElement btnRegistrarse = driver.findElement(byBtnRegistrarse);

        btnRegistrarse.click();

        Thread.sleep(3000);

        //Cerrar Pop-up
        WebElement btnCerrarPopUp = driver.findElement(By.xpath("//button[@aria-label='Cerrar']"));

        if(btnCerrarPopUp.isDisplayed()){
            btnCerrarPopUp.click();
        }

        Thread.sleep(1000);

        //entrar en la casilla de email
        WebElement email = driver.findElement(By.id("username"));
        email.sendKeys("unacuentaquenofueusadanunca@gmail.com");
        Thread.sleep(1000);

        // Darle click a Reegistrar
        driver.findElement(By.xpath("//button[@data-encore-id='buttonPrimary']")).click();
        Thread.sleep(1000);


        //Complete password
        driver.findElement(By.xpath
                ("//input[@id='new-password']")).sendKeys("Contraseña325.");

        Thread.sleep(1000);

        driver.findElement(By.xpath("//button[@data-testid='submit']")).click();

        // Ingresar Nombre de usuario

        driver.findElement(By.xpath
                ("//input[@id='displayName']")).sendKeys("usuario325xD");

        // Ingresa el Numero del Dia de Nacimiento o REF de la cuenta

        driver.findElement(By.xpath("//input[@placeholder='dd']")).sendKeys("26");
        Thread.sleep(1000);

        //Seleeciono la ventana desplegable y hago clic en el mes de Enero
        Select ddlMes = new Select(driver.findElement(By.id("month")));
        ddlMes.selectByVisibleText("Enero");
        Thread.sleep(1000);

        driver.findElement(By.xpath("//input[@id='year']")).sendKeys("1995");
        Thread.sleep(1000);




        // Verificar que se ha redirigido a la página de bienvenida o que se muestra un mensaje de éxito
       // String expectedUrl = "https://open.spotify.com/"; // URL de destino después del registro
        //String actualUrl = driver.getCurrentUrl();
        //Assertions.assertEquals(expectedUrl, actualUrl, "La cuenta debería haberse creado exitosamente.");
    }
        //tiene menú contextual

        /*@AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }*/
    @BeforeEach
    public void preCondiciones(){
        String rutaDriver = System.getProperty("user.dir") +"\\src\\test\\resources\\drivers\\chromedriver.exe";
        //enlazar el webdriver a traves de property
            System.setProperty("webdriver.chrome.driver",rutaDriver);
        // testing
        driver = new ChromeDriver();
        // maximizar el browser
        driver.manage().window().maximize();}

    }
