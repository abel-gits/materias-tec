//este programa cuenta los numeros aleatorios(0 al 10) que hay en un arreglo
import java.util.Random;
public class abc {
public static void main(String[]args) {
int l=11;
int c=0,u=0,d=0,t=0,cu=0,ci=0,s=0,si=0,o=0,n=0,di=0;
Random rnd = new Random();
int a[] = new int [500];
for (int i=0;i<=500-1;i++) {
a[i]=rnd.nextInt(l);
if (a[i]==0)
c++;
else 
if (a[i]==1)
u++;
else 
if (a[i]==2)
d++;
else 
if (a[i]==3)
t++;
else 
if (a[i]==4)
cu++;
else 
if (a[i]==5)
ci++;
else
if (a[i]==6)
s++;
else 
if (a[i]==7)
si++;
else
if (a[i]==8)
o++;
else
if (a[i]==9)
n++;
else 
if (a[i]==10)
di++;
}
System.out.println("cantidad de");
System.out.println("0"+"="+c+"\n"+"1"+"="+u+"\n"+"2"+"="+d+"\n"+"3"+"="+t+"\n"+"4"+"="+cu+"\n"+"5"+"="+ci+"\n"+"6"+"="+s+"\n"+"7"+"="+si+"\n"+"8"+"="+o+"\n"+"9"+"="+n+"\n"+"10"+"="+di);
}
}

