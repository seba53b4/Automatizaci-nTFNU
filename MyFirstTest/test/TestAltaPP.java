

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import Base.BaseTest;
import java.time.Duration;
import java.util.concurrent.TimeUnit;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.CostumerPage;
import pages.LoginPage;
/**
 *
 * @author sdominguez
 */
public class TestAltaPP {
   
   //WebDriver driver ;
   CostumerPage ap;
     
/*
   public TestAltaPP(WebDriver driver) {
        super(driver);
   }*/

    public TestAltaPP() {
        
        ap = new CostumerPage();
      
    }
  
 
   @Test
   public void altaPP() throws Exception
   {     
       //Lee un archivo
       // Le paso los object id
       //Se trabaja con el user
       
       BaseTest.initBaseTest();
       LoginPage lp = new LoginPage();
       
    
       //lp.chromeDriverConnection();
       lp.visit("https://noprd-jit-toms.temu.com.uy:7002/");
       lp.Nav();
       lp.signIn();
          
        
       //leo el archivo
       // for each
       ap.seleccionar_Canal("");
       //ap. seleccionar_CanalX();
       ap.seleccionar_PP("PLTTEX");
      // Thread.sleep(5000);
       ap.obtener_PPActivo("PLTTEX");
      // Thread.sleep(10000);
       ap.iccid_MSISDN_PP();
       //System.out.println(ap.obtener_botonenviar());
       //Thread.sleep(15000);
       //ap.Enviar();
      
       //end for
   }
   
}
