package core;

import org.apache.commons.io.FileUtils;
import org.junit.*;
import org.junit.rules.TestName;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import pages.HomePage;
import pages.LoginPage;
import pages.MenuPage;

import java.io.File;
import java.io.IOException;

import static core.DriverFactory.getDriver;
import static core.DriverFactory.killDriver;
import static java.io.File.separator;

public class BaseTest {

    private LoginPage login = new LoginPage();
    private HomePage home = new HomePage();
    private MenuPage menu = new MenuPage();

    @Rule
    public TestName testName = new TestName();

    @Before
    public  void inicializa() {
        login.accessInitialPage();
        login.insertCredentialsAndEnter();
        resetDataBase();
    }

    public void resetDataBase() {
        menu.accessHome();
        home.resetDatabase();
    }

    @After
    public void finaliza() throws IOException {
        TakesScreenshot ss = (TakesScreenshot) getDriver();
        File arquivo = ss.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(arquivo,
                new File("target" + separator + "screenshots" +  separator + testName.getMethodName() + ".jpg"));

        if (Properties.FECHAR_BROWSER) {
            killDriver();
        }
    }
}
