drop database Tienda_juegos;

Create database Tienda_juegos;
use Tienda_juegos;

-- Tabla : Categorias
DROP TABLE IF EXISTS Categorias;
CREATE TABLE Categorias(
    IdCategoria CHAR(6) NOT NULL,
    Descripcion VARCHAR(50) NOT NULL,
    PRIMARY KEY (IdCategoria)
);

-- Insertar filas de la categoria
INSERT INTO Categorias VALUES('CAT001','Accion');
INSERT INTO Categorias VALUES('CAT002','Aventura');
INSERT INTO Categorias VALUES('CAT003','Casual');
INSERT INTO Categorias VALUES('CAT004','Estrategia');
INSERT INTO Categorias VALUES('CAT005','Rol');


-- Tabla : Juegos
DROP TABLE IF EXISTS Juegos;
CREATE TABLE Juegos(
    IdJuegos int NOT NULL auto_increment,
    IdCategoria CHAR(6) NOT NULL,
    Descripcion VARCHAR(50) NOT NULL,
    Precio DECIMAL(10,2) NOT NULL,
    Imagen VARCHAR(50) NOT NULL,
    PRIMARY KEY(IdJuegos),
    FOREIGN KEY(IdCategoria) REFERENCES Categorias(IdCategoria),
    CHECK(Precio > 0)
);

-- Insertar filas en la tabla Juegos

-- Accion --
INSERT INTO Juegos(IdCategoria, Descripcion, Precio, Imagen) VALUES('CAT001','ARC Raiders',111.90,'00001.jpg');
INSERT INTO Juegos(IdCategoria, Descripcion, Precio, Imagen) VALUES('CAT001','Clair Obscur Expedition 33',99.90,'00002.jpg');
INSERT INTO Juegos(IdCategoria, Descripcion, Precio, Imagen) VALUES('CAT001','HELLDIVERS 2',119.90,'00003.jpg');
INSERT INTO Juegos(IdCategoria, Descripcion, Precio, Imagen) VALUES('CAT001','Alien Isolation',39.90,'00004.jpg');
INSERT INTO Juegos(IdCategoria, Descripcion, Precio, Imagen) VALUES('CAT001','Hollow Knight Silksong',43.00,'00005.jpg');
INSERT INTO Juegos(IdCategoria, Descripcion, Precio, Imagen) VALUES('CAT001','Dragon Ball Xenoverse 2',69.90,'00006.jpg');
INSERT INTO Juegos(IdCategoria, Descripcion, Precio, Imagen) VALUES('CAT001','Stellar Blade',139.90,'00007.jpg');
INSERT INTO Juegos(IdCategoria, Descripcion, Precio, Imagen) VALUES('CAT001','GTA',49.90,'00008.jpg');
INSERT INTO Juegos(IdCategoria, Descripcion, Precio, Imagen) VALUES('CAT001','ELDEN RING NIGHTREIGN',149.90,'00009.jpg');
INSERT INTO Juegos(IdCategoria, Descripcion, Precio, Imagen) VALUES('CAT001','Resident Evil 4',45.00,'00010.jpg');


-- Aventura --
INSERT INTO Juegos(IdCategoria, Descripcion, Precio, Imagen) VALUES('CAT002','Subnautica',89.90,'00011.jpg');
INSERT INTO Juegos(IdCategoria, Descripcion, Precio, Imagen) VALUES('CAT002','Grounded 2',129.90,'00012.jpg');
INSERT INTO Juegos(IdCategoria, Descripcion, Precio, Imagen) VALUES('CAT002','Far Cry 6',159.90,'00013.jpg');
INSERT INTO Juegos(IdCategoria, Descripcion, Precio, Imagen) VALUES('CAT002','Black Myth Wukong',259.90,'00014.jpg');
INSERT INTO Juegos(IdCategoria, Descripcion, Precio, Imagen) VALUES('CAT002','Raft',49.90,'00015.jpg');
INSERT INTO Juegos(IdCategoria, Descripcion, Precio, Imagen) VALUES('CAT002','Lies of P',179.90,'00016.jpg');
INSERT INTO Juegos(IdCategoria, Descripcion, Precio, Imagen) VALUES('CAT002','Kingdom Heart',199.90,'00017.jpg');
INSERT INTO Juegos(IdCategoria, Descripcion, Precio, Imagen) VALUES('CAT002','Minecraft',89.90,'00018.jpg');
INSERT INTO Juegos(IdCategoria, Descripcion, Precio, Imagen) VALUES('CAT002','Stray',129.90,'00019.jpg');
INSERT INTO Juegos(IdCategoria, Descripcion, Precio, Imagen) VALUES('CAT002','BioShock The Collection',89.90,'00020.jpg');


