
package proyecto;
import java.text.SimpleDateFormat;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;





public class clientes_atendidos extends javax.swing.JFrame {
   

    public clientes_atendidos() {
       
        initComponents();

    }
    
   
   

    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jDialog1 = new javax.swing.JDialog();
        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        boton_detalle = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabla_total = new javax.swing.JTable();
        boton_baucher = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyecto/Diseño sin título (2).png"))); // NOI18N

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(900, 750));
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setMinimumSize(new java.awt.Dimension(800, 620));
        jPanel1.setLayout(null);

        boton_detalle.setBackground(new java.awt.Color(255, 255, 51));
        boton_detalle.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        boton_detalle.setForeground(new java.awt.Color(51, 0, 255));
        boton_detalle.setText("Detalle");
        boton_detalle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_detalleActionPerformed(evt);
            }
        });
        jPanel1.add(boton_detalle);
        boton_detalle.setBounds(600, 180, 270, 130);

        tabla_total.setBackground(new java.awt.Color(153, 153, 255));
        tabla_total.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "#", "Producto", "Cantidad", "Precio", "Fecha"
            }
        ));
        jScrollPane2.setViewportView(tabla_total);

        jPanel1.add(jScrollPane2);
        jScrollPane2.setBounds(30, 130, 530, 450);

        boton_baucher.setBackground(new java.awt.Color(255, 255, 0));
        boton_baucher.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        boton_baucher.setForeground(new java.awt.Color(0, 0, 255));
        boton_baucher.setText("Baucher");
        boton_baucher.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_baucherActionPerformed(evt);
            }
        });
        jPanel1.add(boton_baucher);
        boton_baucher.setBounds(600, 350, 270, 130);

        jLabel4.setBackground(new java.awt.Color(51, 51, 255));
        jLabel4.setFont(new java.awt.Font("Segoe UI", 3, 36)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 255));
        jLabel4.setText("Pedido Entregado del Dia:");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(30, 20, 530, 60);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyecto/103825100-comida-de-restaurante.jpg"))); // NOI18N
        jPanel1.add(jLabel1);
        jLabel1.setBounds(240, 110, 480, 480);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 1030, 710);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void boton_baucherActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_baucherActionPerformed
        

    }//GEN-LAST:event_boton_baucherActionPerformed

    private void boton_detalleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_detalleActionPerformed
       

    }//GEN-LAST:event_boton_detalleActionPerformed


    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
              
                // Si `pedidos_1` requiere datos para funcionar, asegúrate de agregar esos datos aquí

                // Mostrar la ventana `clientes_atendidos`
                new clientes_atendidos().setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton boton_baucher;
    private javax.swing.JButton boton_detalle;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tabla_total;
    // End of variables declaration//GEN-END:variables

   
}
