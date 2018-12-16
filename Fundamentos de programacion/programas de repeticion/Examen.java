//Abel Robles Montoya
public class Examen {
public static void main(String[]args) {
float pre=5000000;
String nomf=" ",estc=" ",noap=" ";
int prom=0,eps=0,ebu=0,apo=0,becas=0;
while (pre>0) {
 System.out.println("escribe el nombre de la familia");
 nomf=Keyboard.String();
 System.out.println("ingresa el promedio");
 prom=Keyboard.readInt();
 System.out.println("escribe el estado civil");
 estc=Keyboard.readString();
 System.out.println("escribe el numero de estudiantes en primaria o secundaria");
 eps=Keyboard.readInt();
 System.out.println("escribe el numero de estudiantes en bachilerato o universidad");
 ebu=Keyboard.readInt();
 if (prom>1000) {
  noap=noap+nomf+"  "+"ingreso promedio por mienbro"+ " "+prom;
  else {
   if (estc!='c')
   apo=1000;
   if (eps>0) {
   apo=apo+(eps*500);
   becas=eps*500
   }
   if (ebu>0) {
   apo=apo+(ebu*800)
   becas=becas+(ebu*800)
   if (apo>300) 
   apo=3000;
   becas=apoyo-becas
  
   

