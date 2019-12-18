nombre(pamela).
nombre(fernando).
nombre(tina).
nombre(diego).

apellido(rodriguez).
apellido(barrios).
apellido(rios).
apellido(vargas).


platillo(ravioles).
platillo(estofado).
platillo(ensalada).
platillo(pastel).


no_es(fernando,rodriguez).
no_es(fernando,barrios).

no_es(tina,rodriguez).

no_es(diego,barrios).
no_es(diego,rodriguez).
no_es(diego,rios). 

no_es(pamela,barrios).
no_es(pamela,rios).
no_es(pamela,vargas).


no_llevara(pamela,ravioles).
no_llevara(pamela,estofado).
no_llevara(pamela,ensalada).

no_llevara(fernando,estofado).
no_llevara(fernando,pastel).

no_llevara(diego,estofado).
no_llevara(diego,pastel).

no_llevara(tina,pastel).
no_llevara(tina,ensalada).
no_llevara(tina,ravioles).


comensal(X,Y,Z):- (   nombre(X),apellido(Y),not(no_es(X,Y))),platillo(Z),not(no_llevara(X,Z)).