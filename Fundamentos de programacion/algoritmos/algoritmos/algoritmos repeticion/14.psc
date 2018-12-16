Proceso sin_titulo
	Escribir "ingrese 10 numeros positivos mayores a 0 el ultimo debe serr 99"
	Dimension a[10]
	x=0
	para i=1 hasta 10 Hacer
		leer a[i]
	FinPara
	para i=1 hasta 10 Hacer
		para i=1 hasta 9 Hacer
			si a[i]>a[i+1] Entonces
				x=a[i]
				a[i+1]=a[i]
				a[i]=x
			FinSi
		FinPara
	FinPara
	Escribir "el numero mayor es " ,a[10]
FinProceso
