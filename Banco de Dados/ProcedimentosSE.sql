-- Criação de Procedimentos
Use SE;

-- Procedimento 1

DELIMITER $
CREATE PROCEDURE FiltrarOcorrencias(
    IN palavra_chave VARCHAR(50)
)
BEGIN
    SELECT a.nome AS nome_aluno, o.data_registro_ocorrencia, o.descricao_ocorrencia
    FROM Aluno a INNER JOIN Ocorrencia o ON a.cod_aluno = o.cod_aluno
    WHERE o.descricao_ocorrencia LIKE CONCAT('%', palavra_chave, '%');
END $
DELIMITER ;

CALL FiltrarOcorrencias('joelh');

-- Procedimento 2

DELIMITER $

CREATE FUNCTION DiaPenalidade(tipo_ocorrencia VARCHAR(50)) 
RETURNS INT
BEGIN
    DECLARE dias_penalidade INT;

    CASE tipo_ocorrencia
        WHEN 'Advertência escrita' THEN SET dias_penalidade = 2;
        WHEN 'Advertência oral' THEN SET dias_penalidade = 0;
        WHEN 'Suspensão' THEN SET dias_penalidade = 3;
        WHEN 'Desligamento da matrícula' THEN SET dias_penalidade = 365;
        WHEN 'Chamar responsáveis' THEN SET dias_penalidade = 1;
        ELSE SET dias_penalidade = 0; 
    END CASE;

    RETURN dias_penalidade;
END $
DELIMITER ;

DELIMITER $
CREATE PROCEDURE AplicarPenalidade(
    IN cod_ocorrenciaA INT,
    IN tipo_ocorrenciaA VARCHAR(50)
)
BEGIN
    DECLARE dias_penalidade INT;

    SET dias_penalidade = DiaPenalidade(tipo_ocorrenciaA);

    INSERT INTO Penalidade(tipo, data_inicio, qnt_dias, cod_ocorrencia)
    VALUES (tipo_ocorrenciaA, CURDATE(), dias_penalidade, cod_ocorrenciaA);

    SELECT 'Penalidade aplicada com sucesso' AS status;
END $
DELIMITER ;

CALL AplicarPenalidade(3, 'Suspensão');
select * from Penalidade;

-- Procedimento 3

DELIMITER $
CREATE PROCEDURE InserirTurma(
    IN cod_turmaA INT,
    IN nome_turmaA VARCHAR(50),
    IN anoA INT,
    IN periodoA VARCHAR(50),
    IN cod_cursoA INT
)
BEGIN
    -- Condição
    IF cod_turmaA IS NULL OR nome_turmaA IS NULL OR anoA IS NULL OR periodoA IS NULL OR cod_cursoA IS NULL THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'Todos os campos obrigatórios devem ser preenchidos';
    ELSE
        INSERT INTO Turma(cod_turma, nome_turma, ano, periodo, cod_curso)
        VALUES (cod_turmaA, nome_turmaA, anoA, periodoA, cod_cursoA);

        SELECT 'Inserção concluída com sucesso' AS status;
    END IF;
END $
DELIMITER ;

CALL InserirTurma(null, 'ADM', 3050, 'EAD', 3);
select * from Turma;


