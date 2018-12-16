Proceso sin_titulo
	escribir "ingrese el capital"
	leer a
	Escribir "ingrese la tasa de interes anual"
	leer b
	Escribir "ingrese el plaso en meses al que se desea invertir"
	leer c
	cap=a/c
	int=(a/c)*(b/c)
	total=cap+int
	x=0
dimension m[c]
para i=1 hasta c hacer
	repetir 
		escribir "   mes " "   capital" "     intereses  " "  total "  
		x=x+1
	hasta que x>0
		 Escribir "    " ,i "      " , cap "         " ,int "         " ,total
	FinPara
	
	
FinProceso
