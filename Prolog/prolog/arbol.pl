abuelo(X,Y):- padre(X,Z),padre(Z,Y).
hermano(X,Y):- padre(Z,X),padre(Z,Y).
tio(X,Y):- hermano(X,Z), padre(Z,Y).
dif(X,Y).
padre(tom,liz).
padre(tom,bob).
padre(pam,bob).
padre(bob,pat).
padre(bob,ann).
padre(pat,jim).
