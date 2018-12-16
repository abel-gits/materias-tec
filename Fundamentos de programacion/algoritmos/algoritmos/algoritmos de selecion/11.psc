Proceso sin_titulo
	//este programa lee un numero de horas y determina si esta durmiendo lo sufisiente// 
	Escribir "ingrese numero de horas"
	Leer a
	si a<7 y a>-1
		Entonces
		x="nesesita dormir mas"
	Sino
		si a>6 y a<9
			Entonces
			x="duerme lo nesesario"
		Sino
			si a>8
				Entonces
				x="puede estar durmiendo en exeso"
			FinSi
		FinSi
	FinSi
	Escribir x
FinProceso
