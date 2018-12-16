;Prac02
;Proposito: Lee y muestra un mensaje

TITLE   PRAC02
.MODEL SMALL
.486
.STACK
.DATA
MENSAJE1 DB "Cualquier mensaje"
LM2 DB 20
MENSAJE2 DB 20 DUP('$')

.CODE
MAIN PROC  FAR
.STARTUP
;Preguntar para pedir el mensaje
MOV BX, 0001H  ;peticion para leer caracter
LEA DX, MENSAJE1  ;cargar la direccion de la indicacion
MOV AH, 09H   ;visalisacion de una cadena de caracteres
INT 21H
;Leer el mensaje
MOV BX, 000h     ;
LEA DX, LM2
MOV AH, 0AH      ;lee una cadena
INT 21H
;Regresar el carro
MOV DL, 0DH   ;registra un enter
MOV AH, 02H   ;envia a la salida el registro dl
INT 21H

;Avance de linea
MOV DL, 0AH   ;lee una cadena
MOV AH, 02H
INT 21H

;Desplegar el mensaje en el teclado
MOV BX, 0001H 
LEA DX, MENSAJE1
MOV AH, 09H
INT 21H


.EXIT
MAIN ENDP
END