/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pages;

import static Base.BasePage.driver;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

/**
 *
 * @author ipupo
 */
public class DesconectarPage extends Base.BasePage{
    By primerpartelinea= By.xpath("/html/body/div[4]/div[3]/div[1]/form[1]/div[1]/table/tbody/tr[2]/td/table/tbody/tr[2]/td/div/table/tbody/tr/td[2]/table/tbody/tr/td[2]/div/span/input[1]");
    By segundapartelinea= By.xpath("/html/body/div[4]/div[3]/div[1]/form[1]/div[1]/table/tbody/tr[2]/td/table/tbody/tr[2]/td/div/table/tbody/tr/td[2]/table/tbody/tr/td[2]/div/span/input[2]");
    By tercerapartelinea= By.xpath("/html/body/div[4]/div[3]/div[1]/form[1]/div[1]/table/tbody/tr[2]/td/table/tbody/tr[2]/td/div/table/tbody/tr/td[2]/table/tbody/tr/td[2]/div/span/input[3]");
    By botonbusuqeda= By.xpath("/html/body/div[4]/div[3]/div[1]/form[1]/div[2]/div/div");
   
    By linkcliente= By.xpath("/html/body/div[4]/div[3]/div[1]/form[2]/table/tbody/tr/td/div[1]/table/tbody/tr/td[3]/a");
    By SO= By.linkText("Órdenes de Venta");
    By nuevaSO= By.xpath("/html/body/div[6]/div[3]/div[1]/div[2]/div[1]/div[2]/div/div[1]/div/div/div/div/div[1]/button");
    By canaldistribucion= By.className("refsel_single");
    By combobox= By.className("refsel_table");
    ///html/body/div[31]/div[2]/div[1]
    By pruebacanal= By.cssSelector("#id_refsel1613764204_div > div > input");
    By elementoAgente= By.xpath("//*[@id=\"id_refsel1965777193_div\"]/div/input");
    By stringAgente= By.xpath("//*[@id=\"nc_refsel_list\"]/div[2]/div[1]/div[1]/div[1]");
    By recientes = By.xpath("//*[@id=\"gen_menu_3\"]");
    By botonCrear= By.xpath("//html/body/div[30]/div/div/div[2]/div/div[2]/table/tbody/tr[2]/td/div/div[2]/div/div/div/div/div[1]/button"); 
    
    CostumerPage page;
    By plan= By.xpath("/html/body/div[3]/div[3]/div[2]/div[1]/div[3]/div[2]/div[2]/div[2]/div/div/div/div[1]/div/div/div/div/div/div[1]/div/div/div/div[2]");
    By desconectar= By.xpath("/html/body/div[3]/div[3]/div[2]/div[2]/table/tbody/tr/td[2]/div/div/div[2]/div/div/table/tbody/tr/td[2]/div/a[5]");
    By botonnextaddpp=By.cssSelector("body > div.wizard_layout.header_visible > div.top_line_2 > div.breadcrumbs > div.prev_next_box > div:nth-child(2)");
    By comentario= By.xpath("/html/body/div[5]/div/div/div[2]/div/div/textarea");
    By aceptardesconexion=By.xpath("/html/body/div[5]/div/div/div[3]/div/button[1]");
    By boton_informacion_deudanopagada = By.xpath("/html/body/div[8]/div/div/div[3]/div/button[1]");
    public DesconectarPage()
    {
        page= new CostumerPage();
    }
    
    public void initUrlBusqueda(String env  ){
         visit("https://noprd-"+env+"-toms.temu.com.uy:7002/common/search.jsp?explorer_mode=disable&object=9141907040613227268&o=9155890323313723269");
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
        Thread.sleep(2000);
        Wait_element(page.seleccionar_CanalX());
        click(page.seleccionar_CanalX());
        Wait(botonCrear);
        click(botonCrear); 
        page.loading();
        
        Wait_element(obtener_linea(linea));
        click(obtener_linea(linea));
        
        Wait(desconectar);
        click(desconectar);
       sendKeys("Desconexión Automatizada", comentario);
        Wait(aceptardesconexion);
        click(aceptardesconexion);
        Wait(botonnextaddpp);
        click(botonnextaddpp);
        Thread.sleep(4000);
        Wait_element(page.obtener_BotonMenu("Revisión"));
        click(page.obtener_BotonMenu("Revisión"));
        Wait_element(page.obtener_botonenviar());
        
        click(page.obtener_botonenviar());
        
        page.validar_Deuda();
        
        Thread.sleep(5000);
        Wait(page.boton_cerrarSO);
        Thread.sleep(5000);
        //click(page.boton_cerrarSO);
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
     
     
}
