/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.fireflyiii.po.reports;

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
public class ReportsPage extends FireFlyBasePage {
    
    private Select includedAccounts;
    
    @FindBy(xpath = "//*[@id=\"inputAccountsSelect\"]/span/div/ul/li[4]/a/label/input")
    private WebElement correnteInput;
    
    @FindBy(xpath = "//*[@id=\"inputAccountsSelect\"]/span/div/button")
    private WebElement btnSubmit;
    
    @FindBy(id = "incomeVsExpenseReport")
    private WebElement incomeVsExpenses;
    
    @FindBy(xpath = "//*[@id=\"incomeVsExpenseReport\"]/table/tbody/tr[1]/td[2]/span")
    private WebElement inReport;

    @FindBy(xpath = "//*[@id=\"incomeVsExpenseReport\"]/table/tbody/tr[2]/td[2]/span")
    private WebElement outReport;
    
    @FindBy(xpath = "//*[@id=\"incomeVsExpenseReport\"]/table/tbody/tr[3]/td[2]/span")
    private WebElement differenceReport;
    
    public ReportsPage(WebDriver driver) {
        super(driver);

        WebElement select = wait.until(d -> {
            return d.findElement(By.id("inputAccounts"));
        });
        
        includedAccounts = new Select(select);
    }
    
    public void selectIncludedAccounts(String value) {
        List<WebElement> options =  includedAccounts.getOptions();
        String select = "";
        for(WebElement e : options) {
            System.out.println(e.getText());
            if(e.getText().trim().equals(value)) {
                select = e.getText();
            }
        }
        includedAccounts.selectByVisibleText(select);
    }
    
    public ReportsPage submit() {
        btnSubmit = wait.until(d -> {
            return d.findElement(By.xpath("//*[@id=\"inputAccountsSelect\"]/span/div/button"));
        });
        btnSubmit.submit();
        return this;
    }

    
    public String getInReport() {
        inReport = wait.until(d -> {
            return d.findElement(By.xpath("//*[@id=\"incomeVsExpenseReport\"]/table/tbody/tr[1]/td[2]/span"));
        });
        return inReport.getText();
    }

    public String getOutReport() {
        outReport = wait.until(d -> {
            return d.findElement(By.xpath("//*[@id=\"incomeVsExpenseReport\"]/table/tbody/tr[2]/td[2]/span"));
        });
        return outReport.getText();
    }

    public String getDifferenceReport() {
        differenceReport = wait.until(d -> {
            return d.findElement(By.xpath("//*[@id=\"incomeVsExpenseReport\"]/table/tbody/tr[3]/td[2]/span"));
        });
        return differenceReport.getText();
    }
    
}
