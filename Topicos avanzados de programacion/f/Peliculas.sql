DROP TABLE Peliculas;

CREATE TABLE Direcciones
(
	IDPeliculas INT NOT NULL GENERATED ALWAYS AS IDENTITY,
	Titulo VARCHAR (15) NOT NULL,
	Genero VARCHAR (30) NOT NULL,
	Directores VARCHAR (30) NOT NULL,
	Escritores VARCHAR (15) NOT NULL,
	Duracion VARCHAR (15) NOT NULL,
	Activo BOOLEAN NOT NULL
	
);
INSERT INTO Direcciones (Titulo,Genero,Directores,Escritores,Duracion,Activo)
	VALUES ('Mike','Green','demo1@deitel.com','555-5555','cinco',true),
	('Mary','Brown','demo2@deitel.com','555-1234','cinco',true);