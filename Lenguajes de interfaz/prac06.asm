title prac06
.model small
.data 
ne1 db 56h,43h,21h
ne2 db 45h,68h,54h
res db 0h,0h,0h,0h

.code
main proc near
.startup
mov al,ne1+2
add al, ne2+2
daa
mov res+3,al

mov al,ne1+1
adc al, ne2+1
daa
mov res+2,al

mov al,ne1
adc al,ne2
daa
mov res+1,al
adc res,0

;imprimir el resultado
mov bx,0001h
mov ah,02h
;imprecion 0


mov dl,res
add dl,30h
int 21h

;imprecion 1
mov al,res+1
and al,11110000b
rol al,4

mov dl,al
add dl,30h
int 21h

mov al,res+1
and al,00001111b

mov dl,al
add dl,30h
int 21h
;imprecion 2
mov al,res+2
and al,11110000b
rol al,4

mov dl,al
add dl,30h
int 21h

mov al,res+2
and al,00001111b

mov dl,al
add dl,30h
int 21h

;imprecion 3
mov al,res+3
and al,11110000b
rol al,4

mov dl,al
add dl,30h
int 21h

mov al,res+3
and al,00001111b

mov dl,al
add dl,30h
int 21h


.exit
main endp
end