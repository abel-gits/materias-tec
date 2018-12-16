import java.util.Random;
public class SerpientesyEscaleras {
	public static void main(String[]args) {
		Random rnd = new Random();
		int l=6,dado1=0,dado2=0,c=0,uj=0;
		String d=" ",ganador=" ";
		int ndj=0;
		int a=0;
		do {
			System.out.println("escribe el numero de jugadores(2-5)");
			ndj=Keyboard.readInt();
		}
		while ((ndj<2)||(ndj>5));
		int x=ndj;
		int cjugadores[] = new int [ndj]; 
		String jugador[] = new String[ndj];
		for (int i=0;i<=ndj-1;i++) {
			System.out.println("escribe el nombre");
			jugador[i]=Keyboard.readString();
			cjugadores[i]=0;
					}
		while (cjugadores[uj]!=100) {
				System.out.println("es el turno de "+jugador[a]+" escribe cualquier cosa para lanzar los dados");
				d=Keyboard.readString();
			dado1=rnd.nextInt(l)+1;
			dado2=rnd.nextInt(l)+1;
			System.out.println("el dado 1 cayo "+dado1+" el dado 2 cayo "+dado2);
			cjugadores[a]=cjugadores[a]+dado1+dado2;
			if (cjugadores[a]>100) 
				cjugadores[a]=100-(cjugadores[a]-100);

			switch (cjugadores[a]) {
				case 3:System.out.println("caiste en la casilla 3 hay una escalera avansas hasta 39");
				cjugadores[a]=39;break;
				case 14:System.out.println("caiste en la casilla 14 hay una escalera avansas hasta 35");
				cjugadores[a]=35;break;
				case 31:System.out.println("caiste en la casilla 31 hay una escalera avansas hasta 70");
				cjugadores[a]=70;break;
				case 44:System.out.println("caiste en la casilla 44 hay una escalera avansas hasta 65");
				cjugadores[a]=65;break;
				case 47:System.out.println("caiste en la casilla 47 hay una escalera avansas hasta 86");
				cjugadores[a]=86;break;
				case 63:System.out.println("caiste en la casilla 63 hay una escalera avansas hasta 83");
				cjugadores[a]=83;break;
				case 72:System.out.println("caiste en la casilla 72 hay una escalera avansas hasta 91");
				cjugadores[a]=91;break;
				case 30:System.out.println("caiste en la casilla 30 hay una serpiente regresas a 8");
				cjugadores[a]=8;break;
				case 40:System.out.println("caiste en la casilla 40 hay una serpiente regresas a 4");
				cjugadores[a]=4;break;
				case 54:System.out.println("caiste en la casilla 54 hay una serpiente regresas a 37");
				cjugadores[a]=37;break;
				case 79:System.out.println("caiste en la casilla 79 hay una serpiente regresas a 42");
				cjugadores[a]=42;break;
				case 90:System.out.println("caiste en la casilla 90 hay una serpiente regresas a 33");
				cjugadores[a]=33;break;
				case 93:System.out.println("caiste en la casilla 93 hay una escalera regresas a 69");
				cjugadores[a]=69;break;
				case 98:System.out.println("caiste en la casilla 98 hay una serpiente regresas a 64");
				cjugadores[a]=64;break;
				default:System.out.println("caiste en la casilla "+cjugadores[a]);
			}
			if (cjugadores[a]==100)
				uj=a;

			if (x==2) {
				switch (a) {
					case 0:a=1;break;
					case 1:a=0;
				}

			}
			if (x==3) {
				switch (a) {
					case 0:a=1;break;
					case 1:a=2;break;
					case 2:a=0;
				}
			}
			if (x==4) {
				switch (a) {
					case 0:a=1;break;
					case 1:a=2;break;
					case 2:a=3;break;
					case 3:a=0;
				}
				
			}
			if (x==5) {
				switch (a) {
					case 0:a=1;break;
					case 1:a=2;break;
					case 2:a=3;break;
					case 3:a=4;break;
					case 4:a=0;
				}
				
			}
			if (cjugadores[uj]==100)
			    ganador=jugador[uj];	
		} 
		
	    System.out.println("el ganador es "+ganador);
	}
}