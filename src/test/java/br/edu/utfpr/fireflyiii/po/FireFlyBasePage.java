/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.fireflyiii.po;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 *
 * @author paulo
 */
public class FireFlyBasePage extends BasePage {
    
    @FindBy(id = "box-net-worth")
    private WebElement boxNetWorth;
    private WebElement subTitle;
    private NavBarTop navBarTop;
    private NavBarSide navBarSide;
    
    public FireFlyBasePage(WebDriver driver) {
        super(driver);
        navBarTop = new NavBarTop(driver);
        navBarSide = new NavBarSide(driver);
    }
    
    public NavBarTop getNavBarTop() {
        return navBarTop;
    }
    
    public NavBarSide getNavBarSide() {
        return navBarSide;
    }
    
    public String getSubTitle() {
        return subTitle.getText();
    }
    
    public String getCurrentEmailUser() {
        return navBarTop.getCurrentEmailUser();
    }
    
    public String getCurrentMessage() {
        List<WebElement> es = driver.findElements(By.xpath("//*[@id=\"app\"]/div[1]/section[2]/div[1]"));
        wait.until(ExpectedConditions.elementToBeClickable(es.get(0)));
        
        String msg = es.get(0).getText();
        msg = msg.replaceFirst("×", "")
                .replaceAll("\\r\\n|\\r|\\n", "")
                .replaceFirst("Close", "");

        return msg.trim();
    }
    
    public FireFlyBasePage skipAnnoyingTutorial() {
        
        if(annoyingTutorialExist()) {
            WebElement tutorialSkip = driver.findElement(
                    By.className("introjs-button,introjs-skipbutton"));

            WebDriverWait wait = new WebDriverWait(driver, 10);
            wait.until(ExpectedConditions.elementToBeClickable(tutorialSkip));

            tutorialSkip.click();
        }
        return this;
    }
    
    public boolean annoyingTutorialExist() {
         return !driver.findElements(By.className("introjs-skipbutton")).isEmpty();
    }
    
    public String getBoxNetWorth() {
        wait.until(ExpectedConditions.elementToBeClickable(boxNetWorth));
        return boxNetWorth.getText();
    }
}
