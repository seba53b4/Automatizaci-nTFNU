/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pages;

import Utils.CadenaUtils;
import Utils.Plan;
import java.util.List;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.TimeoutException;


/**
 *
 * @author sdominguez
 */
public class CostumerPage extends Base.BasePage{
   
    By menu= By.xpath("//*[@id=\\\"menuItem_0\\\"]/ul/li[1]/a/span");
    By SO= By.linkText("Órdenes de Venta");
    By nuevaSO= By.xpath("//button[contains(text(),'Nueva orden de venta')]");
    By canaldistribucion= By.className("refsel_single");
    By combobox= By.className("refsel_table");
    By pruebacanal= By.cssSelector("#id_refsel1613764204_div > div > input");
    By elementoAgente= By.xpath("//*[@id=\"id_refsel1965777193_div\"]/div/input");
    By stringAgente= By.xpath("//*[@id=\"nc_refsel_list\"]/div[2]/div[1]/div[1]/div[1]");
    By recientes = By.xpath("//*[@id=\"gen_menu_3\"]");
    By botonCrear= By.xpath("//button[@class='TableCtrl-button ParCtrl-editButton' and contains(text(),'Crear')]");
    By Lis_planes= By.cssSelector("  body > div.wizard_layout.header_visible > div.content_wrapper.open_right > div:nth-child(3) > div.center_col > table > tbody > tr > td > table > tbody > tr > td:nth-child(1) > div > div:nth-child(3)");
    By nombre_orden_venta= By.xpath("//div[@class='roe-widget-header' and h1[contains(text(),'SO')]]");
    By seleccionPP= By.cssSelector("td:nth-child(1) > .box_selection .roe-widget-content:nth-child(2) .roe-widget-header__sh-inner");
    By table= By.xpath("/html/body/div[3]/div[3]/div[2]/div[2]/table/tbody/tr/td/table/tbody/tr/td[1]/div/div[3]/div[2]/table");
    By table_plc= By.xpath("//div[div[@class='roe-widget-header__sh-inner' and contains(text(),'Cuenta Controlada')]]//following-sibling::table");
    By table_plr = By.xpath("//div[div[@class=\"roe-widget-header__sh-inner\" and contains(text(),'Regulares')]]//following-sibling::table");
    By tabla_cuenta_controlada=By.xpath("//div[@class='roe-widget-header__sh-inner _hidden' and contains(text(),'Cuenta Controlada')]");
    By productosasociados=By.cssSelector("body > div.wizard_layout.header_visible > div.content_wrapper.open_right > div:nth-child(3) > div.left_col > div.left_col__inner > div.left_col__inner-wrap > div:nth-child(2)");
    By seleccionarPLTEJ=By.className("roe-widget-content");
    By msisdn = By.xpath("//td[@class=\"cell name\"]/.//span[contains(text(),'MSISDN')]//following::input[2]");
    By msidn_posp= By.xpath("/html/body/div[3]/div[3]/div[2]/div[2]/table/tbody/tr/td[2]/div/div/div[3]/table[1]/tbody/tr/td/div/div[3]/table/tbody/tr/td/div/div/table/tbody/tr/td/div/div/div/div/div/div[2]/div/div/div/div[2]/div/table/tbody/tr[8]/td[2]/div/span/div/div/div[1]/input");
    By msidn_posplr=By.xpath("/html/body/div[3]/div[3]/div[2]/div[2]/table/tbody/tr/td[2]/div/div/div[3]/table[1]/tbody/tr/td/div/div[3]/table/tbody/tr/td/div/div/table/tbody/tr/td/div/div/div/div/div/div[2]/div/div/div/div[2]/div/table/tbody/tr[10]/td[2]/div/span/div/div/div[1]/input");
    By seleccionarmsisdn= By.xpath("/html/body/div[4]/div[2]/div[1]/div");
    By iccidPPPLKMIG= By.xpath("/html/body/div[3]/div[3]/div[2]/div[2]/table/tbody/tr/td[2]/div/div/div[3]/table[1]/tbody/tr/td/div/div[3]/table/tbody/tr/td/div/div/table/tbody/tr/td/div/div/div/div/div/div[4]/div/div/div/div[2]/div/table/tbody/tr[8]/td[2]/div/div/div/div[1]/input");
    By selectICCIDPPPLKMIG=By.xpath("/html/body/div[4]/div[2]/div[1]/div[1]");
    By msidnPPPLKMIG=By.xpath("/html/body/div[3]/div[3]/div[2]/div[2]/table/tbody/tr/td[2]/div/div/div[3]/table[1]/tbody/tr/td/div/div[3]/table/tbody/tr/td/div/div/table/tbody/tr/td/div/div/div/div/div/div[4]/div/div/div/div[2]/div/table/tbody/tr[9]/td[2]/div/span/div/div/div[1]/input");
    By selectmsidnPPPLKMIG=By.xpath("/html/body/div[4]/div[2]/div[1]/div");
    By iccid= By.xpath("//td[@class=\"cell name\"]/.//span[contains(text(),'ICCID')]//following::input[2]");
    By iccid_posp=By.xpath("//td[@class=\"cell name\"]/.//span[contains(text(),'ICCID')]//following::input[2]");
    By iccid_plr= By.xpath("//td[@class=\"cell name\"]/.//span[contains(text(),'ICCID')]//following::input[2]");
    By seleccionariccid= By.xpath("/html/body/div[4]/div[2]/div[1]/div");
    By reparacion_pantalla= By.xpath("/html/body/div[3]/div[3]/div[2]/div[2]/table/tbody/tr/td[2]/div/div/div[3]/table[1]/tbody/tr/td/div/div[3]/table/tbody/tr/td/div/div/table/tbody/tr/td/div/div");
    By botonnextaddpp=By.cssSelector("body > div.wizard_layout.header_visible > div.top_line_2 > div.breadcrumbs > div.prev_next_box > div:nth-child(2)");
    By botonfact_pago = By.xpath("//a[@class=\"gwt-InlineHyperlink roe-pathList\"][@href=\"#payment\" and contains(text(),'Facturación y pago')]");
    By boton_revision1=By.xpath("//a[@class='gwt-InlineHyperlink roe-pathList'][@href=\"#review\" and contains(text(),'Revisión')]");
    By cuenta_facturacion=By.xpath("//button[contains(text(),'Nueva cuenta de facturación pre-pago')]");
    By cuenta_fact_posp= By.xpath("//button[contains(text(),'Nueva cuenta de facturación post-pago')]");
    By boton_crear_nuevacuenta_facturacion_pp= By.xpath("//button[@class=\"TableCtrl-button ParCtrl-editButton\" and contains(text(),'Crear')]");
    By boton_crear_cf_posp=By.xpath("//button[@class=\"TableCtrl-button ParCtrl-editButton\" and contains(text(),'Crear ')][1]");
    By cuenta_facturacion_creada= By.xpath("/html/body/div[3]/div[3]/div[2]/div/div[2]/div[2]");
    By servicios_lista=By.xpath("/html/body/div[3]/div[3]/div[2]/div/div[1]/div");
    By select_cuenta_facturacion= By.xpath("/html/body/div[3]/div[3]/div[2]/div/div[1]/div/div[3]/div/div[2]/div/div[2]/div[1]");
    By boton_revision= By.xpath("//a[@class='gwt-InlineHyperlink roe-pathList'][@href='#review' and contains(text(),'Revisión')]");
    By boton_contrato = By.xpath("/html/body/div[3]/div[3]/div[1]/div[2]/div/div[2]/div[7]");
    By boton_contrato_confirmar= By.xpath("//span[@class='ui-button-text' and contains(text(),'Confirmar')]");
    By boton_contrato_confirmar2=By.xpath("/html/body/div[8]/div/div/div[3]/div/button[1]");
    By boton_confirmar_firma= By.xpath("//a[@href='#' and contains(text(),'Firmar')]");
    By boton_guardar_firma=By.xpath("//button[@class='TableCtrl-button ParCtrl-editButton' and contains(text(),'Guardar')]");
    By list_botonenviar= By.xpath("/html/body/div[3]/div[3]/div[1]/div[2]/div/div[2]");
    By boton_enviar= By.xpath("//div[@class=\"tfn_button_panel_submit\" and a[contains(text(),'Enviar')]]");
    By boton_factSinPagar= By.xpath("//button[@class='ui-button ui-widget ui-state-default ui-corner-all ui-button-text-only'][@aria-disabled='false'and span[contains(text(),'Sí')]] ");
    By estado_so= By.xpath("//td[div[contains(text(),'Estado de cumplimiento')]]//following-sibling::td[1]");// "//td[div[contains(text(),\"Estado\")]]/following-sibling::td");
    By boton_cerrarSO = By.xpath("//div[@class=\"box_bottom close\"]/a[contains(text(),'Cerrar')]");
    By opcion_cambiado= By.xpath("//h1[contains(text(),'Cambiado a')]");
    By lista_plancambio_regular= By.xpath("/html/body/div[3]/div[3]/div[2]/div[2]/table/tbody/tr/td[1]/div[2]/div[2]/div[3]/div[2]/div/div[1]");
    By lista_plancambio_controlada= By.xpath("/html/body/div[3]/div[3]/div[2]/div[2]/table/tbody/tr/td[1]/div[2]/div[2]/div[3]/div[2]/div/div[2]");
    By lista_plancambio_prepago= By.xpath("/html/body/div[3]/div[3]/div[2]/div[2]/table/tbody/tr/td[1]/div[2]/div[2]/div[3]/div[2]/div/div[3]");
    By select_SIMCardLost= By.xpath("//td[@class=\"cell name\"]/.//span[contains(text(),'SIM Card Lost')]//following::select[1]");
    By boton_progress = By.xpath("/html/body/div[9]");
    By filtro_SO_nombre = By.xpath("//*[@id=\"9139371752413211533_-1\"]/span[2]");
    By filtro_input_Nombre = By.xpath("//input[@type=\"text\" and @class=\"gwt-TextBox nc-field-text-input\"]");
    By aplicar_Filtro_Nombre = By.xpath("//button[@class=\"TableCtrl-button gwt-ParCtrl-btn\" and contains(text(),'Aplicar')]");
    By body_nombre_orden=By.xpath("/html/body/div[6]/div[3]/div[1]/div[2]/div[1]/div[2]/div/table/tbody[1]");
    By link_generar_doc= By.xpath("//a[@href and contains(text(),\"Generar documento\")]");
    By seleccionar_agente_esoecialista=By.xpath("//div[@class=\"refsel_name\"][1]");
    By lista_pp=By.xpath("//div[@class=\"roe-widget-header__sh-inner _hidden\" and contains(text(),'PrePagos')]");
    By lista_plr=By.xpath("//div[@class=\"roe-widget-header__sh-inner _hidden\" and contains(text(),'Regulares')]");
    By btn_approve_desactivado = By.xpath("//a[contains(text(),'Approve') and @style=\"display: none;\"]");
    By btn_approve_activado = By.xpath("//a[contains(text(),'Approve')]");
    By cambio_tarjeta_sim=By.xpath("//div[@class='expand-btn-container']/following::span[contains(text(),\"El cambio de la tarjeta SIM\")]");
    
