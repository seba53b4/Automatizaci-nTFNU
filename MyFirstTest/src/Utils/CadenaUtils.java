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
        
        if (pivote.length() > str.length()) {
            return false;
        } else {
            //boolean ret = false;
            for (int i = 0; i < str.length(); i++) {
                
                if (str.charAt(i) == pivote.charAt(0)) {
                    System.out.println("Primer Comparacion - Compara pivote char "+ pivote.charAt(0) + " compara con "+ str.charAt(i));
                    int aux = i;
                    for (int j = 0; j < pivote.length(); j++) {
                        
                        if (str.charAt(aux) != pivote.charAt(j)) {
                            System.out.println("Compara pivote char "+ pivote.charAt(j) + " compara con "+ str.charAt(aux) );
                            break;
                        }
                        if (j == pivote.length()-1) {
                            return true;
                        }
                        aux++;
                        
                    }
                }
                
            }
        }
        return false;
        
    }
}
