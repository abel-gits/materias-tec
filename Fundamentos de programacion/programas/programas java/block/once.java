//este programa calcula el area y el volumen de una esfera
//materia:fundamentos de programacion unidad 3
//25/10/2015
//Abel Robles Montoya
//datos de entrada: radio
//datos de salida: area y volumen
import java.util.Scanner;
public class once {
public static void main(String[]args) {
Scanner leer=new Scanner(System.in);
double radio, area,vol;
System.out.println("ingrese el radio");
radio=leer.nextDouble();
area=4*Math.PI*Math.pow(radio,2);
vol=(4/3)*Math.PI*Math.pow(radio,3);
System.out.println("area= "+area+" volumen= "+vol);
}
}