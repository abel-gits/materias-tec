//este programa calcula el doble, triple y cuadruple de un numero
//materia:fundamentos de programacion unidad 3
//25/10/2015
//Abel Robles Montoya
//datos de entrada: un numero
//datos de salida:el doble, triple y cuadruple del numero
import java.util.Scanner;
public class cuatro {
public static void main(String[]args) {
Scanner leer = new Scanner(System.in);
System.out.println("ingrese un numero");
int num,doble,triple,cuadruple;
num=leer.nextInt();
doble=num*2;
triple=num*3;
cuadruple=num*4;
System.out.println("doble= "+doble+" triple= "+triple+" cuadruple= "+cuadruple);
}
}