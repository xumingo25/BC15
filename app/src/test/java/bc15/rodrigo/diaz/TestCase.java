package bc15.rodrigo.diaz;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestCase {
    private WebDriver driver;

    @Test //crear test
    public void CP001_LoginCorrecto_saucedemo() throws InterruptedException { // Thread.sleep
        driver.get("https://www.saucedemo.com/v1/");
        Thread.sleep(3000);

       By username = By.xpath("//input[@id=\"user-name\"]");
       WebElement btn= driver.findElement(username);
       btn.sendKeys("standard_user");
        Thread.sleep(1000);

        By password = By.xpath("//input[@id=\"password\"]");
        WebElement btn2= driver.findElement(password);
        btn2.sendKeys("secret_sauce");
        Thread.sleep(1000);

        By login = By.xpath("//input[@id=\"login-button\"]");
        WebElement btn3= driver.findElement(login);
        btn3.click();
        Thread.sleep(6000);
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
    public void posCondiciones(){
        driver.close();
    }

}


