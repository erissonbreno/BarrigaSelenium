package pages;

import core.BasePage;
import org.openqa.selenium.By;

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
