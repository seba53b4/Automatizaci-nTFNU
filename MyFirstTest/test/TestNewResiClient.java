
import Base.BasePage;
import Utils.HandleFile;
import Utils.Client;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import limpieza_recurso.Limpieza_Class;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.By;
import static org.openqa.selenium.By.name;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import static org.openqa.selenium.lift.Finders.table;
import pages.ClientPage;
import pages.CostumerPage;
import pages.LoginPage;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author sdominguez
 */
public class TestNewResiClient extends Base.BaseTest {
     
     private ClientPage cp;
     private HandleFile hf;
     private LoginPage lp;
     //HashMap<String, List<Client>> datosClient;
    

    
    @Test
    public void residentialClientRegister() throws InterruptedException, Exception{
        BasePage.initBaseTest();
        this.cp = new ClientPage();
        this.lp = new LoginPage();
        this.hf = new HandleFile();
        List<Client> realClients = new ArrayList<>();
        HashMap<String, List<Client>> dataSource = this.hf.readRegisterDataSource("new_residential_client");
        if (!dataSource.isEmpty()) {
            for (HashMap.Entry<String, List<Client>> entry : dataSource.entrySet()) {
                String enviroment = entry.getKey();
                this.cp.initUrlBusqueda(enviroment);
                this.lp.Nav(enviroment);
                if(enviroment.contains("preprod")){
                this.lp.signIn_preprod();
                }
                else{
                this.lp.signIn();
                }
                List<Client> newClients = entry.getValue();
                for (int i = 0; i < newClients.size(); i++) {
                    Client newClient = this.cp.crear_Cliente_Residencial(newClients.get(i));
                    if (newClient.getClientId() != null) {
                        realClients.add(newClient);
                    }
                }
            }
        }
        // only save in spreadsheet the real Clients
        if (realClients.size() > 0) {
            this.hf.generateRegisteredRClientDatasource(realClients);
        }
   }
 }
