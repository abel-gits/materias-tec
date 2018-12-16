title prac09
model small
.data
 msj db  'Esta es na llamada a un procedimiento que imprime este mensaje$',0ah,0dh
 
.code
main proc far
.startup
call imprime  
main endp
.exit


imprime proc near     
mov bx,0001h
lea dx, msj
mov ah, 09h
int 21h


mov bx,0001h
mov ah,02h

mov dl,7h
int 21h
ret 
imprime endp

end
 