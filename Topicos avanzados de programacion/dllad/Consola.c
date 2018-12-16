#include <jni.h>
#include "Consola.h"
#include <stdlib.h>
#include <windows.h>

JNIEXPORT void JNICALL Java_Consola_limpiarPantalla(JNIEnv *env, jclass object)
{
	system( "cls" );
}

JNIEXPORT void JNICALL Java_Consola_posicionarCursor(JNIEnv *env, jclass object, jint renglon, jint columna)
{
	HANDLE hStdout = GetStdHandle(STD_OUTPUT_HANDLE);
	COORD posicion;
	posicion.X = columna;
	posicion.Y = renglon;

	SetConsoleCursorPosition(hStdout, posicion);
}


