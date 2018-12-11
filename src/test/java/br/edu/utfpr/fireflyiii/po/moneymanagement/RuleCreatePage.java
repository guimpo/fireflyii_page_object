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
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 *
 * @author paulo
 */
public class RuleCreatePage extends FireFlyBasePage {
    
    private WebElement btnNewRule;

    public RuleCreatePage(WebDriver driver) {
        super(driver);
        btnNewRule = wait.until(d -> {
            List<WebElement> buttons = d.findElements(By.className("btn-success"));
            return buttons.get(0);
        });
    }
    
    public BillsPage clickStoreNewRule() {
        wait.until(ExpectedConditions.elementToBeClickable(btnNewRule));
        btnNewRule.submit();
        return new BillsPage(driver);
    }
}
