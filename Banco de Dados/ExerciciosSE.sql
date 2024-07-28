/*Exercício 1---------------------------------------------------*/
-- a) Seleciona os dados dos alunos que nasceram entre 2000-01-01 e 2004-12-31
select *
from Aluno
where data_nasc between '2000-01-01' and'2004-12-31';
/*Exercício 2---------------------------------------------------*/
-- b) Seleciona todos os dados dos alunos que o código é 2,3 e 5
select cod_aluno, sigla, matricula, nome, rg, email, telefone, endereco, sexo, data_nasc
from Aluno, curso
where sigla in ('DS','CC');
/*Exercício 3---------------------------------------------------*/
-- c) Seleciona as ocorrencias no campus A
select *
from ocorrencia
where campus like 'campus A%';
/*Exercício 4---------------------------------------------------*/
-- d) Seleciona todos os dados das turmas de 2022
select *
from turma
where ano = 2022;
/*Exercício 5---------------------------------------------------*/
-- e) Seleciona os dados da turma entre 2002 e 2021
select distinct year(data_matricula) data_matricula, periodo, cod_aluno_turma cod_alt
from turma t, Aluno_turma a
where a.cod_turma = t.cod_turma and year(data_matricula) >= 2018 and
year(data_matricula) <= 2021;
/*Exercício 6---------------------------------------------------*/
-- f) seleciona todos os alunos que não nasceram no ano de 2006
select year(data_nasc) data_nasc,cod_aluno,matricula,nome,rg,email,telefone,endereco,sexo
from Aluno
where year(data_nasc) != 2006;
-- 4)
/*Exercício 1---------------------------------------------------*/
-- a) Seleciona o nome do Aluno,
-- nome do Responsável e email
-- do responsável que possuem inicio do celular 34 e sexo do sexo feminino.
Select a.nome 'Nome do Aluno', r.nome_resp 'Nome do Responsável', r.email ' Email do
Responsável'
From Aluno a
INNER JOIN
Responsavel r ON r.cod_resp = a.cod_resp
Where r.telefone like "34%" and a.sexo = "F";
/*Exercício 2---------------------------------------------------*/
-- b) Seleciona o nome da turma, nome do curso
-- que o ano da turma seja entre 2001 e 2018 e o seu turno seja integral.
Select t.nome_turma 'Nome da Turma', c.nome_curso 'Nome do Curso'
From Curso c
INNER JOIN
Turma t ON c.cod_curso = t.cod_curso
Where t.ano between 2001 and 2018 and t.periodo ="Integral";
/*Exercício 3---------------------------------------------------*/
-- c) Seleciona o tipo de penalidade,
-- descrição da ocorência e
-- a resolução da ocorrência que a quantidade de dias seja igual ou maior que três.
Select p.tipo 'Tipo de Penalidade', o.descricao_ocorrencia 'Descrição da ocorrência',
o.resolucao 'Resolução da Ocorrência'
From Ocorrencia o
INNER JOIN
Penalidade p ON o.cod_ocorrencia = p.cod_ocorrencia
Where p.qnt_dias >= 3;
/*Exercício 4---------------------------------------------------*/
-- d) Seleciona a matrícula do aluno, a sigla do curso e o endereço do responsável.
Select a.matricula 'Matrícula do Aluno', c.sigla ' Sigla do Curso', r.endereco 'Endereço do
Responsável'
From Aluno a
INNER JOIN
Responsavel r ON r.cod_resp = a.cod_resp
INNER JOIN
Curso c ON c.cod_curso = a.cod_curso
Where r.email like "%gmail.com" and c.nome_curso like "%o";
/*Exercício 5---------------------------------------------------*/
-- e) Seleciona os dados do aluno e o ano da turma q
-- que a data da matrícula seja entre 2019-01-01 e 2020-08-30.
Select al.cod_aluno_turma, a.nome 'Nome do Aluno', a.sexo 'Sexo do Aluno', t.ano 'Ano da
Turma'
From Aluno_Turma al
INNER JOIN Turma t ON t.cod_turma = al.cod_turma
INNER JOIN Aluno a ON a.cod_aluno = al.cod_aluno
Where al.data_matricula between "2019-01-01" and "2020-08-30";
-- 5)
use se;
/*Exercício 1 selecione o nome do curso e insira o total de aluno de cada curso*/
select c.cod_curso, count(a.cod_aluno) total_alunos
from Aluno a
INNER JOIN curso c ON c.cod_curso = a.cod_curso
group by cod_curso;
/*Exercício 2-- seleciona o nome do aluno e a quantidade de dias de penalidade por aluno*/
select a.nome, sum(qnt_dias) soma_penalidades
from Penalidade p
Inner JOIN Ocorrencia o ON o.cod_ocorrencia = p.cod_ocorrencia
Inner JOIN Aluno a ON a.cod_aluno = o.cod_aluno
group by a.nome;
/*Exercício 3- selecione o código de curso e coloque o total de alunos que existe*/
select cod_turma, count(*) total_alunos
from Aluno_Turma
group by cod_turma
order by total_alunos desc;
/*Exercício 4 */
/* Selecione o tipo da penalidade e mostra os dias mínimos e máximo de cada penalidade*/
select p.tipo, MIN(qnt_dias) dias_minimos, max(qnt_dias) dias_maximos
from Penalidade p
group by p.tipo;
/*Exercício 5*/
/* Selecione o nome do aluno e mostra a data de registro de ocorrência mais antiga e a mais
recente de cada aluno*/
select a.nome, min(data_registro_ocorrencia) data_mais_antiga,
max(data_registro_ocorrencia) data_mais_recente
from Aluno a
INNER JOIN Ocorrencia o ON a.cod_aluno = o.cod_aluno
group by a.nome;