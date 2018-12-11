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
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

/**
 *
 * @author paulo
 */
public class DepositCreatePage extends FireFlyBasePage {
    
    @FindBy(className = "box-title")
    private List<WebElement> mandatoryFields;
    
    @FindBy(id = "ffInput_description")
    private WebElement description;
    
    @FindBy(id = "ffInput_source_name")
    private WebElement revenueAccount;
    
    private Select destinationAccount;
    
    @FindBy(id = "ffInput_amount")
    private WebElement amount;
    

    public DepositCreatePage(WebDriver driver) {
        super(driver);
        destinationAccount = new Select(driver.findElement(
                By.id("ffInput_destination_id")));
    }
    
    public String getMandatoryFieldsTitle() {
        return mandatoryFields.get(0).getText();
    }
    
    public DepositCreatePage setDescription(String keysToSend) {
        description.sendKeys(keysToSend);
        return this;
    }
    
    public DepositCreatePage setRevenueAccount(String keysToSend) {
        revenueAccount.sendKeys(keysToSend);
        return this;
    }
    
    public DepositCreatePage selectDestinationAccount(String destination) {
        destinationAccount.selectByVisibleText(destination);
        return this;
    }
    
    public DepositCreatePage setAmount(double keysToSend) {
        amount.sendKeys(String.valueOf(keysToSend));
        return this;
    }
    
    public DepositPage submitDeposit() {
        amount.submit();
        return new DepositPage(driver);
    }
}
