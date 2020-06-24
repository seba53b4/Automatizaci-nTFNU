package pages;


import static Base.BasePage.driver;
import Utils.CadenaUtils;
import Utils.Client;
import java.util.Date;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import Utils.Utils;

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
    By payment=By.xpath("//tr[@class='gwt-row']//div[contains(text(),'Método de pago')]/following::i[1]");
    By tabla_payment=By.xpath("//*[@class='refsel_table']");
    By boton_crear=By.xpath("//button[contains(text(),'Crear')]");
    By suscripcionesAA = By.xpath("//div[div[div[div[div[div[button[contains(text(),'Nueva recarga')]]]]]]]/following-sibling::table");
    By boton_recargas = By.xpath("//a[contains(text(),'Recargas')]");
    By boton_anadir_recargas = By.xpath("//button[contains(text(),'Nueva recarga')]");
    By nueva_recarga_realizada = By.xpath("//tr[@__gwt_row=\"0\" and @__gwt_subrow=\"0\"]/td/div/div/a[contains(text(),'Aumentar')]/parent::div");
    By status_recarga = By.xpath("//td/div[contains(text(),'Estado')]/following::span[1]");
    
    CadenaUtils cadena;
    
    
      public RechargePage() {
       cadena=new CadenaUtils();
  
    }
      public Client recargaLinea(Client newClient,String env) throws InterruptedException, Exception {
         
          
          boolean ret = realizar_Recarga(newClient);
          cargando();
        /*  Wait(nueva_recarga_realizada);
          String str = getText(nueva_recarga_realizada);
          System.out.println(str);
          */
        if (ret) {
            String url_SO=obtener_urlSO();
            Wait(status_recarga);
            String statusRecarga=getText(status_recarga);
            System.out.println("link-->"+ url_SO);
            System.out.println("status-->"+ statusRecarga);
            newClient.setLink_recharge(url_SO);
            newClient.setStatus_recharge(statusRecarga);
            
          } else {
            newClient.setLink_recharge(newClient.getAmbiente()+" "+ newClient.getLine());
            newClient.setStatus_recharge("NO GENERO RECARGA ");
            throw new Exception("ERROR EN GENERAR RECARGA "+ newClient.getLine());
          }
      
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
       public void scrollUntilElement(WebElement wb){
           JavascriptExecutor js = (JavascriptExecutor) driver;
           js.executeScript("argumentos[0].scrollIntoView();", wb);
       }
       
    
       public boolean realizar_Recarga(Client newClient) throws InterruptedException{
           
           
           Date iniTest = new Date();
           visit("https://noprd-"+newClient.getAmbiente()+"-toms.temu.com.uy:7002/ncobject.jsp?id="+ newClient.getObject_id());
           Wait_Click(billaccount);
           click(billaccount);
           getAltamiraUrl(newClient.getLine());
           Wait_Click(boton_recargas);
           click(boton_recargas);
           cargando();
           // Scroll up 
           Actions clicker = new Actions(driver);
           clicker.sendKeys(Keys.PAGE_UP);
           Thread.sleep(4000);
           clicker.perform(); 
           Thread.sleep(1000);
           Wait_Click(boton_anadir_recargas);
           click(boton_anadir_recargas);
           
            //obtener_Line(newClient);
           Thread.sleep(2000);
           cargando();
           Wait(importe);
           System.out.println("importe-->"+newClient.getAmount());
           sendKeys(newClient.getAmount(), importe);
           Thread.sleep(2000);
           Wait_Click(payment);
           click(payment);
           Thread.sleep(2000);
           obtener_Payment(newClient);
           Wait_Click(boton_crear);
           click(boton_crear);
           cargando();
           Wait_Click(nueva_recarga_realizada);     
           String str = getText(nueva_recarga_realizada);
           Date recargaDate = Utils.getInstance().toDate(str);
           click(nueva_recarga_realizada);
           return iniTest.before(recargaDate);

       }
       
       public void getAltamiraUrl(String num) throws InterruptedException{
           
       Wait(suscripcionesAA);
       WebElement elem = findElement(suscripcionesAA);
       
       List<WebElement> list_linea = elem.findElements(By.tagName("a"));
       
       
           System.out.println("Esto es vacio ??: " + list_linea.isEmpty() +" "+ list_linea );
        for (int i = 0; i < list_linea.size(); i++) {
            System.out.println("element lista-->"+list_linea.get(i).getText());
            System.out.println("linea-->"+cadena.formatoNumber(num));
            if(cadena.compararCadenas(cadena.formatoNumber(num),list_linea.get(i).getText())){
            WebElement line=list_linea.get(i);
                click(line);
                break;
            }         
        }   
           
           
       }
       
       public void obtener_Line(Client newClient) throws InterruptedException{
       //WebElement line=null;
       Wait(tabla);
       WebElement obtener_line= findElement(tabla);
       List<WebElement> list_linea= obtener_line.findElements(By.tagName("div"));
        for (int i = 0; i < list_linea.size(); i++) {
            System.out.println("element lista-->"+list_linea.get(i).getText());
            System.out.println("linea-->"+newClient.getLine());
            if(cadena.compararCadenas(cadena.formatoNumber(newClient.getLine()),list_linea.get(i).getText())){
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
            System.out.println("element lista-->"+list_payment.get(i).getText());
            System.out.println("linea-->"+newClient.getPayment_method());
            if(cadena.compararCadenas(newClient.getPayment_method(),list_payment.get(i).getText() )){
            WebElement pay=list_payment.get(i);
                click(pay);
                break;
            } 
        
        }
       }
       
       public void cargando() throws InterruptedException
       {
           
           WebElement progress = null;
           for (int i = 1; i < 11; i++) {
               try{///html/body/div[7]/div /html/body/div[7]
                   progress = findElement(By.xpath("//div[@class=\"nc-loading-overlay\"]"));///html/body/div["+i+"`]/div"));
                   Wait_element_progress(progress);
                   System.out.println(progress);
                   while (progress != null && progress.isDisplayed()){
                       //System.out.println("estado progreso en loading: "+progress.isEnabled());
                       //System.out.println("estado progreso displeied en loading: "+progress.isDisplayed());
                       Thread.sleep(2000);
                       Wait_element_progress(progress);
                   }
               } catch (StaleElementReferenceException e)
               {
                   System.out.println("Error en StaleElementReferenceException en ejecucion de CARGANDO");
                   //System.out.println(e);
               }catch (NoSuchElementException e)
               {
                   System.out.println("Error en NoSuchElementException  en ejecucion de CARGANDO");
               }
           }
       }  
}