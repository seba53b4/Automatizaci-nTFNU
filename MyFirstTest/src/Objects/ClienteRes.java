/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objects;

import Utils.Plan;
import java.util.HashMap;
import java.util.LinkedList;

/**
 *
 * @author seolivera
 */
public class ClienteRes extends Cliente{
    
    public ClienteRes(String name, String ape, String cat, String typeDoc, String numD, String nat, String dir) {
        super(name, ape, cat, typeDoc, numD, nat, dir);
        planes = new HashMap<>();
    }
    // Key = PLAN
    HashMap<String,LinkedList<Plan>> planes;
    
    
   
}
