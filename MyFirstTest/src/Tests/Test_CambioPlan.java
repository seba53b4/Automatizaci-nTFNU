package Tests;



import Base.BasePage;
import Utils.HandleFile;
import Utils.Plan;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.Test;
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
public class Test_CambioPlan extends Base.BaseTest {
    private CostumerPage ap;
    private LoginPage lp;
    private Plan plan;
    
    public Test_CambioPlan(Plan p ) {
        plan = p;
    }
    
    @Override
    public String test() {
        try {
            this.Cambio_Plan();
            return "OK";
        } catch (Exception ex) {
            try {
                
                HandleFile.getHandleFile().registrarError("ERROR en Cambio Plan \n\n"+ ex +"\n\n---------------------------------------------------------------------------\n\n");
                ex.printStackTrace();
            } catch (IOException ex1) {
                Logger.getLogger(TestAltaPosP.class.getName()).log(Level.SEVERE, null, ex1);
            }
            return "Falló";
        }finally{
            //BasePage.initBaseTest().closeDriver();
        }
    }
    
    @Test
    public void Cambio_Plan() throws Exception
    {
        BasePage.initBaseTest();
        BasePage.getNewDriver();
        this.ap = new CostumerPage();
        this.lp = LoginPage.getLoginPage();
        List<Plan> realPlans = new ArrayList<>();
        this.ap.initUrlBusqueda(plan.getAmbiente());
        this.lp.Nav(plan.getAmbiente());
       if(plan.getAmbiente().equals("preprod")){
          this.lp.signIn_preprod();
       }
       else{
          this.lp.signIn();
      }
        List<Plan> newPlans = new LinkedList<>();
        Plan newPlan = this.ap.cambioPlan(plan,plan.getAmbiente());
        if (newPlan.getName() != null) {
            realPlans.add(newPlan);
        }
        // only save in spreadsheet the changed Plan
        if (realPlans.size() > 0) {
            HandleFile.getHandleFile().generateRegisteredChangedPlanDatasource(realPlans);
        }
    }
}

