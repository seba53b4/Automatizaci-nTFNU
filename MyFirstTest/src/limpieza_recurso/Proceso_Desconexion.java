/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package limpieza_recurso;

import Base.BasePage;
import Utils.HandleFile;
import java.util.HashMap;
import java.util.LinkedList;
import org.junit.Test;
import pages.DesconectarPage;
import pages.LoginPage;

/**
 *
 * @author ipupo
 */
public class Proceso_Desconexion {
    
    private HandleFile hf;
    HashMap<String, LinkedList<String>> datosEntrada;
    public Proceso_Desconexion()
    {
        BasePage.initBaseTest();
        hf = HandleFile.getHandleFile();
        datosEntrada = hf.readArchivoEntradaDesconexion();
    }
    
    
    
    public void desconectar() throws InterruptedException{
      LoginPage lp = new LoginPage();
      DesconectarPage dp = new DesconectarPage();
      for (HashMap.Entry<String, LinkedList<String>>entry : datosEntrada.entrySet()) {
            dp.initUrlBusqueda(entry.getKey());
            lp.Nav();
         if(entry.getKey().equals("jit")){
         lp.signIn_Jit();
         }
         else{
         lp.signIn();
         }
            for (String num : entry.getValue()) {
                System.out.println(num);
                dp.initUrlBusqueda(entry.getKey());
                dp.buscarLinea(num);
                dp.Desconectar(num);
                hf.writeArchivoSO_Desconexion(dp.getSoCreadas());
                
                //busqueda estado logico , iccid
            }
            
        }
      
      
    }
}
