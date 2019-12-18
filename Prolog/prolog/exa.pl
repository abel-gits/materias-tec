nombre(pamela).
nombre(fernando).
nombre(tina).
nombre(diego).

apellido(rodriguez).
apellido(barrios).
apellido(rios).
apellido(vargas).

es_hombre(fernando).
es_hombre(diego).

es_mujer(pamela).
es_mujer(tina).


platillo(ravioles).
platillo(estofado).
platillo(ensalada).
platillo(pastel).

llevara(X,rabioles):- es_hombre(X).


no_es(diego,rios).

no_es(fernando,rodriguez).
no_es(tina,rodriguez).

llevara(X,ravioles

no_llevara(fernando,estofado).
no_llevara(tina,ensalada).

