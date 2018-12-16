Proceso sin_titulo
	x=0
	r=0
	Dimension a[10]
	para i=1 hasta 10 Hacer
		Escribir "ingrese numero de control " , i
		leer a[i]
	FinPara
	Escribir "cuantas calificaciones son"
	leer b
	
	
	
	
	dimension d[b] 
	Escribir "escriba las calificaciones de la persona 1" 
	para i=1 hasta b hacer
		leer d[i]
	FinPara
	
	
	Escribir "escriba las calificaciones de la persona 2"
	dimension f[b]
	para i=1 hasta b hacer
		leer f[i]
	FinPara
	
	
	Dimension g[b] 
	Escribir "escriba las calificaciones de la persona 3"
	para i=1 hasta b hacer
		leer g[i]
	FinPara
	
	dimension s[b]
	escribir "escriba las calificaciones de la persona 4"
	para i=1 hasta b hacer
		leer s[i]
	FinPara
	
	
	
	
	dimension w[b]
	Escribir "escriba las calificaciones de la persona 5"
	para i=1 hasta b hacer
		leer w[i]
	FinPara
	
	
	
	dimension l[b]
	Escribir "escriba las calificasiones de la persona 6"
	para i=1 hasta b hacer
		leer l[i]
	FinPara
	
	
	
	Escribir "escriba las calificaciones de la persona 7"
	dimension v[b]
	para i=1 hasta b hacer
		leer v[i]
	FinPara
	
	
	
	Escribir "escriba las calificasiones de la persona 8"
	dimension p[b]
	para i=1 hasta b hacer
		leer p[i]
	FinPara
	
	
	
	dimension k[b]
	Escribir "escribir las calificaciones de la persona 9"
	para i=1 hasta b hacer
		leer k[i]
	FinPara
	
	
	
	dimension z[b]
	Escribir "escriba las calificaciones de la persona 10"
	para i=1 hasta b hacer
		leer z[i]
	FinPara
	
	
	
	
	Escribir "NO. de control 1= " a[1]
	Escribir "calificaciones "
	ñ=0
	para i=1 hasta b hacer
			
		Escribir d[i]
		ñ=ñ+d[i]
		finpara 
		para i=1 hasta b hacer
			si d[i]<70 entonces
				r=r+1
			Sino
				x=x+1
			FinSi
		FinPara
		Escribir "materias reprobadas= " ,r
		Escribir "materias aprobadas= " x
		cs=ñ/b
		Escribir "promedio = " cs
		x=0
		r=0
		
		
		
		
		
		
		Escribir "NO. de control 2 = " a[2]
		Escribir "calificaciones "
		ñ=0
		para i=1 hasta b hacer
			
			Escribir f[i]
			ñ=ñ+f[i]
		finpara
		cs=ñ/b
		para i=1 hasta b hacer
			si f[i]<70 entonces
				r=r+1
			Sino
				x=x+1
			FinSi
		FinPara
		Escribir "materias reprobadas= " ,r
		Escribir "materias aprobadas= " x
		Escribir "promedio = " cs
		x=0
		r=0
		
		
		Escribir "NO. de control 3= " a[3]
		Escribir "calificaciones "
		ñ=0
		para i=1 hasta b hacer
			
			Escribir g[i]
			ñ=ñ+g[i]
		finpara
		para i=1 hasta b hacer
			si g[i]<70 entonces
				r=r+1
			Sino
				x=x+1
			FinSi
		FinPara
		Escribir "materias reprobadas= " ,r
		Escribir "materias aprobadas= " x
		cs=ñ/b
		Escribir "promedio = " cs
		
		x=0
		r=0
		
		
		Escribir "NO. de control 4= " a[4]
		Escribir "calificaciones ="
		ñ=0
		para i=1 hasta b hacer
			
			Escribir s[i]
			ñ=ñ+s[i]
		finpara
		para i=1 hasta b hacer
			si s[i]<70 entonces
				r=r+1
			Sino
				x=x+1
			FinSi
		FinPara
		Escribir "materias reprobadas= " ,r
		Escribir "materias aprobadas= " x
		cs=ñ/b
		Escribir "promedio = " cs
		x=0
		r=0
		
		
		Escribir "NO. de control 5= " a[5]
		Escribir "calificaciones " 
		ñ=0
		para i=1 hasta b hacer
			
			Escribir w[i]
			ñ=ñ+W[i]
		finpara
		para i=1 hasta b hacer
			si w[i]<70 entonces
				r=r+1
			Sino
				x=x+1
			FinSi
		FinPara
		Escribir "materias reprobadas= " ,r
		Escribir "materias aprobadas= " x
		cs=ñ/b
		Escribir "promedio = " cs
		x=0
		r=0
		
		Escribir "NO. de control 6= " a[6]
		Escribir "calificaciones "
		ñ=0
		para i=1 hasta b hacer
			
			Escribir l[i]
			ñ=ñ+l[i]
		finpara
		para i=1 hasta b hacer
			si l[i]<70 entonces
				r=r+1
			Sino
				x=x+1
			FinSi
		FinPara
		Escribir "materias reprobadas= " ,r
		Escribir "materias aprobadas= " x
		cs=ñ/b
		Escribir "promedio = " cs
		x=0
		r=0
		
		Escribir "NO. de control 7= " a[7]
		Escribir "calificaciones "
		ñ=0
		para i=1 hasta b hacer
			
			Escribir v[i]
			ñ=ñ+v[i]
		finpara
		para i=1 hasta b hacer
			si v[i]<70 entonces
				r=r+1
			Sino
				x=x+1
			FinSi
		FinPara
		Escribir "materias reprobadas= " ,r
		Escribir "materias aprobadas= " x
		cs=ñ/b
		Escribir "promedio = " cs
		x=0
		r=0
	
		Escribir "NO. de control 8= " a[8]
		Escribir "calificaciones "
		ñ=0
		para i=1 hasta b hacer
			
			Escribir p[i]
			ñ=ñ+p[i]
		finpara
		para i=1 hasta b hacer
			si p[i]<70 entonces
				r=r+1
			Sino
				x=x+1
			FinSi
		FinPara
		Escribir "materias reprobadas= " ,r
		Escribir "materias aprobadas= " x
		cs=ñ/b
		Escribir "promedio = " cs
		x=0
		r=0
		
		Escribir "NO. de control 9= " a[9]
		Escribir "calificaciones "
		ñ=0
		para i=1 hasta b hacer
			
			Escribir k[i]
			ñ=ñ+k[i]
		finpara
		para i=1 hasta b hacer
			si k[i]<70 entonces
				r=r+1
			Sino
				x=x+1
			FinSi
		FinPara
		Escribir "materias reprobadas= " ,r
		Escribir "materias aprobadas= " x
		cs=ñ/b
		Escribir "promedio = " cs
		x=0
		r=0
		
		Escribir "NO. de control 10= " a[10]
		Escribir "calificaciones "
		ñ=0
		para i=1 hasta b hacer
			
			Escribir z[i]
			ñ=ñ+z[i]
		finpara
		para i=1 hasta b hacer
			si z[i]<70 entonces
				r=r+1
			Sino
				x=x+1
			FinSi
		FinPara
		Escribir "materias reprobadas= " ,r
		Escribir "materias aprobadas= " x
		cs=ñ/b
		Escribir "promedio = " cs
FinProceso
