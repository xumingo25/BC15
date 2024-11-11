package bc15;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ejemploSelenium1 {

    @Test
    public void ejemplo1() throws InterruptedException {
        String rutaDriver = System.getProperty("user.dir") +"\\src\\test\\resources\\drivers\\chromedriver.exe";

        //enlazar el webdriver a traves de property
        System.setProperty("webdriver.chrome.driver",rutaDriver);
        //testing
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.google.com");

        Thread.sleep(3000);

        System.out.println("El titulo de la página web es: "+driver.getTitle());

        System.out.println("La url actual es: "+ driver.getCurrentUrl());

        System.out.println("DOM: "+driver.getPageSource());


        driver.navigate().to("https://www.tsoftlatam.com");

        Thread.sleep(3000);

        System.out.println("El titulo de la página web es: "+driver.getTitle());

        System.out.println("La url actual es: "+ driver.getCurrentUrl());

        System.out.println("DOM: "+driver.getPageSource());

        Thread.sleep(3000);

        driver.navigate().back();

        Thread.sleep(3000);

        driver.navigate().forward();

        Thread.sleep(3000);

        driver.navigate().refresh();

        Thread.sleep(3000);

        driver.close();
    }
}
