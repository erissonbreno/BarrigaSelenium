package tests;

import core.BaseTest;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;
import pages.MenuPage;
import pages.TransactionPage;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class TransactionMandatoryFieldsDDT extends BaseTest {
    private MenuPage menu = new MenuPage();
    private TransactionPage transaction = new TransactionPage();

    @Parameter
    public String transactionDate;
    @Parameter(value = 1)
    public String paymentDate;
    @Parameter(value = 2)
    public String description;
    @Parameter(value = 3)
    public String interested;
    @Parameter(value = 4)
    public String value;
    @Parameter(value = 5)
    public String msg;

    @Parameters
    public static Collection<Object[]> getParameters() {
        return Arrays.asList(new Object[][]{
                {"", "05/05/2022", "Description Test", "Interested Test", "200", "Data da Movimentação é obrigatório"},
                {"05/05/2022", "", "Description Test", "Interested Test", "200", "Data do pagamento é obrigatório"},
                {"05/05/2022", "05/05/2022", "", "Interested Test", "200", "Descrição é obrigatório"},
                {"05/05/2022", "05/05/2022", "Description Test", "", "200", "Interessado é obrigatório"},
                {"05/05/2022", "05/05/2022", "Description Test", "Interested Test", "", "Valor é obrigatório\n" + "Valor deve ser um número"},
                {"05/05/2022", "05/05/2022", "Description Test", "Interested Test", "abc", "Valor deve ser um número"}
        });
    }

    @Test
    public void testCreateTransactionWithoutMandatoryFields() {
        menu.accessTransactionPage();

        transaction.setTransactionDate(transactionDate);
        transaction.setPaymentDate(paymentDate);
        transaction.setDescription(description);
        transaction.setInterested(interested);
        transaction.setValue(value);
        transaction.save();

        Assert.assertEquals(msg, transaction.getFailMessage());
    }
}
