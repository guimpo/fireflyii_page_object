/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.fireflyiii.po.profile;

import br.edu.utfpr.fireflyiii.po.FireFlyBasePage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 *
 * @author paulo
 */
public class NewUserPage extends FireFlyBasePage {
    
    private WebElement bank_name;
    private WebElement bank_balance;
    
    @FindBy(xpath = "//*[@id=\"bank_balance_holder\"]/div/div/div/ul/li[3]/a")
    private WebElement brCurrency; 
    
    public NewUserPage(WebDriver driver) {
        super(driver);
    }
    
    public NewUserPage setBankName(String keysToSend) {
        bank_name.sendKeys(keysToSend);
        return this;
    }
    
    public NewUserPage setBankBalance(double keysToSend) {
        bank_balance.sendKeys(String.valueOf(keysToSend));
        return this;
    }
    
    public FireFlyBasePage submit() {
        bank_balance.submit();
        return new FireFlyBasePage(driver);
    }
    
    
    
    public NewUserPage selectBrCurrency() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", brCurrency);
        return this;
    }
    
}
