package Frames;


import javax.swing.JOptionPane;
import pages.LoginPage;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Seba-OS
 */
public class LoginFrame extends javax.swing.JFrame {

    /**
     * Creates new form JFrameTests
     */
    private boolean estaLogueado;
    public LoginFrame() {
        initComponents();
        estaLogueado = false;
        this.setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txtField_User = new javax.swing.JTextField();
        psw_Field = new javax.swing.JPasswordField();
        btn_LogIn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(txtField_User, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 190, 259, 41));
        jPanel1.add(psw_Field, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 240, 259, 39));

        btn_LogIn.setText("Log in");
        btn_LogIn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_LogInActionPerformed(evt);
            }
        });
        jPanel1.add(btn_LogIn, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 310, 259, 37));

        jLabel1.setFont(new java.awt.Font("Constantia", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Hello there !!");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 494, 89));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_LogInActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_LogInActionPerformed
        
        if (psw_Field.getText().isEmpty() && txtField_User.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "No deben ser vacios", "Error", JOptionPane.ERROR_MESSAGE);
        } else if (!psw_Field.getText().isEmpty() && txtField_User.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Debe ingresar Usuario", "Error", JOptionPane.ERROR_MESSAGE);
        } else if (psw_Field.getText().isEmpty() && !txtField_User.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Debe ingresar Password", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            MainFrame.getInstance();
            MainFrame.getInstance().setUser(txtField_User.getText());
            MainFrame.getInstance().setPass(psw_Field.getText());
            MainFrame.getInstance().show();
            this.dispose();
        }
    }//GEN-LAST:event_btn_LogInActionPerformed

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
            java.util.logging.Logger.getLogger(LoginFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_LogIn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField psw_Field;
    private javax.swing.JTextField txtField_User;
    // End of variables declaration//GEN-END:variables
}
