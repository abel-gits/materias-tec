//este programa suma los numeros pares del 2 al 100
//e imprime su valor
public class Nueve {
public static void main(String[]args) {
int sum=0;
for (int i=2;i<=100;i++) {
if (i%2==0) 
sum=sum+i;
}
System.out.println("la suma de los primeros numeros pares del 2 al 100 es = "+sum);
}
}