    private static CostumerPage  cp; 
    
    public CostumerPage() {
       super();     
    }
    
    public static CostumerPage getInstance(){
        if (cp == null) {
            cp = new CostumerPage();
        }
        return cp;
    }
    
    
     public Plan AltaPP(Plan newPlan) throws InterruptedException {
        return AltaPP(newPlan,"");
    }
    public Plan AltaPP(Plan newPlan,String env) throws InterruptedException{
        
        seleccionar_Canal(newPlan, env);
        loading();
        seleccionar_PP(newPlan);
        loading();
        obtener_PPActivo(newPlan, "");
        loading();
        Thread.sleep(250);
        alta_PP(newPlan);
        
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
        loading();
        seleccionar_PosPR(newPlan);
        loading();
        Thread.sleep(500);
        obtener_PPActivo(newPlan, env);
        loading();
        alta_PLR(newPlan);
    }
    else{
        seleccionar_Canal(newPlan, env);
        seleccionar_PosPC(newPlan);
        loading();
        Thread.sleep(500);
        obtener_PPActivo(newPlan, env);
        loading();
        alta_PLC(newPlan);
    
    }
    return newPlan;
    }
     public Plan cambioPlan(Plan newPlan) throws InterruptedException {
        return cambioPlan(newPlan, "");
     }
     
    public Plan cambioPlan(Plan newPlan,String env) throws InterruptedException{
        seleccionar_CanalOrder(newPlan, env);
        loading();
        obtener_PPActivo(newPlan, "");
        loading();
        cambiar_Plan(newPlan);
        loading();
        Thread.sleep(1000);
        Terminar_Cambio_Plan(newPlan);
    return newPlan;
    }
     public Plan simCardLost(Plan newPlan) throws InterruptedException {
        return simCardlost(newPlan,"");
     }
    public Plan simCardlost(Plan newPlan,String env) throws InterruptedException{
        seleccionar_CanalOrder(newPlan, env);
        loading();
        obtener_PPActivo(newPlan, env);
        loading();
        simCardLost(newPlan,"Yes");
        loading();
        
        Terminar(newPlan);
    return newPlan;
    }
       // CAMBIO DE USIM
 
   public Plan cambiarUSIM(Plan plan,String env) throws InterruptedException{
       
        seleccionar_CanalOrder(plan, plan.getAmbiente());
        loading();
        obtener_PPActivo(plan, "");
        loading();
        changeUSIM(plan);
        return plan;
        
   }
   
   public void changeUSIM(Plan plan) throws InterruptedException{
       
       Wait_Click(cambio_tarjeta_sim);
       click(cambio_tarjeta_sim);
       Thread.sleep(2000);
       loading();
       Wait(iccid);
       WebElement iccid=findElement(this.iccid);
       iccid.clear();
       loading();
       sendKeys(plan.getName_change_sim(), this.iccid);//Keys.chord(Keys.CONTROL, "a"), "55"
       Thread.sleep(200);
       Wait_Click(seleccionariccid);
       click(seleccionariccid);
       loading();
       Wait_Click(boton_revision);
       Thread.sleep(500);
       click(boton_revision);
       validar_Factura();
       cerrarProcesoSO(plan,false);
       
             
       
   } 
   //FIN CAMBIO DE USIM
    
    /*Para Test_Cliente_solicita_denunciar_la_linea_por_robo_o_perdida*/
   public void seleccionar_CanalOrder(Plan newPlan,String env) throws InterruptedException{
      if(env.equals("preprod")){
      visit("https://pretoms.temu.com.uy/platform/csr/customer.jsp?tab=_Sales+Orders+&object="+ newPlan.getObject_id());
      
      }
      else{
       visit("https://noprd-"+env+"-toms.temu.com.uy:7002/platform/csr/customer.jsp?tab=_Sales+Orders+&object="+ newPlan.getObject_id());
      }
        
        Wait_Click(nuevaSO);
        click(nuevaSO);
        Wait_Click(canaldistribucion);
        Thread.sleep(400);
        click(canaldistribucion);
        Thread.sleep(200);
        Wait_Click(seleccionar_agente_esoecialista);
        click(seleccionar_agente_esoecialista);
        Wait_Click(botonCrear);
        click(botonCrear);      
   }
   
   public void simCardLost(Plan newPlan,String str) throws InterruptedException{
       
       Thread.sleep(250);
       Wait_Click(select_SIMCardLost);
       click(select_SIMCardLost);
       WebElement simPosp = findElement(select_SIMCardLost);
       Thread.sleep(500);
       List<WebElement>lista_simPosp=simPosp.findElements(By.tagName("option"));
       for(int i=0;i<lista_simPosp.size();i++){
           if(lista_simPosp.get(i).getText().contains(str)){//En dependencia de los permisos del usuario podra acceder a diferentes canal de distribucion
               WebElement simcardlost=lista_simPosp.get(i);
               click(simcardlost);
               break;
           }
       }
   }
 
      
   public void Terminar(Plan newPlan) throws InterruptedException{
       
       Thread.sleep(400);
       Wait_Click(boton_revision);
       click(boton_revision);
       cerrarProcesoSO(newPlan,false);
       
   }
   
   /*Cambio Plan*/
   public void cambiar_Plan(Plan newPlan) throws InterruptedException{
       
       Thread.sleep(500);
       Wait_Click(opcion_cambiado);
       Thread.sleep(500);
       click(opcion_cambiado);
       loading();
       WebElement select =null;
       System.out.println("nombre plan a cambiar-->"+newPlan.getName_change_plan());
       
       if(CadenaUtils.compararCadenas("PLTT", newPlan.getName_change_plan()) || (CadenaUtils.compararCadenas("PLGPKA", newPlan.getName_change_plan())) || 
               (CadenaUtils.compararCadenas("PLK", newPlan.getName_change_plan())) ){
           select = this.Obtener_cambioPP(newPlan.getName_change_plan());
           click(select);
           
       }
       else  if(CadenaUtils.compararCadenas("C0",newPlan.getName_change_plan()) || (CadenaUtils.compararCadenas("C1",newPlan.getName_change_plan()) ) || 
               (CadenaUtils.compararCadenas("C2",newPlan.getName_change_plan()) ) || CadenaUtils.compararCadenas("C3",newPlan.getName_change_plan()) 
               || CadenaUtils.compararCadenas("PLG",newPlan.getName_change_plan()) ) {
           select= this.Obtener_cambioPLC(newPlan.getName_change_plan());
           click(select);
       }
       else{
           select = this.Obtener_cambioPLR(newPlan.getName_change_plan());
           click(select);
       }
       loading();
   }
   
   public void Terminar_Cambio_Plan(Plan newPlan) throws InterruptedException{
       
       Wait(botonfact_pago);
       Thread.sleep(400);
       click(botonfact_pago);
       
       if(getTypePlan(newPlan.getName()).equals("prepago") && getTypePlan(newPlan.getName_change_plan()).equals("pospago")){
           obtener_factcreada_posp();
       }
       
       if(getTypePlan(newPlan.getName()).equals("pospago") && getTypePlan(newPlan.getName_change_plan()).equals("prepago")){
           obtener_factcreada_pp_cambio();
       }
       Wait_Click(boton_revision);
       Thread.sleep(500);
       click(boton_revision);
       Thread.sleep(400);
       
       if (esta_configurar_Contrato()) {
           loading();
           click(boton_contrato);
           Thread.sleep(300);
           confirmarContrato();
           loading();
           WebElement approve = buscarElement(btn_approve_desactivado, 2);
           
           if (approve == null) {
               approve = buscarElement(btn_approve_activado, 1);
               click(approve);
           } else {
               
               Wait(link_generar_doc);
               Thread.sleep(500);
               click(link_generar_doc);
               loading();
               Thread.sleep(800);
               Wait(boton_confirmar_firma);
               click(boton_confirmar_firma);
               loading();
               Thread.sleep(400);
               Wait_Click(boton_guardar_firma);
               click(boton_guardar_firma);
               loading();
           }
       }
      
       if(getTypePlan(newPlan.getName()).equals("pospago") && getTypePlan(newPlan.getName_change_plan()).equals("prepago")){
           validar_Factura();
       }
       
       loading();
       WebElement wb = buscarElement(boton_enviar, 2);
       if (wb != null) {
            Thread.sleep(5000);
            click(boton_enviar);
       }
           
       loading();
       
       validar_Deuda();
        
       cerrarProcesoSO(newPlan, false);
      
       
   }
   /*Para Test Alta Cliente y Plan*/
  
   public void seleccionar_Canal(Plan newPlan,String env) throws InterruptedException{
       
       //click(recientes);
       if (!env.toLowerCase().contains("preprod") ) {
           
           visit("https://noprd-"+env+"-toms.temu.com.uy:7002/ncobject.jsp?id="+ newPlan.getObject_id());
           
       } else
       {
           visit("https://pretoms.temu.com.uy/ncobject.jsp?id="+ newPlan.getObject_id());
       }
       Thread.sleep(500);
       Wait_Click(SO);
       click(SO);
       Wait_Click(nuevaSO);
       click(nuevaSO);
       Thread.sleep(400);
       Wait_Click(canaldistribucion);
       click(canaldistribucion);
       Thread.sleep(300);
       Wait_Click(seleccionar_agente_esoecialista);
       click(seleccionar_agente_esoecialista);
       Thread.sleep(200);
       Wait_Click(botonCrear);
       click(botonCrear);
   }
     

   public void seleccionar_PP(Plan newPlan) throws InterruptedException {
       
       loading();
       Wait_Click(lista_pp);
       click(lista_pp);
       Wait(table);
       WebElement tablePP=findElement(table);
       List<WebElement> pp= tablePP.findElements(By.tagName("span"));
       for (int j = 0; j < pp.size(); j++) {
           if(getText(pp.get(j)).contains(newPlan.getName())){//En dependencia de los permisos del usuario podra acceder a diferentes canal de distribucion
               Thread.sleep(250);
               click(pp.get(j));
               break;
           }
       }
       
   }
   
   public void seleccionar_PosPC(Plan newPlan) throws InterruptedException {
       
       //Wait_element(obtenerList_Planes("Cuenta Controlada"));
       //Thread.sleep(2000);
       Wait_Click(tabla_cuenta_controlada);
       Thread.sleep(5000);
       click(tabla_cuenta_controlada);
       Wait(table_plc);
       WebElement tablePP = findElement(table_plc);
       List<WebElement> ppc= tablePP.findElements(By.tagName("span"));
       for (int j = 0; j < ppc.size(); j++) {
           if(ppc.get(j).getText().contains(newPlan.getName())){//En dependencia de los permisos del usuario podra acceder a diferentes canal de distribucion
               click(ppc.get(j));
               break;
           }
       }
       
   }
   public void seleccionar_PosPR(Plan newPlan) throws InterruptedException {
       WebElement plr=null;
       Wait_Click(lista_plr);
       click(lista_plr);
       Wait(table_plr);
       WebElement tablePP=findElement(table_plr);
       List<WebElement> ppc= tablePP.findElements(By.tagName("span"));
       for (int j = 0; j < ppc.size(); j++) {
           if(ppc.get(j).getText().contains(newPlan.getName())){//En dependencia de los permisos del usuario podra acceder a diferentes canal de distribucion
               plr=ppc.get(j);
               break;
           }
       }
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
           if (spanContainer.getText().contains(newPlan.getName())) {
               click(spanContainer);
               break;
           }
       }
   }

   public void alta_PP(Plan newPlan) throws InterruptedException{
    
    
    WebElement siguiente=findElement(botonnextaddpp);
    
    if(newPlan.getName().contains("PLKMIG")){
        Wait(msidnPPPLKMIG);
        sendKeys(newPlan.getMSISDN(),msidnPPPLKMIG);
        Thread.sleep(250);
        //findElement(selectmsidnPPPLKMIG);
        Wait_Click(selectmsidnPPPLKMIG);
        click(selectmsidnPPPLKMIG);
        loading();
        Thread.sleep(250);
        Wait(iccidPPPLKMIG);
        sendKeys(newPlan.getICCID(),iccidPPPLKMIG);
        Thread.sleep(250);
        //findElement(selectICCIDPPPLKMIG);
        Wait_Click(selectICCIDPPPLKMIG);
        click(selectICCIDPPPLKMIG);
        
    }
    else{
        
        Wait(msisdn);
        Thread.sleep(250);
        System.out.println("Numero a agregar "+ newPlan.getMSISDN());
        sendKeys(newPlan.getMSISDN(), msisdn);
        Thread.sleep(250);
        Wait_Click(seleccionarmsisdn);
        click(seleccionarmsisdn);
        Thread.sleep(250);
        loading();
        Wait(iccid);
        Thread.sleep(250);
        sendKeys(newPlan.getICCID(),iccid); // 89598071102044547292
        Wait_Click(seleccionariccid);
        click(seleccionariccid);
        Thread.sleep(250);
        
    }
    
    // Facturacion y Pago - Proceso de Creacion de Factura
    loading();
    
    Wait_Click(botonfact_pago);
    Thread.sleep(250);
    click(botonfact_pago);
    
    obtener_factcreada_pp();
    Thread.sleep(250);
    // Revision - Validar Factura
    
    System.out.println("Entra a Validar");
    validar_Factura();
    System.out.println("Sale Validar");
    
    WebElement btn_enviar = null;
    try{
        btn_enviar = findElement(boton_enviar);
    } catch (NoSuchElementException e){
        System.out.println("elemento no localizado el enviar");
    }
    
    if (btn_enviar != null) {
        System.out.println("Entra en enviar");
        click(btn_enviar);
        System.out.println("Sale de enviar");
    }else {
        System.out.println("El boton enviar ya fue clickeado");
    }
    
    validar_Deuda();
    
    cerrarProcesoSO(newPlan,true);        
 }
 
   public void alta_PLC(Plan newPlan) throws InterruptedException{
     
     WebElement siguiente = Wait(botonnextaddpp);
     WebElement fact_pago2=findElement(botonfact_pago);
     
     loading();
     Wait(msidn_posp);
     
     Thread.sleep(250);
     sendKeys(newPlan.getMSISDN(), msidn_posp); // 95728402
     
     Thread.sleep(250);
     Wait_Click(seleccionarmsisdn);
     click(seleccionarmsisdn);
     loading();
     Wait(iccid_posp);
     //findElement(iccid_posp);
     sendKeys(newPlan.getICCID(), iccid_posp); // 89598071102044547292
     //Wait(seleccionariccid);
     Thread.sleep(250);
     Wait_Click(seleccionariccid);
     click(seleccionariccid);
     Thread.sleep(250);
     // Facturacion y pago
     loading();
     
     click(fact_pago2);
     
     obtener_factcreada_posp();
     Thread.sleep(400);
     
     // REvision
     Thread.sleep(250);
     Wait_Click(boton_contrato);
     click(boton_contrato);
     Thread.sleep(250);
     
     this.confirmarContrato();
     Thread.sleep(250);
     Wait_Click(link_generar_doc);
     click(link_generar_doc);
     Thread.sleep(250);
     Wait_Click(boton_confirmar_firma);
     click(boton_confirmar_firma);
     
     Wait_Click(boton_guardar_firma);
     click(boton_guardar_firma);
     loading();
     
     System.out.println("Entra a Validar factura");
     validar_Factura();
     System.out.println("Sale Validar factura");
     
     Thread.sleep(250);
     validar_Deuda();
     cerrarProcesoSO(newPlan,true);
 }
  
