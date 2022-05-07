package pages;

import core.BasePage;
import org.openqa.selenium.By;

public class MenuPage extends BasePage {

    public void accessInsertAccountPage() {
        click(By.xpath("//a[.='Contas ']"));
        click(By.xpath("//a[.='Adicionar']"));
    }

    public void accessListAccountPage() {
        click(By.xpath("//a[.='Contas ']"));
        click(By.xpath("//a[.='Listar']"));
    }

    public void accessTransactionPage() {
        click(By.xpath("//a[.='Criar Movimentação']"));
    }

    public void accessMonthlySummary() {
        click(By.xpath("//a[.='Resumo Mensal']"));
    }

    public void accessHome() {
        click(By.xpath("//a[.='Home']"));
    }
}
