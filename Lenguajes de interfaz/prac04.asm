title prac04
.model small
.486
.stack
.data
divisor db 3
coc db 0
residuo db 0

.code 
main proc far
.startup
mov ax, 47
div divisor
mov coc,al
mov residuo, ah


mov bx,0001h
mov ah,02h

mov dl,coc
add dl,30h
int 21h

.exit
main endp
end
