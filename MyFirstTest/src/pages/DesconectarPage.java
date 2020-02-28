/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package pages;

import static Base.BasePage.driver;
import com.google.common.base.CharMatcher;
import java.util.HashMap;
import java.util.List;
import limpieza_recurso.Limpieza_Class;
import limpieza_recurso.Proceso_Desconexion;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;


/**
 *
 * @author ipupo
 */
public class DesconectarPage extends Base.BasePage{
    
    private HashMap<String, String> soCreadas;
    private Proceso_Desconexion proceso_desconexion;

    
    By primerpartelinea= By.xpath("/html/body/div[4]/div[3]/div[1]/form[1]/div[1]/table/tbody/tr[2]/td/table/tbody/tr[2]/td/div/table/tbody/tr/td[2]/table/tbody/tr/td[2]/div/span/input[1]");
    By segundapartelinea= By.xpath("/html/body/div[4]/div[3]/div[1]/form[1]/div[1]/table/tbody/tr[2]/td/table/tbody/tr[2]/td/div/table/tbody/tr/td[2]/table/tbody/tr/td[2]/div/span/input[2]");
    By tercerapartelinea= By.xpath("/html/body/div[4]/div[3]/div[1]/form[1]/div[1]/table/tbody/tr[2]/td/table/tbody/tr[2]/td/div/table/tbody/tr/td[2]/table/tbody/tr/td[2]/div/span/input[3]");
    By botonbusuqeda= By.xpath("/html/body/div[4]/div[3]/div[1]/form[1]/div[2]/div/div");
    By linkcliente= By.xpath("/html/body/div[4]/div[3]/div[1]/form[2]/table/tbody/tr/td/div[1]/table/tbody/tr/td[3]/a");
    By SO= By.linkText("Órdenes de Venta");
    By nuevaSO= By.xpath("/html/body/div[6]/div[3]/div[1]/div[2]/div[1]/div[2]/div/div[1]/div/div/div/div/div[1]/button");
    By canaldistribucion= By.className("refsel_single");
    By combobox= By.className("refsel_table");
    By pruebacanal= By.cssSelector("#id_refsel1613764204_div > div > input");
    By elementoAgente= By.xpath("//*[@id=\"id_refsel1965777193_div\"]/div/input");
    By stringAgente= By.xpath("//*[@id=\"nc_refsel_list\"]/div[2]/div[1]/div[1]/div[1]");
    By recientes = By.xpath("//*[@id=\"gen_menu_3\"]");
    By botonCrear= By.xpath("//html/body/div[30]/div/div/div[2]/div/div[2]/table/tbody/tr[2]/td/div/div[2]/div/div/div/div/div[1]/button");
    By configurar_ContratoBTN = By.xpath("//div[@class='tfn_button_panel' and a[contains(text(),'Configurar contratos')]]");
    CostumerPage page;
    By plan= By.xpath("/html/body/div[3]/div[3]/div[2]/div[1]/div[3]/div[2]/div[2]/div[2]/div/div/div/div[1]/div/div/div/div/div/div[1]/div/div/div/div[2]");
    
    ///html/body/div[3]/div[3]/div[2]/div[2]/table/tbody/tr/td[2]/div/div/div[2]/div/div/table/tbody/tr/td[2]/div/a[5]
    By botonnextaddpp=By.cssSelector("body > div.wizard_layout.header_visible > div.top_line_2 > div.breadcrumbs > div.prev_next_box > div:nth-child(2)");
    By comentario= By.xpath("//textarea[@class=\"reason_description\"]");
    By aceptardesconexion=By.xpath("//button[@class=\"ok-button ui-button ui-widget ui-state-default ui-corner-all ui-button-text-only\" and span[contains(text(),'Desconectar')]]");
    By boton_informacion_deudanopagada = By.xpath("/html/body/div[8]/div/div/div[3]/div/button[1]");
    By nombre_orden_venta= By.xpath("//div[@class='roe-widget-header' and h1[contains(text(),'Desconectar Servicios SO')]]");
    By body_nombre_orden=By.xpath("/html/body/div[6]/div[3]/div[1]/div[2]/div[1]/div[2]/div/table/tbody[1]");
    By desconectar= By.xpath("//a[@class=\"bt_bt\" and contains(text(),\"Desconectar\")]");
    By deshabilitado_desconectar= By.xpath("//a[@class=\"bt_bt disabled\" and contains(text(),\"Desconectar\")]");
    By filtro_SO_nombre = By.xpath("//*[@id=\"9139371752413211533_-1\"]/span[2]");
    By filtro_input_Nombre = By.xpath("//input[@type=\"text\" and @class=\"gwt-TextBox nc-field-text-input\"]");
    By aplicar_Filtro_Nombre = By.xpath("//button[@class=\"TableCtrl-button gwt-ParCtrl-btn\" and contains(text(),'Aplicar')]");
   
