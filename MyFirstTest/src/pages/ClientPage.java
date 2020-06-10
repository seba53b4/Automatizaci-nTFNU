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
     By RUT = By.xpath("/html/body/div[33]/div/div/div[2]/div/div[2]/table/tbody/tr/td/div/form/table/tbody/tr/td/table/tbody/tr[3]/td[2]/div/table/tbody/tr/td/input");
     By apellidoR=By.xpath("//input[@class='gwt-TextBox nc-field-text-input']//following::input[1]");
   
     By categoria_cliente=By.xpath("//i[@class=\"refsel_arrow\"][1]");
     By categoria_CE=By.xpath("//i[@class=\"refsel_arrow\"][1]");
     By table_categoria_empresarial=By.xpath("/html/body/div[34]/div[2]/div[1]/div[2]");
     By list_cc= By.xpath("/html/body/div[34]/div[2]/div[1]");   //"/html/body/div[34]");
     By obtener_CR = By.xpath("//div[@class=\"refsel_name\" and contains(text(),'Particulares') and contains(text(),'Valor')] [1]");
     
     
     By obtener_pasaporte=By.xpath("/html/body/div[34]/div[2]/div[1]/div[1]");
     By numero_pasaporte= By.xpath("/html/body/div[35]/div/div/div[2]/div/div[2]/table/tbody/tr/td/div/form/table/tbody/tr/td/table/tbody/tr[7]/td[2]/div/table/tbody/tr/td/input");
     By escribir_direccion_CR=By.xpath("/html/body/div[35]/div/div/div[2]/div/div[2]/table/tbody/tr/td/div/form/table/tbody/tr/td/table/tbody/tr[9]/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/div/div/input");
     By desplegar_direccion=By.xpath("/html/body/div[35]/div/div/div[2]/div/div[2]/table/tbody/tr/td/div/form/table/tbody/tr/td/table/tbody/tr[9]/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/div/div/i");
     By contacto_primario=By.xpath("/html/body/div[33]/div/div/div[2]/div/div[2]/table/tbody/tr/td/div/form/table/tbody/tr/td/table/tbody/tr[7]/td[2]/div/table/tbody/tr/td/table/tbody/tr/td[1]/div/div");
     ///html/body/div[33]/div/div/div[2]/div/div[2]/table/tbody/tr/td/div/form/table/tbody/tr/td/table/tbody/tr[7]/td[2]/div/table/tbody/tr/td/table/tbody/tr/td[1]/div/div
     By table_contacto_primario= By.xpath("/html/body/div[34]/div[2]/div[1]/div[3]");
     By rol_contacto_primario= By.xpath("/html/body/div[33]/div/div/div[2]/div/div[2]/table/tbody/tr/td/div/form/table/tbody/tr/td/table/tbody/tr[8]/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/div/div");
     By obtener_rol_contacto_primario= By.xpath("//div[contains(text(),'Firmante')]");
     By numero_doc= By.xpath("//tr[@class='gwt-row']//following::input[9]");
     By direccion_cliente= By.xpath("//tr[@class='gwt-row']//following::input[15]");
     By direccion_CE= By.xpath("/html/body/div[33]/div/div/div[2]/div/div[2]/table/tbody/tr/td/div/form/table/tbody/tr/td/table/tbody/tr[5]/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/div/div/input");
     By obtener_direccion_CE= By.xpath("/html/body/div[34]/div[2]/div[1]/div[1]");
     By obtener_direccion= By.xpath("//div[@class=\"refsel_table\"]//following::div[2]");
     By boton_crear=By.xpath("//button[contains(text(),'Crear y consultar los detalles')]");
     By popup_cliente_existente = By.xpath("/html/body/div[33]/div/div[2]");
     By seleccionar_tipo_doc= By.xpath("//i[@class=\"refsel_arrow\"]//following::i[1]");
     By table_DNI=By.xpath("//div[@class=\"refsel_table_holder ps-container ps-theme-default\"]");
     
     
     
     
     
    public void initUrlBusqueda(String env){
        if (env.toLowerCase() != "preprod") {
            visit("https://noprd-"+env+"-toms.temu.com.uy:7002/ncobject.jsp?id=9155890523813779409&tab=_All+Tasks");
            
        } else
        {
             visit("https://pretoms.temu.com.uy/common/search.jsp?explorer_mode=disable&object=9141907040613227268&o=9155890323313723269");
        }
        
    }
    
    public Client crear_Cliente_Residencial(Client newClient) throws InterruptedException , Exception{
        return crear_Cliente_Residencial(newClient, false);
    }
    public Client crear_Cliente_Residencial(Client newClient, boolean handleDuplicate) throws InterruptedException, Exception
    { 
        Actions action=new Actions(driver);     
        WebElement cliente_resi=findElement(creacion_rapida);
        action.moveToElement(cliente_resi).build().perform(); 
        Wait(opcion_ClienteRe);
        Thread.sleep(5000);
        click(opcion_ClienteRe);
        Thread.sleep(2000);
        Wait(nombreE);
        sendKeys(newClient.getName(), nombreE);
        Wait(apellidoR);
        sendKeys(newClient.getSecondName(), apellidoR);
        Thread.sleep(2000);
        click(categoria_cliente);
        obtener_CR(newClient);
        Wait(seleccionar_tipo_doc);
        click(seleccionar_tipo_doc);
        obtener_TipoDoc(newClient);
        Wait(direccion_cliente);
        sendKeys(newClient.getAddress(), direccion_cliente);
        Thread.sleep(4000);
        Wait(obtener_direccion);
        Thread.sleep(2000);
        click(obtener_direccion);
        Wait(boton_crear);
        Thread.sleep(2000);
        click(boton_crear);
        Thread.sleep(5000);
        // 1- existe el cliente (se muestra popup POSIBLES DUPLICADOS)
        // entonces ejecuto el flujo correspondiente a Cliente Duplicado
        List<WebElement> existentElements = findElements(popup_cliente_existente);
        Thread.sleep(2000);
        if (existentElements.size() > 0) {
            
            if(handleDuplicate) {
                System.out.println("Duplicated Client");
                //ejecuto el flujo para duplicados
                throw new Exception("Duplicated Client");
            }
        }
        // 2- si no existe, entonces obtengo el ClientId del cliente y actualizo
        // objeto Cliente
        else {
            Thread.sleep(10000);
           
            String clientId = getClientIdByUrl(driver.getCurrentUrl());
            newClient.setClientId(clientId);
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
    WebElement cliente_resi=findElement(creacion_rapida);
    action.moveToElement(cliente_resi).build().perform();
    Thread.sleep(2000);
    Wait(opcion_ClienteEm);
    click(opcion_ClienteEm);
    Thread.sleep(2000);
    sendKeys(newClient.getName(), nombreE);
    sendKeys(newClient.getRut(), RUT);
    Thread.sleep(2000);
    click(categoria_CE);
    obtener_Categoria_Em();
    Thread.sleep(3000);
    click(obtener_Categoria_Em());
    sendKeys(newClient.getAddress(), direccion_CE);
    Thread.sleep(2000);
    Wait(obtener_direccion_CE);
    click(obtener_direccion_CE);
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
            Thread.sleep(10000);
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
    
    public void obtener_TipoDoc(Client newClient){
    WebElement td=null;  
    Wait(table_DNI);
    WebElement obtener_td= findElement(table_DNI);
    List<WebElement> list_obtenertd= obtener_td.findElements(By.tagName("div"));
    for (int i = 0; i < list_obtenertd.size(); i++) {
           if(!newClient.getPassport().equals("null"))
            if(getText(list_obtenertd.get(i)).equals("International Passport (Pasaporte Internacional)")){
            td=list_obtenertd.get(i);
             click(td);
             Wait(numero_doc);
             sendKeys(newClient.getPassport(), numero_doc);
            } 
            if(!(newClient.getInternational_id().equals("null")) && getText(list_obtenertd.get(i)).equals("National ID (Documento de identidad)")) {
            td=list_obtenertd.get(i);
            click(td);
            Wait(numero_doc);
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
