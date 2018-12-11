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
public class BillsCreatePage extends FireFlyBasePage {
    
    @FindBy(className = "box-title")
    private List<WebElement> mandatoryFields;
    
    @FindBy(id = "ffInput_name")
    private WebElement name;
    
    private Select currency;
    
    @FindBy(id = "ffInput_amount_min")
    private WebElement minimumAmount;
    
    @FindBy(id = "ffInput_amount_max")
    private WebElement maximumAmount;
    
    private Select repeats;
    
    public BillsCreatePage(WebDriver driver) {
        super(driver);
        currency = new Select(driver.findElement(By.id("ffInput_transaction_currency_id")));
        repeats = new Select(driver.findElement(By.id("ffInput_repeat_freq")));
    }
    
    public String getMandatoryFieldsTitle() {
        return mandatoryFields.get(0).getText();
    }
    
    public BillsCreatePage setName(String keysToSend) {
        name.sendKeys(keysToSend);
        return this;
    }
    
    public BillsCreatePage selectCurrency(String keysToSend) {
        currency.selectByVisibleText(keysToSend);
        return this;
    }
    
    public BillsCreatePage setMinimumAmount(double keysToSend) {
        minimumAmount.sendKeys(String.valueOf(keysToSend));
        return this;
    }
    
    public BillsCreatePage setMaximumAmount(double keysToSend) {
        maximumAmount.sendKeys(String.valueOf(keysToSend));
        return this;
    }
    
    public BillsCreatePage selectRepeats(String keysToSend) {
        repeats.selectByVisibleText(keysToSend);
        return this;
    }
    
    public RuleCreatePage submit() {
        maximumAmount.submit();
        return new RuleCreatePage(driver);
    }
}
