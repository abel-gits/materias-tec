public class Siete {
	public static void main(String[]args) {
			String nombre[] ={"luis","maria","pedro","juan","veronica","silvia","german","manuel","vanesa","luz"};
			String f=" ";
	        String t[] ={"6674589122","6689645723","669089343","6698715378","668257229","6678771233","667543257","66998029","6654340980","667586780"};
	        System.out.println("escribe el nombre de la persona para imprimir su telefono escriba fin para terminar el programa");
	        String n=" ";
	        while  (f!="o") {
	        	n=Keyboard.readString();
	        	 switch (n) {
	        	case "luis":System.out.println(t[0]);break;
	        	case "maria":System.out.println(t[1]);break;
	        	case "pedro":System.out.println(t[2]);break;
	        	case "juan":System.out.println(t[3]);break;
	        	case "veronica":System.out.println(t[4]);break;
	        	case "silvia":System.out.println(t[5]);break;
	        	case "german":System.out.println(t[6]);break;
	        	case "manuel":System.out.println(t[7]);break;
	        	case "vanesa":System.out.println(t[8]);break;
	        	case "luz":System.out.println(t[9]);break;
	        	case "fin":f="o";break;
	        	default:System.out.println("ese nombre no esta en el arreglo");
	           }
	        }
	       

	

	}
}