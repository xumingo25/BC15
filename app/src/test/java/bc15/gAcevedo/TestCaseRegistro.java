package bc15.gAcevedo;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class TestCaseRegistro {

    private WebDriver driver;

    @Test
    public void TP01createAccountSpotify() throws InterruptedException{
        driver.get("https://open.spotify.com/intl-es");
        Thread.sleep(1000);

        driver.findElement(By.xpath("//button[@data-testid ='signup-button']")).click();

        WebElement btnCerrarPopUp = driver.findElement(By.xpath("//button[@aria-label ='Close']"));

        if(btnCerrarPopUp.isDisplayed()){
            btnCerrarPopUp.click();
        }
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@name='username']")).sendKeys("userpruebabootcamp@gmail.com");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//button[@data-encore-id='buttonPrimary']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@id='new-password']")).sendKeys("Contrasena1234");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//button[@data-encore-id='buttonPrimary']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@id='displayName']")).sendKeys("Contrasena1234");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@id='day']")).sendKeys("11");
        Select mes = new Select(driver.findElement(By.id("month")));
        mes.selectByVisibleText("Diciembre");



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
        public void posCondiciones() throws InterruptedException {
            //driver.close();
            Thread.sleep(3000);
            //driver.close();
        }
}