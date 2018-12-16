//este programa lee un numero e imprime su
//tabla de multriplicar del 0 hasta el 12
public class e6 {
public static void main(String[]args) {
System.out.println("escribe un numero");
int a=Keyboard.readInt();
for (int i=0;i<=12;i++)
System.out.println(a+"*"+i+"="+a*i);
}
}