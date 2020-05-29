/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frames;

import Base.BasePage;
import Base.BaseTest;
import Tests.TestAltaPP;
import Tests.TestAltaPosP;
import Tests.TestEmpClient;
import Tests.TestNewResiClient;
import Utils.CadenaUtils;
import Utils.Client;
import Utils.HandleFile;
import Utils.Plan;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import pages.LoginPage;

/**
 *
 * @author seolivera
 */
public class MainFrame extends javax.swing.JFrame {

    private String dir;
    private HashMap<String, List<Plan>> planesPP;
    private HashMap<String, List<Plan>> planesPosP;
    private HashMap<String, List<Client>> clientesEmp;
    private HashMap<String, List<Client>>  clientesRes;
    private HashMap<String, BaseTest> tests;
    private static  MainFrame mf;
    private String user;
    private String pass;


    public HashMap<String, List<Client>> getClientesRes() {
        return clientesRes;
    }

    public HashMap<String, List<Plan>> getPlanesPP() {
        return planesPP;
    }

    public HashMap<String, List<Plan>> getPlanesPosP() {
        return planesPosP;
    }

    public HashMap<String, List<Client>> getClientesEmp() {
        return clientesEmp;
    }
    public void setUser(String user) {
        this.user = user;
        LoginPage.initLoginPage().setUsuario(user);
        
    }

    public void setPass(String pass) {
        this.pass = pass;
        LoginPage.initLoginPage().setPassword(pass);
    }
    
