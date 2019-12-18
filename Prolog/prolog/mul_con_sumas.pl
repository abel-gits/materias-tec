mul(N,F,R):-N==1,R is F.
mul(N,F,R):- N2 is N-1 ,mul(N2,F,R2),R is F+R2.