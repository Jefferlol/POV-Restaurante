package menu;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.table.JTableHeader;

public class Menu extends JFrame {
    private JPanel panel_opciones;
    private JPanel panel_pedidos;
    private JButton texto_Categoria;
    private JTable pedidosTable;
    private DefaultTableModel tableModel;
    private JButton removeButton;
    private JButton payButton; // Botón para imprimir
    private double total; // Variable para almacenar el total

    public Menu() {
        initComponents();
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

        panel_pedidos.add(buttonPanel, BorderLayout.SOUTH);

        // Títulos de categorías
        JLabel categoriaLabel = new JLabel("Categorías", SwingConstants.CENTER);
        categoriaLabel.setFont(new Font("Arial", Font.BOLD, 24));
        categoriaLabel.setForeground(Color.WHITE);
        add(categoriaLabel);
        categoriaLabel.setBounds(760, 40, 230, 30);

        // Botones de categorías
        String[] productos = {
            "Hamburguesa", "Salchipapa", "Alitas", "Piqueos", "Postres", 
            "Gaseosa", "Refrescos", "Cervesa", "Cigarros", "Cocteles", "Pack de bebidas"
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
        JButton buscarButton = new JButton("Buscar");
        JButton totalVendidoButton = new JButton("Total Vendido");

        // Ajustar tamaño y centrar
        Dimension buttonSize = new Dimension(150, 50);
        inventarioButton.setPreferredSize(buttonSize);
        buscarButton.setPreferredSize(buttonSize);
        totalVendidoButton.setPreferredSize(buttonSize);

        inventarioButton.addActionListener(e -> abrirVentanaVacía("Inventario"));
        buscarButton.addActionListener(e -> abrirVentanaVacía("Buscar"));
        totalVendidoButton.addActionListener(e -> abrirVentanaVacía("Total Vendido"));

        JPanel navButtonPanel = new JPanel();
        navButtonPanel.setBackground(new Color(0, 0, 128)); // Color azul marino
        navButtonPanel.setLayout(new FlowLayout(FlowLayout.LEFT)); // Alinear a la izquierda
        navButtonPanel.add(inventarioButton);
        navButtonPanel.add(buscarButton);
        navButtonPanel.add(totalVendidoButton);
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
        String precio = getPrecio(pedido);
        total += Double.parseDouble(precio); // Sumar al total
        tableModel.addRow(new Object[]{tableModel.getRowCount() + 1, pedido, precio}); // Agregar número
        payButton.setText("Baucher: S/. " + total); // Actualizar texto del botón "Baucher"
    }

    private void eliminarProducto() {
        int selectedRow = pedidosTable.getSelectedRow();
        if (selectedRow != -1) {
            String precioStr = (String) tableModel.getValueAt(selectedRow, 2);
            total -= Double.parseDouble(precioStr); // Restar del total
            tableModel.removeRow(selectedRow);
            payButton.setText("Baucher: S/. " + total); // Actualizar texto del botón "Baucher"
        } else {
            JOptionPane.showMessageDialog(this, "Por favor, selecciona un producto a eliminar.");
        }
    }

    private void pagar() {
        StringBuilder baucher = new StringBuilder();
        baucher.append("\n");
        baucher.append("                  Sabor Latino             \n");
        
        baucher.append("Fecha y Hora: ")
               .append(LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")))
               .append("\n\n");
        baucher.append("Pedidos:\n");
        baucher.append("-------------------------------------\n");

        for (int i = 0; i < tableModel.getRowCount(); i++) {
            String producto = (String) tableModel.getValueAt(i, 1);
            String precio = (String) tableModel.getValueAt(i, 2);
            baucher.append((i + 1) + ". " + producto) // Enumerar productos
                   .append("  \t\t S/. ")
                   .append(precio)
                   .append("\n");
        }

        baucher.append("-------------------------------------\n");
        baucher.append("Total: \t\t S/. ")
               .append(total)
               .append("\n");
        baucher.append("=====================================");

        JOptionPane.showMessageDialog(this, baucher.toString(), "Baucher", JOptionPane.INFORMATION_MESSAGE);

        // Limpiar la tabla y restablecer el total
        tableModel.setRowCount(0);
        total = 0;
        payButton.setText("Baucher: S/. 0.00"); // Reiniciar texto del botón "Baucher"
    }

    private void abrirVentanaVacía(String titulo) {
        JFrame ventana = new JFrame(titulo);
        ventana.setSize(300, 200);
        ventana.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        ventana.setVisible(true);
    }

    private String[] getOpciones(String categoria) {
        return switch (categoria) {
            case "Hamburguesa" -> new String[]{"Hamburguesa Simple", "Hamburguesa Doble", "Hamburguesa Vegana"};
            case "Salchipapa" -> new String[]{"Salchipapa pecho", "Salchipapa con pierna","Salchichapapa entrepierna"};
            case "Alitas" -> new String[]{"Alitas BBQ", "Alitas Picantes"};
            case "Piqueos" -> new String[]{"Piqueo Variado"};
            case "Postres" -> new String[]{"Tarta de Limón", "Helado"};
            case "Gaseosa" -> new String[]{"Gaseosa Normal", "Gaseosa Dietética"};
            case "Refrescos" -> new String[]{"Jugo de Naranja", "Jugo de Piña"};
            case "Cerveza" -> new String[]{"Cristal", "Pilsen","Heineken"};
            case "Cigarros" -> new String[]{"Lucky", "Hamilton"};
            case "Cocteles" -> new String[]{"Mojito", "Piña Colada"};
            case "Pack de bebidas" -> new String[]{"Pack de 6 Gaseosas", "Pack de 6 Cervezas"};
            default -> new String[]{};
        };
    }

    private String getPrecio(String producto) {
        return switch (producto) {
            case "Hamburguesa Simple" -> "15.00";
            case "Hamburguesa Doble" -> "25.00";
            case "Hamburguesa Vegana" -> "18.00";
            case "Salchipapa Simple" -> "10.00";
            case "Salchipapa con Queso" -> "12.00";
            case "Alitas BBQ" -> "20.00";
            case "Alitas Picantes" -> "22.00";
            case "Piqueo Variado" -> "30.00";
            case "Tarta de Limón" -> "8.00";
            case "Helado" -> "5.00";
            case "Gaseosa Normal" -> "2.50";
            case "Gaseosa Dietética" -> "3.00";
            case "Jugo de Naranja" -> "3.50";
            case "Jugo de Piña" -> "3.50";
            case "Cristal" -> "10.00";
            case "Pilsen" -> "12.00";
            case "Heineken" -> "15.00";
            case "Lucky" -> "7.00";
            case "Hamilton" -> "10.00";
            case "Mojito" -> "15.00";
            case "Piña Colada" -> "15.00";
            case "Pack de 6 Gaseosas" -> "15.00";
            case "Pack de 6 Cervezas" -> "55.00";
            default -> "0.00";
        };
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Menu menu = new Menu();
            menu.setVisible(true);
        });
    }
}
