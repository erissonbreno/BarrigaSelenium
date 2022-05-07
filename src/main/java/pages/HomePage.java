package pages;

import core.BasePage;
import org.openqa.selenium.By;

public class HomePage extends BasePage {

    public void resetDatabase() {
        click(By.xpath("//a[.='reset']"));
    }

    public String getSaldo(String accountName) {
        return getTextField(By.xpath("//td[.='"+ accountName +"']/../td[2]"));
    }
}
