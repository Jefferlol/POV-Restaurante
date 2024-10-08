
package proyecto;

import java.sql.Connection; // Importa la clase Connection correcta
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;


public class clientes_atendidos extends javax.swing.JFrame {
   
    private static final String URL = "jdbc:oracle:thin:@localhost:1521:XE";
    private static final String USER = "C##Jefferson";
    private static final String PASSWORD = "Jefferson";
    
   

    public clientes_atendidos() {
       
        initComponents();
       
    }
    /*private void cargarDatos_inv_nofijo() {
        DefaultTableModel modelo = (DefaultTableModel) inv_no_fijo.getModel();
        modelo.setRowCount(0);

        // Consulta SQL con JOIN para obtener detalles del producto junto con el inventario no fijo
        String query = "SELECT inv.INV_NOFIJO_ID, prod.PRODUCTO_NOM, inv.STOCK_DISPONIBLE "
                + "FROM INV_NOFIJO inv "
                + "JOIN PRODUCTOS prod ON inv.PRODUCTO_ID = prod.PRODUCTO_ID";

        while (rs.next()) {
            Object[] fila = new Object[3];
            fila[0] = rs.getInt("INV_NOFIJO_ID");
            fila[1] = rs.getString("PRODUCTO_NOM");
            String stockDisponibleStr = rs.getString("STOCK_DISPONIBLE");
            try {
                fila[2] = Integer.parseInt(stockDisponibleStr); // Intenta convertir el valor a int
            } catch (NumberFormatException e) {
                e.printStackTrace(); // Maneja la excepción si la conversión falla
                fila[2] = null; // O asigna un valor predeterminado si es necesario
            }
            modelo.addRow(fila);
        }
    }*/
    private void cargarDatosInvFijo() {
        DefaultTableModel modelo = (DefaultTableModel) inv_no_fijo.getModel();
        modelo.setRowCount(0);

        String query = "SELECT i.INV_NOFIJO_ID, p.PRODUCTO_NOM,  p.PRECIO, i.STOCK_DISPONIBLE \n" +
                        "FROM INV_NOFIJO i JOIN PRODUCTOS p \n" +
                        "ON i.PRODUCTO_ID = p.PRODUCTO_ID";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD); PreparedStatement stmt = conn.prepareStatement(query); ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Object[] fila = new Object[4];
                fila[0] = rs.getString("INV_NOFIJO_ID"); // Usando nombre de columna
                fila[1] = rs.getString("PRODUCTO_NOM");
                fila[2] = rs.getString("PRECIO");
                fila[3] = rs.getString("STOCK_DISPONIBLE");
                modelo.addRow(fila);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    

   
   

    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jDialog1 = new javax.swing.JDialog();
        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        boton_Cargar_bd = new javax.swing.JButton();
        boton_agotado = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        inv_no_fijo = new javax.swing.JTable();
        rdb_disponible = new javax.swing.JRadioButton();
        rdb_agotado = new javax.swing.JRadioButton();

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
        jPanel1.setMinimumSize(new java.awt.Dimension(900, 620));
        jPanel1.setLayout(null);

