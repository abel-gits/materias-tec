//este programa obtiene el numero de letras 
//minusculas que contiene un string
public class e4 {
public static void main(String[]args) {
System.out.println("escribe un string");
String a=" ";
int suma=0,l=0;
a=Keyboard.readString();
l=a.length();
for (int i=0;i<=l-1;i++) {
if ((a.charAt(i)=='a')||(a.charAt(i)=='b')||(a.charAt(i)=='c')||(a.charAt(i)=='d')||(a.charAt(i)=='e')||(a.charAt(i)=='f')||(a.charAt(i)=='g')||(a.charAt(i)=='h')||(a.charAt(i)=='i')||(a.charAt(i)=='j')||(a.charAt(i)=='k')||(a.charAt(i)=='l')||(a.charAt(i)=='m')||(a.charAt(i)=='n')||(a.charAt(i)=='ñ')||(a.charAt(i)=='o')||(a.charAt(i)=='p')||(a.charAt(i)=='q')||(a.charAt(i)=='r')||(a.charAt(i)=='s')||(a.charAt(i)=='t')||(a.charAt(i)=='u')||(a.charAt(i)=='v')||(a.charAt(i)=='w')||(a.charAt(i)=='x')||(a.charAt(i)=='y')||(a.charAt(i)=='z'))
suma++;
}
System.out.println("el string "+a+" contiene "+suma+" letras minusculas");
}
}
