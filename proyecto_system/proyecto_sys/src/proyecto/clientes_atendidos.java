
package proyecto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import javax.swing.table.DefaultTableModel;


public class clientes_atendidos extends javax.swing.JFrame {
   
    private Map<String, ArrayList<String[]>> pedidosPorMesa;
    public clientes_atendidos() {
        initComponents();
        pedidosPorMesa = new HashMap<>();
      

    }
    
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jDialog1 = new javax.swing.JDialog();
        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla_detalle = new javax.swing.JTable();
        boton_detalle = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabla_entregada_1 = new javax.swing.JTable();
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
        setMinimumSize(new java.awt.Dimension(800, 750));
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setMinimumSize(new java.awt.Dimension(800, 620));
        jPanel1.setLayout(null);

        tabla_detalle.setBackground(new java.awt.Color(204, 255, 255));
        tabla_detalle.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "#Mesa", "Estado"
            }
        ));
        jScrollPane1.setViewportView(tabla_detalle);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(30, 100, 450, 150);

        boton_detalle.setBackground(new java.awt.Color(51, 255, 0));
        boton_detalle.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        boton_detalle.setForeground(new java.awt.Color(51, 0, 255));
        boton_detalle.setText("Detalle");
        boton_detalle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_detalleActionPerformed(evt);
            }
        });
        jPanel1.add(boton_detalle);
        boton_detalle.setBounds(500, 160, 140, 30);

        tabla_entregada_1.setBackground(new java.awt.Color(204, 255, 255));
        tabla_entregada_1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "#", "Producto", "Cantidad", "Precio", "Fecha"
            }
        ));
        jScrollPane2.setViewportView(tabla_entregada_1);

        jPanel1.add(jScrollPane2);
        jScrollPane2.setBounds(210, 290, 460, 330);

        boton_baucher.setBackground(new java.awt.Color(0, 255, 0));
        boton_baucher.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        boton_baucher.setForeground(new java.awt.Color(0, 0, 255));
        boton_baucher.setText("Baucher");
        boton_baucher.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_baucherActionPerformed(evt);
            }
        });
        jPanel1.add(boton_baucher);
        boton_baucher.setBounds(30, 520, 150, 50);

        jLabel4.setBackground(new java.awt.Color(51, 51, 255));
        jLabel4.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 255));
        jLabel4.setText("Pedido Entregado del Dia");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(30, 20, 530, 60);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyecto/103825100-comida-de-restaurante.jpg"))); // NOI18N
        jPanel1.add(jLabel1);
        jLabel1.setBounds(240, 110, 480, 480);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 900, 710);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void boton_baucherActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_baucherActionPerformed
        DefaultTableModel modeloDetalle = (DefaultTableModel) tabla_detalle.getModel();
        DefaultTableModel modeloEntregada = (DefaultTableModel) tabla_entregada_1.getModel();

        // Limpiar la tabla detalle antes de agregar nuevos datos
        modeloDetalle.setRowCount(0);

        // Iterar sobre todas las filas de la tabla de entregados
        for (int i = 0; i < modeloEntregada.getRowCount(); i++) {
            // Obtener el estado de la mesa (asumiendo que está en la columna 4 de tabla_entregada_1)
            String estado = (String) modeloEntregada.getValueAt(i, 4);

            // Verificar si el estado es "Entregado"
            if ("Entregado".equals(estado)) {
                // Obtener los datos de la fila actual
                Object[] fila = new Object[modeloEntregada.getColumnCount()];
                for (int j = 0; j < modeloEntregada.getColumnCount(); j++) {
                    fila[j] = modeloEntregada.getValueAt(i, j);
                }
                // Agregar la fila a la tabla detalle
                modeloDetalle.addRow(fila);
            }
        }

    }//GEN-LAST:event_boton_baucherActionPerformed

    private void boton_detalleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_detalleActionPerformed
        DefaultTableModel modeloDetalle = (DefaultTableModel) tabla_detalle.getModel();
        DefaultTableModel modeloEntregada = (DefaultTableModel) tabla_entregada_1.getModel();

        // Limpiar la tabla detalle antes de agregar nuevos datos
        modeloDetalle.setRowCount(0);

        // Iterar sobre todas las filas de la tabla de entregados
        for (int i = 0; i < modeloEntregada.getRowCount(); i++) {
            // Obtener el estado de la mesa (asumiendo que está en la columna 4 de tabla_entregada_1)
            String estado = (String) modeloEntregada.getValueAt(i, 4);

            // Verificar si el estado es "Entregado"
            if ("Entregado".equals(estado)) {
                // Obtener el número de mesa (asumiendo que está en la columna 0)
                String mesa = (String) modeloEntregada.getValueAt(i, 0);

                // Agregar la fila a la tabla detalle con el número de mesa y su estado
                modeloDetalle.addRow(new Object[]{mesa, estado});
            }
        }
    }//GEN-LAST:event_boton_detalleActionPerformed
    
    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(clientes_atendidos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        // Invocar la GUI en el hilo de despacho de eventos (Event Dispatch Thread)
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tabla_detalle;
    private javax.swing.JTable tabla_entregada_1;
    // End of variables declaration//GEN-END:variables

   
}
