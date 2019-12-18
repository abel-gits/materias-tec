/*
EJERCICIO 2:
======================================
Encuentra la ocupación de cada mujer:

(a) Clara es violentamente alérgica a las plantas.
(b) Luisa y la florista comparten el departamento
(c) A María y Luisa les gusta solamente la música rock
(d) La jardinera, la diseñadora de modas y Nélida no se conocen entre sí.
e) una mujer no puede tener una ocupación que esté relacionada con algo a lo que es alérgica:
f) cada mujer tiene un solo trabajo, y  cada trabajo es ocupado por una sola mujer las cuatro mujeres elegidas y las cuatro ocupaciones  deben ser diferentes entre sí.
**/
/*	?- respuesta(X).
	X=[[clara,diseñadora],[luisa,jardinera],
	   [maria,florista],[nelida,directora_de_orquesta]]
	Yes
*/

mujer(clara).   mujer(nelida).   mujer(maria).   mujer(luisa).
ocupacion(florista).
ocupacion(jardinera).
ocupacion(diseñadora).
ocupacion(directora_de_orquesta).



alergica(clara,plantas).


gusta(maria,rock).
gusata(luisa,rock).
noEs(maria,directora_de_orquesta).
noEs(luisa,directora_de_orquesta).
noEs(nelida,diseñadora).
noEs(nelida,jardinera).
noEs(clara,jardinera).
noEs(clara,florista).
noEs(luisa,florista).



viveCon(luisa,florista).


diferente(A,B,C,D):- A\=B, A\=C,A\=D, B\=C, B\=D, C\=D.

respuesta( [Mujer1,Ocup1], [Mujer2,Ocup2], [Mujer3,Ocup3], [Mujer4,Ocup4]):-
	mujer(Mujer1), mujer(Mujer2),mujer(Mujer3), mujer(Mujer4),
	ocupacion(Ocup1), ocupacion(Ocup2), ocupacion(Ocup3), ocupacion(Ocup4),
	diferentes(Mujer1,Mujer2,Mujer3,Mujer4),
	diferentes(Ocup1,Ocup2,Ocup3,Ocup4),
	not(noEs(Mujer1,Ocup1)),	not(noEs(Mujer2,Ocup2)),
	not(noEs(Mujer3,Ocup3)),	not(noEs(Mujer4,Ocup4)).









