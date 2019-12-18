%      Para correr el programa se llama a la funcion:
%      inicio.
%
%
%
%      Integrantes:
%      Astorga Ramos Alvaro
%      Ibarra villegas Juan Luis
%      Robles Montoya Abel
%
%
%      Horario:  8-9
%
%
:-dynamic aprobadas/1,materias/1,semestre/1,carga/1,rc/1,esp/1,guar/1,credit/1.
%semestre 1
materia(5,calDif).
materia(5,funProg).
materia(4,tallerEtic).
materia(5,mateDis).
materia(4,tallerAdmin).
%semestre 2
materia(5,calInt).
materia(5,poo).
materia(4,cont).
materia(4,quimica).
materia(5,algebraLin).
%semestre 3
materia(5,calVec).
materia(5,estrucDat).
materia(4,culturaEmp).
materia(4,io).
materia(5,desSus).
%semestre 4
materia(5,ecDif).
materia(4,metNum).
materia(5,tap).
materia(5,funDB).
materia(5,sim).
%semestre 5
materia(5,graf).
materia(4,funTele).
materia(4,sistOp).
materia(4,tallerDB).
materia(4,funIng).
%semestre 6
materia(5,lenAut).
materia(5,redesComp).
materia(4,tallerSis).
materia(5,dba).
materia(5,ingSoft).
%semestre 7
materia(5,lenAutII).
materia(5,conmutacion).
materia(4,tallerInv).
materia(6,gestionSoft).
materia(10,residencias).

seriadas(calDif,calInt).
seriadas(calInt,calVec).
seriadas(calVec,ecDif).
seriadas(funProg,poo).
seriadas(poo,estrucDat).
seriadas(estrucDat,metNum).
seriadas(estrucDat,tap).
seriadas(funDB,tallerDB).
seriadas(tallerDB,dba).
seriadas(funIng,ingSoft).
seriadas(ingSoft,gestionSoft).
seriadas(sistOp,tallerSis).
seriadas(lenAut,lenAutII).
seriadas(funTele,redesComp).
seriadas(redesComp,conmutacion).

materias([calDif,funProg,tallerEtic,mateDis,tallerAdmin,calInt,poo,cont,quimica,algebraLin,calVec,estrucDat,culturaEmp,io,desSus,ecDif,metNum,tap,funDB,sim,graf,funTele,sistOp,tallerDB,funIng,lenAut,redesComp,tallerSis,dba,ingSoft,lenAutII,conmutacion,tallerInv,gestionSoft,residencias]).


materiaDif(3,calDif).
materiaDif(3,funProg).
materiaDif(1,tallerEtic).
materiaDif(2,mateDis).
materiaDif(1,tallerAdmin).

materiaDif(3,calInt).
materiaDif(2,poo).
materiaDif(1,cont).
materiaDif(1,quimica).
materiaDif(2,algebraLin).

materiaDif(3,calVec).
materiaDif(2,estrucDat).
materiaDif(1,culturaEmp).
materiaDif(1,io).
materiaDif(1,desSus).

materiaDif(3,ecDif).
materiaDif(2,metNum).
materiaDif(2,tap).
materiaDif(2,funDB).
materiaDif(1,sim).

materiaDif(2,graf).
materiaDif(1,funTele).
materiaDif(1,sistOp).
materiaDif(1,tallerDB).
materiaDif(1,funIng).

materiaDif(2,lenAut).
materiaDif(1,redesComp).
materiaDif(1,tallerSis).
materiaDif(1,dba).
materiaDif(2,ingSoft).

materiaDif(1,lenAutII).
materiaDif(2,conmutacion).
materiaDif(1,tallerInv).
materiaDif(1,gestionSoft).
materiaDif(0,residencias).


