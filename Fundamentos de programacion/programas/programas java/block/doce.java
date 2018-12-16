//este programa calcula la hipotenusa de un triangulo conosiendo los lados
//materia:fundamentos de programacion unidad 3
//25/10/2015
//Abel Robles Montoya
//datos de entrada: ninguno
//datos de salida: la hipotenusa
public class doce {
public static void main(String[]args) {
int base,altura;
base=3;
altura=5;
int a,b,c;
a=base*base;
b=altura*altura;
c=a+b;
double h;
h=(double)Math.pow(c, 0.5);
System.out.println("hipotenusa de un triangulo de base 3 y altura 5= "+h);
}
}