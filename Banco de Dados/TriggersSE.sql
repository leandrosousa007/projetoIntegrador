use se;

-- 1
CREATE TABLE ResponsavelBackup (
    cod_resp int PRIMARY KEY,
    nome_resp varchar(50),
    telefone varchar(20),
    email varchar(50),
    endereco varchar(70)
);


DELIMITER $

CREATE TRIGGER Backupresponsavel
AFTER INSERT ON Responsavel
FOR EACH ROW
BEGIN
    
    INSERT INTO ResponsavelBackup (cod_resp, nome_resp, telefone, email, endereco)
    VALUES (NEW.cod_resp, NEW.nome_resp, NEW.telefone, NEW.email, NEW.endereco);
END $

DELIMITER ;

INSERT INTO Responsavel (cod_resp, nome_resp, telefone, email, endereco)
VALUES (13, 'Dario Marwell', '34988433765', 'dario@gmail.com', 'Rua do Carpinteiro, 220, Uberlândia, Minas Gerais');

select * from ResponsavelBackup;


-- 2

DELIMITER $

CREATE FUNCTION FormatarTelefone(codigo_resp INT)
RETURNS VARCHAR(20)
BEGIN
    RETURN CONCAT(
        SUBSTRING((SELECT telefone FROM Responsavel WHERE cod_resp = codigo_resp), 1, 2), ' ',
        SUBSTRING((SELECT telefone FROM Responsavel WHERE cod_resp = codigo_resp), 3, 5), '-',
        SUBSTRING((SELECT telefone FROM Responsavel WHERE cod_resp = codigo_resp), 8, 4)
    );
END $


DELIMITER ;

select FormatarTelefone(4) AS Telefone;


