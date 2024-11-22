package bc15.gAcevedo.Unidad2.pages;

import bc15.gAcevedo.Unidad2.utils.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BaseClass {
    By byLocalizadorHombreSection = By.xpath("//h3[contains(text(),'Hombre')]");


    public HomePage(WebDriver driver){
        super(driver);
    }

    public void SectionHombre(){
        click(esperaExplicita(byLocalizadorHombreSection,10));
    }
}
