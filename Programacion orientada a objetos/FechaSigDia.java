package FP16A;
import java.util.*;
public class FechaSigDia 
{
    public static void main(String[]args)
    {
        String inDate, day, month, year;
        System.out.println("Escribe una Fecha en el siguiente Formato (DD/MM/YYYY)");
        inDate=Leer.dato();
        day=inDate.substring(0, 2);
        month=inDate.substring(3, 5);
        year=inDate.substring(6, 10);
        System.out.println("El Dia Leido es: "+day);
        System.out.println("El Mes Leido es: "+month);
        System.out.println("El A–o Leido es: "+year);
        
        int iDay = Integer.parseInt(day);
        int iMonth = Integer.parseInt(month);
        int iYear = Integer.parseInt(year);
        
        System.out.println(nextDay(iDay,iMonth,iYear));
    }
    public static String nextDay(int D,int M,int Y)
    {
    	String next="";
    	switch(M)
    	{
            case 1: case 3: case 5: case 7: case 8: case 10:
                if (D==31)
                {
                    D=1;
                    M++;
                }
                else D++; break;
                
            case 4: case 6: case 9: case 11:
                if (D==30)
                {
                    D=1;
                    M++;
                }
                else D++; break;
                
                case 2:
                int Bi=Y%4;
                if ((D==28 && Bi !=0)  || D==29)
                {
                    D=1;
                    M++;
                }
                else D++; break;
                
                case 12:
                    if (D==31)
                    {
                    	D=1;
                    	M=1;
                    	Y++;
                    }
                else D++; break;
        }
    	next=("DIA SIGUIENTE: "+((D<10)?"0"+D:D)+"/"+((M<10)?"0"+M:M)+"/"+Y);
    	return next;
    }
}
