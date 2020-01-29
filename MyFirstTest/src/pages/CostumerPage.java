/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pages;

import java.awt.Desktop;
import java.sql.Driver;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.TimeoutException;


/**
 *
 * @author sdominguez
 */
public class CostumerPage extends Base.BasePage{
   
    By menu= By.xpath("//*[@id=\\\"menuItem_0\\\"]/ul/li[1]/a/span");
    By SO= By.linkText("Órdenes de Venta");
    By nuevaSO= By.xpath("/html/body/div[6]/div[3]/div[1]/div[2]/div[1]/div[2]/div/div[1]/div/div/div/div/div[1]/button");
    By canaldistribucion= By.className("refsel_single");
    By combobox= By.className("refsel_table");
    By pruebacanal= By.cssSelector("#id_refsel1613764204_div > div > input");
   
    //("//*[@class=\"id_refsel1965777193_div/a
    By elementoAgente= By.xpath("//*[@id=\"id_refsel1965777193_div\"]/div/input");
    By stringAgente= By.xpath("//*[@id=\"nc_refsel_list\"]/div[2]/div[1]/div[1]/div[1]");
    By recientes = By.xpath("//*[@id=\"gen_menu_3\"]");
    By botonCrear= By.xpath("//*[@id=\"ui-id-5\"]/div/div[2]/table/tbody/tr[2]/td/div/div[2]/div/div/div/div/div[1]/button");
    By Lis_planes= By.xpath("/html/body/div[3]/div[3]/div[2]/div[2]/table/tbody/tr/td/table/tbody/tr/td[1]/div/div[3]");
    
    
   
    By seleccionPP= By.cssSelector("td:nth-child(1) > .box_selection .roe-widget-content:nth-child(2) .roe-widget-header__sh-inner");
    By table= By.xpath("/html/body/div[3]/div[3]/div[2]/div[2]/table/tbody/tr/td/table/tbody/tr/td[1]/div/div[3]/div[2]/table");
    By table_plc= By.xpath("/html/body/div[3]/div[3]/div[2]/div[2]/table/tbody/tr/td/table/tbody/tr/td[1]/div/div[3]/div[3]/table");
    By table_plr = By.xpath("/html/body/div[3]/div[3]/div[2]/div[2]/table/tbody/tr/td/table/tbody/tr/td[1]/div/div[3]/div[4]");
    
    By productosasociados=By.xpath("/html/body/div[3]/div[3]/div[2]/div[1]/div[3]/div[2]/div[2]");
   ///html/body/div[3]/div[3]/div[2]/div[1]/div[3]/div[2]/div[2]
    By seleccionarPLTEJ=By.className("roe-widget-content");
    By msisdn = By.xpath("/html/body/div[3]/div[3]/div[2]/div[2]/table/tbody/tr/td[2]/div/div/div[3]/table[1]/tbody/tr/td/div/div[3]/table/tbody/tr/td/div/div/table/tbody/tr/td/div/div/div/div/div/div[2]/div/div/div/div[2]/div/table/tbody/tr[8]/td[2]/div/span/div/div/div[1]/input");
    By msidn_posp= By.xpath("/html/body/div[3]/div[3]/div[2]/div[2]/table/tbody/tr/td[2]/div/div/div[3]/table[1]/tbody/tr/td/div/div[3]/table/tbody/tr/td/div/div/table/tbody/tr/td/div/div/div/div/div/div[2]/div/div/div/div[2]/div/table/tbody/tr[6]/td[2]/div/span/div/div/div[1]/input");
    By seleccionarmsisdn= By.xpath("//*[@id=\"nc_refsel_list\"]/div[2]");
    
