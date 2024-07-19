package menu;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.swing.table.JTableHeader;

public class Menu extends JFrame {
    private JPanel panel_opciones;
    private JPanel panel_pedidos;
    private JButton texto_Categoria;
    private JTable pedidosTable;
    private DefaultTableModel tableModel;
    private JButton removeButton;
    private JButton payButton; // Botón para pagar
    private JButton saveButton; // Botón para guardar
    private JButton clearButton; // Botón para limpiar
    private JButton clientesAtendidosButton; // Botón para clientes atendidos
    private JTextField buscarTextField; // TextField para búsqueda
    private JButton buscarButton; // Botón para buscar productos
    private double total; // Variable para almacenar el total
    private Map<String, ArrayList<String[]>> clientesAtendidos = new HashMap<>(); // Map para almacenar los pedidos por mesa
    private int mesaCounter = 1; // Contador de mesas
    private JComboBox<String> mesasComboBox; // ComboBox para mostrar mesas atendidas

    public Menu() {
        initComponents();
    }
    private void abrirInventario() {
        JFrame inventarioFrame = new JFrame("Inventario");
        inventarioFrame.setSize(1020, 580);
        inventarioFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        inventarioFrame.setLayout(new BorderLayout());

        // Crear el modelo de tabla para el inventario
        String[] columnNames = {"Producto", "Cantidad", "Precio"};
        DefaultTableModel inventarioTableModel = new DefaultTableModel(columnNames, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Hacer que la tabla no sea editable
            }
        };

        // Crear la tabla de inventario
        JTable inventarioTable = new JTable(inventarioTableModel);
        inventarioTable.setFont(new Font("Arial", Font.PLAIN, 16));
        inventarioTable.setRowHeight(30);
        JScrollPane scrollPane = new JScrollPane(inventarioTable);
        inventarioFrame.add(scrollPane, BorderLayout.CENTER);

