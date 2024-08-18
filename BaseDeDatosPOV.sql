



drop table Orden_detalle;
drop table FACTURA;
drop table usuarios;
drop table inv_fijo;
drop table inv_Nofijo;
drop table Ordenes;
drop table Productos;
drop table categorias;


CREATE TABLE Categorias (
    Categoria_id NUMBER GENERATED BY DEFAULT ON NULL AS IDENTITY,
    Categoria_nom VARCHAR2(50) NOT NULL,
    PRIMARY KEY (Categoria_id)
);


-- Crear Tabla de Productos
CREATE TABLE Productos (
    Producto_id NUMBER GENERATED BY DEFAULT ON NULL AS IDENTITY,
    Producto_nom VARCHAR2(100) NOT NULL,
    Categoria_id NUMBER,
    Precio NUMBER(10, 2) NOT NULL,
    description CLOB,
    PRIMARY KEY (Producto_id),
    FOREIGN KEY (Categoria_id) REFERENCES Categorias(Categoria_id)
);
-- Crear Tabla de Pedidos
CREATE TABLE Ordenes (
    Orden_id NUMBER GENERATED BY DEFAULT ON NULL AS IDENTITY,
    Cliente_id char(8) not null,
    Orden_fecha TIMESTAMP NOT NULL,
    Total NUMBER(10, 2) NOT NULL,
    Estado VARCHAR2(20) NOT NULL,
    PRIMARY KEY (Orden_id)
);

-- Crear Tabla de Detalles del Pedido
CREATE TABLE Orden_Detalle (
    Orden_Detalle_id NUMBER GENERATED BY DEFAULT ON NULL AS IDENTITY,
    Orden_id NUMBER,
    Producto_id NUMBER,
    Cantidad NUMBER NOT NULL,
    Precio NUMBER(10, 2) NOT NULL,
    PRIMARY KEY (Orden_Detalle_id),
    FOREIGN KEY (Orden_id) REFERENCES Ordenes(Orden_id),
    FOREIGN KEY (Producto_id) REFERENCES Productos(Producto_id)
);
select * from orden_detalle
-- Crear Tabla de Facturas
CREATE TABLE Factura (
    Factura_id NUMBER GENERATED BY DEFAULT ON NULL AS IDENTITY,
    Orden_id NUMBER,
    Factura_fecha TIMESTAMP NOT NULL,
    Monto NUMBER(10, 2) NOT NULL,
    PRIMARY KEY (Factura_id),
    FOREIGN KEY (Orden_id) REFERENCES Ordenes(Orden_id)
);
-- Crear Tabla de Usuarios
CREATE TABLE Usuarios (
    Usuario_id NUMBER GENERATED BY DEFAULT ON NULL AS IDENTITY,
    Username VARCHAR2(50) NOT NULL UNIQUE,
    Contrasena VARCHAR2(255) NOT NULL,
    Rol VARCHAR2(20) NOT NULL,
    Nombre VARCHAR2(100) NOT NULL,
    PRIMARY KEY (Usuario_id)
);

CREATE TABLE Inv_Fijo (
    Inv_Fijo_id NUMBER GENERATED BY DEFAULT ON NULL AS IDENTITY,
    Producto_id NUMBER NOT NULL,
    Stock_Disponible NUMBER NOT NULL,
    PRIMARY KEY (Inv_Fijo_id),
    FOREIGN KEY (Producto_id) REFERENCES Productos(Producto_id)
);

create TABLE Inv_NoFijo (
    Inv_NoFijo_id NUMBER GENERATED BY DEFAULT ON NULL AS IDENTITY,
    Producto_id NUMBER NOT NULL,
    Stock_Disponible CHAR(1) default 'N' CHECK (Stock_Disponible IN ('N', 'S'))Not null,
    PRIMARY KEY (Inv_NoFijo_id),
    FOREIGN KEY (Producto_id) REFERENCES Productos(Producto_id)
);


-------INSERTS----------

