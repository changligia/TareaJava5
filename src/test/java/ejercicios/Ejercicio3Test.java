package ejercicios;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class Ejercicio3Test extends BaseTest {

    @Test
    public void exercise3Test() {
        var url = "http://the-internet.herokuapp.com/checkboxes";
        log.info("Voy a la pagina: " + url);
        driver.get(url);

        log.info("Espero de forma explicita que carge la pagina por 2 segundos");
        var titleLocator = By.xpath("//h3[text()='Checkboxes']");
        var wait = new WebDriverWait(driver, Duration.ofSeconds(2)); //Declaro el objeto wait
        wait.until(ExpectedConditions.visibilityOfElementLocated(titleLocator));

        var checkboxesLocator = By.cssSelector("input[type='checkbox']");
        var checkboxList = driver.findElements(checkboxesLocator);
        var checkbox1Input = checkboxList.get(0);
        var checkbox2Input = checkboxList.get(1);

        log.info("Verificando que el checkbox1 esté desmarcado");
        softAssert.assertFalse(checkbox1Input.isSelected());

        log.info("Verificando que el checkbox2 esté marcado");
        softAssert.assertTrue(checkbox2Input.isSelected());

        softAssert.assertAll();

        log.info("Marcando el checkbox1");
        checkbox1Input.click();

        log.info("Desmarcando el checkbox2");
        checkbox2Input.click();

        log.info("Verificando que el checkbox1 esté marcado");
        softAssert.assertTrue(checkbox1Input.isSelected());

        log.info("Verificando que el checkbox2 esté desmarcado");
        softAssert.assertFalse(checkbox2Input.isSelected());

        softAssert.assertAll();
    }
}
