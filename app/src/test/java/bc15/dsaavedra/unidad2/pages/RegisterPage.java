package bc15.dsaavedra.unidad2.pages;

import bc15.dsaavedra.unidad2.utils.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage extends BaseClass {
    //Centralizar Localizadores
    By byTxtUserame = By.id("username");
    By byBtnCerrarPopUp = By.xpath("//button[@aria-label='Cerrar']");
    By byBtnSiguiente = By.xpath("//button[@data-testid='submit']");
    By byTxtPassword = By.name("new-password");
    By byTxtDisplayName = By.name("displayName");
    By byTxtDia = By.xpath("//input[@placeholder='dd']");
    By byTxtMes =By.id("month");
    By byTxtAnnio = By.xpath("//input[@placeholder='aaaa']");
    By byOptionGenders = By.xpath("//label[contains(@for,'gender')]");
    By byChksPreferences = By.xpath("//label[contains(@for,'checkbox-')]");

    //Acciones de pagina
    public void crearCtaSpotify(String mail,String password,String username,int dia,String mes,int annio,int genero,boolean chkMarketing,boolean chkConpartirInfo){
        agregarTexto(esperaExplicita(byTxtUserame,10),mail);
        if(estaDesplegado(esperaExplicita(byBtnCerrarPopUp,10))){
            click(esperaExplicita(byBtnCerrarPopUp,10));
        }
        siguiente();
        agregarTexto(esperaExplicita(byTxtPassword,10),password);
        siguiente();
        agregarTexto(esperaExplicita(byTxtDisplayName,10),username);
        agregarTexto(esperaExplicita(byTxtDia,10), String.valueOf(dia));
        seleccionarDDlPorTexto(esperaExplicita(byTxtMes,10),mes);
        agregarTexto(esperaExplicita(byTxtAnnio,10), String.valueOf(annio));
        click(buscarElementosWeb(byOptionGenders).get(genero));
        siguiente();
        if(chkMarketing){
            click(buscarElementosWeb(byChksPreferences).get(0));
        }

        if(chkConpartirInfo){
            click(buscarElementosWeb(byChksPreferences).get(1));
        }
        siguiente();
    }

    public void siguiente(){
        esperarXSegundos(1000);
        click(esperaExplicita(byBtnSiguiente,10));
    }


    public RegisterPage(WebDriver driver) {
        super(driver);
    }
}
