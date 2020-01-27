
import org.junit.Assert;
import org.junit.Test;
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
public class TestAA {
    
    AAPage ap;
    
    public TestAA ()
    {
        ap = new AAPage();
        
    }
    @Test
    public void validarTestAA()
    {
        ap.logIN();
        Assert.assertTrue(ap.consultaEstado("95838603","TOMS"));
    }
}
