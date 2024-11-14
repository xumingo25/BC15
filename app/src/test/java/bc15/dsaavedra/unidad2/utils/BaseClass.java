package bc15.dsaavedra.unidad2.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class BaseClass {
    //Atributos
    protected WebDriver driver;
    protected WebDriverWait wait;
    //métodos


    public BaseClass(WebDriver driver) {
        this.driver = driver;
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    //acciones genericas wrapper de la libreria de selenium
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

    public void click(WebElement elemento){
        elemento.click();
    }

    public void esperarXSegundos(int milisegundos){
        try {
            Thread.sleep(milisegundos);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public WebElement esperaExplicita(By localizador,int segundos){
        wait = new WebDriverWait(this.driver,segundos);
        return wait.until(ExpectedConditions.presenceOfElementLocated(localizador));
    }

    public void agregarTexto(By localizador,String texto){
        this.driver.findElement(localizador).sendKeys(texto);
    }

    public void agregarTexto(WebElement elemento,String texto){
        elemento.sendKeys(texto);
    }

    public void cerrarBrowser(){
        this.driver.close();
    }

    public void maximizarBrowser(){
        this.driver.manage().window().maximize();
    }

    public void seleccionarDDlPorTexto(WebElement elemento,String texto){
        Select select = new Select(elemento);
        select.selectByVisibleText(texto);
    }

    public void irAIframeXElementoWeb(WebElement elemento){
        this.driver.switchTo().frame(elemento);
    }

    public WebDriver conexionDriver(String browser, String ruta,String property){
        if(browser.equalsIgnoreCase("Chrome")){
            System.setProperty(property,ruta);
            this.driver = new ChromeDriver();
        }
        if(browser.equalsIgnoreCase("Firefox")){
            System.setProperty(property,ruta);
            this.driver = new FirefoxDriver();
        }
        return this.driver;
    }

    public boolean estaDesplegado(WebElement elemento){
        try {
            return  elemento.isDisplayed();
        }catch (org.openqa.selenium.NoSuchElementException e){
            return false;
        }
    }




}
