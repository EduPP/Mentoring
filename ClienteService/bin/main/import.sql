INSERT INTO clientes (name, username, password ,fecha_inicio, fecha_fin , estado) VALUES('Juan', 'jgonzales', '$2a$10$ve1jn2I9fnNvnRSmtPFaJOrhE8BvYe5AyicQK.Nlwy0QyJbP.Xrmi',PARSEDATETIME('19-05-2011', 'dd-MM-yyyy'), PARSEDATETIME('19-05-2020', 'dd-MM-yyyy'), 'A');
INSERT INTO clientes (name, username, password ,fecha_inicio, fecha_fin , estado) VALUES('Fredy', 'fsuarez', '$2a$10$RAakBOsQGBdqyM.7PvOWi.Q8Dg5umrBFRtoKo0xd5XyUbFws1.yGu',PARSEDATETIME('21-05-2010', 'dd-MM-yyyy'), PARSEDATETIME('21-05-2021', 'dd-MM-yyyy'), 'A');
INSERT INTO clientes (name, username, password ,fecha_inicio, fecha_fin , estado) VALUES('Carlos', 'cporlles', '$2a$10$RAakBOsQGBdqyM.7PvOWi.Q8Dg5umrBFRtoKo0xd5XyUbFws1.yGu',PARSEDATETIME('15-01-2010', 'dd-MM-yyyy'), PARSEDATETIME('15-01-2019', 'dd-MM-yyyy'), 'I');
INSERT INTO clientes (name, username, password ,fecha_inicio, fecha_fin , estado) VALUES('Marlon', 'mquispe', '$2a$10$RAakBOsQGBdqyM.7PvOWi.Q8Dg5umrBFRtoKo0xd5XyUbFws1.yGu',PARSEDATETIME('11-03-2011', 'dd-MM-yyyy'), PARSEDATETIME('11-03-2020', 'dd-MM-yyyy'), 'A');
INSERT INTO clientes (name, username, password ,fecha_inicio, fecha_fin , estado) VALUES('Daniela', 'djuarez', '$2a$10$3dndsNpqKuaFIyPGSKgEiuDFa2GEKesD8jGX70sUR6t7OqlChHtvS',PARSEDATETIME('12-04-2010', 'dd-MM-yyyy'), PARSEDATETIME('12-04-2020', 'dd-MM-yyyy'), 'A');
INSERT INTO clientes (name, username, password ,fecha_inicio, fecha_fin , estado) VALUES('Julian','jjulian', '$2a$10$3dndsNpqKuaFIyPGSKgEiuDFa2GEKesD8jGX70sUR6t7OqlChHtvS', PARSEDATETIME('22-01-2011', 'dd-MM-yyyy'), PARSEDATETIME('12-01-2019', 'dd-MM-yyyy'), 'I');
INSERT INTO clientes (name, username, password ,fecha_inicio, fecha_fin , estado) VALUES('Steve', 'stevegreen', '$2a$10$RAakBOsQGBdqyM.7PvOWi.Q8Dg5umrBFRtoKo0xd5XyUbFws1.yGu',PARSEDATETIME('13-07-2010', 'dd-MM-yyyy'), PARSEDATETIME('11-03-2020', 'dd-MM-yyyy'), 'I');
INSERT INTO clientes (name, username, password ,fecha_inicio, fecha_fin , estado) VALUES('Rocio', 'renriquez', '$2a$10$RAakBOsQGBdqyM.7PvOWi.Q8Dg5umrBFRtoKo0xd5XyUbFws1.yGu',PARSEDATETIME('05-02-2011', 'dd-MM-yyyy'), PARSEDATETIME('12-04-2020', 'dd-MM-yyyy'), 'A');

INSERT INTO roles (nombre) VALUES ('ROLE_USER');
INSERT INTO roles (nombre) VALUES ('ROLE_ADMIN');

INSERT INTO clientes_roles (cliente_id, role_id) VALUES (1, 1);
INSERT INTO clientes_roles (cliente_id, role_id) VALUES (1, 2);
INSERT INTO clientes_roles (cliente_id, role_id) VALUES (2, 1);
INSERT INTO clientes_roles (cliente_id, role_id) VALUES (2, 2);
INSERT INTO clientes_roles (cliente_id, role_id) VALUES (3, 1);
INSERT INTO clientes_roles (cliente_id, role_id) VALUES (4, 1);
INSERT INTO clientes_roles (cliente_id, role_id) VALUES (5, 1);
INSERT INTO clientes_roles (cliente_id, role_id) VALUES (6, 1);
INSERT INTO clientes_roles (cliente_id, role_id) VALUES (6, 2);
INSERT INTO clientes_roles (cliente_id, role_id) VALUES (7, 1);
INSERT INTO clientes_roles (cliente_id, role_id) VALUES (8, 1);