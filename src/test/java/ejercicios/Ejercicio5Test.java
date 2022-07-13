package ejercicios;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class Ejercicio5Test extends BaseTest {

    @Test
    public void excercise5Test() {
        var url = "http://the-internet.herokuapp.com/status_codes";
        log.info("Voy a la pagina: " + url);
        driver.get(url);

        log.info("Espero de forma explicita que carge la pagina por 2 segundos");
        var titleLocator = By.xpath("//h3[text()='Status Codes']");
        var wait = new WebDriverWait(driver, Duration.ofSeconds(2)); //Declaro el objeto wait
        wait.until(ExpectedConditions.visibilityOfElementLocated(titleLocator));

        var option404Locator = By.cssSelector("a[href='status_codes/404']");//Declaro el localizador
        var options404 = driver.findElement(option404Locator);//Convierto el localizador a una lista de WebElements

        log.info("Haciendo click en el 404");
        options404.click();

        log.info("Espero de forma explicita que carge la pagina por 2 segundos");
        var titleLocator2 = By.xpath("//h3[text()='Status Codes']");
        wait.until(ExpectedConditions.visibilityOfElementLocated(titleLocator2));

        var optionsHereLocator = By.cssSelector("a[href='/status_codes']");//Declaro el localizador
        var optionHere = driver.findElement(optionsHereLocator);//Convierto el localizador a WebElement

        log.info("Haciendo click en here");
        optionHere.click();

        log.info("Espero de forma explicita que carge la pagina por 2 segundos");
        var titleLocator3 = By.xpath("//h3[text()='Status Codes']");
        wait.until(ExpectedConditions.visibilityOfElementLocated(titleLocator3));

        log.info("Verifico que la url sea la misma que la del punto1");

    }
}