-- Casual --
INSERT INTO Juegos(IdCategoria, Descripcion, Precio, Imagen) VALUES('CAT003','Forager',14.90,'00021.jpg');
INSERT INTO Juegos(IdCategoria, Descripcion, Precio, Imagen) VALUES('CAT003','Coral Island',29.90,'00022.jpg');
INSERT INTO Juegos(IdCategoria, Descripcion, Precio, Imagen) VALUES('CAT003','Unpacking',19.90,'00023.jpg');
INSERT INTO Juegos(IdCategoria, Descripcion, Precio, Imagen) VALUES('CAT003','Stardew Valley',14.90,'00024.jpg');
INSERT INTO Juegos(IdCategoria, Descripcion, Precio, Imagen) VALUES('CAT003','The Sims 4',29.90,'00025.jpg');
INSERT INTO Juegos(IdCategoria, Descripcion, Precio, Imagen) VALUES('CAT003','Bloons TD 6',12.90,'00026.jpg');
INSERT INTO Juegos(IdCategoria, Descripcion, Precio, Imagen) VALUES('CAT003','Powerwash Simulator',19.90,'00027.jpg');
INSERT INTO Juegos(IdCategoria, Descripcion, Precio, Imagen) VALUES('CAT003','Vampire Survivors',9.90,'00028.jpg');
INSERT INTO Juegos(IdCategoria, Descripcion, Precio, Imagen) VALUES('CAT003','Tiny Glade',12.90,'00029.jpg');
INSERT INTO Juegos(IdCategoria, Descripcion, Precio, Imagen) VALUES('CAT003','Fantasy Life i',39.90,'00030.jpg');


-- Estrategia --
INSERT INTO Juegos(IdCategoria, Descripcion, Precio, Imagen) VALUES('CAT004','Age of Empires IV',119.90,'00031.jpg');
INSERT INTO Juegos(IdCategoria, Descripcion, Precio, Imagen) VALUES('CAT004','Cities Skylines II',159.90,'00032.jpg');
INSERT INTO Juegos(IdCategoria, Descripcion, Precio, Imagen) VALUES('CAT004','Balatro',24.90,'00033.jpg');
INSERT INTO Juegos(IdCategoria, Descripcion, Precio, Imagen) VALUES('CAT004','Civilization VII',199.90,'00034.jpg');
INSERT INTO Juegos(IdCategoria, Descripcion, Precio, Imagen) VALUES('CAT004','Anno 117 Pax Romana',219.90,'00035.jpg');
INSERT INTO Juegos(IdCategoria, Descripcion, Precio, Imagen) VALUES('CAT004','Metaphor ReFantazio',259.90,'00036.jpg');
INSERT INTO Juegos(IdCategoria, Descripcion, Precio, Imagen) VALUES('CAT004','Shin Megami Tensei V Vengeance',179.90,'00037.jpg');
INSERT INTO Juegos(IdCategoria, Descripcion, Precio, Imagen) VALUES('CAT004','Plague Inc Evolved',19.90,'00038.jpg');
INSERT INTO Juegos(IdCategoria, Descripcion, Precio, Imagen) VALUES('CAT004','Command and Conquer Remastered',49.90,'00039.jpg');
INSERT INTO Juegos(IdCategoria, Descripcion, Precio, Imagen) VALUES('CAT004','Sword of Convallaria',39.90,'00040.jpg');


