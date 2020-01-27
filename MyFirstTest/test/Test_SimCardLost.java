
import Base.BasePage;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
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
public class Test_SimCardLost extends Base.BaseTest {
     CostumerPage ap;
    
     
    
     public Test_SimCardLost() {
        
        ap = new CostumerPage();
      
    }
     @Test
   public void sim_Card_Lost() throws Exception
   {     
       //Lee un archivo
       // Le paso los object id
       //Se trabaja con el user
      // String nombre_plan= "";
       BasePage.initBaseTest();
       LoginPage lp = new LoginPage();
       lp.chromeDriverConnection();
       lp.visit("https://noprd-jit-toms.temu.com.uy:7002/");
       lp.Nav();
       lp.signIn();
        ap.seleccionar_CanalOrder("9156277650013065775");
        ap.obtener_PPActivo("PLR314");
        ap.select_SIMCardLost();
        ap.Terminar();  
        Thread.sleep(4000);
        super.CerrarNavegador();
   }
    
}
