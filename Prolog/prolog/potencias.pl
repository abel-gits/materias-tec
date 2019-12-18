potencia(B,E,R):- E==1,R is B.
potencia(B,E,R):- E2 is E-1, potencia(B,E2,R2), R is R2*B.