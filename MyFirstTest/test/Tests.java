/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ipupo
 */
public class Tests {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        // TODO code application logic here
        TestAltaPP altaPP= new TestAltaPP();
        TestAltaPosP altaPosP =new TestAltaPosP();
        TestEmpClient altaempClient= new TestEmpClient();
        TestNewResiClient altaresiClient= new TestNewResiClient();
        Test_CambioPlan cambioPlan= new Test_CambioPlan();
        Test_SimCardLost simCard= new Test_SimCardLost();
        
        altaPP.altaPP();
        altaPosP.altaPP();
        altaresiClient.residentialClientRegister();
        altaempClient.altaClienteP();
        cambioPlan.Cambio_Plan();
        simCard.sim_Card_Lost();
        
        
        
    }
    
}
