
/* Populate tabla  */
INSERT INTO personas (nombre) VALUES ('Camilo Ochoa');

INSERT INTO estados (nombre) VALUES ('activo');
INSERT INTO estados (nombre) VALUES ('dado de baja');
INSERT INTO estados (nombre) VALUES ('en reparación');
INSERT INTO estados (nombre) VALUES ('disponible');
INSERT INTO estados (nombre) VALUES ('asignado');

INSERT INTO ciudades (nombre) VALUES ('Bogotá');
INSERT INTO ciudades (nombre) VALUES ('Cali');
INSERT INTO ciudades (nombre) VALUES ('Medellin');

INSERT INTO areas (nombre, id_ciudad) VALUES ('Area 1', 1);
INSERT INTO areas (nombre, id_ciudad) VALUES ('Area 2', 2);
INSERT INTO areas (nombre, id_ciudad) VALUES ('Area 3', 3);


INSERT INTO activos (numero_interno, ancho, color, descripcion, fecha_baja, fecha_compra, largo, nombre, peso, serial, tipo, valor_compra, id_area, id_estado, id_persona) VALUES ('232432212', '23', 'negro', 'silla', '2021-03-21 14:05:42.000000', '2021-03-21 14:05:44.000000', '20', 'silla', '20', 'ASDSALOW12', 'mueble', '250000', '1', '1', '1');


