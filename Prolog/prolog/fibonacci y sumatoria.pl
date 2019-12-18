fibonacci(0,0).
fibonacci(1,1).
fibonacci(N,X):-
    N>1,
    N1 is N-1,
    fibonacci(N1,X1),
    N2 is N-2,
    fibonacci(N2,X2),
    X is X1+X2.

suma(N,Resultado):-
    N=<1 , Resultado is 1.

suma(N,Resultado):- 
    N>1,
    suma(N-1,RespuestaAux),
    Resultado is RespuestaAux+N.
    