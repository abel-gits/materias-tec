perros(pastor_aleman,[solvino,dino,oso]).
perros(san_bernardo,[riky,bella,majestad]).
perros(french_poodle,[paloma,piojo,livier]).

pertenece(E,L) :- L=[E|_].
pertenece(E,[_|T]) :- pertenece(E,T).

pastor_aleman(P):-  perros(pastor_aleman,L),pertenece(P,L).

raza(R):- perros(_,L), pertenece(R,L).


%concatenar dos cadenas

concatena([],L,L).
concatena([X|L1],L2,[X|L3]):- concatena(L1,L2,L3).


concatena(_,[Month1,may,Month2|_],
          [jan,feb,mar,apr,may,jun,jul,aug,sep,oct,nov,dec]).