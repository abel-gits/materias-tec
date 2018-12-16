Proceso sin_titulo
	//este algoritmo cuenta la cantidad de digitos en un string
	Escribir "ingrese un string"
	leer a
	b="0123456789"
	x=0
	para i=1 hasta longitud(a) Hacer
		para p=1 hasta longitud(b) Hacer
			si Subcadena(a,i,i)=subcadena(b,p,p) Entonces
				x=x+1
			FinSi
		FinPara
	FinPara
	Escribir " total de digitos= " x
FinProceso