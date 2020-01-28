
import Base.BasePage;
import java.util.List;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.By;
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
     
     ClientPage cp;
     
    public TestNewResiClient() {
        
        cp = new ClientPage();   
    }
    @Test
    public void altaClienteR() throws InterruptedException{
    BasePage.initBaseTest();
    LoginPage lp = new LoginPage();
    lp.visit("https://noprd-jit-toms.temu.com.uy:7002");
    lp.Nav();
    lp.signIn();
    cp.crear_Cliente_Residencial();
    
   // super.CerrarNavegador();
    
    }
     
}
