DROP TABLE CatalogoPeliculas;

CREATE TABLE CatalogoPeliculas
(
	IDPeliculas INT NOT NULL GENERATED ALWAYS AS IDENTITY,
	Titulo VARCHAR (30) NOT NULL,
	Genero VARCHAR (30) NOT NULL,
	Directores VARCHAR (30) NOT NULL,
	Escritores VARCHAR (30) NOT NULL,
	Duracion VARCHAR (30) NOT NULL,
	Activo BOOLEAN NOT NULL
	
);
INSERT INTO CatalogoPeliculas (Titulo,Genero,Directores,Escritores,Duracion,Activo)
	VALUES ('Iron Man','Accion','Stan Lee','Sara Stark','2.5h',true),
('Jurassic Park','ciencia ficcion','Steven Spielberg','Michael Crichton','127 minutes',true);	