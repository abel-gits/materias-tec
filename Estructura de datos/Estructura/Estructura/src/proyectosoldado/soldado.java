package proyectosoldado;

import Listas.ClaseNodo;

public class soldado 
{
	 static ClaseListaI Lista=new ClaseListaI(); // Declaracion global del objeto Lista
	 
	 public static void main(String args[])
	 {
	  int op=0;
	  Lista.Inicializar(); // Inicializar la Lista Enlazada
	  do {
	      System.out.println("\n\n<<< LISTAS ENCADENADAS CON OBJETOS >>>");
	      System.out.print("\n1.- Altas");
	      System.out.print("\n2.- Bajas");
	      System.out.print("\n3.- Recorrido");
	      System.out.print("\n4.- Soldado ganador");
	      System.out.print("\n0.- Salir");
	      System.out.print("\nOpcion? ---> ");
	      op=Leer.datoInt();
	      
	      switch(op) {
	       case 1 : Altas();                break;
	       case 2 : Bajas();                break;
	       case 3 : Lista.Recorrido(); 		break;
	       case 4 : ganador();              break;
	      }
	      
	  }while(op!=0);
	 }
	 
	 public static void Bajas()
	 {
		 int a=0,b=0;
		 do{
	  int dato;
	  dato=(int)(Math.random()*1000+1);
	  a=Lista.Eliminar(dato);
	  b=b+a;
		 }while(!(b==49));
	 }
	 
	 public static void Altas()
	 {
		 int num;ClaseListaI lista= new ClaseListaI();
		 int a=0,b=0;
		 do{
			 
			  num=(int)(Math.random()*1000+1);
			  a=lista.Insertar(num);
			  b=b+a;
		 }while(!(b==50));
		
	  
	 }
	 public static void ganador(){
		 System.out.println("el soldado ganador es el numero :");
		 Lista.Recorrido();
	 }
	
	 
     
}
