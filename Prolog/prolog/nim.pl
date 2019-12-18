jugador(j1).
jugador(j2).

empieza:-
    write("¿Con cuantos palitos empezamos? "), read(Palitos),
    write("¿Quien empieza? "), read(Quien),
    jugador(Quien), nim(Palitos, Quien).

nim(1,Q):- write(Q),write(" ya perdiste!!! :) \n").
nim(P,Q):- P<1, write(Q), write(" ya ganaste!!! \n").
nim(P,Q):- write(Q), write(" cuantos palitos quitamos? "),
    read(Cuantos), 
    validar(Cuantos,Cuantos1),
    P1 is P-Cuantos,
    write("quedan "), write(P1), nl,
    jugador(Q1), Q1 \= Q,
    nim(P1,Q1).

validar(C,C):- C>0, C<4.
validar(C,C1):- 
    write(" solo son validos 1,2,3. De otro numero: "),
    read(Otro),
    validar(Otro,C1).