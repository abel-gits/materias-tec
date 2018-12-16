//este programa lee nombre y edad de 20 persona e imprime 
//el nombre de la mas joven
public class E15 {
public static void main(String[]args) {
String nombre=" ",masj=" ";
int edad=0,a=150;
for (int i=1;i<=20;i++) {
System.out.println("escribe el nombre");
nombre=Keyboard.readString();
System.out.println("escribe la edad");
edad=Keyboard.readInt();
if (edad<a)
masj=nombre;
a=edad;
}
System.out.println("el mas joven es "+masj);
}
}