        // Crear panel para los botones
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));

        // Botón Agregar
        JButton agregarButton = new JButton("Agregar");
        agregarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Aquí puedes implementar la funcionalidad para agregar un nuevo producto
                String producto = JOptionPane.showInputDialog(inventarioFrame, "Ingrese el nombre del producto:");
                String cantidadStr = JOptionPane.showInputDialog(inventarioFrame, "Ingrese la cantidad:");
                String precioStr = JOptionPane.showInputDialog(inventarioFrame, "Ingrese el precio:");

                if (producto != null && cantidadStr != null && precioStr != null) {
                    try {
                        int cantidad = Integer.parseInt(cantidadStr);
                        double precio = Double.parseDouble(precioStr);
                        inventarioTableModel.addRow(new Object[]{producto, cantidad, precio});
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(inventarioFrame, "Cantidad o precio inválidos.");
                    }
                }
            }
        });
        buttonPanel.add(agregarButton);

        // Botón Limpiar
        JButton limpiarButton = new JButton("Limpiar");
        limpiarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                inventarioTableModel.setRowCount(0); // Limpiar todas las filas
            }
        });
        buttonPanel.add(limpiarButton);

        // Botón Borrar
        JButton borrarButton = new JButton("Borrar");
        borrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = inventarioTable.getSelectedRow();
                if (selectedRow != -1) {
                    inventarioTableModel.removeRow(selectedRow);
                } else {
                    JOptionPane.showMessageDialog(inventarioFrame, "Seleccione una fila para borrar.");
                }
            }
        });
        buttonPanel.add(borrarButton);

        // Botón Atrás
        JButton atrasButton = new JButton("Atrás");
        atrasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                inventarioFrame.dispose(); // Cerrar la ventana de inventario
            }
        });
        buttonPanel.add(atrasButton);

        inventarioFrame.add(buttonPanel, BorderLayout.SOUTH);

        inventarioFrame.setVisible(true);
    }


    private void initComponents() {
        panel_opciones = new JPanel();
        texto_Categoria = new JButton();
        panel_pedidos = new JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(1020, 580));
        setLayout(null);
        getContentPane().setBackground(new Color(0, 0, 128)); // Cambiar el color de fondo a azul marino

        panel_opciones.setBackground(new Color(204, 204, 255));
        panel_opciones.setLayout(new GridLayout(0, 1));
        add(panel_opciones);
        panel_opciones.setBounds(410, 40, 340, 370);

        panel_pedidos.setBackground(new Color(135, 206, 250)); // Color celeste
        panel_pedidos.setLayout(new BorderLayout());
        add(panel_pedidos);
        panel_pedidos.setBounds(90, 40, 310, 370);

        // Crear la JTable
        String[] columnNames = {"#", "Producto", "Precio"};
        tableModel = new DefaultTableModel(columnNames, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Hacer que la tabla no sea editable
            }
        };
        pedidosTable = new JTable(tableModel);
        pedidosTable.setFont(new Font("Arial", Font.PLAIN, 18)); // Tamaño de texto más grande
        pedidosTable.setRowHeight(30); // Aumentar el alto de las filas

        // Ajustar el ancho de la columna #
        pedidosTable.getColumnModel().getColumn(0).setPreferredWidth(40); // Ancho para la columna #

        JTableHeader header = pedidosTable.getTableHeader();
        header.setFont(new Font("Arial", Font.BOLD, 18)); // Tamaño de texto más grande para el encabezado
        JScrollPane scrollPane = new JScrollPane(pedidosTable);
        panel_pedidos.add(scrollPane, BorderLayout.CENTER);

        // Panel para botones de acción
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());

        // Botón para eliminar un producto
        removeButton = new JButton("Eliminar Producto");
        removeButton.addActionListener(e -> eliminarProducto());
        buttonPanel.add(removeButton);

        // Botón para guardar
        saveButton = new JButton("Guardar");
        saveButton.addActionListener(e -> guardarPedidos());
        buttonPanel.add(saveButton);

        // Botón para limpiar
        clearButton = new JButton("Limpiar");
        clearButton.addActionListener(e -> limpiarPedidos());
        buttonPanel.add(clearButton);

        panel_pedidos.add(buttonPanel, BorderLayout.SOUTH);

        // Panel para TextField y Botón de búsqueda
        JPanel searchPanel = new JPanel();
        searchPanel.setLayout(new FlowLayout());

        buscarTextField = new JTextField();
        buscarTextField.setPreferredSize(new Dimension(200, 30)); // Ajustar tamaño
        searchPanel.add(buscarTextField);

        buscarButton = new JButton("Buscar");
        buscarButton.setPreferredSize(new Dimension(100, 30)); // Ajustar tamaño
        buscarButton.addActionListener(e -> buscarMesa());
        searchPanel.add(buscarButton);

        panel_pedidos.add(searchPanel, BorderLayout.NORTH);

        // Títulos de categorías
        JLabel categoriaLabel = new JLabel("Categorías", SwingConstants.CENTER);
        categoriaLabel.setFont(new Font("Arial", Font.BOLD, 24));
        categoriaLabel.setForeground(Color.WHITE);
        add(categoriaLabel);
        categoriaLabel.setBounds(760, 40, 230, 30);

        // Botones de categorías
        String[] productos = {
                "Hamburguesa", "Salchipapa", "Alitas", "Piqueos", "Postres",
                "Gaseosa", "Refrescos", "Cerveza", "Cigarros", "Cocteles", "Pack de bebidas"
        };

        int yPosition = 80;
        for (String producto : productos) {
            JButton button = new JButton(producto);
            button.setBounds(760, yPosition, 230, 30);
            button.addActionListener(e -> mostrarOpciones(producto));
            add(button);
            yPosition += 30;
        }

        // Botón "Baucher"
        payButton = new JButton("Baucher: S/. 0.00");
        payButton.setBounds(780, 430, 200, 80); // Ajustar posición
        payButton.setBackground(new Color(255, 255, 0)); // Color de fondo amarillo
        payButton.addActionListener(e -> pagar());
        payButton.setFont(new Font("Arial", Font.BOLD, 16)); // Fuente en negrita
        payButton.setHorizontalAlignment(SwingConstants.CENTER);
        payButton.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2)); // Bordes del botón
        payButton.setBorder(BorderFactory.createCompoundBorder(
                payButton.getBorder(),
                BorderFactory.createEmptyBorder(10, 10, 10, 10) // Espacio interno
        ));
        add(payButton);

        // Botones de navegación
        JButton inventarioButton = new JButton("Inventario");
        JButton totalVendidoButton = new JButton("Total Vendido");

        // Ajustar tamaño y centrar
        Dimension buttonSize = new Dimension(150, 50);
        inventarioButton.setPreferredSize(buttonSize);
        totalVendidoButton.setPreferredSize(buttonSize);

        inventarioButton.addActionListener(e -> abrirInventario());
        totalVendidoButton.addActionListener(e -> abrirVentanaVacía("Total Vendido"));

        JPanel navButtonPanel = new JPanel();
        navButtonPanel.setBackground(new Color(0, 0, 128)); // Color azul marino
        navButtonPanel.setLayout(new FlowLayout(FlowLayout.LEFT)); // Alinear a la izquierda
        navButtonPanel.add(inventarioButton);
        navButtonPanel.add(totalVendidoButton);

        // Botón "Clientes Atendidos"
        clientesAtendidosButton = new JButton("Clientes Atendidos");
        clientesAtendidosButton.setPreferredSize(buttonSize);
        clientesAtendidosButton.addActionListener(e -> mostrarClientesAtendidos());
        navButtonPanel.add(clientesAtendidosButton);

        add(navButtonPanel);
        navButtonPanel.setBounds(0, 450, 1020, 50); // Ajustar posición

        pack();
    }

    private void mostrarOpciones(String categoria) {
        panel_opciones.removeAll();
        texto_Categoria.setText("\"" + categoria + "\""); // Añadir comillas
        texto_Categoria.setFont(new Font("Arial", Font.BOLD, 24)); // Negrita y tamaño
        texto_Categoria.setHorizontalAlignment(SwingConstants.CENTER);
        panel_opciones.add(texto_Categoria);

        String[] opciones = getOpciones(categoria);
        Color colorOpcion = new Color(204, 204, 255); // Cambiar color por opción

        for (String opcion : opciones) {
            JButton button = new JButton(opcion);
            button.setBackground(colorOpcion); // Cambiar color por opción
            button.addActionListener(e -> agregarPedido(opcion));
            panel_opciones.add(button);
        }
        panel_opciones.revalidate();
        panel_opciones.repaint();
    }

    private void agregarPedido(String pedido) {
        String precio = getPrecio(pedido); // Obtener el precio del producto seleccionado
        total += Double.parseDouble(precio); // Sumar al total
        tableModel.addRow(new Object[]{tableModel.getRowCount() + 1, pedido, precio}); // Agregar número

        // Desplazar la vista hacia la última fila agregada
        int lastRow = tableModel.getRowCount() - 1;
        pedidosTable.scrollRectToVisible(pedidosTable.getCellRect(lastRow, 0, true));

        payButton.setText("Baucher: S/. " + total); // Actualizar texto del botón "Baucher"
    }

    private void eliminarProducto() {
        int selectedRow = pedidosTable.getSelectedRow();
        if (selectedRow >= 0) {
            String precio = (String) tableModel.getValueAt(selectedRow, 2);
            total -= Double.parseDouble(precio);
            tableModel.removeRow(selectedRow);

            // Actualizar el número de orden en la columna "#"
            for (int i = 0; i < tableModel.getRowCount(); i++) {
                tableModel.setValueAt(i + 1, i, 0); // Actualizar el número
            }

            payButton.setText("Baucher: S/. " + total); // Actualizar texto del botón "Baucher"
        }
    }

    private void pagar() {
        if (tableModel.getRowCount() > 0) {
            StringBuilder baucherText = new StringBuilder();
            baucherText.append("Sabor Latino\n");
            baucherText.append("Huachipa - Perulandia\n");
            baucherText.append("RUC: 2173042587\n\n");
            baucherText.append("Pedido:\n");
            for (int i = 0; i < tableModel.getRowCount(); i++) {
                baucherText.append(tableModel.getValueAt(i, 1)).append(" - S/. ").append(tableModel.getValueAt(i, 2)).append("\n");
            }
            baucherText.append("\nTotal: S/. ").append(total);

            JOptionPane.showMessageDialog(this, baucherText.toString(), "Baucher", JOptionPane.INFORMATION_MESSAGE);

            // Limpiar tabla y reiniciar total
            tableModel.setRowCount(0);
            total = 0.0;
            payButton.setText("Baucher: S/. 0.00");
        }
    }

    private String[] getOpciones(String categoria) {
        // Aquí defines las opciones por categoría
        switch (categoria) {
            case "Hamburguesa":
                return new String[]{"Hamburguesa Simple", "Hamburguesa Doble", "Hamburguesa Triple"};
            case "Salchipapa":
                return new String[]{"Salchipapa Clásica", "Salchipapa Especial", "Salchipapa Super"};
            case "Alitas":
                return new String[]{"Alitas BBQ", "Alitas Picantes", "Alitas Miel Mostaza"};
            case "Piqueos":
                return new String[]{"Tequeños", "Papas Fritas", "Yuca Frita"};
            case "Postres":
                return new String[]{"Cheesecake", "Brownie", "Helado"};
            case "Gaseosa":
                return new String[]{"Coca Cola", "Pepsi", "Fanta"};
            case "Refrescos":
                return new String[]{"Limonada", "Chicha Morada", "Maracuyá"};
            case "Cerveza":
                return new String[]{"Cerveza Rubia", "Cerveza Negra", "Cerveza Roja"};
            case "Cigarros":
                return new String[]{"Marlboro", "Lucky Strike", "Winston"};
            case "Cocteles":
                return new String[]{"Pisco Sour", "Mojito", "Margarita"};
            case "Pack de bebidas":
                return new String[]{"Pack 6 cervezas", "Pack 12 cervezas", "Pack 24 cervezas"};
            default:
                return new String[0];
        }
    }

    private String getPrecio(String pedido) {
        // Aquí defines el precio por producto
        switch (pedido) {
            case "Hamburguesa Simple":
                return "10.00";
            case "Hamburguesa Doble":
                return "15.00";
            case "Hamburguesa Triple":
                return "20.00";
            case "Salchipapa Clásica":
                return "8.00";
            case "Salchipapa Especial":
                return "12.00";
            case "Salchipapa Super":
                return "16.00";
            case "Alitas BBQ":
                return "18.00";
            case "Alitas Picantes":
                return "18.00";
            case "Alitas Miel Mostaza":
                return "18.00";
            case "Tequeños":
                return "12.00";
            case "Papas Fritas":
                return "6.00";
            case "Yuca Frita":
                return "6.00";
            case "Cheesecake":
                return "10.00";
            case "Brownie":
                return "8.00";
            case "Helado":
                return "5.00";
            case "Coca Cola":
                return "3.00";
            case "Pepsi":
                return "3.00";
            case "Fanta":
                return "3.00";
            case "Limonada":
                return "5.00";
            case "Chicha Morada":
                return "5.00";
            case "Maracuyá":
                return "5.00";
            case "Cerveza Rubia":
                return "7.00";
            case "Cerveza Negra":
                return "8.00";
            case "Cerveza Roja":
                return "8.00";
            case "Marlboro":
                return "10.00";
            case "Lucky Strike":
                return "9.00";
            case "Winston":
                return "8.00";
            case "Pisco Sour":
                return "12.00";
            case "Mojito":
                return "15.00";
            case "Margarita":
                return "15.00";
            case "Pack 6 cervezas":
                return "40.00";
            case "Pack 12 cervezas":
                return "75.00";
            case "Pack 24 cervezas":
                return "140.00";
            default:
                return "0.00";
        }
    }

    

    private void abrirVentanaVacía(String title) {
        // Aquí defines la funcionalidad para abrir una ventana vacía
        JOptionPane.showMessageDialog(this, title, title, JOptionPane.INFORMATION_MESSAGE);
    }

    private void guardarPedidos() {
        if (tableModel.getRowCount() > 0) {
        String mesa = "Mesa " + mesaCounter;
        ArrayList<String[]> pedidos = new ArrayList<>();
        for (int i = 0; i < tableModel.getRowCount(); i++) {
            String producto = (String) tableModel.getValueAt(i, 1);
            String precio = (String) tableModel.getValueAt(i, 2);
            pedidos.add(new String[]{producto, precio});
        }
        clientesAtendidos.put(mesa, pedidos);
        mesaCounter++;
        tableModel.setRowCount(0); // Limpiar la tabla de pedidos
        total = 0.0; // Reiniciar el total
        payButton.setText("Baucher: S/. 0.00"); // Reiniciar el texto del botón "Baucher"
    }
}

    private void limpiarPedidos() {
        tableModel.setRowCount(0);
        total = 0.0;
        payButton.setText("Baucher: S/. 0.00");
    }

    private void mostrarClientesAtendidos() {
        JFrame clientesAtendidosFrame = new JFrame("Clientes Atendidos");
        clientesAtendidosFrame.setSize(800, 600);
        clientesAtendidosFrame.setLayout(new BorderLayout());

        // Crear el modelo de tabla para los clientes atendidos
        String[] columnNames = {"Mesa", "Producto", "Precio"};
        DefaultTableModel clientesTableModel = new DefaultTableModel(columnNames, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Hacer que la tabla no sea editable
            }
        };

        // Crear la tabla de clientes atendidos
        JTable clientesTable = new JTable(clientesTableModel);
        clientesTable.setFont(new Font("Arial", Font.PLAIN, 16));
        clientesTable.setRowHeight(30);
        JScrollPane scrollPane = new JScrollPane(clientesTable);
        clientesAtendidosFrame.add(scrollPane, BorderLayout.CENTER);

        // Cargar los datos de los clientes atendidos en la tabla
        for (Map.Entry<String, ArrayList<String[]>> entry : clientesAtendidos.entrySet()) {
            String mesa = entry.getKey();
            ArrayList<String[]> pedidos = entry.getValue();
            for (String[] pedido : pedidos) {
                clientesTableModel.addRow(new Object[]{mesa, pedido[0], pedido[1]});
                mesa = ""; // Dejar la columna de "Mesa" vacía para las filas subsecuentes
            }
        }

        // Panel para los botones
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));

        // Botón para regresar al menú principal
        JButton menuButton = new JButton("Menú");
        menuButton.setBackground(Color.RED);
        menuButton.setForeground(Color.WHITE);
        menuButton.setFont(new Font("Arial", Font.BOLD, 16));
        menuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clientesAtendidosFrame.dispose(); // Cerrar la ventana de clientes atendidos
                setVisible(true); // Mostrar el menú principal
            }
        });
        buttonPanel.add(menuButton);

        // Botón para cerrar la ventana
        JButton closeButton = new JButton("Cerrar");
        closeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clientesAtendidosFrame.dispose(); // Cerrar la ventana de clientes atendidos
            }
        });
        buttonPanel.add(closeButton);

        clientesAtendidosFrame.add(buttonPanel, BorderLayout.SOUTH);

        clientesAtendidosFrame.setVisible(true);
        setVisible(false); // Ocultar el menú principal mientras se muestra la ventana de clientes atendidos
    }

    private void buscarMesa() {
        String mesaBuscada = buscarTextField.getText();
        if (mesaBuscada != null && clientesAtendidos.containsKey(mesaBuscada)) {
            cargarPedidosAMesa(mesaBuscada);
        } else {
            JOptionPane.showMessageDialog(this, "Mesa no encontrada", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void cargarPedidosAMesa(String mesa) {
        if (mesa != null && clientesAtendidos.containsKey(mesa)) {
            ArrayList<String[]> pedidos = clientesAtendidos.get(mesa);
            tableModel.setRowCount(0);
            total = 0.0;
            for (String[] pedido : pedidos) {
                tableModel.addRow(new Object[]{tableModel.getRowCount() + 1, pedido[0], pedido[1]});
                total += Double.parseDouble(pedido[1]);
            }
            payButton.setText("Baucher: S/. " + total);
        }
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            new Menu().setVisible(true);
        });
    }
}
