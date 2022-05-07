package pages;

import core.BasePage;
import core.DriverFactory;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static core.DriverFactory.getDriver;

public class LoginPage extends BasePage {

    public void accessInitialPage() {
        getDriver().get("https://seubarriga.wcaquino.me/login");
    }

    public void insertCredentialsAndEnter() {
        write("email", "erissonbreno@hotmail.com");
        write("senha", "04011960");
        click(By.xpath("//button[.='Entrar']"));
    }
}
