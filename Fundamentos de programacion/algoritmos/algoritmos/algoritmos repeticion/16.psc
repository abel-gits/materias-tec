Proceso sin_titulo
	x=0
	z=0
	l=0
	Repetir
		Escribir  "ingrese H para hombre, M para mujer y N pra niño"
		leer c
		segun c hacer
			caso "h": x=x+1
			caso "m":z=z+1
				caso "n":l=l+1
		FinSegun
	Hasta Que c="fin"
	Escribir "entraron"
	Escribir    x "	  "  "hombres"
	Escribir    z "   "  "mujeres"
	Escribir    l "   "  "niños"
FinProceso
