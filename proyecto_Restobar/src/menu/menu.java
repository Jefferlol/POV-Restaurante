/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package menu;

/**
 *
 * @author wilia
 */
public class menu extends javax.swing.JFrame {

    /**
     * Creates new form menu
     */
    public menu() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel_categoria = new javax.swing.JPanel();
        categorias = new javax.swing.JButton();
        hamburguesa = new javax.swing.JButton();
        salchipapa = new javax.swing.JButton();
        alitas = new javax.swing.JButton();
        piqueos = new javax.swing.JButton();
        postres = new javax.swing.JButton();
        gaseosa = new javax.swing.JButton();
        refresco1 = new javax.swing.JButton();
        cervesa = new javax.swing.JButton();
        cigarros = new javax.swing.JButton();
        cocteles2 = new javax.swing.JButton();
        pack = new javax.swing.JButton();
        panel_opciones = new javax.swing.JPanel();
        texto_Categoria = new javax.swing.JButton();
        panel_pedidos = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        panel_categoria.setBackground(new java.awt.Color(153, 153, 255));
        panel_categoria.setForeground(new java.awt.Color(153, 153, 255));
        panel_categoria.setLayout(null);

        categorias.setBackground(new java.awt.Color(51, 51, 51));
        categorias.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        categorias.setForeground(new java.awt.Color(255, 255, 255));
        categorias.setText("categorias");
        panel_categoria.add(categorias);
        categorias.setBounds(0, 0, 230, 40);

        hamburguesa.setText("Hamburguesa");
        panel_categoria.add(hamburguesa);
        hamburguesa.setBounds(0, 40, 230, 30);

        salchipapa.setText("Salchipapa");
        panel_categoria.add(salchipapa);
        salchipapa.setBounds(0, 70, 230, 30);

        alitas.setText("Alitas");
        panel_categoria.add(alitas);
        alitas.setBounds(0, 100, 230, 30);

        piqueos.setText("Piqueos");
        panel_categoria.add(piqueos);
        piqueos.setBounds(0, 130, 230, 30);

        postres.setText("Postres");
        panel_categoria.add(postres);
        postres.setBounds(0, 160, 230, 30);

        gaseosa.setText("Gaseosa");
        panel_categoria.add(gaseosa);
        gaseosa.setBounds(0, 190, 230, 30);

        refresco1.setText("Refrescos");
        panel_categoria.add(refresco1);
        refresco1.setBounds(0, 220, 230, 30);

        cervesa.setText("Cervesa");
        panel_categoria.add(cervesa);
        cervesa.setBounds(0, 250, 230, 30);

        cigarros.setText("Cigarros");
        panel_categoria.add(cigarros);
        cigarros.setBounds(0, 340, 230, 30);

        cocteles2.setText("Cocteles");
        panel_categoria.add(cocteles2);
        cocteles2.setBounds(0, 280, 230, 30);

        pack.setText("Pack de bebidas");
        panel_categoria.add(pack);
        pack.setBounds(0, 310, 230, 30);

        getContentPane().add(panel_categoria);
        panel_categoria.setBounds(520, 50, 230, 370);

        panel_opciones.setBackground(new java.awt.Color(204, 204, 255));
        panel_opciones.setLayout(null);
        panel_opciones.add(texto_Categoria);
        texto_Categoria.setBounds(0, 0, 250, 40);

        getContentPane().add(panel_opciones);
        panel_opciones.setBounds(260, 50, 250, 370);

        panel_pedidos.setBackground(new java.awt.Color(204, 204, 255));
        panel_pedidos.setLayout(null);

        jButton1.setText("Pedidos");
        panel_pedidos.add(jButton1);
        jButton1.setBounds(0, 0, 138, 34);

        getContentPane().add(panel_pedidos);
        panel_pedidos.setBounds(30, 50, 220, 370);

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new menu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton alitas;
    private javax.swing.JButton categorias;
    private javax.swing.JButton cervesa;
    private javax.swing.JButton cigarros;
    private javax.swing.JButton cocteles2;
    private javax.swing.JButton gaseosa;
    private javax.swing.JButton hamburguesa;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton pack;
    private javax.swing.JPanel panel_categoria;
    private javax.swing.JPanel panel_opciones;
    private javax.swing.JPanel panel_pedidos;
    private javax.swing.JButton piqueos;
    private javax.swing.JButton postres;
    private javax.swing.JButton refresco1;
    private javax.swing.JButton salchipapa;
    private javax.swing.JButton texto_Categoria;
    // End of variables declaration//GEN-END:variables
}
