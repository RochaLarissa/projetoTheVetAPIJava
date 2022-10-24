INSERT INTO `desafio_api`.`tb_perfil` (`id`, `nome`) VALUES ('1', 'Admin');
INSERT INTO `desafio_api`.`tb_perfil` (`id`, `nome`) VALUES ('2', 'User');


INSERT INTO `desafio_api`.`tb_usuario` (`id`, `email`, `nome`, `senha`, `cliente_id`, `perfil_id`) VALUES ('1', 'vet1@gft.com', 'Tatiane Nobrega' , '$2a$10$Ige5Z9hXF.Sc9k/f2FhwXu.M95tP3a6kYfFiEGKPa1hOUtAve2fue', null, '1');
INSERT INTO `desafio_api`.`tb_usuario` (`id`, `email`, `nome`, `senha`, `cliente_id`, `perfil_id`) VALUES ('2', 'cliente1@email.com', 'Joana Darc dos Santos' , '$2a$10$Ige5Z9hXF.Sc9k/f2FhwXu.M95tP3a6kYfFiEGKPa1hOUtAve2fue', '1', '2');
INSERT INTO `desafio_api`.`tb_usuario` (`id`, `email`, `nome`, `senha`, `cliente_id`, `perfil_id`) VALUES ('3', 'cliente2@email.com', 'Silverio Antônio Torres' , '$2a$10$Ige5Z9hXF.Sc9k/f2FhwXu.M95tP3a6kYfFiEGKPa1hOUtAve2fue', '2', '2');
INSERT INTO `desafio_api`.`tb_usuario` (`id`, `email`, `nome`, `senha`, `cliente_id`,`perfil_id`) VALUES ('4', 'vet2@gft.com', 'Juliane Bastos' , '$2a$10$Ige5Z9hXF.Sc9k/f2FhwXu.M95tP3a6kYfFiEGKPa1hOUtAve2fue', null, '1');
