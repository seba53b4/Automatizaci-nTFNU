/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package pages;

import static Base.BasePage.driver;
import java.util.HashMap;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

/**
 *
 * @author ipupo
 */
public class DesconectarPage extends Base.BasePage{
    
    private HashMap<String, String> soCreadas;

   
    
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
    By desconectar= By.xpath("/html/body/div[3]/div[3]/div[2]/div[2]/table/tbody/tr/td[2]/div/div/div[2]/div/div/table/tbody/tr/td[2]/div/a[5]");
    ///html/body/div[3]/div[3]/div[2]/div[2]/table/tbody/tr/td[2]/div/div/div[2]/div/div/table/tbody/tr/td[2]/div/a[5]
    By botonnextaddpp=By.cssSelector("body > div.wizard_layout.header_visible > div.top_line_2 > div.breadcrumbs > div.prev_next_box > div:nth-child(2)");
    By comentario= By.xpath("//textarea[@class=\"reason_description\"]");
    By aceptardesconexion=By.xpath("//button[@class=\"ok-button ui-button ui-widget ui-state-default ui-corner-all ui-button-text-only\" and span[contains(text(),'Desconectar')]]");
    By boton_informacion_deudanopagada = By.xpath("/html/body/div[8]/div/div/div[3]/div/button[1]");
    By nombre_orden_venta= By.xpath("//div[@class='roe-widget-header' and h1[contains(text(),'Desconectar Servicios SO')]]");
    By body_nombre_orden=By.xpath("/html/body/div[6]/div[3]/div[1]/div[2]/div[1]/div[2]/div/table/tbody[1]");
    
    By filtro_SO_nombre = By.xpath("//*[@id=\"9139371752413211533_-1\"]/span[2]");
    By filtro_input_Nombre = By.xpath("//input[@type=\"text\" and @class=\"gwt-TextBox nc-field-text-input\"]");
    By aplicar_Filtro_Nombre = By.xpath("//button[@class=\"TableCtrl-button gwt-ParCtrl-btn\" and contains(text(),'Aplicar')]");
    
    public DesconectarPage()
    {
        page= new CostumerPage();
        soCreadas = new HashMap<>();
        
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
    }
    public void Desconectar(String linea) throws InterruptedException{
        WebElement fact_pago2=page.obtener_BotonMenu("Facturación y pago");
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
        
        Wait_element(obtener_linea(linea));
        Thread.sleep(4000);
        click(obtener_linea(linea));
        
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
        
        if (page.esta_configurar_Contrato()) {
            click(configurar_ContratoBTN);
            Thread.sleep(3000);
            page.confirmarContrato();
            Wait(page.generar_contrato);
            Thread.sleep(5000);
            click(page.generar_contrato);
            
            Wait(page.firmar_contrato);
            Thread.sleep(8000);
            click(page.firmar_contrato);
            Thread.sleep(8000);
            Wait(page.boton_confirmar_firma);
            Thread.sleep(4000);
            click(page.boton_confirmar_firma);
        }
        
        Wait_element(page.obtener_botonenviar());
        Thread.sleep(3000);
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
        soCreadas.put(linea,obtener_urlSO());
        System.out.println(soCreadas);
        
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
                ppactivo=planes.get(i);
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
    
}
