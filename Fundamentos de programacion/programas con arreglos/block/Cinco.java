public class Cinco {
	public static void main(String[]args) {
		int b=0;
		int a[] = new int [5];
		System.out.println("escribe 50 numeros");
		for (int i=0;i<=4;i++) {
			a[i]=Keyboard.readInt();
		} 
		for (int r=1;r<=4;r++) {
				for (int d=0;d<=3;d++) {
					if (a[d]>a[d+1]) {
				            b=a[d+1];
					    a[d+1]=a[d];
				            a[d]=b;
				       
				    }
				     
							}
					
		}

		
		for (int j=0;j<=4;j++)
			System.out.println(a[j]);
	}
}