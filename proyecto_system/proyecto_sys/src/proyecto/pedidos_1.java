
package proyecto;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class pedidos_1 extends javax.swing.JFrame {
    private JComboBox<String> mesaComboBox;
    private HashMap<String, ArrayList<String[]>> pedidosPorMesa;
    private SimpleDateFormat dateFormat;
 
   

   
     public pedidos_1(HashMap<String, ArrayList<String[]>> pedidosPorMesa) {
        this.pedidosPorMesa = pedidosPorMesa;
        initComponents();
        this.dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
        mostrarPedidosEntregados();
        cargarMesasEnComboBox(); 
        //pedidosPorMesa = new HashMap<>();
       
        
    }
     

    private void mostrarPedidosEntregados() {
        ArrayList<String[]> pedidosEntregados = new ArrayList<>();

        for (ArrayList<String[]> listaPedidos : pedidosPorMesa.values()) {
            for (String[] pedido : listaPedidos) {
                if (pedido[4].equals("Entregado")) { // Suponiendo que el estado está en el índice 4
                    pedidosEntregados.add(pedido);
                }
            }
        }
        DefaultTableModel modelEntregado = (DefaultTableModel) Tabla_entregado.getModel();
        modelEntregado.setRowCount(0); // Limpiar la tabla antes de agregar datos
        for (String[] pedido : pedidosEntregados) {
            modelEntregado.addRow(pedido);
        }
        Tabla_entregado.setModel(modelEntregado);
 
    }

   
    public JPanel getPanelContent() {
       return (JPanel) getContentPane();
    }
   

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla_Alistando = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        Tabla_entregado = new javax.swing.JTable();
        boton_entregado = new javax.swing.JButton();
        boton_alistando = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        combo = new javax.swing.JComboBox<>();
        jScrollPane3 = new javax.swing.JScrollPane();
        tabla_a = new javax.swing.JTable();
        Baucher = new javax.swing.JButton();
        boton_eliminar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(900, 750));
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(null);
        jPanel1.add(jLabel3);
        jLabel3.setBounds(155, 230, 0, 0);

        tabla_Alistando.setBackground(new java.awt.Color(0, 255, 204));
        tabla_Alistando.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mesa", "Producto", "Cantidad", "Precio"
            }
        ));
        jScrollPane1.setViewportView(tabla_Alistando);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(20, 280, 850, 130);

        jLabel2.setFont(new java.awt.Font("Matura MT Script Capitals", 3, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 255));
        jLabel2.setText("Pedido Entregado:");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(20, 420, 240, 33);

        jLabel5.setBackground(new java.awt.Color(255, 0, 0));
        jLabel5.setFont(new java.awt.Font("Segoe UI", 3, 36)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 255));
        jLabel5.setText("Pedidos en General :");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(20, 10, 460, 48);

        jLabel7.setFont(new java.awt.Font("Matura MT Script Capitals", 3, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 0, 51));
        jLabel7.setText("Alistando:");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(30, 240, 240, 50);

        Tabla_entregado.setBackground(new java.awt.Color(0, 255, 204));
        Tabla_entregado.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mesa", "Producto", "Cantidad", "Precio", "Fecha-Hora"
            }
        ));
        jScrollPane4.setViewportView(Tabla_entregado);

        jPanel1.add(jScrollPane4);
        jScrollPane4.setBounds(190, 460, 680, 210);

        boton_entregado.setBackground(new java.awt.Color(255, 255, 51));
        boton_entregado.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        boton_entregado.setForeground(new java.awt.Color(51, 51, 255));
        boton_entregado.setText("Entregado");
        boton_entregado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_entregadoActionPerformed(evt);
            }
        });
        jPanel1.add(boton_entregado);
        boton_entregado.setBounds(730, 120, 117, 60);

        boton_alistando.setBackground(new java.awt.Color(255, 255, 102));
        boton_alistando.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        boton_alistando.setForeground(new java.awt.Color(51, 51, 255));
        boton_alistando.setText("Alistando");
        boton_alistando.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_alistandoActionPerformed(evt);
            }
        });
        jPanel1.add(boton_alistando);
        boton_alistando.setBounds(730, 50, 120, 60);

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyecto/103825100-comida-de-restaurante.jpg"))); // NOI18N
        jPanel1.add(jLabel8);
        jLabel8.setBounds(250, 240, 480, 480);

        combo.setBackground(new java.awt.Color(0, 255, 0));
        combo.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        combo.setForeground(new java.awt.Color(0, 0, 255));
        combo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mesa1" }));
        combo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboActionPerformed(evt);
            }
        });
        jPanel1.add(combo);
        combo.setBounds(380, 20, 110, 30);

        tabla_a.setBackground(new java.awt.Color(0, 255, 204));
        tabla_a.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mesa", "Producto", "Cantidad", "Precio", "Estado"
            }
        ));
        jScrollPane3.setViewportView(tabla_a);

        jPanel1.add(jScrollPane3);
        jScrollPane3.setBounds(20, 70, 680, 170);

        Baucher.setBackground(new java.awt.Color(153, 255, 153));
        Baucher.setText("Baucher");
        Baucher.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BaucherActionPerformed(evt);
            }
        });
        jPanel1.add(Baucher);
        Baucher.setBounds(30, 510, 150, 120);

        boton_eliminar.setBackground(new java.awt.Color(255, 255, 51));
        boton_eliminar.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        boton_eliminar.setForeground(new java.awt.Color(51, 51, 255));
        boton_eliminar.setText("Eliminar");
        boton_eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_eliminarActionPerformed(evt);
            }
        });
        jPanel1.add(boton_eliminar);
        boton_eliminar.setBounds(730, 190, 120, 60);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 920, 710);

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
       
         if (combo != null) {
            Object selectedItem = combo.getSelectedItem();
            if (selectedItem != null) {
                mostrarPedidosEnTabla((String) selectedItem);
            }
        }
       
    }//GEN-LAST:event_comboActionPerformed

    private void boton_alistandoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_alistandoActionPerformed
      cambiarEstadoPedido("Alistando");
    }//GEN-LAST:event_boton_alistandoActionPerformed

    private void boton_entregadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_entregadoActionPerformed
         cambiarEstadoPedido("Entregado");
         
    }//GEN-LAST:event_boton_entregadoActionPerformed

    private void BaucherActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BaucherActionPerformed
        generarComprobante();
    }//GEN-LAST:event_BaucherActionPerformed

    private void boton_eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_eliminarActionPerformed
        // Obtener la fila seleccionada
        int filaSeleccionada = tabla_a.getSelectedRow();

        if (filaSeleccionada != -1) {
            // Obtener el modelo de la tabla
            DefaultTableModel model = (DefaultTableModel) tabla_a.getModel();

            // Obtener el valor de la celda en la columna de la mesa
            String mesaSeleccionada = (String) model.getValueAt(filaSeleccionada, 0);

            // Obtener el valor de la celda en la columna de estado
            String estado = (String) model.getValueAt(filaSeleccionada, 4);

            // Verificar si el estado es "alistando" o "pendiente"
            if ("alistando".equalsIgnoreCase(estado) || "pendiente".equalsIgnoreCase(estado)) {
                // Obtener la lista de pedidos para la mesa seleccionada
                ArrayList<String[]> pedidos = pedidosPorMesa.get(mesaSeleccionada);
                if (pedidos != null) {
                    // Eliminar el pedido de la lista
                    pedidos.remove(filaSeleccionada);
                    // Actualizar la lista de pedidos en el HashMap
                    pedidosPorMesa.put(mesaSeleccionada, pedidos);

                    // Eliminar la fila de la tabla
                    model.removeRow(filaSeleccionada);

                    // Verificar si la lista de pedidos está vacía y eliminar la mesa del HashMap si es necesario
                    if (pedidos.isEmpty()) {
                        pedidosPorMesa.remove(mesaSeleccionada);
                        cargarMesasEnComboBox(); // Actualizar el JComboBox
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "No se encontraron pedidos para la mesa seleccionada.");
                }
            } else {
                JOptionPane.showMessageDialog(this, "No se puede eliminar el pedido ya que su estado es " + estado + ".");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Por favor, seleccione un producto para eliminar.");
        }
        
    }//GEN-LAST:event_boton_eliminarActionPerformed

    private void generarComprobante() {
        String mesaSeleccionada = (String) combo.getSelectedItem();
        if (mesaSeleccionada != null && pedidosPorMesa.containsKey(mesaSeleccionada)) {
            ArrayList<String[]> pedidos = pedidosPorMesa.get(mesaSeleccionada);
            StringBuilder comprobante = new StringBuilder();

            // Verificar si hay productos entregados
            boolean hayEntregados = false;
            double totalSinIGV = 0.0;

            // Define el rango de tiempo permitido (por ejemplo, entre las 08:00 y las 23:50)
            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
            String horaActualStr = sdf.format(new Date());
            String horaInicioStr = "00:00";
            String horaFinStr = "23:50";

            try {
                Date horaActual = sdf.parse(horaActualStr);
                Date horaInicio = sdf.parse(horaInicioStr);
                Date horaFin = sdf.parse(horaFinStr);

                if (horaActual.before(horaInicio) || horaActual.after(horaFin)) {
                    JOptionPane.showMessageDialog(this, "Los comprobantes solo pueden generarse entre las 08:00 y las 23:50.");
                    return;
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Error al verificar la hora: " + e.getMessage());
                return;
            }

            // Cabecera del comprobante
            comprobante.append("            ***********************\n");
            comprobante.append("                     Restobar           \n");
            comprobante.append("               Comprobante de Pedido   \n");
            comprobante.append("                     Mesa: ").append(mesaSeleccionada).append("\n");
            comprobante.append("            ***********************\n");
            comprobante.append("           \n");
            // Añadir la fecha y hora de generación del comprobante
            comprobante.append("Ruc: 10730425878           \n");
            comprobante.append("Dirección: Perulandia - referencia 2 cuadras\n");
            String fechaHoraActual = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new Date());
            comprobante.append("Fecha y Hora de generación: ").append(fechaHoraActual).append("\n");

            // Títulos de las columnas
            comprobante.append(String.format("%-25s %-10s %-10s\n", "Producto", "Cantidad", "Precio (S/)"));
            comprobante.append("------------------------------------------------------------\n");

            // Detalles de cada pedido
            boolean productosParaComprobante = false; // Indica si hay productos que añadir al comprobante

            for (String[] pedido : pedidos) {
                if (!pedido[4].isEmpty()) { // Solo agregar productos entregados
                    double precio = Double.parseDouble(pedido[3]);
                    int cantidad = Integer.parseInt(pedido[2]);
                    totalSinIGV += precio * cantidad;
                    comprobante.append(String.format("%-25s %-10d %-10s\n", pedido[1], cantidad, String.format("S/ %.2f", precio)));
                    productosParaComprobante = true; // Hay productos que se agregarán al comprobante
                }
            }

            if (productosParaComprobante) {
                double igv = totalSinIGV * 0.18;
                double totalConIGV = totalSinIGV + igv;
                comprobante.append("------------------------------------------------------------\n");
                comprobante.append("            \n");
                comprobante.append(String.format("%-35s %-10s\n", "Subtotal (S/):", String.format("S/ %.2f", totalSinIGV)));
                comprobante.append(String.format("%-35s %-10s\n", "IGV (18%) (S/):", String.format("S/ %.2f", igv)));
                comprobante.append(String.format("%-35s %-10s\n", "Total (S/):", String.format("S/ %.2f", totalConIGV)));

                // Mensaje de despedida
                comprobante.append("\n");
                comprobante.append("\n");
                comprobante.append("             ");
                comprobante.append("\n           Gracias por su preferencia!");
                comprobante.append("\n       Esperamos volver a atenderle pronto.");
                comprobante.append("    ");

                // Mostrar el comprobante en una ventana de texto
                mostrarComprobante(comprobante.toString());

                // Guardar el comprobante en un archivo
                try {
                    String folderPath = "F:\\proyecto_modificado_chung\\proyecto_system\\proyecto_sys\\comprobante\\"; // Asegúrate de que esta ruta termina con "\"
                    String fileName = "Comprobante_Mesa_" + mesaSeleccionada + ".txt";
                    FileWriter fileWriter = new FileWriter(folderPath + fileName);
                    fileWriter.write(comprobante.toString());
                    fileWriter.close();
                    //JOptionPane.showMessageDialog(this, "Comprobante generado y guardado en archivo de texto.");

                    // Imprimir la ruta completa del archivo
                    System.out.println("Comprobante guardado en: " + new File(folderPath + fileName).getAbsolutePath());
                } catch (IOException e) {
                    JOptionPane.showMessageDialog(this, "Error al guardar el comprobante: " + e.getMessage());
                }
            } else {
                JOptionPane.showMessageDialog(this, "No hay productos entregados para la mesa seleccionada.");
            }
        } else {
            JOptionPane.showMessageDialog(this, "No hay pedidos para la mesa seleccionada.");
        }
        
    }
    private void mostrarComprobante(String comprobanteTexto) {
         JOptionPane.showMessageDialog(null, "Generando comprobante, por favor espere...", "Generando Comprobante", JOptionPane.INFORMATION_MESSAGE);
        // Crear un temporizador para esperar 3 segundos antes de mostrar el comprobante
        Timer timer = new Timer(3000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame("Comprobante de Pedido");

                JTextArea textArea = new JTextArea(comprobanteTexto);
                textArea.setEditable(false);
                textArea.setFont(new Font("Monospaced", Font.BOLD, 12)); // Fuente en negrita
                textArea.setWrapStyleWord(true);
                textArea.setLineWrap(true);
                textArea.setBackground(Color.WHITE); // Fondo blanco
                textArea.setText(comprobanteTexto);

                JScrollPane scrollPane = new JScrollPane(textArea);
                frame.add(scrollPane);

                // Establecer tamaño fijo del JFrame
                int frameWidth = 370;
                int frameHeight = 600;

                // Ajustar el tamaño del frame
                frame.setSize(frameWidth, frameHeight);

                // Centrar la ventana en la pantalla
                Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
                int x = (screenSize.width - frameWidth) / 2;
                int y = (screenSize.height - frameHeight) / 2;
                frame.setLocation(x, y);

                frame.setVisible(true);
            }
        });

        timer.setRepeats(false); // El temporizador solo se ejecuta una vez
        timer.start(); // Inicia el temporizador

       
    }
    private void cargarMesasEnComboBox() {
        combo.removeAllItems(); // Clear existing items
        for (String mesa : pedidosPorMesa.keySet()) {
            combo.addItem(mesa);
        }
        if (combo.getItemCount() > 0) {
            combo.setSelectedIndex(0);
            mostrarPedidosEnTabla((String) combo.getSelectedItem());
        }

    }
    private void cambiarEstadoPedido(String estado) {
        String mesaSeleccionada = (String) combo.getSelectedItem();
        if (mesaSeleccionada != null && pedidosPorMesa.containsKey(mesaSeleccionada)) {
            int filaSeleccionada = tabla_a.getSelectedRow();

            if (filaSeleccionada != -1) {
                DefaultTableModel model = (DefaultTableModel) tabla_a.getModel();
                ArrayList<String[]> pedidos = pedidosPorMesa.get(mesaSeleccionada);
                String[] pedido = pedidos.get(filaSeleccionada);

                // Verificar el estado actual del pedido
                String estadoActual = pedido[4];
                String fechaHoraActual = dateFormat.format(new Date());

                if (estadoActual.equals("Entregado") || (estadoActual != null && estadoActual.compareTo(fechaHoraActual) <= 0)) {
                    JOptionPane.showMessageDialog(null, "El producto ya ha sido entregado.");
                    return;
                }

                if (estado.equals("Alistando") && estadoActual.equals("Alistando")) {
                    JOptionPane.showMessageDialog(null, "El producto ya está en proceso de alistamiento.");
                    return;
                }

                // Actualizar el estado del pedido
                pedido[4] = estado;

                // Actualizar el estado del pedido en el HashMap
                pedidosPorMesa.put(mesaSeleccionada, pedidos);

                // Actualizar la vista de pedidos para la mesa seleccionada
                mostrarPedidosEnTabla(mesaSeleccionada);

                // Eliminar el pedido de la tabla general
                model.removeRow(filaSeleccionada);

                // Agregar el pedido a la tabla correspondiente
                switch (estado) {
                    case "Alistando":
                        agregarAPedidoAlistando(pedido);
                        break;
                    case "Entregado":
                        pedido[4] = fechaHoraActual; // Añadir la fecha y hora para "Entregado"
                        agregarAPedidoNoAtendido(pedido);
                        break;
                }
            } else {
                JOptionPane.showMessageDialog(null, "Selecciona un producto para cambiar su estado.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "No hay pedidos para la mesa seleccionada.");
        }
         
    }

    private void mostrarPedidosEnTabla(String mesa) {
        ArrayList<String[]> pedidos = pedidosPorMesa.get(mesa);
        DefaultTableModel model = new DefaultTableModel(new String[]{"Mesa", "Producto", "Cantidad", "Precio", "Estado"}, 0);
        if (pedidos != null) {
            for (String[] pedido : pedidos) {
                model.addRow(pedido);
            }
        }
        tabla_a.setModel(model);
        
    }

    private void agregarAPedidoAlistando(String[] pedido) {
        DefaultTableModel modelAlistando = (DefaultTableModel) tabla_Alistando.getModel();
        modelAlistando.addRow(pedido);
        tabla_Alistando.setModel(modelAlistando);
        
    }
    private void agregarAPedidoNoAtendido(String[] pedido) {
        /*DefaultTableModel model = (DefaultTableModel) Tabla_entregado.getModel();
        model.addRow(pedido);*/
         DefaultTableModel modelEntregado = (DefaultTableModel) Tabla_entregado.getModel();
        modelEntregado.addRow(pedido);
        Tabla_entregado.setModel(modelEntregado);
    }
    /*------------------------------------------------------*/

    public static void main(String[] args) {
        // Ejemplo de pedidos para una mesa
        HashMap<String, ArrayList<String[]>> pedidosPorMesa = new HashMap<>();

        ArrayList<String[]> pedidosMesa1 = new ArrayList<>();
        

        pedidosPorMesa.put("Mesa1", pedidosMesa1);

        java.awt.EventQueue.invokeLater(() -> {
            new pedidos_1(pedidosPorMesa).setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Baucher;
    private javax.swing.JTable Tabla_entregado;
    private javax.swing.JButton boton_alistando;
    private javax.swing.JButton boton_eliminar;
    private javax.swing.JButton boton_entregado;
    private javax.swing.JComboBox<String> combo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable tabla_Alistando;
    private javax.swing.JTable tabla_a;
    // End of variables declaration//GEN-END:variables

}