INSERT INTO Categorias (Categoria_nom) VALUES ('Hamburguesa');
INSERT INTO Categorias (Categoria_nom) VALUES ('Salchipapa');
INSERT INTO Categorias (Categoria_nom) VALUES ('Alitas ');
INSERT INTO Categorias (Categoria_nom) VALUES ('Piqueos');
INSERT INTO Categorias (Categoria_nom) VALUES ('Postres');
INSERT INTO Categorias (Categoria_nom) VALUES ('Refrescos');
INSERT INTO Categorias (Categoria_nom) VALUES ('Cervezas');
INSERT INTO Categorias (Categoria_nom) VALUES ('Cocteles');
INSERT INTO Categorias (Categoria_nom) VALUES ('Pack de Bebidas');
INSERT INTO Categorias (Categoria_nom) VALUES ('Cigarros');


-- Insertar Productos
INSERT INTO Productos (Producto_nom, Categoria_id, Precio, description) VALUES ('H. Pollo Deshilachado', 1, 8, 'H. pollo deshilachado con papas');
INSERT INTO Productos (Producto_nom, Categoria_id, Precio, description) VALUES ('H. Clasica',1, 10, 'Hamburguesa de carne con papas');
INSERT INTO Productos (Producto_nom, Categoria_id, Precio, description) VALUES ('H. Cheese', 1, 12, 'Hamburguesa de carne, queso con papas');
INSERT INTO Productos (Producto_nom, Categoria_id, Precio, description) VALUES ('H. Queso Tocino',1,14, 'Hamburguesa de carne, queso, 2 tiras de tocino con papas');
INSERT INTO Productos (Producto_nom, Categoria_id, Precio, description) VALUES ('H. Hawaiana con Carne',1,15,'Hamburguesa de carne, pi�a, queso, jamon ingles con papas');
INSERT INTO Productos (Producto_nom, Categoria_id, Precio, description) VALUES ('H. Hawaiana con Filete de Pollo',1,15,'Hamburguesa de filete de pollo, pi�a, queso, jamon ingles con papas');
INSERT INTO Productos (Producto_nom, Categoria_id, Precio, description) VALUES ('H. Royal',1,15,'Hamburguesa de carne, huevo, queso con papas');
INSERT INTO Productos (Producto_nom, Categoria_id, Precio, description) VALUES ('H. Parrillera',1,16,'Hamburguesa de carne, queso, Chorizo parrillero con papas');


INSERT INTO Productos (Producto_nom, Categoria_id, Precio, description) VALUES ('S. Clasica',2,12,'Salchipapa clasica');
INSERT INTO Productos (Producto_nom, Categoria_id, Precio, description) VALUES ('S. Salchiroyal',2,14,'Salchipapa con 2 huevos');
INSERT INTO Productos (Producto_nom, Categoria_id, Precio, description) VALUES ('S. Salchimix',2,16,'Salchipapa con Chorizo');

INSERT INTO Productos (Producto_nom, Categoria_id, Precio, description) VALUES ('6u A. Clasicas',3,15,'6 und. Alitas Clasicas');
INSERT INTO Productos (Producto_nom, Categoria_id, Precio, description) VALUES ('6u A. BBQ',3,16.5,'6 und. Alitas BBQ');
INSERT INTO Productos (Producto_nom, Categoria_id, Precio, description) VALUES ('6u A. Picantes',3,16.5,'6 und. Alitas Picantes');
INSERT INTO Productos (Producto_nom, Categoria_id, Precio, description) VALUES ('6u A. Orientales',3,16.5,'6 und. Alitas Orientales');
INSERT INTO Productos (Producto_nom, Categoria_id, Precio, description) VALUES ('6u A. Acevichadas',3,16.5,'6 und. Alitas Acevichadas');
INSERT INTO Productos (Producto_nom, Categoria_id, Precio, description) VALUES ('6u A. Peruchas',3,16.5,'6 und. Alitas Peruchas');

INSERT INTO Productos (Producto_nom, Categoria_id, Precio, description) VALUES ('Anticuchos',4,13,'2 brochetas de anticuchos');
INSERT INTO Productos (Producto_nom, Categoria_id, Precio, description) VALUES ('Teque�os',4,10,'6 und. teque�os');

INSERT INTO Productos (Producto_nom, Categoria_id, Precio, description) VALUES ('Torta de chocolate',5,6,'Porcion de torta de chocolate');
INSERT INTO Productos (Producto_nom, Categoria_id, Precio, description) VALUES ('Cake pops',5,8,'6 cake pops');

