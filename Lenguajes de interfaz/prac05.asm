title prac05
.model small
.data
nd1 db 5h,2h,1h
nd2 db 4h,8h,4h
res db 0h,0h,0h,0h

.code
main proc near
.startup
mov al,nd1+2
add al,nd2+2
aaa
mov res+3,al 
mov al,nd1+1
adc al,nd2+1
aaa
mov res+2,al
mov al,nd1
adc al,nd2
aaa
mov res+1,al
adc res,0
;imprimir el resultado
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


mov dl,res+3
add dl,30h
int 21h


.exit
main endp
end