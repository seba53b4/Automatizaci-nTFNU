/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pages;

import Utils.EnterpriseClient;
import Utils.Plan;
import java.awt.Desktop;
import java.sql.Driver;
import java.time.chrono.ThaiBuddhistChronology;
import java.util.List;
import java.util.concurrent.TimeUnit;
import limpieza_recurso.Proceso_Desconexion;
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
    By Lis_planes= By.cssSelector("  body > div.wizard_layout.header_visible > div.content_wrapper.open_right > div:nth-child(3) > div.center_col > table > tbody > tr > td > table > tbody > tr > td:nth-child(1) > div > div:nth-child(3)");
    //body > div.wizard_layout.header_visible > div.content_wrapper.open_right > div:nth-child(3) > div.center_col > table > tbody > tr > td > table > tbody > tr > td:nth-child(1) > div > div:nth-child(3)
    
    
    By nombre_orden_venta= By.xpath("//div[@class='roe-widget-header' and h1[contains(text(),'Servicios SO')]]");
    By seleccionPP= By.cssSelector("td:nth-child(1) > .box_selection .roe-widget-content:nth-child(2) .roe-widget-header__sh-inner");
    By table= By.xpath("/html/body/div[3]/div[3]/div[2]/div[2]/table/tbody/tr/td/table/tbody/tr/td[1]/div/div[3]/div[2]/table");
    By table_plc= By.xpath("/html/body/div[3]/div[3]/div[2]/div[2]/table/tbody/tr/td/table/tbody/tr/td[1]/div/div[3]/div[3]/table");
    By table_plr = By.xpath("/html/body/div[3]/div[3]/div[2]/div[2]/table/tbody/tr/td/table/tbody/tr/td[1]/div/div[3]/div[4]");
    
    By productosasociados=By.cssSelector("body > div.wizard_layout.header_visible > div.content_wrapper.open_right > div:nth-child(3) > div.left_col > div.left_col__inner > div.left_col__inner-wrap > div:nth-child(2)");
    By seleccionarPLTEJ=By.className("roe-widget-content");
    By msisdn = By.xpath("/html/body/div[3]/div[3]/div[2]/div[2]/table/tbody/tr/td[2]/div/div/div[3]/table[1]/tbody/tr/td/div/div[3]/table/tbody/tr/td/div/div/table/tbody/tr/td/div/div/div/div/div/div[2]/div/div/div/div[2]/div/table/tbody/tr[9]/td[2]/div/span/div/div/div[1]/input");
    By msidn_posp= By.xpath("/html/body/div[3]/div[3]/div[2]/div[2]/table/tbody/tr/td[2]/div/div/div[3]/table[1]/tbody/tr/td/div/div[3]/table/tbody/tr/td/div/div/table/tbody/tr/td/div/div/div/div/div/div[2]/div/div/div/div[2]/div/table/tbody/tr[8]/td[2]/div/span/div/div/div[1]/input");
    By msidn_posplr=By.xpath("/html/body/div[3]/div[3]/div[2]/div[2]/table/tbody/tr/td[2]/div/div/div[3]/table[1]/tbody/tr/td/div/div[3]/table/tbody/tr/td/div/div/table/tbody/tr/td/div/div/div/div/div/div[2]/div/div/div/div[2]/div/table/tbody/tr[10]/td[2]/div/span/div/div/div[1]/input");
    ///html/body/div[3]/div[3]/div[2]/div[2]/table/tbody/tr/td[2]/div/div/div[3]/table[1]/tbody/tr/td/div/div[3]/table/tbody/tr/td/div/div/table/tbody/tr/td/div/div/div/div/div/div[2]/div/div/div/div[2]/div/table/tbody/tr[10]/td[2]/div/span/div/div/div[1]/input
    By seleccionarmsisdn= By.xpath("/html/body/div[4]/div[2]/div[1]/div");
    By iccidPPPLKMIG= By.xpath("/html/body/div[3]/div[3]/div[2]/div[2]/table/tbody/tr/td[2]/div/div/div[3]/table[1]/tbody/tr/td/div/div[3]/table/tbody/tr/td/div/div/table/tbody/tr/td/div/div/div/div/div/div[4]/div/div/div/div[2]/div/table/tbody/tr[8]/td[2]/div/div/div/div[1]/input");
    By selectICCIDPPPLKMIG=By.xpath("/html/body/div[4]/div[2]/div[1]/div[1]");
    
    By msidnPPPLKMIG=By.xpath("/html/body/div[3]/div[3]/div[2]/div[2]/table/tbody/tr/td[2]/div/div/div[3]/table[1]/tbody/tr/td/div/div[3]/table/tbody/tr/td/div/div/table/tbody/tr/td/div/div/div/div/div/div[4]/div/div/div/div[2]/div/table/tbody/tr[9]/td[2]/div/span/div/div/div[1]/input");
    ///html/body/div[3]/div[3]/div[2]/div[2]/table/tbody/tr/td[2]/div/div/div[3]/table[1]/tbody/tr/td/div/div[3]/table/tbody/tr/td/div/div/table/tbody/tr/td/div/div/div/div/div/div[4]/div/div/div/div[2]/div/table/tbody/tr[9]/td[2]/div/span/div/div/div[1]/input
    By selectmsidnPPPLKMIG=By.xpath("/html/body/div[4]/div[2]/div[1]/div");
    By iccid= By.xpath("/html/body/div[3]/div[3]/div[2]/div[2]/table/tbody/tr/td[2]/div/div/div[3]/table[1]/tbody/tr/td/div/div[3]/table/tbody/tr/td/div/div/table/tbody/tr/td/div/div/div/div/div/div[2]/div/div/div/div[2]/div/table/tbody/tr[8]/td[2]/div/div/div/div[1]/input");
    By iccid_posp=By.xpath("/html/body/div[3]/div[3]/div[2]/div[2]/table/tbody/tr/td[2]/div/div/div[3]/table[1]/tbody/tr/td/div/div[3]/table/tbody/tr/td/div/div/table/tbody/tr/td/div/div/div/div/div/div[2]/div/div/div/div[2]/div/table/tbody/tr[5]/td[2]/div/div/div/div[1]/input");
    By iccid_plr= By.xpath("/html/body/div[3]/div[3]/div[2]/div[2]/table/tbody/tr/td[2]/div/div/div[3]/table[1]/tbody/tr/td/div/div[3]/table/tbody/tr/td/div/div/table/tbody/tr/td/div/div/div/div/div/div[2]/div/div/div/div[2]/div/table/tbody/tr[3]/td[2]/div/div/div/div[1]/input");
    By seleccionariccid= By.xpath("/html/body/div[4]/div[2]/div[1]/div");
    By reparacion_pantalla= By.xpath("/html/body/div[3]/div[3]/div[2]/div[2]/table/tbody/tr/td[2]/div/div/div[3]/table[1]/tbody/tr/td/div/div[3]/table/tbody/tr/td/div/div/table/tbody/tr/td/div/div");
    
    By botonnextaddpp=By.cssSelector("body > div.wizard_layout.header_visible > div.top_line_2 > div.breadcrumbs > div.prev_next_box > div:nth-child(2)");
  
    By botonfact_pago= By.xpath("/html/body/div[3]/div[2]");
    By boton_revision1=By.cssSelector("body > div.wizard_layout.header_visible > div.top_line_2 > div.breadcrumbs > ul > li:nth-child(4)");
 
    By cuenta_facturacion=By.xpath("/html/body/div[3]/div[3]/div[2]/div/div[2]/div[1]/div[2]/div/button[1]");
    By cuenta_fact_posp= By.xpath("/html/body/div[3]/div[3]/div[2]/div/div[2]/div[1]/div[2]/div/button[2]");
    By boton_crear_nuevacuenta_facturacion_pp= By.xpath("//*[@id=\"ui-id-1\"]/div/div[3]/div/div/div/div/div[1]/button");
    By boton_crear_cf_posp= By.xpath("/html/body/div[6]/div/div/div[2]/div/div[3]/div/div/div/div/div[1]/button");
    ///html/body/div[6]/div/div/div[2]/div/div[3]/div/div/div/div/div[1]/button
    By cuenta_facturacion_creada= By.xpath("/html/body/div[3]/div[3]/div[2]/div/div[2]/div[2]");
    By servicios_lista=By.xpath("/html/body/div[3]/div[3]/div[2]/div/div[1]/div");
    
    By select_cuenta_facturacion= By.xpath("/html/body/div[3]/div[3]/div[2]/div/div[1]/div/div[3]/div/div[2]/div/div[2]/div[1]");
 
    By boton_revision= By.xpath("/html/body/div[3]/div[2]/div[1]/ul/li[4]");
    By boton_contrato= By.xpath("/html/body/div[3]/div[3]/div[1]/div[2]/div/div[2]/div[7]");
    By boton_contrato_confirmar= By.xpath("/html/body/div[7]/div/div/div[3]/div/button[1]");
    By boton_contrato_confirmar2=By.xpath("/html/body/div[8]/div/div/div[3]/div/button[1]");
   ///html/body/div[8]/div/div/div[3]/div/button[1]
    By generar_contrato=By.xpath("/html/body/div[3]/div[3]/div[1]/div[2]/div/div[3]/div[2]/div/table/tbody/tr[2]/td[2]");
    By firmar_contrato=By.xpath("/html/body/div[3]/div[3]/div[1]/div[2]/div/div[3]/div[2]/div/table/tbody/tr[2]/td[2]");
    By boton_confirmar_firma= By.xpath("/html/body/div[9]/div/div/div[2]/div/div[3]/div/div/div/div/div[1]");
    By boton_crearfact= By.xpath("/html/body/div[3]/div[3]/div[1]/div[2]/div/div[2]/div[10]");
    By list_botonenviar= By.xpath("/html/body/div[3]/div[3]/div[1]/div[2]/div/div[2]");
    By boton_enviar= By.xpath("/html/body/div[3]/div[3]/div[1]/div[2]/div/div[2]/div[11]");
    
    By boton_factSinPagar= By.xpath("//button[@class='ui-button ui-widget ui-state-default ui-corner-all ui-button-text-only'][@aria-disabled='false'and span[contains(text(),'Sí')]] ");
    ///html/body/div[7]/div/div/div[3]/div/button[1]
    //class="ui-button ui-widget ui-state-default ui-corner-all ui-button-text-only"
    //aria-disabled="false"
    By estado_so= By.xpath("/html/body/div[6]/div[3]/div[1]/div[2]/div[1]/div[2]/div/form/table/tbody/tr/td/table/tbody/tr[2]/td[2]/div/table/tbody/tr/td/div/div/div");
    By boton_cerrarSO = By.xpath("/html/body/div[3]/div[3]/div[2]/div/div[2]/div[3]");
    By opcion_cambiado= By.xpath("/html/body/div[3]/div[3]/div[2]/div[2]/table/tbody/tr/td[1]/div[2]/div[2]/div[3]");
    By lista_plancambio_regular= By.xpath("/html/body/div[3]/div[3]/div[2]/div[2]/table/tbody/tr/td[1]/div[2]/div[2]/div[3]/div[2]/div/div[1]");
    //html/body/div[3]/div[3]/div[2]/div[2]/table/tbody/tr/td[1]/div[2]/div[2]/div[3]/div[2]/div/div[1]
    By lista_plancambio_controlada= By.xpath("/html/body/div[3]/div[3]/div[2]/div[2]/table/tbody/tr/td[1]/div[2]/div[2]/div[3]/div[2]/div/div[2]");
    By lista_plancambio_prepago= By.xpath("/html/body/div[3]/div[3]/div[2]/div[2]/table/tbody/tr/td[1]/div[2]/div[2]/div[3]/div[2]/div/div[3]");
    By select_SIMCardLost= By.xpath("/html/body/div[3]/div[3]/div[2]/div[2]/table/tbody/tr/td[2]/div/div/div[3]/table[1]/tbody/tr/td/div/div[3]/table/tbody/tr/td/div/div/table/tbody/tr/td/div/div/div/div/div/div[2]/div/div/div/div[2]/div/table/tbody/tr[12]/td[2]/div/div/select");
    By boton_progress = By.xpath("/html/body/div[9]");
    By filtro_SO_nombre = By.xpath("//*[@id=\"9139371752413211533_-1\"]/span[2]");
    By filtro_input_Nombre = By.xpath("//input[@type=\"text\" and @class=\"gwt-TextBox nc-field-text-input\"]");
    By aplicar_Filtro_Nombre = By.xpath("//button[@class=\"TableCtrl-button gwt-ParCtrl-btn\" and contains(text(),'Aplicar')]");
    By body_nombre_orden=By.xpath("/html/body/div[6]/div[3]/div[1]/div[2]/div[1]/div[2]/div/table/tbody[1]");
   
    public CostumerPage() {
       super();
       //dp= new DesconectarPage(new Proceso_Desconexion());
    
        
    }
     public Plan AltaPP(Plan newPlan) throws InterruptedException {
        return AltaPP(newPlan,"");
    }
    public Plan AltaPP(Plan newPlan,String env) throws InterruptedException{
        seleccionar_Canal(newPlan, env);
        seleccionar_PP(newPlan);
        obtener_PPActivo(newPlan, "");
        iccid_MSISDN_PP(newPlan);
    return newPlan;
    
    }
      public Plan AltaPosP(Plan newPlan) throws InterruptedException {
        return get_Type_PlanPos(newPlan, "");
    }
    public Plan AltaPosP(Plan newPlan,String env) throws InterruptedException{
        get_Type_PlanPos(newPlan, env);
    return newPlan;
    
    }
    public Plan get_Type_PlanPos(Plan newPlan,String env) throws InterruptedException{
    
    if(newPlan.getName().contains("PLR")){
        seleccionar_Canal(newPlan, env);
        seleccionar_PosPR(newPlan);
        loading();
        Thread.sleep(5000);
        obtener_PPActivo(newPlan, env);
        iccid_MSISDN_PosPLR(newPlan);
    }
    else{
        seleccionar_Canal(newPlan, env);
        seleccionar_PosPC(newPlan);
        loading();
        Thread.sleep(5000);
        obtener_PPActivo(newPlan, env);
        iccid_MSISDN_PosPLC(newPlan);
    
    }
    return newPlan;
    }
     public Plan cambioPlan(Plan newPlan) throws InterruptedException {
        return cambioPlan(newPlan, "");
     }
    public Plan cambioPlan(Plan newPlan,String env) throws InterruptedException{
        seleccionar_CanalOrder(newPlan, env);
        obtener_PPActivo(newPlan, "");
        cambiar_Plan(newPlan);
        Terminar_Cambio_Plan(newPlan);
    return newPlan;
    }
     public Plan simCardLost(Plan newPlan) throws InterruptedException {
        return simCardlost(newPlan,"");
     }
    public Plan simCardlost(Plan newPlan,String env) throws InterruptedException{
        seleccionar_CanalOrder(newPlan, env);
        obtener_PPActivo(newPlan, env);
        select_SIMCardLost();
    return newPlan;
    }
    /*Para Test_Cliente_solicita_denunciar_la_linea_por_robo_o_perdida*/
   public void seleccionar_CanalOrder(Plan newPlan,String env) throws InterruptedException{
     
       visit("https://noprd-"+env+"-toms.temu.com.uy:7002/platform/csr/customer.jsp?tab=_Sales+Orders+&object="+ newPlan.getObject_id());
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
   public void cambiar_Plan(Plan newPlan) throws InterruptedException{
      
        Wait(opcion_cambiado);
        System.out.println(opcion_cambiado);
        click(opcion_cambiado);
        WebElement select =null;
        System.out.println("nombre plan a cambiar-->"+newPlan.getName_change_plan());
       /* switch (newPlan.getName_change_plan()) {
           case "PP":
               WebElement select = this.Obtener_cambioPP(newPlan.getName_change_plan());
               click(select);
               break;
           case "PLC":
               select= this.Obtener_cambioPLC(newPlan.getName_change_plan());
               click(select);
               break;
           case "PLR":
               select = this.Obtener_cambioPLR(newPlan.getName_change_plan());
               click(select);
               break;
       }*/
       if(newPlan.getName_change_plan().contains("PTT") || (newPlan.getName_change_plan().contains("PLGP")) || (newPlan.getName_change_plan().contains("PLK")) ){
        select = this.Obtener_cambioPP(newPlan.getName_change_plan());
               click(select);
       }
       if(newPlan.getName_change_plan().contains("PLC0") || (newPlan.getName_change_plan().contains("PLC1")) || (newPlan.getName_change_plan().contains("PLC2")) || (newPlan.getName_change_plan().contains("PLC3"))){
       select= this.Obtener_cambioPLC(newPlan.getName_change_plan());
               click(select);
       }
       else{
       select = this.Obtener_cambioPLR(newPlan.getName_change_plan());
               click(select);
       }    
   }
   
     public void Terminar_Cambio_Plan(Plan newPlan) throws InterruptedException{
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
    String so = obtener_nombre_SO();
    Thread.sleep(5000);
   click(boton_cerrarSO);
   obtener_SO(so);
   String url_SO=obtener_urlSO();
   newPlan.setUrlSO(url_SO);
   String statusSO=get_estadoSO(newPlan);
   newPlan.setStatuSO(statusSO);
   newPlan.setName(newPlan.getName()); 
   
   }
    /*Para Test Alta Cliente y Plan*/
      public void initUrlBusqueda(String env){
        if (env.toLowerCase() != "preprod") {
            
            visit("https://noprd-"+env+"-toms.temu.com.uy:7002/ncobject.jsp?id=9155890523813779409&tab=_All+Tasks");
            
        } else
        {
             visit("https://pretoms.temu.com.uy:7002/ncobject.jsp?id=9155890523813779409&tab=_All+Tasks");
        }
        
    }
    public void seleccionar_Canal(Plan newPlan,String env) throws InterruptedException{
        
        //click(recientes);
        visit("https://noprd-"+env+"-toms.temu.com.uy:7002/ncobject.jsp?id="+ newPlan.getObject_id());//9155882510113704246");//fichero Seleccionar cliente
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
        Thread.sleep(2000);
        findElement(botonCrear);
        Wait(botonCrear);
        click(botonCrear);
    }
     

public void seleccionar_PP(Plan newPlan) throws InterruptedException {
   
   loading();
    Wait_element(obtenerList_Planes("PrePagos"));
   click(obtenerList_Planes("PrePagos"));
   Wait(table);
   WebElement tablePP=findElement(table);
   List<WebElement> pp= tablePP.findElements(By.tagName("span"));
            for (int j = 0; j < pp.size(); j++) {
            if(getText(pp.get(j)).contains(newPlan.getName())){//En dependencia de los permisos del usuario podra acceder a diferentes canal de distribucion
                Wait_element(pp.get(j));
                Thread.sleep(4000);
                click(pp.get(j));
                break;
            } 
          }          
 
}
public void seleccionar_PosPC(Plan newPlan) {
   
   Wait_element(obtenerList_Planes("Cuenta Controlada"));
   click(obtenerList_Planes("Cuenta Controlada"));
   Wait(table_plc);
   WebElement tablePP=findElement(table_plc);
   List<WebElement> ppc= tablePP.findElements(By.tagName("span"));
            for (int j = 0; j < ppc.size(); j++) {
            if(getText(ppc.get(j)).contains(newPlan.getName())){//En dependencia de los permisos del usuario podra acceder a diferentes canal de distribucion
                click(ppc.get(j));
                break;
            } 
          }          
 
}
public void seleccionar_PosPR(Plan newPlan) {
   WebElement plr=null;
   Wait_element(obtenerList_Planes("Regulares"));
   click(obtenerList_Planes("Regulares"));
   Wait(table_plr);
   WebElement tablePP=findElement(table_plr);
   List<WebElement> ppc= tablePP.findElements(By.tagName("span"));
            for (int j = 0; j < ppc.size(); j++) {
            if(getText(ppc.get(j)).contains(newPlan.getName())){//En dependencia de los permisos del usuario podra acceder a diferentes canal de distribucion
                plr=ppc.get(j);      
                break;
            } 
          }
            Wait_element(plr);
            click(plr);
 
}

public void obtener_PPActivo(Plan newPlan,String linea) throws InterruptedException{
WebElement ppactivo = null;
    Wait(productosasociados);
    Thread.sleep(5000);   
    WebElement tableproductasociados= findElement(productosasociados);
    List<WebElement> planeContainers = tableproductasociados.findElements(By.tagName("span"));
    for (int i = 0; i < planeContainers.size(); i++) {
        WebElement spanContainer = planeContainers.get(i);
        System.out.println("nombre plan-->"+getText(spanContainer));
        System.out.println("nombre plan entrado-->"+newPlan.getName());
       if (spanContainer.getText().contains(newPlan.getName())) {
           click(spanContainer);
           break;
       }
    }
   }
public void iccid_MSISDN_PP(Plan newPlan) throws InterruptedException{
    
   
   WebElement siguiente=findElement(botonnextaddpp);
    WebElement fact_pago2=obtener_BotonMenu("Facturación y pago");
   // WebElement iccid1=findElement(iccid);
    if(newPlan.getName().contains("PLKMIG")){
        Wait(iccidPPPLKMIG);
        sendKeys(newPlan.getICCID(),iccidPPPLKMIG);
        Thread.sleep(2000);
        findElement(selectICCIDPPPLKMIG);
        click(selectICCIDPPPLKMIG);
        Wait(msidnPPPLKMIG);
        Thread.sleep(4000);
        sendKeys(newPlan.getMSISDN(),msidnPPPLKMIG);
        Thread.sleep(2000);
        findElement(selectmsidnPPPLKMIG);
        click(selectmsidnPPPLKMIG);
    }
    else{
    Wait(iccid);
    sendKeys(newPlan.getICCID(),iccid); // 89598071102044547292
    findElement(seleccionariccid);
    Wait(seleccionariccid);
    Thread.sleep(2000);
    click(seleccionariccid);
    WebElement msisdn1=findElement(msisdn);
   // Wait(msisdn);
    Thread.sleep(4000);
    sendKeys(newPlan.getMSISDN(), msisdn1); // 95728402
    findElement(seleccionarmsisdn);
    Wait(seleccionarmsisdn);
    Thread.sleep(4000);
    click(seleccionarmsisdn);
    }
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
    Thread.sleep(2000);
    click(obtener_botonenviar());
    Thread.sleep(5000);
   if(validar_Deuda()){
                    
                    System.out.println("HAY VALIDAR");
                    Thread.sleep(5000);
                    Wait(boton_cerrarSO);
                    String so = obtener_nombre_SO();
                    System.out.println(obtener_nombre_SO());
                    Thread.sleep(4000);
                    click(boton_cerrarSO);
                    obtener_SO(so);
                    
                } else {
                    System.out.println("NO HAY VALIDAR");
                    Thread.sleep(5000);
                    Wait(boton_cerrarSO);
                    String so = obtener_nombre_SO();
                    System.out.println(obtener_nombre_SO());
                    click(boton_cerrarSO);
                    obtener_SO(so);
                    
                }
         String url_SO=obtener_urlSO();
         newPlan.setUrlSO(url_SO);
         String statusSO=get_estadoSO(newPlan);
         newPlan.setStatuSO(statusSO);
         newPlan.setName(newPlan.getName());            
 }
 public void iccid_MSISDN_PosPLC(Plan newPlan) throws InterruptedException{
    
 
   WebElement siguiente=findElement(botonnextaddpp);
    WebElement fact_pago2=obtener_BotonMenu("Facturación y pago");
    Thread.sleep(2000);
    loading();
    Wait(iccid_posp);
    findElement(iccid_posp);
    sendKeys(newPlan.getICCID(), iccid_posp); // 89598071102044547292
    Wait(seleccionariccid);
    Thread.sleep(2000);
    click(seleccionariccid);
    
    Wait(msidn_posp);
    findElement(msidn_posp);
    Thread.sleep(5000);
    sendKeys(newPlan.getMSISDN(), msidn_posp); // 95728402
    Wait(seleccionarmsisdn);
    Thread.sleep(4000);
    click(seleccionarmsisdn);
    Thread.sleep(4000);
    Wait_element(siguiente);
    siguiente.click();
    Wait_element(fact_pago2);
    Thread.sleep(4000);
    fact_pago2.click();
   
    obtener_factcreada_posp();
   
   Thread.sleep(4000);
    findElement(boton_contrato);
    Wait(boton_contrato);
    click(boton_contrato);
    
    this.confirmarContrato();
    loading();
    Thread.sleep(5000);
    findElement(generar_contrato);
    Wait(generar_contrato);
    click(generar_contrato);
    
     Wait(firmar_contrato);
     findElement(firmar_contrato);
     Thread.sleep(4000);
    click(firmar_contrato);
     Thread.sleep(2000);
     Wait(boton_confirmar_firma);
     findElement(boton_confirmar_firma);
     click(boton_confirmar_firma);
   Wait(boton_crearfact);
     click(boton_crearfact);
    validar_Factura();
    Wait_element(obtener_botonenviar());
    Thread.sleep(2000);
    click(obtener_botonenviar());
    Thread.sleep(5000);
   if(validar_Deuda()){
                    
                    System.out.println("HAY VALIDAR");
                    Thread.sleep(5000);
                    Wait(boton_cerrarSO);
                    String so = obtener_nombre_SO();
                    System.out.println(obtener_nombre_SO());
                    Thread.sleep(4000);
                    click(boton_cerrarSO);
                    obtener_SO(so);
                    
                } else {
                    System.out.println("NO HAY VALIDAR");
                    Thread.sleep(5000);
                    Wait(boton_cerrarSO);
                    String so = obtener_nombre_SO();
                    System.out.println(obtener_nombre_SO());
                    click(boton_cerrarSO);
                    obtener_SO(so);
                    
                }
         String url_SO=obtener_urlSO();
         newPlan.setUrlSO(url_SO);
         String statusSO=get_estadoSO(newPlan);
         newPlan.setStatuSO(statusSO);
         newPlan.setName(newPlan.getName());  
 }
 
 
 
public void iccid_MSISDN_PosPLR(Plan newPlan) throws InterruptedException{
    
 
   WebElement siguiente=findElement(botonnextaddpp);
   WebElement fact_pago2=obtener_BotonMenu("Facturación y pago");
    
    
    Wait(iccid_plr);
    sendKeys(newPlan.getICCID(), iccid_plr); // 89598071102044547292
    Wait(seleccionariccid);
    Thread.sleep(2000);
    click(seleccionariccid);
    findElement(msidn_posplr);
    Wait(msidn_posplr);
    Thread.sleep(4000);
   sendKeys(newPlan.getMSISDN(), msidn_posplr); // 95728402
    Wait(seleccionarmsisdn);
    Thread.sleep(4000);
    click(seleccionarmsisdn);
    Thread.sleep(6000);
    Wait_element(siguiente);
    Thread.sleep(4000);
    siguiente.click();
    Wait_element(fact_pago2);
    Thread.sleep(6000);
    fact_pago2.click();
    
    obtener_factcreada_posp();
    
    Wait(boton_contrato);
    Thread.sleep(4000);
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
    Thread.sleep(2000);
    click(obtener_botonenviar());
    Thread.sleep(5000);
   if(validar_Deuda()){
                    
                    System.out.println("HAY VALIDAR");
                    Thread.sleep(5000);
                    Wait(boton_cerrarSO);
                    String so = obtener_nombre_SO();
                    System.out.println(obtener_nombre_SO());
                    Thread.sleep(4000);
                    click(boton_cerrarSO);
                    obtener_SO(so);
                    
                } else {
                    System.out.println("NO HAY VALIDAR");
                    Thread.sleep(5000);
                    Wait(boton_cerrarSO);
                    String so = obtener_nombre_SO();
                    System.out.println(obtener_nombre_SO());
                    click(boton_cerrarSO);
                    obtener_SO(so);
                    
                }
         String url_SO=obtener_urlSO();
         newPlan.setUrlSO(url_SO);
         String statusSO=get_estadoSO(newPlan);
         newPlan.setStatuSO(statusSO);
         newPlan.setName(newPlan.getName());  
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

public Boolean validar_Deuda()
{
   Boolean ret=false;
    try{
   
    By button_yes = By.xpath("//button[@aria-disabled='false' and span[contains(text(),'Sí')]]"); //(/html/body/div[8]/div/div/div[3]/div/button[1]");
    WebElement boton= findElement(button_yes);
   
     
        System.out.println("boton cartel deuda-->"+boton);
 
        if (boton!= null) {
           
                    click(boton);
                    ret=true;
                    
                 }
                    
                 }catch (NoSuchElementException e)
                     {
                         System.out.println(e);
                     }
        System.out.println("valor retorno Validad Deuda-->"+ret);
        return ret;
 
        }
        
public void validar_Factura() throws InterruptedException
{//metodo utilizado
By nombre_clase_boton_validar_factura_disabled=By.xpath("//div[@class='tfn_button_panel disabled'  and a[contains(text(),'Nueva factura')]]");
WebElement validar_fact_disable = null;
By nombre_clase_boton_validar_factura=By.xpath("//div[@class='tfn_button_panel'  and a[contains(text(),'Validar factura')]]");
WebElement validar_fact = null;
By nombre_clase_boton_nueva_factura_enabled=By.xpath("//div[@class='tfn_button_panel'  and a[contains(text(),'Nueva factura')]]");
WebElement nueva_fact_enable = null;


int i=0;
    
    loading();
    
    while (validar_fact_disable == null) {
                i++;       
                
                System.out.println("Validar factura: "+i);
                
                try{
                    nueva_fact_enable = findElement(nombre_clase_boton_nueva_factura_enabled);
                    click(nueva_fact_enable);
                 }catch (NoSuchElementException e)
                     {
                         System.out.println("No se encuentra boton nueva factura "+nombre_clase_boton_nueva_factura_enabled.toString());
                     }
                try{
                    loading();
                } catch (StaleElementReferenceException e)
                {
                    System.out.println(e);
                }catch (NoSuchElementException e)
                {
                    System.out.println("error en loading NoSuchElementException"+nombre_clase_boton_nueva_factura_enabled.toString());
                }
                
                try{
                    validar_fact = findElement(nombre_clase_boton_validar_factura);
                    click(validar_fact);
                 }catch (NoSuchElementException e)
                     {
                         System.out.println("No se encuentra boton nueva factura "+nombre_clase_boton_validar_factura.toString());
                     }
                try{
                    loading();
                } catch (StaleElementReferenceException e)
                {
                    System.out.println(e);
                }catch (NoSuchElementException e)
                {
                    System.out.println("error en loading NoSuchElementException");
                }
                
                try{
                    validar_fact_disable = findElement(nombre_clase_boton_validar_factura_disabled);
                 }catch (NoSuchElementException e)
                     {
                         System.out.println("No se encuentra boton nueva factura "+nombre_clase_boton_validar_factura_disabled.toString());
                     }
            }
}
public boolean esta_configurar_Contrato() throws InterruptedException
{//metodo utilizado

By nombre_clase_boton_configurar_contrato=By.xpath("//div[@class='tfn_button_panel' and a[contains(text(),'Configurar contratos')]][@style='display: none;']");
WebElement config_contract = null;
boolean ret = true;
//    loading();
    try{
        Wait(nombre_clase_boton_configurar_contrato);
        config_contract = findElement(nombre_clase_boton_configurar_contrato);
        
        ret = false;
    }catch (NoSuchElementException e)//button[@class="ui-button-icon-primary ui-icon ui-icon-closethick" and span[contains(text(),'Desconectar')]]
    {
        System.out.println(e);
    }catch (TimeoutException e)
    {
        System.out.println(e);
    }
    
    return ret;
    
}


            

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
        WebElement boton_rev= findElement(boton_revision1);
        click(boton_rev);
            
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
     public String obtener_urlSO(){
        String url =driver.getCurrentUrl();
        return url;
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
  public String get_estadoSO(Plan newPlan){
          
          String urlso=newPlan.getUrlSO();
          visit(urlso);
          String so="";
          Wait(estado_so);
          WebElement sos=findElement(estado_so);
          List<WebElement>div_SO= sos.findElements(By.tagName("span"));
          for (int i = 0; i < div_SO.size(); i++) {
              so=getText(div_SO.get(i));

          }
          
          return so;
      }
   public String obtener_nombre_SO(){
        WebElement nombre_so = findElement(nombre_orden_venta);
        String nombre_orden= getText(nombre_so);
        System.out.println("nombre SO"+ nombre_orden);
        return nombre_orden.substring(0, 30);
    }

}



   

