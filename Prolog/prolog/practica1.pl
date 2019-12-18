/*

A partir de la siguiente base de conocimiento en prolog,

crear las reglas necesarias para que el intérprete nos

diga qué alimento puede comer cada animal:

*/

herbívoro(vaca).

herbívoro(oveja).

carnívoro(león).

hortaliza(tomate).

hortaliza(zanahoria).

fruta(manzana).

pescado(besugo).

carne(salchicha).

fideos(spaghetti).



%Creamos las reglas:

come(X,Y):- herbivoro(X), (hortaliza(Y); fruta(Y)).
come(X,Y):-carnivoro(X),
	(   carne(Y); pescado(Y);herbivoro(Y);
	(   carnivoro(Y),dif(X,Y))).



animal(perro).
animal(gato).
animal(serpiente).
espersona(luis).
espersona(maria).
espersona(juan).
objeto(zapato).
objeto(lapz).
echahumo(tren).



% Elabore un programa en prolog que defina lo siguiente:

% 1) Las algas usan medias rojas.
usamediasrojas(alga).


%2) Todo objeto o animal o persona que usa  desodorante sabe tocar el saxo.
tocasax(X):- usadesodorante(X),(animal(X);objeto(X);persona(X)).

%3) Todo lo que eche humo usa desodorante.

usadesodorante(X):-echahumo(X).


% 4) Nada ni nadie que usa medias rojas puede tocar el saxo.
tocasax(X):-not(usamediasrojas(X)).

% 5) Todas las personas  puede usar un objeto
puedeusarobjeto(X):-espersona(X).


% 6) Si una persona usa desodorante no hara la tarea
noharatarea(X):-usadesodorante(X).

% 7) Si usa desodorante y puede usar un objeto echa humo
echahumo(X):-usadesodorante(X),puedeusarobjeto(X).


% 8)Cualquier animal que corre es feliz
esfeliz(X):-esanimal(X),corre(X).

% 9) Los hippies son felices y pueden tocar el saxo
eshippi(X):-esfeliz(X),tocasax(X).

% 10) cualquier animal o persona puede correr
corre(X):-espersona(X);animal(X).











