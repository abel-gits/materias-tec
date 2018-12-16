DROP TABLE isbnAutor;
DROP TABLE titulos;
DROP TABLE autores;

CREATE TABLE autores (
   idAutor INT NOT NULL GENERATED ALWAYS AS IDENTITY,
   nombrePila varchar (20) NOT NULL,
   apellidoPaterno varchar (30) NOT NULL,
   PRIMARY KEY (idAutor)
);

CREATE TABLE titulos (
   isbn varchar (20) NOT NULL,
   titulo varchar (100) NOT NULL,
   numeroEdicion INT NOT NULL,
   copyright varchar (4) NOT NULL,
   PRIMARY KEY (isbn)
);

CREATE TABLE isbnAutor (
   idAutor INT NOT NULL,
   isbn varchar (20) NOT NULL,
   FOREIGN KEY (idAutor) REFERENCES autores (idAutor), 
   FOREIGN KEY (isbn) REFERENCES titulos (isbn)
);

INSERT INTO autores (nombrePila, apellidoPaterno)
VALUES 
   ('Harvey','Deitel'),
   ('Paul','Deitel'), 
   ('Andrew','Goldberg'),
   ('David','Choffnes');

INSERT INTO titulos (isbn,titulo,numeroEdicion,
   copyright)
VALUES
   ('0131869000','Visual Basic 2005 How to Program',3,'2006'),
   ('0131525239','Visual C# 2005 How to Program',2,'2006'),
   ('0132222205','Java How to Program',7,'2007'), 
   ('0131857576','C++ How to Program',5,'2005'),
   ('0132404168','C How to Program',5,'2007'),
   ('0131450913','Internet & World Wide Web How to Program',3,'2004'),
   ('0131828274','Operating Systems',3,'2004');

INSERT INTO isbnAutor (idAutor,isbn)
VALUES
   (1,'0131869000'),
   (2,'0131869000'),
   (1,'0131525239'),
   (2,'0131525239'),
   (1,'0132222205'), 
   (2,'0132222205'), 
   (1,'0131857576'),
   (2,'0131857576'),
   (1,'0132404168'),
   (2,'0132404168'),
   (1,'0131450913'),
   (2,'0131450913'),
   (3,'0131450913'),
   (1,'0131828274'),
   (2,'0131828274'),
   (4,'0131828274');