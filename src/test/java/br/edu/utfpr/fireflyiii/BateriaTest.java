package br.edu.utfpr.fireflyiii;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import br.edu.utfpr.fireflyiii.po.BasePage;
import br.edu.utfpr.fireflyiii.po.profile.AccountDeletePage;
import br.edu.utfpr.fireflyiii.po.FireFlyBasePage;
import br.edu.utfpr.fireflyiii.po.LoginPage;
import br.edu.utfpr.fireflyiii.po.budget.BudgetPage;
import br.edu.utfpr.fireflyiii.po.budget.BudgetCreatePage;
import br.edu.utfpr.fireflyiii.po.categories.CategoriesCreatePage;
import br.edu.utfpr.fireflyiii.po.categories.CategoriesPage;
import br.edu.utfpr.fireflyiii.po.moneymanagement.BillsPage;
import br.edu.utfpr.fireflyiii.po.moneymanagement.BillsCreatePage;
import br.edu.utfpr.fireflyiii.po.moneymanagement.PiggyBanksCreatePage;
import br.edu.utfpr.fireflyiii.po.moneymanagement.RuleCreatePage;
import br.edu.utfpr.fireflyiii.po.moneymanagement.PiggyBanksPage;
import br.edu.utfpr.fireflyiii.po.profile.NewUserPage;
import br.edu.utfpr.fireflyiii.po.profile.RegisterPage;
import br.edu.utfpr.fireflyiii.po.reports.ReportsPage;
import br.edu.utfpr.fireflyiii.po.transactions.DepositCreatePage;
import br.edu.utfpr.fireflyiii.po.transactions.WithdrawalCreatePage;
import br.edu.utfpr.fireflyiii.po.transactions.DepositPage;
import br.edu.utfpr.fireflyiii.po.transactions.WithdrawalPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

/**
 *
 * @author paulo
 */
public class BateriaTest {
    
    private static int scId = 0;
    
    private final static int WAIT = 10;
    
    private WebDriver driver;
    
    private FireFlyBasePage fireFly;
    private LoginPage login;
       
    @BeforeClass
    public static void setUpClass() {
        WebDriverManager.chromedriver().setup();
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        ChromeOptions chromeOptions = new ChromeOptions();
//        chromeOptions.addArguments("headless");
        chromeOptions.addArguments("window-size=1200x600");
        chromeOptions.addArguments("start-maximized");
        
        driver = new ChromeDriver(chromeOptions);
        driver.manage().timeouts().implicitlyWait(WAIT, TimeUnit.SECONDS);        
    }
    
