package ejercicios;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Ejercicio1Test extends BaseTest {

    @Test
    public void exercise1Test() {
        var url = "http://the-internet.herokuapp.com/login";
        log.info("Voy a la pagina: " + url);
        driver.get(url);

        log.info("Espero de forma explicita que carge la pagina por 5 segundos");
        var tituloLocator = By.xpath("//h2[text()='Login Page']");
        var wait = new WebDriverWait(driver, Duration.ofSeconds(5)); //Declaro el objeto wait
        wait.until(ExpectedConditions.visibilityOfElementLocated(tituloLocator));

        var usernameInputLocator = By.id("username"); //Defino el localizador username
        var passwordInputLocator = By.id("password"); //Defino el localizador password
        var buttonLoginLocator = By.className("radius");

        var usernameInput = driver.findElement(usernameInputLocator); //Convierto el localizador username a web element
        var passwordInput = driver.findElement(passwordInputLocator); //Convierto el localizador password a web element
        var buttonLogin = driver.findElement(buttonLoginLocator); //Convierto el localizador radius a web element

        log.info("Verificando que el usernameInput esté visible");
        Assert.assertTrue(usernameInput.isDisplayed());//verifico que el input de username esté visible

        log.info("Verificando que el passwordInput esté visible");
        Assert.assertTrue(passwordInput.isDisplayed()); //verifico que el input de password esté visible

        log.info("Verificando que el buttonLogin esté visible");
        Assert.assertTrue(buttonLogin.isDisplayed());//verifico que el input de radius esté visible

        log.info("Escribiendo el username");
        usernameInput.sendKeys("tomsmith");

        log.info("Escribiendo el password");
        passwordInput.sendKeys("SuperSecretPassword!");

        log.info("Haciendo click en boton Login");
        buttonLogin.click();

        var successMessageLocator = By.id("flash"); //Defino el localizador del cuadro verde
        var buttonLogoutLocator = By.className("radius"); //Defino el localizador del botonlogout

        log.info("Espero de forma explicita que cargue la pagina success por 5 segundos");
        wait.until(ExpectedConditions.visibilityOfElementLocated(successMessageLocator));

        var buttonLogout = driver.findElement(buttonLogoutLocator);

        log.info("Verificando que el buttonLogout esté visible");
        Assert.assertTrue(buttonLogout.isDisplayed());

        log.info("Haciendo click en boton Logout");
        buttonLogout.click();

        log.info("Espero de forma explicita que cargue la pagina por 5 segundos");
        wait.until(ExpectedConditions.visibilityOfElementLocated(tituloLocator));

        usernameInput = driver.findElement(usernameInputLocator);
        log.info("Verificando que el username esté visible");
        Assert.assertTrue(usernameInput.isDisplayed());
    }

}
