
package proyecto;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
public class inventario extends javax.swing.JFrame {

   
    public inventario() {
        initComponents();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyecto/103825100-comida-de-restaurante.jpg"))); // NOI18N

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(900, 750));
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));
        jPanel1.setMinimumSize(new java.awt.Dimension(920, 710));
        jPanel1.setPreferredSize(new java.awt.Dimension(920, 710));
        jPanel1.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 3, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 255));
        jLabel1.setText("Inventario:");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(350, 80, 200, 40);

        jTable1.setBackground(new java.awt.Color(204, 204, 255));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Producto", "Cantidad", "Precio"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(130, 140, 620, 380);

        jButton1.setBackground(new java.awt.Color(153, 153, 255));
        jButton1.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jButton1.setText("Agregar");
        jPanel1.add(jButton1);
        jButton1.setBounds(180, 540, 130, 40);

        jButton2.setBackground(new java.awt.Color(153, 153, 255));
        jButton2.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jButton2.setText("Buscar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2);
        jButton2.setBounds(520, 540, 130, 40);

        jButton4.setBackground(new java.awt.Color(153, 153, 255));
        jButton4.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jButton4.setText("Eliminar");
        jPanel1.add(jButton4);
        jButton4.setBounds(350, 540, 130, 40);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 920, 710);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        
    }//GEN-LAST:event_jButton2ActionPerformed

    
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new inventario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
