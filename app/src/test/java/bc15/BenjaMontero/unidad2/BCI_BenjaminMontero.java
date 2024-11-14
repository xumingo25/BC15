package bc15.BenjaMontero.unidad2;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BCI_BenjaminMontero {

    private WebDriver driver;
    private WebDriverWait wait;

    @Test
    void tc001_CreateAccount() throws InterruptedException {
        driver.get("https://www.bci.cl/personas");

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(), 'Hazte')]"))).click();
        Thread.sleep(6000);
        WebElement iframe = driver.findElement(By.id("myFrame"));
        driver.switchTo().frame(iframe);

        //ingreso rut
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Ingresa tu RUT']"))).sendKeys("10863075-2");
        //Thread.sleep(6000);
        //ingreso doc
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(" //input[contains(@placeholder, 'Ingresa número')]"))).sendKeys("100.000.000");
        //ingreso num
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(" //input[contains(@placeholder, 'Ingresa tu teléfono')]"))).sendKeys("44492923");
        //ingreso email
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(" //input[contains(@placeholder, 'Ingresa tu email')]"))).sendKeys("benjatest@gmail.com");
        //ingreso confirmacion de email
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(" //input[contains(@placeholder, 'Vuelve a ingresar tu email')]"))).sendKeys("benjatest@gmail.com");
        //click para sacar el label que aparece abajo
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(" //input[contains(@placeholder, 'Ingresa tu teléfono')]"))).click();
        //terminos y condiciones
        WebElement btnCheckbox = driver.findElement(By.id("bci-wk-checkbox0"));
        JavascriptExecutor js = (JavascriptExecutor) driver;

        // Hacer clic sobre el checkbox usando JavaScript
        js.executeScript("arguments[0].click();", btnCheckbox);

        //btn continuar
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(), 'Continuar')]"))).click();

        WebElement pText = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//p[@class='tituloError']")));
        System.out.println("este es el texto del parrafo " + pText.getText());
        String textoValido1 = "No es posible la apertura de la cuenta";
        String textoValido2 = "Acceso bloqueado temporalmente";
        if(pText.getText().equalsIgnoreCase(textoValido1)){
            Assertions.assertEquals(textoValido1, pText.getText());
        }else if(pText.getText().equalsIgnoreCase(textoValido2)){
            Assertions.assertEquals(textoValido2, pText.getText());
        }else{
            //fuerzo el fallo
            Assertions.assertEquals(1, 2);
        }
    }



    @BeforeEach
    public void preCondiciones() {
        String rutaDriver = System.getProperty("user.dir") +"\\src\\test\\resources\\drivers\\chromedriver.exe";
        //enlazar el webdriver a traves de property
        System.setProperty("webdriver.chrome.driver",rutaDriver);

        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 20);
        //maximizar el browser
        driver.manage().window().maximize();
    }

    @AfterEach
    public void posCondiciones(){
        driver.close();
    }
}