INSERT INTO Productos (Producto_nom, Categoria_id, Precio, description) VALUES ('Coca-Cola 500ml',6,5,'Coca-Cola 500ml');
INSERT INTO Productos (Producto_nom, Categoria_id, Precio, description) VALUES ('Inka-Cola 500ml',6,5,'Inka-Cola 500ml');
INSERT INTO Productos (Producto_nom, Categoria_id, Precio, description) VALUES ('Coca-Cola 1.5L',6,12,'Coca-Cola 1.5L');
INSERT INTO Productos (Producto_nom, Categoria_id, Precio, description) VALUES ('Inka-Cola 1.5L',6,12,'Inka-Cola 1.5L');
INSERT INTO Productos (Producto_nom, Categoria_id, Precio, description) VALUES ('Chicha Morada 1L',6,15,'Chicha Morada 1L');
INSERT INTO Productos (Producto_nom, Categoria_id, Precio, description) VALUES ('Limonada Frozen 1L',6,15,'Limonada Frozen 1L');

INSERT INTO Productos (Producto_nom, Categoria_id, Precio, description) VALUES ('Corona 355ml',7,7,'Corona 355ml');
INSERT INTO Productos (Producto_nom, Categoria_id, Precio, description) VALUES ('Pilsen lata 473ml',7,7,'Pilsen lata 473ml');
INSERT INTO Productos (Producto_nom, Categoria_id, Precio, description) VALUES ('Heineken 330ml',7,6.50,'Heineken 330ml');
INSERT INTO Productos (Producto_nom, Categoria_id, Precio, description) VALUES ('Cusque�a 310ml',7,5.50,'Cusque�a 310ml');
INSERT INTO Productos (Producto_nom, Categoria_id, Precio, description) VALUES ('Cristal 330ml',7,5.50,'Cristal 330ml');

INSERT INTO Productos (Producto_nom, Categoria_id, Precio, description) VALUES ('Cuba Libre',8,12,'Cuba Libre');
INSERT INTO Productos (Producto_nom, Categoria_id, Precio, description) VALUES ('Daikiri de Fresa',8,14,'Daikiri de Fresa');
INSERT INTO Productos (Producto_nom, Categoria_id, Precio, description) VALUES ('Macchu Picchu',8,13.50,'Macchu Picchu');
INSERT INTO Productos (Producto_nom, Categoria_id, Precio, description) VALUES ('Pisco Sour',8,13,'Pisco Sour');
INSERT INTO Productos (Producto_nom, Categoria_id, Precio, description) VALUES ('Pina Colada',8,14,'Pina Colada');
INSERT INTO Productos (Producto_nom, Categoria_id, Precio, description) VALUES ('Sex on the beach',8,15,'Sex on the beach');
INSERT INTO Productos (Producto_nom, Categoria_id, Precio, description) VALUES ('Mojito',8,13,'Mojito');
INSERT INTO Productos (Producto_nom, Categoria_id, Precio, description) VALUES ('Laguna Azul',8,14,'Laguna Azul');
INSERT INTO Productos (Producto_nom, Categoria_id, Precio, description) VALUES ('Chill out',8,14,'Chill out');

INSERT INTO Productos (Producto_nom, Categoria_id, Precio, description) VALUES ('Ron+Cocacola',9,60,'Ron 750ml + Cocacola 1.5L + Hielos');
INSERT INTO Productos (Producto_nom, Categoria_id, Precio, description) VALUES ('Vodka+Evervess',9,60,'Vodka 750ml + Evervess 1.5L + Hielos');
INSERT INTO Productos (Producto_nom, Categoria_id, Precio, description) VALUES ('Pisco+Evervess',9,60,'Pisco 750ml + Evervess 1.5L + Hielos');
INSERT INTO Productos (Producto_nom, Categoria_id, Precio, description) VALUES ('Six pack Corona',9,24,'Six pack Corona');
INSERT INTO Productos (Producto_nom, Categoria_id, Precio, description) VALUES ('Six pack Pilsen',9,28,'Six pack Pilsen');
INSERT INTO Productos (Producto_nom, Categoria_id, Precio, description) VALUES ('Six pack Heineken',9,22,'Six pack Heineken');
INSERT INTO Productos (Producto_nom, Categoria_id, Precio, description) VALUES ('Six pack Cusquena',9,24,'Six pack Cusquena');
INSERT INTO Productos (Producto_nom, Categoria_id, Precio, description) VALUES ('Six pack Cristal',9,24,'Six pack Cristal');


