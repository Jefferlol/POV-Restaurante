
package proyecto;

import javax.swing.JOptionPane;


public class login extends javax.swing.JFrame {
    
    private char senha;
    private String user = "admin";
    private String key = "admin";

   
    public login() {
        initComponents();
        senha = password_1.getEchoChar();
        setLocationRelativeTo(null);
    }
    
 

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        usuario = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jCheckBox1 = new javax.swing.JCheckBox();
        jLabel6 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        password_1 = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Login");
        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(420, 320));
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jLabel1.setText("\"LOGIN DE INGRESO RESTOBAR\"");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(60, -10, 410, 67);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyecto/login.png"))); // NOI18N
        getContentPane().add(jLabel2);
        jLabel2.setBounds(10, 50, 130, 170);
        getContentPane().add(jLabel3);
        jLabel3.setBounds(0, 0, 0, 0);
        getContentPane().add(jLabel4);
        jLabel4.setBounds(0, 0, 0, 0);

        usuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usuarioActionPerformed(evt);
            }
        });
        getContentPane().add(usuario);
        usuario.setBounds(150, 90, 220, 30);

        jLabel7.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyecto/identificador.png"))); // NOI18N
        jLabel7.setText("Usuario:");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(150, 50, 100, 40);

        jLabel5.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyecto/senha.png"))); // NOI18N
        jLabel5.setText("Password:");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(150, 120, 120, 40);

        jCheckBox1.setText("Mostrar contraseña");
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });
        getContentPane().add(jCheckBox1);
        jCheckBox1.setBounds(180, 190, 140, 20);

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyecto/exibirSenha.png"))); // NOI18N
        getContentPane().add(jLabel6);
        jLabel6.setBounds(150, 180, 60, 40);

        jButton1.setText("Iniciar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(150, 220, 100, 23);

        password_1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                password_1ActionPerformed(evt);
            }
        });
        getContentPane().add(password_1);
        password_1.setBounds(150, 160, 220, 30);

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void login_1() {
        if (new String(password_1.getPassword()).equals(key) && usuario.getText().equals(user)) {

            menu menu = new menu();
            menu.setVisible(true);
            this.dispose();

        } else {

            JOptionPane.showMessageDialog(this, "Usuario o Contraseña no validos", "ERROR", JOptionPane.ERROR_MESSAGE);

        }

    }
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       login_1();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void usuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usuarioActionPerformed
        login_1();
    }//GEN-LAST:event_usuarioActionPerformed

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed
         if (jCheckBox1.isSelected()) {
            
            password_1.setEchoChar('\u0000');
            jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyecto/ocultarSenha.png")));
            jCheckBox1.setText("Ocultar Contraseña"); 
           
        } else {
            
            password_1.setEchoChar(senha);
            jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyecto/exibirSenha.png")));
            jCheckBox1.setText("Mostrar Contraseña"); 
            
        }
    }//GEN-LAST:event_jCheckBox1ActionPerformed

    private void password_1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_password_1ActionPerformed
        login_1();
    }//GEN-LAST:event_password_1ActionPerformed

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
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPasswordField password_1;
    private javax.swing.JTextField usuario;
    // End of variables declaration//GEN-END:variables
}
