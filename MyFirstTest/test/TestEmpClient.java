
import Base.BasePage;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
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
 
     ClientPage cp;
     
    public TestEmpClient() {
        
        cp = new ClientPage();   
    }
    @Test
    public void altaClienteP() throws InterruptedException{
    BasePage.initBaseTest();
    LoginPage lp = new LoginPage();
    lp.visit("https://noprd-jit-toms.temu.com.uy:7002/");
    lp.Nav();
    lp.signIn();
    cp.crear_Cliente_Empresarial();
    
        Thread.sleep(4000);
        super.CerrarNavegador();
        //System.out.println(cp.obtener_CR());
    
    }
       
}
