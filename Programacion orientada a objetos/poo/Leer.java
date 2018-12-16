import java.io.*;
public class Leer
{
	public static boolean error;
  public static String dato()
  {
    String sdato = "";
    try
    {
      // Definir un flujo de caracteres de entrada: flujoE
      InputStreamReader isr = new InputStreamReader(System.in);
      BufferedReader flujoE = new BufferedReader(isr);
      // Leer. La entrada finaliza al pulsar la tecla Entrar
      sdato = flujoE.readLine();
    }
    catch(IOException e)
    {
      System.err.println("Error: " + e.getMessage());
    }
    return sdato; // devolver el dato tecleado
  }
  
  public static byte datoByte()
  {
  	try
    {
      error=false;
      return Byte.parseByte(dato());
    }
    catch(NumberFormatException e)
    {   
    	 error=true;
    	return Byte.MIN_VALUE; // valor más pequeño
    }
   }
  
  public static short datoShort()
  {
    try
    {
      return Short.parseShort(dato());
    }
    catch(NumberFormatException e)
    {
      return Short.MIN_VALUE; // valor más pequeño
    }
  }
  
  public static int datoInt()
  {
    try
    {
    	error=false;
    	int val=Integer.parseInt(dato());
    	if (val<-32768||val>32767)
    		error=true;
      return val;
    }
    catch(NumberFormatException e)
    {
      return Integer.MIN_VALUE; // valor más pequeño
    }
  }
  
  public static long datoLong()
  {
    try
    {
      return Long.parseLong(dato());
    }
    catch(NumberFormatException e)
    {
      return Long.MIN_VALUE; // valor más pequeño
    }
  }
  
  public static float datoFloat()
  {
    try
    {
    	error=false;
      Float f = new Float(dato());
      return f.floatValue();
    }
    catch(NumberFormatException e)
    {
    error=true;
      return Float.NaN; // No es un Número; valor float.
    }
  }
  
  public static double datoDouble()
  {
    try
    {
    	error=false;
      Double d = new Double(dato());
      return d.doubleValue();
    }
    catch(NumberFormatException e)
    {
    	error=true;
      return Double.NaN; // No es un Número; valor double.
    }
  }
}
