/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pages;

import static Base.BasePage.driver;
import org.openqa.selenium.By;
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
    
    protected static LoginPage loginP;
    private String usuario;
    private String password;
    
    public void setUsuario(String usuario) {
       // this.usuario = usuario;
       // loginP. usaurio = usuario;
    }
    
    public void setPassword(String password) {
        //this.password = password;
        loginP.setPassword(password);
    }
    
    public String getUsuario() {
        return usuario;
    }
    
    public String getPassword() {
        return password;
    }
    
    public LoginPage(String usr, String pass) {
        super();
        usuario = usr;
        password = pass;
    }
    public LoginPage() {
        super();
        usuario = "dammy";
        password = "dammy";
    }
    
    public static LoginPage getLoginPage(){
        return LoginPage.loginP;
    }
    
    
    public static LoginPage initLoginPage(String usr, String pass)
    {
        if (loginP == null) {
            loginP = new LoginPage(usr,pass);
        }
        return loginP;
    }
    public static LoginPage initLoginPage()
    {
        if (loginP == null) {
            loginP = new LoginPage();
        }
        return loginP;
    }
    
    
    
    public void Nav(String env) throws InterruptedException{
        
        
        if(env.contains("preprod")){
            Boolean nav= new WebDriverWait(driver, 10)
                    .until(ExpectedConditions.invisibilityOfElementLocated(botonnavegador));
            Boolean link= new WebDriverWait(driver, 10)
                    .until(ExpectedConditions.invisibilityOfElementLocated(linknavegador));
        }
        else{
            click(botonnavegador);
            click(linknavegador);
            visit("https://noprd-"+env+"-toms.temu.com.uy:7002/");
        }
        
    }
    public void signIn_preprod() throws InterruptedException{
        
        
        click(userNT_preprod);
        if(isDisplayed(user)){
            sendKeys("temu\\"+usuario,user);
            sendKeys(password,pass);
            click(botonlog);
        }else{
            System.out.println("username textbox was not present");
        }
    }
    public void signIn() throws InterruptedException{
        //Wait_Click(userNT);
        click(userNTpp);
        if(isDisplayed(user)){
            sendKeys("temu\\"+usuario,user);
            sendKeys(password,pass);

        click(botonlog);
        }else{
            System.out.println("username textbox was not present");
        }
    }
}
