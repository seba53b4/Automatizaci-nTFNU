
import Base.BasePage;
import DataBase.ConnectionManager;
import DataBase.Queries;
import Frames.LoginFrame;
import Objects.Cliente;
import Objects.ClienteRes;
import Test_PLM_Regression.TC1;
import Test_PLM_Regression.TC4;
import Tests.TestNewResiClient;
import Utils.Client;
import Utils.HandleFile;
import Utils.Plan;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import pages.LoginPage;






public class MyFirstTest{
    
    public static void main(String [] args) {
        
        /*
        List<String> nums = new LinkedList<>();
        nums.add("095777444");
        nums.add("095777555");
        */
        /*
        List<String> sims1 = new LinkedList<>();
        sims1.add("12335111");
        sims1.add("11232312");
        
        List<String> sims2 = new LinkedList<>();
        sims2.add("11111111");
        sims2.add("22222222");
        
        HashMap<String,List<String>> hm = new HashMap<>();
        
        hm.put("095", sims1);
        hm.put("094", sims2);
        */
        
        Queries q = new Queries();
        try {
            System.out.println("Recurso elegido: "+q.selectRecurso_MSISDN());
        } catch (SQLException ex) {
            Logger.getLogger(MyFirstTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        q.closeConnection();
        /*
            LoginFrame lf = new LoginFrame();
            lf.setVisible(true);
            lf.show();
            */
            
            
            //try {
            //String str = HandleFile.getHandleFile().getICCID_Regresion("uat");
            //System.out.println("La linea " + str);
           
            /*9try {
            
            Client cl = new Client("Nativo Automation", "181", "asvz1z", "", "18 de julio");
            Plan pl= new Plan();
            //cl.setClientId("9147446331113197269");
            cl.setAmbiente("e2e");
            pl.setMSISDN("94421183");//Este dato viene del Plan Creado
            
            
            //TestNewResiClient tr = new TestNewResiClient(cl);
            //tr.test();
            TC1 tc1 = new TC1(cl);
            tc1.test();
            
            
            
            } catch (Exception e) {
            System.out.println("Error al cargar hoja de residencial" + e);
            
            } catch (Exception ex) {
            Logger.getLogger(MyFirstTest.class.getName()).log(Level.SEVERE, null, ex);
            }*/
            
            
            
            
            //  String str = "Aumentar 09/14/2019 13:14:03 $150.00";
//          Utils u = new Utils();
//          Date dat = u.toDate(str);
//          System.out.println(dat.toString());

        


//        BasePage.initBaseTest();
//        
//        BasePage.getNewDriver();
//        BasePage.driver.get("https://www.google.com.uy/?hl=es-419");
//        
//        BasePage.getNewDriver();
//        BasePage.driver.get("https://www.google.com.mx/?hl=es-419");
//
//      System.out.println("Cargado Archivo - Alta Plan PP:  PLTTEF en cliente de object_id: 9157366908913851340");
        
//        if (CadenaUtils.compararCadenas("Plan PosP", "Cargado Archivo - Alta Plan PosP:  PLTTEF en cliente de object_id: 9157366908913851340")) {
//            System.out.println("Esta presente el pivote");
//        } else {
//            System.out.println("El pivote no esta, el pivote se fue"
//                    + "");
//        }
      

        
    }
    
}