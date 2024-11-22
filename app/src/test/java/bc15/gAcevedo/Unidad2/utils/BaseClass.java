package bc15.gAcevedo.Unidad2.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class BaseClass {
    protected WebDriver driver;
    protected WebDriverWait wait;

    //Constructor
    public BaseClass(WebDriver driver) {
        this.driver = driver;
    }
    //Getter and Setters
    public WebDriverWait getWait() {
        return wait;
    }

    public void setWait(WebDriverWait wait) {
        this.wait = wait;
    }
    //Acciones libreria selenium
    public void cargarSitio(String url){
        this.driver.get(url);
    }
    public WebElement buscarElementoWeb(By localizador){
        return this.driver.findElement(localizador);
    }
    public List<WebElement> buscarElementosWeb(By localizador){
        return this.driver.findElements(localizador);
    }
    public void click(By localizador){
        this.driver.findElement(localizador).click();
    }
    public void click(WebElement element){
        element.click();
    }
    public void esperarNSegundos(int milisegundos){
        try{
            Thread.sleep(milisegundos);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public WebElement esperaExplicita(By localizador, int segundos){
        wait = new WebDriverWait(this.driver,segundos);
        return wait.until(ExpectedConditions.presenceOfElementLocated(localizador));
    }
    public void agregarTexto(By localizador,String text){
        this.driver.findElement(localizador).sendKeys(text);
    }
    public void agregarTexto(WebElement element, String text){
        element.sendKeys(text);
    }
    public void cerrarBrowser(){
        this.driver.close();
    }
    public void maximizarBrowser(){
        this.driver.manage().window().maximize();
    }
    public void seleccionarDDlPorTexto(WebElement element, String text){
        Select select = new Select(element);
        select.selectByVisibleText(text);
    }
    public void irAIframeElementoWeb(WebElement element){
        this.driver.switchTo().frame(element);
    }
    public WebDriver conexionDriver(String browser){
        if(browser.equalsIgnoreCase("Chrome")){
            WebDriverManager.chromedriver().setup();
            this.driver = new ChromeDriver();
        }
        if(browser.equalsIgnoreCase("Firefox")){
            WebDriverManager.firefoxdriver().setup();
            this.driver = new FirefoxDriver();
        }
        if(browser.equalsIgnoreCase("Edge")){
            WebDriverManager.edgedriver();
            this.driver = new EdgeDriver();
        }
        return  this.driver;
    }
    public boolean estaDesplegado(WebElement element){
        try{
            return element.isDisplayed();
        } catch (org.openqa.selenium.NoSuchElementException e) {
            return false;
        }
    }
    public String obtenerTextoAtributo(WebElement element, String text){
        return element.getAttribute(text);
    }
}
