package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utilities.Logs;

public abstract class BaseTest {
    protected WebDriver driver;
    protected final Logs log = new Logs();

    @BeforeMethod
    protected void setup() {
        log.debug("Inicializando el driver de Chrome");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        log.debug("Maximizando la ventana");
        driver.manage().window().maximize();

        log.debug("Eliminando las cookies");
        driver.manage().deleteAllCookies();
    }

    @AfterMethod
    protected void tearDown() {
        log.debug("Matando el driver de Chrome");
        driver.quit();
    }
}
