
import Base.BasePage;
import Utils.HandleFile;
import Utils.Plan;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
   private CostumerPage ap;
   private HandleFile hf;
   private LoginPage lp;
   
     
    public TestAltaPosP() {
        
        ap = new CostumerPage();
      
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
                this.lp.Nav(enviroment);
                if(enviroment.contains("preprod")){
                this.lp.signIn_preprod();
                }
                else{
                this.lp.signIn();
                }
                List<Plan> newPlans = entry.getValue();
                for (int i = 0; i < newPlans.size(); i++) {
                  Plan newPlan = this.ap.AltaPosP(newPlans.get(i),enviroment);
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
      /* String nombre_plan= "";
       BasePage.initBaseTest();
       LoginPage lp = new LoginPage();
       
    
       //lp.chromeDriverConnection();
       lp.visit("https://noprd-jit-toms.temu.com.uy:7002");
       lp.Nav();
       lp.signIn();
       // if("PLR282".equals(nombre_plan)){
        //ap.seleccionar_Canal("9156314432513103959");
        //Thread.sleep(5000);
        //ap.seleccionar_PosPR("PLR314");
        //Thread.sleep(5000);
        //ap.obtener_PPActivo("PLR314","");
        //ap.iccid_MSISDN_PosPLR();
       // }
       // else 
       //nombre_plan="PLC292";
      // ap.seleccionar_Canal("9156311923013095250");
       //ap.seleccionar_PosPC("PLC305");
      // ap.obtener_PPActivo("PLC305");
      // ap.iccid_MSISDN_PosPLC();
      
        Thread.sleep(4000);
        //super.CerrarNavegador();
       
   } */ 
     
   }
  }
}

