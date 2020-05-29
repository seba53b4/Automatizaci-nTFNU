package Tests;



import Base.BasePage;
import Utils.HandleFile;
import Utils.Client;
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
public class TestNewResiClient extends Base.BaseTest {
     
     private ClientPage cp;
     private LoginPage lp;
     private Client client;
     //HashMap<String, List<Client>> datosClient;
     
     public TestNewResiClient(Client clte){
         client = clte;
     }
     
     
    @Override
    public String test() {
         try {
           this.residentialClientRegister();
           return "OK";
       } catch (Exception ex) {
             try {
                 HandleFile.getHandleFile().registrarError("ERROR en Alta de Cliente Residencial\n\n"+ ex.getMessage()+"\n\n---------------------------------------------------------------------------\n\n");
             } catch (IOException ex1) {
                 Logger.getLogger(TestNewResiClient.class.getName()).log(Level.SEVERE, null, ex1);
             }
           //Logger.getLogger(TestAltaPP.class.getName()).log(Level.SEVERE, null, ex);
           return "Falló";
       }finally{
           BasePage.initBaseTest().closeDriver();
       }
    }
    
     
    
    @Test
    public void residentialClientRegister() throws InterruptedException, Exception{
        
        BasePage.getNewDriver();
        this.cp = new ClientPage();
        this.lp = LoginPage.initLoginPage();
        List<Client> realClients = new ArrayList<>();
       // HashMap<String, List<Client>> dataSource = this.hf.readRegisterDataSource("new_residential_client");
        //if (!dataSource.isEmpty()) {
          //  for (HashMap.Entry<String, List<Client>> entry : dataSource.entrySet()) {
               // String enviroment = entry.getKey();
               
                this.cp.initUrlBusqueda(client.getAmbiente());
                this.lp.Nav(client.getAmbiente());
                if(client.getAmbiente().contains("preprod")){
                this.lp.signIn_preprod();
                }
                else{
                this.lp.signIn();
                }
                //List<Client> newClients = entry.getValue();
                //for (int i = 0; i < newClients.size(); i++) {
                    Client newClient = this.cp.crear_Cliente_Residencial(client);
                    if (client.getClientId() != null) {
                        realClients.add(client);
                    }
                
            //}
        
        // only save in spreadsheet the real Clients
        if (realClients.size() > 0) {
            HandleFile.getHandleFile().generateRegisteredRClientDatasource(realClients);
        }
    }

   
 }
