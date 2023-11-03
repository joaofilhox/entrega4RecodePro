CREATE DATABASE viajarEDescobrir;

CREATE TABLE clientes (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255),
    cpf VARCHAR(11),
    endereco VARCHAR(255),
    telefone VARCHAR(15),
    email VARCHAR(255)
);


