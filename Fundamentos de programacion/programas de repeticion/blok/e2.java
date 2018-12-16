//este programa lee la edad de 10 personas 
//e imprime su promedio
import java.util.Scanner;
public class e2 {
public static void main(String[]args) {
Scanner leer =new Scanner(System.in);
int edad=0,suma=0;
double prom=0;
System.out.println("escribe la edad de 10 personas");
for (int i=1;i<=10;i++) {
edad=leer.nextInt();
suma=suma+edad;
}
prom=suma/10;
System.out.println("el promedio de las edades es "+prom);
}
}
