public class Seis {
	public static void main(String[]args) {
		Alumnos grupo[] = new Alumnos[5];
		String nombre=0;
		double calificacion=0;
		char sexo=' ';
		for (int i=0;i<=4;i++) {
			nombre=Keyboard.readString();
			sexo=Keyboard.readChar();
			calificacion=Keyboard.readDouble();
			grupo[i]=Alumno();
		}
		System.out.println(Alumno.getNombre);
	}
}