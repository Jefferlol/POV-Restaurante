package proyecto;

//Base de datos

import java.awt.BorderLayout;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;


import javax.swing.table.TableColumnModel;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.border.AbstractBorder;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.DefaultListModel;

import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;


public class menu_opciones extends javax.swing.JFrame {
    
    //Base de datos
    private static final String URL = "jdbc:oracle:thin:@localhost:1521:XE";
    private static final String USER = "C##WILIAM";
    private static final String PASSWORD = "system";
    //private HashMap<String, List<String>> pedidosPorMesa = new HashMap<>();
    private HashMap<String, ArrayList<String[]>> pedidosPorMesa;

    DefaultListModel<String> productListModel = new DefaultListModel<>();
    JList<String> productList = new JList<>(productListModel);
    private List<String> productosGuardados = new ArrayList<>();
    private DefaultTableModel model;
    private JComboBox<String> mesaComboBox;
    private JComboBox<String> comboMesas;
    private int mesaCounter=0;
    private JFrame frame;
     private JFrame parentFrame;
  
    Color buttonColor = new Color(236, 240, 241);
     private JComboBox<String> comboBoxMesas;
 
    private final Border border = new LineBorder(java.awt.Color.BLACK, 1);

    public menu_opciones() {
        initComponents();

        Lista_Productos.setBorder(border);

        pedidosPorMesa = new HashMap<>();
        mesaComboBox = new JComboBox<>();
        actualizarComboBoxMesas();

        TableColumnModel columnModel = tabla_pedidos.getColumnModel();
        if (columnModel.getColumnCount() > 0) {
            columnModel.getColumn(0).setMinWidth(20);
            columnModel.getColumn(0).setMaxWidth(30);
            columnModel.getColumn(2).setMinWidth(50);
            columnModel.getColumn(2).setMaxWidth(60);
        }
        DefaultListModel<String> modelo = new DefaultListModel<>();
        this.Lista_Productos.setModel(modelo);

        // Agregar ListSelectionListener
        Lista_Productos.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    String selectedProduct = Lista_Productos.getSelectedValue();
                    if (selectedProduct != null) {
                        agregarProductoATabla(selectedProduct);
                        // Desplazar el JList para mostrar el elemento seleccionado
                        int index = Lista_Productos.getSelectedIndex();
                        if (index >= 0) {
                            Lista_Productos.ensureIndexIsVisible(index);
                        }
                    }
                }
            }
        });
       
    }
    private void ajustarColumnasTablaPedidos() {
        TableColumnModel columnModel = tabla_pedidos.getColumnModel();

        for (int column = 0; column < columnModel.getColumnCount(); column++) {
            TableColumn tableColumn = columnModel.getColumn(column);
            int maxWidth = tableColumn.getMaxWidth(); // Obtiene el ancho máximo de la columna

            // Inicializa el ancho preferido de la columna
            int preferredWidth = tableColumn.getMinWidth();

            for (int row = 0; row < tabla_pedidos.getRowCount(); row++) {
                TableCellRenderer cellRenderer = tabla_pedidos.getCellRenderer(row, column);
                Component comp = tabla_pedidos.prepareRenderer(cellRenderer, row, column);

                // Obtiene el ancho preferido del componente
                int cellWidth = comp.getPreferredSize().width;

                // Actualiza el ancho preferido si es mayor que el actual
                preferredWidth = Math.max(preferredWidth, cellWidth);
            }

            // Asegura que el ancho preferido no supere el ancho máximo
            preferredWidth = Math.min(preferredWidth, maxWidth);

            // Establece el ancho preferido de la columna
            tableColumn.setPreferredWidth(preferredWidth);
        }
    }
    private void mostrarVentanaSeleccionMesa() {
        JFrame ventanaMesa = new JFrame("Seleccionar Mesa");
        ventanaMesa.setSize(350, 200); // Aumentar tamaño de la ventana
        ventanaMesa.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        ventanaMesa.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10); // Márgenes internos
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Crear el JComboBox con las mesas
        JComboBox<String> comboMesas = new JComboBox<>();
        for (int i = 1; i <= 8; i++) {
            comboMesas.addItem("Mesa " + i);
        }
        comboMesas.setPreferredSize(new Dimension(300, 40)); // Tamaño del JComboBox
        comboMesas.setBackground(Color.GREEN); // Color fosforescente
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2; // Ocupa 2 columnas
        ventanaMesa.add(comboMesas, gbc);

        // Crear el panel para los botones
        JPanel panelBotones = new JPanel();
        panelBotones.setLayout(new GridLayout(1, 2, 10, 0)); // GridLayout con espacio entre botones

        // Crear el botón Guardar
        JButton botonGuardar = new JButton("Guardar");
        botonGuardar.setFont(new Font("Arial", Font.BOLD, 16)); // Tamaño de fuente mayor
        botonGuardar.setPreferredSize(new Dimension(150, 50)); // Tamaño del botón
        botonGuardar.setBackground(new Color(34, 139, 34)); // Verde oscuro
        botonGuardar.setForeground(Color.WHITE);
        botonGuardar.setFocusPainted(false);
        botonGuardar.setBorder(BorderFactory.createRaisedBevelBorder());
        botonGuardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String mesaSeleccionada = (String) comboMesas.getSelectedItem();
                guardarPedidos(mesaSeleccionada);
                ventanaMesa.dispose(); // Cierra la ventana de selección
            }
        });

        // Crear el botón Cancelar
        JButton botonCancelar = new JButton("Cancelar");
        botonCancelar.setFont(new Font("Arial", Font.BOLD, 16)); // Tamaño de fuente mayor
        botonCancelar.setPreferredSize(new Dimension(150, 50)); // Tamaño del botón
        botonCancelar.setBackground(new Color(220, 20, 60)); // Rojo oscuro
        botonCancelar.setForeground(Color.WHITE);
        botonCancelar.setFocusPainted(false);
        botonCancelar.setBorder(BorderFactory.createRaisedBevelBorder());
        botonCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ventanaMesa.dispose(); // Cierra la ventana de selección
            }
        });

        // Añadir botones al panel
        panelBotones.add(botonGuardar);
        panelBotones.add(botonCancelar);

        // Añadir panel de botones al JFrame
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 2; // Ocupa 2 columnas
        gbc.fill = GridBagConstraints.NONE; // No llenar el espacio
        gbc.anchor = GridBagConstraints.CENTER; // Centrar los botones
        ventanaMesa.add(panelBotones, gbc);

        // Centrar la ventana en la pantalla
        ventanaMesa.setLocationRelativeTo(null);

        // Mostrar la ventana
        ventanaMesa.setVisible(true);
        
    }

    private void agregarProductoATabla(String producto) {
        String precioString = obtenerPrecioProducto(producto);

        // Mensaje de depuración para mostrar el valor del precio
        System.out.println("Precio obtenido: " + precioString);

        BigDecimal precio;
        try {
            // Asegúrate de que el formato del precio sea correcto (reemplazar comas por puntos, etc.)
            precioString = precioString.replace(",", ".").trim(); // Reemplazar comas por puntos y eliminar espacios
            precio = new BigDecimal(precioString).setScale(2, RoundingMode.HALF_UP);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Error al obtener el precio del producto. Verifique el formato del precio: " + precioString, "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Crear un nuevo modelo de tabla si no existe
        DefaultTableModel modelo = (DefaultTableModel) tabla_pedidos.getModel();

        // Verificar si el producto ya está en la tabla
        boolean productoExiste = false;
        int filaExistente = -1;

        for (int i = 0; i < modelo.getRowCount(); i++) {
            String nombreProducto = (String) modelo.getValueAt(i, 1);
            if (nombreProducto.equals(producto)) {
                productoExiste = true;
                filaExistente = i;
                break;
            }
        }

        if (productoExiste) {
            // Actualizar la cantidad y el precio si el producto ya existe en la tabla
            int cantidadActual;
            BigDecimal precioActual;
            try {
                cantidadActual = (int) modelo.getValueAt(filaExistente, 0);
                Object precioObj = modelo.getValueAt(filaExistente, 2);

                // Verificar el tipo de precio y convertir si es necesario
                if (precioObj instanceof BigDecimal) {
                    precioActual = (BigDecimal) precioObj;
                } else if (precioObj instanceof Number) {
                    precioActual = new BigDecimal(((Number) precioObj).toString()).setScale(2, RoundingMode.HALF_UP);
                } else {
                    throw new ClassCastException("Tipo de dato inesperado para el precio.");
                }
            } catch (ClassCastException e) {
                JOptionPane.showMessageDialog(this, "Error al procesar la fila del producto existente. Verifique los datos en la tabla.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Actualizar cantidad y precio
            modelo.setValueAt(cantidadActual + 1, filaExistente, 0); // Incrementar cantidad
            modelo.setValueAt(precioActual.add(precio), filaExistente, 2); // Actualizar precio total
        } else {
            // Agregar nuevo producto a la tabla
            modelo.addRow(new Object[]{
                1, // Cantidad inicial
                producto, // Nombre del producto
                precio // Precio
            });
        }

        // Limpiar la selección de la lista de productos
        Lista_Productos.clearSelection();
    }

    public HashMap<String, ArrayList<String[]>> getPedidosPorMesa() {
        return pedidosPorMesa;
    }
    

    public void agregarPedido(String mesa, String[] pedido) {
        if (!pedidosPorMesa.containsKey(mesa)) {
            pedidosPorMesa.put(mesa, new ArrayList<>());
        }
        pedidosPorMesa.get(mesa).add(pedido);
    }
   

    private String obtenerPrecioProducto(String producto) {
      String precio = "0.00";
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            String sql = "SELECT PRECIO FROM PRODUCTOS WHERE PRODUCTO_NOM= ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, producto);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                precio = resultSet.getString("PRECIO");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (resultSet != null) resultSet.close();
                if (preparedStatement != null) preparedStatement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return precio;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        limpiar = new javax.swing.JButton();
        eliminar = new javax.swing.JButton();
        guardar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla_pedidos = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        Lista_Productos = new javax.swing.JList<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        btn_buscar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1024, 750));
        getContentPane().setLayout(null);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setMinimumSize(new java.awt.Dimension(690, 720));
        jPanel2.setPreferredSize(new java.awt.Dimension(690, 720));
        jPanel2.setLayout(null);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 3, 32)); // NOI18N
        jLabel2.setText("Productos");
        jPanel2.add(jLabel2);
        jLabel2.setBounds(380, 20, 160, 40);

        limpiar.setBackground(new java.awt.Color(250, 250, 250));
        limpiar.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        limpiar.setForeground(new java.awt.Color(0, 0, 255));
        limpiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyecto/icons8-escoba-50.png"))); // NOI18N
        limpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                limpiarActionPerformed(evt);
            }
        });
        jPanel2.add(limpiar);
        limpiar.setBounds(260, 610, 110, 90);

        eliminar.setBackground(new java.awt.Color(250, 250, 250));
        eliminar.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        eliminar.setForeground(new java.awt.Color(0, 0, 255));
        eliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyecto/icons8-eliminar-50.png"))); // NOI18N
        eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarActionPerformed(evt);
            }
        });
        jPanel2.add(eliminar);
        eliminar.setBounds(10, 610, 120, 90);

        guardar.setBackground(new java.awt.Color(170, 170, 170));
        guardar.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        guardar.setForeground(new java.awt.Color(0, 0, 255));
        guardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyecto/icons8-obtener-50.png"))); // NOI18N
        guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarActionPerformed(evt);
            }
        });
        jPanel2.add(guardar);
        guardar.setBounds(140, 610, 110, 90);

        tabla_pedidos.setBackground(new java.awt.Color(204, 204, 255));
        tabla_pedidos.setFont(new java.awt.Font("Franklin Gothic Demi Cond", 0, 18)); // NOI18N
        tabla_pedidos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "#", "Producto", "Precio"
            }
        ));
        tabla_pedidos.setRowHeight(32);
        jScrollPane1.setViewportView(tabla_pedidos);

        jPanel2.add(jScrollPane1);
        jScrollPane1.setBounds(10, 70, 360, 530);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setMinimumSize(new java.awt.Dimension(300, 720));
        jPanel1.setLayout(null);

        jButton1.setText("jButton1");
        jPanel1.add(jButton1);
        jButton1.setBounds(500, 60, 75, 23);

        jButton2.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyecto/icons8-cigarro-64.png"))); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2);
        jButton2.setBounds(100, 570, 80, 100);

        jButton3.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyecto/hamburguesa.png"))); // NOI18N
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3);
        jButton3.setBounds(10, 50, 80, 100);

        jButton4.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyecto/icons8-salchicha-64.png"))); // NOI18N
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4);
        jButton4.setBounds(100, 50, 80, 100);

        jButton5.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyecto/icons8-chicken-wings-64.png"))); // NOI18N
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton5);
        jButton5.setBounds(10, 180, 80, 100);

        jButton6.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyecto/icons8-baile-64.png"))); // NOI18N
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton6);
        jButton6.setBounds(100, 180, 80, 100);

        jButton7.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyecto/icons8-postre-48.png"))); // NOI18N
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton7);
        jButton7.setBounds(10, 310, 80, 100);

        jButton8.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyecto/icons8-copa-de-soda-64.png"))); // NOI18N
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton8);
        jButton8.setBounds(100, 310, 80, 100);

        jButton9.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        jButton9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyecto/icons8-cerveza-64.png"))); // NOI18N
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton9);
        jButton9.setBounds(10, 440, 80, 100);

        jButton10.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        jButton10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyecto/icons8-cóctel-64.png"))); // NOI18N
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton10);
        jButton10.setBounds(100, 440, 80, 100);

        jButton11.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        jButton11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyecto/icons8-bar-64.png"))); // NOI18N
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton11);
        jButton11.setBounds(10, 570, 80, 100);

        jLabel1.setBackground(new java.awt.Color(0, 51, 204));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 3, 32)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 255));
        jLabel1.setText("Categoria");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(20, 0, 190, 50);

        jPanel2.add(jPanel1);
        jPanel1.setBounds(710, 20, 190, 680);

        Lista_Productos.setBackground(new java.awt.Color(204, 204, 204));
        Lista_Productos.setFont(new java.awt.Font("Bernard MT Condensed", 0, 32)); // NOI18N
        jScrollPane2.setViewportView(Lista_Productos);

        jPanel2.add(jScrollPane2);
        jScrollPane2.setBounds(380, 70, 330, 630);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyecto/103825100-comida-de-restaurante.jpg"))); // NOI18N
        jPanel2.add(jLabel3);
        jLabel3.setBounds(240, 110, 480, 480);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jLabel4.setText("Pedidos");
        jPanel2.add(jLabel4);
        jLabel4.setBounds(10, 0, 170, 30);

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        jPanel2.add(jTextField1);
        jTextField1.setBounds(160, 30, 200, 30);

        btn_buscar.setBackground(new java.awt.Color(255, 0, 0));
        btn_buscar.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        btn_buscar.setForeground(new java.awt.Color(255, 255, 255));
        btn_buscar.setText("Buscar");
        btn_buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_buscarActionPerformed(evt);
            }
        });
        jPanel2.add(btn_buscar);
        btn_buscar.setBounds(10, 30, 140, 30);

        getContentPane().add(jPanel2);
        jPanel2.setBounds(0, 0, 900, 710);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        AgregarLista("1");

    }//GEN-LAST:event_jButton3ActionPerformed
    
    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        AgregarLista("2");
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        AgregarLista("3");
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        AgregarLista("4");
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        AgregarLista("5");
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        AgregarLista("6");
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        AgregarLista("7");
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        AgregarLista("8");
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        AgregarLista("9");
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        AgregarLista("10");
    }//GEN-LAST:event_jButton2ActionPerformed
    //private int contadorMesas = 1;
    private void guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarActionPerformed
        mostrarVentanaSeleccionMesa();
        
    }//GEN-LAST:event_guardarActionPerformed
    private void guardarPedidos(String mesaSeleccionada) {
        DefaultTableModel model = (DefaultTableModel) tabla_pedidos.getModel();

        if (mesaSeleccionada != null) {
            ArrayList<String[]> pedidos = new ArrayList<>();

            // Verificar si la mesa seleccionada ya está ocupada
            if (pedidosPorMesa.containsKey(mesaSeleccionada)) {
                // Mostrar mensaje si la mesa ya está ocupada
                JOptionPane.showMessageDialog(this,
                        "La " + mesaSeleccionada + " ya está ocupada.",
                        "Mesa Ocupada",
                        JOptionPane.WARNING_MESSAGE);
                return;
            }

            // Agregar los nuevos pedidos a la lista
            for (int i = 0; i < model.getRowCount(); i++) {
                try {
                    String cantidad = String.valueOf(model.getValueAt(i, 0)); // Cantidad en la primera columna
                    String producto = (String) model.getValueAt(i, 1);
                    String precio = String.valueOf(model.getValueAt(i, 2));
                    String estado = "Pendiente"; // Estado inicial

                    // Añadir el nuevo pedido a la lista de pedidos
                    pedidos.add(new String[]{mesaSeleccionada, producto, cantidad, precio, estado});
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(this, "Error al procesar la tabla. Verifique los valores.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            }

            // Guardar los pedidos en el HashMap
            pedidosPorMesa.put(mesaSeleccionada, pedidos);
            JOptionPane.showMessageDialog(this, "Pedidos guardados exitosamente para " + mesaSeleccionada);

            // Limpiar la tabla después de guardar
            model.setRowCount(0);
        } else {
            JOptionPane.showMessageDialog(this, "Seleccione una mesa para guardar los pedidos.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarActionPerformed
        DefaultTableModel model = (DefaultTableModel) tabla_pedidos.getModel();
        int selectedRow = tabla_pedidos.getSelectedRow();
        if (selectedRow >= 0) {
            model.removeRow(selectedRow);
        } else {
            JOptionPane.showMessageDialog(this, "Selecciona una fila para eliminar.");
        }
    }//GEN-LAST:event_eliminarActionPerformed
    private void actualizarComboMesas() {
        comboBoxMesas.removeAllItems(); // Limpiar el JComboBox

        for (int i = 1; i <= 8; i++) {
            String mesa = "Mesa " + i;
            String estado = pedidosPorMesa.containsKey(mesa) ? "Ocupada" : "Disponible";
            comboBoxMesas.addItem(mesa + " - " + estado);
        }
    }
    private void limpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_limpiarActionPerformed
       DefaultTableModel model = (DefaultTableModel) tabla_pedidos.getModel();
        model.setRowCount(0);
    }//GEN-LAST:event_limpiarActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
         btn_buscarActionPerformed(evt);
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void btn_buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_buscarActionPerformed
         String mesaSeleccionada = jTextField1.getText().trim();

        if (!mesaSeleccionada.isEmpty()) {
            // Mostrar los productos de la mesa seleccionada
            mostrarProductosEnMesa(mesaSeleccionada);
        } else {
            JOptionPane.showMessageDialog(this, "Por favor, introduzca una mesa.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btn_buscarActionPerformed
    private void mostrarProductosEnMesa(String mesaSeleccionada) { 
        DefaultTableModel model = (DefaultTableModel) tabla_pedidos.getModel();

        // Limpiar la tabla actual
        model.setRowCount(0);
        model.setColumnIdentifiers(new Object[]{"#", "Producto", "Precio"});

        if (pedidosPorMesa.containsKey(mesaSeleccionada)) {
            List<String[]> pedidos = pedidosPorMesa.get(mesaSeleccionada);
            for (String[] pedido : pedidos) {
                // Verifica el formato esperado de los datos
                if (pedido.length >= 4) {
                    try {
                        int cantidad = Integer.parseInt(pedido[2]);
                        BigDecimal precio = new BigDecimal(pedido[3]).setScale(2, RoundingMode.HALF_UP);
                        model.addRow(new Object[]{cantidad, pedido[1], precio});
                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(this, "Error en los datos del pedido. Verifique el formato.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "No hay pedidos guardados para la mesa " + mesaSeleccionada, "Sin Pedidos", JOptionPane.INFORMATION_MESSAGE);
        }

        ajustarColumnasTablaPedidos();
        
    }

   
    private void mostrarPedidosEnTabla(String mesa) {

        DefaultTableModel model = (DefaultTableModel) tabla_pedidos.getModel();
        model.setRowCount(0); // Limpiar la tabla antes de mostrar los nuevos datos

        ArrayList<String[]> pedidos = pedidosPorMesa.get(mesa);
        if (pedidos != null) {
            for (String[] pedido : pedidos) {
                model.addRow(new Object[]{model.getRowCount() + 1, pedido[1], pedido[3]}); // Agregar filas con el formato adecuado
            }
        }
    }
    
    private void actualizarComboBoxMesas() {
        if (mesaComboBox != null) {
            mesaComboBox.removeAllItems();
            for (String mesa : pedidosPorMesa.keySet()) {
                mesaComboBox.addItem(mesa);
            }
        }   
    }

    private void addToOrder(String producto, int precio) {
         DefaultTableModel model = (DefaultTableModel) tabla_pedidos.getModel();
        model.addRow(new Object[]{model.getRowCount() + 1, producto, precio});
        
    }

    private void AgregarLista (String Categoria)
    {
        String Productos[] = ReadBD("select Producto_nom from Productos where categoria_id = "+Categoria,"Producto_nom");
    
        DefaultListModel<String> modelo = (DefaultListModel<String>) Lista_Productos.getModel();
        modelo.clear();
        if (modelo instanceof DefaultListModel) {
            for (String elemento : Productos) {
                modelo.addElement(elemento);
            }
        } else {
            System.out.println("El modelo no es un DefaultListModel.");
        }
       
    }
    
    
    public static String[] ReadBD(String Sentencia, String ParteTabla) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        List<String> List_Momentania = new ArrayList<>();

        try {
            // Cargar el driver JDBC
            Class.forName("oracle.jdbc.driver.OracleDriver");

            // Establecer la conexión
            conn = DriverManager.getConnection(URL, USER, PASSWORD);

            // Crear un statement
            stmt = conn.createStatement();

            // Ejecutar la consulta
            rs = stmt.executeQuery(Sentencia);

            // Procesar los resultados
            while (rs.next()) {
                String Cate = rs.getString(ParteTabla);
                List_Momentania.add(Cate);
            }

            // Convertir la lista en un array
            return List_Momentania.toArray(new String[0]);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Cerrar los recursos
            try {
                if (rs != null) {
                    rs.close();
                }
                if (stmt != null) {
                    stmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        // Retornar null si ocurrió algún error
        return null;
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
 
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> new menu_opciones().setVisible(true));
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JList<String> Lista_Productos;
    private javax.swing.JButton btn_buscar;
    private javax.swing.JButton eliminar;
    private javax.swing.JButton guardar;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JButton limpiar;
    private javax.swing.JTable tabla_pedidos;
    // End of variables declaration//GEN-END:variables

}
 
