/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package limpieza_recurso;

import Utils.HandleFile;
import com.sun.org.apache.bcel.internal.generic.AALOAD;
import java.io.File;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ipupo
 */
public class MainDesconexion {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        File f = new File(".");
        String dir = f.getAbsolutePath().replace(".","");
        HandleFile hf = HandleFile.initHandleFile(dir);
        Proceso_Desconexion pd = new Proceso_Desconexion();
       
        try {
           pd.desconectar();
           pd.cambio();
          
        } catch (InterruptedException ex) {
            Logger.getLogger(MainDesconexion.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        
    }
    
}
