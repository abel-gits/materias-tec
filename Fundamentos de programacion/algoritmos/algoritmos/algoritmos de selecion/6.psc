Proceso sin_titulo
	//este programa lee tres calificaciones e imprime cuantas reprobo//
	Escribir "ingrese tres calificasiones"
	Leer a,b,c
	si (a<70 y b>69 y c>69) o (a>69 y b<70 y c>69) o (a>69 y b>69 y c<70)
		Entonces
		Escribir "materias reprobadas=1"
	Sino
		si (a<70 y b<70 y c>69) o (a>69 y b<70 y c<70) o (a<70 y b>69 y c<70)
			entonces
			Escribir "materias reprobadas=2"
		Sino
			si a<70 y b<70 y c<70
				Entonces
				Escribir "materias reprobadas=3"
			Sino
				si a>69 y b>69 y c>69
					entonces 
					Escribir "materias reprobadas=0"
				FinSi
			FinSi
		FinSi
		
	FinSi
FinProceso
