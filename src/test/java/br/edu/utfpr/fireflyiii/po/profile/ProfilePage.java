/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.fireflyiii.po.profile;

import br.edu.utfpr.fireflyiii.po.FireFlyBasePage;
import org.openqa.selenium.WebDriver;

/**
 *
 * @author paulo
 */
public class ProfilePage extends FireFlyBasePage {

    public ProfilePage(WebDriver driver) {
        super(driver);
        driver.get(DOMINIO + "/profile");
    }
    
    public AccountDeletePage goToDeleteAccount() {
        return new AccountDeletePage(driver);
    }
}
