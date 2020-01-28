/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author seolivera
 */
public class HandleFile {
    
    private String dir;
    
    
    public HandleFile(String path)
    {
        dir = path;
    }
    
    
    public void altaCliente()
    {
        
        try {
            FileReader fr = new FileReader(dir+"\\Cliente\\Clientes.csv");
            BufferedReader br = new BufferedReader(fr);
            String linea;
            String ant ="";
            String[] aux ;
        while((linea = br.readLine()) != null)
        {
            
        }
        
      } catch(Exception e) {
          System.out.println("Excepcion leyendo fichero " +": " + e);
          
        }
        
    }
    
    public void CargarArchivos(String dir)
    {
        File fallados = new File(dir+"/Failed.txt");
        try
        {
            FileWriter fw = new FileWriter(fallados); 
           
            
            fw.close();
        
        } catch (Exception e){
            System.out.println("Error al leer crear archivo - Failed.txt");
        }
        
        
    }
    
   
    
}

