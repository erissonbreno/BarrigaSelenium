package tests;

import core.BaseTest;
import org.junit.Assert;
import org.junit.Test;
import pages.HomePage;
import pages.MenuPage;

public class BalanceTest extends BaseTest {
    private HomePage home = new HomePage();
    private MenuPage menu = new MenuPage();

    @Test
    public void testCheckBalance() {
        menu.accessHome();
        String saldo = home.getSaldo("Conta para saldo");
        Assert.assertEquals("534.00", saldo);
    }
}
