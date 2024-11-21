package bc15.rodrigoDiaz.Unidad2.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class MetodosGenericos {
    //Atributos------------------------------------------------------------------------------------
    protected WebDriver driver;
    protected WebDriverWait wait;
    //métodos------------------------------------------------------------------------------------


    public MetodosGenericos(WebDriver driver) {
        this.driver = driver;
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    //acciones genericas wrapper de la libreria de selenium
    public void cargarSitio(String url){ this.driver.get(url);
    }

    //Driver------------------------------------------------------------------------------------
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

    //Web element------------------------------------------------------------------------------------
    public WebElement buscarElementoWeb(By localizador){
        return this.driver.findElement(localizador);
    }

    public List<WebElement> buscarElementosWeb(By localizador){
        return this.driver.findElements(localizador);
    }

    public boolean estaDesplegado(WebElement elemento){
        try {
            return  elemento.isDisplayed();
        }catch (org.openqa.selenium.NoSuchElementException e){
            return false;
        }
    }

    //Click------------------------------------------------------------------------------------

    public void click(By localizador){
        this.driver.findElement(localizador).click();
    }

    public void click(WebElement elemento){  elemento.click();
    }

    public void click(WebElement elemento,int segundos){
        wait = new WebDriverWait(this.driver,segundos);
        wait.until(ExpectedConditions.elementToBeClickable(elemento));
        elemento.click();
    }

    //frame------------------------------------------------------------------------------------
    public void cambiarAFrame(WebElement elemento,int segundos){
        wait = new WebDriverWait(this.driver,segundos);
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(elemento));
    }


    public void moverPantalla(By by) {
        WebElement element = driver.findElement(by);  // Encuentra el elemento usando el By proporcionado
        JavascriptExecutor js = (JavascriptExecutor) this.driver;
        // Usamos 'scrollIntoView' con opciones para evitar que el elemento se salga de la pantalla
        js.executeScript("arguments[0].scrollIntoView({block: 'center', inline: 'nearest'});", element);
    }
    public void moverPantalla(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) this.driver;
        // Usamos 'scrollIntoView' con opciones para evitar que el elemento se salga de la pantalla
        js.executeScript("arguments[0].scrollIntoView({block: 'center', inline: 'nearest'});", element);
    }

    public void seleccionarCheckbox(WebElement element){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();",element);
    }


    //waits------------------------------------------------------------------------------------

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

    public WebElement esperaExplicita(WebElement element,int segundos){
        wait = new WebDriverWait(this.driver,segundos);
        return wait.until(ExpectedConditions.visibilityOf(element));
    }


    //text------------------------------------------------------------------------------------
    public String getText(WebElement elemento){
        return    elemento.getText();
    }

    public void agregarTexto(By localizador,String texto){
        this.driver.findElement(localizador).sendKeys(texto);
    }

    public void agregarTexto(WebElement elemento,String texto){
        wait.until(ExpectedConditions.visibilityOf(elemento));
        elemento.clear();
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

    public String obtenerTextoAtributo(WebElement elemento, String texto){
        return elemento.getAttribute(texto);
    }

}
