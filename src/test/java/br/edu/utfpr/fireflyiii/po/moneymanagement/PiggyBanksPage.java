/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.fireflyiii.po.moneymanagement;

import br.edu.utfpr.fireflyiii.po.FireFlyBasePage;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 *
 * @author paulo
 */
public class PiggyBanksPage extends FireFlyBasePage {
    
    private WebElement btnNewPiggyBank;
    
    private WebElement addMoneyTitle;
    
    private WebElement amount;
    
    //*[@id="sortable-piggy"]/tbody/tr/td[9]/a
    private WebElement addMoney;
    
    private WebElement defaultModal;
    
    @FindBy(xpath = "//*[@id=\"sortable-piggy\"]/tbody/tr/td[11]/span")
    private WebElement leftToSave;
    
    public PiggyBanksPage(WebDriver driver) {
        super(driver);
        btnNewPiggyBank = wait.until(d -> {
            List<WebElement> buttons = d.findElements(By.className("btn-success"));
            return buttons.get(0);
        });
    }
    
    public PiggyBanksCreatePage clickNewPiggyBank() {
        wait.until(ExpectedConditions.elementToBeClickable(btnNewPiggyBank));
        btnNewPiggyBank.click();
        return new PiggyBanksCreatePage(driver);
    }
    
    public PiggyBanksPage clickAddMoney() {
        
        addMoney = wait.until(d -> {
            WebElement table = d.findElement(By.id("sortable-piggy"));
            return table.findElement(By.className("addMoney"));
        });

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", addMoney);
        return this;
    }
    
    public String getAddMoneyTitle() {
        defaultModal = wait.until(ExpectedConditions.elementToBeClickable(By.id("defaultModal")));
        String s = defaultModal.findElement(By.tagName("h4")).getText();
        System.out.println(s);
        return s;
    }
    
    public PiggyBanksPage setAmount(double keysToSend) {
        defaultModal = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("defaultModal")));
        amount = defaultModal.findElement(By.id("amount"));
        amount.sendKeys(String.valueOf(keysToSend));
        return this;
    }
    
    public PiggyBanksPage submit() {
        defaultModal = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("defaultModal")));
        amount = defaultModal.findElement(By.id("amount"));
        amount.submit();
        return this;
    }
    
    public String getLeftToSave() {
        leftToSave = wait.until(d -> {
            WebElement span = d.findElement(
                    By.xpath("//*[@id=\"sortable-piggy\"]/tbody/tr/td[11]/span"));
            return span.findElement(By.className("text-success"));
        });
        System.out.println(leftToSave.getText());
        return leftToSave.getText();
    }
    
//    Add money to piggy bank "relogioXadrez" 
//    Success! Added R$20.00 to "relogioXadrez"
}
