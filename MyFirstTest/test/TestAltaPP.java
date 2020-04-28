

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import Base.BasePage;
import Utils.Client;
import Utils.HandleFile;
import Utils.Plan;
import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.ClientPage;
import pages.CostumerPage;
import pages.LoginPage;
/**
 *
 * @author sdominguez
 */
public class TestAltaPP extends Base.BaseTest{
   
   //WebDriver driver ;
   private CostumerPage ap;
   private HandleFile hf;
   private LoginPage lp;
   
     
/*
   public TestAltaPP(WebDriver driver) {
        super(driver);
   }*/

    public TestAltaPP() {
        
      
    }
  
 
   @Test
   public void altaPP() throws Exception
   {      
       BasePage.initBaseTest();
        this.ap = new CostumerPage();
        this.lp = new LoginPage();
        this.hf = new HandleFile();
       List<Plan> realPlans = new ArrayList<>();
        HashMap<String, List<Plan>> dataSource = this.hf.readRegisterDataSource("new_plan");
        if (!dataSource.isEmpty()) {
            for (HashMap.Entry<String, List<Plan>> entry : dataSource.entrySet()) {
                String enviroment = entry.getKey();
                this.ap.initUrlBusqueda(enviroment);
                this.lp.Nav();
                this.lp.signIn();
                List<Plan> newPlans = entry.getValue();
                for (int i = 0; i < newPlans.size(); i++) {
                  Plan newPlan = this.ap.AltaPP(newPlans.get(i),enviroment);
                   if (newPlan.getName() != null) {
                        realPlans.add(newPlan);
                    }
                    
                   
                }
            }
        }
         // only save in spreadsheet the real Plan
        if (realPlans.size() > 0) {
            this.hf.generateRegisteredNewPlanDatasource(realPlans);
       
       
       
       
       
       //Lee un archivo
       // Le paso los object id
       //Se trabaja con el user
       
      /* BasePage.initBaseTest();
       LoginPage lp = new LoginPage();
       
    
       //lp.chromeDriverConnection();
       lp.visit("https://noprd-jit-toms.temu.com.uy:7002/");
       lp.Nav();
       lp.signIn();
          
        
       //leo el archivo
       // for each
       ap.seleccionar_Canal("9156322232713111161","");
       //ap. seleccionar_CanalX();
       ap.seleccionar_PP("PLTTEF");
      // Thread.sleep(5000);
       ap.obtener_PPActivo("PLTTEF","");
      // Thread.sleep(10000);
       ap.iccid_MSISDN_PP();
       //System.out.println(ap.obtener_botonenviar());
       //Thread.sleep(15000);
       //ap.Enviar();
      
       //end for
       
       
        Thread.sleep(4000);
        //super.CerrarNavegador();
   }*/
     
     }
   }
 }  
   
