title prac01
.model small
.486
.stack
.data
mensaje db "hola mundo$",0dh,0ah
.code 
main proc far
.startup
mov bx,0001h
lea dx, mensaje
mov ah, 09h
int 21h
.exit
main endp
end
