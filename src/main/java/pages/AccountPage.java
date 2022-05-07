package pages;

import core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static core.DriverFactory.getDriver;

public class AccountPage extends BasePage {

    public void setName(String text) {
        clearTextField(By.xpath("//input[@type='text']"));
        write(By.xpath("//input[@type='text']"), text);
    }

    public void save() {
        click(By.xpath("//button[.='Salvar']"));
    }

    public void setEdit(String accountName) {
        click(By.xpath("//td[.='" + accountName + "']/..//span[@class='glyphicon glyphicon-edit']"));
    }

    public void removeAccount(String accountName) {
        click(By.xpath("//td[.='" + accountName + "']/..//span[@class='glyphicon glyphicon-remove-circle']"));
    }

}
