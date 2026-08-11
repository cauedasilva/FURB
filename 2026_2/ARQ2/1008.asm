.model small       ; memory model (always use "small")
.stack 100h        ; reserve 256 bytes for the stack
.data               ; data section (variables go here)
db 11h,22h,33h
alfa equ 0
beta equ 1
gama equ 2
.code               ; code section (instructions go here)
mov ax, @data     ; load the data segment address
mov ds, ax        ; set DS so we can access our variables
mov [alfa], 55h ; escrita da variável
mov [beta], 66h
mov [gama], 77h
mov bh, [alfa] ; leitura da variável
mov bh, [beta]
mov bh, [gama]
; somando:
;	inc [alfa]
;	inc [beta]
;	inc [gama]
;	jmp somando
; subtraindo:
;	dec [alfa]
;	dec [beta]
;	dec [gama]
;	jmp subtraindo
; somando:
;	add [alfa],2
;	add [beta],2
;	add [gama],2
;	jmp somando
; subtraindo:
;	sub [alfa],2
;	sub [beta],2
;	sub [gama],2
;	jmp subtraindo

; mov dx,2 ; endereço de controladora, uso geral, nesse caso será endereço de controladora
; mov al,01010101b ; é o dado que você deseja enviar para a controladora
; out dx,al ; enviando para a controladora o comando al

; mov dx,2  ; end de controladora
; piscapisca:
; mov al,01010101b ; é o dado que voce quer enviar para controladora
; out dx,al
; mov al,10101010b ; é o dado que voce quer enviar para controladora
; out dx,al
; jmp piscapisca


;mov dx,2  ; end de controladora
;piscapisca:
;mov al,00000001b ; é o dado que voce quer enviar para controladora
;out dx,al
;mov al,00000010b ; é o dado que voce quer enviar para controladora
;out dx,al
;mov al,00000100b ; é o dado que voce quer enviar para controladora
;out dx,al
;mov al,00001000b ; é o dado que voce quer enviar para controladora
;out dx,al
;mov al,00010000b ; é o dado que voce quer enviar para controladora
;out dx,al
;mov al,00100000b ; é o dado que voce quer enviar para controladora
;out dx,al
;mov al,01000000b ; é o dado que voce quer enviar para controladora
;out dx,al
;mov al,10000000b ; é o dado que voce quer enviar para controladora
;out dx,al

;mov al,01000000b ; é o dado que voce quer enviar para controladora
;out dx,al
;mov al,00100000b ; é o dado que voce quer enviar para controladora
;out dx,al
;mov al,00010000b ; é o dado que voce quer enviar para controladora
;out dx,al
;mov al,00001000b ; é o dado que voce quer enviar para controladora
;out dx,al
;mov al,00000100b ; é o dado que voce quer enviar para controladora
;out dx,al
;mov al,0000010b ; é o dado que voce quer enviar para controladora
;out dx,al
;jmp piscapisca

;mov dx,2 
;repete_ciclo:
;mov al,00000001b
;mov cl,8
;rotate_left:
;out dx,al
;rol al,1
;dec cl
;cmp cl,0
;jne rotate_left

;mov al,10000000b
;mov cl,8
;rotate_right:
;out dx,al
;ror al,1
;dec cl
;cmp cl,0
;jne rotate_right
;jmp repete_ciclo

;le_escreve:
;mov dx,1
;in al,dx ; faz a leitura da controladora do teclado e joga o valor em al, input
;mov dx,2 ; acessa controladora de leds
;out dx,al ; escreve na controladora de leds o que foi lido da controladora do teclado
;jmp le_escreve

mov cx,1234h
push cx ; salva 1234h na pilha, stack

hlt
end                ; end of source file