    public  By get_sim=By.xpath("/html/body/div[4]/div[3]/div[1]/form[2]/table/tbody/tr/td/div[1]/table/tbody/tr/td[5]/a/span");
  
    By get_linea= By.xpath("/html/body/div[4]/div[3]/div[1]/form[2]/table/tbody/tr/td/div[1]/table/tbody/tr/td[2]/a");
    By get_editar= By.xpath("//a[contains(text(),\"Editar\")]");
    By select_estado= By.xpath("//td[@id=\"vv_5051946481013506925\"]");
    By select_estado_disponible= By.xpath("//option[contains(text(),\"Disponible\")]");
    By select_estado_sim= By.xpath("//td[@id=\"vv_9141687230013679726\"]");
    By get_actualizar= By.xpath("//a[contains(text(),\"Actualizar\")]");
    By get_estado_sim= By.xpath("//a[contains(text(),\"Tarjeta SIM:\")]");
    By estado_so= By.xpath("/html/body/div[6]/div[3]/div[1]/div[2]/div[1]/div[2]/div/form/table/tbody/tr/td/table/tbody/tr[2]/td[2]/div/table/tbody/tr/td/div/div/div");
    By estado_logico_linea_usado= By.xpath("/html/body/div[4]/div[3]/div[1]/form[2]/table/tbody/tr/td/div[1]/table/tbody/tr/td[4]");
    By tabla_añadido= By.xpath("//b[contains(text(),'Añadido:')]");
    
    public DesconectarPage(Proceso_Desconexion pd)
    {
        page= new CostumerPage();
        soCreadas = new HashMap<>();
        proceso_desconexion= pd;
        
    }
    