    @After
    public void tearDown() {
        driver.close();
    }
    
//    @Ignore
    @Test
    public void ct00() {
        boolean isRegistred = new LoginPage(driver).getUrl()
                .equals(BasePage.DOMINIO + "/login");
        
        if(isRegistred) {
            login = new LoginPage(driver);
            login.setEmail("teste@teste.com").setPassword("teste");
            fireFly = login.signIn();
        } else {
            RegisterPage register = new RegisterPage(driver);
        
            NewUserPage newUser = register.setEmail("teste@teste.com")
                    .setPassword("teste")
                    .setPasswordConfirmation("teste")
                    .register();

            assertTrue(newUser.getUrl().equals(BasePage.DOMINIO + "/new-user"));

            fireFly = newUser.setBankName("corrente")
                    .selectBrCurrency()
                    .setBankBalance(1000.0d)
                    .submit();
            
            fireFly.skipAnnoyingTutorial();

            assertTrue(fireFly.getCurrentMessage()
                    .equals("Success! Yay! Your new accounts have been stored."));
            
            assertTrue(fireFly.getSubTitle().equals("What's playing?"));
            
            assertTrue(fireFly.getBoxNetWorth().equals("R$1,000.00"));
        }
        
        assertTrue(fireFly.getCurrentEmailUser().equals("teste@teste.com"));

        assertTrue(fireFly.getNavBarSide().logout().getUrl()
                .equals(BasePage.DOMINIO + "/login"));
    }
    
//    @Ignore
    @Test
    public void ct01() {
        login = new LoginPage(driver);
        login.setEmail("teste@teste.com").setPassword("teste");
        fireFly = login.signIn();
        
        assertTrue(fireFly.getNavBarSide().clickTransaction()
                .transactionIsDisplayed());
        
        DepositPage deposit =  fireFly.getNavBarSide()
                .clickTransaction()
                .goToRevenueIncome();
        
        assertTrue(deposit.getUrl().equals(BasePage.DOMINIO + "/transactions/deposit"));
        
        DepositCreatePage createDeposit = deposit.clickNewDeposit();
        
        assertTrue(createDeposit.getMandatoryFieldsTitle().equals("Mandatory fields"));
        
        deposit = createDeposit.setDescription("salario")
                .setRevenueAccount("salario")
                .selectDestinationAccount("corrente (R$1,000.00)")
                .setAmount(1000.00d)
                .submitDeposit();
        
        assertTrue(deposit.getCurrentMessage()
                .equals("Success! Successfully created new transaction \"salario\""));
    }
    
//    @Ignore
    @Test
    public void ct02() {
        login = new LoginPage(driver);
        login.setEmail("teste@teste.com").setPassword("teste");
        fireFly = login.signIn();
        BudgetPage budget = fireFly.getNavBarSide().goToBudget();
        
        assertTrue(budget.getSubTitle().equals("Budgets"));
        
        BudgetCreatePage createBudget = budget.clickNewBudget();
        
        assertTrue(createBudget.getMandatoryFieldsTitle().equals("Mandatory fields"));
        
        createBudget.setName("transporte");
        budget = createBudget.submitBudget();
        
        assertTrue(budget.getCurrentMessage().equals("Success! Stored new budget \"transporte\""));
        
        budget.setBudgeted(420.00d);
        takeScreenShot();
        
        System.out.println(budget.getleftPerDay());
        assertTrue(budget.getleftPerDay().equals("R$420.00 (R$21.00)"));
        
        takeScreenShot();
    }
    
//    @Ignore
    @Test
    public void ct03() {
        login = new LoginPage(driver);
        login.setEmail("teste@teste.com").setPassword("teste");
        fireFly = login.signIn();
        
        fireFly.getNavBarSide().clickTransaction();
        
        assertTrue(fireFly.getNavBarSide().transactionIsDisplayed());
        
        WithdrawalPage withdrawal = fireFly.getNavBarSide().goToExpenses();
        
        assertTrue(withdrawal.getTitle().contains("expenses"));
        
        WithdrawalCreatePage createWithdrawal =  withdrawal.clickNewWithdrawal();
        
        assertTrue(createWithdrawal.getMandatoryFieldsTitle().equals("Mandatory fields"));
        
        withdrawal = createWithdrawal.setDescription("transporte")
                .selectSourceAccount("corrente (R$2,000.00)")
                .setExpenseAccount("transporte")
                .setAmount(420.00d)
                .selectBudget("transporte")
                .submit();
        
        assertTrue(withdrawal.getCurrentMessage()
                .equals("Success! Successfully created new transaction \"transporte\""));
    }
    
//    @Ignore
    @Test
    public void ct04() {
        login = new LoginPage(driver);
        login.setEmail("teste@teste.com").setPassword("teste");
        fireFly = login.signIn();
        
        fireFly.getNavBarSide().clickMoneyManagement();
        
        assertTrue(fireFly.getNavBarSide().moneyManagementIsDisplayed());
        
        BillsPage bills = fireFly.getNavBarSide().goToBills();
        
        assertTrue(bills.getTitle().contains("Bills"));
        
        BillsCreatePage createBills =  bills.clickNewWithdrawal();
        
        assertTrue(createBills.getMandatoryFieldsTitle().equals("Mandatory fields"));
        
        RuleCreatePage createRule= createBills.setName("internet")
                .selectCurrency("Brazilian real (R$)")
                .setMinimumAmount(120.00d)
                .setMaximumAmount(120.00)
                .selectRepeats("monthly")
                .submit();
        
        assertTrue(createRule.getCurrentMessage().equals("Success! Stored new bill \"internet\""));
               
        assertTrue(createRule.getUrl().contains("rules/create"));
        
        createRule.skipAnnoyingTutorial();
        
        bills = createRule.clickStoreNewRule();
        
        assertTrue(bills.getUrl().contains("bills"));
        
         assertTrue(bills.getCurrentMessage()
                 .equals("Success! Stored new rule with title \"Rule for bill \"internet\"\""));
    }
    
//    @Ignore
    @Test
    public void ct05() {
        login = new LoginPage(driver);
        login.setEmail("teste@teste.com").setPassword("teste");
        fireFly = login.signIn();
        assertTrue(fireFly.getCurrentEmailUser().equals("teste@teste.com"));
        
        fireFly.getNavBarSide().clickTransaction();
        
        assertTrue(fireFly.getNavBarSide().transactionIsDisplayed());
        
        WithdrawalPage withdrawal = fireFly.getNavBarSide().goToExpenses();
        
        assertTrue(withdrawal.getTitle().contains("expenses"));
        
        WithdrawalCreatePage createWithdrawal =  withdrawal.clickNewWithdrawal();
        
        assertTrue(createWithdrawal.getMandatoryFieldsTitle().equals("Mandatory fields"));
        
        withdrawal = createWithdrawal.setDescription("internet")
                .selectSourceAccount("corrente (R$1,580.00)")
                .setExpenseAccount("transporte")
                .setAmount(120.00d)
                .submit();
        
        assertTrue(withdrawal.getCurrentMessage()
                .equals("Success! Successfully created new transaction \"internet\""));
        
        assertTrue(fireFly.getNavBarSide().goToDashBoard().getBoxNetWorth().equals("R$1,460.00"));
    }
    
//    @Ignore
    @Test
    public void ct06() {
        login = new LoginPage(driver);
        login.setEmail("teste@teste.com").setPassword("teste");
        fireFly = login.signIn();
        assertTrue(fireFly.getCurrentEmailUser().equals("teste@teste.com"));
        
        fireFly.getNavBarSide().clickMoneyManagement();
        
        assertTrue(fireFly.getNavBarSide().moneyManagementIsDisplayed());
        
        PiggyBanksPage piggy = fireFly.getNavBarSide().goToPiggyBanks();
        
        assertTrue(piggy.getTitle().contains("Piggy banks"));
        
        PiggyBanksCreatePage createPiggy =  piggy.clickNewPiggyBank();
        
        assertTrue(createPiggy.getMandatoryFieldsTitle().equals("Mandatory fields"));
        
        piggy = createPiggy.setName("relogioXadrez")
                .selectSaveOnAccount("corrente (R$1,460.00)")
                .setTargetAmount(120.00d)
                .submit();
        
        assertTrue(piggy.getCurrentMessage().equals("Success! Store new piggy bank \"relogioXadrez\""));
    }

//    @Ignore
    @Test
    public void ct07() {
        login = new LoginPage(driver);
        login.setEmail("teste@teste.com").setPassword("teste");
        fireFly = login.signIn();
        assertTrue(fireFly.getCurrentEmailUser().equals("teste@teste.com"));
        
        fireFly.getNavBarSide().clickMoneyManagement();
        
        assertTrue(fireFly.getNavBarSide().moneyManagementIsDisplayed());
        
        PiggyBanksPage piggy = fireFly.getNavBarSide().goToPiggyBanks();
        
        piggy.skipAnnoyingTutorial();
        
        assertTrue(piggy.getTitle().contains("Piggy banks"));
        
        piggy.skipAnnoyingTutorial();
                
        piggy = piggy.clickAddMoney();
        
        assertTrue(piggy.getAddMoneyTitle().equals("Add money to piggy bank \"relogioXadrez\""));
        
        piggy = piggy.setAmount(20.00d).submit();
        
        assertTrue(piggy.getLeftToSave().equals("R$100.00"));

        takeScreenShot();
        System.out.println(piggy.getCurrentMessage());
        assertTrue(piggy.getCurrentMessage().equals("Success! Added R$20.00 to \"relogioXadrez\""));
    }
    