%inicializa las variables globales
ini:-retractall(credit(_)),retractall(aprobadas(_)),assert(aprobadas([])),retractall(materias(_)),assert(materias([calDif,funProg,tallerEtic,mateDis,tallerAdmin,calInt,poo,cont,quimica,algebraLin,calVec,estrucDat,culturaEmp,io,desSus,ecDif,metNum,tap,funDB,sim,graf,funTele,sistOp,tallerDB,funIng,lenAut,redesComp,tallerSis,dba,ingSoft,lenAutII,conmutacion,tallerInv,gestionSoft,residencias])),retractall(guar(_)),retractall(carga(_)),retractall(semestre(_)),retractall(rc(_)), retractall(esp(_)),assert(rc([])),assert(esp([])),assert(carga([])),assert(semestre(1)),assert(guar([])).

%concatena dos cadenas
concatena([],L,L).
concatena([X|L1],L2,[X|L3]):- concatena(L1,L2,L3).

fin:-retractall(materias(_)).

%reinicia carga
rcarga:- retractall(carga(_)),assert(carga([])).

%guarda en R un 1 si el alumno aprobo la materia M y un 0 si no
reprobA(M,R):- random(1,10,N),materiaDif(E,M),N>E,R is 1.
reprobA(_,R):- R is 0.

%guarda en guar el elemento L
fun(L):- guar(X),concatena(X,[L],R),retractall(guar(_)), assert(guar(R)).

% recibe una lista de materias y regresa una lista de las
% aprobadas y otra de las reprobadas
azar([]).
azar([X|L1]):-reprobA(X,R),(R == 1, fun(X),azar(L1)); azar(L1).
elimrep([],R):-retractall(guar(_)),assert(guar(R)).
elimrep([L|L1],R):- eliminar(L,R,N),elimrep(L1,N).
rand(L,A,R):-azar(L),guar(A),elimrep(A,L),guar(R),retractall(guar(_)),assert(guar([])).

%elemina X de la lista
eliminar(X, [X|Xs], Xs).
eliminar(X, [Y|Ys], [Y|Zs]):- eliminar(X, Ys, Zs).

%calcular el numero de creditos en la carga
cuentaC([],R):-R is 0.
cuentaC([L|L1],R):- materia(S,L),cuentaC(L1,R1),R is R1+S.
creditos(R):- carga(X),cuentaC(X,R).

%guarda un elemento en carga
gCarga(L):-carga(X),concatena(X,[L],R),retractall(carga(_)), assert(carga(R)).

%guarda un elemento en aprobadas
gAp(L):-aprobadas(X),concatena(X,[L],R),retractall(aprobadas(_)), assert(aprobadas(R)).

%guarda un elemento en credit
gCredit(L):-retractall(credit(_)), assert(credit(L)).

%une en una lista los creditos y las materias
imprimir(C,L,[C,L]).

%regresa true si la lista contiene el elemento X
contiene(_,[],R):- R is 0.
contiene(X,[L|L1],R):- (X==L,R is 1);(contiene(X,L1,R)).
verifica(X,L):- contiene(X,L,R), R == 1.

%revisa si esta seriada
seriada(M):- ( not(seriadas(S,M)),S==S,M==M ) ;  (seriadas(S,M),aprobadas(X),(verifica(S,X));(rc(R),contar(R,R1),esp(E),contar(E,E1),N is R1+E1,N>4)).

%elimina el elemento X de rc
eRc(X):- rc(L),eliminar(X,L,R),retractall(rc(_)),assert(rc(R)).

%elimina el elemento X de esp
eEsp(X):- esp(L),eliminar(X,L,R),retractall(esp(_)),assert(esp(R)).

%elimina de rc o esp una materia si ya la paso y las guarda en aprobadas
pasar([]).
pasar([M|M1]):-gAp(M),rc(X),esp(Y), ((verifica(M,X),eRc(M));(verifica(M,Y),eEsp(M));(1==1)),pasar(M1).

%guarda un elemento en rc
gRc(L):-rc(X),concatena(X,[L],R),retractall(rc(_)), assert(rc(R)).
%guarda un elemento en esp
gesp(L):- esp(X),concatena(X,[L],R),retractall(esp(_)), assert(esp(R)).

%guarda un elemento en semestre
gSemestre(L):-retractall(semestre(_)), assert(semestre(L)).

