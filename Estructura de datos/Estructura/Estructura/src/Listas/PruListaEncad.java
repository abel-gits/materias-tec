package Listas;

public class PruListaEncad 
{
	 static ClaseLista Lista=new ClaseLista(); // Declaracion global del objeto Lista
	 
	 public static void main(String args[])
	 {
	  int op=0;
	  Lista.Inicializar(); // Inicializar la Lista Enlazada
	  do {
	      System.out.println("\n\n<<< LISTAS ENCADENADAS CON OBJETOS >>>");
	      System.out.print("\n1.- Altas");
	      System.out.print("\n2.- Bajas");
	      System.out.print("\n3.- Recorrido");
	      System.out.print("\n0.- Salir");
	      System.out.print("\nOpcion? ---> ");
	      op=Leer.datoInt();
	      
	      switch(op) {
	       case 1 : Altas();                break;
	       case 2 : Bajas();                break;
	       case 3 : Lista.Recorrido(); 		break;
	      }
	      
	  }while(op!=0);
	 }
	 
	 public static void Bajas()
	 {
	  String dato;
	  
	  System.out.println("\n<<< BAJAS >>>");
	  System.out.print("\nAnote el dato a eliminar ---> ");
	  dato=Leer.dato();
	  Lista.Eliminar(dato);
	 }
	 
	 public static void Altas()
	 {
	  String dato;
	  System.out.println("\n\n<<< ALTAS >>>");
	  System.out.print("\nAnote el dato a insertar ---> ");
	  dato=Leer.dato();
	  Lista.Insertar(dato);
	 }
	 
     /* public static void clrscr() {
	  for(int i=0;i<26;i++)
	    System.out.println(" ");
	 }*/

}
