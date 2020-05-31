/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frames;

import Base.BasePage;
import Tests.TestAltaPP;
import Tests.TestAltaPosP;
import Tests.TestEmpClient;
import Tests.TestNewResiClient;
import Utils.CadenaUtils;
import Utils.Client;
import Utils.HandleFile;
import Utils.Plan;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import pages.LoginPage;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.table.JTableHeader;

import Tests.TestAltaPP;
import Tests.TestAltaPosP;
import Tests.TestEmpClient;
import Tests.TestNewResiClient;
import Utils.CadenaUtils;
import Utils.Client;
import Utils.Plan;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 *
 * @author seolivera
 */
public class MainFrame extends javax.swing.JFrame {

    private String dir;
    HashMap<String, List<Client>>  clientesRes;
    HashMap<String, List<Plan>> planesPP;
    HashMap<String, List<Plan>> planesPosP;
    HashMap<String, List<Client>> clientesEmp;
    private static  MainFrame mf;
    private String user;
    private String pass;
    
    

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
    
   private void iniciarComponentes() {
  
  
  
 }
    public MainFrame() {
       imagenfondo image=new imagenfondo();
       image.setImage("/Images/fondo-horizonte-futurista_23-2148292294.jpg");
       setContentPane(image);  
     initComponents();
        this.user = "random";
        this.pass = "random";
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
                
                tb.addRow(new Object[]{false,"Cargado Archivo - Alta cliente residencial "+ cl.getAmbiente().toUpperCase()+":    "+ cl.getName() + " "+ cl.getSecondName() ,"No iniciado"});
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
        ButtonEjecutar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        TablaTest.setBackground(new java.awt.Color(139, 195, 224));
        TablaTest.setBorder(new javax.swing.border.MatteBorder(new javax.swing.ImageIcon(getClass().getResource("/Images/Telefonica.original_IG2rXLU.jpg")))); // NOI18N
        TablaTest.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
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
        TablaTest.setGridColor(new java.awt.Color(139, 195, 224));
        jScrollPane1.setViewportView(TablaTest);
        if (TablaTest.getColumnModel().getColumnCount() > 0) {
            TablaTest.getColumnModel().getColumn(0).setResizable(false);
            TablaTest.getColumnModel().getColumn(1).setResizable(false);
            TablaTest.getColumnModel().getColumn(2).setResizable(false);
        }

        ButtonEjecutar.setBackground(new java.awt.Color(204, 204, 255));
        ButtonEjecutar.setFont(new java.awt.Font("Arial", 3, 18)); // NOI18N
        ButtonEjecutar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/execute.png"))); // NOI18N
        ButtonEjecutar.setText("EJECUTAR");
        ButtonEjecutar.setAlignmentY(0.0F);
        ButtonEjecutar.setBorder(new javax.swing.border.MatteBorder(null));
        ButtonEjecutar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonEjecutarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(135, 135, 135)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 725, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addComponent(ButtonEjecutar, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(174, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(237, 237, 237))
            .addGroup(layout.createSequentialGroup()
                .addGap(236, 236, 236)
                .addComponent(ButtonEjecutar, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ButtonEjecutarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonEjecutarActionPerformed
        
        LinkedList<Worker> works = new LinkedList<>();
        for (int i = 0; i < TablaTest.getRowCount(); i++) {
            if ( TablaTest.getValueAt(i, 0).equals(true)) {
                
                if (CadenaUtils.compararCadenas("Alta cliente residencial:", TablaTest.getValueAt(i, 1).toString())){
                    System.out.println("Es boolean y esta seleccionado la pos; "+ i);
                    TestNewResiClient tn = new TestNewResiClient();
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
    private javax.swing.JTable TablaTest;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

    
}
