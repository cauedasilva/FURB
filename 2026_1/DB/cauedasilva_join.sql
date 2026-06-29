SELECT c.nm_cliente, a.nm_animal
FROM cliente c
JOIN animal a ON a.cd_cliente = c.cd_cliente;

SELECT p.cd_produto, p.nm_produto, p.ds_produto,
       p.vl_custo, p.vl_venda, p.qt_estoque,
       cat.ds_categoria
FROM produto p
JOIN categoria cat ON cat.cd_categoria = p.cd_categoria;

SELECT ag.nr_agendamento, ag.dt_agendamento, ag.hr_agendamento,
       ps.nm_prestador, ps.nr_telefone, ps.ds_email
FROM agendamento ag
JOIN prestador_servico ps ON ps.cd_prestador = ag.cd_prestador;

SELECT ag.nr_agendamento, s.ds_servico,
       ags.qt_servico, ags.vl_servico
FROM agendamento_servico ags
JOIN agendamento ag ON ag.nr_agendamento = ags.nr_agendamento
JOIN servico s      ON s.cd_servico      = ags.cd_servico;

SELECT ps.nm_prestador, s.ds_servico, s.vl_servico
FROM prestador_servico ps
JOIN servico_prestador sp ON sp.cd_prestador = ps.cd_prestador
JOIN servico s             ON s.cd_servico   = sp.cd_servico;

SELECT nf.nr_notal_fiscal, nf.dt_emissao, nf.vl_total,
       c.nm_cliente
FROM nota_fiscal nf
JOIN cliente c ON c.cd_cliente = nf.cd_cliente;

SELECT inf.nr_notal_fiscal, p.nm_produto,
       inf.qt_produto, inf.vl_produto
FROM item_nota_fiscal inf
JOIN produto p ON p.cd_produto = inf.cd_produto;

SELECT a.nm_animal, r.nm_raca, e.nm_especie
FROM animal a
JOIN raca    r ON r.cd_raca    = a.cd_raca
JOIN especie e ON e.cd_especie = r.cd_especie;

SELECT ag.nr_agendamento, ag.dt_agendamento, ag.hr_agendamento,
       c.nm_cliente, an.nm_animal
FROM agendamento ag
JOIN cliente c ON c.cd_cliente = ag.cd_cliente
JOIN animal an ON an.cd_animal = ag.cd_animal;

SELECT c.nm_cliente, e.ds_logradouro, e.nm_bairro,
       m.nm_municipio, m.sg_uf
FROM cliente c
JOIN endereco  e ON e.cd_endereco  = c.cd_endereco
JOIN municipio m ON m.cd_municipio = e.cd_municipio;

SELECT ps.nm_prestador, e.ds_logradouro,
       m.nm_municipio, m.sg_uf
FROM prestador_servico ps
JOIN endereco  e ON e.cd_endereco  = ps.cd_endereco
JOIN municipio m ON m.cd_municipio = e.cd_municipio;

SELECT nf.nr_notal_fiscal, nf.dt_emissao,
       p.nm_produto, inf.qt_produto, inf.vl_produto
FROM nota_fiscal nf
JOIN item_nota_fiscal inf ON inf.nr_notal_fiscal = nf.nr_notal_fiscal
JOIN produto p             ON p.cd_produto       = inf.cd_produto;

SELECT ag.nr_agendamento, ag.dt_agendamento,
       s.ds_servico, ags.qt_servico,
       (ags.qt_servico * ags.vl_servico) AS vl_total
FROM agendamento ag
JOIN agendamento_servico ags ON ags.nr_agendamento = ag.nr_agendamento
JOIN servico s               ON s.cd_servico       = ags.cd_servico;

SELECT ps.nm_prestador, s.ds_servico, s.vl_servico
FROM prestador_servico ps
JOIN servico_prestador sp ON sp.cd_prestador = ps.cd_prestador
JOIN servico s             ON s.cd_servico   = sp.cd_servico
WHERE s.vl_servico > 100.00;

SELECT a.nm_animal, r.nm_raca, e.nm_especie
FROM animal a
JOIN raca    r ON r.cd_raca    = a.cd_raca
JOIN especie e ON e.cd_especie = r.cd_especie
WHERE r.nm_raca = 'Poodle';