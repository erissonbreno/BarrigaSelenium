package core;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.Select;

import static core.DriverFactory.getDriver;

public class BasePage {

    public void escrever(By by, String texto) {
        getDriver().findElement(by).sendKeys(texto);
    }

    public void escrever(String id_campo, String texto) {
        escrever(By.id(id_campo), texto);
    }

    public void clicar(String id_campo) {
        getDriver().findElement(By.id(id_campo)).click();
    }

    public void selecionarCombo(String id_campo, String valor) {
        Select combo = new Select(getDriver().findElement(By.id(id_campo)));
        combo.selectByVisibleText(valor);
    }

    public String obterTextoCampo(String id_campo) {
        return getDriver().findElement(By.id(id_campo)).getText();
    }

    public void trocarJanela(String id_janela) {
        getDriver().switchTo().window(id_janela);
    }

    public void frame(String frame) {
        getDriver().switchTo().frame(frame);
    }

    public void sairFrame() {
        getDriver().switchTo().defaultContent();
    }

    public String alertaObterTextoEAceita() {
        Alert alert = getDriver().switchTo().alert();
        String texto = alert.getText();
        alert.accept();
        return texto;
    }

    public Object executarJS(String cmd, Object... param) {
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        return js.executeScript(cmd, param);
    }
}
