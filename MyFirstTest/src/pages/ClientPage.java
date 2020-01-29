/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pages;

import java.awt.Desktop;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

/**
 *
 * @author sdominguez
 */
public class ClientPage extends Base.BasePage{
     By creacion_rapida= By.xpath("/html/body/div[3]/ul/li[5]");
     By opcion_ClienteRe= By.xpath("/html/body/div[3]/ul/li[5]/ul/li[3]");
  
     By opcion_ClienteEm= By.xpath("/html/body/div[3]/ul/li[5]/ul/li[4]");
     By nombR= By.xpath("/html/body/div[33]/div/div/div[2]/div/div[2]/table/tbody/tr/td/div/form/table/tbody/tr/td/table/tbody/tr[3]/td[2]/div/table/tbody/tr/td/input");
     By nombreE=By.xpath("/html/body/div[33]/div/div/div[2]/div/div[2]/table/tbody/tr/td/div/form/table/tbody/tr/td/table/tbody/tr[2]/td[2]/div/table/tbody/tr/td/input");
     By RUT = By.xpath("/html/body/div[33]/div/div/div[2]/div/div[2]/table/tbody/tr/td/div/form/table/tbody/tr/td/table/tbody/tr[3]/td[2]/div/table/tbody/tr/td/input");
     By apellidoR=By.xpath("/html/body/div[33]/div/div/div[2]/div/div[2]/table/tbody/tr/td/div/form/table/tbody/tr/td/table/tbody/tr[4]/td[2]/div/table/tbody/tr/td/input");
   
     By categoria_cliente=By.xpath("/html/body/div[33]/div/div/div[2]/div/div[2]/table/tbody/tr/td/div/form/table/tbody/tr/td/table/tbody/tr[5]/td[2]/div");
     By categoria_CE=By.xpath("/html/body/div[33]/div/div/div[2]/div/div[2]/table/tbody/tr/td/div/form/table/tbody/tr/td/table/tbody/tr[4]/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/div/div");
     By table_categoria_empresarial=By.xpath("/html/body/div[34]/div[2]/div[1]/div[2]");
     By list_cc= By.xpath("/html/body/div[34]");
    
     By obtener_tipoDoc= By.xpath("/html/body/div[33]/div/div/div[2]/div/div[2]/table/tbody/tr/td/div/form/table/tbody/tr/td/table/tbody/tr[6]/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/div/div/i");
   
     By list_td=By.xpath("/html/body/div[34]/div[2]/div[1]");
     
     By obtener_pasaporte=By.xpath("/html/body/div[34]/div[2]/div[1]/div[1]");
     By numero_pasaporte= By.xpath("/html/body/div[35]/div/div/div[2]/div/div[2]/table/tbody/tr/td/div/form/table/tbody/tr/td/table/tbody/tr[7]/td[2]/div/table/tbody/tr/td/input");
     By escribir_direccion_CR=By.xpath("/html/body/div[35]/div/div/div[2]/div/div[2]/table/tbody/tr/td/div/form/table/tbody/tr/td/table/tbody/tr[9]/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/div/div/input");
     By desplegar_direccion=By.xpath("/html/body/div[35]/div/div/div[2]/div/div[2]/table/tbody/tr/td/div/form/table/tbody/tr/td/table/tbody/tr[9]/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/div/div/i");
     By contacto_primario=By.xpath("/html/body/div[33]/div/div/div[2]/div/div[2]/table/tbody/tr/td/div/form/table/tbody/tr/td/table/tbody/tr[7]/td[2]/div/table/tbody/tr/td/table/tbody/tr/td[1]/div/div");
     ///html/body/div[33]/div/div/div[2]/div/div[2]/table/tbody/tr/td/div/form/table/tbody/tr/td/table/tbody/tr[7]/td[2]/div/table/tbody/tr/td/table/tbody/tr/td[1]/div/div
     By table_contacto_primario= By.xpath("/html/body/div[34]/div[2]/div[1]/div[3]");
     By rol_contacto_primario= By.xpath("/html/body/div[33]/div/div/div[2]/div/div[2]/table/tbody/tr/td/div/form/table/tbody/tr/td/table/tbody/tr[8]/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/div/div");
     By obtener_rol_contacto_primario= By.xpath("/html/body/div[34]/div[2]/div[1]/div[1]");
     By numero_doc= By.xpath("/html/body/div[33]/div/div/div[2]/div/div[2]/table/tbody/tr/td/div/form/table/tbody/tr/td/table/tbody/tr[7]/td[2]/div/table/tbody/tr/td/input");
     By direccion_cliente= By.xpath("/html/body/div[33]/div/div/div[2]/div/div[2]/table/tbody/tr/td/div/form/table/tbody/tr/td/table/tbody/tr[9]/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/div/div/input");
     By direccion_CE= By.xpath("/html/body/div[33]/div/div/div[2]/div/div[2]/table/tbody/tr/td/div/form/table/tbody/tr/td/table/tbody/tr[5]/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/div/div/input");
     By obtener_direccion_CE= By.xpath("/html/body/div[34]/div[2]/div[1]/div[1]");
     By obtener_direccion= By.xpath("/html/body/div[34]/div[2]/div[1]/div[1]");
     By boton_crear=By.xpath("/html/body/div[33]/div/div/div[2]/div/div[3]/div/div/div/div/div[1]/button");
     public void crear_Cliente_Residencial() throws InterruptedException{
    
    Actions action=new Actions(driver);     
    WebElement cliente_resi=findElement(creacion_rapida);
    action.moveToElement(cliente_resi).build().perform();
    Thread.sleep(2000); 
    click(opcion_ClienteRe);
    Thread.sleep(2000);
    sendKeys("Nativo", nombR);
    sendKeys("Test_3", apellidoR);
    Thread.sleep(2000);
    click(categoria_cliente);
    obtener_CR();
    sendKeys("k16500232301", numero_doc);
    sendKeys("18 de julio", direccion_cliente);
    Thread.sleep(4000);
    Wait(obtener_direccion);
    Thread.sleep(2000);
    click(obtener_direccion);
    Wait(boton_crear);
    Thread.sleep(2000);
    click(boton_crear);
    Thread.sleep(4000);
    
    }
      public void crear_Cliente_Empresarial() throws InterruptedException{
    
    Actions action=new Actions(driver);     
    WebElement cliente_resi=findElement(creacion_rapida);
    action.moveToElement(cliente_resi).build().perform();
    Thread.sleep(2000);
    Wait(opcion_ClienteEm);
    click(opcion_ClienteEm);
    Thread.sleep(2000);
    sendKeys("Nativo", nombreE);
    sendKeys("213975190053", RUT);
    Thread.sleep(2000);
    click(categoria_CE);
    Wait_element(obtener_Categoria_Em());
    Thread.sleep(3000);
    click(obtener_Categoria_Em());
    sendKeys("18 de julio", direccion_CE);
    Thread.sleep(4000);
    click(obtener_direccion_CE);
    Wait(contacto_primario);
    Thread.sleep(4000);
    click(contacto_primario);
    Thread.sleep(4000);
    Wait_element(obtener_ContactoPrimario());
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
    
    }
     