INSERT INTO Productos (Producto_nom, Categoria_id, Precio, description) VALUES ('Malboro',10,2.50,'1 und. ');
INSERT INTO Productos (Producto_nom, Categoria_id, Precio, description) VALUES ('Lucky',10,2,'1 und.');
INSERT INTO Productos (Producto_nom, Categoria_id, Precio, description) VALUES ('Hamilton',10,1.5, '1 und.');

-- Insertar Usuarios (Ejemplo)
INSERT INTO Usuarios (Username, Contrasena, Rol, Nombre) VALUES ('admin', 'admin123', 'Gerente', 'Eduardo condorcanqui');
INSERT INTO Usuarios (Username, Contrasena, Rol, Nombre) VALUES ('mozo1', 'mozo123', 'Mozo', 'Yesenia Pocomucha');


-- Insertar Pedidos (Ejemplo)
INSERT INTO Ordenes  (Cliente_id , Orden_fecha , Total , Estado ) VALUES ('60805652', SYSTIMESTAMP, 20.00, 'Completados');
INSERT INTO Ordenes  (Cliente_id , Orden_fecha , Total , Estado ) VALUES ('03843621', SYSTIMESTAMP, 30.00, 'Completados');

select * from usuarios;

-- Insertar Detalles del Pedido (Ejemplo)
INSERT INTO Orden_Detalle  (Orden_id , Producto_id , Cantidad , Precio ) VALUES (1, 2, 1, 10.00);
INSERT INTO Orden_Detalle  (Orden_id , Producto_id , Cantidad , Precio ) VALUES (1, 16, 1, 10.00);
INSERT INTO Orden_Detalle  (Orden_id , Producto_id , Cantidad , Precio ) VALUES (2, 2, 1, 10.00);
INSERT INTO Orden_Detalle  (Orden_id , Producto_id , Cantidad , Precio ) VALUES (2, 15, 1, 13.00);
INSERT INTO Orden_Detalle  (Orden_id , Producto_id , Cantidad , Precio ) VALUES (2, 27, 1, 7.00);

-- Insertar Facturas (Ejemplo)
INSERT INTO Factura  (Orden_id , Factura_fecha , Monto ) VALUES (1, SYSTIMESTAMP, 20.00);
INSERT INTO Factura  (Orden_id , Factura_fecha , Monto ) VALUES (2, SYSTIMESTAMP, 30.00);


INSERT into Inv_NoFijo (Producto_id , Stock_Disponible) values (1,'S'); 
INSERT into Inv_NoFijo (Producto_id , Stock_Disponible) values (2,'S');
INSERT into Inv_NoFijo (Producto_id , Stock_Disponible) values (3,'S');
INSERT into Inv_NoFijo (Producto_id , Stock_Disponible) values (4,'S');
INSERT into Inv_NoFijo (Producto_id , Stock_Disponible) values (5,'S');
INSERT into Inv_NoFijo (Producto_id , Stock_Disponible) values (6,'S');
INSERT into Inv_NoFijo (Producto_id , Stock_Disponible) values (7,'S');
INSERT into Inv_NoFijo (Producto_id , Stock_Disponible) values (8,'S');
INSERT into Inv_NoFijo (Producto_id , Stock_Disponible) values (9,'S');
INSERT into Inv_NoFijo (Producto_id , Stock_Disponible) values (10,'S');
INSERT into Inv_NoFijo (Producto_id , Stock_Disponible) values (11,'S');
INSERT into Inv_NoFijo (Producto_id , Stock_Disponible) values (12,'S');
INSERT into Inv_NoFijo (Producto_id , Stock_Disponible) values (13,'S');
INSERT into Inv_NoFijo (Producto_id , Stock_Disponible) values (14,'S');
INSERT into Inv_NoFijo (Producto_id , Stock_Disponible) values (15,'S');
INSERT into Inv_NoFijo (Producto_id , Stock_Disponible) values (16,'S');
INSERT into Inv_NoFijo (Producto_id , Stock_Disponible) values (17,'S');
INSERT into Inv_NoFijo (Producto_id , Stock_Disponible) values (18,'S');
INSERT into Inv_NoFijo (Producto_id , Stock_Disponible) values (19,'S');
INSERT into Inv_NoFijo (Producto_id , Stock_Disponible) values (26,'S');
INSERT into Inv_NoFijo (Producto_id , Stock_Disponible) values (17,'S');

