/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.fireflyiii.po;

import java.time.Duration;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

/**
 *
 * @author paulo
 */
public abstract class BasePage {
    
    public final static String DOMINIO = "http://192.168.15.36";
    
    protected WebDriver driver;
    protected Wait<WebDriver> wait;
            
    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        
        this.wait = new FluentWait<>(driver)
            .withTimeout(Duration.ofSeconds(30))
            .pollingEvery(Duration.ofSeconds(5))
            .ignoring(NoSuchElementException.class);
    }
    
    public String getTitle() {
        return driver.getTitle();
    }
    
    public String getUrl() {
        return driver.getCurrentUrl();
    }
}