public void alta_PLR(Plan newPlan) throws InterruptedException{
    
    WebElement siguiente=findElement(botonnextaddpp);
    WebElement fact_pago2=findElement(botonfact_pago);
    //Thread.sleep(500);
    Wait(msidn_posplr);
    Thread.sleep(500);
    sendKeys(newPlan.getMSISDN(), msidn_posplr); // 95728402
    Thread.sleep(200);
    Wait_Click(seleccionarmsisdn);
    click(seleccionarmsisdn);
    loading();
    Thread.sleep(600);
    Wait(iccid_plr);
    Thread.sleep(500);
    sendKeys(newPlan.getICCID(), iccid_plr); // 89598071102044547292
    //Thread.sleep(2000);
    loading();
    Wait_Click(seleccionariccid);
    click(seleccionariccid);
    Thread.sleep(150);
    
    //Facturacion y pago
    loading();
    click(fact_pago2);
    obtener_factcreada_posp();
    Thread.sleep(400);
    // Revision
    Wait_Click(boton_contrato);
    click(boton_contrato);
    Thread.sleep(250);
    confirmarContrato();
    
    Thread.sleep(250);
    Wait_Click(link_generar_doc);
    click(link_generar_doc);
    Thread.sleep(250);
    Wait_Click(boton_confirmar_firma);
    click(boton_confirmar_firma);
    
    Wait_Click(boton_guardar_firma);
    click(boton_guardar_firma);
    loading();
    
    System.out.println("Entra a Validar Factura");
    validar_Factura();
    System.out.println("Sale Validar Factura");
    cerrarProcesoSO(newPlan,true);
    
 } 


