//este programa lee un numero entero e imprime todos sus divisores
public class E12 {
public static void main(String[]args) {
System.out.println("escribe un numero");
int num=0;
String div=" ";
num=Keyboard.readInt();
for (int i=1;i<=num;i++) {
if (num%i==0)
div=div+" "+i;
}
System.out.println("los divisores son "+div);
}
}
