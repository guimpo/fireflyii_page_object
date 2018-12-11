/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.fireflyiii.po;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 *
 * @author paulo
 */
public class NavBarTop extends BasePage {

    @FindBy(xpath = "//*[@id=\"app\"]/header/nav/div/ul/li[3]/span/span")
    private WebElement user;
    
    public NavBarTop(WebDriver driver) {
        super(driver);
    }
    
    public String getCurrentEmailUser() {
        return user.getAttribute("innerHTML");
    }
}
