//este programa lee 10 numeros e imprime la suma de ellos
public class Ocho {
public static void main(String[]args) {
int num=0,sum=0;
System.out.println("escribe 10 numeros");
for (int i=1;i<=10;i++) {
num=Keyboard.readInt();
sum=sum+num;
}
System.out.println("suma = "+sum);
}
}