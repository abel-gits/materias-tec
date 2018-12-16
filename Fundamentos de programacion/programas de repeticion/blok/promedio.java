//este programa lee el nombre y calificaciones e imprime
//su promedio y materias reprobadas
public class promedio {
public static void main(String[]args) {
String nombre= " ",r=" ";
int calif=0,rep=0;
double prom=0;
for (int i=1;i<=3;i++) {
prom=0;
rep=0;
System.out.println("escribe el nombre");
nombre=Keyboard.readString();
r=r+i+"  "+nombre;
for (int n=1;n<=5;n++) {
System.out.println("escribe la calificasion "+n);
calif=Keyboard.readInt();
if (calif<70)
rep++;
r=r+"    "+calif;
prom=prom+calif;
}
r=r+"  "+prom/5+"  "+rep+"\n";
}
System.out.println(r);
}
}