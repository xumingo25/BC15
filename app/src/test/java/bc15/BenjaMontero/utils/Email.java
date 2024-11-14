package bc15.BenjaMontero.utils;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;

//class for generate random email
public class Email {
    private static WebDriver driver;
    private static WebDriverWait wait;
    private static int quantityOfCharactersForRandomString = 25;

    private static void configuredBrowser(){
        String rutaDriver = System.getProperty("user.dir") +"\\src\\test\\resources\\drivers\\chromedriver.exe";
        //enlazar el webdriver a traves de property
        System.setProperty("webdriver.chrome.driver",rutaDriver);

        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 120);
        //maximizar el browser
        driver.manage().window().maximize();
    }

    public static ArrayList<String> getEmailAndPsw(){
        configuredBrowser();
        ArrayList<String> toReturn = new ArrayList<>(2);
        driver.get("https://accounts.google.com/lifecycle/steps/signup/name?ddm=1&dsh=S-49050826:1731414582713188&flowEntry=SignUp&flowName=GlifWebSignIn&hl=en-GB&ifkv=AcMMx-e_ta8JfHVS_9B62woyoOylNuNLXIL-_IYopOvKCDMsPJG3MIV4frGuEjpW8fLnsUnCymSU6Q&TL=AKOx4s0NhTU92jqeorMCMFfEM_VDiGxZKpT67KR0xlBg7tdh_t7dZyXxlQXubcKL");

        WebElement inputFirstName = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"firstName\"]")));
        inputFirstName.sendKeys("benja");

        WebElement btnNext = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"collectNameNext\"]/div/button/span")));
        btnNext.click();

        WebElement inputDay = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"day\"]")));
        inputDay.sendKeys("31");

        Select selectMonth = new Select(wait.until(ExpectedConditions.elementToBeClickable(By.xpath(" //*[@id=\"month\"]"))));
        selectMonth.selectByValue("Enero");

//        WebElement optionJanuary = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"month\"]/option[2]")));
//        optionJanuary.click();

        WebElement inputYear = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"year\"]")));
        inputYear.sendKeys();

        Select selectGender = new Select(wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"gender\"]"))));
        selectGender.selectByValue("Male");

//        WebElement gender = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"gender\"]/option[3]")));
//        gender.click();

        WebElement btnNextBithday = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"birthdaygenderNext\"]/div/button/span")));
        btnNextBithday.click();

        WebElement optionCreateANewEmail = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"yDmH0d\"]/c-wiz/div/div[2]/div/div/div/form/span/section/div/div/div[1]/div[1]/div/span/div[3]/div/div[1]/div/div[3]/div")));
        optionCreateANewEmail.click();

        WebElement inputNewEmail = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"yDmH0d\"]/c-wiz/div/div[2]/div/div/div/form/span/section/div/div/div[2]/div[1]/div/div[1]/div/div[1]/input")));
        String email = RandomStringUtils.randomAlphabetic(quantityOfCharactersForRandomString);
        inputNewEmail.sendKeys(email);

        WebElement inputPsw = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"passwd\"]/div[1]/div/div[1]/input")));
        String psw = RandomStringUtils.randomAlphabetic(quantityOfCharactersForRandomString);
        inputPsw.sendKeys(psw);

        WebElement inputConfirmPsw = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"confirm-passwd\"]/div[1]/div/div[1]/input")));
        inputConfirmPsw.sendKeys(psw);

        WebElement btnSkip = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"recoverySkip\"]/div/button/div[3]")));
        btnSkip.click();

        WebElement emailConfirmed = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"yDmH0d\"]/c-wiz/div/div[2]/div/div/div/form/span/section/div/div/div/div/div[2]/div[2]")));

        Assertions.assertTrue(emailConfirmed.getText().equalsIgnoreCase(email));
        toReturn.add(0, email);
        toReturn.add(1, psw);
        driver.close();
        return toReturn;
    }
}
