Proceso sin_titulo
	dimension a[5]
	dimension e[5]
	
	
	para i=1 hasta 5 hacer
		Escribir "ingrese el nombre de la persona " ,i
		leer a[i] 
		Escribir "ingrese la edad de la persona " ,i
		leer e[i]
	FinPara
	
	para i=1 hasta 4 hacer
		si e[i]>e[i+1] entonces
			x=e[i+1]
			e[i+1]=e[i]
			e[i]=x
			
			
			c=a[i+1]
			a[i+1]=a[i]
			a[i]=c
			
		FinSi
	FinPara
	Escribir "la persona mayor es " a[5]
FinProceso