INSERT into Inv_NoFijo (Producto_id , Stock_Disponible) values (33,'S');--tragos
INSERT into Inv_NoFijo (Producto_id , Stock_Disponible) values (34,'S');
INSERT into Inv_NoFijo (Producto_id , Stock_Disponible) values (35,'S');
INSERT into Inv_NoFijo (Producto_id , Stock_Disponible) values (36,'S');
INSERT into Inv_NoFijo (Producto_id , Stock_Disponible) values (37,'S');
INSERT into Inv_NoFijo (Producto_id , Stock_Disponible) values (38,'S');
INSERT into Inv_NoFijo (Producto_id , Stock_Disponible) values (39,'S');
INSERT into Inv_NoFijo (Producto_id , Stock_Disponible) values (40,'S');
INSERT into Inv_NoFijo (Producto_id , Stock_Disponible) values (41,'S');


INSERT into Inv_Fijo (Producto_id , Stock_Disponible) values (20,12); --torta
INSERT into Inv_Fijo (Producto_id , Stock_Disponible) values (21,32); -- cakepop
INSERT into Inv_Fijo (Producto_id , Stock_Disponible) values (22,48); --gaseosas
INSERT into Inv_Fijo (Producto_id , Stock_Disponible) values (23,48); 
INSERT into Inv_Fijo (Producto_id , Stock_Disponible) values (24,24); --gaseosas 1.5l
INSERT into Inv_Fijo (Producto_id , Stock_Disponible) values (25,24); 
INSERT into Inv_Fijo (Producto_id , Stock_Disponible) values (28,48); --cervezas
INSERT into Inv_Fijo (Producto_id , Stock_Disponible) values (29,48);
INSERT into Inv_Fijo (Producto_id , Stock_Disponible) values (30,48);
INSERT into Inv_Fijo (Producto_id , Stock_Disponible) values (31,48);
INSERT into Inv_Fijo (Producto_id , Stock_Disponible) values (32,48); --cristal
INSERT into Inv_Fijo (Producto_id , Stock_Disponible) values (42,8);--pack de bebidas
INSERT into Inv_Fijo (Producto_id , Stock_Disponible) values (43,8);
INSERT into Inv_Fijo (Producto_id , Stock_Disponible) values (44,8);
INSERT into Inv_Fijo (Producto_id , Stock_Disponible) values (45,8);-- six packs cervezas
INSERT into Inv_Fijo (Producto_id , Stock_Disponible) values (46,8);
INSERT into Inv_Fijo (Producto_id , Stock_Disponible) values (47,8);
INSERT into Inv_Fijo (Producto_id , Stock_Disponible) values (48,8);
INSERT into Inv_Fijo (Producto_id , Stock_Disponible) values (49,8);
INSERT into Inv_Fijo (Producto_id , Stock_Disponible) values (50,40);-- Cigarros
INSERT into Inv_Fijo (Producto_id , Stock_Disponible) values (51,40);
INSERT into Inv_Fijo (Producto_id , Stock_Disponible) values (52,40);

select * from inv_nofijo;
select * from productos;


SELECT i.INV_NOFIJO_ID, p.PRODUCTO_NOM,  i.STOCK_DISPONIBLE 
FROM INV_NOFIJO i JOIN PRODUCTOS p 
ON i.PRODUCTO_ID = p.PRODUCTO_ID;

SELECT * INV_NOFIJO
SELECT i.INV_NOFIJO_ID, p.PRODUCTO_NOM,  p.PRECIO, i.STOCK_DISPONIBLE 
FROM INV_NOFIJO i JOIN PRODUCTOS p 
ON i.PRODUCTO_ID = p.PRODUCTO_ID;

UPDATE Inv_NoFijo SET Stock_Disponible = 'N' WHERE Producto_id = 2 AND Stock_Disponible = 'S';






