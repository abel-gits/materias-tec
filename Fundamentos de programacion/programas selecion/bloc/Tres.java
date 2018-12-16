//este programa lee un numero del 1 al 7
//e imprime el dia de la semana al que corresponde
importjava.util.Scanner;
public class Tres {
public static void main(String[]args) {
Scanner leer = new Scanner(System.in);
byte a;
System.out.println("ingrese un numero del 1 al 7");
a=leer.nextByte();
switch (a) {
case 1: System.out.println("1=lunes"); break;
case 2: System.out.println("2=martes"); break;
case 3: System.out.println("3=miercoles"); break;
case 4: System.out.println("4=jueves"); break;
case 5: System.out.println("5=viernes"); break;
case 6: System.out.println("6=sabado"); break;
case 7: System.out.println("7=domingo"); break;
default :System.out.println("numero invalido");
}
}
}