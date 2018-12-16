//este programa lee las tres calificasiones de un estudiante 
//e imprime cuantas reprobo
import java.util.Scanner;
public class Seis {
public static void main(String[]args) {
Scanner leer = new Scanner(System.in);
System.out.println("escriba las tres calificasiones");
float a,b,c;
a=leer.nextFloat();
b=leer.nextFloat();
c=leer.nextFloat();
if ((a>=70)&(b>=70)&(c>=70))
System.out.println("materias reprobadas = 0");
else 
if (((a>=70)&(b<70)&(c<70))||((a<70)&(b>=70)&(c<70))||((a<70)&(b<70)&(c>=70)))
System.out.println("materias reprobadas = 2");
else 
if ((a<70)&(b<70)&(c<70))
System.out.println("materias reprobadas = 3");
else 
if (((a>=70)&(b>=70)&(c<70))||((a>=70)&(b<70)&(c>=70))||((a<70)&(b>=70)&(c>=70)))
System.out.println("materias reprobadas = 1");
}
}