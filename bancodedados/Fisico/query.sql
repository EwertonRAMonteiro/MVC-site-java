CREATE DATABASE IF NOT exists vayvem;
use vayvem;

CREATE TABLE cliente (
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    cpf VARCHAR(15) NOT NULL UNIQUE,
    nomeCompleto VARCHAR(80) not null,
    rua VARCHAR(50) NOT NULL,
    bairro VARCHAR(50) NOT NULL,
    cep VARCHAR(10) NOT NULL,
    cidade VARCHAR(50) NOT NULL,
    estado VARCHAR(30) NOT NULL,
    email VARCHAR(50) NOT NULL,
    numero VARCHAR(15) NOT NULL
);
 