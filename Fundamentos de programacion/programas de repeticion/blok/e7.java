//este programa lee un numero del 0 al 10 e imprime su
//tabla de multriplicar del 0 hasta el numero leido
public class e7 {
public static void main(String[]args) {
System.out.println("escribe un numero");
int a=Keyboard.readInt();
for (int i=0;i<=a;i++)
System.out.println(a+"*"+i+"="+a*i);
}
}