/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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
    By userNT= By.xpath("//div[@class=\"buttonInner\" and a[contains(text(),\"Inicie sesión como usuario de NT\")] ]");
    ///html/body/div[3]/div[3]/div[1]/table/tbody/tr/td/div[1]/form/table/tbody/tr[2]/td/div[2]/div
    By userNTpp=By.xpath("/html/body/div[3]/div[3]/div[1]/table/tbody/tr/td/div[1]/form/table/tbody/tr[2]/td/div[2]");
    

    public LoginPage() {
       super();
    }
    
    public void Nav(){
     click(botonnavegador);
     click(linknavegador);
     
    }
    public void signIn_Jit() throws InterruptedException{
        
   click(userNT);
    if(isDisplayed(user)){
    //sendKeys("temu\\ipupo",user);
    //sendKeys("Movistar.123",pass);
        click(botonlog);
    }else{
       System.out.println("username textbox was not present");
    }
   } 
    public void signIn(){
        
   click(userNTpp);
    if(isDisplayed(user)){
     WebElement user1=findElement(user);
     WebElement pass1=findElement(pass);
    sendKeys("temu\\ipupo",user1);
    sendKeys("Movistar.123",pass1);
        click(botonlog);
    }else{
       System.out.println("username textbox was not present");
    }
   }  
}
