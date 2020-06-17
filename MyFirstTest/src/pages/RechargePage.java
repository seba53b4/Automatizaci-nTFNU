package pages;


import Utils.CadenaUtils;
import Utils.Client;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/*package pages;

import Utils.Client;
import Utils.Plan;
import org.openqa.selenium.By;

/**
 *
 * @author ipupo
 */
public class RechargePage extends Base.BasePage{
    
    By billaccount=By.xpath("//a[@href and contains(text(),\"Cuentas de facturación\")]");
    By newrecharge=By.xpath("//button[@class='TableCtrl-button TableCtrl-button-icon NewNote'and contains(text(),\"Nueva recarga\")]");
    By importe=By.xpath("//tr[@class='gwt-row']//div[contains(text(),'Importe')]/following::input[1]");
    By suscripcion_AA=By.xpath("//tr[@class='gwt-row']//div[contains(text(),'Suscripción de Altamira')]/following::div[1]");
    By tabla=By.xpath("//*[@id=\"nc_refsel_list\"]/div[2]");
    By payment=By.xpath("//tr[@class='gwt-row']//div[contains(text(),'Método de pago')]/following::div[1]");
    By tabla_payment=By.xpath("//*[@id=\"ui-id-5\"]/div/div[2]/table/tbody/tr/td/div/form/table/tbody/tr/td/table/tbody/tr[6]/td[2]/div/table");
    By boton_crear=By.xpath("//button[contains(text(),'Crear')]");
    CadenaUtils cadena;
    
      public RechargePage() {
       cadena=new CadenaUtils();
   
    }
      public Client recargaLinea(Client newClient,String env) throws InterruptedException {
          seleccionar_billingAccount(newClient, env);
          realizar_Recarga(newClient);
      
          return newClient;
    } 
       public void initUrlBusqueda(String env){
        if (env.toLowerCase() != "preprod") {
            visit("https://noprd-"+env+"-toms.temu.com.uy:7002/ncobject.jsp?id=9155890523813779409&tab=_All+Tasks");
            
        } else
        {
             visit("https://pretoms.temu.com.uy/common/search.jsp?explorer_mode=disable&object=9141907040613227268&o=9155890323313723269");
        }
        
    }
       public void seleccionar_billingAccount(Client newClient,String env) throws InterruptedException{
     
       visit("https://noprd-"+env+"-toms.temu.com.uy:7002/platform/csr/customer.jsp?tab=_Sales+Orders+&object="+ newClient.getObject_id());
        Wait_Click(billaccount);
        click(billaccount);
        Wait_Click(newrecharge);
        Thread.sleep(4000);
        click(newrecharge);
        Thread.sleep(2000);     
   }
       public void realizar_Recarga(Client newClient) throws InterruptedException{
           Wait(importe);
           System.out.println("importe-->"+newClient.getAmount());
           sendKeys(newClient.getAmount(), importe);
           Thread.sleep(2000);
           Wait_Click(suscripcion_AA);
           click(suscripcion_AA);
           obtener_Line(newClient);
           Thread.sleep(2000);
           Wait_Click(payment);
           click(payment);
           Thread.sleep(2000);
           obtener_Payment(newClient);
           Wait_Click(boton_crear);
           click(boton_crear);
       }
       
       public void obtener_Line(Client newClient) throws InterruptedException{
       //WebElement line=null;
       Wait(tabla);
       WebElement obtener_line= findElement(tabla);
       List<WebElement> list_linea= obtener_line.findElements(By.tagName("div"));
        for (int i = 0; i < list_linea.size(); i++) {
            System.out.println("element lista-->"+list_linea.get(i).getText());
            System.out.println("linea-->"+newClient.getLine());
            if(cadena.compararCadenas(newClient.getLine(),list_linea.get(i).getText())){
            WebElement line=list_linea.get(i);
                click(line);
                break;
            }         
        }   
}
       public void obtener_Payment(Client newClient) throws InterruptedException{
        Wait(tabla_payment);
       WebElement obtener_payment= findElement(tabla_payment);
       List<WebElement> list_payment= obtener_payment.findElements(By.tagName("div"));
        for (int i = 0; i < list_payment.size(); i++) {
            if(cadena.compararCadenas(list_payment.get(i).getText(), newClient.getPayment_method())){
            WebElement pay=list_payment.get(i);
                click(pay);
                break;
            } 
        
        }
       }
}