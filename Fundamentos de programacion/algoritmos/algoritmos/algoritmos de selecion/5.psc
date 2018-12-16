Proceso sin_titulo
	//este programa lee tres numeros y los ordena de mayo a menor//
	Escribir "ingrese tres numeros"
	Leer a,b,c
	si a>b y a>c y b>c
		entonces
		Escribir a,b,c
	Sino
		si b>a y b>c y a>c
			Entonces
			Escribir b,a,c
		Sino
			si c>a y c>b y a>b
				Entonces
				Escribir c,a,b
			sino
				si a>b y a>c y c>b
					entonces 
					Escribir a,c,b
				Sino
					si b>a y b>c y c>a
						Entonces
						Escribir b,c,a
					Sino
						si c>a y c>b y b>a
							Entonces
							Escribir c,b,a
						FinSi
					FinSi
				FinSi
			FinSi
		FinSi
		
	FinSi
	
FinProceso
