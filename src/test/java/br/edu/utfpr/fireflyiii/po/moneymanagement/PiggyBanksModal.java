/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.fireflyiii.po.moneymanagement;

import br.edu.utfpr.fireflyiii.po.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 *
 * @author paulo
 */
public class PiggyBanksModal extends BasePage {
    
    private WebElement modal;
    private WebElement modalTitle;
    private WebElement amount;
    
    public PiggyBanksModal(WebDriver driver) {
        super(driver);
        modal = wait.until(d -> {
            return d.findElement(By.id("defaultModal"));
        });
        
        modalTitle = modal.findElement(By.className("modal-title"));
        amount = modal.findElement(By.id("amount"));
    }
    
}
