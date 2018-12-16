//este programa lee 100 numeros e
//imprime cuantos son positivos y cuantos negativos
import java.util.Scanner;
public class Cuatro {
public static void main(String[]args) {
Scanner leer = new Scanner(System.in);
int positivos=0;
int negativos=0;
System.out.println("escribe 100 numeros");
for (int i=1;i<=100;i++) {
int a=leer.nextInt();
if (a>0)
positivos=positivos+1;
else
if (a<0)
negativos=negativos+1;
}
System.out.println("positivos = "+positivos);
System.out.println("negativos = "+negativos);
}
}

