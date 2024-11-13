package bc15.gAcevedo.TestCaseBci;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestCaseBCI {

    private WebDriver driver;
    private WebDriverWait wait;
    @Test
    public void TP01_Register() throws InterruptedException{
        driver.get("https://www.bci.cl/personas");
        //wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='closeModalHome']"))).click();
        WebElement btnCerrarPopUp = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='closeModalHome']")));
        if(btnCerrarPopUp.isDisplayed()){
            btnCerrarPopUp.click();
        }
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'Hazte Cliente')]"))).click();
        //switch To IFrame using Web Element
        WebElement iframe = driver.findElement(By.id("myFrame"));
        //Switch to the frame
        driver.switchTo().frame(iframe);
        assertEquals(true, driver.getPageSource().contains("We Leave From Here"));
        //Now we can type text into email field
        WebElement emailE= driver.findElement(By.xpath("//input[@placeholder='Ingresa tu RUT']"));
        emailE.sendKeys("user.user@user.com");
    }

    @BeforeEach
    public void preCondiciones() {
        String rutaDriver = System.getProperty("user.dir") + "\\src\\test\\resources\\drivers\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", rutaDriver);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver,20);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(30,TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(45,TimeUnit.SECONDS);
    }
}
