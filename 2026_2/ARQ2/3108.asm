; define o tamanho máximo da string
MAXSIZE EQU 32 
.model small
.stack 256.
.data
mensagem db "JOGO DA FORCA 1.0",13,10,"ENTRE COM UMA PALAVRA",13,10,"$"
palavra db "                                ","$"
tracos  db "--------------------------------","$"
mensagemletra db 13,10,"ENTRE COM UMA LETRA",13,10,"$"
contadordeteclas db 0
.code
mov si, offset mensagem
call printstring
mov si, offset palavra
call lestring
CALL PULALINHA
;mov si, offset palavra
;call printstring
call pulalinha
LEIMPRIME:
mov si, offset tracos
call printstring
mov si, offset mensagemletra
call printstring
CALL PULALINHA
;AQUI VOCE DEVE DIGITAR UMA LETRA A SER PROCURADA NA STRING PALAVRA
AGUARDALETRA:
IN AL, 8 ; ESTA ROTINA LE UM BYTE DO TERMINAL
CMP AL, 0 ; OPA, AINDA NADA FOI DIGITADO!!!!!!!!!
JE AGUARDALETRA ; FICA NO LOOP ENTAO...
;CHEGUEI NESTE PONTO, ENTAO VOCE DIGITOU ALGO :)
;AL É O CARACTER DIGITADO
CALL PROCURACARACTER
JMP LEIMPRIME

; previamente coloque si para apontar a string sendo lida (memoria)
lestring:
	push ax
	mov contadordeteclas,0
	mov di, offset tracos
aguardatecla:
	IN AL, 8 ; ler a tecla digitada, se nada foi digitado, retorna NULL
	cmp al,0 ; se retornou null, nada foi digitado
	je aguardatecla
	cmp al, 13 ; compara se tecla digitada = ENTER = CR (tabela ascii)
	je finalizalestring
	cmp al, 8  ; compara se tecla = backspace
	je tratabackspace
	;pegar a tecla digitada e guardar na memoria apontada por si
	cmp contadordeteclas, MAXSIZE ; compara se atingiu MAXSIZE
	je aguardatecla ; se atingiu maximo,  aguarda tecla
	mov [si],al ; guarda tecla digitada
	inc si ; próxima posição que guarda caracter
	inc di ; próxima posição de traco
	out 8, al ; aproveite e faça o ECHO
        inc contadordeteclas
	jmp aguardatecla
finalizalestring:
	cmp contadordeteclas,0 ; não finalize se não há teclas digitadas
	je aguardatecla
	mov [si],"$"
	mov [di],"$"
	pop ax
	ret
tratabackspace:
	cmp contadordeteclas, 0 ; bs ???? mas estas na coluna zero!!!!!
	je aguardatecla
	; continua se não estiver na coluna 0
	dec si
	dec di ; volta posição de traco
	dec contadordeteclas
	mov al, 8  ; 8 = bs
	out 8, al  ; manda backspace para o terminal
	mov al, " "
	out 8, al
	mov al, 8  ; 8 = bs
	out 8, al  ; manda backspace para o terminal
	jmp aguardatecla
	
printstring:
	; vamos chamar o sistema operacional
	; deves executar a instrução int 21h
	; porem, o sistema operacional tem várias rotinas prontas
	; mas devo escolher pelo ah !!!!!!
	push ax
	push dx
	mov ah,9 ; serviço que imprime string
	mov dx, si ; si é o parâmetro da função, porem, do s.o é o DX
	int 21h ; chama serviço 9
	pop dx
	pop ax
	ret

PULALINHA:
	PUSH AX
	MOV AL,13
	OUT 8,AL
	MOV AL,10
	OUT 8,AL
	POP AX
	RET

PROCURACARACTER:
	MOV SI, OFFSET PALAVRA
	MOV DI, OFFSET TRACOS
PROCURANDO:
	mov  dh, [si] ; "M"
	cmp  dh,"$" ; será que DH chegou no final do texto ?
	je FIMPROCURACARACTER
        cmp dh,al  ; compara se o parametro passado é igual ao letra de PALAVRA
	JE PREENCHETRACO
	INC SI
	INC DI
	JMP PROCURANDO
PREENCHETRACO:
	mov [di],al ; joga tecla digitada na variavel tracos
	inc si ; avanca memoria
	inc di ; avanca memoria
	jmp PROCURANDO
FIMPROCURACARACTER:
	RET

	