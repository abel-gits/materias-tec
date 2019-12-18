estaAIzq(ginny,dean).
estaAIzq(angelina,ginny).
estaAIzq(seamus,angelina).
estaAIzq(colin,seamus).
estaAIzq(harry,colin).
estaAIzq(hermione,harry).
estaAIzq(ron,hermione).
estaAIzq(natalie,ron).
estaAIzq(katie,natalie).
estaAIzq(parvati,katie).
estaAIzq(lavender,parvati).
estaAIzq(neville,lavender).
estaAIzq(alicia,neville).
estaAIzq(fred,alicia).
estaAIzq(gorge,fred).
estaAIzq(lee,gorge).
estaAIzq(dennis,lee).
estaAIzq(dean,dennis).

estaADer(X,Y):- estaAIzq(Y,X).
quienIzq(X,I):- estaAIzq(I,X).
quienesEstanMesa(X):- estaAIzq(X,_).

quienEstaDer(X,N):-N==1, estaADer(R,X),write(R),nl .
quienEstaDer(X,N):-  estaADer(R,X),  A is N-1, quienEstaDer(R,A).

quienEstaIzq(X,N):-N==1, estaAIzq(R,X),write(R) .
quienEstaIzq(X,N):-  estaAIzq(R,X),  A is N-1, quienEstaIzq(R,A).


quienEsta(X,N):- quienEstaDer(X,N),quienEstaIzq(X,N).

medio(X,Y):- estaADer(Y,X).
medio(X,Y):- estaADer(R,X),write(R),nl,medio(R,Y).