package Tests;


import Base.BasePage;
import Utils.EnterpriseClient;
import Utils.HandleFile;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.Test;
import pages.ClientPage;
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
public class TestEmpClient extends Base.BaseTest {
 
     private ClientPage cp;
     private HandleFile hf;
     private LoginPage lp;
     HashMap<String, List<EnterpriseClient>> datosClient;

    @Override
    public String test() {
         try {
           this.altaClienteP();
           return "OK";
       } catch (Exception ex) {
           BasePage.initBaseTest().closeDriver();
             try {
                 HandleFile.getHandleFile().registrarError("ERROR en Alta de Cliente Empresarial \n\n"+ ex.getMessage()+"\n\n---------------------------------------------------------------------------\n\n");
             } catch (IOException ex1) {
                 Logger.getLogger(TestEmpClient.class.getName()).log(Level.SEVERE, null, ex1);
             }
           //Logger.getLogger(TestAltaPP.class.getName()).log(Level.SEVERE, null, ex);
           return "Falló";
       }
    }
     
     
     
     
    @Test
    public void altaClienteP() throws InterruptedException, Exception{
        BasePage.initBaseTest();
        this.cp = new ClientPage();
        this.lp = LoginPage.initLoginPage();
        this.hf = new HandleFile();
        List<EnterpriseClient> realClients = new ArrayList<>();
        HashMap<String, List<EnterpriseClient>> dataSource = this.hf.readRegisterDataSource("new_enterprise_client");
        if (!dataSource.isEmpty()) {
            for (HashMap.Entry<String, List<EnterpriseClient>> entry : dataSource.entrySet()) {
                String enviroment = entry.getKey();
                this.cp.initUrlBusqueda(enviroment);
                this.lp.Nav(enviroment);
                if(enviroment.contains("preprod")){
                this.lp.signIn_preprod();
                }
                else{
                this.lp.signIn();
                }
                List<EnterpriseClient> newClients = entry.getValue();
                for (int i = 0; i < newClients.size(); i++) {
                    EnterpriseClient newClient = this.cp.crear_Cliente_Empresarial(newClients.get(i));
                    if (newClient.getClientId() != null) {
                        realClients.add(newClient);
                    }
                }
            }
        }
        // only save in spreadsheet the real Clients
        if (realClients.size() > 0) {
            this.hf.generateRegisteredEntClientDatasource(realClients);
        }
    
    }
       
}
