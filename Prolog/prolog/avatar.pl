% BC Avatar cortesia:
%Rodriguez Mendoza Nora Kassandra.
%Rodriguez Qui�onez Ramon Guadalupe.

airecontrol(aang).
triste(katara).
enojado(aang).
aguacontrol(katara,mujer).
aguacontrol(aang,hombre).
aguacontrol(pakku,hombre).
tierracontrol(toph).
tierracontrol(aang).
metalcontrol(toph).
espadachin(sokka).
fuegocontrol(zuko).
fuegocontrol(aang).
fuegocontrol(azula).
fuegocontrol(zhao).
fuegocontrol(ozai).
ciega(toph).
termina(guerra).

estadoavatar(X):- enojado(X),airecontrol(X).
bandidaciega(X):- ciega(X), tierracontrol(X).
peleadoragua(X):- aguacontrol(X).
peleadorfuego(X):- fuegocontrol(X).
peleadortierra(X):- tierracontrol(X).
peleadoraire(X):- airecontrol(X).
curandera(X):- aguacontrol(X,mujer).
combate(X,Y):-

gana(X,Y,Z,X):-
gana(X,Y,Z,X):-
avatar(X):- airecontrol(X).
aborrece(X,Y):-
mata(X,Y):-
feliz(X):-


