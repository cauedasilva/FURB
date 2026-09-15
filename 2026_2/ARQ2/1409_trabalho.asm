.model small
.stack 256
.data

mensagem_inicial db "a palavra ", 13, 10, 0
mensagem_encontrou db " foi encontrada", 13, 10, 0
mensagem_nao_encontrou db " nao foi encontrada", 13, 10, 0

palavra_atual dw 0
inicio_tentativa dw 0 

palavra1 db "copas$"
palavra2 db "espadas$"
palavra3 db "ouro$"
palavra4 db "valete$"
palavra5 db "dama$"

caca	db "afafafafafafafafaafafafafafafafafa",13,10
		db "afafafafafafafafaafcopasafafafafafafafa",13,10
		db "afafafafafafafafaafafafafafafafafa",13,10
		db "afafafafafafafafafafafafafafafafafa",13,10
		db "afafafafafafafafaafafafafafafafafa",13,10,"$"

.code

inicio:
	mov ah, 9
	mov dx, offset caca
	int 21h

	mov bx, offset palavra1
    mov palavra_atual, bx
    call procura_palavra

	mov bx, offset palavra2
    mov palavra_atual, bx
    call procura_palavra
	
	mov bx, offset palavra3
    mov palavra_atual, bx
    call procura_palavra

	mov bx, offset palavra4
    mov palavra_atual, bx
    call procura_palavra

	mov bx, offset palavra5
    mov palavra_atual, bx
    call procura_palavra

	mov ah, 9
    mov dx, offset caca
    int 21h

	HLT

procura_palavra:
	mov si, palavra_atual
    mov di, offset caca
    mov inicio_tentativa, di

proximo:
	mov al, [si]
	mov ah, [di]
	cmp al, "$"
	je achei
	cmp ah, "$"
	je naoachei
	cmp ah,al
	je igual
	
diferente:
	mov si, palavra_atual
	mov ax, inicio_tentativa
	inc ax
	mov inicio_tentativa, ax
    mov di, ax
    jmp proximo

igual:
	inc si
	inc di
	jmp proximo

achei:
	mov si, palavra_atual

contar_tamanho:
	cmp byte ptr [si], "$"
	je aplica_maiusculo
	inc si
	dec di
	jmp contar_tamanho

aplica_maiusculo:
	mov si, palavra_atual

substituir_loop:
	mov al, [si]
	cmp al, "$"
	je fim_substituicao
	sub byte ptr [di], 32
	inc si
	inc di
	jmp substituir_loop

fim_substituicao:
	mov bx, offset mensagem_inicial
	call imprimir_texto
	mov bx, palavra_atual
	call imprimir_texto
	mov bx, offset mensagem_encontrou
	call imprimir_texto
	ret

naoachei:
	mov bx, offset mensagem_inicial
	call imprimir_texto
	mov bx, palavra_atual
    call imprimir_texto
    mov bx, offset mensagem_nao_encontrou
    call imprimir_texto
    ret

imprimir_texto:
	push ax ; salva contexto para que, o usuario 
	push dx ; nao perceba que foram alterados

imprimindo_cabecalho:
	mov al, [bx] 
    cmp al, 0
    je sair_imprimir_texto
    cmp al, "$"
    je sair_imprimir_texto
    
    mov dx, 8 
    out dx, al 
    inc bx     
    jmp imprimindo_cabecalho

sair_imprimir_texto:
    pop dx
    pop ax
    ret

; buscar as palavras, uma por uma
; se encontrar, substituir as palavras no caca original por elas em maiusculo
; imprimir novamente o caca

hlt 