    public void initUrlBusqueda(String env){
        System.out.println(env);
        if (!env.equals("preprod")) {
            visit("https://noprd-"+env+"-toms.temu.com.uy:7002/common/search.jsp?explorer_mode=disable&object=9141907040613227268&o=9155890323313723269");
            
        } else
        {
             visit("https://pretoms.temu.com.uy/common/search.jsp?explorer_mode=disable&object=9141907040613227268&o=9155890323313723269");
        }
        
    }
    public void buscarLinea(String linea){
        sendKeys(linea.substring(0, 2), primerpartelinea);
        sendKeys(linea.substring(2, 5), segundapartelinea);
        sendKeys(linea.substring(5, 8), tercerapartelinea);
        click(botonbusuqeda);   
      //  getDatosDesconexion().get(linea).setSim(sim.getText());
    }
    public void Desconectar(String linea) throws InterruptedException{
        WebElement fact_pago2=page.obtener_BotonMenu("Facturación y pago");
        //WebElement esta_desco_boton = findElement(deshabilitado_desconectar);
        Wait(linkcliente);
        click(linkcliente);
        Wait(SO);
        click(SO);
        Wait(nuevaSO);
        click(nuevaSO);
        Wait(canaldistribucion);
        Thread.sleep(4000);
        click(canaldistribucion);
        Thread.sleep(4000);
        Wait_element(page.seleccionar_CanalX());
        Thread.sleep(3000);
        click(page.seleccionar_CanalX());
        Wait(botonCrear);
        click(botonCrear);
        page.loading();
        
        //Wait_element(obtener_linea(linea));
        Thread.sleep(4000);
        if(obtener_linea(linea) == null)
        {
         getDatosDesconexion().get(linea).setStatus("Multilinea");
        }
        else{
        Thread.sleep(4000);
        click(obtener_linea(linea));
        if(esta_BotonDesconectar()){
            getDatosDesconexion().get(linea).setStatus("Error de linea");
            
        } else
        {
            page.loading();
            Wait(desconectar);
            Thread.sleep(4000);
            click(desconectar);
            
            Wait(comentario);
            Thread.sleep(4000);
            sendKeys("Desconexión Automatizada", comentario);
            Wait(aceptardesconexion);
            click(aceptardesconexion);
            
            Thread.sleep(4000);
            Wait_element(page.obtener_BotonMenu("Revisión"));
            Thread.sleep(6000);
            click(page.obtener_BotonMenu("Revisión"));
            if(existe_Añadido(linea)){
                getDatosDesconexion().get(linea).setStatus("Linea añadida por error de SO");
            }
            else{
            if (page.esta_configurar_Contrato()) {
                click(configurar_ContratoBTN);
                Thread.sleep(3000);
                page.confirmarContrato();
                Wait(page.generar_contrato);
                Thread.sleep(5000);
                click(page.generar_contrato);
                page.loading();
                Wait(page.firmar_contrato);
                Thread.sleep(8000);
                click(page.firmar_contrato);
                Thread.sleep(8000);
                Wait(page.boton_confirmar_firma);
                Thread.sleep(4000);
                click(page.boton_confirmar_firma);
            }
                
                Wait_element(page.obtener_botonenviar());
                Thread.sleep(5000);
                click(page.obtener_botonenviar());
                Thread.sleep(3000);
                
                if(page.validar_Deuda()){
                    
                    System.out.println("HAY VALIDAR");
                    Thread.sleep(5000);
                    Wait(page.boton_cerrarSO);
                    String so = obtener_nombre_SO();
                    System.out.println(obtener_nombre_SO());
                    Thread.sleep(4000);
                    click(page.boton_cerrarSO);
                    obtener_SO(so);
                    
                } else {
                    System.out.println("NO HAY VALIDAR");
                    Thread.sleep(5000);
                    Wait(page.boton_cerrarSO);
                    String so = obtener_nombre_SO();
                    System.out.println(obtener_nombre_SO());
                    click(page.boton_cerrarSO);
                    obtener_SO(so);
                    
                }
                System.out.println(obtener_urlSO());
                getDatosDesconexion().get(linea).setSO(obtener_urlSO());
                getDatosDesconexion().get(linea).setStatus("Desconexion");
            }
        }
    }
  }     
    
    public HashMap<String,Limpieza_Class> getDatosDesconexion()
    {
        return proceso_desconexion.getDatosLimpieza();
    }
    
    public WebElement obtener_linea(String linea) throws InterruptedException{
        WebElement ppactivo = null;
        Wait(page.productosasociados);
        Thread.sleep(3000);
        System.out.println("prod asociados "+page.productosasociados);
        String conEspacios =linea.substring(0, 2)+" "+ linea.substring(2, 5)+" "+linea.substring(5, 8);
        WebElement tableproductasociados= findElement(page.productosasociados);
        List<WebElement> planes= tableproductasociados.findElements(By.tagName("span"));
        
        for (int i = 0; i < planes.size(); i++) {
            
            if(getText(planes.get(i)).contains(conEspacios)){
                try {
                    ppactivo=planes.get(i);
                    return ppactivo;
                } catch (TimeoutException e) {
                    System.out.println("ERROR "+ e.toString());
                    return null;
                }
            }
            
        }
        return ppactivo;
    }
    
    public String obtener_nombre_SO(){
        WebElement nombre_so = findElement(nombre_orden_venta);
        String nombre_orden= getText(nombre_so);
        return nombre_orden.substring(0, 36);
    }
    
