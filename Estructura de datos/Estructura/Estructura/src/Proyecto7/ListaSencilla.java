package Proyecto7;

public class ListaSencilla<T> {
		   private Nodo<T> Frente;
		   private Nodo<T> Fin;
		   public Nodo<T> Dr;
		   public ListaSencilla(){
		      Frente=Fin=null;
		   }
		   public Nodo<T> DameFrente() 
		   {
		      return Frente;
		   }
		   public Nodo<T> DameFin(){
		      return Fin;
		   }
		   public int length() 
		   {
		      Nodo<T> Tra=Frente;
		      int Cont=0;
		      while(Tra !=null){
		        Cont++;
		        Tra=Tra.sig;
		      }
		      return Cont;
		   }
		
		public boolean InsertaFre(T Dato)
		{
		   Nodo<T> Nuevo=new Nodo<T>(Dato);
		   if(Nuevo==null || Dato==null)
		      return false;
		   // Checar si es el primer nodo de la lista
		   if(Frente==null) 
		   {
		      Frente=Fin=Nuevo;
		   }
		   else 
		   {
		      Nuevo.sig=Frente;
		      Frente=Nuevo;
		   }
		   return true;
		}
		public boolean InsertaFin(T Dato)
		{
		   Nodo<T> Nuevo=new Nodo<T>(Dato);
		   if(Nuevo==null || Dato==null)
		      return false;
		   // Checar si es el primer nodo de la lista
		   if(Fin==null) {
		      Frente=Fin=Nuevo;
		   }
		   else {
		      Fin.sig=Nuevo;
		      Fin=Nuevo;
		   }
		   return true;
		}
		public boolean Retira(String Dato)
		{
		   Nodo<T> Tra=Frente;
		   Nodo<T> Ant=null;
		   Dr=null;
		   boolean b=false;
		   while (Tra != null)
		   {
		      if(Dato.compareTo(Tra.Info.toString())==0)
		      {
		         b=true; break;
		      }
		      Ant=Tra;
		      Tra=Tra.sig;
		   }
		   if(!b)
		      return false;
		   Dr=Tra;
		   if(Frente==Fin) {
		      Frente=Fin=null;
		      return true;
		   }
		   if(Tra==Frente) {
		      Frente=Frente.sig;
		      return true;
		   }
		   if(Tra==Fin) {
		      Fin=Ant;
		      Fin.sig=null;
		      return true;
		   }
		   Ant.sig=Tra.sig;
		   return true;
		}
		
}

	
