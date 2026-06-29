SELECT COUNT(*) AS total_pequeno_porte
FROM   animal
WHERE  tp_porte = 'P';

SELECT AVG(vl_total) AS valor_medio_outubro
FROM   nota_fiscal
WHERE  MONTH(dt_emissao) = 10
  AND  YEAR(dt_emissao)  = 2024;
  
SELECT ps.nm_prestador,
       COUNT(a.nr_agendamento) AS total_agendamentos
FROM   prestador_servico ps
LEFT JOIN agendamento a ON a.cd_prestador = ps.cd_prestador
GROUP  BY ps.cd_prestador, ps.nm_prestador
ORDER  BY total_agendamentos DESC;

SELECT c.ds_categoria,
       COUNT(p.cd_produto) AS total_produtos
FROM   categoria c
LEFT JOIN produto p ON p.cd_categoria = c.cd_categoria
GROUP  BY c.cd_categoria, c.ds_categoria
ORDER  BY total_produtos DESC;

SELECT m.nm_municipio,
       m.sg_uf,
       COUNT(c.cd_cliente) AS total_clientes
FROM   municipio m
JOIN   endereco e  ON e.cd_municipio = m.cd_municipio
JOIN   cliente  c  ON c.cd_endereco  = e.cd_endereco
GROUP  BY m.cd_municipio, m.nm_municipio, m.sg_uf
ORDER  BY total_clientes DESC;

SELECT c.nm_cliente,
       SUM(nf.vl_total) AS total_vendas
FROM   cliente c
JOIN   nota_fiscal nf ON nf.cd_cliente = c.cd_cliente
GROUP  BY c.cd_cliente, c.nm_cliente
ORDER  BY total_vendas DESC;

SELECT ps.nm_prestador,
       COUNT(a.nr_agendamento) AS nr_agendamentos
FROM   prestador_servico ps
LEFT JOIN agendamento a ON a.cd_prestador = ps.cd_prestador
GROUP  BY ps.cd_prestador, ps.nm_prestador
ORDER  BY nr_agendamentos DESC;

SELECT ps.nm_prestador,
       SUM(ags.qt_servico * ags.vl_servico) AS receita_total
FROM   prestador_servico ps
JOIN   agendamento         a   ON a.cd_prestador   = ps.cd_prestador
JOIN   agendamento_servico ags ON ags.nr_agendamento = a.nr_agendamento
GROUP  BY ps.cd_prestador, ps.nm_prestador
ORDER  BY receita_total DESC;

SELECT nm_especi, total_racas
FROM (
    SELECT e.cd_especie,
           e.nm_especi,
           COUNT(r.cd_raca) AS total_racas
    FROM   especie e
    JOIN   raca    r ON r.cd_especie = e.cd_especie
    GROUP  BY e.cd_especie, e.nm_especi
) AS contagem_racas
WHERE  total_racas > 3
ORDER  BY total_racas DESC;

SELECT nm_cliente, total_animais
FROM (
    SELECT c.cd_cliente,
           c.nm_cliente,
           COUNT(a.cd_animal) AS total_animais
    FROM   cliente c
    JOIN   animal  a ON a.cd_cliente = c.cd_cliente
    GROUP  BY c.cd_cliente, c.nm_cliente
) AS contagem_animais
WHERE  total_animais > 1
ORDER  BY total_animais DESC;