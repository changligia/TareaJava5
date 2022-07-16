package ejercicios;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Ejercicio4Test extends BaseTest {

    @Test
    public void exercise4Test() {
        var url = "http://the-internet.herokuapp.com/add_remove_elements/";
        log.info("Voy a la pagina: " + url);
        driver.get(url);

        log.info("Espero de forma explicita que carge la pagina por 2 segundos");
        var titleLocator = By.xpath("//h3[text()='Add/Remove Elements']");
        var wait = new WebDriverWait(driver, Duration.ofSeconds(2)); //Declaro el objeto wait
        wait.until(ExpectedConditions.visibilityOfElementLocated(titleLocator));

        var addElementButtonLocator = By.cssSelector("button[onclick='addElement()']"); //Declaro el localizador
        var addElementButton = driver.findElement(addElementButtonLocator); //Convierto el localizador a web element

        log.info("Haciendo click 10 veces al botón de add element");
        for (var i = 0; i < 10; i++) {
            addElementButton.click();
        }
        
        var deleteElementButtonLocator = By.cssSelector("button[onclick='deleteElement()']");
        var deleteButtonList = driver.findElements(deleteElementButtonLocator);
        log.info("Haciendo click en todos los deleteButton");
        for (var deleteButton : deleteButtonList) {
            deleteButton.click();
        }

        deleteButtonList = driver.findElements(deleteElementButtonLocator);
        log.info("Verificando que no hayan los deleteButton");
        Assert.assertEquals(deleteButtonList.size(), 0);
    }
}
