
package proyecto;



import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.BorderFactory;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumnModel;
public class inventario extends javax.swing.JFrame {
    private static final String URL = "jdbc:oracle:thin:@localhost:1521:XE";
    private static final String USER = "C##Jefferson";
    private static final String PASSWORD = "Jefferson";

   
    public inventario() {
        initComponents();
        TableColumnModel columnModel = tabla_inventario.getColumnModel();
        if (columnModel.getColumnCount() > 0) {
            columnModel.getColumn(0).setMinWidth(40);
            columnModel.getColumn(0).setMaxWidth(50);
            columnModel.getColumn(2).setMinWidth(50);
            columnModel.getColumn(2).setMaxWidth(60);
            columnModel.getColumn(3).setMinWidth(50);
            columnModel.getColumn(3).setMaxWidth(60);
        }
         cargarDatos();
     
    }
    private void cargarDatos() {
        DefaultTableModel modelo = (DefaultTableModel) tabla_inventario.getModel();
        modelo.setRowCount(0);

        String query = "SELECT p.Producto_ID, p.PRODUCTO_NOM,  p.PRECIO, i.STOCK_DISPONIBLE \n" +
                        "FROM INV_NOFIJO i JOIN PRODUCTOS p \n" +
                        "ON i.PRODUCTO_ID = p.PRODUCTO_ID;";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD); PreparedStatement stmt = conn.prepareStatement(query); ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Object[] fila = new Object[4];
                fila[0] = rs.getInt("PRODUCTO_ID");
                fila[1] = rs.getString("PRODUCTO_NOM");
                fila[2] = rs.getInt("Stock Disponible"); // Cambiado a "Stock Disponible"
                fila[3] = rs.getDouble("Precio"); // Cambiado a "Precio"
                modelo.addRow(fila);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
  

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla_inventario = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyecto/103825100-comida-de-restaurante.jpg"))); // NOI18N

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(920, 750));
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setMinimumSize(new java.awt.Dimension(920, 710));
        jPanel1.setPreferredSize(new java.awt.Dimension(920, 710));
        jPanel1.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 3, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 255));
        jLabel1.setText("Inventario:");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(40, 0, 510, 80);

        tabla_inventario.setBackground(new java.awt.Color(204, 204, 255));
        tabla_inventario.setFont(new java.awt.Font("Cascadia Mono", 0, 18)); // NOI18N
        tabla_inventario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Producto", "Cantidad", "Precio"
            }
        ));
        jScrollPane1.setViewportView(tabla_inventario);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(40, 80, 700, 600);

        jButton1.setBackground(new java.awt.Color(153, 153, 255));
        jButton1.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jButton1.setText("Agregar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(770, 410, 120, 100);

        jButton4.setBackground(new java.awt.Color(153, 153, 255));
        jButton4.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jButton4.setText("Eliminar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4);
        jButton4.setBounds(770, 280, 120, 100);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 1040, 710);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
       
    }//GEN-LAST:event_jButton4ActionPerformed
     
    
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new inventario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabla_inventario;
    // End of variables declaration//GEN-END:variables
}
