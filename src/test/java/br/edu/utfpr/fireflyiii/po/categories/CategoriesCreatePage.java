/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.fireflyiii.po.categories;

import br.edu.utfpr.fireflyiii.po.FireFlyBasePage;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 *
 * @author paulo
 */
public class CategoriesCreatePage extends FireFlyBasePage {
    
    @FindBy(className = "box-title")
    private List<WebElement> mandatoryFields;
    
    @FindBy(id = "ffInput_name")
    private WebElement name;
    
    public CategoriesCreatePage(WebDriver driver) {
        super(driver);
    }
    
    public String getMandatoryFieldsTitle() {
        return mandatoryFields.get(0).getText();
    }
    
    public CategoriesCreatePage setName(String keysToSend) {
        wait.until(ExpectedConditions.elementToBeClickable(name));
        name.sendKeys(keysToSend);
        return this;
    }
    
    public CategoriesPage submit() {
        name.submit();
        return new CategoriesPage(driver);
    }
}