    @Test
    public void ct08() {
        login = new LoginPage(driver);
        login.setEmail("teste@teste.com").setPassword("teste");
        fireFly = login.signIn();
        assertTrue(fireFly.getCurrentEmailUser().equals("teste@teste.com"));
        
        ReportsPage reports = fireFly.getNavBarSide().goToReports();
        
        assertTrue(reports.getTitle().contains("Reports"));
        
        reports.selectIncludedAccounts("corrente");
        
        reports.submit();
        
        assertTrue(reports.getInReport().equals("R$1,000.00"));
        assertTrue(reports.getOutReport().equals("R$-540.00"));
        assertTrue(reports.getDifferenceReport().equals("R$460.00"));
    }
    
    @Test
    public void ct09() {
        login = new LoginPage(driver);
        login.setEmail("teste@teste.com").setPassword("teste");
        fireFly = login.signIn();
        assertTrue(fireFly.getCurrentEmailUser().equals("teste@teste.com"));
        
        CategoriesCreatePage createCategories = fireFly
                .getNavBarSide()
                .goToCategories()
                .clickNewCategory();
        
        assertTrue(createCategories.getMandatoryFieldsTitle().equals("Mandatory fields"));
        
        CategoriesPage categories = createCategories.setName("lazer").submit();
                
        assertTrue(categories.getCurrentMessage().equals("Success! Stored new category \"lazer\""));
    }
    
