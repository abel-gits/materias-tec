//este programa lee medidas volumetricas en pies cubicos y las transforma en galones litros yardas bushels y barriles
//materia:fundamentos de programacion unidad 3
//27/10/2015
//Abel Robles Montoya
//datos de entrada: medidas en pies
//datos de salida: el equibalente en galones litros yardas bushels y barriles
import java.util.Scanner;
public class veintitres {
public static void main(String[]args) {
Scanner leer = new Scanner(System.in);
double p,g,l,ya,bu,ba;
System.out.println("ingrese la medida en pies");
p=leer.nextDouble();
g=p*7.8;
l=p*28.316;
ya=p/27;
bu=p*0.8036;
ba=g/31.5;
System.out.println("son "+g+" galones "+l+" litros "+ya+" yardas "+bu+"bushels "+ba+" barriles");
}
}

