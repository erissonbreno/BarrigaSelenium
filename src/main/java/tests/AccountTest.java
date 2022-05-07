package tests;

import core.BaseTest;
import org.junit.Assert;
import org.junit.Test;
import pages.AccountPage;
import pages.MenuPage;

public class AccountTest extends BaseTest {

    private AccountPage account = new AccountPage();
    private MenuPage menu = new MenuPage();

    @Test
    public void testCreateAccount(){
        menu.accessInsertAccountPage();
        account.setName("Conta Teste");
        account.save();
        Assert.assertEquals("Conta adicionada com sucesso!", account.getSuccessMessage());
    }

    @Test
    public void testUpdateAccount() {
        menu.accessListAccountPage();
        account.setEdit("Conta para alterar");
        account.setName("Conta alterada");
        account.save();
        Assert.assertEquals("Conta alterada com sucesso!", account.getSuccessMessage());
    }

    @Test
    public void testCreateAccountWithSameName() {
        menu.accessInsertAccountPage();
        account.setName("Conta mesmo nome");
        account.save();
        Assert.assertEquals("Já existe uma conta com esse nome!", account.getFailMessage());
    }

    @Test
    public void testRemoveAccountWithTransaction() {
        menu.accessListAccountPage();
        account.removeAccount("Conta com movimentacao");
        Assert.assertEquals("Conta em uso na movimentações", account.getFailMessage());
    }
}
