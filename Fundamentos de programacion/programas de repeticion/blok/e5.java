//este programa lee un numero del 0 al 10 
//y obtenga su factorial
public class e5 {
public static void main(String[]args) {
int n=0,f=0;
System.out.println("escribe un numero del 0 al 10");
n=Keyboard.readInt();
f=n;
if (n<0||n>10)
System.out.println("error");
else  {
for (int i=n-1;i>1;i--)
f=f*i;
System.out.println("el factorial es "+f);
}
}
}


