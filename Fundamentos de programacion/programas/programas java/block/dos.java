//este programa lee dos numeros e imprime su suma, resta, 
//multriplicasion y division
//materia:fundamentos de programacion unidad 3
//25/10/2015
//Abel Robles Montoya
//datos de entrada: dos numeros
//datos de salida:su suma, resta, multriplicasion y division
import java.util.Scanner;
public class dos {
public static void main(String[]args) {
//definir variables
int num1,num2,suma,resta,multriplicasion;
float division;
//leer datos
Scanner leer = new Scanner(System.in);
System.out.println("ingrese dos numeros");
num1=leer.nextInt();
num2=leer.nextInt();
suma=num1+num2;
resta=num1-num2;
multriplicasion=num1*num2;
division=num1/num2;
System.out.println("suma= "+suma+ " resta= "+resta+ " multriplicasion= " +multriplicasion +" division= " +division);
}
}
