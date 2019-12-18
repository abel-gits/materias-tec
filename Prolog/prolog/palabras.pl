palabras(casa,c,a,s,a).
palabras(amlo,a,m,l,o).
palabras(palma,p,a,l,m,a).
palabras(aclarar,a,c,l,a,r,a,r).
palabras(maluma,m,a,l,u,m,a).

crucigrama([V1, V2, H1, H2, H3 ]):-
    palabras(V1, X1, _, X3,_,_,X5,_),
    palabras(V2,_,X2,_,X4,_),
    palabras(H1,_,X1,_,X2),
    palabras(H2,_,_,X3,_,X4,_),
    palabras(H3,X5,_,_,_).