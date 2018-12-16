//este programa lee x numeros enteros hasta que el
//numero leido sea 0
public class E16 {
public static void main(String[]args) {
int num=0;
System.out.println("escribe un numero");
num=Keyboard.readInt();
while (num!=0) 
num=Keyboard.readInt();
}
}