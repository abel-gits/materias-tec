//este programa determina el area y la longuitud de la circunferencia de un triangulo
//materia:fundamentos de programacion unidad 3
//25/10/2015
//Abel Robles Montoya
//datos de entrada: radio
//datos de salida: el area y longuitud de la circunferencia
import java.util.Scanner;
public class diez {
public static void main(String[]args) {
Scanner leer=new Scanner(System.in);
double radio,area,longitud;
System.out.println("ingrese el radio");
radio=leer.nextDouble();
area=Math.PI*Math.pow(radio,2);
longitud=2*Math.PI*radio;
System.out.println("area= "+area+" longitud= "+longitud);
}
}