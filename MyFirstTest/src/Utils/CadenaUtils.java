/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

/**
 *
 * @author Seba-OS
 */
public class CadenaUtils{
    // str - Alta Posp de plan
    // pivote - PosP
    // Comaramos el primero con el segundo, el primero como pivote
    public static boolean compararCadenas(String pivote, String str){
        String povitillo = pivote.toLowerCase();
        String stringuillo = str.toLowerCase();
        if (povitillo.length() > stringuillo.length()) {
            return false;
        } else {
            //boolean ret = false;
            for (int i = 0; i < stringuillo.length(); i++) {
                
                if (stringuillo.charAt(i) == povitillo.charAt(0)) {
                    // System.out.println("Primer Comparacion - Compara pivote char "+ pivote.charAt(0) + " compara con "+ str.charAt(i));
                    int aux = i;
                    for (int j = 0; j < povitillo.length(); j++) {
                        /*if (str.charAt(aux) == ' ' && pivote.charAt(j) == ' ') {
                        System.out.println("son vacios");
                        aux++;
                        continue;
                        }*/
                        if (stringuillo.charAt(aux) != povitillo.charAt(j)) {
                            //  System.out.println("Compara pivote char "+ pivote.charAt(j) + " compara con "+ str.charAt(aux) );
                            break;
                        }
                        if (j == povitillo.length()-1) {
                            return true;
                        }
                        aux++;
                    }
                }
            }
        }
        return false;
    }
    //094 838 603
    public static String formatoNumber(String num){
        return num.substring(0, 2)+" "+num.substring(2, 5)+" "+num.substring(5, 8);
    }
}