%verifica si L esta en rc o especial y lo guarda donde corresponde
reprob(L):-rc(X),esp(Y),((verifica(L,X),gesp(L),eRc(L));(verifica(L,Y),nl,write("!Has reprobado un especial!"),nl,fin);(gRc(L))).

%guarda las materias reprobadas
materiasRep([]).
materiasRep([L|L1]):- reprob(L),( materiasRep(L1)).

%devuelve la longitud de una lista
contar([],0).
contar([_|L2],N):-  contar(L2,N2),N is N2+1.
ret():- aprobadas(X), contar(X,N),T is 34-N,semestre(S),S1 is 12-S,S1 >0,T1 is T/S1,T1 > 4,gCredit(19).
ret().

%elimina de materias las materias que se guardaron en carga
eMat(M):- materias(X),eliminar(M,X,R),retractall(materias(_)),assert(materias(R)).
eMat(_).
%guarda en carga las materias de la lista tomando en cuenta los creditos
gcar([L|L1]):-ret(),credit(C),materia(C2,L),creditos(X),Sum is X+C2,(C >= Sum,seriada(L),gCarga(L),eMat(L),cargar(L1));cargar(L1).
%regresa true si la lista esta vacia
isnull([]).

cargar(L):- not(isnull(L)),gcar(L).
cargar(_).

cargar2():-esp([E|E1]),cargar3(E1,R),concatena([E],[R],N),cargar(N).
cargar3([R|_],R).

%carga las materias reprobadas
cargarep():-esp(E), contar(E,N),((N>=2,cargar2());(cargar(E),rc(R),cargar(R))).
cargarep().
%verifica si hay mas de dos especiles
cargarNR(M):- esp(E),contar(E,R),R=<2,cargar(M).
cargarNR(_).

prorroga():-materias(M),esp(E),rc(R),cuentaC(M,M1),cuentaC(E,E1),cuentaC(R,R1),A is M1+E1+R1,A>0,A=<19,write("Se aprobo la prorroga"),nl.
prorroga():-materias(M),contar(M,C),C>0,write("No se aprobo la prorroga, se le recomienda que obtenga su título como TSU"),nl,1==3.

iterar(S):-gSemestre(S),cargarep(),materias(M),cargarNR(M),carga(C),not(isnull(C)),creditos(D),imprimir(D,C,I),rcarga,write(S),write(I),rand(C,A,R),pasar(A),materiasRep(R),nl,Q is S+1,simular(Q).
iterar(_).

simular(S):-((S =< 12,iterar(S));(S<14,prorroga(),iterar(S))).
simular(_):-materias(M),rc(R),esp(E),contar(M,M1),contar(R,R1),contar(E,E1),A is M1+R1+E1,((A>0,write("No terminaste la carrera");(write("Terminaste la carrera")))).

recorrer([]).
recorrer([L|L1]):- eMat(L), recorrer(L1).
rec([]).
rec([L|L1]):- gAp(L), rec(L1).

guardar(A,R):-recorrer(A),recorrer(R),rec(A),pasar(A),materiasRep(R).


old(S,C):-S >= C, write('Escribe las materias aprobadas en en semestre '),write(C),nl,read(A),write('Escribe las materias reprobadas en en semestre '),write(C),nl,read(R),guardar(A,R),N is C+1,old(S,N).
old(S,_):-R is S+1,assert(credit(15)),simular(R).

trabajo():-write('¿trabajas?(si/no)'),read(X),((X == 'no',gCredit(19));(X == 'si',gCredit(15)));trabajo().

inicio3():-trabajo(), write('¿Cuantos semestres has cursado?'),read(S),old(S,1).
inicio4():- write('¿trabajas?(si/no)'),read(X),  ((X == 'no',gCredit(19),simular(1));(X == 'si',gCredit(15),simular(1)));inicio4().
inicio:- ini,write("¿Eres de nuevo ingreso?(si/no)"),nl,read(X),((X == 'no',inicio3());(X == 'si',inicio4());(inicio)).
















