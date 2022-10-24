INSERT INTO `desafio_api`.`clientes` (`id`, `cpf`, `email`, `nome`, `telefone`) VALUES ('1', '052.042.883-85', 'user1@email.com', 'Joana Darc dos Santos', '(85)98775-3520');
INSERT INTO `desafio_api`.`clientes` (`id`, `cpf`, `email`, `nome`, `telefone`) VALUES ('2', '025.035.681-20', 'user2@email.com', 'Silverio Antônio Torres', '(18)96832-2613');
INSERT INTO `desafio_api`.`clientes` (`id`, `cpf`, `email`, `nome`, `telefone`) VALUES ('3', '040.045.701-10', 'user3@email.com', 'Jerônimo Silva', '(23)98787-5590');
INSERT INTO `desafio_api`.`clientes` (`id`, `cpf`, `email`, `nome`, `telefone`) VALUES ('4', '045.044.701-10', 'user4@email.com', 'Maria Silva Santos', '(21)99999-5590');

INSERT INTO `desafio_api`.`cachorros` (`id`, `informacoes`, `nascimento`, `nome`, `raca`) VALUES ('1', 'Paciente saudável, peso 13kg, altura 55cm', '2019-01-20', 'Bidu', 'SRD');
INSERT INTO `desafio_api`.`cachorros` (`id`, `informacoes`, `nascimento`, `nome`, `raca`) VALUES ('2', 'Peso: 20kg, Comprimento: 100cm, Pelagem: branco e preto', '2020-07-27', 'Zeus', 'Dálmata');
INSERT INTO `desafio_api`.`cachorros` (`id`, `informacoes`, `nascimento`, `nome`, `raca`) VALUES ('3', 'Paciente oncológico. Peso: 11kg, Comprimento: 75cm, Pelagem: bege', '2016-01-09', 'Thor', 'Poodle');
INSERT INTO `desafio_api`.`cachorros` (`id`, `informacoes`, `nascimento`, `nome`, `raca`) VALUES ('4', 'Paciente saudável, peso 8kg, comprimento 30cm, pelagem marrom', '2015-02-10', 'Apolo', 'Pinscher');

INSERT INTO `desafio_api`.`clientes_lista_cachorros` (`cliente_id`, `cachorro_id`) VALUES ('1', '1');
INSERT INTO `desafio_api`.`clientes_lista_cachorros` (`cliente_id`, `cachorro_id`) VALUES ('1', '2');
INSERT INTO `desafio_api`.`clientes_lista_cachorros` (`cliente_id`, `cachorro_id`) VALUES ('2', '3');
INSERT INTO `desafio_api`.`clientes_lista_cachorros` (`cliente_id`, `cachorro_id`) VALUES ('3', '4');

INSERT INTO `desafio_api`.`veterinarios` (`id`, `crmv`, `email`, `especialidade`, `nome`, `telefone`) VALUES ('1', '253-36 CE', 'vet1@vet.com', 'Oftalmologista', 'Tatiane Nobrega', '(85)98888-7777');
INSERT INTO `desafio_api`.`veterinarios` (`id`, `crmv`, `email`, `especialidade`, `nome`, `telefone`) VALUES ('2', '357-01 CE', 'vet2@vet.com', 'Clinico Geral', 'Juliane Bastos', '(85)99999-2222');
INSERT INTO `desafio_api`.`veterinarios` (`id`, `crmv`, `email`, `especialidade`, `nome`, `telefone`) VALUES ('3', '025-10 RJ', 'vet3@vet.com', 'Radiologista', 'João Pinho', '(11)99999-1212');

INSERT INTO `desafio_api`.`atendimentos` (`id`, `comentarios`, `dados_animal`, `data_hora`, `diagnostico`) VALUES ('1', 'Receituário: Coleira Escalibour', 'Consulta de rotina.', '2022-05-04 08:12:07.000001', 'Otite leve');
INSERT INTO `desafio_api`.`atendimentos` (`id`, `comentarios`, `dados_animal`, `data_hora`, `diagnostico`) VALUES ('2', 'Completar o calendário vacinal; Retorna em 6 meses para acompanhamento de rotina. Receituário: Coleira Escalibour', 'Consulta de rotina.', '2022-05-05 10:12:07.000001', 'Otite leve');
INSERT INTO `desafio_api`.`atendimentos` (`id`, `comentarios`, `dados_animal`, `data_hora`, `diagnostico`) VALUES ('3', 'Retorno em 1 mês', 'Acompanhamento de paciente oncologico em remissão', '2022-01-20 09:12:07.899551', 'Câncer');
INSERT INTO `desafio_api`.`atendimentos` (`id`, `comentarios`, `dados_animal`, `data_hora`, `diagnostico`) VALUES ('4', '', 'Paciente em tratamento para calazar', '2022-02-15 14:11:07.899551', 'Calazar');

INSERT INTO `desafio_api`.`cachorro_lista_atendimentos` (`cachorro_id`, `atendimento_id`) VALUES ('1', '1');
INSERT INTO `desafio_api`.`cachorro_lista_atendimentos` (`cachorro_id`, `atendimento_id`) VALUES ('2', '2');
INSERT INTO `desafio_api`.`cachorro_lista_atendimentos` (`cachorro_id`, `atendimento_id`) VALUES ('3', '3');
INSERT INTO `desafio_api`.`cachorro_lista_atendimentos` (`cachorro_id`, `atendimento_id`) VALUES ('4', '4');

INSERT INTO `desafio_api`.`cliente_lista_atendimentos` (`cliente_id`, `atendimento_id`) VALUES ('1', '1');
INSERT INTO `desafio_api`.`cliente_lista_atendimentos` (`cliente_id`, `atendimento_id`) VALUES ('1', '2');
INSERT INTO `desafio_api`.`cliente_lista_atendimentos` (`cliente_id`, `atendimento_id`) VALUES ('2', '3');
INSERT INTO `desafio_api`.`cliente_lista_atendimentos` (`cliente_id`, `atendimento_id`) VALUES ('3', '4');

INSERT INTO `desafio_api`.`veterinario_lista_atendimentos` (`veterinario_id`, `atendimento_id`) VALUES ('1', '1');
INSERT INTO `desafio_api`.`veterinario_lista_atendimentos` (`veterinario_id`, `atendimento_id`) VALUES ('1', '2');
INSERT INTO `desafio_api`.`veterinario_lista_atendimentos` (`veterinario_id`, `atendimento_id`) VALUES ('3', '3');
INSERT INTO `desafio_api`.`veterinario_lista_atendimentos` (`veterinario_id`, `atendimento_id`) VALUES ('3', '4');
