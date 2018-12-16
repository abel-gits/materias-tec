title prac03
.model small
include irvine32.inc
.code
main proc far
.startup
mov eax, 10000h
add eax, 40000h
sub eax, 20000h

.exit
main endp
end 