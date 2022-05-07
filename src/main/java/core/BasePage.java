package core;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import static core.DriverFactory.getDriver;

public class BasePage {

    public void write(By by, String text) {
        getDriver().findElement(by).sendKeys(text);
    }

    public void write(String id, String text) {
        write(By.id(id), text);
    }

    public void click(By by) {
        getDriver().findElement(by).click();
    }

    public void click(String id) {
        click(By.id(id));
    }

    public void selectCombo(String id, String value) {
        Select combo = new Select(getDriver().findElement(By.id(id)));
        combo.selectByVisibleText(value);
    }

    public String getTextField(By by) {
        return getDriver().findElement(by).getText();
    }

    public String getTextField(String id) {
        return getTextField(By.id(id));
    }

    public void switchWindow(String id) {
        getDriver().switchTo().window(id);
    }

    public void frame(String frame) {
        getDriver().switchTo().frame(frame);
    }

    public void exitFrame() {
        getDriver().switchTo().defaultContent();
    }

    public String alertGetTextAndAccept() {
        Alert alert = getDriver().switchTo().alert();
        String text = alert.getText();
        alert.accept();
        return text;
    }

    public Object executeJS(String cmd, Object... param) {
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        return js.executeScript(cmd, param);
    }

    public void clearTextField(By by) {
        getDriver().findElement(by).clear();
    }

    public String getSuccessMessage() {
        return getTextField(By.xpath("//div[@class='alert alert-success']"));
    }

    public String getFailMessage() {
        return getTextField(By.xpath("//div[@class='alert alert-danger']"));
    }
}
