title prac08
.model small
.data
divisor db 3
dividendo db 47
coc db 0h,0h
residuo db 0

.code
main proc near
.startup
mov ax,47
aad
div divisor

mov coc,al

mov residuo,ah

;imprimir el resultado

mov bx,0001h
mov ah,02h

mov dl,coc
int 21h

.exit
main endp
end