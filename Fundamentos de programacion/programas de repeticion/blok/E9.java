//este programa lee el nombre y sexo de 10 personas 
//e imprime cuantos son hombres o mujeres
public class E9 {
public static void main(String[]args) {
int m=0,h=0;
for (int i=1;i<=10;i++) {
System.out.println("escribe el nombre");
String nombre=Keyboard.readString();
System.out.println("escribe el sexo");
String sexo=Keyboard.readString();
switch (sexo) {
case "mujer": m++;break;
case "hombre" : h++;break;
}
}
System.out.println(m+" mujeres y "+h+" hombres");
}
}