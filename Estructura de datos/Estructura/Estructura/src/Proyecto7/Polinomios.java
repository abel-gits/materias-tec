package Proyecto7;
import java.lang.*;

import java.util.*;

import java.io.*;

public class Polinomios
{
 
   public static void main(String arg[]) throws IOException
    {
        ListaSencilla pol1=new ListaSencilla();
        ListaSencilla pol2=new ListaSencilla();
        ListaSencilla pol3=new ListaSencilla();
        
        MetodoCaptura(pol1);
        MetodoCaptura(pol2);
        
        imprime(pol1);
        imprime(pol2);
        suma(pol1,pol2,pol3);
        imprime(pol3);

    }
   public static void MetodoCaptura(ListaSencilla Obj) throws IOException
   {   
      dato Captura; 
      while (true)
      {
         System.out.print("Base (0 Para Terminar un Polinomio) ");
         Captura=new dato(); 
         Captura.base=new Scanner(System.in).nextInt();
         if(Captura.base==0)
            break;
         System.out.print("Exponente ");   
         Captura.expo=new Scanner(System.in).nextInt();
         Obj.InsertaFre(Captura);
       }
    } 
   public static void imprime(ListaSencilla Obj)
   {
      Nodo aux=Obj.DameFrente();
      while (aux != null)
      {
          System.out.print(  ((dato) aux.Info).base +"X"+ ((dato) aux.Info).expo );
          if (aux.sig!=null)
          {
             if (  ((dato) aux.sig.Info).base >=0 )
       	      System.out.print("+");
          }      
          aux=aux.sig;         
      }
      System.out.println();
   }	
   public static void suma(ListaSencilla Obj1, ListaSencilla Obj2,ListaSencilla Obj3)
   {  dato captura;
      for(Nodo aux=Obj1.DameFrente() ; aux !=null ; aux=aux.sig)
      {
         captura=new dato();
         captura.base=((dato)aux.Info).base;
         captura.expo=((dato)aux.Info).expo;
         Obj3.InsertaFre(captura);
      }
      for (Nodo aux=Obj2.DameFrente() ; aux !=null ; aux=aux.sig)
      {
         captura=new dato();
         captura.expo=((dato)aux.Info).expo;
         captura.base=((dato)aux.Info).base;
         Nodo aux3=Obj3.DameFrente();
         while (aux3 !=null)
         { 
            if (((dato) aux3.Info).expo==captura.expo)
               break;
            aux3=aux3.sig;   
         }
         if (aux3 !=null )
            ((dato)aux3.Info).base += captura.base;
         else
         {
       	Obj3.InsertaFre(captura);
         }   
      }
   }

}