    By iccid= By.xpath("/html/body/div[3]/div[3]/div[2]/div[2]/table/tbody/tr/td[2]/div/div/div[3]/table[1]/tbody/tr/td/div/div[3]/table/tbody/tr/td/div/div/table/tbody/tr/td/div/div/div/div/div/div[2]/div/div/div/div[2]/div/table/tbody/tr[7]/td[2]/div/div/div/div[1]/input");
    By iccid_posp=By.xpath("/html/body/div[3]/div[3]/div[2]/div[2]/table/tbody/tr/td[2]/div/div/div[3]/table[1]/tbody/tr/td/div/div[3]/table/tbody/tr/td/div/div/table/tbody/tr/td/div/div/div/div/div/div[2]/div/div/div/div[2]/div/table/tbody/tr[1]/td[2]/div/div/div/div[1]/input");
    By iccid_plr= By.xpath("/html/body/div[3]/div[3]/div[2]/div[2]/table/tbody/tr/td[2]/div/div/div[3]/table[1]/tbody/tr/td/div/div[3]/table/tbody/tr/td/div/div/table/tbody/tr/td/div/div/div/div/div/div[2]/div/div/div/div[2]/div/table/tbody/tr[3]/td[2]/div/div/div/div[1]/input");
    By seleccionariccid= By.xpath("//*[@id=\"nc_refsel_list\"]/div[2]");
    By reparacion_pantalla= By.xpath("/html/body/div[3]/div[3]/div[2]/div[2]/table/tbody/tr/td[2]/div/div/div[3]/table[1]/tbody/tr/td/div/div[3]/table/tbody/tr/td/div/div/table/tbody/tr/td/div/div");
    //By reparacion_pantalla_plr= By.xpath("/html/body/div[3]/div[3]/div[2]/div[2]/table/tbody/tr/td[2]/div/div/div[3]/table[1]/tbody/tr/td/div/div[3]/table/tbody/tr/td/div/div/table/tbody/tr/td/div/div/div/div/div/div[11]/div[1]");
    ///html/body/div[3]/div[3]/div[2]/div[2]/table/tbody/tr/td[2]/div/div/div[3]/table[1]/tbody/tr/td/div/div[3]/table/tbody/tr/td/div/div/table/tbody/tr/td/div/div/div/div/div/div[11]/div[1]/div/input
    ///html/body/div[3]/div[3]/div[2]/div[2]/table/tbody/tr/td[2]/div/div/div[3]/table[1]/tbody/tr/td/div/div[3]/table/tbody/tr/td/div/div/table/tbody/tr/td/div/div/div/div/div/div[11]/div[1]/div/input
    By botonnextaddpp=By.cssSelector("body > div.wizard_layout.header_visible > div.top_line_2 > div.breadcrumbs > div.prev_next_box > div:nth-child(2)");
  
    By botonfact_pago= By.xpath("/html/body/div[3]/div[2]");
 
    By cuenta_facturacion=By.xpath("/html/body/div[3]/div[3]/div[2]/div/div[2]/div[1]/div[2]/div/button[1]");
    By cuenta_fact_posp= By.xpath("/html/body/div[3]/div[3]/div[2]/div/div[2]/div[1]/div[2]/div/button[2]");
    By boton_crear_nuevacuenta_facturacion_pp= By.xpath("//*[@id=\"ui-id-1\"]/div/div[3]/div/div/div/div/div[1]/button");
    By boton_crear_cf_posp= By.xpath("/html/body/div[7]/div/div/div[2]/div/div[3]/div/div/div/div/div[1]");
    ///html/body/div[7]/div/div/div[2]/div/div[3]/div/div/div/div/div[1]
    By cuenta_facturacion_creada= By.xpath("/html/body/div[3]/div[3]/div[2]/div/div[2]/div[2]");
    By servicios_lista=By.xpath("/html/body/div[3]/div[3]/div[2]/div/div[1]/div");
    
    By select_cuenta_facturacion= By.xpath("/html/body/div[3]/div[3]/div[2]/div/div[1]/div/div[3]/div/div[2]/div/div[2]/div[1]");
 
    By boton_revision= By.xpath("/html/body/div[3]/div[2]/div[1]/ul/li[4]");
    By boton_contrato= By.xpath("/html/body/div[3]/div[3]/div[1]/div[2]/div/div[2]/div[7]");
    By boton_contrato_confirmar= By.xpath("/html/body/div[7]/div/div/div[3]/div/button[1]");
    By boton_contrato_confirmar2=By.xpath("/html/body/div[8]/div/div/div[3]/div/button[1]");

    By generar_contrato=By.xpath("/html/body/div[3]/div[3]/div[1]/div[2]/div/div[3]/div[2]/div/table/tbody/tr[2]/td[2]");
    By firmar_contrato=By.xpath("/html/body/div[3]/div[3]/div[1]/div[2]/div/div[3]/div[2]/div/table/tbody/tr[2]/td[2]");
    By boton_confirmar_firma= By.xpath("/html/body/div[9]/div/div/div[2]/div/div[3]/div/div/div/div/div[1]");
    By boton_crearfact= By.xpath("/html/body/div[3]/div[3]/div[1]/div[2]/div/div[2]/div[10]");
    By list_botonenviar= By.xpath("/html/body/div[3]/div[3]/div[1]/div[2]/div/div[2]");
    By boton_enviar= By.xpath("/html/body/div[3]/div[3]/div[1]/div[2]/div/div[2]/div[11]");
    
    By boton_factSinPagar= By.xpath("/html/body/div[10]/div/div/div[3]/div/button[1]");
    
