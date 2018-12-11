/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.fireflyiii.po.moneymanagement;

import br.edu.utfpr.fireflyiii.po.FireFlyBasePage;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 *
 * @author paulo
 */
public class BillsPage extends FireFlyBasePage {
    
    private WebElement btnNewBill;
    
    public BillsPage(WebDriver driver) {
        super(driver);
        btnNewBill = wait.until(d -> {
            List<WebElement> buttons = d.findElements(By.className("btn-success"));
            return buttons.get(0);
        });
    }
    
    public BillsCreatePage clickNewWithdrawal() {
        btnNewBill.click();
        return new BillsCreatePage(driver);
    }
    
}