        boton_Cargar_bd.setBackground(new java.awt.Color(51, 255, 51));
        boton_Cargar_bd.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        boton_Cargar_bd.setForeground(new java.awt.Color(51, 0, 255));
        boton_Cargar_bd.setText("Cargar la Bd");
        boton_Cargar_bd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_Cargar_bdActionPerformed(evt);
            }
        });
        jPanel1.add(boton_Cargar_bd);
        boton_Cargar_bd.setBounds(20, 10, 140, 90);

        boton_agotado.setBackground(new java.awt.Color(255, 255, 0));
        boton_agotado.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        boton_agotado.setForeground(new java.awt.Color(0, 0, 255));
        boton_agotado.setText("Trasnsferir productos agotados");
        boton_agotado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_agotadoActionPerformed(evt);
            }
        });
        jPanel1.add(boton_agotado);
        boton_agotado.setBounds(120, 620, 680, 50);

        jLabel4.setBackground(new java.awt.Color(51, 51, 255));
        jLabel4.setFont(new java.awt.Font("Segoe UI", 3, 36)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 255));
        jLabel4.setText("Inventario no fijo:");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(300, 10, 320, 50);

        inv_no_fijo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Producto", "Precio", "Estado"
            }
        ));
        inv_no_fijo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                inv_no_fijoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(inv_no_fijo);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(20, 110, 840, 490);

        rdb_disponible.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        rdb_disponible.setText("DISPONIBLE");
        rdb_disponible.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdb_disponibleActionPerformed(evt);
            }
        });
        jPanel1.add(rdb_disponible);
        rdb_disponible.setBounds(310, 60, 140, 40);

        rdb_agotado.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        rdb_agotado.setText("AGOTADO");
        rdb_agotado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdb_agotadoActionPerformed(evt);
            }
        });
        jPanel1.add(rdb_agotado);
        rdb_agotado.setBounds(450, 60, 160, 40);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 1040, 710);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void boton_agotadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_agotadoActionPerformed
        

    }//GEN-LAST:event_boton_agotadoActionPerformed

    private void boton_Cargar_bdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_Cargar_bdActionPerformed
       cargarDatosInvFijo();

    }//GEN-LAST:event_boton_Cargar_bdActionPerformed

    private void rdb_agotadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdb_agotadoActionPerformed
        this.rdb_disponible.setSelected(false);
        int filaSeleccionada = inv_no_fijo.getSelectedRow();
        if (filaSeleccionada != -1) {
            inv_no_fijo.setValueAt("N",filaSeleccionada, 3);
            Object valorColumna1 = inv_no_fijo.getValueAt(filaSeleccionada, 0);
            String valor = valorColumna1.toString();
            System.out.println(valor);
            
            String sql = "UPDATE Inv_NoFijo SET Stock_Disponible = 'N' WHERE inv_nofijo_id = "+valor+" AND Stock_Disponible = 'S'";
            try { CreateBD(sql);} 
            catch (SQLException e) {
                e.printStackTrace();
                }
        }
    }//GEN-LAST:event_rdb_agotadoActionPerformed

    private void inv_no_fijoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_inv_no_fijoMouseClicked
        int filaSeleccionada = inv_no_fijo.getSelectedRow();

    // Verificar que se haya seleccionado una fila
        if (filaSeleccionada != -1) {
            // Obtener el valor de la columna 4 (índice 3, ya que las columnas son 0-based)
            Object valorColumna4 = inv_no_fijo.getValueAt(filaSeleccionada, 3);
            String valor = valorColumna4.toString();
            if (valor.equals("S")){
                this.rdb_agotado.setSelected(false);
                this.rdb_disponible.setSelected(true);
            }
            else {this.rdb_agotado.setSelected(true);
                this.rdb_disponible.setSelected(false);}
        }
    }//GEN-LAST:event_inv_no_fijoMouseClicked

    private void rdb_disponibleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdb_disponibleActionPerformed
        this.rdb_agotado.setSelected(false);
        int filaSeleccionada = inv_no_fijo.getSelectedRow();
        if (filaSeleccionada != -1 ) {
            inv_no_fijo.setValueAt("S",filaSeleccionada, 3);
            
            Object valorColumna1 = inv_no_fijo.getValueAt(filaSeleccionada, 0);
            String valor = valorColumna1.toString();
            System.out.println(valor);
            
            String sql = "UPDATE Inv_NoFijo SET Stock_Disponible = 'S' WHERE inv_nofijo_id = "+valor+" AND Stock_Disponible = 'N'";
            try { CreateBD(sql);} 
            catch (SQLException e) {
                e.printStackTrace();
                }
        }
    }//GEN-LAST:event_rdb_disponibleActionPerformed


    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
              
                // Si `pedidos_1` requiere datos para funcionar, asegúrate de agregar esos datos aquí

                // Mostrar la ventana `clientes_atendidos`
                new clientes_atendidos().setVisible(true);
            }
        });
    }
    public void CreateBD(String sql) throws SQLException {
                Connection conexion = null;
                Statement statement = null;
                try {
                    conexion = DriverManager.getConnection(URL, USER, PASSWORD);
                    statement = conexion.createStatement();
                    int filasAfectadas = statement.executeUpdate(sql);
                    System.out.println("Filas afectadas: " + filasAfectadas);
                } catch (SQLException e) {
                    e.printStackTrace();
                    throw e;
                } finally {
                    if (statement != null) {
                        try {
                            statement.close();
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                    }
                    if (conexion != null) {
                        try {
                            conexion.close();
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
 

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton boton_Cargar_bd;
    private javax.swing.JButton boton_agotado;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JTable inv_no_fijo;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton rdb_agotado;
    private javax.swing.JRadioButton rdb_disponible;
    // End of variables declaration//GEN-END:variables

   
}
