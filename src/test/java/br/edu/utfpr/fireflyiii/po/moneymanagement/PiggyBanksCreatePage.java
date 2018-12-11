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
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

/**
 *
 * @author paulo
 */
public class PiggyBanksCreatePage extends FireFlyBasePage {
    
    @FindBy(className = "box-title")
    private List<WebElement> mandatoryFields;
    
    @FindBy(id = "ffInput_name")
    private WebElement name;
    
    private Select saveOnAccount;
    
    @FindBy(id = "ffInput_targetamount")
    private WebElement targetAmount;
    
    public PiggyBanksCreatePage(WebDriver driver) {
        super(driver);
        saveOnAccount = new Select(driver.findElement(By.id("ffInput_account_id")));
    }
    
    public String getMandatoryFieldsTitle() {
        return mandatoryFields.get(0).getText();
    }
    
    public PiggyBanksCreatePage setName(String keysToSend) {
        name.sendKeys(keysToSend);
        return this;
    }
    
//    corrente (R$1,460.00)
//    corrente savings account (R$0.00)
//    Success! Store new piggy bank "relogioXadrez"

    public PiggyBanksCreatePage selectSaveOnAccount(String keysToSend) {
        saveOnAccount.selectByVisibleText(keysToSend);
        return this;
    }

    public PiggyBanksCreatePage setTargetAmount(double keysToSend) {
        targetAmount.sendKeys(String.valueOf(keysToSend));
        return this;
    }

    public PiggyBanksPage submit() {
        targetAmount.submit();
        return new PiggyBanksPage(driver);
    }
}
