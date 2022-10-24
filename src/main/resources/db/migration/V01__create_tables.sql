CREATE TABLE `clientes` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `cpf` varchar(255) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `nome` varchar(255) NOT NULL,
  `telefone` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_7wflw78ibh162cmq12ii6ffly` (`cpf`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `cachorros` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `informacoes` varchar(255) DEFAULT NULL,
  `nascimento` date NOT NULL,
  `nome` varchar(255) NOT NULL,
  `raca` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `clientes_lista_cachorros` (
  `cliente_id` bigint NOT NULL,
  `cachorro_id` bigint NOT NULL,
  PRIMARY KEY (`cachorro_id`),
  KEY `FKabdfwf02xwf03rkw836u95u8p` (`cliente_id`),
  CONSTRAINT `FKabdfwf02xwf03rkw836u95u8p` FOREIGN KEY (`cliente_id`) REFERENCES `clientes` (`id`),
  CONSTRAINT `FKpr3xl046pnk2457f1xpalyprn` FOREIGN KEY (`cachorro_id`) REFERENCES `cachorros` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `veterinarios` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `crmv` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `especialidade` varchar(255) DEFAULT NULL,
  `nome` varchar(255) NOT NULL,
  `telefone` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_bgp8s7r32jte0ndtaqov43bip` (`crmv`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `arquivo_morto` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `atendimento` varchar(2000) DEFAULT NULL,
  `data_exclusao` datetime(6) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `atendimentos` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `comentarios` varchar(255) DEFAULT NULL,
  `dados_animal` varchar(255) NOT NULL,
  `data_hora` datetime(6) NOT NULL,
  `diagnostico` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `cachorro_lista_atendimentos` (
  `cachorro_id` bigint NOT NULL,
  `atendimento_id` bigint NOT NULL,
  PRIMARY KEY (`atendimento_id`),
  KEY `FKahgwfffir7is0hkllh079qotx` (`cachorro_id`),
  CONSTRAINT `FKahgwfffir7is0hkllh079qotx` FOREIGN KEY (`cachorro_id`) REFERENCES `cachorros` (`id`),
  CONSTRAINT `FKsr40oqxgv8xoqbcvwvxp2av3m` FOREIGN KEY (`atendimento_id`) REFERENCES `atendimentos` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `cliente_lista_atendimentos` (
  `cliente_id` bigint NOT NULL,
  `atendimento_id` bigint NOT NULL,
  PRIMARY KEY (`atendimento_id`),
  KEY `FK2jchg6kway2f8hc584rui47sa` (`cliente_id`),
  CONSTRAINT `FK2jchg6kway2f8hc584rui47sa` FOREIGN KEY (`cliente_id`) REFERENCES `clientes` (`id`),
  CONSTRAINT `FKdomsqt9t4my5fbddotgg7n2ue` FOREIGN KEY (`atendimento_id`) REFERENCES `atendimentos` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `veterinario_lista_atendimentos` (
  `veterinario_id` bigint NOT NULL,
  `atendimento_id` bigint NOT NULL,
  PRIMARY KEY (`atendimento_id`),
  KEY `FK9012ug888xwy4k61i5hxbwjgi` (`veterinario_id`),
  CONSTRAINT `FK9012ug888xwy4k61i5hxbwjgi` FOREIGN KEY (`veterinario_id`) REFERENCES `veterinarios` (`id`),
  CONSTRAINT `FKpu3ec46ie8t7330ubo7r9bgve` FOREIGN KEY (`atendimento_id`) REFERENCES `atendimentos` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
