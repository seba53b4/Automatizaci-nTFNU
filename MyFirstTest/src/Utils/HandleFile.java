/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
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
    
    
    public LinkedList<String> readArchivoEntradaDesconexion()
    {
        LinkedList<String> ret = new LinkedList<>();
        try {
            FileReader fr = new FileReader(dir+"\\Desconexion\\archivoEntrada.csv");
            BufferedReader br = new BufferedReader(fr);
            String linea;
            String ant ="";
            String[] aux ;
            while((linea = br.readLine()) != null)
            {
                aux = linea.split(";");
                if (isNumeric(aux[1])) {
                    ret.add(ant);
                }
            }
            fr.close();
        } catch(Exception e) {
          System.out.println("Excepcion leyendo fichero archivoEntrada.csv con Error: " + e);
          
        }
        return ret;
    }
    public boolean writeArchivoSO_Desconexion(String id,String SO)
    {
        File f = new File(dir+"\\Desconexion\\archivoSO.csv");
        try {
            FileWriter fw = new FileWriter(dir+"\\Desconexion\\archivoSO.csv",true);
            BufferedWriter bw = new BufferedWriter(fw);
            String linea = id+";"+SO+"\n";
            bw.write(linea);
            return true;
        } catch(Exception e) {
          System.out.println("Excepcion leyendo fichero archivoSO.csv con Error: " + e);
          
        }
        return false;
    }
    public boolean writeArchivoNumeroSIM_Desconexion(String id,String num,String sim)
    {
        File f = new File(dir+"\\Desconexion\\archivoNumberSIM.csv");
        try {
            FileWriter fw = new FileWriter(dir+"\\Desconexion\\archivoNumberSIM.csv",true);
            BufferedWriter bw = new BufferedWriter(fw);
            String linea = id+";"+num+";"+sim+"\n";
            bw.write(linea);
            return true;
        } catch(Exception e) {
          System.out.println("Excepcion leyendo fichero archivoSO.csv con Error: " + e);
          
        }
        return false;
    }
    public boolean writeArchivoStatus_Desconexion(String id,String estado)
    {
        File f = new File(dir+"\\Desconexion\\archivoStatus.csv");
        try {
            FileWriter fw = new FileWriter(dir+"\\Desconexion\\archivoStatus.csv",true);
            BufferedWriter bw = new BufferedWriter(fw);
            String linea = id+";"+estado+"\n";
            bw.write(linea);
            return true;
        } catch(Exception e) {
          System.out.println("Excepcion leyendo fichero archivoSO.csv con Error: " + e);
          
        }
        return false;
    }
    
    
    
    
    public boolean isNumeric(String cadena){
	try {
                
                LinkedList<String> lst =new LinkedList<>();
                while (cadena.length() != 0) {
                    if (cadena.length() > 7) {
                        lst.add(cadena.substring(0, 6));
                        cadena = cadena.substring(7, cadena.length());
                        
                    } else 
                        {
                            lst.add(cadena.substring(0, cadena.length()));
                            cadena = "";
                        }
                    System.out.println(cadena);
                    
                }
                for (String string : lst) {
                    Integer.parseInt(string);
                    System.out.println(string+" ");
                }
                
		return true;
	} catch (NumberFormatException nfe){
		return false;
	}
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

