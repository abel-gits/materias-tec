import java.util.*;
public class orden { 
	public static void main(String[]args) {
		int a[] = new int [5];
		System.out.println("escribe 50 numeros");
		for (int i=0;i<=4;i++) 
			a[i]=Keyboard.readInt();
		 
		Arrays.sort(a);
		
			System.out.println(Arrays.toString(a));
	}
}
	

