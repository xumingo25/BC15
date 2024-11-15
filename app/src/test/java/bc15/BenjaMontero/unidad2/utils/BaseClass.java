package bc15.BenjaMontero.unidad2.utils;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class BaseClass {

    protected WebDriver driver;
    protected WebDriverWait wait;

    protected BaseClass(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, 20);
    }

    protected void sendKeysToElementVisible(WebElement element, String value){
        wait.until(ExpectedConditions.visibilityOf(element));
        element.clear();
        element.sendKeys(value);
    }

    protected void sendKeysToElementVisible(WebElement element, Keys value){
        wait.until(ExpectedConditions.visibilityOf(element)).sendKeys(value);
    }

    protected void clickToElementClickable(WebElement element){
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }

    protected void moveToIframe(WebElement iframe){
        driver.switchTo().frame(iframe);
    }

    protected void clickElementByJavaScript(WebElement element){
        //WebElement presenceElement = wait.until(ExpectedConditions.visibilityOf(element));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", element);
    }

    protected String getTextByElement(WebElement element){
        return wait.until(ExpectedConditions.visibilityOf(element)).getText();
    }

    protected WebDriver getDriver() {
        return driver;
    }

    //protected void setDriver(WebDriver driver) {
    //    this.driver = driver;
    //}

    public static WebDriver generateDriver(String browser, String ruta,String property){
        if(browser.equalsIgnoreCase("Chrome")){
            System.setProperty(property,ruta);
           return new ChromeDriver();
        }
        if(browser.equalsIgnoreCase("Firefox")){
            System.setProperty(property,ruta);
            return new FirefoxDriver();
        }
        return null;
    }
    public static void setEspera(WebDriver driver){
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(5, TimeUnit.SECONDS);
    }

    public static void setMaximWindow(WebDriver driver){
        driver.manage().window().maximize();
    }
}
