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
public class WithdrawalPage extends FireFlyBasePage {
    
    private WebElement btnNewWithdrawal;
    
    public WithdrawalPage(WebDriver driver) {
        super(driver);
        btnNewWithdrawal = wait.until(d -> {
            List<WebElement> buttons = d.findElements(By.className("btn-success"));
            return buttons.get(0);
        });
    }
    
    public WithdrawalCreatePage clickNewWithdrawal() {
        btnNewWithdrawal.click();
        return new WithdrawalCreatePage(driver);
    }
    
    public String getCategory() {
        WebElement lazer = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/section[2]/div[3]/div[1]/div/div[2]/table/tbody/tr[1]/td[9]/a"));
        return lazer.getText();
    }
    
}