public void cerrarProcesoSO(Plan newPlan, boolean especial) throws InterruptedException{
    
    WebElement btn_enviar = null;
    
    try{
        Thread.sleep(2000);
        btn_enviar = findElement(boton_enviar);
    } catch (NoSuchElementException e){
        System.out.println("elemento no localizado el enviar");
    }
    
    if (btn_enviar != null) {
        System.out.println("Entra en enviar");
        click(boton_enviar);
        validar_Deuda();
        System.out.println("Sale de enviar");
    }else {
        System.out.println("El boton enviar ya fue clickeado");
    }
    if (especial) {
        // Caso - Enunciado completo "Modificacion So#123123123 ha sido enviada"
        Thread.sleep(600);
        String so = obtener_nombre_SO();
        System.out.println(obtener_nombre_SO());
        Thread.sleep(250);
        Wait_Click(boton_cerrarSO);
        click(boton_cerrarSO);
        obtener_SO(so);
        String url_SO=obtener_urlSO();
        newPlan.setUrlSO(url_SO);
        String statusSO=get_estadoSO();
        newPlan.setStatuSO(statusSO);
        newPlan.setName(newPlan.getName());
        
    } else {
         // Caso - Enunciado simple "SO #123123123"
        //Wait(boton_cerrarSO);
        String so = obtener_nombre_SO_CambioPlan();
        Thread.sleep(500);
        Wait_Click(boton_cerrarSO);
        click(boton_cerrarSO);
        obtener_SO(so);
        String url_SO=obtener_urlSO();
        newPlan.setUrlSO(url_SO);
        String statusSO= get_estadoSO();
        newPlan.setStatuSO(statusSO);
        newPlan.setName(newPlan.getName());
        
    }
}

