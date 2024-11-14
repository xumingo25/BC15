package bc15.rodrigo.Unidad2;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;



public class BciTestCase {
    private WebDriver driver;

    @Test //crear test
    public void CP001_Abrir() throws InterruptedException { // Thread.sleep
        driver.get("https://www.bci.cl/personas");
        Thread.sleep(3000);


        By hazteclientebtn = By.xpath("//a[text()=\"Hazte Cliente\"]");
        WebElement btn1= driver.findElement(hazteclientebtn);
        btn1.click();
        Thread.sleep(9000);

        WebElement iframe=driver.findElement(By.id("myFrame"));
        driver.switchTo().frame(iframe);
        Thread.sleep(2000);

        By abt=By.xpath("//input[@placeholder=\"Ingresa tu RUT\"]");
        WebElement btn2=driver.findElement(abt);
        btn2.sendKeys("3.683.925-2");
        Thread.sleep(2000);

        By abt1=By.xpath("//input[@placeholder=\"Ingresa número\"]");
        WebElement btn3=driver.findElement(abt1);
        btn3.sendKeys( "523.225.038");
        Thread.sleep(2000);

        //input[@placeholder="Ingresa tu teléfono"]
        By abt2=By.xpath("//input[@placeholder=\"Ingresa tu teléfono\"]");
        WebElement btn4=driver.findElement(abt2);
        String input = "112348";
        int number = Integer.parseInt(input);
        btn4.sendKeys("3804 9737");
        Thread.sleep(2000);

        //input[@placeholder="Ingresa tu email"]
        By abt3=By.xpath(" //input[@placeholder=\"Ingresa tu email\"]");
        WebElement btn5=driver.findElement(abt3);
        btn5.sendKeys("juanto@mail.com");
        Thread.sleep(2000);

        //input[@placeholder="Vuelve a ingresar tu email"]
        By abt4=By.xpath("//input[@placeholder=\"Vuelve a ingresar tu email\"]");
        WebElement btn6=driver.findElement(abt4);
        btn6.sendKeys("juanto@mail.com");
        Thread.sleep(2000);

        //label[@class="bci-wk-label__checkbox"]
        By abt5=By.xpath("//lavel[@class=\"bci-wk-label__checkbox\"]");
        WebElement btn7=driver.findElement(abt5);
        btn7.click();
        Thread.sleep(2000);

        //button[@class="bci-wk-btn bci-wk-btn--primary"]
        By abt6=By.xpath(" //button[@class=\"bci-wk-btn bci-wk-btn--primary\"]");
        WebElement btn8=driver.findElement(abt6);
        btn8.click();
        Thread.sleep(2000);



    }@BeforeEach
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
