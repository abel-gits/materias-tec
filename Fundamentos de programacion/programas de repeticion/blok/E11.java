//este programa lee el nombre de 10 persona e imprime cuantos
//empiezan con A
public class E11 {
public static void main(String[]args) {
String nombre=" ";
int a=0;
for (int i=1;i<=10;i++) {
System.out.println("escribe el nombre");
nombre=Keyboard.readString();
if (nombre.charAt(0)=='A')
a++;
}
System.out.println("el numero de nombres que empiezan con A es "+a);
}
}