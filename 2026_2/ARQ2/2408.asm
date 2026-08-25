.MODEL SMALL
.STACK 256
.DATA
    tabmens db "TABUADA", 13, 10, 0 
    mens1   db " * ", 0
    mens2   db " = ", 0

.CODE
    ; Inicializa o segmento de dados
    MOV AX, @DATA
    MOV DS, AX

    MOV CH, 9                   ; CH define a tabuada inicial (tabuada do 9)

NOVOCICLO:
    MOV BX, OFFSET tabmens      ; Carrega o endereço da mensagem "TABUADA"
    CALL IMPRIMIR_TEXTO         ; Imprime o cabeçalho
    MOV CL, 1                   ; CL representa o contador da tabuada (1 a 10)

IMPRIMINDO:
    MOV AL, CH                  ; Copia o número da tabuada atual para AL
    CALL IMPRIMIR_AL            ; Imprime o número da tabuada (ex: 09)
    
    MOV BX, OFFSET mens1        ; Carrega o texto " * "
    CALL IMPRIMIR_TEXTO         ; Imprime " * "
    
    MOV AL, CL                  ; Copia o contador atual para AL
    CALL IMPRIMIR_AL            ; Imprime o número do contador (ex: 01)
    
    MOV BX, OFFSET mens2        ; Carrega o texto " = "
    CALL IMPRIMIR_TEXTO         ; Imprime " = "

    ; Realiza a multiplicação (AX = AL * BL)
    MOV BL, CH                  ; Define o multiplicador atual (valor de CH)
    MOV AL, CL                  ; Move o contador (CL) para AL
    MUL BL                      ; Multiplica AL por BL (Resultado fica em AX)

    CALL IMPRIMIR_AL_PLUS       ; Imprime o resultado dinamicamente (sem zeros à esquerda)
    CALL PULAR_LINHA            ; Salta para a próxima linha no terminal
    
    INC CL                      ; Incrementa o contador da linha (multiplicador)
    CMP CL, 11                  ; Verifica se terminou a tabuada atual (1 a 10)
    JE FINALIZA                 ; Se chegou a 11, vai para o controle do ciclo
    JMP IMPRIMINDO              ; Se não, continua imprimindo a tabuada atual

FINALIZA:
    INC CH                      ; Avança para a próxima tabuada (ex: passa de 9 para 10)
    CMP CH, 11                  ; Verifica se já processou as tabuadas do 9 e do 10
    JE FIMCICLO                 ; Se chegou a 11, encerra o programa
    JMP NOVOCICLO               ; Se não, inicia a próxima tabuada

FIMCICLO:
    HLT                         ; Interrompe a execução do processador

; --- ROTINAS E FUNÇÕES ---

; Imprime uma string terminada em zero (Null)
; Parâmetro: BX = Endereço da string
IMPRIMIR_TEXTO:
    PUSH AX                     ; Salva o registrador AX
    PUSH DX                     ; Salva o registrador DX

IMPRIMINDO_CABECALHO:
    MOV AL, [BX]                ; Carrega o caractere apontado por BX em AL
    CMP AL, 0                   ; Verifica se chegou ao fim do texto (Null)
    JE SAIR_IMPRIMIR_TEXTO      ; Se for zero, encerra a função
    MOV DX, 8                   ; Endereço da porta do terminal
    OUT DX, AL                  ; Envia o caractere para o terminal
    INC BX                      ; Avança para o próximo caractere na memória
    JMP IMPRIMINDO_CABECALHO    ; Repete o processo

SAIR_IMPRIMIR_TEXTO:
    POP DX                      ; Restaura o valor de DX
    POP AX                      ; Restaura o valor de AX
    RET

; Envia os comandos CR (13) e LF (10) para o terminal
PULAR_LINHA:
    PUSH AX                     ; Salva o registrador AX
    PUSH DX                     ; Salva o registrador DX
    MOV DX, 8                   ; Endereço da porta do terminal
    MOV AL, 13                  ; Código ASCII para Carriage Return (Retorno de Carro)
    OUT DX, AL                  ; Move o cursor para o início da linha
    MOV AL, 10                  ; Código ASCII para Line Feed (Nova Linha)
    OUT DX, AL                  ; Move o cursor para a linha de baixo
    POP DX                      ; Restaura DX
    POP AX                      ; Restaura AX
    RET

; Imprime o valor de AL fixo com dois dígitos (00 a 99)
; Parâmetro: AL = Número a ser impresso
IMPRIMIR_AL:
    PUSH BX                     ; Salva o registrador BX
    PUSH DX                     ; Salva o registrador DX
    MOV AH, 0                   ; Zera AH para isolar o valor de AL em AX
    MOV BL, 10                  ; Define o divisor como 10
    DIV BL                      ; Divide AX por BL (AL = Dezena, AH = Resto/Unidade)
    
    ADD AL, "0"                 ; Converte a dezena para caractere ASCII
    MOV DX, 8                   ; Endereço da porta do terminal
    OUT DX, AL                  ; Imprime o dígito da dezena
    
    MOV AL, AH                  ; Move o resto (unidade) para AL
    ADD AL, "0"                 ; Converte a unidade para caractere ASCII
    OUT DX, AL                  ; Imprime o dígito da unidade
    
    POP DX                      ; Restaura DX
    POP BX                      ; Restaura BX
    RET

; Imprime o valor de AX de forma dinâmica (suporta mais dígitos e evita zeros à esquerda)
; Parâmetro: AX = Número obtido na multiplicação
IMPRIMIR_AL_PLUS:
    PUSH AX                     ; Salva os registradores do contexto
    PUSH BX
    PUSH CX
    PUSH DX
    MOV CL, 0                   ; Zera CL, que contará quantos dígitos foram armazenados

DIVIDE:
    MOV AH, 0                   ; Zera AH para focar na divisão do dígito atual
    MOV BL, 10                  ; Define o divisor como 10
    DIV BL                      ; Divide AX por 10 (AL = Quociente, AH = Resto do dígito)
    PUSH AX                     ; Guarda o resultado (com o resto em AH) na pilha
    INC CL                      ; Incrementa o contador de dígitos na pilha
    CMP AL, 0                   ; Verifica se o quociente zerou (fim da divisão)
    JE DESEMPILHA               ; Se zerou, vai para a fase de exibição
    JMP DIVIDE                  ; Se não zerou, continua dividindo

DESEMPILHA:
    POP AX                      ; Recupera o último par quociente/resto da pilha
    MOV AL, AH                  ; Move o resto (que é o dígito correto) para AL
    ADD AL, "0"                 ; Converte o dígito numérico para caractere ASCII
    MOV DX, 8                   ; Endereço da porta do terminal
    OUT DX, AL                  ; Imprime o caractere no terminal
    DEC CL                      ; Decrementa o contador de dígitos restantes
    CMP CL, 0                   ; Verifica se todos os dígitos foram impressos
    JNE DESEMPILHA              ; Se ainda restam dígitos, continua desempilhando
    
    POP DX                      ; Restaura os registradores originais
    POP CX
    POP BX
    POP AX
    RET
