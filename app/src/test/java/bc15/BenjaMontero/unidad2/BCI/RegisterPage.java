package bc15.BenjaMontero.unidad2.BCI;

import bc15.BenjaMontero.unidad2.utils.BaseClass;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage extends BaseClass {

    @FindBy(xpath = "//input[@placeholder='Ingresa tu RUT']")
    WebElement inputRUT;
    @FindBy(xpath = "//input[contains(@placeholder, 'Ingresa número')]")
    WebElement inputNumberDoc;
    @FindBy(xpath = "//input[contains(@placeholder, 'Ingresa tu teléfono')]")
    WebElement inputNumberTel;
    @FindBy(xpath = "//input[contains(@placeholder, 'Ingresa tu email')]")
    WebElement inputEmail;
    @FindBy(xpath = "//input[contains(@placeholder, 'Vuelve a ingresar tu email')]")
    WebElement inputConfirmEmail;
    @FindBy(id = "bci-wk-checkbox0")
    WebElement btnCheckBox;
    @FindBy(xpath = "//button[contains(text(), 'Continuar')]")
    WebElement btnContinue;
    @FindBy(xpath = "//p[@class='tituloError']")
    WebElement textErrorCreateAccount;
    @FindBy(id = "myFrame")
    WebElement iFrame;

    public RegisterPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void createAccount(String rut, String email, String numberDoc, String numberTel){
        this.moveToIframe(this.iFrame);
        this.sendKeysToElementVisible(this.inputRUT, rut);
        this.sendKeysToElementVisible(this.inputNumberDoc, numberDoc);
        this.sendKeysToElementVisible(this.inputNumberTel, numberTel);
        this.sendKeysToElementVisible(this.inputEmail, email);
        this.sendKeysToElementVisible(this.inputConfirmEmail, email);
        this.clickElementByJavaScript(this.btnCheckBox);
        this.sendKeysToElementVisible(this.inputEmail, Keys.PAGE_DOWN);
        this.clickToElementClickable(this.btnContinue);
    }

    public String getTextErrorRegister(){
        return getTextByElement(this.textErrorCreateAccount);
    }

}
