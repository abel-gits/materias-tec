//este programa lee numeros
//del teclado hasta que sean 0
import java.util.Scanner;
public class e1 {
public static void main(String[]args) {
Scanner leer = new Scanner(System.in);
int a=1;
System.out.println("escribe un numero");
a=leer.nextInt();
while ((a<0)||(a>0))
a=leer.nextInt();
}
}

