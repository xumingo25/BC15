package bc15.aramos.Unidad1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;




public class OpenCart {
    private WebDriver driver;
    private WebDriverWait wait;

    @Test
    public void C001_AgregarAlCarrito() throws InterruptedException {
        driver.get("https://opencart.abstracta.us/");

        driver.findElement(By.xpath("//input[contains(@placeholder, 'Search')]")).sendKeys("Macbook");

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='btn btn-default btn-lg']"))).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("MacBook Air"))).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-cart"))).click();

        driver.findElement(By.id("cart-total")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("View Cart"))).click();

        driver.findElement(By.linkText("Checkout")).click();

        wait.until(ExpectedConditions.elementToBeClickable(By.id("button-account"))).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("input-payment-firstname"))).sendKeys("Juan");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("input-payment-lastname"))).sendKeys("Martinez");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("input-payment-email"))).sendKeys("JuanMartinez@gmail.com");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("input-payment-telephone"))).sendKeys("11583474");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("input-payment-address-1"))).sendKeys("av14324");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("input-payment-city"))).sendKeys("Tandil");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("input-payment-postcode"))).sendKeys("7000");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("input-payment-password"))).sendKeys("juan12345");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("input-payment-confirm"))).sendKeys("juan12345");

        List<WebElement> options = driver.findElements(By.id("input-payment-country"));

        options.get(0).click();
        Thread.sleep(2000);

        List<WebElement> select = driver.findElements(By.id("input-payment-zone"));
        select.get(0).click();
        Thread.sleep(1000);

        wait.until((ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='agree']")))).click();
        driver.findElement(By.id("button-register")).click();




    }







    @BeforeEach
    public void preCondiciones(){
        String rutaDriver = System.getProperty("user.dir") +"\\src\\test\\resources\\drivers\\chromedriver.exe";
        //enlazar el webdriver a traves de property
        System.setProperty("webdriver.chrome.driver",rutaDriver);

        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 20);
        //maximizar el browser
        driver.manage().window().maximize();
    }

}


