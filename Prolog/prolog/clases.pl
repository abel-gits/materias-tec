maestro(elisa).   maestro(fernando).   maestro(carlos).
materia(logica).   materia(programacion).   materia(matematicas).
dias(lunes).   dias(martes).   dias(viernes).

%imparte(maestro, dia).
imparte(carlos,Dia):- dias(Dia),Dia \= lunes.
imparte(Maestro,Dia):- maestro(Maestro),dias(Dia),Maestro \= carlos.

%horario(clase,dia).
horario(programacion,viernes).
horario(logica,Dia):- dias(Dia),Dia \= lunes.
horario(matematicas,Dia):-dias(Dia).

%daClase(maestro,clase).
daClase(elisa, programacion).
daClase(Maestro,Materia):-maestro(Maestro),materia(Materia),Maestro \= elisa.


diferentes(A,B,C):- A\=B, A\=C,B\=C.


horario([Dia,Mat,Profe], [Dia2,Mat2,Profe2], [Dia3,Mat3,Profe3]):-
	maestro(Profe),
	maestro(Profe2),
	maestro(Profe3),

	materia(Mat),
	materia(Mat2),
	materia(Mat3),

	dias(Dia),
	dias(Dia2),
	dias(Dia3),

	diferentes(Mat,Mat2,Mat3),
	diferentes(Profe,Profe2,Profe3),
	diferentes(Dia,Dia2,Dia3),

	imparte(Profe,Dia),
	imparte(Profe2,Dia2),
	imparte(Profe3,Dia3),

	horario(Mat,Dia),
	horario(Mat2,Dia2),
	horario(Mat3,Dia3),

	daClase(Profe,Mat),
	daClase(Profe2, Mat2),
	daClase(Profe3, Mat3).


