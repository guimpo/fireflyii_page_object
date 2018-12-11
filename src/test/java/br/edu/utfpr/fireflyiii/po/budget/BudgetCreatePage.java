/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.fireflyiii.po.budget;

import br.edu.utfpr.fireflyiii.po.FireFlyBasePage;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 *
 * @author paulo
 */
public class BudgetCreatePage extends FireFlyBasePage {
    
    @FindBy(className = "box-title")
    private List<WebElement> mandatoryFields;
    
    @FindBy(id = "ffInput_name")
    private WebElement name;
    
    public BudgetCreatePage(WebDriver driver) {
        super(driver);
    }
    
    public String getMandatoryFieldsTitle() {
        return mandatoryFields.get(0).getText();
    }
    
    public BudgetCreatePage setName(String keysToSend) {
        name.sendKeys(keysToSend);
        return this;
    }
    
    public BudgetPage submitBudget() {
        name.submit();
        return new BudgetPage(driver);
    }
}
