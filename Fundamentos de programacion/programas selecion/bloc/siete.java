//este programa lee un numero del 1 al 10 y
//escribe el numero en letras
import java.util.Scanner;
public class Siete {
public static void main(String[]args) {
Scanner leer = new Scanner(System.in);
System.out.println("ingrese un numero del 0 al 10");
byte a;
String num="a";
a=leer.nextByte();
switch (a) {
case 0:num="cero";break;
case 1:num="uno";break;
case 2:num="dos";break;
case 3:num="tres";break;
case 4:num="cuatro";break;
case 5:num="cinco";break;
case 6:num="seis";break;
case 7:num="siete";break;
case 8:num="ocho";break;
case 9:num="nueve";break;
case 10:num="diez";break;
default :System.out.println("error");
}
System.out.println(num);
}
}