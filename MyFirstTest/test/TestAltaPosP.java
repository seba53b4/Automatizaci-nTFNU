
import Base.BasePage;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pages.CostumerPage;
import pages.LoginPage;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ipupo
 */
public class TestAltaPosP extends Base.BaseTest {
    CostumerPage ap;
   
     
    public TestAltaPosP() {
        
        ap = new CostumerPage();
      
    }
    @Test
   public void altaPP() throws Exception
   {     
       //Lee un archivo
       // Le paso los object id
       //Se trabaja con el user
       String nombre_plan= "";
       BasePage.initBaseTest();
       LoginPage lp = new LoginPage();
       
    
       //lp.chromeDriverConnection();
       lp.visit("https://noprd-jit-toms.temu.com.uy:7002");
       lp.Nav();
       lp.signIn();
       // if("PLR282".equals(nombre_plan)){
        ap.seleccionar_Canal("9156314432513103959");
        Thread.sleep(5000);
        ap.seleccionar_PosPR("PLR314");
        Thread.sleep(5000);
        ap.obtener_PPActivo("PLR314");
        ap.iccid_MSISDN_PosPLR();
       // }
       // else 
       //nombre_plan="PLC292";
      // ap.seleccionar_Canal("9156311923013095250");
       //ap.seleccionar_PosPC("PLC305");
      // ap.obtener_PPActivo("PLC305");
      // ap.iccid_MSISDN_PosPLC();
      
        Thread.sleep(4000);
        //super.CerrarNavegador();
       
   }  
     
  }