     /**
     * Creates new form MainFrame
     *
     */
    public static MainFrame getInstance(){
        if (mf == null) {
            mf = new MainFrame();
        }
        return mf;
    }
    public MainFrame() {
        
        initComponents();
        this.user = "random";
        this.pass = "random";
        tests = new HashMap<>();
        //BasePage.initBaseTest();
        LoginPage.initLoginPage();
        this.setLocationRelativeTo(null);
        TableColumn c =  this.TablaTest.getColumnModel().getColumn(0);//
       // c.setPreferredWidth(25);
        c.setMaxWidth(90);
        c.setMinWidth(90);
        c =  this.TablaTest.getColumnModel().getColumn(2);
       // c.setPreferredWidth(55);
        c.setMaxWidth(90);
        c.setMinWidth(90);
        
        HandleFile.initHandleFile();
        DefaultTableModel tb ;
        try {
            clientesRes = HandleFile.getHandleFile().readRegisterDataSource("new_residential_client");
        } catch (Exception e) {
            System.out.println("Error al cargar hoja de residencial" + e);
        }
        
        tb = (DefaultTableModel) TablaTest.getModel();
        
        for (Map.Entry<String, List<Client>> entry : clientesRes.entrySet()) {
            for (Client cl : entry.getValue()) {
                String str = "Cargado Archivo - Alta cliente residencial "+ cl.getAmbiente().toUpperCase()+":    "+ cl.getName() + " "+ cl.getSecondName();
                tb.addRow(new Object[]{false,str,"No iniciado"});
                tests.put(str, new TestNewResiClient(cl));
            }
        }
        try {
            clientesEmp = HandleFile.getHandleFile().readRegisterDataSource("new_enterprise_client");
            

              tb = (DefaultTableModel) TablaTest.getModel();

            for (Map.Entry<String, List<Client>> entry : clientesEmp.entrySet()) {
                for (Client cl : entry.getValue()) {

                    tb.addRow(new Object[]{false,"Cargado Archivo - Alta cliente empresarial "+ cl.getAmbiente().toUpperCase()+":    "+ cl.getName() + " "+ cl.getSecondName() ,"No iniciado"});
                }
            }
        } catch (Exception e) {
            System.out.println("Error al cargar clietnes Empresariales" + e);
        }
        
        
        try {
            planesPP = HandleFile.getHandleFile().readRegisterDataSource("new_plan");
        } catch (Exception e) {
             System.out.println("Error al cargar plan" + e);
        }
         
        tb = (DefaultTableModel) TablaTest.getModel();
        
        for (Map.Entry<String, List<Plan>> entry : planesPP.entrySet()) {
            for (Plan p : entry.getValue()) {
                if (CadenaUtils.compararCadenas("PLTT",p.getName()) || CadenaUtils.compararCadenas("PLK",p.getName())||CadenaUtils.compararCadenas("PLGP",p.getName()) ) {
                    tb.addRow(new Object[]{false,"Cargado Archivo - Alta Plan PP "+ p.getAmbiente().toUpperCase()+":    "+p.getName() + " en cliente de object_id: "+p.getObject_id() ,"No iniciado"});
                    
                } else {
                    tb.addRow(new Object[]{false,"Cargado Archivo - Alta Plan PosP "+ p.getAmbiente().toUpperCase()+":    "+ p.getName() + " en cliente de object_id: "+p.getObject_id() ,"No iniciado"});
                }
            }
        }
        
         
        
        
        
        
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        TablaTest = new javax.swing.JTable();
        ButtonSeleccionarTodos = new javax.swing.JButton();
        ButtonEjecutar = new javax.swing.JButton();
        jProgressBar1 = new javax.swing.JProgressBar();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        TablaTest.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        TablaTest.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Seleccionado", "Test", "Estado"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Boolean.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                true, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(TablaTest);
        if (TablaTest.getColumnModel().getColumnCount() > 0) {
            TablaTest.getColumnModel().getColumn(0).setResizable(false);
            TablaTest.getColumnModel().getColumn(1).setResizable(false);
            TablaTest.getColumnModel().getColumn(2).setResizable(false);
        }

        ButtonSeleccionarTodos.setText("Seleccionar Todos");
        ButtonSeleccionarTodos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonSeleccionarTodosActionPerformed(evt);
            }
        });

        ButtonEjecutar.setText("Ejecutar");
        ButtonEjecutar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonEjecutarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jProgressBar1, javax.swing.GroupLayout.DEFAULT_SIZE, 769, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(ButtonEjecutar, javax.swing.GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE)
                    .addComponent(ButtonSeleccionarTodos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(19, 19, 19))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(150, 150, 150)
                        .addComponent(ButtonSeleccionarTodos, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(ButtonEjecutar, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(150, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 374, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)))
                .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ButtonEjecutarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonEjecutarActionPerformed
        
        LinkedList<Worker> works = new LinkedList<>();
        for (int i = 0; i < TablaTest.getRowCount(); i++) {
            if ( TablaTest.getValueAt(i, 0).equals(true)) {
                
                if (CadenaUtils.compararCadenas("Alta cliente residencial:", TablaTest.getValueAt(i, 1).toString())){
                    System.out.println("Es boolean y esta seleccionado la pos; "+ i);
                    TestNewResiClient tn = (TestNewResiClient) tests.get(TablaTest.getValueAt(i, 1).toString());
                    Worker wk = new Worker(TablaTest, tn, i);
                    works.add(wk);
                    continue;
                }
                
                if (CadenaUtils.compararCadenas("Alta cliente empresarial:", TablaTest.getValueAt(i, 1).toString())) {
                    System.out.println("Es boolean y esta seleccionado la pos; "+ i);
                    TestEmpClient tn = new TestEmpClient();
                    Worker wk = new Worker(TablaTest, tn, i);
                    works.add(wk);
                    continue;
                }
                
                if (CadenaUtils.compararCadenas("PP", TablaTest.getValueAt(i, 1).toString())) {
                    System.out.println("Es boolean y esta seleccionado la pos; "+ i);
                    TestAltaPP tap = new TestAltaPP();
                    Worker wk = new Worker(TablaTest, tap, i);
                    works.add(wk);
                    continue;
                }
                if (CadenaUtils.compararCadenas("PosP", TablaTest.getValueAt(i, 1).toString())) {
                    System.out.println("Alta de Posp esta seleccionado pos; "+ i);
                    TestAltaPosP tap = new TestAltaPosP();
                    Worker wk = new Worker(TablaTest, tap, i);
                    works.add(wk);
                    continue;
                }
            }
        }
        for (Worker wk : works) {
            wk.execute();
            System.out.println("Ejecutando");
        }
    }//GEN-LAST:event_ButtonEjecutarActionPerformed

    private void ButtonSeleccionarTodosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonSeleccionarTodosActionPerformed
        
        DefaultTableModel tb = (DefaultTableModel) TablaTest.getModel();
        
        for (int i = 0; i < tb.getRowCount(); i++) {
            tb.setValueAt(true, i, 0);
        }
    }//GEN-LAST:event_ButtonSeleccionarTodosActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ButtonEjecutar;
    private javax.swing.JButton ButtonSeleccionarTodos;
    private javax.swing.JTable TablaTest;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
