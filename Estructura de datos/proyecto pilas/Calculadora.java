package Pilas;
import java.util.Stack;
public class Calculadora  {
	public static void main(String[] args) {
		String a[]=new String[10];
		crear(a);
		String[] balanceadas = new String[10];
		String nobalanceadas[] = new String[10];
		leer_expresiones(a,balanceadas,nobalanceadas);
		String b[]= new String[10];
		for (int i = 0; i < 10; i++) {
			b[i]=balanceadas[i];
		}
		reporta_evaluacion(balanceadas,nobalanceadas,b);
	}
	public static void crear(String a[]){
		System.out.println("Escribe 10 expreciones en infijo");
		for (int i = 0; i < 10; i++) {
			do {
				a[i]=Leer.dato();
			} while (a[i].equals(""));
		}
	}
	public static void leer_expresiones(String a[],String balanceadas[],String nobalanceadas[]){
		boolean b=true;int c=0,d=0;
		for (int i = 0; i < 10; i++) {
			b=verifica(a[i]);
			if (b==true) {
				balanceadas[c]=a[i];c++;
			}else {nobalanceadas[d]=a[i];d++;}
		}
	}
	public static boolean verifica(String a){
		Stack<String> pila = new Stack<String>();       int i = 0;
        while (i<a.length()) { 
            if(a.charAt(i)=='('||a.charAt(i)=='['||a.charAt(i)=='{') {pila.push("(");}                                
            else if  (a.charAt(i)==')'||a.charAt(i)==']'||a.charAt(i)=='}') {  
                        if (!pila.empty()){ pila.pop(); } 
                        else { pila.push(")"); break; } 
            }
            i++;
        }
        if(pila.empty()){ return true; } else { return false; }
	}
	public static void reporta_evaluacion(String balanceadas[],String nobalanceadas[],String b[]){
		int a=0;String c=null;
		int resultado[]= new int[10];
			for (int i = 0; i < 10; i++) {
				if (balanceadas[i]!=null) {
					c=convierte_infpost(balanceadas[i]);
					balanceadas[i]=c;
					if (balanceadas[i].length()>1) {
						a=evalua_post(balanceadas[i]);
						resultado[i]=a;
					}else resultado[i]=Integer.parseInt(balanceadas[i]);
					
				}
		}
			
			System.out.println("RESULTADO DE EVALUACION DE EXPRESIONES CORRECTAS\n\nEXPRESION\t\t\tRESULTADO");
			System.out.println("----------\t\t\t----------");
			for (int i = 0; i < 10; i++) {
				if (b[i]!=null) {
					System.out.println(b[i]+"\t\t\t\t"+resultado[i]);
				}
				
			} 
			System.out.println("\n\n");
			System.out.println("RESULTADO DE EVALUACION DE EXPRESIONES INCORRECTAS\n\nEXPRESION");
			System.out.println("----------");
			for (int i = 0; i < 10 ; i++) {		
				if(nobalanceadas[i]==null){}
					else
						System.out.println(nobalanceadas[i]);
			}
			
			
			
			
	}
	public static String convierte_infpost(String balanceadas){
		String expr = new String("");
	    String exprpost = new String("");
	    char ch;
	    int max;
	    expr =balanceadas;
	    if (expr.length()>2) {
	    	max=expr.length();
		    operapilaschar obj1 = new operapilaschar(max);
		    obj1.push('('); 
		    expr+=')'; 
		    for (int i=0;i<expr.length();i++)
		     {
		      ch=expr.charAt(i);
		      switch (ch) 
		       {
		 	case '(': obj1.push(ch);
		 	  	    break;
		  	case '*' :
		        case '/' :
		        case '+' : 
		        case '-' :
		        case '^' :
		 	  	  	 	      
		 		while ((precedencia(obj1.pila[obj1.tope])>=precedencia(ch) && obj1.pila[obj1.tope]!='('))
		 	  	   {
		 	  	    obj1.pop();
		 	  	    exprpost+=obj1.dret;
		 	  	   } 
		 	  	   obj1.push(ch);
		                break;               
		 	case ')': while (obj1.pila[obj1.tope] != '(')
		 	          {
		 	  	    obj1.pop();
		 	  	    exprpost+=obj1.dret;
		 	  	  }
		 	  	   obj1.pop();
		 	  	  break;       
		 	  	  default : exprpost+=ch;
		    } 	       	    	                     
		 	  	  	 
		  } 	 	   
		  while (!(obj1.pila_Vacia(obj1.tope)))
		    {
		      obj1.pop();	        
		      if (obj1.dret!= '(')
		      exprpost+=obj1.dret;
		}
		  balanceadas=exprpost;
	    } 	 
	
	  return balanceadas;
	  
	} 	
	public static int evalua_post(String balanceadas){
		String expr = new String("");
	    char ch;
	    int max,a,b; 
	    expr =balanceadas;
	    max=expr.length();
	    	operapilasint obj1 = new operapilasint(max);
	 	   
		    expr+=')';
		    for (int i=0;i<expr.length()-1;i++)
		     {
		      ch=expr.charAt(i);
		      
		      switch (ch) 
		       {
		 
		    	case '*' :
		        case '/' :
		        case '+' : 
		        case '-' :
		        case '^' : obj1.pop();
		                   a = obj1.dret;
		                  
		 	   	  	 	   obj1.pop();
		 	   	  	 	   b = obj1.dret;
		                    
		                   
		                   obj1.push(evalua(a,b,ch)); 
		                   break;   
		        default : 
		                 
		                  obj1.push(convierte(ch));
		                  break;
		        } 	         
		 	 } 	       	    	                     
		 	  obj1.pop();
		 	 return obj1.dret;
	   
		 	
		
	    
	 	   
	  } 	 	   
	
	public static int precedencia(char ch)
	 {
	 	int aux = 0;
	 	switch (ch)
	 	 {
	 	 	case '^' : aux = 4;
	 	 	           break;
	 	 	case '*' : case '/' : aux = 3;
	 	 	           break;
	 	 	case '+' : case '-' : aux = 2;
	 	 	           break;
	 	 	case '(' : aux = 1;
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
	
}