public String estadoSOFinal(){
    ///String str = "";
    while (!get_estadoSO().equals("Ok") &&!get_estadoSO().contains("Error")) {
        actualizarPagina();
        System.out.println(get_estadoSO());
        //Thread.sleep(1000);
    }
    
    return get_estadoSO();
}

public void obtener_botonenviar() throws InterruptedException{
    WebElement boton_envia = null;
    Wait_Click(boton_enviar);
    WebElement be= findElement(boton_enviar);
    List<WebElement> enviar= be.findElements(By.tagName("a"));
    for (int i = 0; i < enviar.size(); i++) {
        if(getText(enviar.get(i)).equals("Enviar")){
            
            boton_envia=enviar.get(i);
            click(boton_enviar);
        }
        break;
    }
    
}

public Boolean validar_Deuda() throws InterruptedException
{
    Boolean ret=false;
    By button_yes = By.xpath("//button[@aria-disabled='false' and span[contains(text(),'Sí')]]"); //(/html/body/div[8]/div/div/div[3]/div/button[1]");
    try{
        
        Thread.sleep(2000);
        WebElement boton= findElement(button_yes);
        System.out.println("boton cartel deuda-->"+boton);
        if (boton!= null) {
            click(boton);
            ret=true;
        }
        
    }catch (TimeoutException e)
    {
        System.out.println("El elemento no esta. TIMEOUT "+button_yes);
    }catch (NoSuchElementException e)
    {
        System.out.println("El elemento no esta. NO se encuentra "+button_yes);
    }
    System.out.println("valor retorno Validad Deuda-->"+ret);
    return ret;
    
}
        
