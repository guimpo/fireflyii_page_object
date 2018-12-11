/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.fireflyiii.po;

import br.edu.utfpr.fireflyiii.po.budget.BudgetPage;
import br.edu.utfpr.fireflyiii.po.categories.CategoriesPage;
import br.edu.utfpr.fireflyiii.po.moneymanagement.BillsPage;
import br.edu.utfpr.fireflyiii.po.moneymanagement.PiggyBanksPage;
import br.edu.utfpr.fireflyiii.po.profile.ProfilePage;
import br.edu.utfpr.fireflyiii.po.reports.ReportsPage;
import br.edu.utfpr.fireflyiii.po.transactions.DepositPage;
import br.edu.utfpr.fireflyiii.po.transactions.WithdrawalPage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 *
 * @author paulo
 */
public class NavBarSide extends BasePage {
    
    @FindBy(xpath = "//*[@id=\"app\"]/aside[1]/section/ul/li[1]/a")
    private WebElement dashboard;

    @FindBy(xpath = "//*[@id=\"budget-menu\"]/a")
    private WebElement budget;
    
    @FindBy(xpath = "//*[@id=\"app\"]/aside[1]/section/ul/li[4]/a")
    private WebElement categories;
    
    @FindBy(xpath = "//*[@id=\"report-menu\"]/a")
    private WebElement reports;
       
    @FindBy(id = "transaction-menu")
    private WebElement transaction;
    
    @FindBy(xpath = "//*[@id=\"transaction-menu\"]/ul/li[1]/a")
    private WebElement expenses;
    
    @FindBy(xpath = "//*[@id=\"transaction-menu\"]/ul/li[2]/a")
    private WebElement transactionRevenueIncome;
        
    @FindBy(xpath = "//*[@id=\"app\"]/aside[1]/section/ul/li[8]/a")
    private WebElement moneyManagement;
    
    @FindBy(xpath = "//*[@id=\"app\"]/aside[1]/section/ul/li[8]/ul/li[1]/a")
    private WebElement piggyBanks;
    
    @FindBy(xpath = "//*[@id=\"app\"]/aside[1]/section/ul/li[8]/ul/li[2]/a")
    private WebElement bills;
    
    @FindBy(xpath = "//*[@id=\"option-menu\"]/ul/li[1]/a")
    private WebElement profile;
    
    @FindBy(xpath = "//*[@id=\"app\"]/aside[1]/section/ul/li[11]/a")
    private WebElement logout;
    
    public NavBarSide(WebDriver driver) {
        super(driver);
    }
    
    public FireFlyBasePage goToDashBoard() {
        wait.until(ExpectedConditions.elementToBeClickable(dashboard));
        dashboard.click();
        return new FireFlyBasePage(driver);
    }
    
    public BudgetPage goToBudget() {
        wait.until(ExpectedConditions.elementToBeClickable(budget));
        budget.click();
        return new BudgetPage(driver);
    }
    
    public CategoriesPage goToCategories() {
        wait.until(ExpectedConditions.elementToBeClickable(categories));
        categories.click();
        return new CategoriesPage(driver);
    }
    
    public ReportsPage goToReports() {
        wait.until(ExpectedConditions.elementToBeClickable(reports));
        reports.click();
        return new ReportsPage(driver);
    }
    
    public NavBarSide clickTransaction() {
        wait.until(ExpectedConditions.elementToBeClickable(transaction));
        transaction.click();
        return this;
    }
    
    public boolean transactionIsDisplayed() {
        return transaction.isDisplayed();
    }
    
    public WithdrawalPage goToExpenses() {
        expenses.click();
        return new WithdrawalPage(driver);
    }
    
    public DepositPage goToRevenueIncome() {
        wait.until(ExpectedConditions.elementToBeClickable(transactionRevenueIncome));
        transactionRevenueIncome.click();
        return new DepositPage(driver);
    }
    
    public NavBarSide clickMoneyManagement() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", moneyManagement);
        return this;
    }
    
    public boolean moneyManagementIsDisplayed() {
        return moneyManagement.isDisplayed();
    }
    
    public PiggyBanksPage goToPiggyBanks() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", piggyBanks);
        return new PiggyBanksPage(driver);
    }
    
    public BillsPage goToBills() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", bills);
        return new BillsPage(driver);
    }
    
    
    public ProfilePage goToProfile() {
        return new ProfilePage(driver);
    }
    
    public LoginPage logout() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", logout);
        return new LoginPage(driver);
    } 
}