CREATE DATABASE BD_HospitalSC;
--DROP DATABASE BD_HospitalSC;
USE BD_HospitalSC;

CREATE TABLE tipoUsuario(
tipoUsuario_id INT AUTO_INCREMENT,
tipoUsuario_nombre VARCHAR(50),
PRIMARY KEY(tipoUsuario_id)
);

INSERT INTO tipoUsuario VALUES(NULL, 'Administrador');
INSERT INTO tipoUsuario VALUES(NULL, 'Secretario');
INSERT INTO tipoUsuario VALUES(NULL, 'Doctor');
INSERT INTO tipoUsuario VALUES(NULL, 'Enfermera');

CREATE TABLE tipoTurno(
tipoTurno_id INT AUTO_INCREMENT,
tipoTurno_nombre VARCHAR(50),
tipoTurno_HoraEntrada VARCHAR(50),
tipoTurno_HoraSalida VARCHAR(50),
PRIMARY KEY(tipoTurno_id)
);

INSERT INTO tipoTurno VALUES(NULL, 'Mañana', '7Hrs', '15Hrs');
INSERT INTO tipoTurno VALUES(NULL, 'Tarde', '15Hrs', '23Hrs');
INSERT INTO tipoTurno VALUES(NULL, 'Noche', '23Hrs', '7Hrs');
INSERT INTO tipoTurno VALUES(NULL, 'Admin', 'Admin', 'Admin');

CREATE TABLE usuario(
usuario_id INT AUTO_INCREMENT,
usuario_rut VARCHAR(100),
usuario_nombre VARCHAR(100),
usuario_apellidos VARCHAR(100),
usuario_fechaNaciminero DATE,
usuario_email VARCHAR(100),
usuario_clave BLOB,
usuario_idTipoUsuario INT,
usuario_idTipoTurno INT,
PRIMARY KEY(usuario_id),
FOREIGN KEY(usuario_idTipoUsuario) REFERENCES tipoUsuario(tipoUsuario_id),
FOREIGN KEY(usuario_idTipoTurno) REFERENCES tipoTurno(tipoTurno_id)
);

INSERT INTO usuario VALUES(NULL,
'19.220.262-0', 
'Luis',
'Martinez Gonzalez',
'1995-11-14',
'luis_martinez08@hotmail.es',
AES_ENCRYPT('admin',666),
1,
4);

INSERT INTO usuario VALUES(NULL,
'22-2', 
'Doctor',
'Doctor',
'1995-11-14',
'luis_martinez08@hotmail.es',
AES_ENCRYPT('doc123',666),
3,
2);

CREATE TABLE paciente(
paciente_id INT AUTO_INCREMENT,
paciente_rut VARCHAR(50),
paciente_nombre VARCHAR(50),
paciente_apellido VARCHAR(100),
paciente_fechaNacimiento DATE,
paciente_direccion VARCHAR(150),
PRIMARY KEY(paciente_id)
);

INSERT INTO paciente VALUES(NULL, '11-1','Javier','Olea','1992-03-01','Rancagua');

CREATE TABLE hospitalizacion(
hospitalizacion_id INT AUTO_INCREMENT,
hospitalizacion_motivo VARCHAR(200),
hospitalizacion_estado VARCHAR(200),
hospitalizacion_diasHospitalizacion INT,
hospitalizacion_fecha DATE,
hospitalizacion_idPaciente INT,
hospitalizacion_idUsuario INT,
PRIMARY KEY(hospitalizacion_id),
FOREIGN KEY(hospitalizacion_idPaciente) REFERENCES paciente(paciente_id),
FOREIGN KEY(hospitalizacion_idUsuario) REFERENCES usuario(usuario_id)
);

INSERT INTO hospitalizacion VALUES(NULL,
'Operacion mano derecha',
'estable pero con dolor',
'5',
'2016-06-10',
'1',
'2');

CREATE TABLE controles(
controles_id INT AUTO_INCREMENT,
controles_descripcion VARCHAR(200),
controles_estado INT,/*1. hospitalizado, 2.Alta enfermera, 3.Alta Doctor*/
controles_fecha DATE,
controles_idHospitalizacion INT,
controles_idUsuario INT,
PRIMARY KEY(controles_id),
FOREIGN KEY(controles_idHospitalizacion) REFERENCES hospitalizacion(hospitalizacion_id),
FOREIGN KEY(controles_idUsuario) REFERENCES usuario(usuario_id)
);

INSERT INTO controles VALUES(NULL,'El paciente va mejorando','1','2016-06-10','1','2');

CREATE TABLE medicamentos(
medicamentos_id INT AUTO_INCREMENT,
medicamentos_medicamento VARCHAR(100),
medicamentos_descripcion VARCHAR(200),
medicamentos_idUsuario INT,
medicamentos_idHospitalizacion INT,
PRIMARY KEY(medicamentos_id),
FOREIGN KEY(medicamentos_idUsuario) REFERENCES usuario(usuario_id),
FOREIGN KEY(medicamentos_idHospitalizacion) REFERENCES hospitalizacion(hospitalizacion_id)
);

INSERT INTO medicamentos VALUES(NULL, 'Paracetamol','uno cada 8 horas','2','1');

CREATE TABLE HospitalizacionUsuarios(
HospitalizacionUsuarios_id INT AUTO_INCREMENT,
HospitalizacionUsuarios_idUsuario INT,
HospitalizacionUsuarios_idHospitalizacion INT,
PRIMARY KEY(HospitalizacionUsuarios_id),
FOREIGN KEY(HospitalizacionUsuarios_idUsuario) REFERENCES usuario(usuario_id),
FOREIGN KEY(HospitalizacionUsuarios_idHospitalizacion) REFERENCES hospitalizacion(hospitalizacion_id)
);

INSERT INTO HospitalizacionUsuarios VALUES(NULL,'2','1');

CREATE TABLE respaldo(
respaldo_id INT AUTO_INCREMENT,
respaldo_fecha VARCHAR(200),
respaldo_hora VARCHAR(200),
respaldo_tipo VARCHAR(200),
PRIMARY KEY(respaldo_id)
);

SELECT * FROM tipoUsuario;
SELECT * FROM tipoTurno;
SELECT * FROM usuario;
SELECT * FROM paciente;

INSERT INTO usuario VALUES(NULL,'1','1','1','1995-11-14','1',AES_ENCRYPT('1',666),1,1);
INSERT INTO usuario VALUES(NULL,
'22-2', 
'Doctor',
'Doctor',
'1995-11-14',
'luis_martinez08@hotmail.es',
AES_ENCRYPT('doc123',666),
3,
2);