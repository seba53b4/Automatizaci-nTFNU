/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objects;

import Base.BaseTest;
import java.util.LinkedList;

/**
 *
 * @author seolivera
 */
public class Testeador {
    
    public static Testeador testeador;
    private LinkedList<Cliente> clientes;
    private LinkedList<Test> tests;
    
    
    public static Testeador initTesteador()
    {
        if (testeador == null) {
            testeador = new Testeador();            
        }
        return testeador;
    }
    
    
    
}
