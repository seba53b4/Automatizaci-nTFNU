package Tests;



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import Base.BasePage;
import Utils.HandleFile;
import Utils.Plan;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.Test;
import pages.CostumerPage;
import pages.LoginPage;
/**
 *
 * @author ipupo
 */
public class TestAltaPP extends Base.BaseTest{
   
   //WebDriver driver ;
   private CostumerPage ap;
   private LoginPage lp;
   private Plan plan;
   
    public TestAltaPP(Plan p) {
        plan = p;
    }

    @Override
    public String test() {
       try {
           this.altaPP();
           return "OK";
       } catch (Exception ex) {
           
           try {
               HandleFile.getHandleFile().registrarError("ERROR en Alta de PP \n\n"+ ex+"\n\n---------------------------------------------------------------------------\n\n");
           } catch (IOException ex1) {
               Logger.getLogger(TestAltaPP.class.getName()).log(Level.SEVERE, null, ex1);
           }
           return "Falló";
       } finally{
      //     BasePage.initBaseTest().closeDriver();
       }
    }
 
   @Test
   public void altaPP() throws Exception
   {      
       BasePage.getNewDriver();
       this.ap = new CostumerPage();
       this.lp = LoginPage.getLoginPage();
       List<Plan> realPlans = new ArrayList<>();
       
       String enviroment = plan.getAmbiente();
       this.ap.initUrlBusqueda(enviroment);
       this.lp.Nav(enviroment);
       if(enviroment.contains("preprod")){
           this.lp.signIn_preprod();
       }
       else{
           this.lp.signIn();
       }
       Plan newPlan = this.ap.AltaPP(plan,enviroment);
       if (newPlan != null) {
           realPlans.add(newPlan);
       }
       if (realPlans.size() > 0) {
           HandleFile.getHandleFile().generateRegisteredNewPlanDatasource(realPlans);
       }
   }

    @After
    public void CerrarNavegador() {
        super.CerrarNavegador(); //To change body of generated methods, choose Tools | Templates.
    }
   
 }  
   
