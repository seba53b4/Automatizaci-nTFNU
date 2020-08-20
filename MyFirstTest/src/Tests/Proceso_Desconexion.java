/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Tests;

import Base.BasePage;
import Frames.MainFrame;
import Utils.HandleFile;
import java.util.HashMap;
import java.util.LinkedList;
import pages.DesconectarPage;
import pages.LoginPage;
import java.io.IOException;
import Utils.Limpieza_Class;
import Utils.Plan;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.Test;
/**
 *
 * @author ipupo
 */
public class Proceso_Desconexion extends Base.BaseTest{
    
    //private HandleFile hf;
    //HashMap<String, LinkedList<String>> datosEntrada;
    Plan p;
    DesconectarPage dp;
    
    public Proceso_Desconexion(Plan plan){
        p = plan;
    }
    
    
    @Override
    public String test() {
       try {
           this.desconectar();
           return "OK";
       } catch (Exception ex) {
           
           try {
               HandleFile.getHandleFile().registrarError("ERROR Desconectar page \n\n"+ ex+"\n\n---------------------------------------------------------------------------\n\n");
           } catch (IOException ex1) {
               Logger.getLogger(Proceso_Desconexion.class.getName()).log(Level.SEVERE, null, ex1);
           }
           return "Falló";
       } finally{
      //     BasePage.initBaseTest().closeDriver();
       }
    }
    
   @Test
    public void desconectar() throws InterruptedException, IOException, Exception{
        BasePage.initBaseTest();
        
        //hf = HandleFile.getHandleFile();
        //datosEntrada = hf.readArchivoEntradaDesconexion();
        //cargaDatosLimpieza();
        
        LoginPage lp = LoginPage.getLoginPage();
        
        //BasePage.getNewDriver();
        //for (HashMap.Entry<String, LinkedList<String>>entry : datosEntrada.entrySet()) {
        
        String enviroment = p.getAmbiente();
        dp.initUrlBusqueda(enviroment);
        lp.Nav(enviroment);
        // if(enviroment.contains("preprod")){
        lp.signIn_preprod();
        //}
        // else{
        //    lp.signIn();
        //}
        // for (String num : entry.getValue()) {
        System.out.println(p.getMSISDN());
        //dp.initUrlBusqueda(enviroment);
        dp.buscarLinea(p.getMSISDN());
        
        dp.set_SIM(p.getMSISDN());
        dp.Desconectar(p);
        
          }
          
     // }
          
  //  }
   /* public void verificar() throws InterruptedException{
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
        
        
    }*/
    
    
    
}


