package bc15.agusVilla.unidad2.BCI.Pages;

import bc15.agusVilla.unidad2.BCI.utils.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;

public class RegisterPage extends BaseClass {
    public RegisterPage(WebDriver driver, WebDriverWait wait){
        super(driver, wait);
    }
    /*
    WebElement btnCheckbox = driver.findElement(By.id("bci-wk-checkbox0"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", btnCheckbox);
    */

    //Centralizamos localizadores
    By byRut = By.xpath("//input[@placeholder='Ingresa tu RUT']");
    By byInputDNI = By.xpath("//input[@placeholder='Ingresa número']");
    By byTel = By.xpath("//input[@placeholder='Ingresa tu teléfono']");
    By byMail = By.xpath("//input[@placeholder='Ingresa tu email']");
    By byMailConfirmed = By.xpath("//input[@placeholder = 'Vuelve a ingresar tu email']");
    By checkFinal = By.xpath("//input[@name='bci-wk-checkbox0']"); //input[@name='bci-wk-checkbox0']
    By byNext = By.xpath("//button[text()='Continuar']");
    By byPoliticas = By.xpath("//a[class='politicasLink']");

    //Acciones de la pagina
    public void fill() throws InterruptedException {
        wait.until(ExpectedConditions.presenceOfElementLocated(byRut)).sendKeys("14951864-9");
        if (driver.findElement(byRut).isDisplayed()){
            buscarWebElement(byInputDNI).sendKeys("149518640");
            buscarWebElement(byTel).sendKeys("34543456");
            buscarWebElement(byMail).sendKeys("ejemploTestBC15@gmail.com");
            buscarWebElement(byMailConfirmed).sendKeys("ejemploTestBC15@gmail.com");

            Thread.sleep(1000);
            //buscarWebElement(checkFinal).submit();
            //buscarWebElement(checkFinal).click();
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", buscarWebElement(checkFinal));
            Thread.sleep(1000);
        }
        wait.until(ExpectedConditions.elementToBeClickable(byNext)).click();
    }

}
