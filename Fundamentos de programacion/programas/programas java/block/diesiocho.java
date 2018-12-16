//este programa calcula la velosidad promedio de un corredor
//materia:fundamentos de programacion unidad 3
//26/10/2015
//Abel Robles Montoya
//datos de entrada: ninguno
//datos de salida: velocidad promedio
public class diesiocho {
public static void main(String[]args) {
double a,b,c,d;
System.out.println("1500 metros y un tiempo de 2 minutos, 5 segundos y 37 centésimas");
a=1.5;
b=(2*60*100)+(5*100+37);
d=b/100/60/60;
c=a/d;
System.out.println("el promedio es "+c+" km/h");
}
}