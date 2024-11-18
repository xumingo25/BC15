package bc15.agusVilla.unidad2.BCI.Pages;

import bc15.agusVilla.unidad2.BCI.utils.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class HomePage extends BaseClass {
    By byLocatorBtnRegistrarse = By.xpath("//a[text()='Hazte Cliente']");

    public HomePage(WebDriver driver, WebDriverWait wait){
        super(driver, wait);
    }

    public void registerUser() throws InterruptedException {
        esperaExplicitaVisible(byLocatorBtnRegistrarse, 3);
        click(buscarWebElement(byLocatorBtnRegistrarse));
    }
}
