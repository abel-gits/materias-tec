public class Actclase {
public static void main(String[]args) {
String nombre=" ",f=" ";
int rep=0;
double prom=0,pm=0,fin=0,pe=10,calif=0;
while (pe>0) {
System.out.println("escribe el nombre");
nombre=Keyboard.readString();
f=f+" "+nombre;
prom=0;
for (int i=1;i<=5;i++) {
do {
System.out.println("escribe la calificacion "+i);
calif=Keyboard.readDouble();
}
while (!(calif>=0)&(calif<=10));
if (calif<70)
rep++;
prom=prom+calif;
f=f+" "+calif;
}
prom=prom/5;
f=f+" "+prom+" "+rep;
if ((prom>=59)&(prom<71)&(rep<3)) {
fin=fin+(fin*0.15);
f=f+" "+fin;
pm=fin*0.15;
}
if ((prom>=71)&(prom<=80)&(rep<3)) {
fin=fin+(fin*0.20);
f=f+" "+fin;
pm=fin*0.20;
}
if ((prom>=81)&(prom<=90)&(rep<3)) {
fin=fin+(fin*0.25);
f=f+" "+fin;
pm=fin*0.25;
}
if ((prom>=91)&(prom<=100)&(rep<3)) {
fin=100;
f=f+" "+fin; 
pm=100-prom;
}
if (rep>=3) {
f=f+" "+prom;
}
pe=pe-pm;
f=f+"\n";
}
System.out.println(f);
}
}

