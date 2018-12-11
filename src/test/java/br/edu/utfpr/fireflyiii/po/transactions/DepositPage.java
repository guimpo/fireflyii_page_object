/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.fireflyiii.po.transactions;

import br.edu.utfpr.fireflyiii.po.FireFlyBasePage;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 *
 * @author paulo
 */
public class DepositPage extends FireFlyBasePage {
  
    public DepositPage(WebDriver driver) {
        super(driver);
    }
    
    public DepositCreatePage clickNewDeposit() {
        List<WebElement> es = driver.findElements(By.className("btn-success"));
        es.get(0).click();
        if(annoyingTutorialExist()) skipAnnoyingTutorial();
        return new DepositCreatePage(driver);
    }
}
