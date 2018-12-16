import java.util.Random;
public class Act {
public static void main(String[]args) {
Random  rnd = new Random(500);
int pares=0,primos=0;
double prom=0;
System.out.println("escribe el tamaño del arreglo");
int t =Keyboard.readInt();
int a[] = new int [t];
for (int i=0;i<=i-1;i++) {
a[i]=rnd.nextInt();
prom=prom+a[i];
if (a[i]%2==0)
pares++;
}
prom=prom/t;
for (int c=0;c<=t-1;c++) {
int div=0;
for (int b=1;b<=a[c];b++) {
if (a[c]%b==0)
div++;
if (div==2)
primos++;
}
}
int mp=0;
for (int d=0;d<=t-1;d++) {
if (a[d]>prom)
mp++;
}
System.out.println("son "+pares+" numeros pares"+"\n"+"son "+primos+" numeros primos"+"\n"+"el promedio es de "+prom+"\n"+"son "+mp+" numeros mayores que el promedio");
}
}