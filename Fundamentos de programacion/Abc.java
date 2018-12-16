import java.util.Arrays;
public class Abc {
	public static void main(String[]args) {
		String a[] = new String[3];
System.out.println("escribe tres string");
		for (int i=0;i<=2;i++) 
			a[i]=Keyboard.readString();
		 
		Arrays.sort(a);
		for (int i=0;i<=2;i++)
	System.out.println(a[i]);
	}
}