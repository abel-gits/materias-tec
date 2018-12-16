//este programa lee nombre y sexo de diez personas y
//imprime el numero de mujeres
public class e8 {
public static void main(String[]args) {
int m=0;
for (int i=1;i<=10;i++) {
System.out.println("escribe el nombre");
String nombre=Keyboard.readString();
System.out.println("escribe el sexo");
String sexo=Keyboard.readString();
switch (sexo) {
case "mujer": m++;
}
}
System.out.println(m+" mujeres");
}
}