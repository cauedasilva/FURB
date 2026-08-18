       .model small
.stack 256  ; empilhar 256 valores de 16 bits cada
.data ; segmento de dados
; alfa db 0x99 ; aloca uma variavel de 1 byte
; beta dw 0x8888 ; aloca uma variavel de 2 bytes (WORD)
; nome db "caue",0 ; 0 = NULL, indicador de final de texto
; nome_backup db "    ",0

; nome1 db "S403",0
; nome2 db "   ",0

string db "TESTE",0

.code ; segmento de codigo
mov bx,offset string
convertendo:
mov al,[bx] ; coloca em al o conteudo apontado por bx
cmp al,0 ; antes de transformar em maiúsculo, verifique se chegou no final da string
je fim_da_conversao
cmp al,65
jl ignora
cmp al,90
jg ignora 
; sub al,32 ; subtrai de al 32, convertendo w para W, subtraindo o valor hexa do primeiro index da var string em 32
add al,32
mov [bx],al ; reescrevendo o valor na memória
inc bx
jmp convertendo
ignora:
inc bx
jmp convertendo
fim_da_conversao:
; mov ax,ds
; mov es,ax
; mov si,offset nome1
; mov di,offset nome2
; mov cx, 4
; rep movsb ; rep é um macro que pede para repetir o comando após ela, cx vezes, carregue o cx com o número de laços necessários

; compara_ate_encontrar_null:
; mov al,[si] ; verifica se chegou ao final da string
; cmp al,0
; je iguais ; se chegou ao final da string, se chegou ao 0, null, são iguais; percorreu toda a string
; cmp al, [di] ; compara conteúdo apontado por si com conteúdo apontado por di, offset aponta
; je iguais_parcial
; jmp diferentes

; iguais_parcial:
; inc si ; avança si para a próxima posição de memória, nome1
; inc di ; avança di para a próxima posição de memória, nome2
; jmp compara_ate_encontrar_null

; diferentes:
; mov cl, 0 ; cl recebe 0 se as strings são diferentes
; hlt
; iguais:
; mov cl, 1 ; cl recebe 1 se as strings são iguais
; mov alfa,0x77 ; 8 bits
; mov beta,0x7777 ; 16 bits

; mov si,offset nome ; coleta endereço de nome na memória
; mov di,offset nome_backup ; si = source, di = destination, é importante usar essa ordem
; varredura:
; mov al,[si] ; "s"
; cmp al, 0 ; antes de copiar, verifique se não chegou ao final da string
; je fim_backup ; chegou ao final da string (ao 0, ao null)
; mov [di],al ; caso contrário, faça o backup daquele carectere
; inc si ; avança memória source index
; inc di ; avança memória destination index
; jmp varredura
; fim_backup:

; varredura:
; mov al, [si] ; coleta conteúdo apontdo por si
; cmp al, 0 ; antes de avançar na memória, verifique se já chegou ao final da string
; je encerra_varredura
; inc si ; avança para a próxima posição de memória
; jmp varredura

; encerra_varredura:
hlt: 
