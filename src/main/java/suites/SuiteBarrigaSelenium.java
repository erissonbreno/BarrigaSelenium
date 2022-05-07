package suites;

import core.BasePage;
import core.DriverFactory;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import pages.HomePage;
import pages.LoginPage;
import tests.AccountTest;
import tests.BalanceTest;
import tests.TransactionMandatoryFieldsDDT;
import tests.TransactionTest;

import static core.DriverFactory.killDriver;

@RunWith(Suite.class)
@SuiteClasses({
        AccountTest.class,
        BalanceTest.class,
        TransactionTest.class,
        TransactionMandatoryFieldsDDT.class
})
public class SuiteBarrigaSelenium {

    @AfterClass
    public static void endsAll() {
        killDriver();
    }
}
