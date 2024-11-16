package bc15.Mmercado.Unidad1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

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

        //Cerrar Pop-up "la ventana emergente"
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

        // Encuentra e Ingresar un Nombre de usuario
        driver.findElement(By.xpath
                ("//input[@id='displayName']")).sendKeys("usuario325xD");

        // Encuentra e Ingresa el Numero del Dia de Nacimiento o REF de la cuenta
        driver.findElement(By.xpath("//input[@placeholder='dd']")).sendKeys("26");
        Thread.sleep(1000);

        //Seleeciono la ventana desplegable y hago clic en el mes de Enero
        Select ddlMes = new Select(driver.findElement(By.id("month")));
        ddlMes.selectByVisibleText("Enero");
        Thread.sleep(1000);

        //Encuentra e Ingresa el año de Nacimiento en la casilla
        driver.findElement(By.xpath("//input[@id='year']")).sendKeys("1995");
        Thread.sleep(1000);

        // Busca dentro de un Label con un for el genero
        List<WebElement> generos = driver.findElements(By.xpath("//label[contains(@for,'gender')]"));

        //Aqui recorre todos los botones para seleccionar el tipo de genero adecuado
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

        // Aqui Selecciona el genero que definimos
        driver.findElement(By.xpath("//button[@data-testid='submit']")).click();
        Thread.sleep(1000);

        //Encuentra y Selecciona los terminos y condiciones de la pagina
        List<WebElement> checklist = driver.findElements(By.xpath("//label[contains(@for,'checkbox-')]"));
        checklist.get(0).click(); // La posicion cera 0 ya que es el primer casillero
        //Thread.sleep(1000);
        checklist.get(1).click(); // La posicion cera 1 ya que es el segundo casillero
        Thread.sleep(1000);


        // Hace clic en boton registrar
        driver.findElement(By.xpath("//button[@data-testid='submit']")).click();
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
