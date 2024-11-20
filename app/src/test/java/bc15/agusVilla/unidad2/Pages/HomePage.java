package bc15.agusVilla.unidad2.Pages;

import bc15.agusVilla.unidad2.utils.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BaseClass {
    By byLocatorBtnRegistrarse = By.xpath("//buon[contains(text)]");

    public HomePage(WebDriver driver){
        super(driver);
    }

}
