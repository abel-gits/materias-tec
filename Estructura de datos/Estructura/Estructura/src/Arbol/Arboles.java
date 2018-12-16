package Arbol;
import Arbol.Leer;
public class Arboles 
{
	public static NodoArbol Raiz=null;
	public static int tot=0;
	
	
	public static void main(String args[])// throws IOException
	{
		String salir="N";
		System.out.println("CREACION Y RECORRIDO DE UN ARBOL BINARIO");
		System.out.println();
		do
		{
			System.out.println("Clave Articulo");
			String clave=Leer.dato();
			
			if (!NodoArbol.Busca(clave,Raiz))
			{
				System.out.println("Descripcion");
				String descrip=Leer.dato();
				System.out.println("Precio");
				float precio=Leer.datoFloat();
				if (Raiz==null) 
				{
					NodoArbol nvo=NodoArbol.CreaNodo(clave,  descrip,  precio);
					System.out.println("INSERTA NODO RAIZ: "+clave);
					Raiz=nvo;
				}
				else
				{
				
				   if (NodoArbol.InsertaABB(clave,  descrip,  precio,Raiz))
				   	   System.out.println("NODO Insertado: "+clave);		
				}
				
			}
			else
			{
				System.out.println("NODO " +clave +" ya Existe");
			}
			System.out.println("Continuar Capturando Articulos? S/N");
			salir=Leer.dato().toUpperCase(); 
		}
        while(salir.compareToIgnoreCase("N")!=0);
			
		
		System.out.println("Recorrido inorden");
		NodoArbol.inorden(Raiz);
		
		System.out.println("Recorrido preorden");
		NodoArbol.preorden(Raiz);
		
		System.out.println("Recorrido postorden");
		NodoArbol.postorden(Raiz);
		
		System.out.println(" ");
		System.out.println("BORRA UN NODO DEL ARBOL ");
		System.out.println(" ");
		System.out.print("CLAVE DE ARTICULO A BORRAR ");
		String Dato=Leer.dato();
		
		Raiz=NodoArbol.BorraABB(Raiz,Dato);
		System.out.println();
		
		System.out.println("Recorrido PREORDEN");
		NodoArbol.preorden(Raiz);
		System.out.println();
		
		System.out.println("Recorrido INORDEN");
		NodoArbol.inorden(Raiz);
		System.out.println();
		
		System.out.println("Recorrido POSTORDEN");
		NodoArbol.postorden(Raiz);
	}
	
	
}
