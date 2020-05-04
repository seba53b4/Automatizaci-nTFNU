/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pages;

import static Base.BasePage.driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 *
 * @author sdominguez
 */
public class LoginPage extends Base.BasePage{
    By botonnavegador= By.xpath("//*[@id=\"details-button\"]");
    By linknavegador= By.xpath("//*[@id=\"proceed-link\"]");
    By sesionNT= By.linkText("Inicie sesión como usuario de NT");
    By user = By.xpath("//*[@id=\"userNameInput\"]");
    By pass = By.xpath("//*[@id=\"passwordInput\"]");
    By botonlog = By.xpath("//*[@id=\"submitButton\"]");
    By userNT= By.xpath("//div[@class='buttonInner' and a[contains(text(),'Inicie sesión como usuario de NT')]]");
    By userNT_preprod=By.xpath("//a[@href='#' and contains(text(),'Inicie sesión como usuario de NT')]");
    ///html/body/div[3]/div[3]/div[1]/table/tbody/tr/td/div[1]/form/table/tbody/tr[2]/td/div[2]/div
    By userNTpp=By.xpath("/html/body/div[3]/div[3]/div[1]/table/tbody/tr/td/div[1]/form/table/tbody/tr[2]/td/div[2]");
    
    private static LoginPage loginP;
    private String usuario;

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getPassword() {
        return password;
    }
    private String password;
    
    public LoginPage() {
       super();
    }
    
    public static LoginPage initLoginPage()
    {
        if (loginP == null) {
            loginP = new LoginPage();
        }
        return loginP;
    }
    
    
    
    public void Nav(String env){
       
     
     if(env.contains("preprod")){
     Boolean nav= new WebDriverWait(driver, 10)
        .until(ExpectedConditions.invisibilityOfElementLocated(botonnavegador)); 
      Boolean link= new WebDriverWait(driver, 10)
        .until(ExpectedConditions.invisibilityOfElementLocated(linknavegador));
     }
     else{
         click(botonnavegador);
         click(linknavegador); 
     }  
    }
    public void signIn_preprod() throws InterruptedException{
        
    click(userNT_preprod);
    if(isDisplayed(user)){
     WebElement user1=findElement(user);
     WebElement pass1=findElement(pass);
    sendKeys("temu\\ipupo",user1);
    sendKeys("Movistar.1234",pass1);
        click(botonlog);
    }else{
       System.out.println("username textbox was not present");
    }
   } 
    public void signIn(){
    Wait_Click(userNT);
    click(userNTpp);
    if(isDisplayed(user)){
     WebElement user1=findElement(user);
     WebElement pass1=findElement(pass);
    sendKeys("temu\\ipupo",user1);
    sendKeys("Movistar.1234",pass1);
        click(botonlog);
    }else{
       System.out.println("username textbox was not present");
    }
   }  
}
