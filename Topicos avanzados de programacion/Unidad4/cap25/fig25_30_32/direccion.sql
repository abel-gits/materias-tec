DROP TABLE Direcciones;

CREATE TABLE Direcciones
(
	IDDireccion INT NOT NULL GENERATED ALWAYS AS IDENTITY,
	PrimerNombre VARCHAR (15) NOT NULL,
	ApellidoPaterno VARCHAR (30) NOT NULL,
	Email VARCHAR (30) NOT NULL,
	NumeroTelefonico VARCHAR (15) NOT NULL
);
INSERT INTO Direcciones (PrimerNombre,ApellidoPaterno,Email,NumeroTelefonico)
	VALUES ('Mike','Green','demo1@deitel.com','555-5555'),
	('Mary','Brown','demo2@deitel.com','555-1234');