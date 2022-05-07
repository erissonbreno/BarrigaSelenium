package pages;

import core.BasePage;
import org.openqa.selenium.By;
import utils.DateUtils;

import java.util.Calendar;
import java.util.Date;

public class TransactionPage extends BasePage {

    public void setTransactionType(String type) {
        selectCombo("tipo", type);
    }

    public void setTransactionDate(Integer qttDays) {
        write("data_transacao", DateUtils.getDateDiferenceDays(qttDays));
    }

    public void setTransactionDate() {
        setTransactionDate(0);
    }

    public void setTransactionDate(String date) {
        write("data_transacao", date);
    }

    public void setPaymentDate(Integer qttDays) {
        write("data_pagamento", DateUtils.getDateDiferenceDays(qttDays));
    }

    public void setPaymentDate() {
        setPaymentDate(0);
    }

    public void setPaymentDate(String date) {
        write("data_pagamento", date);
    }

    public void setDescription(String description) {
        write("descricao", description);
    }

    public void setInterested(String interested) {
        write("interessado", interested);
    }

    public void setValue(String value) {
        write("valor",value);
    }

    public void setAccount(String account) {
        selectCombo("conta", account);
    }

    public void setStatePaid() {
        click("status_pago");
    }

    public void save() {
        click(By.xpath("//button[. = 'Salvar']"));
    }
}
