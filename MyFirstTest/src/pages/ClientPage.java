/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pages;

import Utils.Client;
import Utils.EnterpriseClient;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

/**
 *
 * @author sdominguez
 */
public class ClientPage extends Base.BasePage{
    
     By creacion_rapida= By.xpath("//a[contains(text(),'Creación rápida')]");
     By opcion_ClienteRe= By.xpath("//span[contains(text(),\"Cliente residencial\")]");
     By opcion_ClienteEm= By.xpath("//span[contains(text(),'Cliente empresial')]");
     By nombreE=By.xpath("//input[@class='gwt-TextBox nc-field-text-input'][1]");
     By RUT = By.xpath("//td[div[contains(text(),\"R.U.T\")]]/following-sibling::td/descendant::input");
     By apellidoR=By.xpath("//input[@class='gwt-TextBox nc-field-text-input']//following::input[1]");
     By categoria_cliente=By.xpath("//td[div[contains(text(),\"Categoría de cliente\")]]/following-sibling::td");
     //By categoria_CE=By.xpath("//i[@class=\"refsel_arrow\"][1]");
     By table_categoria_empresarial=By.xpath("//div[@class=\"ui-widget-overlay-under-wrapper\"]/following-sibling::div");
     By list_cc= By.xpath("/html/body/div[34]/div[2]/div[1]");   //"/html/body/div[34]");
     By obtener_CR = By.xpath("//div[@class=\"refsel_name\" and contains(text(),'Particulares') and contains(text(),'Valor')] [1]");
     By obtener_pasaporte=By.xpath("/html/body/div[34]/div[2]/div[1]/div[1]");
     By numero_pasaporte= By.xpath("/html/body/div[35]/div/div/div[2]/div/div[2]/table/tbody/tr/td/div/form/table/tbody/tr/td/table/tbody/tr[7]/td[2]/div/table/tbody/tr/td/input");
     By escribir_direccion_CR=By.xpath("/html/body/div[35]/div/div/div[2]/div/div[2]/table/tbody/tr/td/div/form/table/tbody/tr/td/table/tbody/tr[9]/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/div/div/input");
     By desplegar_direccion=By.xpath("/html/body/div[35]/div/div/div[2]/div/div[2]/table/tbody/tr/td/div/form/table/tbody/tr/td/table/tbody/tr[9]/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/div/div/i");
     By contacto_primario=By.xpath("//td[div[contains(text(),\"Contacto primario\")]]/following-sibling::td/descendant::i");
     By table_contacto_primario= By.xpath("/html/body/div[34]/div[2]/div[1]/div[3]");
     By rol_contacto_primario= By.xpath("//td[div[contains(text(),\"Rol de contacto primario\")]]/following-sibling::td/descendant::i");
     By obtener_rol_contacto_primario= By.xpath("//div[contains(text(),'Firmante')]");
     By numero_doc= By.xpath("//td[div[contains(text(),\"Número de documento\")]]/following-sibling::td/descendant::input");
     By direccion_cliente= By.xpath("//td[div[contains(text(),\"Dirección de cliente\")]]/following-sibling::td/descendant::input[3]");
     By direccion_CE= By.xpath("//td[div[contains(text(),\"Dirección legal\")]]/following-sibling::td/descendant::input[3]");
     By obtener_direccion_CE= By.xpath("//div[@class=\"refsel_table\"]//following::div[2]");
     By obtener_direccion= By.xpath("//div[@class=\"refsel_table\"]//following::div[2]");
     By boton_crear=By.xpath("//button[contains(text(),'Crear y consultar los detalles')]");
     By popup_cliente_existente = By.xpath("/html/body/div[33]/div/div[2]");
     By seleccionar_tipo_doc= By.xpath("//td[div[contains(text(),\"Tipo de documento\")]]/following::i[1]");
     By table_DNI=By.xpath("//div[@class=\"refsel_table_holder ps-container ps-theme-default\"]");
     
     
     
     public static ClientPage cp;
     
     public static ClientPage getInstance(){
         if (cp == null) {
             cp = new ClientPage();
         }
         return cp;
     }
     
  
    
    public Client crear_Cliente_Residencial(Client newClient) throws InterruptedException , Exception{
        return crear_Cliente_Residencial(newClient, false);
    }
    
