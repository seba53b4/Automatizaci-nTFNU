
import Base.BaseTest;
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
public class TestAltaPosP {
    CostumerPage ap;
    BaseTest driver;
     
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
       BaseTest.initBaseTest();
       LoginPage lp = new LoginPage();
       
    
       //lp.chromeDriverConnection();
       lp.visit("https://noprd-jit-toms.temu.com.uy:7002/");
       lp.Nav();
       lp.signIn();
       // if("PLR282".equals(nombre_plan)){
        ap.seleccionar_Canal("9156277650013065775");
        ap.seleccionar_PosPR("PLR314");
        ap.obtener_PPActivo("PLR314");
        ap.iccid_MSISDN_PosPLR();
       // }
       // else 
      //   nombre_plan="PLC292";
    //   ap.seleccionar_Canal();
   //    ap.seleccionar_PosPC(nombre_plan);
      //ap.obtener_PPActivo(nombre_plan);
    //   ap.iccid_MSISDN_PosPLC();
      
       
   }  
     @After
    public void CerrarNavegador(){
    
        WebDriver dri=driver.chromeDriverConnection();
        dri.quit();
           
    }
  }