-- Rol --
INSERT INTO Juegos(IdCategoria, Descripcion, Precio, Imagen) VALUES('CAT005','Age of Wonders 4',159.90,'00041.jpg');
INSERT INTO Juegos(IdCategoria, Descripcion, Precio, Imagen) VALUES('CAT005','Monster Hunter Rise',139.90,'00042.jpg');
INSERT INTO Juegos(IdCategoria, Descripcion, Precio, Imagen) VALUES('CAT005','Final Fantasy XIV',79.90,'00043.jpg');
INSERT INTO Juegos(IdCategoria, Descripcion, Precio, Imagen) VALUES('CAT005','Yakuza Like a Dragon',129.90,'00044.jpg');
INSERT INTO Juegos(IdCategoria, Descripcion, Precio, Imagen) VALUES('CAT005','Hogwarts Legacy',249.90,'00045.jpg');
INSERT INTO Juegos(IdCategoria, Descripcion, Precio, Imagen) VALUES('CAT005','Diablo IV',289.90,'00046.jpg');
INSERT INTO Juegos(IdCategoria, Descripcion, Precio, Imagen) VALUES('CAT005','Code Vein II',89.90,'00047.jpg');
INSERT INTO Juegos(IdCategoria, Descripcion, Precio, Imagen) VALUES('CAT005','Atelier Ryza 3',99.90,'00048.jpg');
INSERT INTO Juegos(IdCategoria, Descripcion, Precio, Imagen) VALUES('CAT005','Baldurs Gate 3',129.90,'00049.jpg');
INSERT INTO Juegos(IdCategoria, Descripcion, Precio, Imagen) VALUES('CAT005','Darkest Dungeon',29.90,'00050.jpg');

select * from Juegos;

-- Tabla : Clientes
DROP TABLE IF EXISTS Clientes;
CREATE TABLE Clientes(
    IdCliente CHAR(8) NOT NULL,
    Apellidos VARCHAR(50) NOT NULL,
    Nombres VARCHAR(50) NOT NULL,
    DNI VARCHAR(12) NOT NULL,
    Direccion VARCHAR(50) NOT NULL,
    Telefono VARCHAR(20) NOT NULL,
    FechaNacimiento DATE NOT NULL,
    Sexo CHAR(1) NOT NULL,
    Correo VARCHAR(50) NOT NULL,
    Password VARCHAR(255) NOT NULL,
    Estado CHAR(1) NOT NULL,
    Rol VARCHAR(20) NOT NULL,
    PRIMARY KEY(IdCliente),
    CHECK(Sexo IN ('M','F')),
    CHECK(Estado IN ('0','1'))
);

-- Insertar filas en la tabla Clientes
INSERT INTO Clientes VALUES('78451236','Gonzales','Marco Antonio','45258695','Av. Los Olivos 123','995587456','1998-05-14','M','marco.g@gmail.com','pass123','1', 'CLIENTE');
INSERT INTO Clientes VALUES('81549273','Rojas','Ana Lucia','12453425','Jr. Lima 450','945781020','2000-11-02','F','ana.rojas@gmail.com','ana2000','1', 'CLIENTE');
INSERT INTO Clientes VALUES('72915487','Fernandez','Luis Alberto','78563225','Calle Sol 233','930450760','1995-03-22','M','luisf95@gmail.com','luisA95','1', 'CLIENTE');
INSERT INTO Clientes VALUES('80451299','Torres','María Fernanda','65763467','Av. Arequipa 670','902546803','1999-07-28','F','mfernanda@gmail.com','mf1234','1', 'CLIENTE');
INSERT INTO Clientes VALUES('72134588','Ramirez','Carlos Daniel','69695847','Jr. Progreso 120','953697221','2001-09-10','M','c.ramirez@gmail.com','ram123','1', 'CLIENTE');
INSERT INTO Clientes VALUES('79541230','Castillo','Valeria Sofia','20526897','Calle Luna 876','900002545','1997-02-05','F','val.castillo@gmail.com','vs777','1', 'CLIENTE');
INSERT INTO Clientes VALUES('75349812','Mendoza','Jorge Andres','32547811','Av. Grau 540','954255685','1996-10-18','M','jorge.m@gmail.com','jm96','1', 'CLIENTE');
INSERT INTO Clientes VALUES('81234590','Paredes','Diana Patricia','45662345','Jr. Amazonas 321','912340987','2002-08-03','F','diana.p@gmail.com','dpat02','1', 'CLIENTE');
INSERT INTO Clientes VALUES('70234891','Salazar','Kevin Joel','12875554','Calle Central 900','95467090','1998-12-30','M','kevin.s@gmail.com','ks123','1', 'CLIENTE');
INSERT INTO Clientes VALUES('74891230','Hidalgo','Monica Rene','82934419','Av. Colonial 450','974534423','1994-06-15','F','monica.h@gmail.com','mh94','1', 'CLIENTE');
INSERT INTO Clientes VALUES('74891120','Sanchez','Renato','825454519','Av. WAZAAA','9745454823','1998-07-05','F','sanchez@gmail.com','mas78','0', 'CLIENTE');
INSERT INTO Clientes VALUES('80463819','Istrador','Admin','567894235','Av. Admin','956894369','2026-01-01','F','admin@gmail.com','admin','1', 'ADMIN');

