Proceso sin_titulo
	//este programa lee un dia y mes e imprime la estacion del año que corresponde//
	escribir "ingrese el dia"
	leer a
	Escribir "ingrese mes"
	leer b
	segun b hacer
		Caso "enero" o "febrero" o "marzo":e="primavera"
		caso "abril" o "mayo" o "junio":e="verano"
		caso "julio" o "agosto" o "septiembre":e="otoño"
		caso "octubre" o "noviembre" o "diciembre":e="invierno"
			
	FinSegun
	Escribir e
	
FinProceso