    public void obtener_CR() throws InterruptedException {//metodo utilizado
     
     
     click(categoria_cliente);
     Thread.sleep(2000);
     click(obtener_Categoria());
     Thread.sleep(2000);
     click(obtener_tipoDoc);
     Thread.sleep(2000);
     click(obtener_TipoDoc());
   
    
    
    }
    public WebElement obtener_Categoria(){//metodo utilizado
    WebElement cc=null;   
    WebElement obtener_cc= findElement(list_cc);
    List<WebElement> list_obtenercc= obtener_cc.findElements(By.tagName("div"));
    for (int i = 0; i < list_obtenercc.size(); i++) {
            if(getText(list_obtenercc.get(i)).equals("Particulares - Valor"))//En dependencia de los permisos del usuario podra acceder a diferentes canal de distribucion
                cc=list_obtenercc.get(i);
        
        }
 return cc;
    }
       public WebElement obtener_Categoria_Em(){//metodo utilizado
    WebElement cc=null;  
    Wait(table_categoria_empresarial);
    WebElement obtener_cc= findElement(table_categoria_empresarial);
    List<WebElement> list_obtenercc= obtener_cc.findElements(By.tagName("div"));
    for (int i = 0; i < list_obtenercc.size(); i++) {
            if(getText(list_obtenercc.get(i)).contains("Empresas - Pymes A"))//En dependencia de los permisos del usuario podra acceder a diferentes canal de distribucion
                cc=list_obtenercc.get(i);
        
        }
 return cc;
    }
    
   public WebElement obtener_TipoDoc(){
    WebElement td=null;   
    WebElement obtener_td= findElement(list_td);
    List<WebElement> list_obtenertd= obtener_td.findElements(By.tagName("div"));
    for (int i = 0; i < list_obtenertd.size(); i++) {
            if(getText(list_obtenertd.get(i)).equals("International Passport (Pasaporte Internacional)"))//En dependencia de los permisos del usuario podra acceder a diferentes canal de distribucion
                td=list_obtenertd.get(i);
        
        }
 return td;
    } 
    public WebElement obtener_ContactoPrimario(){
    WebElement cp=null;
   Wait(table_contacto_primario);
    WebElement obtener_cp= findElement(table_contacto_primario);
    List<WebElement> list_obtenertd= obtener_cp.findElements(By.tagName("div"));
    for (int i = 0; i < list_obtenertd.size(); i++) {
            if(getText(list_obtenertd.get(i)).contains("IVANNA TROVATTO"))//En dependencia de los permisos del usuario podra acceder a diferentes canal de distribucion
                cp=list_obtenertd.get(i);
        
        }
 return cp;

}
}
