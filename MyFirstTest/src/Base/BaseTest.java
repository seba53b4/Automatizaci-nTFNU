/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Base;

import org.junit.After;

/**
 *
 * @author ipupo
 */
public class BaseTest {
    
    
    
    public String test(){
        return "Hola aca se supone que se ejecuta un test, chaop";
    }
    
    
    

    public void CerrarNavegador(){
    
         BasePage.initBaseTest().closeDriver();
           
    }
    
}
