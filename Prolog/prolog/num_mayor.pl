llam([L|P]):-comp(L,P).
comp(R,[]):-R is R.
comp(P,[L|L1]):- P >= L, comp(P,L1).

res([L|_],R):-R is L.

may(L,R):- llam(L),res(L,R1),R is R1.
may([_|L1],R):-may(L1,R).