package bc15.agusVilla.unidad1;

import org.junit.jupiter.api.AfterEach;
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
        By byButtonSiguiente = By.xpath("//button[@data-testid='submit']");

        driver.get("https://open.spotify.com/intl-es");
        Thread.sleep(2000);

        WebElement registrarse = driver.findElement(byRegisterButton);
        registrarse.click();
        WebElement btnCerrarPopUp = wait.until(ExpectedConditions.presenceOfElementLocated(byClosePopUp));
        btnCerrarPopUp.click();

        WebElement inputEmail = wait.until(ExpectedConditions.presenceOfElementLocated(byInputEmail));
        inputEmail.sendKeys(email);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@data-encore-id='buttonPrimary']"))).click();
        Thread.sleep(3000);

        WebElement siguiente = driver.findElement(byButtonSiguiente);
        if (!inputEmail.getText().isEmpty()){
            siguiente.click();
            System.out.println("Se hizo click");
        }else{
            System.out.println("El campo de mail esta vacio");
        }


        /*
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

        //List<WebElement> list = driver.findElement(By.xpath());
        */
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

