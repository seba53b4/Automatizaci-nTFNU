/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pages;

import Base.BasePage;
import java.util.List;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

/**
 *
 * @author seolivera
 */
public class AAPage extends Base.BasePage{
    
    By login_volver = By.xpath("/html/body/table/tbody/tr[3]/td/a");
    By user_login = By.xpath("/html/body/form[1]/table/tbody/tr/td/table/tbody/tr[2]/td/table/tbody/tr[2]/td[2]/center/table/tbody/tr[1]/td[2]/input");
    By user_pass = By.xpath("/html/body/form[1]/table/tbody/tr/td/table/tbody/tr[2]/td/table/tbody/tr[2]/td[2]/center/table/tbody/tr[2]/td[2]/input");
    By boton_entrar = By.xpath("/html/body/form[1]/table/tbody/tr/td/table/tbody/tr[2]/td/table/tbody/tr[2]/td[2]/center/table/tbody/tr[5]/td/input[2]");
    By consulta_SitActual = By.xpath("/html/body/div[17]/table/tbody/tr/td/table/tbody/tr[1]/td/a/div/table/tbody/tr/td/font");
    By boton_MovistarPP = By.xpath("/html/body/div[1]/table/tbody/tr[2]/td[1]/table/tbody/tr[3]");
    By input_Telefono = By.xpath("/html/body/table[1]/tbody/tr/td/table/tbody/tr[2]/td[4]/input");
    By boton_Buscar = By.xpath("/html/body/table[1]/tbody/tr/td/table/tbody/tr[2]/td[16]/input");
    By tablas_Estado = By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[4]/td[2]/table/tbody");
    By plan_AA = By.xpath("/html/body/table[2]/tbody/tr/td[1]/div[1]/table/tbody/tr[2]/td/table/tbody/tr[22]/td[8]/input");
    
    
     

    
    public void logIN()
    {
        BasePage.initBaseTest();
        this.visit("http://10.24.167.216/AltamirA/bowe/bw_co_Movistar");
        Wait(login_volver);
        click(login_volver);
        WebElement user_login1=findElement(user_login);
        WebElement user_pass1=findElement(user_pass);
        this.sendKeys("isecco", user_login);
        this.sendKeys("Movistar.1", user_pass);
        click(boton_entrar);
    }
    
    public boolean consultaEstado(String num,String plan)
    {
        //Wait(boton_MovistarPP);
        //click(boton_MovistarPP);
        visit("http://10.24.167.216/AltamirA/bowe/bw_co_CargaSituacionActual?ID=infoSituacionActual");
        //Wait(consulta_SitActual);
        //click(consulta_SitActual);
        WebElement input_telef =findElement(input_Telefono);
        sendKeys(num, input_Telefono);
        click(boton_Buscar);
        WebElement wb = seleccionarEstadoActual("PRE");
        
        click(wb);
        Alert alert = BasePage.driver.switchTo().alert();
        alert.accept();
        
        Wait(plan_AA);
        System.out.println(findElement(plan_AA).getAttribute("value"));
        
        return findElement(plan_AA).getAttribute("value").contains(plan);
    }
    
    public WebElement seleccionarEstadoActual(String estado)
    {
        WebElement tb = findElement(tablas_Estado);
        List<WebElement> tablas = tb.findElements(By.tagName("tr"));
        WebElement actual = null; // td, el segundo que contiene
        List<WebElement> td = null;
        WebElement aux = null;
        for (int i = 0; i < tablas.size(); i++) {
            td = tablas.get(i).findElements(By.tagName("td"));
            //System.out.println("td largo"+ td.size());
            for (int j = 0; j < td.size(); j++) {
                try{
                aux = td.get(j).findElement(By.tagName("p"));
                    //System.out.println("Entra");
                } catch(NoSuchElementException e)
                {
                    System.out.println("ERROR"+i+" "+j);
                }
                if (aux != null && getText(aux).contains(estado) && getText(td.get(3)).equals("")) {
                    //System.out.println(aux.getText()+" j");
                    actual = td.get(0);
                    break;
                }///html/body/table/tbody/tr/td/table/tbody/tr[4]/td[2]/table/tbody/tr[2]/td[2]/p/text()
                
            }
        
        }
        return actual.findElement(By.tagName("a"));
    }
}