    public Client crear_Cliente_Residencial(Client newClient, boolean handleDuplicate) throws InterruptedException, Exception
    {
        Actions action=new Actions(driver);
        Wait(creacion_rapida);
      
        WebElement cliente_resi=findElement(creacion_rapida);
        Thread.sleep(2000);
        action.moveToElement(cliente_resi).build().perform();
        Thread.sleep(2000);
        //action.perform();
        
        Wait_Click(opcion_ClienteRe);
        Thread.sleep(2000);
        WebElement opcion_resi = findElement(opcion_ClienteRe);
        
        Thread.sleep(2000);
        action.moveToElement(opcion_resi).build().perform();
        click(opcion_ClienteRe);
        Thread.sleep(2000);
        Wait(nombreE);
        sendKeys(newClient.getName(), nombreE);
        Wait(apellidoR);
        sendKeys(newClient.getSecondName(), apellidoR);
        Thread.sleep(2000);
        Wait_Click(categoria_cliente);
        click(categoria_cliente);
        obtener_CR(newClient);
        Thread.sleep(2000);
        Wait_Click(seleccionar_tipo_doc);
        click(seleccionar_tipo_doc);
        Thread.sleep(800);
        obtener_TipoDoc(newClient);
        Wait(direccion_cliente);
        sendKeys(newClient.getAddress(), direccion_cliente);
        Thread.sleep(2500);
        Wait(obtener_direccion);
        Thread.sleep(2000);
        click(obtener_direccion);
        Wait(boton_crear);
        Thread.sleep(1000);
        click(boton_crear);
        Thread.sleep(3000);
        // 1- existe el cliente (se muestra popup POSIBLES DUPLICADOS)
        // entonces ejecuto el flujo correspondiente a Cliente Duplicado
        List<WebElement> existentElements = findElements(popup_cliente_existente);
        Thread.sleep(2000);
        if (existentElements.size() > 0) {
            
            System.out.println("ENTRO A DUPLICADO");
            if(handleDuplicate) {
                System.out.println("Duplicated Client");
                //ejecuto el flujo para duplicados
                throw new Exception("Duplicated Client");
            }
        }
        // 2- si no existe, entonces obtengo el ClientId del cliente y actualizo
        // objeto Cliente
        else {
            
            Thread.sleep(1000);
            String clientId = getClientIdByUrl(driver.getCurrentUrl());
            newClient.setClientId(clientId);
            System.out.println(newClient.getClientId());
        }
        
        return newClient;
    }
    
    public String getClientIdByUrl(String url){
        String[] urlSplitted = url.split("id=");
        return urlSplitted[1];
    }
    public EnterpriseClient crear_Cliente_Empresarial(EnterpriseClient newClient) throws InterruptedException {
        return crear_Cliente_Empresarial(newClient, false);
    }
    
     public EnterpriseClient crear_Cliente_Empresarial(EnterpriseClient newClient, boolean handleDuplicate) throws InterruptedException{
         
         Actions action=new Actions(driver);
         
         Wait(creacion_rapida);
         
         WebElement cliente_resi=findElement(creacion_rapida);
         Thread.sleep(1000);
         action.moveToElement(cliente_resi).perform();
         Thread.sleep(1000);
         Wait_Click(opcion_ClienteEm);
         click(opcion_ClienteEm);
         Thread.sleep(2000);
         sendKeys(newClient.getName(), nombreE);
         sendKeys(newClient.getRut(), RUT);
         Thread.sleep(2000);
         click(categoria_cliente);
         obtener_Categoria_Em();
         Thread.sleep(3000);
         click(obtener_Categoria_Em());
         Wait(direccion_CE);
         sendKeys(newClient.getAddress(), direccion_CE);
         Thread.sleep(2000);
         Wait(obtener_direccion);
         Thread.sleep(2000);
         click(obtener_direccion);
         Wait(contacto_primario);
         Thread.sleep(4000);
         click(contacto_primario);
         Thread.sleep(4000);
         obtener_ContactoPrimario();
         Thread.sleep(4000);
         click(obtener_ContactoPrimario());
         Thread.sleep(4000);
         Wait(rol_contacto_primario);
         click(rol_contacto_primario);
         Thread.sleep(4000);
         Wait(obtener_rol_contacto_primario);
         click(obtener_rol_contacto_primario);
         
         //click(obtener_direccion_CE);
         
         click(boton_crear);
         // 1- existe el cliente (se muestra popup POSIBLES DUPLICADOS)
         // entonces ejecuto el flujo correspondiente a Cliente Duplicado
         List<WebElement> existentElements = findElements(popup_cliente_existente);
         Thread.sleep(2000);
         if (existentElements.size() > 0) {
             System.out.println("Duplicated Client");
             if(handleDuplicate) {
                 //ejecuto el flujo para duplicados
             }
         }
         // 2- si no existe, entonces obtengo el ClientId del cliente y actualizo
         // objeto Cliente
         else {
             Thread.sleep(8000);
             String clientId = getClientIdByUrl(driver.getCurrentUrl());
             newClient.setClientId(clientId);
         }
         
         return newClient;
     }
    
