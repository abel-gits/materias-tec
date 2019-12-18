:-dynamic aqui/1.


conectado(cocina,recibidor).
conectado(recibidor,cocina).
conectado(cocina,despensa).
conectado(despensa,cocina).
conectado(cocina,comedor).
conectado(comedor,cocina).
conectado(comedor,estar).
conectado(estar,comedor).

aqui(cocina).

ir(Lugar):-
    puedo_ir(Lugar),
    moverse(Lugar).

puedo_ir(Lugar):-
    aqui(X),
    conectado(X,Lugar).

moverse(Lugar):-
    retract(aqui(_)),
    asserta(aqui(Lugar)).
