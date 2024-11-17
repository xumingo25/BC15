package bc15.griquieri.Unidad2.utils;

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
    //Atrib
    protected WebDriver driver;
    protected WebDriverWait wait;


    //Metodos
    public BaseClass(WebDriver driver){
        this.driver = driver;
    }//Seteo de driver

    public WebDriver getDriver() {
        return driver;
    }
    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    //Metodos Genéricos = wrapper de la librería de Selenium
    public void cargarPagina(String url){
        this.driver.get(url);
    } //Carga la página web

    public WebElement buscarElemento (By locator){
        return this.driver.findElement(locator);
    }//Busca un solo elemento

    public List<WebElement> buscarElementos (By locator){
        return this.driver.findElements(locator);
    }//Busca una lista de elementos

    public void click (By locator){
        this.driver.findElement(locator).click();
    }//Hace click en un elemento

    public void click (WebElement element){
        element.click();
    }//Hace click en un elemento

    public void esperarXMilisegundos(int milisegundos) {
        try {
            Thread.sleep(milisegundos);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public WebElement esperaExplicita (By locator, int seg){
        wait = new WebDriverWait(this.driver,seg);
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public void  agregarTexto(By locator, String texto){
        this.driver.findElement(locator).sendKeys(texto);
    }

    public void  agregarTexto(WebElement element, String texto){
        element.sendKeys(texto);
    }

    public void cerrar(){
        this.driver.close();
    }

    public void maximize(){
        this.driver.manage().window().maximize();
    }

    public void ddlXText(WebElement element,String text){
        Select select = new Select(element);
        select.selectByVisibleText(text);
    }

    public void iFrameXElement(WebElement element){
        this.driver.switchTo().frame(element);
    }

    public WebDriver conexionDriver(String browser, String route, String property){
        if (browser.equalsIgnoreCase("Chrome")){
            System.setProperty(property,route);
            this.driver = new ChromeDriver();
        }

        if (browser.equalsIgnoreCase("Firefox")){
            System.setProperty(property,route);
            this.driver = new FirefoxDriver();
        }
        return this.driver;
    }

    public boolean isDeployed(WebElement element){
        try {
            return element.isDisplayed();
        }catch (org.openqa.selenium.NoSuchElementException e){
            return false;
        }
    }



}
