package bc15.BenjaMontero;

import bc15.BenjaMontero.utils.Email;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;


public class SpotifyAccountTC {

    private WebDriver driver;
    private WebDriverWait wait;
    private int quantityOfCharactersForRandomString = 25;
    private String pswSpoty = "benjamonterobc_15";
    private String emailGeneraterForSpoty = "";

    @BeforeEach
    public void preCondiciones() {
        String rutaDriver = System.getProperty("user.dir") +"\\src\\test\\resources\\drivers\\chromedriver.exe";
        //enlazar el webdriver a traves de property
        System.setProperty("webdriver.chrome.driver",rutaDriver);

        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 120);
        //maximizar el browser
        driver.manage().window().maximize();
    }

    @AfterEach
    public void posCondiciones(){
        driver.close();
    }

    @Test
    public void TC01_CreateAccount() throws InterruptedException {
        driver.get("https://open.spotify.com/intl-es");

        WebElement btnCloseCookies = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"onetrust-close-btn-container\"]/button")));
        btnCloseCookies.click();

        WebElement btnRegister = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"global-nav-bar\"]/div[3]/div/button[1]")));
        btnRegister.click();

        ArrayList<String> emailAndPsw = Email.getEmailAndPsw();
        String email = emailAndPsw.getFirst();
        String psw = emailAndPsw.get(1);
        this.emailGeneraterForSpoty = email;

        WebElement inputEmail = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"username\"]")));
        inputEmail.sendKeys(email+"@gmail.com");

        WebElement inputPsw = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"new-password\"]")));
        inputPsw.sendKeys(pswSpoty);

        WebElement bntSiguiente = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"__next\"]/main/main/section/div/form/div[2]/button/span[1]")));
        bntSiguiente.click();

        WebElement inputName = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"displayName\"]")));
        inputName.sendKeys("BenjaMonteroBC15");

        WebElement inputDay = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//INPUT[@id='day']")));
        inputDay.sendKeys("31");

        Select select = new Select(wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//SELECT[@id='month']"))));
        select.selectByValue("Enero");

//        WebElement optionJanuary = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"month\"]/option[2]")));
//        optionJanuary.click();

        WebElement inputYear = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//INPUT[@id='year']")));
        inputYear.sendKeys("2002");

        WebElement optionGenre = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//SPAN[@class='Indicator-sc-hjfusp-0 jRuGOG']")));
        optionGenre.click();

        WebElement btnNext = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//SPAN[@class='ButtonInner-sc-14ud5tc-0 hvvTXU encore-bright-accent-set'][text()='Siguiente']")));
        btnNext.click();

        WebElement optionDontReceivePublish = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//SPAN[@class='Indicator-sc-1airx73-0 lhZnAn'])[1]")));
        optionDontReceivePublish.click();

        WebElement btnFinalRegister = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//SPAN[@class='ButtonInner-sc-14ud5tc-0 hvvTXU encore-bright-accent-set'][text()='Registrarte']")));
        btnFinalRegister.click();

        WebElement profile = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@data-testid=\"username-first-letter\"]")));

        Assertions.assertEquals("B", profile.getText());
    }

    @Test
    public void TC02_LogInAccount(){
        driver.get("https://open.spotify.com/intl-es");

        WebElement inputLogin = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//INPUT[@id='login-username']")));
        inputLogin.sendKeys(emailGeneraterForSpoty);

        WebElement btnLogInWithPsw = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//BUTTON[@type='button'][text()='Iniciar sesión con contraseña']")));
        btnLogInWithPsw.click();

        WebElement inputPsw = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//INPUT[@id='login-password']")));
        inputPsw.sendKeys(pswSpoty);

        WebElement btnLogin = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//SPAN[@class='encore-text encore-text-body-medium-bold sc-iKTcqh sc-gnpbhQ doOTMr cyUyia'][text()='Iniciar Sesión']")));
        btnLogin.click();

        WebElement profile = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@data-testid=\"username-first-letter\"]")));

        Assertions.assertEquals("B", profile.getText());
    }



}
