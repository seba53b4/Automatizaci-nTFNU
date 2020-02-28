/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Base;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;


/**
 *
 * @author sdominguez
 */
public class BasePage  {
    
public static WebDriver driver;
public static BasePage bt;



public static BasePage initBaseTest() {
  
    if (bt == null) {
        bt = new BasePage();
        System.setProperty("webdriver.chrome.driver","C:\\Users\\ipupo\\Documents\\GitHub\\Automatizaci-nTFNU\\MyFirstTest\\drivers\\chromedriver.exe");
        driver= new ChromeDriver();
        driver.manage().window().maximize();
    }    
    return bt;
    
 }  


public void small_Wait(By e){

     FluentWait wai= new FluentWait(driver);
     wai.withTimeout(20,TimeUnit.SECONDS);
     wai.pollingEvery(1,TimeUnit.SECONDS);
     wai.ignoring(NoSuchElementException.class);
     wai.until((ExpectedCondition<Boolean>) new ExpectedCondition<Boolean>() {
         @Override
         public Boolean apply(WebDriver driver1) {
             WebElement ele = driver1.findElement(e);
             if(ele==null) {  
                return false;
                }                   
                 else    
                System.out.println("found");
             
                 return true;
            
         }
     });  
}

public void Wait(By e){

     FluentWait wai= new FluentWait(driver);
     wai.withTimeout(30,TimeUnit.SECONDS);
     wai.pollingEvery(2,TimeUnit.SECONDS);
     wai.ignoring(NoSuchElementException.class);
     wai.until((ExpectedCondition<Boolean>) new ExpectedCondition<Boolean>() {
         @Override
         public Boolean apply(WebDriver driver1) {
             WebElement ele = driver1.findElement(e);
             if(ele==null) {  
                return false;
                }                   
                 else    
                System.out.println("found");
             
                 return true;
            
         }
     });  
}
public void Wait_element(WebElement e){ 

    FluentWait wai= new FluentWait(driver);
     wai.withTimeout(60,TimeUnit.SECONDS);
     wai.pollingEvery(3,TimeUnit.SECONDS);
     wai.ignoring(NoSuchElementException.class);
     wai.until((ExpectedCondition<Boolean>) new ExpectedCondition<Boolean>() {
         @Override
         public Boolean apply(WebDriver driver1) {
             //WebElement ele = driver1.findElement(e);
             
                if (e==null) {  
                return false;
                }                   
                else 
                System.out.println("found");
                 return true;
            
         }
     });  
}
public WebDriver chromeDriverConnection(){
//System.setProperty("webdriver.chrome.driver","C:\\Users\\sdominguez\\Documents\\NetBeansProjects\\MyFirstTest\\drivers\\chromedriver.exe");

return driver;
}

public WebElement findElement(By locator){
    return driver.findElement(locator);
}

public List<WebElement> findElements(By locator){
    return driver.findElements(locator);
}

public String getText(By locator){
    return driver.findElement(locator).getText();
}

public String getText(WebElement element){
    return element.getText();
}

public void sendKeys(String inputText,By locator){
    driver.findElement(locator).sendKeys(inputText);
}

public void click(By locator){
    driver.findElement(locator).click();
}

public void click(WebElement element){
    element.click();
}

public Boolean isDisplayed(By locator){
    try{
        return driver.findElement(locator).isDisplayed();
    }catch (Exception e){
        return false;
    }
    
}

public void visit(String url){
    
    driver.get(url);
    Alert a = null;
    try
    {
        a = driver.switchTo().alert();
        a.accept();
    } catch (NoAlertPresentException e){
        System.out.println(e+ "Error en visit");
    }
    
}

}


    

