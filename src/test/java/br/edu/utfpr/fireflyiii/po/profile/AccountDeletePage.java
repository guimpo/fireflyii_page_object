/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.fireflyiii.po.profile;


import br.edu.utfpr.fireflyiii.po.FireFlyBasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 *
 * @author paulo
 */
public class AccountDeletePage extends FireFlyBasePage {
    
    WebElement password;
    
    @FindBy(xpath = "//*[@id=\"delete-account\"]/div/div/div/div[3]/button")
    private WebElement btnDelete;
    
    public AccountDeletePage(WebDriver driver) {
        super(driver);
        driver.get(DOMINIO + "/profile/delete-account");
    }
    
    public RegisterPage setPasswordAndConfirm(String keysToSend) {
        password.sendKeys(keysToSend);
        btnDelete.click();
        driver.switchTo().alert().accept();
        return new RegisterPage(driver);
    }
}
