/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.fireflyiii.po.budget;

import br.edu.utfpr.fireflyiii.po.FireFlyBasePage;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 *
 * @author paulo
 */
public class BudgetPage extends FireFlyBasePage {
    
    @FindBy(className = "btn-success")
    private List<WebElement> btnNewBudget;
    
    private WebElement amount;
    
    private WebElement budgetList;
    
    private WebElement leftPerDay;
    
    public BudgetPage(WebDriver driver) {
        super(driver);
    }
    
    public BudgetCreatePage clickNewBudget() {
        btnNewBudget.get(1).click();
        return new BudgetCreatePage(driver);
    }
    
    public void setBudgeted(double budget) {
        amount = budgetList.findElement(By.name("amount"));
        amount.sendKeys(String.valueOf(budget));
        
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("$(arguments[0]).change();", amount);
    }
    
    public String getleftPerDay() {
        List<WebElement> es = budgetList.findElements(By.className("left"));
        leftPerDay = es.get(0);
        
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until((WebDriver d) -> {
            WebElement progressBar = d.findElement(By.id("progress-bar-danger"));
            return progressBar.getAttribute("style").equals("width: 100%;");
        });

        
        return leftPerDay.getText();
    }
    
    @Override
    public String getSubTitle() {
        WebElement e = driver.findElement(By.className("content-header"));
        return e.findElement(By.tagName("h1")).getText();
    }
   
}
