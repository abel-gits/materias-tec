public class ejercicio {
public static void main(String[]args) {
String nombre=" ",n=" ";
int calif=0;
for (int i=1;i<=3;i++) {
float prom=0;
int rep=0;
System.out.println("escribe el nombre");
nombre=Keyboard.readString();
n=n+i+" "+nombre+"\n";
for (int d=1;d<=5;d++) {
do {
System.out.println("escribe la calificacion "+d);
calif=Keyboard.readInt();
}
while ((calif<0)||(calif>100));
prom=prom+calif;
if (calif<5)
rep++;
n=n+calif+"   ";
}
n=n+"  "+prom/5+" "+" "+rep+"\n";
}
System.out.println(n);
}
}