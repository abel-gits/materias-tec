//este programa lee nombre, edad y sexo de 10 personas e imprime
//el numero de mujeres, el promedio de edad de las mujeres y el
//nombre de la mas joven
public class E10 {
public static void main(String[]args) {
int edad=0,mujeres=0,a=150;
double prom=0;
String nombre=" ",mj=" ";
String sexo=" ";
for (int i=1;i<=3;i++) {
System.out.println("escribe el nombre");
nombre=Keyboard.readString();
System.out.println("escribe la edad");
edad=Keyboard.readInt();
System.out.println("escribe el sexo");
sexo=Keyboard.readString();
if (sexo=="mujer") {
mujeres++;
prom=prom+edad;
if (edad<a)
mj=nombre;
a=edad;
}
}
prom=prom/mujeres;
System.out.println("son "+mujeres+" mujeres"+"\n"+"el promedio de las mujeres es de "+prom+"\n"+"la mas joven es "+mj);
}
}