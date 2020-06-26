/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frames;

import java.util.LinkedList;
import java.util.concurrent.ExecutionException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Seba-OS
 */
public class WorkerExecutor extends Thread {

    LinkedList<Worker> works ;
    
    public WorkerExecutor(LinkedList<Worker> wks){
        works = wks;
    }
    
    @Override
    public void run() {
        
        for (Worker wk : works) {
            wk.execute();
            try {
                wk.get();
            } catch (InterruptedException ex) {
                Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ExecutionException ex) {
                Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        } //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
