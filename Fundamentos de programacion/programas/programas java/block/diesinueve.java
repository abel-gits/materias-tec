//este programa leer la hora y clacula el tiempo que falta para que finalise el dia 
//materia:fundamentos de programacion unidad 3
//26/10/2015
//Abel Robles Montoya
//datos de entrada: la hora
//datos de salida: el tiempo que falta para que acabe el dia
import java.util.Scanner;
public class diesinueve {
public static void main(String[]args) {
Scanner leer = new Scanner(System.in);
System.out.println("ingrese la hora");
int HH,MM,SS;
HH=leer.nextInt();
System.out.println("ingrese los minutos");
MM=leer.nextInt();
System.out.println("ingrese los segundos");
SS=leer.nextInt();
int a,b,c,d;
a=86400;
b=HH*60*60;
c=MM*60;
d=a-(b+c+SS);
double e,f;
e=d/60;
f=e/60;
System.out.println("faltan "+f+" horas "+e+" minutos "+d+" segundos");
}
}