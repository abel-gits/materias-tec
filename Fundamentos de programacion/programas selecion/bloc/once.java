//este programa lee el numero de horas que duerme una 
//persona y determina si esta durmiendo lo sufisiente segun el rango
import java.util.Scanner;
public class Once {
public static void main(String[]args) {
Scanner leer = new Scanner(System.in);
int a;
System.out.println("escriba el numero de horas que duerme");
a=leer.nextInt();
if ((a>=0)&(a<=6))
System.out.println("se considera que nesesita dormir mas");
else 
if ((a>=7)&(a<=8))
System.out.println("duerme lo nesesario");
else 
if (a>=9)
System.out.println("puede estar durmiendo en exeso");
}
}