    public void obtener_SO(String orden) throws InterruptedException{
        WebElement so=null;
        
        
        Wait(filtro_SO_nombre);
        click(filtro_SO_nombre);
        Thread.sleep(4000);
        findElement(filtro_input_Nombre).clear();
        sendKeys(orden,filtro_input_Nombre);
        click(aplicar_Filtro_Nombre);
        Thread.sleep(4000);
        Wait(body_nombre_orden);
        WebElement SO= findElement(body_nombre_orden);
        List<WebElement>lista_SO= SO.findElements(By.tagName("a"));
     
        for (int i = 0; i < lista_SO.size(); i++) {
            if(getText(lista_SO.get(i)).contains(orden))//En dependencia de los permisos del usuario podra acceder a diferentes canal de distribucion
                so=lista_SO.get(i);
        }
        Thread.sleep(4000);
        System.out.println(so);
        click(so);
    }
    public String obtener_urlSO(){
        String url =driver.getCurrentUrl();
        return url;
    }
     public HashMap<String, String> getSoCreadas() {
        return soCreadas;
    }
     public boolean esta_BotonDesconectar(){
         WebElement esta_desco_boton = null;
         try{
             Wait(deshabilitado_desconectar);
             esta_desco_boton = findElement(deshabilitado_desconectar);
             if (esta_desco_boton != null) {
                 System.out.println("botondesconectar");
                 return true;
             }
             
         }catch (NoSuchElementException e)
         {
             System.out.println(e);
         } catch (TimeoutException e)
         {
             System.out.println(e + "ERROR DE TIMEOUT ");
         }
         return false;
     }
     /* public boolean verificar_EstadoSO(){
      
      
      }*/
      public Boolean get_estadoSOProcesado(String linea){
          
          String urlso=getDatosDesconexion().get(linea).getSO();
          visit(urlso);
          boolean so=false;
          Wait(estado_so);
          WebElement sos=findElement(estado_so);
          List<WebElement>div_SO= sos.findElements(By.tagName("span"));
          for (int i = 0; i < div_SO.size(); i++) {
              so = getText(div_SO.get(i)).contains("Procesado"); //En dependencia de los permisos del usuario podra acceder a diferentes canal de distribucion
          }
          
          return so;
      }
      public void cambio_estado(String linea) throws InterruptedException{
        sendKeys(linea.substring(0, 2), primerpartelinea);
        sendKeys(linea.substring(2, 5), segundapartelinea);
        sendKeys(linea.substring(5, 8), tercerapartelinea);
        click(botonbusuqeda);
        Wait(get_linea);
        Thread.sleep(4000);
        click(get_linea);
        Wait(get_editar);
        Thread.sleep(4000);
        click(get_editar);
        Wait(select_estado);
        Thread.sleep(4000);
        click(select_estado);
        click(select_estado_disponible);
        click(get_actualizar);
        click(get_estado_sim);
        Wait(get_editar);
        Thread.sleep(4000);
        click(get_editar);
        click(select_estado_sim);
        click(select_estado_disponible);
        click(get_actualizar);     
      }
      public boolean obtener_estado_logicoLinea(){
      
          try {
              Wait(estado_logico_linea_usado);
              WebElement estado_logico= findElement(estado_logico_linea_usado);
              if(estado_logico.getText().contains("En uso")){
              return true;
              }
                  
          } catch (NoSuchElementException e) {
              System.out.println(e);
          }
          catch(TimeoutException y){
               System.out.println(y);
          }
          return false;
      }
      public boolean obtener_sim(){
      
          try {
              Wait(get_sim);
              WebElement sim= findElement(get_sim);
              if(sim.getText().contains("")){
              return true;
              }
                  
          } catch (NoSuchElementException e) {
              System.out.println(e);
          }
          catch(TimeoutException y){
               System.out.println(y);
          }
          return false;
      }
      public void set_SIM(String linea){
          if(obtener_sim() == true){
              WebElement sim= page.findElement(get_sim);
              getDatosDesconexion().get(linea).setSim(sim.getText());
          }
      }
      public String obtener_nombreCliente(){
          
          WebElement nombre= findElement(linkcliente);
          return nombre.getText();
      }
      public boolean existe_Añadido(String linea){
          
          try{
              Wait(tabla_añadido);
              WebElement tabala_añadido= findElement(tabla_añadido);
              if(tabla_añadido!= null){
                  return true;
              }
          } catch (Exception e)
          {
              System.out.println("ERROR" + e);
              return false;
          }
          
          return false;
      }
}
