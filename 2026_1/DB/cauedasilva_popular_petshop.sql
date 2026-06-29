
INSERT INTO municipio VALUES (1, 'Blumenau', 'SC');
INSERT INTO municipio VALUES (2, 'Pomerode', 'SC');
INSERT INTO municipio VALUES (3, 'Florianopolis', 'SC');
INSERT INTO municipio VALUES (4, 'Itajai', 'SC');
INSERT INTO municipio VALUES (5, 'Timbo', 'SC');


INSERT INTO especie VALUES (1, 'Cachorro');
INSERT INTO especie VALUES (2, 'Gato');
INSERT INTO especie VALUES (3, 'Passaro');
INSERT INTO especie VALUES (4, 'Coelho');
INSERT INTO especie VALUES (5, 'Peixe');


INSERT INTO categoria VALUES (1, 'Racao');
INSERT INTO categoria VALUES (2, 'Medicamentos');
INSERT INTO categoria VALUES (3, 'Brinquedos');
INSERT INTO categoria VALUES (4, 'Higiene');
INSERT INTO categoria VALUES (5, 'Acessorios');


INSERT INTO servico VALUES (1, 'Banho', 50.00);
INSERT INTO servico VALUES (2, 'Tosa', 70.00);
INSERT INTO servico VALUES (3, 'Consulta', 120.00);
INSERT INTO servico VALUES (4, 'Vacina', 90.00);
INSERT INTO servico VALUES (5, 'Exame', 150.00);


INSERT INTO endereco VALUES (1, 'Rua A', 'Casa', 'Centro', '89000000', 1);
INSERT INTO endereco VALUES (2, 'Rua B', 'Apto 1', 'Velha', '89010000', 2);
INSERT INTO endereco VALUES (3, 'Rua C', 'Casa', 'Garcia', '89020000', 3);
INSERT INTO endereco VALUES (4, 'Rua D', 'Sala 2', 'Escola Agricola', '89030000', 4);
INSERT INTO endereco VALUES (5, 'Rua E', 'Casa', 'Agua Verde', '89040000', 5);


INSERT INTO raca VALUES (1, 'Labrador', 1);
INSERT INTO raca VALUES (2, 'Persa', 2);
INSERT INTO raca VALUES (3, 'Canario', 3);
INSERT INTO raca VALUES (4, 'Pitbull', 4);
INSERT INTO raca VALUES (5, 'Sirio', 5);


INSERT INTO cliente VALUES (1, 'Joao Silva', '47999990001', 'joao@email.com', '1990-05-10', 1);
INSERT INTO cliente VALUES (2, 'Maria Souza', '47999990002', 'maria@email.com', '1988-08-15', 2);
INSERT INTO cliente VALUES (3, 'Pedro Santos', '47999990003', 'pedro@email.com', '1995-11-20', 3);
INSERT INTO cliente VALUES (4, 'Ana Costa', '47999990004', 'ana@email.com', '1992-03-25', 4);
INSERT INTO cliente VALUES (5, 'Carlos Lima', '47999990005', 'carlos@email.com', '1985-07-30', 5);


INSERT INTO prestador_servico VALUES (1, 'Dr. Marcos', '47988880001', 'marcos@email.com', 1);
INSERT INTO prestador_servico VALUES (2, 'Dra. Julia', '47988880002', 'julia@email.com', 2);
INSERT INTO prestador_servico VALUES (3, 'Dr. Rafael', '47988880003', 'rafael@email.com', 3);
INSERT INTO prestador_servico VALUES (4, 'Dra. Camila', '47988880004', 'camila@email.com', 4);
INSERT INTO prestador_servico VALUES (5, 'Dr. Bruno', '47988880005', 'bruno@email.com', 5);


INSERT INTO produto VALUES (1, 'Racao', 'Racao para caes', 80.00, 120.00, 20, 1);
INSERT INTO produto VALUES (2, 'Vermifugo', 'Medicamento', 25.00, 45.00, 30, 2);
INSERT INTO produto VALUES (3, 'Bolinha', 'Brinquedo para pets', 10.00, 20.00, 50, 3);
INSERT INTO produto VALUES (4, 'Shampoo', 'Higiene animal', 18.00, 35.00, 25, 4);
INSERT INTO produto VALUES (5, 'Coleira', 'Acessorio para passeio', 22.00, 40.00, 15, 5);


INSERT INTO animal VALUES (1, 'Rex', 'Cao', '2020-01-10', 'M', 1, 1);
INSERT INTO animal VALUES (2, 'Mimi', 'Gato', '2021-02-15', 'P', 2, 2);
INSERT INTO animal VALUES (3, 'Piu', 'Passaro', '2022-03-20', 'P', 3, 3);
INSERT INTO animal VALUES (4, 'Bunny', 'Coelho', '2021-07-12', 'M', 4, 4);
INSERT INTO animal VALUES (5, 'Nino', 'Hamster', '2023-01-05', 'P', 5, 5);


INSERT INTO servico_prestador VALUES (1, 1);
INSERT INTO servico_prestador VALUES (2, 2);
INSERT INTO servico_prestador VALUES (3, 3);
INSERT INTO servico_prestador VALUES (4, 4);
INSERT INTO servico_prestador VALUES (5, 5);


INSERT INTO agendamento VALUES (1, '2025-05-01', '08:00:00', 1, 1, 1);
INSERT INTO agendamento VALUES (2, '2025-05-02', '09:00:00', 2, 2, 2);
INSERT INTO agendamento VALUES (3, '2025-05-03', '10:00:00', 3, 3, 3);
INSERT INTO agendamento VALUES (4, '2025-05-04', '11:00:00', 4, 4, 4);
INSERT INTO agendamento VALUES (5, '2025-05-05', '14:00:00', 5, 5, 5);


INSERT INTO agendamento_servico VALUES (1, 1, 1, 50.00);
INSERT INTO agendamento_servico VALUES (2, 2, 1, 70.00);
INSERT INTO agendamento_servico VALUES (3, 3, 1, 120.00);
INSERT INTO agendamento_servico VALUES (4, 4, 1, 90.00);
INSERT INTO agendamento_servico VALUES (5, 5, 1, 150.00);


INSERT INTO nota_fiscal VALUES (1, '2025-05-01', 120.00, 1);
INSERT INTO nota_fiscal VALUES (2, '2025-05-02', 45.00, 2);
INSERT INTO nota_fiscal VALUES (3, '2025-05-03', 20.00, 3);
INSERT INTO nota_fiscal VALUES (4, '2025-05-04', 35.00, 4);
INSERT INTO nota_fiscal VALUES (5, '2025-05-05', 40.00, 5);

INSERT INTO item_nota_fiscal VALUES (1, 1, 1, 120.00);
INSERT INTO item_nota_fiscal VALUES (2, 2, 1, 45.00);
INSERT INTO item_nota_fiscal VALUES (3, 3, 1, 20.00);
INSERT INTO item_nota_fiscal VALUES (4, 4, 1, 35.00);
INSERT INTO item_nota_fiscal VALUES (5, 5, 1, 40.00);