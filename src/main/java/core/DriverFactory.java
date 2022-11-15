package core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
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
                    break;
                case EDGE:
                    cap.setCapability("browser", "Edge");
                    break;
            }
            try {
                driver = new RemoteWebDriver(new URL("http://26.102.99.27:4444/wd/hub"), cap);
            } catch (MalformedURLException e) {
                System.out.println("Falha na conexão com o GRID");
                e.printStackTrace();
            }
        }

        if (EXECUTION_TYPE == CLOUD) {
            ChromeOptions browserOptions = new ChromeOptions();
            browserOptions.setPlatformName("Windows 11");
            browserOptions.setBrowserVersion("latest");

            try {
                URL url = new URL("https://erissonbreno:97a93e55-c225-4548-a886-9bffedccf211@ondemand.us-west-1.saucelabs.com:443/wd/hub");
                driver = new RemoteWebDriver(url, browserOptions);
            } catch (MalformedURLException e) {
                System.out.println("Falha na conexão com o GRID");
                e.printStackTrace();
            }
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
