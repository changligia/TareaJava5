package ejercicios;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class Ejercicio2Test extends BaseTest {

    @Test
    public void exercise2Test() {
        var url = "http://the-internet.herokuapp.com/login";
        log.info("Voy a la pagina: " + url);
        driver.get(url);

        log.info("Espero de forma explicita que carge la pagina por 5 segundos");
        var tituloLocator = By.xpath("//h2[text()='Login Page']");
        var wait = new WebDriverWait(driver, Duration.ofSeconds(5)); //Declaro el objeto wait
        wait.until(ExpectedConditions.visibilityOfElementLocated(tituloLocator));

        var usernameInputLocator = By.id("username");
        var passwordInputLocator = By.id("password");
        var buttonLoginLocator = By.className("radius");

        var usernameInput = driver.findElement(usernameInputLocator);
        var passwordInput = driver.findElement(passwordInputLocator);
        var buttonLogin = driver.findElement(buttonLoginLocator);

        var softAssert = new SoftAssert(); //Creo un objeto de soft assert
        log.info("Verificando que el username esté visible");
        softAssert.assertTrue(usernameInput.isDisplayed());

        log.info("Verificando que el password esté visible");
        softAssert.assertTrue(passwordInput.isDisplayed());

        log.info("Verificando que el botonLogin esté visible");
        softAssert.assertTrue(buttonLogin.isDisplayed());
        softAssert.assertAll(); //verifico todas las sentencias con AssertAll

        log.info("Escribiendo el username");
        usernameInput.sendKeys("hola123");

        log.info("Escribiendo el password");
        passwordInput.sendKeys("hehehe");

        log.info("Haciendo click en boton Login");
        buttonLogin.click();

        var invalidMessageLocator = By.id("flash");
        log.info("Espero de forma explicita que se muestre el msj de error por 5 segundos");
        var invalidMessage = wait.until(
                ExpectedConditions.visibilityOfElementLocated(invalidMessageLocator));

        var textoRojo = "Your username is invalid!";
        log.info("Verificando que muestre el mensaje de error");
        Assert.assertTrue(invalidMessage.getText().contains(textoRojo));
    }
}
