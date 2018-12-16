package Pilas;
import java.lang.*;

import Proyecto7.Leer;

import java.io.*;

	
class evaluapost

{	
 public static void main (String args[])
  { 
   
    String expr = new String("");
   
    char ch;
   
    int max,a,b; 
    System.out.print("Dame la Expresion en Postfijo : ");
    expr =Leer.dato();
    max=expr.length();
    pilasint obj1 = new pilasint(max);
    // pilag obj1 = new pilag(max);
    System.out.println();
    System.out.println();
    System.out.print("El valor de la expresion Postfijo es :");
   
    expr+=')'; // inserta ')' al final de Expr
    System.out.println(expr);
    System.out.println(expr.length());
    for (int i=0;i<expr.length()-1;i++)
     {
      ch=expr.charAt(i);
      System.out.println("tomo el : "+ch);
      switch (ch) 
       {
 
    	case '*' :
        case '/' :
        case '+' : 
        case '-' : 
        case '^' : obj1.pop();
                   a = obj1.dret;
                   System.out.println(a);
 	   	  	 	   obj1.pop();
 	   	  	 	   b = obj1.dret;
                    
                   System.out.println(b);
                   obj1.push(evalua(a,b,ch)); 
                   break;   
        default : 
                  System.out.println("inserto el : "+ch);
                  obj1.push(convierte(ch));
                  break;
        } 	         
 	 } 	       	    	                     
 	  obj1.pop();
 	   System.out.println(obj1.dret);	  	 
  } 	 	   
     
 
 public static int evalua (int a, int b, char ch)
 {
 	int aux = 1;
 	switch (ch)
 	 {
 	 	case '^' : for(int i= 1;i<=b-1;i++)
 	 	           aux+=a*a;
 	 	           break;
 	 	case '*' : aux=b*a;
 	 	           break;
 	 	
 	 	case '/' : aux = b/a;
 	 	           break;
 	 	case '+' : aux=b+a;
 	 	           break;
 	 	case '-' : aux = b-a;
 	 	           break;
 	 }
 	 return aux;	
  }
  
  public static int convierte (char ch)
 {
 	int aux=0;
 	switch (ch)
 	 {
 	 	case '1' :aux=1;
 	 	           break;
 	 	case '2' : aux=2;
 	 	           break;
 	 	case '3' : aux=3;
 	 	           break;
 	 	case '4' : aux=4;
 	 	           break;
 	 	case '5' : aux=5;
 	 	           break;
 	 	case '6' : aux=6;
 	 	           break;
 	 	case '7' : aux=7;
 	 	           break; 
 	    case '8' : aux=8;
 	 	           break;
 	 	case '9' : aux=9;
 	 	           break;                                          
 	 }
 	 return aux;	
  }
}
 
 