    By boton_cerrarSO = By.xpath("/html/body/div[3]/div[3]/div[2]/div/div[2]/div[3]");
    By opcion_cambiado= By.xpath("/html/body/div[3]/div[3]/div[2]/div[2]/table/tbody/tr/td[1]/div[2]/div[2]/div[3]");
    By lista_plancambio_regular= By.xpath("/html/body/div[3]/div[3]/div[2]/div[2]/table/tbody/tr/td[1]/div[2]/div[2]/div[3]/div[2]/div/div[1]");
    //html/body/div[3]/div[3]/div[2]/div[2]/table/tbody/tr/td[1]/div[2]/div[2]/div[3]/div[2]/div/div[1]
    By lista_plancambio_controlada= By.xpath("/html/body/div[3]/div[3]/div[2]/div[2]/table/tbody/tr/td[1]/div[2]/div[2]/div[3]/div[2]/div/div[2]");
    By lista_plancambio_prepago= By.xpath("/html/body/div[3]/div[3]/div[2]/div[2]/table/tbody/tr/td[1]/div[2]/div[2]/div[3]/div[2]/div/div[3]");
    By select_SIMCardLost= By.xpath("/html/body/div[3]/div[3]/div[2]/div[2]/table/tbody/tr/td[2]/div/div/div[3]/table[1]/tbody/tr/td/div/div[3]/table/tbody/tr/td/div/div/table/tbody/tr/td/div/div/div/div/div/div[2]/div/div/div/div[2]/div/table/tbody/tr[8]/td[2]/div/div");
    By boton_progress = By.xpath("/html/body/div[9]");
   
    public CostumerPage() {
       super(); 
        
    }
    /*Para Test_Cliente_solicita_denunciar_la_linea_por_robo_o_perdida*/
   public void seleccionar_CanalOrder(String object_id) throws InterruptedException{
     
       visit("https://noprd-jit-toms.temu.com.uy:7002/platform/csr/customer.jsp?tab=_Sales+Orders+&object="+ object_id);
        Wait(nuevaSO);
        click(nuevaSO);
        Wait(canaldistribucion);
        Thread.sleep(4000);
        click(canaldistribucion);
        Thread.sleep(2000);
        Wait_element(seleccionar_CanalX());
        click(seleccionar_CanalX());
        Wait(botonCrear);
        click(botonCrear);      
   }
   
   public void select_SIMCardLost(){
   
   WebElement simcardlost= null;
   Wait(select_SIMCardLost);
   WebElement sim=findElement(select_SIMCardLost);
   List<WebElement>lista_sim=sim.findElements(By.tagName("option"));
   for(int i=0;i<lista_sim.size();i++){
   
    if(getText(lista_sim.get(i)).contains("Yes")){//En dependencia de los permisos del usuario podra acceder a diferentes canal de distribucion
               simcardlost=lista_sim.get(i);
                break;
            } 
          }
       click(simcardlost);
   }
   public void Terminar() throws InterruptedException{
   WebElement siguiente=findElement(botonnextaddpp);
   WebElement fact_pago2=obtener_BotonMenu("Facturación y pago");
  
   Thread.sleep(4000);
   Wait_element(siguiente);
   siguiente.click();
   Wait_element(fact_pago2);
   Thread.sleep(4000);
   fact_pago2.click();
   Thread.sleep(4000);
   Wait_element(obtener_BotonMenu("Revisión"));
   click(obtener_BotonMenu("Revisión"));
   Wait_element(obtener_botonenviar());
    Thread.sleep(10000);
    click(obtener_botonenviar());
    Thread.sleep(5000);
    Wait(boton_cerrarSO);
    Thread.sleep(5000);
   click(boton_cerrarSO);
   
   }
   /*Cambio Plan*/
   public void cambio_Plan(String nombre_plan,String tipo_plan) throws InterruptedException{
      
        Wait(opcion_cambiado);
        System.out.println(opcion_cambiado);
        click(opcion_cambiado);
        WebElement select =null;
        switch (tipo_plan) {
           case "PP":
               select = this.Obtener_cambioPP(nombre_plan);
               click(select);
               break;
           case "PLC":
               select= this.Obtener_cambioPLC(nombre_plan);
               click(select);
               break;
           case "PLR":
               select = this.Obtener_cambioPLR(nombre_plan);
               click(select);
               break;
           default:
               throw new AssertionError();
       }
        
   }
   
