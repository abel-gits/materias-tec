title prac07
.model small
.data
nd1 db 5h,2h,1h
nd2 db 4h,8h,4h
res db 0h,0h,0h
msg db "error$",0ah,0dh

.code
main proc near
.startup
mov al,nd1+2
sub al,nd2+2
aas
mov res+2,al

mov al,nd1+1
sbb al,nd2+1
aas
mov res+1,al

mov al,nd1
sbb al,nd2
aas
mov res,al

;imprimir resultados
mov bx,0001h
mov ah,02h

mov dl,res
add dl,30h
int 21h

mov dl,res+1
add dl,30h
int 21h

mov dl,res+2
add dl,30h
int 21h



.exit
main endp
end