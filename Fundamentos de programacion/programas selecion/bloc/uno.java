//este programa lee los datos de un triangulo y si son mayores 
//que cero calula el area
import java.util.Scanner;
public class Uno {
public static void main(String[]args) {
Scanner leer =new Scanner(System.in);
float area, b,a;
System.out.println("ingrese la base");
b=leer.nextFloat();
System.out.println("ingrese la altura");
a=leer.nextFloat();
if (a>0) {
area=b*a/2;
System.out.println("el area es "+area);
}
}
}