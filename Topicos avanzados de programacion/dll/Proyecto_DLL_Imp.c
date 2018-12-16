#include <jni.h>
#include "Proyecto_DLL.h"
#include <windows.h>

JNIEXPORT void JNICALL Java_Proyecto_1DLL_limpiar(JNIEnv *env, jobject obj){
	system("cls");
}

JNIEXPORT void JNICALL Java_Proyecto_1DLL_titulo(JNIEnv *env, jobject obj, jstring titulo){
	const char *cadena = (*env)->GetStringUTFChars(env, titulo, 0);
	SetConsoleTitle(cadena);
	(*env)->ReleaseStringUTFChars(env, titulo, cadena);
}

JNIEXPORT void JNICALL Java_Proyecto_1DLL_posicion(JNIEnv *env, jobject obj, jint x, jint y){
	HANDLE manejadorSalida = GetStdHandle(STD_OUTPUT_HANDLE);
	COORD posicion;
	posicion.X = y;
	posicion.Y = x;
	SetConsoleCursorPosition(manejadorSalida, posicion);
}

JNIEXPORT void JNICALL Java_Proyecto_1DLL_cambiarColor(JNIEnv *env, jobject obj, jint color){
	HANDLE manejadorSalida = GetStdHandle(STD_OUTPUT_HANDLE);
	SetConsoleTextAttribute(manejadorSalida, color);
}