public void validar_Factura() throws InterruptedException
{
    //metodo utilizado
    JavascriptExecutor jse =(JavascriptExecutor)driver;
    By nombre_clase_boton_validar_factura_disabled=By.xpath("//div[@class='tfn_button_panel disabled'  and a[contains(text(),'Nueva factura')]]");
    WebElement validar_fact_disable = null;
    By nombre_clase_boton_validar_factura=By.xpath("//div[@class='tfn_button_panel'  and a[contains(text(),'Validar factura')]]");
    WebElement validar_fact = null;
    By nombre_clase_boton_nueva_factura_enabled=By.xpath("//div[@class='tfn_button_panel'  and a[contains(text(),'Nueva factura')]]");
    //WebElement boton_nueva_fact_enabled=nombre_clase_boton_nueva_factura_enabled;
    WebElement nueva_fact_enable = (WebElement)jse.executeScript("return document.getElementsByClassName('tfn_button_panel')[2]");
    WebElement btn_nuevaFactura = null;
    WebElement btn_cerrarSO = null;
    int i=0;
    
    try{
        //Thread.sleep(5000);
        Wait(nombre_clase_boton_nueva_factura_enabled);
        btn_nuevaFactura = findElement(nombre_clase_boton_nueva_factura_enabled);
        
        if(btn_nuevaFactura != null){
            System.out.println("ENTRO A NUEVA FACTURA");
            System.out.println("El elemento es: "+ btn_nuevaFactura);
            Wait_Click(nombre_clase_boton_nueva_factura_enabled);
            Thread.sleep(1500);
            click(nombre_clase_boton_nueva_factura_enabled);
        }
        //else {
        // nueva_fact_enable.click();
        //}
    }catch (NoSuchElementException e)
    {
        System.out.println("No se encuentra boton nueva factura ");
    }catch (NullPointerException e)
    {
        System.out.println("El boton cerrar SO error NullPointerException");
    }
    
    /*
    try{
    small_Time_Wait(boton_cerrarSO,2,500);
    btn_cerrarSO = findElement(boton_cerrarSO);
    }catch (TimeoutException e)
    {
    System.out.println("El boton cerrar SO no se encuentra leugo de boton nueva factura "+ btn_cerrarSO.toString());
    
    }catch (NoSuchElementException e)
    {
    System.out.println("El boton cerrar SO no se encuentra leugo de boton nueva factura "+ btn_cerrarSO.toString());
    }catch (NullPointerException e)
    {
    System.out.println("El boton cerrar SO error en loading NullPointerException");
    }*/
    
    while (validar_fact_disable == null && btn_cerrarSO == null) {
        
        i++;
        System.out.println("Validar factura: "+i);
        try{
            loading();
        } catch (StaleElementReferenceException e)
        {
            System.out.println("error en loading StaleElementReferenceException");
        }catch (NoSuchElementException e)
        {
            System.out.println("error en loading NoSuchElementException");
        }catch (NullPointerException e)
        {
            System.out.println("error en loading NullPointerException");
        }
        
        try{
            validar_fact = findElement(nombre_clase_boton_validar_factura);
            if (validar_fact != null) {
                click(validar_fact);
            }
        }catch (NoSuchElementException e)
        {
            System.out.println("No se encuentra boton validar factura "+nombre_clase_boton_validar_factura.toString());
        }catch (NullPointerException e)
        {
            System.out.println("error validar factura enabled NullPointerException");
        }
        
        
        try{
            loading();
        } catch (StaleElementReferenceException e)
        {
            System.out.println("error en loading StaleElementReferenceException");
        }catch (NoSuchElementException e)
        {
            System.out.println("error en loading NoSuchElementException");
        }catch (NullPointerException e)
        {
            System.out.println("error en loading NullPointerException");
        }
        
        try{
            validar_fact_disable = findElement(nombre_clase_boton_validar_factura_disabled);
            if (validar_fact_disable != null) {
                break;
            }
        }catch (NoSuchElementException e)
        {
            System.out.println("El validar factura no esta disabled "+nombre_clase_boton_validar_factura_disabled.toString());
        }catch (NullPointerException e)
        {
            System.out.println("error validar factura disabled NullPointerException");
        }
        
        
        try{
            
            btn_cerrarSO = findElement(boton_cerrarSO);
        }catch (NoSuchElementException e)
        {
            System.out.println("El boton cerrar SO no ses encuentra en proceso de VALIDAR "+ boton_cerrarSO.toString());
        }catch (NullPointerException e)
        {
            System.out.println("error validar boron cerrar SO -  NullPointerException");
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
        Wait(nombre_clase_boton_configurar_contrato,2);
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


    public void obtener_SO(String orden) throws InterruptedException{
        WebElement so=null;


        Wait_Click(filtro_SO_nombre);
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
            loading();
            Wait_Click(cuenta_facturacion);
            Thread.sleep(2000);
            click(cuenta_facturacion);
            loading();
            Thread.sleep(2000);
            Wait(boton_crear_nuevacuenta_facturacion_pp);
            click(boton_crear_nuevacuenta_facturacion_pp);
            loading();
            Thread.sleep(4000);
            try{
                Alert a = null;
                a = driver.switchTo().alert();
                a.dismiss();
                System.out.println("Se hace dismiss en el alerta");
            }catch (NoAlertPresentException e){
                System.out.println("No existe mensaje de alerta");
            }
            Thread.sleep(4000);


            Wait_Click(boton_revision1);
            click(boton_revision1);

        }else {

            WebElement scf= findElement(select_cuenta_facturacion);
            Wait(select_cuenta_facturacion);
            List<WebElement> selectfacturacreada= scf.findElements(By.tagName("select"));
            int size_list=selectfacturacreada.size();
            WebElement ultimo_select=selectfacturacreada.get(size_list - 1);
            click(ultimo_select);
            int longitud = serviciolist.size()-1;
            for (int i = 0; i < serviciolist.size(); i++) {
                if (i == longitud) {
                    factura_creada=serviciolist.get(i);
                }

            }
            click(factura_creada);
            loading();
            Thread.sleep(5000);
            Wait_Click(boton_revision);
            click(boton_revision);
        }

    }

    public void obtener_factcreada_pp_cambio() throws InterruptedException{//metodos utilizados

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
            
            loading();
            Wait(cuenta_facturacion);
            Thread.sleep(2000);
            click(cuenta_facturacion);
            loading();
            Thread.sleep(2000);
            findElement(boton_crear_nuevacuenta_facturacion_pp);
            Wait(boton_crear_nuevacuenta_facturacion_pp);
            click(boton_crear_nuevacuenta_facturacion_pp);
            loading();
            Thread.sleep(4000);
            WebElement boton_rev= findElement(boton_revision1);
            click(boton_rev);

        }else {
            WebElement penultimo_select=null;
            WebElement scf= findElement(select_cuenta_facturacion);
            List<WebElement> selectfacturacreada= scf.findElements(By.tagName("select"));
            for (int i = selectfacturacreada.size()-1; i >= 1; i--) {
                penultimo_select=selectfacturacreada.get(i);
                click(penultimo_select);

                break;
            }
            int longitud = serviciolist.size()-3;
            WebElement factura_creada = null;
            for (int j  = 0; j < serviciolist.size(); j++) {
                if (j == longitud) {
                    factura_creada=serviciolist.get(j);
                    click(factura_creada);

                    break;
                }
            }

            Thread.sleep(5000);
            Wait(boton_revision);
            click(boton_revision);
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
            if(wb.getText().contains("Postpago")){
                hay = true;

                break;
            }
        }
        if (!hay) {
            loading();
            Wait_Click(cuenta_fact_posp);
            click(cuenta_fact_posp);
            Thread.sleep(5000);
            Wait_Click(boton_crear_cf_posp);
            Thread.sleep(5000);
            click(boton_crear_cf_posp);
            Thread.sleep(5000);
            try{
                Alert a = null;
                a = driver.switchTo().alert();
                a.dismiss();
                System.out.println("Se hace dismiss en el alerta");
            }catch (NoAlertPresentException e){
                System.out.println("No existe mensaje de alerta");
            }
            Thread.sleep(5000);

            Wait_Click(boton_revision);
            click(boton_revision);

        }else {

            Wait(select_cuenta_facturacion);
            WebElement scf= findElement(select_cuenta_facturacion);
            List<WebElement> selectfacturacreada= scf.findElements(By.tagName("select"));
            int size_list=selectfacturacreada.size();
            WebElement ultimo_select=selectfacturacreada.get(size_list - 1);
            click(ultimo_select);
            int longitud = serviciolist.size()-1;
            for (int i = 0; i < serviciolist.size(); i++) {
                if (i == longitud) {
                    factura_creada=serviciolist.get(i);
                }
            }
            click(factura_creada);
            Thread.sleep(5000);
            Wait_Click(boton_revision);
            click(boton_revision);
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



    public WebElement Obtener_cambioPLR(String nombre_plan) throws InterruptedException{//utilizado
        WebElement plr=null;
        Thread.sleep(5000);
        Wait(lista_plancambio_regular);
        WebElement cambio_regular= findElement(lista_plancambio_regular);
        List<WebElement>lista_regular= cambio_regular.findElements(By.tagName("span"));
        for (int j = 0; j < lista_regular.size(); j++) {
            if(lista_regular.get(j).getText().contains(nombre_plan)) {//En dependencia de los permisos del usuario podra acceder a diferentes canal de distribucion

                plr=lista_regular.get(j);
                break;

            }

        }
        return plr;

    }

    public WebElement Obtener_cambioPLC(String nombre_plan){//utilizado
        WebElement plc=null;
        Wait(lista_plancambio_controlada);
        WebElement cambio_controlado=findElement(lista_plancambio_controlada);

        List<WebElement>lista_controlado= cambio_controlado.findElements(By.tagName("span"));
        for (int j = 0; j < lista_controlado.size(); j++) {
            if(lista_controlado.get(j).getText().contains(nombre_plan)) {//En dependencia de los permisos del usuario podra acceder a diferentes canal de distribucion

                plc=lista_controlado.get(j);
                break;

            }

        }
        return plc;

    }
    public WebElement Obtener_cambioPP(String nombre_plan){//utilizado
        WebElement pp=null;
        Wait(lista_plancambio_prepago);
        WebElement cambio_prepago=findElement(lista_plancambio_prepago);
        List<WebElement>lista_prepago= cambio_prepago.findElements(By.tagName("span"));
        for (int j = 0; j < lista_prepago.size(); j++) {
            if(lista_prepago.get(j).getText().contains(nombre_plan)) {//En dependencia de los permisos del usuario podra acceder a diferentes canal de distribucion

                pp=lista_prepago.get(j);
                break;

            }

        }
        return pp;

    }
    public void confirmarContrato() throws InterruptedException
    {
        boolean esta = false;
        try{
            esta = true;
            Wait_Click(boton_contrato_confirmar);
            Thread.sleep(5000);
            click(boton_contrato_confirmar);

        } catch (StaleElementReferenceException e)
        {
            System.out.println(e);
        } catch (NoSuchElementException e)
        {
            System.out.println(e);
        }

        if (!esta) {
            try{
                Wait_Click(boton_contrato_confirmar2);
                Thread.sleep(5000);
                click(boton_contrato_confirmar2);
            } catch (StaleElementReferenceException e)
            {
                System.out.println(e);
            } catch (NoSuchElementException e)
            {
                System.out.println(e);
            }
        }

    }
     
    
    public String get_estadoSO(){
        //String urlso=newPlan.getUrlSO();
        //visit(urlso);
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
       Wait(nombre_orden_venta);
        WebElement nombre_so = findElement(nombre_orden_venta);
        String nombre_orden= getText(nombre_so);
        //System.out.println("nombre SO"+ nombre_orden);
        return nombre_orden.substring(0, 30);
    }
   
   public String obtener_nombre_SO_CambioPlan(){
       Wait(nombre_orden_venta);
        WebElement nombre_so = findElement(nombre_orden_venta);
        String nombre_orden= getText(nombre_so);
        //System.out.println("nombre SO"+ nombre_orden);
        return nombre_orden.substring(0, 14);
    }   
   
   public String getTypePlan(String namePlan){
       String type="";
       if(CadenaUtils.compararCadenas("PLTT", namePlan) || (CadenaUtils.compararCadenas("PLGPKA", namePlan)) ||
               (CadenaUtils.compararCadenas("PLK", namePlan))){
           type="prepago";
       }
       else
       {
           type="pospago";
       }
       
       return type;
   }
    
   
}




   