    public void obtener_CR(Client newClient) throws InterruptedException {//metodo utilizado
     
     
     //Wait_Click(categoria_cliente);
     //click(categoria_cliente);
     Thread.sleep(2000);
     click(obtener_CR);
     Thread.sleep(2000);
    
    }
    public WebElement obtener_Categoria(){//metodo utilizado
    WebElement cc=null;   
    WebElement obtener_cc= findElement(list_cc);
    List<WebElement> list_obtenercc= obtener_cc.findElements(By.tagName("div"));
    for (int i = 0; i < list_obtenercc.size(); i++) {
            if(list_obtenercc.get(i).getText().equals("Particulares - Valor"))//En dependencia de los permisos del usuario podra acceder a diferentes canal de distribucion
                cc=list_obtenercc.get(i);
        
        }
    return cc;
    }
    public WebElement obtener_Categoria_Em(){//metodo utilizado
        WebElement cc=null;
        Wait(table_categoria_empresarial);
        WebElement obtener_cc= findElement(table_categoria_empresarial);
        List<WebElement> list_obtenercc= obtener_cc.findElements(By.className("refsel_name")); //tagName("div"));
        for (int i = 0; i < list_obtenercc.size(); i++) {
            if(getText(list_obtenercc.get(i)).contains("Pymes"))//En dependencia de los permisos del usuario podra acceder a diferentes canal de distribucion
                cc=list_obtenercc.get(i);
            
        }
        return cc;
    }
    
    public void obtener_TipoDoc(Client newClient) throws InterruptedException{
    WebElement td=null;  
    Wait(table_DNI);
    WebElement obtener_td= findElement(table_DNI);
    List<WebElement> list_obtenertd= obtener_td.findElements(By.tagName("div"));
    for (int i = 0; i < list_obtenertd.size(); i++) {
           if(!newClient.getPassport().equals("null"))
            if(getText(list_obtenertd.get(i)).equals("International Passport (Pasaporte Internacional)")){
            td=list_obtenertd.get(i);
             click(td);
             Wait_Click(numero_doc);
             sendKeys(newClient.getPassport(), numero_doc);
            } 
            if(!(newClient.getInternational_id().equals("null")) && getText(list_obtenertd.get(i)).equals("National ID (Documento de identidad)")) {
            td=list_obtenertd.get(i);
            click(td);
            Wait_Click(numero_doc);
            sendKeys(newClient.getInternational_id(), numero_doc);
            }
        }
    } 
    public WebElement obtener_ContactoPrimario(){
    WebElement cp=null;
    By tablacontacto = By.className("refsel_table");
    Wait(tablacontacto);//table_contacto_primario);
    
    WebElement obtener_cp= findElement(tablacontacto);//table_contacto_primario);
    
    List<WebElement> list_obtenertd= obtener_cp.findElements(By.className("refsel_name"));//tagName("div"));
    for (int i = 0; i < list_obtenertd.size(); i++) {
            if(list_obtenertd.get(i).getText().contains("TROVATTO"))//En dependencia de los permisos del usuario podra acceder a diferentes canal de distribucion
                cp=list_obtenertd.get(i);
        
        }
 return cp;

}
   
}
