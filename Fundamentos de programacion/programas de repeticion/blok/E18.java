//este programa lee un muero entero e imprime verdadero si es par
//y falso si es impar
public class E18 {
public static void main(String[]args) {
int num=0;
System.out.println("escribe un numero");
num=Keyboard.readInt();
if (num%2==0)
System.out.println("verdadero");
else 
System.out.println("falso");
}
}