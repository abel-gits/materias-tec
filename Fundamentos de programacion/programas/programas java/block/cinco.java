//este programa calcula la suma, el producto, la diferencia, el cociente y el módulo  de dos numeros flotantes
//materia:fundamentos de programacion unidad 3
//25/10/2015
//Abel Robles Montoya
//datos de entrada: dos numeros
//datos de salida: la suma, el producto, la diferencia, el cociente y el módulo de los dos numeros 
import java.util.Scanner;
public class cinco {
public static void main(String[]args) {
Scanner leer = new Scanner(System.in);
System.out.println("ingrese dos numeros flotantes");
float num1,num2,suma,producto,dif,cociente,modulo;
num1=leer.nextFloat();
num2=leer.nextFloat();
suma=num1+num2;
producto=num1*num2;
dif=num1-num2;
cociente=num1/num2;
modulo=num1%num2;
System.out.println("suma= "+suma+" producto= "+producto+" diferencia= "+dif+" cociente= "+cociente+" modulo= "+modulo);
}
}