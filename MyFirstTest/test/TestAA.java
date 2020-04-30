
import Base.BasePage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pages.AAPage;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author seolivera
 */
public class TestAA  extends Base.BaseTest{
    
    AAPage ap;
  
    public TestAA ()
    {
        ap = new AAPage();
        
    }
    @Test
    public void validarTestAA() throws InterruptedException
    {
        ap.logIN();
        Assert.assertTrue(ap.consultaEstado("95899424","TOMS"));
        
        Thread.sleep(4000);
        //super.CerrarNavegador();
    }
     
    
    
}
