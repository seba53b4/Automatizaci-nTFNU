package Tests;


import Base.BasePage;
import Utils.Client;
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
     private EnterpriseClient cliente;
     HashMap<String, List<EnterpriseClient>> datosClient;
     

    @Override
    public String test() {
         try {
           this.altaClienteP();
           return "OK";
       } catch (Exception ex) {
             try {
                 HandleFile.getHandleFile().registrarError("ERROR en Alta de Cliente Empresarial \n\n"+ ex.getMessage()+"\n\n---------------------------------------------------------------------------\n\n");
             } catch (IOException ex1) {
                 Logger.getLogger(TestEmpClient.class.getName()).log(Level.SEVERE, null, ex1);
             }
           //Logger.getLogger(TestAltaPP.class.getName()).log(Level.SEVERE, null, ex);
           return "Falló";
       }finally{
           BasePage.initBaseTest().closeDriver();
       }
    }
     
    public TestEmpClient(EnterpriseClient clt){
        this.cliente = clt;
    }
     
     
     
    @Test
    public void altaClienteP() throws InterruptedException, Exception{
        
        BasePage.getNewDriver();
        this.cp = new ClientPage();
        this.lp = LoginPage.initLoginPage();
        
        List<EnterpriseClient> realClients = new ArrayList<>();
        
        String enviroment = cliente.getAmbiente();
        this.cp.initUrlBusqueda(enviroment);
        this.lp.Nav(enviroment);
        if(enviroment.contains("preprod")){
            this.lp.signIn_preprod();
        }
        else{
            this.lp.signIn();
        }
        
        EnterpriseClient newClient = this.cp.crear_Cliente_Empresarial(cliente);
        if (newClient != null) {
            realClients.add(newClient);
        }
        
        if (realClients.size() > 0) {
            HandleFile.getHandleFile().generateRegisteredEntClientDatasource(realClients);
        }
    
    }
       
}
