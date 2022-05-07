package tests;

import core.BaseTest;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;
import pages.MenuPage;
import pages.MonthlySummaryPage;
import pages.TransactionPage;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class TransactionTest extends BaseTest {
    private MenuPage menu = new MenuPage();
    private TransactionPage transaction = new TransactionPage();
    private MonthlySummaryPage summary = new MonthlySummaryPage();

    @Test
    public void testCreateTransaction() {
        menu.accessTransactionPage();
        transaction.setTransactionType("Receita");
        transaction.setTransactionDate();
        transaction.setPaymentDate();
        transaction.setDescription("Receita Teste");
        transaction.setInterested("Usuario ABC");
        transaction.setValue("20000");
        transaction.setAccount("Conta para movimentacoes");
        transaction.setStatePaid();
        transaction.save();

        Assert.assertEquals("Movimentação adicionada com sucesso!", transaction.getSuccessMessage());
    }

    @Test
    public void testCreateFutureTransaction() {
        menu.accessTransactionPage();
        transaction.setTransactionType("Receita");
        transaction.setTransactionDate(1);
        transaction.setPaymentDate();
        transaction.setDescription("Receita Teste");
        transaction.setInterested("Usuario ABC");
        transaction.setValue("200");
        transaction.setAccount("Conta para movimentacoes");
        transaction.setStatePaid();
        transaction.save();

        Assert.assertEquals("Data da Movimentação deve ser menor ou igual à data atual", transaction.getFailMessage());
    }

    @Test
    public void testRemoveTransaction() {
        menu.accessMonthlySummary();
        summary.removeTransaction("Movimentacao para exclusao");

        Assert.assertEquals("Movimentação removida com sucesso!", transaction.getSuccessMessage());
    }
}
