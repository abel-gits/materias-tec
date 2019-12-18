contar([],0).
contar([L|L2],N):-  contar(L2,N2),N is N2+1.