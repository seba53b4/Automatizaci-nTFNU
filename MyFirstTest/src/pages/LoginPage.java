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
    By userNT= By.xpath("//*[@id=\"theform\"]/table/tbody/tr[1]/td[2]/a");
    By userNTpp=By.xpath("/html/body/div[3]/div[3]/div[1]/table/tbody/tr/td/div[1]/form/table/tbody/tr[2]/td/div[2]");
    

    public LoginPage() {
       super();
    }
    
    public void Nav(){
     click(botonnavegador);
     click(linknavegador);
     
    }
    public void signIn_Jit(){
        
   click(userNT);
    if(isDisplayed(user)){
    sendKeys("temu\\ipupo",user);
    sendKeys("Movistar.12",pass);
        click(botonlog);
    }else{
       System.out.println("username textbox was not present");
    }
   } 
    public void signIn(){
        
   click(userNTpp);
    if(isDisplayed(user)){
    sendKeys("temu\\ipupo",user);
    sendKeys("Movistar.12",pass);
        click(botonlog);
    }else{
       System.out.println("username textbox was not present");
    }
   }  
}
