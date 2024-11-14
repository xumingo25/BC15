package bc15.BenjaMontero.unidad2.BCI;

import bc15.BenjaMontero.unidad2.utils.BaseClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BaseClass {

    private String url = "https://www.bci.cl/personas";

    @FindBy(xpath = "//a[contains(text(), 'Hazte')]")
    WebElement btnRegister;

    public HomePage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void goToRegisterPage(){
        clickToElementClickable(btnRegister);
    }

    public void openPage(){
        this.driver.get(url);
    }
}
