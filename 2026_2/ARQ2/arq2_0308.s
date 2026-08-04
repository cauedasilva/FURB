; ABCDE, registradores em m++ -> 8bits = 0-255
; AX,BX,CX,DX,SI,SI, registradores em 8086 -> 16bits = 0-65535

 def SOMA { ; declarar função antes do start:
    INC DI
    RET
}

start:
    MOV DI,0
    CALL SOMA
    HLT

    ; MOV AX,0x9999
    ; MOV BX,AX ; copia ax para bx -> copia da direita para a esquerda
    
    ; MOV CL,0x23
    ; SUB BL,0x99 ; irá acender a flag c, o valor original de BL é menor do que 0x99

    ; MOV CL,0b11111111 ; irá acender a flag c, pois estorou a memória
    ; INC CL
    
    ; MOV SI,44
    ; SUB SI,44 ; irá acender a flag z, ZF
    ; HLT

;    MOV AL,20
;    MOV BL,23
;    CMP AL,BL
;    JG MAIOR ; se esquerda é maior que direita
;    CMP AL,BL
;    JL MENOR
;    HLT
;MAIOR:
;    HLT
; MENOR:
;    HLT

    ; JE - jump if equal
    ; JNE - jump if not equal
    ; JL - jump if less
    ; JG - jump if greater

    ; MOV BL,0x33
    ; CMP BL,0x33 ; com compare o dado no registrador não é perdido, ao contrário da maneira com JZ
    ; JE IGUAL ; jump if equal
    ; HLT
; IGUAL:

    ; MOV BL,0x33
    ; SUB BL,0x33
    ; JZ IGUAL ; se 0, jump para igual, jump zero
    ; HLT
; IGUAL:
    
    ; MOV AX,0x1234
    ; XOR AX,AX ; isso 0 o AX, pois todos os bits de AX são iguais aos bits de AX

    ; MOV AL,0b00110101
    ; MOV BL,0b001110011
    ; XOR AL,BL ; compara os bits e resulta em 1 apenas se os bits forem diferentes
    
    ; MOV AL,0b0011
    ; MOV BL,0b01100
    ; OR AL,BL ; em OR basta um das entradas ser 1 para a saída ser 1, 0011 + 1100 = 1111 ou f

    ; MOV AL,0b10010001
    ; NOT AL ; inverteu os bits
    ; NOT AL
    
    
    ; MOV AL,0b00110101
    ; MOV BL,0b01110011
    ; AND AL,BL ; o destino da operação é na esquerda, no AL

    ;MOV AX,0x7777
    ;MOV BX,0x7777
    ;MOV CX,0x7777
    ;MOV DX,0x7777
    ;MOV SI,0x7777
    ;MOV DI,0x7777
    ;ADD AX,1
    ;ADD BX,1
    ;ADD CX,1
    ;ADD DX,1
    ;ADD DI,1
    ;ADD SI,1 ; adição, qualquer número de 16bits
    ;INC AX
    ;INC BX
    ;INC CX
    ;INC DX
    ;INC SI
    ;INC DI ; incremento
    ;SUB AX,1
    ;SUB BX,1
    ;SUB CX,1
    ;SUB DX,1
    ;SUB SI,1
    ;SUB DI,1 ; subtração
    ;DEC AX
    ;DEC BX
    ;DEC CX
    ;DEC DX
    ;DEC SI
    ;DEC DI ; decréscimo
    
    ; CS, DS, SS, ES -> registradores de 16bits
    ; CS = code segment -> aponta em qual segmento está o código
    ; DS = data segment -> aponta em qual segmento está os dados 
    ; SS = stack segment - > aponta em qual segmento está a pilha
    ; este exemplo é em .exe
    ; este programa roda em .com, portanto todos os segmentos vão apontar para 0
    
    ; MOV AH,0x44 -> movendo para cada registrador independentemente 
    ; MOV AL,0x55
    
    ; MOV AX,0x3322 -> reg H = 33, reg L = 22 
    
    ; MOV AX,0b0100111011001101 -> 0b = binário
    
    ; MOV AX,0x9999
    ; MOV BX,0x9999
    ; MOV CX,0x9999
    ; MOV DX,0x9999
    ; MOV SI,0x9999
    ; MOV DI,0x9999 -> 0x = hexadecimal
    HLT