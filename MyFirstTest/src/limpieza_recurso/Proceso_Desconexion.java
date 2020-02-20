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
import java.util.Map;
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
    HashMap<String, Limpieza_Class> datosLimpieza;

    public HashMap<String, Limpieza_Class> getDatosLimpieza() {
        return datosLimpieza;
    }
    
   
   
    public Proceso_Desconexion()
    {
        BasePage.initBaseTest();
        hf = HandleFile.getHandleFile();
        datosEntrada = hf.readArchivoEntradaDesconexion();
        datosLimpieza = new HashMap<>();
        
        cargaDatosLimpieza();
    }
    
    public void cargaDatosLimpieza()
    {
        for (HashMap.Entry<String, LinkedList<String>>entry : datosEntrada.entrySet()) {
            for (String numero : entry.getValue()) {
                datosLimpieza.put(numero,new Limpieza_Class(numero));
            }
        }
      }
    public void desconectar() throws InterruptedException{
      LoginPage lp = new LoginPage();
      DesconectarPage dp = new DesconectarPage(this);

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
                if(dp.obtener_estado_logicoLinea()== true){
                dp.Desconectar(num);
                dp.getDatosDesconexion();
                //hf.writeArchivoSO_Desconexion(dp.getSoCreadas());
                dp.initUrlBusqueda(entry.getKey());
                
                //dp.cambio_estado(num);
                //busqueda estado logico , iccid
                }
                else
                {
                datosLimpieza.get(num).setStatus("Error estado logico");
                }
               
            }
            
        }
          
                //dp.cambio_estado(num);
                //busqueda estado logico , iccid
    }
    public void verificar() throws InterruptedException{
        DesconectarPage dp = new DesconectarPage(this);
        Limpieza_Class value;
        for (HashMap.Entry<String, LinkedList<String>>entry : datosEntrada.entrySet()) {
            for (String numero : entry.getValue()) {
                value = datosLimpieza.get(numero);
                if (!value.getStatus().contains("Error de linea") && datosLimpieza.get(numero).getSO().length()!=0)
                    if ( dp.get_estadoSOProcesado(numero) ==true) {

                        value.setStatus("Desconectado");
                        //dp.cambio_estado(numero);
                    } else
                    {
                        value.setStatus("Error en SO");
                    }
            }
            hf.writeArchivoSO_Desconexion(datosLimpieza);
        }
        
        
    }
    
    
    
}


