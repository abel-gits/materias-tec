Proceso sin_titulo
	//este algoritmo cuenta las letras de un string
	Escribir "ingrese un string"
	leer a
	b="abcdefghijklmnñopqrstuvwxyz"
	x=0
	para i=1 hasta longitud(a) Hacer
		para p=1 hasta longitud(b) Hacer
			si Subcadena(a,i,i)=subcadena(b,p,p) Entonces
				x=x+1
			FinSi
		FinPara
	FinPara
	Escribir a " tiene " x " letras"
FinProceso
