/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Base;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
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
        
    }
    return bt;
 }  

public static void getNewDriver(){
    
    if (driver != null) {
        driver.close();
        driver.quit();
    }
    System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\drivers\\chromedriver.exe");
    driver= new ChromeDriver();
    driver.manage().window().maximize();
}


public void closeDriver(){
    this.driver.quit();
    this.driver = null;
}


public void small_Wait(By e){

     FluentWait wai= new FluentWait(driver);
     wai.withTimeout(5,TimeUnit.SECONDS);
     wai.pollingEvery(500,TimeUnit.MILLISECONDS);
     wai.ignoring(NoSuchElementException.class);
     wai.until((ExpectedCondition<Boolean>) new ExpectedCondition<Boolean>() {
         @Override
         public Boolean apply(WebDriver driver1) {
             WebElement ele = driver1.findElement(e);
             if(ele==null) {  
                return false;
                }                   
                 else    
                System.out.println("found el elemento " + e.toString());
                 return true;
            
         }
     });  
}
public void small_Time_Wait(By e, int tiempo, int lapso){

     FluentWait wai= new FluentWait(driver);
     wai.withTimeout(tiempo,TimeUnit.SECONDS);
     wai.pollingEvery(lapso,TimeUnit.MILLISECONDS);
     wai.ignoring(NoSuchElementException.class);
     wai.until((ExpectedCondition<Boolean>) new ExpectedCondition<Boolean>() {
         @Override
         public Boolean apply(WebDriver driver1) {
             WebElement ele = driver1.findElement(e);
             if(ele==null) {  
                return false;
                }                   
                 else    
                System.out.println("found el elemento " + e.toString());
                 return true;
            
         }
     });  
}

public WebElement Wait(By e){
    // Inicializa y espera hasta que se haga clic en el element(link): tiempo de espera en 10 segundos
    //try
    WebElement wb = null;
    while (wb == null) {
        try{
            small_Wait(e);
            wb = findElement(e);
            if (wb != null) {
                return wb;
            }
        }catch(TimeoutException r ) {
            System.err.println("NO esta visible el elemento: " + e);
        }
        catch (NoSuchElementException t) {
            System.err.println("El elemento localizado" + e);
        }catch (ElementClickInterceptedException ea){
            System.err.println("Elemento interceptado al clickear " + e);
        }
        catch (ElementNotInteractableException w) {
            System.err.println("Esperar a que el elemento sea interactuable" + e);
        }catch (UnhandledAlertException w) {
            System.err.println("Aparece un mensaje de Alerta antes de " + e);
        }
        catch (NullPointerException z) {
            System.err.println("Esperar a que el elemento no este vacio" + e);
        }
    }
    return wb;
}
public WebElement Wait_Click(By e){
    
    WebElement wb = null;
    int i = 0;
    while (wb == null) {
        try{
            System.out.println("Ejecucion num: "+i+" en wait click");
            WebDriverWait firstResult = new WebDriverWait(driver, 3);
            firstResult.until(ExpectedConditions.presenceOfElementLocated(e));
            System.out.println("Expected condition presence" + ExpectedConditions.presenceOfElementLocated(e));
            
            firstResult.until(ExpectedConditions.elementToBeClickable(e));
            System.out.println("Expected condition clickable" + ExpectedConditions.elementToBeClickable(e));
            
            
            wb = findElement(e);
            
        }catch(TimeoutException r ) {
            System.err.println("NO esta visible el elemento: " + e);
        }
        catch (NoSuchElementException t) {
            System.err.println("El elemento localizado" + e);
        }catch (ElementClickInterceptedException ea){
            System.err.println("Elemento interceptado al clickear " + e);
        }
        catch (ElementNotInteractableException w) {
            System.err.println("Esperar a que el elemento sea interactuable" + e);
        }catch (UnhandledAlertException w) {
            System.err.println("Aparece un mensaje de Alerta antes de " + e);
        }
        catch (NullPointerException z) {
            System.err.println("Esperar a que el elemento no este vacio" + e);
        }
    }
    
    return wb;
}
  
public void Wait_element_progress(WebElement e){ 

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
                System.out.println("found el elemento: "+ e);
                 return true;
            
         }
     });  
}

/*public void Wait_element_Click(WebElement e){ 
   
             // Inicializa y espera hasta que se haga clic en el element(link): tiempo de espera en 10 segundos
        WebDriverWait firstResult = new WebDriverWait(driver, 10);
        firstResult.until(ExpectedConditions.visibilityOf(e));
        firstResult.until(ExpectedConditions.elementToBeClickable(e));
// Imprime en pantalla el primer resultado
System.out.println(firstResult);  
    
}*/

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
/*
public void sendKeys(String inputText,WebElement locator){
    locator.sendKeys(inputText);
}*/
public void sendKeys(String inputText,By locator){
    driver.findElement(locator).sendKeys(inputText);
}

public void click(By locator) throws InterruptedException{
    Thread.sleep(250);
    driver.findElement(locator).click();
}

public void click(WebElement element) throws InterruptedException{
    Thread.sleep(250);
    element.click();
}

public Boolean isDisplayed(By locator){
    try{
        return driver.findElement(locator).isDisplayed();
    }catch (Exception e){
        return false;
    }
    
}

public String obtener_urlSO(){
         
        String url = driver.getCurrentUrl();
        return url;
    }



public void visit(String url){
    
    
    
    /*try
    {
        
        Alert a = null;
        a = driver.switchTo().alert();
        a.accept();
    } catch (NoAlertPresentException e){
        System.out.println(e+ "Error en visit");
    } finally{*/
        driver.get(url);
    //}
            
    
}

}


    

