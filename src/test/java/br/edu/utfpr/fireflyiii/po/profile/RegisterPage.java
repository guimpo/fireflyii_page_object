/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.fireflyiii.po.profile;

import br.edu.utfpr.fireflyiii.po.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 *
 * @author paulo
 */
public class RegisterPage extends BasePage {
    
    private WebElement email;
    private WebElement password;
    private WebElement password_confirmation;
    
    
    public RegisterPage(WebDriver driver) {
        super(driver);
    }
    
    public RegisterPage setEmail(String keysToSend) {
        this.email.sendKeys(keysToSend);
        return this;
    }
    
    public RegisterPage setPassword(String keysToSend) {
        this.password.sendKeys(keysToSend);
        return this;
    }
    
    public RegisterPage setPasswordConfirmation(String keysToSend) {
        this.password_confirmation.sendKeys(keysToSend);
        return this;
    }
    
    public NewUserPage register() {
        this.password_confirmation.submit();
        return new NewUserPage(driver);
    }
}
