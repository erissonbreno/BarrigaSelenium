package core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

import static core.Properties.BROWSER;
import static core.Properties.EXECUTION_TYPE;
import static core.Properties.executionType.*;

public class DriverFactory {

    private static ThreadLocal<WebDriver> threadDriver = new ThreadLocal<WebDriver>() {

        @Override
        protected synchronized WebDriver initialValue() {
            return initDriver();
        }
    };

    private DriverFactory() {
    }

    public static WebDriver getDriver() {
        return threadDriver.get();
    }

    public static WebDriver initDriver() {
        WebDriver driver = null;

        if (EXECUTION_TYPE == LOCAL) {
            switch (BROWSER) {
                case CHROME:
                    driver = new ChromeDriver();
                    break;
                case EDGE:
                    driver = new EdgeDriver();
                    break;
            }
        }

        if (EXECUTION_TYPE == GRID) {
            DesiredCapabilities cap = new DesiredCapabilities();
            switch (BROWSER) {
                case CHROME:
                    cap.setCapability("browser", "Chrome");
            }
            try {
                driver = new RemoteWebDriver(new URL("http://26.102.99.27:4444/wd/hub"), cap);
            } catch (MalformedURLException e) {
                System.out.println("Falha na conexão com o GRID");
                e.printStackTrace();
            }
        }

        if (EXECUTION_TYPE == CLOUD) {
            // Code to CLOUD execution
        }
        driver.manage().window().maximize();
        return driver;
    }

    public static void killDriver() {
        WebDriver driver = getDriver();
        if (driver != null) {
            driver.quit();
            driver = null;
        }

        if (threadDriver != null) {
            threadDriver.remove();
        }
    }
}
