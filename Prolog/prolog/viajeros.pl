
acompaña(alejandro,benito).
acompaña(juan,carlos).

no_acompaña(carlos,dario).

no_viaja(alejandro,coche).
no_viaja(benito,avion).
no_viaja(carlos,avion).
no_viaja(juan,tren).

viaja(dario,avion).
viaja(andres,avion).

pareja(X,Y):- (   acompaña(X,Y); acompaña(Y,X)); (   viaja(X,Z),viaja(Y,Z)).


viaja_tren(X):-pareja(X,Y),(   (no_viaja(X,avion);no_viaja(Y,avion)),(no_viaja(X,coche);no_viaja(Y,coche)) ) ;pareja(X,Y),(   viaja(X,tren);viaja(Y,tren)).
viaja_avion(X):-pareja(X,Y),(   (no_viaja(X,tren);no_viaja(Y,tren)),(no_viaja(X,coche);no_viaja(Y,coche)) ) ;pareja(X,Y),(   viaja(X,avion);viaja(Y,avion)).
viaja_coche(X):-pareja(X,Y),(   (no_viaja(X,avion);no_viaja(Y,avion)),(no_viaja(X,tren);no_viaja(Y,tren)) ) ;pareja(X,Y),(   viaja(X,coche);viaja(Y,coche)).

