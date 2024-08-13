
package proyecto;
import java.text.SimpleDateFormat;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class pedidos_1 extends javax.swing.JFrame {

    private JComboBox<String> mesaComboBox;
    private HashMap<String, ArrayList<String[]>> pedidosPorMesa;
    private SimpleDateFormat dateFormat;

    public pedidos_1(HashMap<String, ArrayList<String[]>> pedidosPorMesa) {
        this.pedidosPorMesa = pedidosPorMesa;
        initComponents();
        this.dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
        // Asegúrate de inicializar y configurar el JComboBox aquí
        cargarMesasEnComboBox(); // Llama a este método para cargar las mesas
    }
    public JPanel getPanelContent() {
       return (JPanel) getContentPane();
    }
   
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane3 = new javax.swing.JScrollPane();
        tabla_a = new javax.swing.JTable();
        combo = new javax.swing.JComboBox<>();
        boton_atendido2 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla_Alistando = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabla_Atendido = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        Tabla_entregado = new javax.swing.JTable();
        boton_entregado = new javax.swing.JButton();
        boton_atendido1 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(800, 750));
        getContentPane().setLayout(null);

        tabla_a.setBackground(new java.awt.Color(204, 204, 255));
        tabla_a.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mesa", "Producto", "Cantidad", "Precio", "Estado"
            }
        ));
        jScrollPane3.setViewportView(tabla_a);

        getContentPane().add(jScrollPane3);
        jScrollPane3.setBounds(10, 70, 530, 120);

        combo.setBackground(new java.awt.Color(0, 255, 0));
        combo.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        combo.setForeground(new java.awt.Color(0, 0, 255));
        combo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mesa1" }));
        combo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboActionPerformed(evt);
            }
        });
        getContentPane().add(combo);
        combo.setBounds(270, 20, 110, 30);

        boton_atendido2.setBackground(new java.awt.Color(0, 0, 0));
        boton_atendido2.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        boton_atendido2.setForeground(new java.awt.Color(255, 255, 255));
        boton_atendido2.setText("Atendido");
        boton_atendido2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_atendido2ActionPerformed(evt);
            }
        });
        getContentPane().add(boton_atendido2);
        boton_atendido2.setBounds(550, 80, 140, 30);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(null);
        jPanel1.add(jLabel3);
        jLabel3.setBounds(155, 230, 0, 0);

        tabla_Alistando.setBackground(new java.awt.Color(204, 204, 255));
        tabla_Alistando.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mesa", "Producto", "Cantidad", "Precio"
            }
        ));
        jScrollPane1.setViewportView(tabla_Alistando);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(20, 390, 670, 110);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 255));
        jLabel2.setText("Pedido Entregado");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(30, 510, 240, 32);

        jLabel5.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        jLabel5.setText("Pedidos en General");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(20, 20, 240, 32);

        jLabel6.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 255));
        jLabel6.setText("Atendido");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(30, 200, 210, 32);

        tabla_Atendido.setBackground(new java.awt.Color(204, 204, 255));
        tabla_Atendido.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mesa", "Producto", "Cantidad", "Precio"
            }
        ));
        jScrollPane2.setViewportView(tabla_Atendido);

        jPanel1.add(jScrollPane2);
        jScrollPane2.setBounds(20, 240, 670, 110);

        jLabel7.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 255));
        jLabel7.setText("Alistando");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(30, 350, 240, 32);

        Tabla_entregado.setBackground(new java.awt.Color(204, 204, 255));
        Tabla_entregado.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mesa", "Producto", "Cantidad", "Precio", "Fecha-Hora"
            }
        ));
        jScrollPane4.setViewportView(Tabla_entregado);

        jPanel1.add(jScrollPane4);
        jScrollPane4.setBounds(20, 550, 670, 110);

        boton_entregado.setBackground(new java.awt.Color(0, 0, 0));
        boton_entregado.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        boton_entregado.setForeground(new java.awt.Color(255, 255, 255));
        boton_entregado.setText("Entregado");
        boton_entregado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_entregadoActionPerformed(evt);
            }
        });
        jPanel1.add(boton_entregado);
        boton_entregado.setBounds(550, 140, 140, 30);

        boton_atendido1.setBackground(new java.awt.Color(0, 0, 0));
        boton_atendido1.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        boton_atendido1.setForeground(new java.awt.Color(255, 255, 255));
        boton_atendido1.setText("Alistando");
        boton_atendido1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_atendido1ActionPerformed(evt);
            }
        });
        jPanel1.add(boton_atendido1);
        boton_atendido1.setBounds(550, 110, 140, 30);

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyecto/103825100-comida-de-restaurante.jpg"))); // NOI18N
        jPanel1.add(jLabel8);
        jLabel8.setBounds(240, 110, 480, 480);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 900, 710);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyecto/103825100-comida-de-restaurante.jpg"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(230, 10, 450, 450);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        jLabel4.setText("Pedidos en General");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(20, 20, 240, 32);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void comboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboActionPerformed
        /*if (mesaComboBox != null) {
            Object selectedItem = mesaComboBox.getSelectedItem();
            // Manejar el item seleccionado
            if (selectedItem != null) {
                mostrarPedidosEnTabla((String) selectedItem);
            }
        } else {
            System.out.println("mesaComboBox es null.");
        }*/
        /* if (combo != null) {
            Object selectedItem = combo.getSelectedItem();
            // Manejar el item seleccionado
            if (selectedItem != null) {
                mostrarPedidosEnTabla((String) selectedItem);
            }
        } else {
            System.out.println("combo es null.");
        }*/
        if (combo != null) {
            Object selectedItem = combo.getSelectedItem();
            if (selectedItem != null) {
                mostrarPedidosEnTabla((String) selectedItem);
            }
        }
    }//GEN-LAST:event_comboActionPerformed

    private void boton_atendido1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_atendido1ActionPerformed
         cambiarEstadoPedido("Alistando");
    }//GEN-LAST:event_boton_atendido1ActionPerformed

    private void boton_atendido2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_atendido2ActionPerformed
       cambiarEstadoPedido("Atendido");
    }//GEN-LAST:event_boton_atendido2ActionPerformed

    private void boton_entregadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_entregadoActionPerformed
          cambiarEstadoPedido("Entregado");
    }//GEN-LAST:event_boton_entregadoActionPerformed
    private void cargarMesasEnComboBox() {
         combo.removeAllItems();
        for (String mesa : pedidosPorMesa.keySet()) {
            combo.addItem(mesa);
        }
        if (combo.getItemCount() > 0) {
            combo.setSelectedIndex(0);
            mostrarPedidosEnTabla((String) combo.getSelectedItem());
        }
    }
    
    private void cambiarEstadoPedido(String estado) {
       
        /*String mesaSeleccionada = (String) combo.getSelectedItem();
        if (mesaSeleccionada != null && pedidosPorMesa.containsKey(mesaSeleccionada)) {
            // Obtener la fila seleccionada
            int filaSeleccionada = tabla_a.getSelectedRow();

            if (filaSeleccionada != -1) { // Verificar si hay una fila seleccionada
                // Obtener el modelo de la tabla
                DefaultTableModel model = (DefaultTableModel) tabla_a.getModel();

                // Actualizar el estado del producto en la fila seleccionada
                model.setValueAt(estado, filaSeleccionada, 4); // La columna 4 es "Estado"

                // Actualizar el estado en los datos almacenados
                ArrayList<String[]> pedidos = pedidosPorMesa.get(mesaSeleccionada);
                String[] pedido = pedidos.get(filaSeleccionada);
                pedido[4] = estado; // Cambia el estado en el array del pedido

                // Refrescar la tabla con los nuevos datos
                tabla_a.setModel(model);
            } else {
                // Mostrar un mensaje si no hay ninguna fila seleccionada
                JOptionPane.showMessageDialog(null, "Selecciona un producto para cambiar su estado.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "No hay pedidos para la mesa seleccionada.");
        }-----------------
        String mesaSeleccionada = (String) combo.getSelectedItem();
        if (mesaSeleccionada != null && pedidosPorMesa.containsKey(mesaSeleccionada)) {
            int filaSeleccionada = tabla_a.getSelectedRow();

            if (filaSeleccionada != -1) {
                // Obtener el modelo de la tabla general
                DefaultTableModel model = (DefaultTableModel) tabla_a.getModel();

                // Obtener el pedido y actualizar su estado
                ArrayList<String[]> pedidos = pedidosPorMesa.get(mesaSeleccionada);
                String[] pedido = pedidos.get(filaSeleccionada);
                pedido[4] = estado; // Cambiar el estado en el array del pedido

                // Eliminar el pedido de la tabla general
                model.removeRow(filaSeleccionada);

                // Actualizar la tabla general
                tabla_a.setModel(model);

                // Mover el pedido a la tabla correspondiente
                switch (estado) {
                    case "Alistando":
                        agregarAPedidoAlistando(pedido);
                        break;
                    case "Atendido":
                        agregarAPedidoAtendido(pedido);
                        break;
                    case "Entregado":
                        agregarAPedidoNoAtendido(pedido);
                        break;
                }
            } else {
                JOptionPane.showMessageDialog(null, "Selecciona un producto para cambiar su estado.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "No hay pedidos para la mesa seleccionada.");
        }*/
         String mesaSeleccionada = (String) combo.getSelectedItem();
        if (mesaSeleccionada != null && pedidosPorMesa.containsKey(mesaSeleccionada)) {
            int filaSeleccionada = tabla_a.getSelectedRow();
            if (filaSeleccionada != -1) {
                DefaultTableModel model = (DefaultTableModel) tabla_a.getModel();
                ArrayList<String[]> pedidos = pedidosPorMesa.get(mesaSeleccionada);
                String[] pedido = pedidos.get(filaSeleccionada);
                pedido[4] = estado;

                model.removeRow(filaSeleccionada);

                switch (estado) {
                    case "Alistando":
                        agregarAPedidoAlistando(pedido);
                        break;
                    case "Atendido":
                        agregarAPedidoAtendido(pedido);
                        break;
                    case "Entregado":
                        pedido[4] = dateFormat.format(new Date());
                        agregarAPedidoNoAtendido(pedido);
                        break;
                }

                pedidos.remove(filaSeleccionada);
                if (pedidos.isEmpty()) {
                    pedidosPorMesa.remove(mesaSeleccionada);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Selecciona un producto para cambiar su estado.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "No hay pedidos para la mesa seleccionada.");
        }
    }
   

    private void agregarAPedidoAlistando(String[] pedido) {
         DefaultTableModel model = (DefaultTableModel) tabla_Alistando.getModel();
        model.addRow(pedido);
    }

    private void agregarAPedidoAtendido(String[] pedido) {
        DefaultTableModel model = (DefaultTableModel) tabla_Atendido.getModel();
        model.addRow(pedido);
    }
  

    private void agregarAPedidoNoAtendido(String[] pedido) {
        /*DefaultTableModel model = (DefaultTableModel) Tabla_entregado.getModel();
        model.addRow(pedido);*/
        DefaultTableModel model = (DefaultTableModel) Tabla_entregado.getModel();
        String[] filaConFechaHora = new String[]{pedido[0], pedido[1], pedido[2], pedido[3], pedido[4]};
        model.addRow(filaConFechaHora);
    }
     private void mostrarPedidosEnTabla(String mesa) {
        /*ArrayList<String[]> pedidos = pedidosPorMesa.get(mesa);
        DefaultTableModel model = new DefaultTableModel(new String[]{"Mesa", "Producto", "Cantidad", "Precio", "Estado"}, 0);
        if (pedidos != null) {
            for (String[] pedido : pedidos) {
                model.addRow(pedido);
            }
        }
        tabla_a.setModel(model);*/
         ArrayList<String[]> pedidos = pedidosPorMesa.get(mesa);
         DefaultTableModel model = (DefaultTableModel) tabla_a.getModel();
         model.setRowCount(0); // Limpiar tabla antes de agregar datos

         if (pedidos != null) {
             for (String[] pedido : pedidos) {
                 model.addRow(pedido);
             }
         }
    }
     
    public static void main(String[] args) {
        HashMap<String, ArrayList<String[]>> pedidosPorMesa = new HashMap<>();
        ArrayList<String[]> pedidosMesa1 = new ArrayList<>();
        pedidosMesa1.add(new String[]{"Mesa1", "Hamburguesa", "2", "20.00", "Alistando"});
        pedidosMesa1.add(new String[]{"Mesa1", "Papas Fritas", "1", "5.00", "Alistando"});
        pedidosPorMesa.put("Mesa1", pedidosMesa1);

        java.awt.EventQueue.invokeLater(() -> {
            new pedidos_1(pedidosPorMesa).setVisible(true);
        });
    }
    
    /*public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            HashMap<String, ArrayList<String[]>> testMap = new HashMap<>();
            ArrayList<String[]> listaPedidos = new ArrayList<>();
            listaPedidos.add(new String[]{"Mesa1", "Producto1", "1", "10", "No atendido"});
            listaPedidos.add(new String[]{"Mesa1", "Producto2", "2", "20", "No atendido"});
            testMap.put("Mesa1", listaPedidos);
            new pedidos_1(testMap).setVisible(true);
        });
    }*/
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Tabla_entregado;
    private javax.swing.JButton boton_atendido1;
    private javax.swing.JButton boton_atendido2;
    private javax.swing.JButton boton_entregado;
    private javax.swing.JComboBox<String> combo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable tabla_Alistando;
    private javax.swing.JTable tabla_Atendido;
    private javax.swing.JTable tabla_a;
    // End of variables declaration//GEN-END:variables
}

