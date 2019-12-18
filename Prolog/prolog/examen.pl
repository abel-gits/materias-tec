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
aDosLugares(X,Q):- estaADer(Z,X),estaAIzq(Z,Q).