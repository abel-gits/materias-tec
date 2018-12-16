Proceso sin_titulo
	//este programa lee un numero y determina sus resultados//
	Escribir "ingrese nivel de alchol"
	Leer a
	si (a>0 y a<0.08) o a=0
		Entonces
		x="aceptable"
	Sino
		si a>0.07
			Entonces
			x="inaceptable"
		FinSi
	FinSi
	Escribir x
FinProceso
