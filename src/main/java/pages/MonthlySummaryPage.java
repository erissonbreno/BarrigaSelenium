package pages;

import core.BasePage;
import org.openqa.selenium.By;

public class MonthlySummaryPage extends BasePage {

    public void removeTransaction(String transactionDescription) {
        click(By.xpath("//td[.='" + transactionDescription +"']/..//a"));
    }
}
