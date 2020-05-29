/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frames;

import Base.BasePage;
import Base.BaseTest;
import java.util.LinkedList;
import java.util.concurrent.Semaphore;
import javax.swing.JTable;
import javax.swing.SwingWorker;

/**
 *
 * @author Sebaa
 */
public class Worker extends SwingWorker<Void,Void>{

    private JTable tabla;
    private int valor;
    private boolean activo;
    private int ident;
    private LinkedList<String> ejecutar;
    private static Worker wk;
    BaseTest bt ;
    private Semaphore sm;
   
    public static Worker getWorker(){
        return wk;
    }
    
    public Worker(JTable tabla,BaseTest bt, int id)
    {
        activo = true;
        this.tabla = tabla;
        ident = id;
        this.valor = 0;
        this.ejecutar = ejecutar;
        this.bt = bt;
        wk = this;
        sm = new Semaphore(1);
    }
    
    public void cleanBarra(){
        
    }
    
    @Override
    public void done() {
        setProgress(100);
        //barra.setValue(100);
        //barra.setStringPainted(false);
       // barra.setVisible(false);
    } 
                
    @Override
    protected Void doInBackground() throws Exception {
        try
        {
           sm.acquire();
           //BasePage.initBaseTest();
           System.out.println("PROBANDO ");
          
           String str = bt.test();
           tabla.setValueAt(str, ident, 2);
          
           sm.release();
           
          // MainFrame.getInstance().enableBotonEjecutar llamo a Mianframe y dejo enable el boton ejecutar
        } catch (Exception e)
        {
            System.out.println(e);
        }
        return null;
    }
    
    
    public void pintar(){
        //barra.setValue(valor);
        setProgress(valor);
        //barra.repaint();
    }
    /*
    public void aumentarBarra(){
        valor += aumento;
        setProgress(valor);
    }

    public void setAumentar(int val) {
        this.aumento += val;
    }*/
    
    public void setActivo(boolean bol){
        this.activo = bol;
    }

    public int getValor() {
        return valor;
    }

    
    
}
