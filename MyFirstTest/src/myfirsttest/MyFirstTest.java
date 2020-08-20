
import Base.BasePage;
import Objects.Cliente;
import Objects.ClienteRes;
import Test_PLM_Regression.TC1;
import Test_PLM_Regression.TC4;
import Tests.TestNewResiClient;
import Utils.Client;
import Utils.HandleFile;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import pages.LoginPage;






public class MyFirstTest{
    
    public static void main(String [] args) {
       /*     LoginFrame lf = new LoginFrame();
            lf.setVisible(true);
            lf.show();*/

            // String name, String ape, String cat, String typeDoc, String numD, String nat, String dir
           /* BasePage.initBaseTest();
            HandleFile.initHandleFile();
            LoginPage.initLoginPage("seolivera", "wartel.1");
            */
        //try {
            //String str = HandleFile.getHandleFile().getICCID_Regresion("uat");
            //System.out.println("La linea " + str);
            try {
                /*HashMap<String,List<Client>> clientesRes = HandleFile.getHandleFile().getNewClientDatSourcePLM();
                
                for (Map.Entry<String, List<Client>> entry : clientesRes.entrySet()) {
                    for (Client cl : entry.getValue()) {
                        System.out.println("ENTRAA");
                        if (cl == null) {
                            System.out.println("ES NULO");
                        }*/
                        Client cl = new Client("name", "ape", "asd23azz", "", "18 de julio");
                        cl.setClientId("9147446331113197269");
                        cl.setAmbiente("e2e");
                        
                        
                        //TestNewResiClient tr = new TestNewResiClient(cl);
                        //tr.test();
                        TC1 tc1 = new TC1(cl);
                        tc1.test();
                  /*  }
                    
                }
            } catch (Exception e) {
                System.out.println("Error al cargar hoja de residencial" + e);
            }*/
        } catch (Exception ex) {
            Logger.getLogger(MyFirstTest.class.getName()).log(Level.SEVERE, null, ex);
        }
            
        
            
            
            String str = "Aumentar 09/14/2019 13:14:03 $150.00";
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