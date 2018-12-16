
import java.util.Scanner;




/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Diego Mendez
 */
public class Examen {
    public static void main(String arg[]){
        Scanner leer= new Scanner(System.in);
        double r1=0;
        double r2=0;
        int p=0;
        double decimal=0;
        double[]numeros=new double[50];
        
        System.out.println("Inserte R1, numero de 4 digitos:");
        r1=leer.nextInt();
        System.out.println("Inserte R2, numero de 4 digitos:");
        r2=leer.nextInt();
        
        for (int i = 0; i < 50; i++) {
            System.out.println("R1: "+r1);
                System.out.println("R2: "+r2);

            String semillaCuadrada=String.valueOf(r1 * r2);
		double nuevaSemilla;
		String aux;
                
                
                if(semillaCuadrada.length()<10)
			for(int j=semillaCuadrada.length(); j<10;j++)
				semillaCuadrada='0'+semillaCuadrada;
		   
		aux=semillaCuadrada.substring(2,6);
		nuevaSemilla=Double.valueOf(aux);
                decimal=nuevaSemilla/10000;
                numeros[i]=decimal;
                r1=r2;
                r2=(double)(nuevaSemilla);
                System.out.println("R1: "+r1);
                System.out.println("R2: "+r2);
                
             
                
                
                
                
                 // System.out.println(semillaCuadrada);
		
            
          
            
            
            
            
            
        }
        
                double suma= 0;
                double media=0;
                for(int j=0; j<50; j++) {
                    
                suma=suma+numeros[j];
                   
                    

                }
                media=suma/50;
                System.out.println("La media es: "+media);
        
        
        
        
    }

    
}
