/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package limpieza_recurso;

import Base.BasePage;
import org.junit.Test;
import pages.LoginPage;

/**
 *
 * @author ipupo
 */
public class Proceso_Desconexion {
    
    public Proceso_Desconexion()
    {
        BasePage.initBaseTest();
    }
    public void desconectar(){
    
      LoginPage lp = new LoginPage();
      lp.visit("https://noprd-jit-toms.temu.com.uy:7002/");
      lp.Nav();
      lp.signIn();
    }
}
