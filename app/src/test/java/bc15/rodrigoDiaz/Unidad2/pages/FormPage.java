package bc15.rodrigoDiaz.Unidad2.pages;

import bc15.rodrigoDiaz.Unidad2.utils.MetodosGenericos;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FormPage extends MetodosGenericos {
    public FormPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }


    //Centralizar Localizadores

    @FindBy(id="myFrame")
    WebElement iframe;
    @FindBy(xpath="//input[@placeholder=\"Ingresa tu RUT\"]")
    WebElement inputRut;
    @FindBy(xpath="//input[@placeholder=\"Ingresa número\"]")
    WebElement inputDNI;
    @FindBy(xpath="//input[@placeholder=\"Ingresa tu teléfono\"]")
    WebElement inputCelular;
    @FindBy(xpath=" //input[@placeholder=\"Ingresa tu email\"]")
    WebElement inputEmail ;
    @FindBy(xpath="//input[@placeholder=\"Vuelve a ingresar tu email\"]")
    WebElement inputReingresarEmail ;
    @FindBy(xpath="//button[@class=\"bci-wk-btn bci-wk-btn--primary\"]")
    WebElement btnContinuar;
    @FindBy(xpath="//input[@id=\"bci-wk-checkbox0\"]")
    WebElement checkboxTerminosYCondidiones;
    @FindBy(xpath="//p[@class=\"tituloError\"]")
    WebElement textNosepudo;



    //Acciones de pagina
    public void RegistrarCtaBci (String rut,int dni,int cel,String email,String email2) throws InterruptedException {
        cambiarAFrame(iframe,15);
        agregarTexto(esperaExplicita(inputRut,10),rut);
        agregarTexto(esperaExplicita(inputDNI,10), String.valueOf(dni));
        agregarTexto(esperaExplicita(inputCelular,10), String.valueOf(cel));
        agregarTexto(esperaExplicita(inputEmail,10),email);
        agregarTexto(esperaExplicita(inputReingresarEmail,10),email2);
        moverPantalla(btnContinuar);
        esperarXSegundos(5);
        seleccionarCheckbox(checkboxTerminosYCondidiones);
        click(btnContinuar,10);

    }
    public void validarTexto(String text) throws InterruptedException {
        esperaExplicita(textNosepudo,10);
        Assertions.assertEquals(text,getText(textNosepudo));
    }
}
