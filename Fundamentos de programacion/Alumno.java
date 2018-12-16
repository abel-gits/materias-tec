public class Alumno{

    String nombre;
    char    sexo;
    int edad;
    double calif[];


   public Alumno(String n, char s, int e double c){
        nombre = n;
        sexo = s;
        edad = e;
        c=calif;
   }

  

   public String getNombre(){
       return nombre;
   }

   public char getSexo(){
       return sexo;
   }

   public int getedad(){
       return edad;
   }
   public double getcalif(){
   return calif;
   }

   public String toString(){
        return nombre+"   "+sexo+"   "+edad+"   "+calif;
   }
}