SELECT * FROM Clientes;

-- Tabla : Ventas
DROP TABLE IF EXISTS Ventas;
CREATE TABLE Ventas (
    IdVenta CHAR(10) NOT NULL,
    IdCliente CHAR(8) NOT NULL,
    FechaVenta DATE NOT NULL,
    MontoTotal DECIMAL(10 , 2 ) NOT NULL,
    Estado CHAR(1) NOT NULL,
    PRIMARY KEY (IdVenta),
    FOREIGN KEY (IdCliente) REFERENCES Clientes (IdCliente),
    CHECK (MontoTotal > 0),
    CHECK (Estado IN ('0' , '1'))
);

-- Tabla : Detalles
DROP TABLE IF EXISTS Detalle;
CREATE TABLE Detalle(
    IdVenta CHAR(10) NOT NULL,
    IdJuegos int NOT NULL,
    Cantidad INT NOT NULL,
    Precio DECIMAL(10,2) NOT NULL,
    Estado CHAR(1) NOT NULL,
    PRIMARY KEY(IdVenta, IdJuegos),
    FOREIGN KEY(IdVenta) REFERENCES Ventas(IdVenta),
    FOREIGN KEY(IdJuegos) REFERENCES Juegos(IdJuegos),
    CHECK(Cantidad > 0),
    CHECK(Precio > 0),
    CHECK(Estado IN ('0','1'))
);

-- Tabla : Mensajes
DROP TABLE IF EXISTS Mensajes;
CREATE TABLE Mensajes (
    IdMensaje INT NOT NULL AUTO_INCREMENT, 
    IdCliente CHAR(8) NOT NULL,
    TextoMensaje VARCHAR(200) NOT NULL,
    FechaEnvio DATETIME NOT NULL,
    Estado CHAR(1) NOT NULL,
    PRIMARY KEY (IdMensaje),
    FOREIGN KEY (IdCliente) REFERENCES Clientes (IdCliente)
);

INSERT INTO Mensajes (IdCliente, TextoMensaje, FechaEnvio, Estado) VALUES
('78451236', 'WAZAAAAAAAAAAAAAAA', '2026-06-15 10:30:00', '1'),
('81549273', 'Mi pedido llegó en perfectas condiciones', '2026-06-16 14:20:00', '1'),
('72915487', '¿Tienen disponibilidad del juego "God of War"?', '2026-06-17 09:15:00', '1'),
('80451299', 'Quiero saber si hacen envíos a provincias', '2026-06-18 11:45:00', '1'),
('72134588', 'El producto no coincide con la descripción', '2026-06-19 16:30:00', '1'),
('79541230', 'Me encantó la atención al cliente', '2026-06-20 08:00:00', '1'),
('75349812', '¿Puedo cambiar la fecha de entrega?', '2026-06-20 12:10:00', '1'),
('81234590', 'Ya realicé el pago, ¿cuándo me confirman?', '2026-06-21 09:30:00', '1'),
('70234891', 'El juego llegó dañado, necesito reemplazo', '2026-06-21 18:20:00', '1'),
('74891230', 'Gracias por la rápida respuesta', '2026-06-22 10:00:00', '1');

-- Creación de vistas para reporte
DROP VIEW IF EXISTS v_header_boleta;
CREATE VIEW v_header_boleta AS
SELECT
    v.IdVenta,
    CONCAT('B001 - ', LPAD(v.IdVenta, 6, '0')) AS NumeroBoleta,
    CONCAT(c.Nombres,' ',c.Apellidos) AS NombreCompletoCliente,
    DATE_FORMAT(v.FechaVenta, '%d/%m/%Y %h:%i:%s %p') AS FechaTexto,
    v.MontoTotal
FROM Ventas v
	INNER JOIN Clientes c ON v.IdCliente = c.IdCliente;

DROP VIEW IF EXISTS v_detail_boleta;
CREATE VIEW v_detail_boleta AS
SELECT
    d.IdVenta AS IdVenta,
    j.IdJuegos AS IdJuegos,
    j.Descripcion AS Descripcion,
    d.Cantidad AS Cantidad,
    d.Precio AS Precio,
    d.Cantidad * d.Precio AS SubTotal
FROM Detalle d
	INNER JOIN Juegos j ON d.IdJuegos = j.IdJuegos;