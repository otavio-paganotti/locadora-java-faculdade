DROP SCHEMA IF EXISTS `Prova02_v2` ;

CREATE SCHEMA IF NOT EXISTS `Prova02_v2` DEFAULT CHARACTER SET utf8 ;
USE `Prova02_v2` ;

DROP TABLE IF EXISTS `Prova02_v2`.`Pessoa` ;

CREATE TABLE IF NOT EXISTS `Prova02_v2`.`Pessoa` (
  `idPessoa` INT NOT NULL,
  `nome` VARCHAR(80) NOT NULL,
  `cpf` INT NOT NULL,
  `telefone` VARCHAR(16) NOT NULL,
  `tipo` INT NOT NULL,
  `endereco` VARCHAR(100) NULL,
  `numCarteira` INT NULL,
  `numTrabalhos` INT NULL,
  `disponivel` TINYINT NULL,
  PRIMARY KEY (`idPessoa`),
  UNIQUE INDEX (`idPessoa`)
);

DROP TABLE IF EXISTS `Prova02_v2`.`Produto` ;

CREATE TABLE IF NOT EXISTS `Prova02_v2`.`Produto` (
  `idProduto` INT NOT NULL,
  `nome` VARCHAR(80) NOT NULL,
  `categoria` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idProduto`),
  UNIQUE INDEX (`idProduto`)
);

DROP TABLE IF EXISTS `Prova02_v2`.`Pedido` ;

CREATE TABLE IF NOT EXISTS `Prova02_v2`.`Pedido` (
  `idPedido` INT NOT NULL,
  `data` VARCHAR(10) NOT NULL,
  `Cliente_idPessoa` INT NOT NULL,
  `Funcionario_idPessoa` INT NOT NULL,
  `Produto_idProduto` INT NOT NULL,
  PRIMARY KEY (`idPedido`),
  UNIQUE INDEX (`idPedido`),
  INDEX (`Cliente_idPessoa`),
  INDEX (`Produto_idProduto`),
  INDEX (`Funcionario_idPessoa`),
  CONSTRAINT `fk_Pedido_Pessoa`
    FOREIGN KEY (`Cliente_idPessoa`)
    REFERENCES `Prova02_v2`.`Pessoa` (`idPessoa`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Pedido_Produto1`
    FOREIGN KEY (`Produto_idProduto`)
    REFERENCES `Prova02_v2`.`Produto` (`idProduto`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Pedido_Pessoa1`
    FOREIGN KEY (`Funcionario_idPessoa`)
    REFERENCES `Prova02_v2`.`Pessoa` (`idPessoa`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
);