//este programa lee dos numeros y los suma
//materia:fundamentos de programacion unidad 3
//25/10/2015
//Abel Robles Montoya
//datos de entrada: dos numeros
/datos de salida: el resultado de la suma de los numeros

import java.util.Scanner;
public class suma {
    public static void main(String[] args) {  
//definir variables
   int num1,num2,total;
//leer datos
     Scanner leer = new Scanner(System.in); 
           System.out.println("ingrese dos numeros; ");       
           num1=leer.nextInt(); 
   num2=leer.nextInt(); 
total=num1+num2;
          System.out.println(total);
     }
}
