antes(huevo,bulbasur).
antes(bulbasur,ivasur).
antes(ivasur,venusur).

despues(ivasur,venusur).
despues(ivasur,bulbasur).
despues(bulbasur,huevo).

evolucion(X,Y):- despues(X,Y).
evolucion(X,Y):- despues(X,Z), evolucion(Y,Z).
