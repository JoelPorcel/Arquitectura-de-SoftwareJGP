-- Crear la base de datos
CREATE DATABASE IF NOT EXISTS bd_concesionario;

USE concesionario;

-- Crear la tabla coches
CREATE TABLE IF NOT EXISTS coches (
    id INT AUTO_INCREMENT PRIMARY KEY,
    color VARCHAR(50) NOT NULL,
    marca VARCHAR(50) NOT NULL,
    modelo VARCHAR(50) NOT NULL
);
