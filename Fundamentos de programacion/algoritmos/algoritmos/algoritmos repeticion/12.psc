Proceso sin_titulo
	escribir "ingrese 50 numeros"
	dimension a[50]
	para i=1 hasta 50 hacer
		leer a[i]
	FinPara

	para i=1 hasta 49
		para x=i+1 hasta 50 Hacer
			si a[i]>a[x] entonces
				m=a[i]
				a[i]=a[x]
				a[x]=m
		FinSi
		
		FinPara
	FinPara
	z=a[25]+a[26]/2
	Escribir "media= " ,z
	
	
FinProceso
