
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
public class Test_CambioPlan {
    CostumerPage ap;
    BaseTest driver;
    
     public Test_CambioPlan() {
        
        ap = new CostumerPage();
       
    }
     @Test
   public void Cambio_Plan() throws Exception
   {     
       //Lee un archivo
       // Le paso los object id
       //Se trabaja con el user
      // String nombre_plan= "";
       BaseTest.initBaseTest();
       LoginPage lp = new LoginPage();
       lp.chromeDriverConnection();
       lp.visit("https://noprd-jit-toms.temu.com.uy:7002/");
       lp.Nav();
       lp.signIn();
        ap.seleccionar_CanalOrder("9156277650013065775");
        ap.obtener_PPActivo("PLR314");
        ap.cambio_Plan("PLROT");
        ap.Terminar_Cambio_Plan();
        
       
        //ap.Terminar();  
   }  
     @After
    public void CerrarNavegador(){
    
        WebDriver dri=driver.chromeDriverConnection();
        dri.quit();
           
    }
}
