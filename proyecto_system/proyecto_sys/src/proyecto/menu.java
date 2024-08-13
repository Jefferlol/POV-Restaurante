
package proyecto;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JFrame;
import javax.swing.JPanel;
import proyecto.pedidos_1;

public class menu extends javax.swing.JFrame {
    private menu_opciones menuOpciones;
    public menu() {
        initComponents();
        menuOpciones = new menu_opciones();
        
    }
    private HashMap<String, ArrayList<String[]>> obtenerPedidos() {
        if (menuOpciones != null) {
            return menuOpciones.getPedidosPorMesa();
        }
        return new HashMap<>();
    }
     

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel_menu = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        panel_principal = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1286, 750));
        getContentPane().setLayout(null);

        panel_menu.setBackground(new java.awt.Color(0, 0, 0));
        panel_menu.setMinimumSize(new java.awt.Dimension(800, 720));
        panel_menu.setLayout(null);

        jButton1.setBackground(new java.awt.Color(250, 250, 250));
        jButton1.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(0, 255, 0));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyecto/icons8-factura-50.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        panel_menu.add(jButton1);
        jButton1.setBounds(10, 500, 100, 90);

        jButton2.setBackground(new java.awt.Color(250, 250, 250));
        jButton2.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(51, 255, 0));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyecto/icons8-producto-50.png"))); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        panel_menu.add(jButton2);
        jButton2.setBounds(10, 610, 100, 90);

        jButton3.setBackground(new java.awt.Color(250, 250, 250));
        jButton3.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jButton3.setForeground(new java.awt.Color(0, 255, 0));
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icons8-terminal-punto-de-venta-50.png"))); // NOI18N
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        panel_menu.add(jButton3);
        jButton3.setBounds(10, 170, 100, 90);

        jButton4.setBackground(new java.awt.Color(250, 250, 250));
        jButton4.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jButton4.setForeground(new java.awt.Color(51, 255, 0));
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyecto/pngegg (1).png"))); // NOI18N
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        panel_menu.add(jButton4);
        jButton4.setBounds(10, 280, 100, 90);

        jButton5.setBackground(new java.awt.Color(250, 250, 250));
        jButton5.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jButton5.setForeground(new java.awt.Color(0, 255, 0));
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyecto/icons8-cliente-50.png"))); // NOI18N
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        panel_menu.add(jButton5);
        jButton5.setBounds(10, 390, 100, 90);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyecto/Diseño sin título (3).png"))); // NOI18N
        jLabel1.setToolTipText("");
        jLabel1.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jLabel1.setMinimumSize(new java.awt.Dimension(50, 40));
        jLabel1.setPreferredSize(new java.awt.Dimension(120, 140));
        panel_menu.add(jLabel1);
        jLabel1.setBounds(-10, 30, 170, 160);

        getContentPane().add(panel_menu);
        panel_menu.setBounds(0, 0, 120, 710);

        panel_principal.setBackground(new java.awt.Color(255, 255, 255));
        panel_principal.setMinimumSize(new java.awt.Dimension(800, 740));
        panel_principal.setPreferredSize(new java.awt.Dimension(900, 620));
        panel_principal.setLayout(null);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyecto/103825100-comida-de-restaurante.jpg"))); // NOI18N
        panel_principal.add(jLabel2);
        jLabel2.setBounds(240, 110, 480, 480);

        getContentPane().add(panel_principal);
        panel_principal.setBounds(120, 0, 1150, 710);

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void actualizarPanelPrincipal(JFrame nuevoContenido) {
        panel_principal.removeAll();
        panel_principal.add(nuevoContenido.getContentPane());
        panel_principal.revalidate();
        panel_principal.repaint();
    }
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
         actualizarPanelPrincipal(menuOpciones);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
         inventario in = new inventario();
        actualizarPanelPrincipal(in);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed

        HashMap<String, ArrayList<String[]>> pedidosPorMesa = obtenerPedidos();
        if (pedidosPorMesa != null) {
            pedidos_1 p = new pedidos_1(pedidosPorMesa);
            panel_principal.removeAll();
            panel_principal.add(p.getContentPane());
            panel_principal.revalidate();
            panel_principal.repaint();
        } else {
            System.out.println("No se pudo obtener el HashMap de pedidos.");
        }

    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        clientes_atendidos c = new clientes_atendidos();
        actualizarPanelPrincipal(c);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        comprobante b = new comprobante();
        actualizarPanelPrincipal(b);
    }//GEN-LAST:event_jButton1ActionPerformed
    


    public static void main(String args[]) {
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
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new menu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel panel_menu;
    private javax.swing.JPanel panel_principal;
    // End of variables declaration//GEN-END:variables
}