    @Test
    public void ct10() {
        login = new LoginPage(driver);
        login.setEmail("teste@teste.com").setPassword("teste");
        fireFly = login.signIn();
        assertTrue(fireFly.getCurrentEmailUser().equals("teste@teste.com"));    
                
        fireFly.getNavBarSide().clickTransaction();
        
        assertTrue(fireFly.getNavBarSide().transactionIsDisplayed());
        
        WithdrawalPage withdrawal = fireFly.getNavBarSide().goToExpenses();
        
        assertTrue(withdrawal.getTitle().contains("expenses"));
        
        WithdrawalCreatePage createWithdrawal =  withdrawal.clickNewWithdrawal();
        
        assertTrue(createWithdrawal.getMandatoryFieldsTitle().equals("Mandatory fields"));
        
        withdrawal = createWithdrawal.setDescription("futebol")
                .selectSourceAccount("corrente (R$1,460.00)")
                .setExpenseAccount("lazer")
                .setAmount(10.00d)
                .setCategory("lazer")
                .submit();
        
        assertTrue(withdrawal.getCurrentMessage()
                .equals("Success! Successfully created new transaction \"futebol\""));
        System.out.println(withdrawal.getCategory());
        assertTrue(withdrawal.getCategory().equals("lazer"));
    }
    
//    @Ignore
    @Test
    public void ct11() {
        login = new LoginPage(driver);
        login.setEmail("teste@teste.com").setPassword("teste");
        fireFly = login.signIn();
        assertTrue(fireFly.getCurrentEmailUser().equals("teste@teste.com"));
        
        AccountDeletePage deleteAccountPage = fireFly.getNavBarSide()
                .goToProfile()
                .goToDeleteAccount();
        
        assertTrue(deleteAccountPage.getSubTitle().equals("Delete account"));
        
        RegisterPage registerPage = deleteAccountPage.setPasswordAndConfirm("teste");
        
        assertTrue(registerPage.getUrl().equals(BasePage.DOMINIO + "/register"));
    }
    
    
    private void takeScreenShot() {
        File sourceFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            scId++;
            FileUtils.copyFile(sourceFile, new File("./res/" + scId + ".png"));
        } catch(IOException e) {}
    }
}
