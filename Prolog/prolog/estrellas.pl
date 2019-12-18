imprimir([]).
imprimir([X|L]):- lista(X), imprimir(L).

lista([]).
lista([X|L]):- write(X),nl, lista(L).



bars([]).
bars([X|L]):- imp(X),nl, bars(L).

imp(X):-X==0.
imp(X):- write(*),X2 is X-1 ,imp(X2).