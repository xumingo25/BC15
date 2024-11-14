package bc15.BenjaMontero.unidad2.BCI.test;

import bc15.BenjaMontero.unidad2.BCI_BenjaminMontero;
import bc15.BenjaMontero.unidad2.BCI_BenjaminMontero.RegisterPage;
import bc15.BenjaMontero.unidad2.BCI_BenjaminMontero;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RegisterTest extends BCI_BenjaminMontero.test.Test {

    HomePage homePage;
    RegisterPage registerPage;
//    private String email = "benjatest@gmail.com";
//    private String rut = "10863075-2";
//    private String tel = "44492923";
//    private String doc = "100.000.000";

    @Test
    public void TC001_CreateAcountNoOk(){
        this.homePage = new HomePage(this.driver);
        this.registerPage = new RegisterPage(this.driver);
        this.homePage.openPage();
        this.homePage.goToRegisterPage();

        this.registerPage.createAccount("10863075-2", "benjatest@gmail.com", "100.000.000", "44492923");

        String text = this.registerPage.getTextErrorRegister();
        String textoValido1 = "No es posible la apertura de la cuenta";
        String textoValido2 = "Acceso bloqueado temporalmente";

        if(text.equalsIgnoreCase(textoValido1)){
            Assertions.assertEquals(textoValido1, text);
        }else if(text.equalsIgnoreCase(textoValido2)){
            Assertions.assertEquals(textoValido2, text);
        }else{
            Assertions.fail("the text of error is distinct to expected text");
        }
    }
}
