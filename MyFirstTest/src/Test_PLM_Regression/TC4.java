/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test_PLM_Regression;

import Base.BaseTest;
import RegresionTests.TestAltaPosP_Regresion;
import Tests.TestAltaPosP;
import Tests.TestNewResiClient;
import Tests.Test_CambioPlan;
import Utils.Client;
import Utils.HandleFile;
import Utils.Plan;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.junit.Test;
import pages.CostumerPage;

/**
 *
 * @author ipupo
 */
public class TC4 extends BaseTest {
    
    private RegresionTests.TestAltaPosP_Regresion test_alta;
    private Tests.Test_CambioPlan test_cambio;
    private Plan p;
    private Client clte;
    
    //private Tests.Test Desconexion incluirlo
   
    public TC4(Client client) throws Exception{
        HandleFile.initHandleFile();
        clte = client;
        
        // Buscar y asignar el   
        p = new Plan("PLC315");
        System.out.println("Object id cliente : " + clte.getClientId());
        
        p.setAmbiente(clte.getAmbiente());
        p.setObject_id(clte.getClientId());
        p.setMSISDN(HandleFile.getHandleFile().getMSISDN_Regresion(p.getAmbiente()));
        p.setICCID(HandleFile.getHandleFile().getICCID_Regresion(p.getAmbiente()));
        
        this.test_alta = new TestAltaPosP_Regresion(p);
        this.test_cambio = new Test_CambioPlan(p);
        
 }

    @Override
    public String test() {
        
        //Crea el Alta del PLC
        test_alta.test();
        
        
        String str = CostumerPage.getInstance().estadoSOFinal();
        System.out.println("ANTES DE CAMBIO A PP: " + str );
        if (str.equals("Ok")) {
            // Cambio a PP
        p.setName_change_plan("PLTTEJ");
        test_cambio.test();
        } else {
            System.out.println("Error en la SO ");
        }
        
        // 
        str = CostumerPage.getInstance().estadoSOFinal();
        System.out.println("ANTES DE CAMBIO A CC: " + str );
        if (str.equals("Ok")) {
            // Cambio a CC
            p.setName_change_plan("PLC310");
            test_cambio.test();
        } else {
            System.out.println("Error en la SO ");
        }
        
      
        return "hello there!";
    }
    
   
}
