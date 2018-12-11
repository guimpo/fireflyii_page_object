/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.fireflyiii.po.categories;

import br.edu.utfpr.fireflyiii.po.FireFlyBasePage;
import br.edu.utfpr.fireflyiii.po.moneymanagement.PiggyBanksCreatePage;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 *
 * @author paulo
 */
public class CategoriesPage extends FireFlyBasePage {
    
    private WebElement btnNewCategorie;
    
    public CategoriesPage(WebDriver driver) {
        super(driver);
        
        btnNewCategorie = wait.until(d -> {
            List<WebElement> buttons = d.findElements(By.className("btn-success"));
            return buttons.get(0);
        });
    }
    
    public CategoriesCreatePage clickNewCategory() {
        wait.until(ExpectedConditions.elementToBeClickable(btnNewCategorie));
        btnNewCategorie.click();
        return new CategoriesCreatePage(driver);
    }
}