     public void Terminar_Cambio_Plan() throws InterruptedException{
   WebElement siguiente=findElement(botonnextaddpp);
   WebElement fact_pago2=obtener_BotonMenu("Facturación y pago");
  
      Thread.sleep(8000);
     try{
         if (reparacion_Pantalla()==true) {
         Wait_element(elemento_reparacion_Pantalla());
         Thread.sleep(4000);
         click(elemento_reparacion_Pantalla());
     }      
     }
     catch (StaleElementReferenceException e)
    {
        System.out.println(e);
    }catch (NoSuchElementException e)
    {
        System.out.println(e);
    } 
      
   Thread.sleep(4000);
   Wait_element(siguiente);
   siguiente.click();
   Wait_element(fact_pago2);
   Thread.sleep(4000);
   fact_pago2.click();
   Thread.sleep(4000);
   Wait_element(obtener_BotonMenu("Revisión"));
   click(obtener_BotonMenu("Revisión"));
    Thread.sleep(4000);
    Wait(boton_contrato);
    click(boton_contrato);
    this.confirmarContrato();
    
    Thread.sleep(2000);
    Wait(generar_contrato);
    click(generar_contrato);
    
     Wait(firmar_contrato);
     Thread.sleep(4000);
    click(firmar_contrato);
     Thread.sleep(2000);
     Wait(boton_confirmar_firma);
     click(boton_confirmar_firma);
   Wait_element(obtener_botonenviar());
    Thread.sleep(10000);
    click(obtener_botonenviar());
    Thread.sleep(5000);
    Wait(boton_cerrarSO);
    Thread.sleep(5000);
   click(boton_cerrarSO);
   
   }
    /*Para Test Alta Cliente y Plan*/
    public void seleccionar_Canal(String object_id) throws InterruptedException{
        
        click(recientes);
        visit("https://noprd-jit-toms.temu.com.uy:7002/ncobject.jsp?id="+ object_id);//9155882510113704246");//fichero Seleccionar cliente
        Wait(SO);
        click(SO);
        Wait(nuevaSO);
        click(nuevaSO);
        Wait(canaldistribucion);
        Thread.sleep(4000);
        click(canaldistribucion);
        Thread.sleep(2000);
        Wait_element(seleccionar_CanalX());
        click(seleccionar_CanalX());
        Wait(botonCrear);
        click(botonCrear);
    }
     

public void seleccionar_PP(String nombre_plan) throws InterruptedException {
   
   Wait_element(obtenerList_Planes("PrePagos"));
   click(obtenerList_Planes("PrePagos"));
   Wait(table);
   WebElement tablePP=findElement(table);
   List<WebElement> pp= tablePP.findElements(By.tagName("span"));
            for (int j = 0; j < pp.size(); j++) {
            if(getText(pp.get(j)).contains(nombre_plan)){//En dependencia de los permisos del usuario podra acceder a diferentes canal de distribucion
                Wait_element(pp.get(j));
                Thread.sleep(4000);
                click(pp.get(j));
                break;
            } 
          }          
 
}
public void seleccionar_PosPC(String nombre_plan) {
   
   Wait_element(obtenerList_Planes("Cuenta Controlada"));
   click(obtenerList_Planes("Cuenta Controlada"));
   Wait(table_plc);
   WebElement tablePP=findElement(table_plc);
   List<WebElement> ppc= tablePP.findElements(By.tagName("span"));
            for (int j = 0; j < ppc.size(); j++) {
            if(getText(ppc.get(j)).contains(nombre_plan)){//En dependencia de los permisos del usuario podra acceder a diferentes canal de distribucion
                click(ppc.get(j));
                break;
            } 
          }          
 
}
public void seleccionar_PosPR(String nombre_plan) {
   WebElement plr=null;
   Wait_element(obtenerList_Planes("Regulares"));
   click(obtenerList_Planes("Regulares"));
   Wait(table_plr);
   WebElement tablePP=findElement(table_plr);
   List<WebElement> ppc= tablePP.findElements(By.tagName("span"));
            for (int j = 0; j < ppc.size(); j++) {
            if(getText(ppc.get(j)).contains(nombre_plan)){//En dependencia de los permisos del usuario podra acceder a diferentes canal de distribucion
                plr=ppc.get(j);      
                break;
            } 
          }
            Wait_element(plr);
            click(plr);
 
}

public void obtener_PPActivo(String nombre_plan) throws InterruptedException{
WebElement ppactivo = null;
    Wait(productosasociados);
    Thread.sleep(3000);
    System.out.println("prod asociados "+productosasociados);   
WebElement tableproductasociados= findElement(productosasociados);
   List<WebElement> planes= tableproductasociados.findElements(By.tagName("span"));
   
    for (int i = 0; i < planes.size(); i++) {
            if(getText(planes.get(i)).contains(nombre_plan)){
                ppactivo=planes.get(i);
            }     
    }
    
    Wait_element(ppactivo);
    Thread.sleep(8000);
    click(ppactivo);
   }
public void iccid_MSISDN_PP() throws InterruptedException{
    
   
   WebElement siguiente=findElement(botonnextaddpp);
    WebElement fact_pago2=obtener_BotonMenu("Facturación y pago");
    Wait(iccid);
    sendKeys("89598076103021044266", iccid); // 89598071102044547292
    Wait(seleccionariccid);
    Thread.sleep(2000);
    click(seleccionariccid);
    Wait(msisdn);
    Thread.sleep(4000);
    sendKeys("93590328", msisdn); // 95728402
    Wait(seleccionarmsisdn);
    Thread.sleep(4000);
    click(seleccionarmsisdn);
    Wait_element(siguiente);
    Thread.sleep(4000);
    siguiente.click();
    Wait_element(fact_pago2);
    Thread.sleep(4000);
    fact_pago2.click();
    
    obtener_factcreada_pp();
   
    Thread.sleep(4000);
     Wait(boton_crearfact);
     click(boton_crearfact);
    validar_Factura();
    Wait_element(obtener_botonenviar());
    Thread.sleep(20000);
    click(obtener_botonenviar());
    Thread.sleep(5000);
   if (fact_sinpagar()!=null){
     Thread.sleep(8000);
      Wait(boton_factSinPagar);
       Thread.sleep(8000);
     click(boton_factSinPagar);
    }
   else{
        Thread.sleep(5000);
        Wait(boton_cerrarSO);
        click(boton_cerrarSO);
        }
 }
 public void iccid_MSISDN_PosPLC() throws InterruptedException{
    
 
   WebElement siguiente=findElement(botonnextaddpp);
    WebElement fact_pago2=obtener_BotonMenu("Facturación y pago");
    Wait(iccid_posp);
    sendKeys("89598076103021021090", iccid_posp); // 89598071102044547292
    Wait(seleccionariccid);
    Thread.sleep(2000);
    click(seleccionariccid);
    Wait(msidn_posp);
    Thread.sleep(4000);
    sendKeys("93571532", msidn_posp); // 95728402
    Wait(seleccionarmsisdn);
    Thread.sleep(4000);
    click(seleccionarmsisdn);
    Thread.sleep(4000);
     if (reparacion_Pantalla()==true) {
         Wait_element(elemento_reparacion_Pantalla());
         Thread.sleep(4000);
         click(elemento_reparacion_Pantalla());
     }
    Thread.sleep(4000);
    Wait_element(siguiente);
    siguiente.click();
    Wait_element(fact_pago2);
    Thread.sleep(4000);
    fact_pago2.click();
   
    obtener_factcreada_posp();
   
   Thread.sleep(4000);
    Wait(boton_contrato);
    click(boton_contrato);
    
    this.confirmarContrato();
    Thread.sleep(2000);
    Wait(generar_contrato);
    click(generar_contrato);
    
     Wait(firmar_contrato);
     Thread.sleep(4000);
    click(firmar_contrato);
     Thread.sleep(2000);
     Wait(boton_confirmar_firma);
     click(boton_confirmar_firma);
   Wait(boton_crearfact);
     click(boton_crearfact);
     validar_Factura();
    Wait_element(obtener_botonenviar());
    Thread.sleep(10000);
    click(obtener_botonenviar());
    Thread.sleep(5000);
    if(fact_sinpagar()!=null){
     Thread.sleep(5000);
      Wait(boton_factSinPagar);
       Thread.sleep(5000);
     click(boton_factSinPagar);
    }
    else
    Thread.sleep(5000);
   Wait(boton_cerrarSO);
   click(boton_cerrarSO);
 }
 
 
 
public void iccid_MSISDN_PosPLR() throws InterruptedException{
    
 
   WebElement siguiente=findElement(botonnextaddpp);
   WebElement fact_pago2=obtener_BotonMenu("Facturación y pago");
    
    
    Wait(iccid_plr);
    sendKeys("89598076103021044555", iccid_plr); // 89598071102044547292
    Wait(seleccionariccid);
    Thread.sleep(2000);
    click(seleccionariccid);
    Wait(msidn_posp);
    Thread.sleep(4000);
    sendKeys("93594532", msidn_posp); // 95728402
    Wait(seleccionarmsisdn);
    Thread.sleep(4000);
    click(seleccionarmsisdn);
    Thread.sleep(6000);
     if (reparacion_Pantalla()==true) {
         Thread.sleep(3000);
         click(elemento_reparacion_Pantalla());
     }
    Thread.sleep(4000);
    Wait_element(siguiente);
    siguiente.click();
    Wait_element(fact_pago2);
    Thread.sleep(6000);
    fact_pago2.click();
    
    obtener_factcreada_posp();
    
    Wait(boton_contrato);
    click(boton_contrato);
    Thread.sleep(5000);
    
    this.confirmarContrato();
    
    Thread.sleep(2000);
    
    Wait(generar_contrato);
    click(generar_contrato);

     Wait(firmar_contrato);
     Thread.sleep(5000);
    click(firmar_contrato);
     Thread.sleep(4000);
     Wait(boton_confirmar_firma);
     click(boton_confirmar_firma);
     Wait(boton_crearfact);
     click(boton_crearfact);
    validar_Factura();
    Wait_element(obtener_botonenviar());
    Thread.sleep(15000);
    click(obtener_botonenviar());
    Thread.sleep(6000);
    if(fact_sinpagar()!= null){
     Thread.sleep(5000);
      Wait(boton_factSinPagar);
       Thread.sleep(5000);
     click(boton_factSinPagar);
    }
    else
    Thread.sleep(5000);
   Wait(boton_cerrarSO);
   click(boton_cerrarSO);
 } 




/**
 *
 * @return 
 */
 public WebElement seleccionar_CanalX(){
        WebElement canal=null;
      
        WebElement canalD= findElement(combobox);
    List<WebElement> elemntcanaldistribucion= canalD.findElements(By.tagName("div")); 
        for (int i = 0; i < elemntcanaldistribucion.size(); i++) {
            if(getText(elemntcanaldistribucion.get(i)).equals("AGENTES ESPECIALISTAS"))//En dependencia de los permisos del usuario podra acceder a diferentes canal de distribucion
                canal=elemntcanaldistribucion.get(i);
        
        }
        return canal;
        
}
 /**
  * Se obtiene la lista de planes 
  * @param nombre_plan
  * @return 
  */
public WebElement obtenerList_Planes(String nombre_plan){//metodos utilizados
 WebElement pp=null;   
   Wait(Lis_planes);
 WebElement obtener_pp= findElement(Lis_planes);
 List<WebElement> list_obtenerpp= obtener_pp.findElements(By.tagName("div"));
 for (int i = 0; i < list_obtenerpp.size(); i++) {
            if(getText(list_obtenerpp.get(i)).equals(nombre_plan))//En dependencia de los permisos del usuario podra acceder a diferentes canal de distribucion
                pp=list_obtenerpp.get(i);
        
        }
 return pp;
} 

public WebElement obtener_botonenviar(){
WebElement boton_envia = null;
    Wait(boton_enviar);
WebElement be= findElement(boton_enviar);
 List<WebElement> enviar= be.findElements(By.tagName("a"));
 for (int i = 0; i < enviar.size(); i++) {
            if(getText(enviar.get(i)).equals("Enviar")){
           
                boton_envia=enviar.get(i);
            }     
    }
    return boton_envia;
}
public void validar_Factura() throws InterruptedException
{//metodo utilizado
By nombre_clase_boton_validar_factura_disabled=By.xpath("//div[@class='tfn_button_panel disabled'  and a[contains(text(),'Nueva factura')]]");
WebElement validar_fact_disable = null;
By nombre_clase_boton_validar_factura=By.xpath("//div[@class='tfn_button_panel'  and a[contains(text(),'Validar factura')]]");
WebElement validar_fact = null;

int i=0;
    
    loading();
    
    while (validar_fact_disable == null) {
                i++;       
                
                System.out.println("Validar factura: "+i);
                
                try{
                    validar_fact = findElement(nombre_clase_boton_validar_factura);
                    click(validar_fact);
                 }catch (NoSuchElementException e)
                     {
                         System.out.println(e);
                     }
                try{
                    loading();
                } catch (StaleElementReferenceException e)
                {
                    System.out.println(e);
                }catch (NoSuchElementException e)
                {
                    System.out.println(e);
                }
                
                try{
                    validar_fact_disable = findElement(nombre_clase_boton_validar_factura_disabled);
                 }catch (NoSuchElementException e)
                     {
                         System.out.println(e);
                     }
            }
}


     
    //return progress.isEnabled();
            

public void loading() throws InterruptedException
{
    
    WebElement progress = null;
    for (int i = 1; i < 11; i++) {
        try{///html/body/div[7]/div /html/body/div[7]
            progress = findElement(By.xpath("//div[@class='popupContent']"));///html/body/div["+i+"`]/div"));
            Wait_element(progress);
            System.out.println(progress);
            while (progress != null && progress.isDisplayed()){
                System.out.println("estado progreso en loading: "+progress.isEnabled());
                System.out.println("estado progreso displeied en loading: "+progress.isDisplayed());
                Thread.sleep(6000);
                Wait_element(progress);
               }
        } catch (StaleElementReferenceException e)
            {
                System.out.println(e);
            }catch (NoSuchElementException e)
            {
                System.out.println(e);
            }
    }
    
    
     
    //return progress.isEnabled();
            
}


public WebElement obtener_BotonMenu(String botoName)//metodos utilizados
{ 
WebElement facturacio_pago = null;
    Wait(botonfact_pago);
WebElement fp= findElement(botonfact_pago);
   List<WebElement> factura= fp.findElements(By.tagName("a"));
    System.out.println(factura);
    for (int i = 0; i < factura.size(); i++) {
            if(getText(factura.get(i)).contains(botoName)){
           
                facturacio_pago=factura.get(i);
            }     
    }
    return facturacio_pago;
    
}

public void obtener_factcreada_pp() throws InterruptedException{//metodos utilizados
    WebElement factura_creada = null;
  Wait(cuenta_facturacion_creada);
WebElement fc= findElement(cuenta_facturacion_creada);
List<WebElement> facturacreada= fc.findElements(By.tagName("div"));
  Wait(servicios_lista);
WebElement serv_list=findElement(servicios_lista);
List<WebElement> serviciolist= serv_list.findElements(By.tagName("option"));
boolean hay= false;    
for (WebElement wb : facturacreada) {
        if(getText(wb).contains("Prepago")){
           hay = true;
           
           break;
        }
    }

    if (!hay) {
       
       Wait(cuenta_facturacion);
        click(cuenta_facturacion);
        Thread.sleep(2000);
        Wait(boton_crear_nuevacuenta_facturacion_pp);
        click(boton_crear_nuevacuenta_facturacion_pp);
        Thread.sleep(4000);
        Wait_element(obtener_BotonMenu("Revisión"));
        click(obtener_BotonMenu("Revisión"));
            
    }else {
     
      WebElement scf= findElement(select_cuenta_facturacion);
      Wait(select_cuenta_facturacion);
     List<WebElement> selectfacturacreada= scf.findElements(By.tagName("select"));
    int size_list=selectfacturacreada.size();
     WebElement ultimo_select=selectfacturacreada.get(size_list - 1);
     Wait_element(ultimo_select);
     click(ultimo_select);
        int longitud = serviciolist.size()-1;
        for (int i = 0; i < serviciolist.size(); i++) {
            if (i == longitud) {
                factura_creada=serviciolist.get(i);     
            }

        }
        click(factura_creada);
     Thread.sleep(5000);
     Wait_element(obtener_BotonMenu("Revisión"));
     click(obtener_BotonMenu("Revisión"));
    }
    
 }
public void obtener_factcreada_posp() throws InterruptedException{//metodos utilizados
   //WebElement revision = obtener_BotonMenu("Revisión");
    WebElement factura_creada = null;
  Wait(cuenta_facturacion_creada);
WebElement fc= findElement(cuenta_facturacion_creada);
List<WebElement> facturacreada= fc.findElements(By.tagName("div"));
  Wait(servicios_lista);
WebElement serv_list=findElement(servicios_lista);
List<WebElement> serviciolist= serv_list.findElements(By.tagName("option"));
boolean hay= false;    
for (WebElement wb : facturacreada) {
        if(getText(wb).contains("Postpago")){
           hay = true;
           
           break;
        }
    }

    if (!hay) {
       
       Wait(cuenta_fact_posp);
        click(cuenta_fact_posp);
        Thread.sleep(2000);
        Wait(boton_crear_cf_posp);
        click(boton_crear_cf_posp);
        Thread.sleep(4000);
        Wait_element(obtener_BotonMenu("Revisión"));
        click(obtener_BotonMenu("Revisión"));
            
    }else {
     
      WebElement scf= findElement(select_cuenta_facturacion);
      Wait(select_cuenta_facturacion);
     List<WebElement> selectfacturacreada= scf.findElements(By.tagName("select"));
    int size_list=selectfacturacreada.size();
     WebElement ultimo_select=selectfacturacreada.get(size_list - 1);
     Wait_element(ultimo_select);
     click(ultimo_select);
        int longitud = serviciolist.size()-1;
        for (int i = 0; i < serviciolist.size(); i++) {
            if (i == longitud) {
                factura_creada=serviciolist.get(i);     
            }

        }
     click(factura_creada);
     Thread.sleep(5000);
     Wait_element(obtener_BotonMenu("Revisión"));
     click(obtener_BotonMenu("Revisión"));
    }
    
    
 }
public WebElement fact_sinpagar() throws InterruptedException{
    
    try{
        Wait(boton_factSinPagar);
        WebElement fact_sin_pago=findElement(boton_factSinPagar);
        return fact_sin_pago;
    } catch (TimeoutException e)
    {
        
        return null;
    }
    
        
}
public WebElement elemento_reparacion_Pantalla() throws InterruptedException{
     WebElement rp=null;
     Wait(reparacion_pantalla);
     WebElement pantalla=findElement(reparacion_pantalla);
     List<WebElement>lista_div= pantalla.findElements((By.tagName("span")));
     for (int j = 0; j < lista_div.size(); j++) {
            if(getText(lista_div.get(j)).contains("Reparación de Pantalla")) {//En dependencia de los permisos del usuario podra acceder a diferentes canal de distribucion
                rp=lista_div.get(j);
                break; 
         
            } 
                     
          }
        return rp;
    
}
public Boolean reparacion_Pantalla() throws InterruptedException{
 WebElement reparacion=elemento_reparacion_Pantalla();
    System.out.println(reparacion);
  return reparacion.isDisplayed();
   
}




/*public Boolean reparacion_Pantalla_PLR() throws InterruptedException{
    
    Wait(reparacion_pantalla_plr);
    WebElement repa_pantalla=findElement(reparacion_pantalla_plr);
        return repa_pantalla.isDisplayed();
}*/
public WebElement Obtener_cambioPLR(String nombre_plan){//utilizado
    WebElement plr=null;
    Wait(lista_plancambio_regular);
    WebElement cambio_regular= findElement(lista_plancambio_regular);
    List<WebElement>lista_regular= cambio_regular.findElements(By.tagName("span"));
     for (int j = 0; j < lista_regular.size(); j++) {
            if(getText(lista_regular.get(j)).contains(nombre_plan)) {//En dependencia de los permisos del usuario podra acceder a diferentes canal de distribucion
            
                plr=lista_regular.get(j);
                break; 
         
            } 
                     
          }
       Wait_element(plr);
       return plr;
   
   }
   public WebElement Obtener_cambioPLC(String nombre_plan){//utilizado
    WebElement plc=null;
    Wait(lista_plancambio_controlada);
     WebElement cambio_controlado=findElement(lista_plancambio_controlada);

    List<WebElement>lista_controlado= cambio_controlado.findElements(By.tagName("span"));
     for (int j = 0; j < lista_controlado.size(); j++) {
            if(getText(lista_controlado.get(j)).contains(nombre_plan)) {//En dependencia de los permisos del usuario podra acceder a diferentes canal de distribucion
            
                plc=lista_controlado.get(j);
                break; 
         
            } 
                     
          }
       Wait_element(plc);
       return plc;
   
   }
    public WebElement Obtener_cambioPP(String nombre_plan){//utilizado
    WebElement pp=null;
    Wait(lista_plancambio_prepago);
     WebElement cambio_prepago=findElement(lista_plancambio_prepago);
    List<WebElement>lista_prepago= cambio_prepago.findElements(By.tagName("span"));
     for (int j = 0; j < lista_prepago.size(); j++) {
            if(getText(lista_prepago.get(j)).contains(nombre_plan)) {//En dependencia de los permisos del usuario podra acceder a diferentes canal de distribucion
            
                pp=lista_prepago.get(j);
                break; 
         
            } 
         
          }
       Wait_element(pp);
       return pp;
   
   }
    public void confirmarContrato()
{
    boolean esta = false;
    try{
        Wait(boton_contrato_confirmar);
        click(boton_contrato_confirmar);
        esta = true;
    } catch (StaleElementReferenceException e)
    {
        System.out.println(e);
    } catch (NoSuchElementException | TimeoutException e)
    {
        System.out.println(e);
    }
    
    if (!esta) {
        try{
            Wait(boton_contrato_confirmar2);
            click(boton_contrato_confirmar2);
        } catch (StaleElementReferenceException e)
        {
            System.out.println(e);
        } catch (NoSuchElementException | TimeoutException e)
        {
            System.out.println(e);
        }
    }
}
/*public WebElement Obtener_PP_Derecha(){
    WebElement elem=null;
Wait_element(obtenerList_PP());
   click(obtenerList_PP());
   Wait(table);
   WebElement tablePP=findElement(table);
   List<WebElement> pp= tablePP.findElements(By.tagName("span"));
            for (int j = 0; j < pp.size(); j++) {
            if(getText(pp.get(j)).contains("PLTT")){//En dependencia de los permisos del usuario podra acceder a diferentes canal de distribucion
                elem=pp.get(j);
                break;
            } 
          } 
            return elem; 
  }
public WebElement obtener_PP_Izquierda(){
WebElement ppactivo = null;
    Wait(productosasociados);
    System.out.println("prod asociados "+productosasociados);   
WebElement tableproductasociados= findElement(productosasociados);
   List<WebElement> planes= tableproductasociados.findElements(By.tagName("span"));
   
    for (int i = 0; i < planes.size(); i++) {
            if(getText(planes.get(i)).contains("PLTT")){
                ppactivo=planes.get(i);
            }     
    }
    return ppactivo;
   }*/
/*public void Validar_PP(){
By mas=By.xpath("/html/body/div[3]/div[3]/div[2]/div[2]/table/tbody/tr/td/table/tbody/tr/td[1]/div/div[3]/div[2]/table/tbody/tr[1]/td[3]");
By boton_mas=By.xpath("/html/body/div[7]/div/div/div[3]/div/button[1]");
WebElement pp_izquierda=obtener_PP_Izquierda();
WebElement pp_derecha= Obtener_PP_Derecha();
if(getText(pp_derecha).equals(getText(pp_izquierda))){
    Wait(mas);
    click(mas);
    Wait(boton_mas);
    click(boton_mas);
}
   WebElement ppactivo = null;
    Wait(productosasociados);
    System.out.println("prod asociados "+productosasociados);   
WebElement tableproductasociados= findElement(productosasociados);
   List<WebElement> planes= tableproductasociados.findElements(By.tagName("span"));
   
    for (int i = 0; i < planes.size(); i++) {
            if(getText(planes.get(i)).contains("PLTT")){
                ppactivo=planes.get(i);
            }     
    }
    Wait_element(ppactivo);       
    click(ppactivo); 
}*/


}



   

