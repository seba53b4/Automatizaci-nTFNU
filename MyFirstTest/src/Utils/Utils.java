/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 *
 * @author Seba-OS
 */
public class Utils {
    
    
    private static Utils util;
    
    public static Utils getInstance(){
        if (util == null) {
            util = new Utils();
        }
        return util;
    }
    
    
    public Date toDate(String str){
         
          String []datos = str.split(" ");
//          for (int i = 0; i < datos.length; i++) {
//              System.out.println("datos "+datos[i]);
//            
//        }
          String[] fecha = datos[1].split("/");
//          for (int i = 0; i < fecha.length; i++) {
//              System.out.println("datos fecha "+ fecha[i]);
//              System.out.println("parseado "+ Integer.parseInt(fecha[i]));
//            
//        }
          String[] hora = datos[2].split(":");
         
          Date date = new GregorianCalendar(Integer.parseInt(fecha[2]), Integer.parseInt(fecha[0])-1, Integer.parseInt(fecha[1]), 
                  Integer.parseInt(hora[0]),Integer.parseInt(hora[1]), Integer.parseInt(hora[2])).getTime();
          
          return date;
    }
    
}
