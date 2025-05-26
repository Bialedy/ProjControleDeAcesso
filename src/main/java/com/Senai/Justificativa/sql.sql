package com.Senai.Justificativa;

public class sql {
CREATE DATABASE sistema_justificativas;
USE sistema_justificativas;

CREATE TABLE justificativas (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(100),
    data VARCHAR(20),
    motivo TEXT
);
}
