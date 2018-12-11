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
public class WithdrawalCreatePage extends FireFlyBasePage {
    
    @FindBy(id = "ffInput_description")
    private WebElement description;
    
    private Select sourceAccount;
    
    private Select budgetSelect;
    
    @FindBy(id = "ffInput_category")
    private WebElement category;
    
    @FindBy(id = "ffInput_destination_name")
    private WebElement expenseAccount;
    
    @FindBy(id = "ffInput_amount")
    private WebElement amount;
    
    @FindBy(className = "box-title")
    private List<WebElement> mandatoryFields;
    
    public WithdrawalCreatePage(WebDriver driver) {
        super(driver);
        sourceAccount = new Select(driver.findElement(By.id("ffInput_source_id")));
        budgetSelect = new Select(driver.findElement(By.id("ffInput_budget_id")));
    }
    
    public WithdrawalCreatePage setDescription(String keysToSend) {
        description.sendKeys(keysToSend);
        return this;
    }
    
    public WithdrawalCreatePage selectSourceAccount(String destination) {
        sourceAccount.selectByVisibleText(destination);
        return this;
    }
    
    public WithdrawalCreatePage selectBudget(String destination) {
        budgetSelect.selectByVisibleText(destination);
        return this;
    }
    
    public WithdrawalCreatePage setCategory(String keysToSend) {
        category.sendKeys(keysToSend);
        return this;
    }
    
    public WithdrawalCreatePage setExpenseAccount(String keysToSend) {
        expenseAccount.sendKeys(keysToSend);
        return this;
    }
    
    public String getMandatoryFieldsTitle() {
        return mandatoryFields.get(0).getText();
    }
    
    public WithdrawalCreatePage setAmount(double keysToSend) {
        amount.sendKeys(String.valueOf(keysToSend));
        return this;
    }
    
    public WithdrawalPage submit() {
        expenseAccount.submit();
        return new WithdrawalPage(driver);
    }
    

    
}
