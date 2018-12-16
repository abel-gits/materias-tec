package Arbol;

public class NodoArbol 
{
	public String claveart;
	public String descripcion;
	public float precio;
	public NodoArbol LI;
	public NodoArbol LD;
	
	
	public NodoArbol()
	{}
	public static String c="";
	
	public static boolean InsertaABB(String clave, String des, float pre, NodoArbol nodo)
	{
		if (nodo.claveart.compareTo(clave)>0)
		{
			if (nodo.LI==null)
			{
				NodoArbol nuevo=CreaNodo(clave,  des,  pre);
				nodo.LI=nuevo;
				System.out.println("Se inserto "+clave);
				return true;
			}
			else
			{
				InsertaABB(clave,  des,  pre,nodo.LI);
			}
		}
		else
		{
			if (nodo.claveart.compareTo(clave)<0)
			{
				if (nodo.LD==null)
				{
					NodoArbol nuevo=CreaNodo(clave,  des,  pre);
					nodo.LD=nuevo;
					System.out.println("Se inserto "+clave);
					return true;		
				}
				else
				{
					InsertaABB(clave,  des,  pre,nodo.LD);
				}
			}
		}
		return false;
	}
	public static NodoArbol CreaNodo(String clave, String des, float pre)
	{
		NodoArbol nvo= new NodoArbol();
		nvo.claveart=clave;
		nvo.descripcion=des;
		nvo.precio=pre;
		nvo.LD=null;
		nvo.LI=null;
		return nvo;
	}
	public static boolean Busca(String dato, NodoArbol nodo)
	{
		if (nodo!=null)	
		{
			if (nodo.claveart.compareTo(dato)==0)
			{
				return true;
			}
			else
			{
				if (nodo.claveart.compareTo(dato)>0)
				{
					return Busca(dato,nodo.LI);
				}
				else
				{	if (nodo.claveart.compareTo(dato)<0)
					{
						return Busca(dato,nodo.LD);  
					}
				}
			}
		}
		return false;
	}
	
	public static void suma(NodoArbol nodo)
	{
		if (nodo!=null)
		{
			c=c+nodo.claveart;
			inorden(nodo.LI);
			inorden(nodo.LD);
		}
		System.out.println(c);
	}
	
	public static void total(NodoArbol nodo,NodoArbol nodo2)
	{
		if (nodo!=null && nodo2!=null)
		{
			if(nodo!=nodo2)
			{
				if(nodo.LI!=null)
					System.out.println(nodo.LI.claveart);
				if(nodo.LD!=null)
					System.out.println(nodo.LD.claveart);
			
				if(nodo2.LI!=null)
					System.out.println(nodo2.LI.claveart);
				if(nodo2.LD!=null)
					System.out.println(nodo2.LD.claveart);
			
			}
			else
			{
				System.out.println(nodo.claveart);	
				if(nodo.LI!=null)
					System.out.println(nodo.LI.claveart);
				if(nodo.LD!=null)
					System.out.println(nodo.LD.claveart);
			}
			total(nodo.LI,nodo.LD);
		}
	}
	
	public static void inorden(NodoArbol nodo)
	{
		if (nodo!=null)
		{
			inorden(nodo.LI);
			System.out.println(nodo.claveart);
			inorden(nodo.LD);
		}
	}
	
	public static void preorden(NodoArbol nodo)
	{
		if (nodo!=null)
		{
			System.out.println(nodo.claveart);
			preorden(nodo.LI);
			preorden(nodo.LD);
		}
	}
	
	public static void postorden(NodoArbol nodo)
	{
		if (nodo!=null)
		{
			postorden(nodo.LI);
			postorden(nodo.LD);
			System.out.println(nodo.claveart);
		}
	}
	
	
	public static NodoArbol BorraABB( NodoArbol nodo, String dato) 
	{
      if (nodo==null)
      {
      	 System.out.println("NO encontro ");
      	 return null;
      }
      if (nodo.claveart.compareTo(dato)==0)
        return unir(nodo.LI, nodo.LD);

      if (nodo.claveart.compareTo(dato)>0)
        nodo.LI= BorraABB( nodo.LI,dato);
      else
        nodo.LD= BorraABB( nodo.LD, dato);
        
      return nodo;
    }

   
	public static  NodoArbol unir(NodoArbol izq, NodoArbol der) 
	{
      if (izq==null)
        return der;
      if (der==null)
        return izq;
      
      NodoArbol centro= unir(izq.LD, der.LI);
      izq.LD= der;
      der.LI= centro;
      return izq;
    }
}
