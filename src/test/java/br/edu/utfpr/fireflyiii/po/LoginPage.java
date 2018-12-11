/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.fireflyiii.po;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 *
 * @author paulo
 */
public class LoginPage extends BasePage {
    
    private WebElement email;
    private WebElement password;
    
    public LoginPage(WebDriver driver) {
        super(driver);
        driver.get(DOMINIO + "/login");
    }
    
    public LoginPage setEmail(String keysToSend) {
        this.email.sendKeys(keysToSend);
        return this;
    }
    
    public LoginPage setPassword(String keysToSend) {
        this.password.sendKeys(keysToSend);
        return this;
    }
    
    public FireFlyBasePage signIn() {
        this.password.submit();
        return new FireFlyBasePage(driver);
    }
}
