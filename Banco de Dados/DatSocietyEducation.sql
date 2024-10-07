-- 1)
CREATE DATABASE SE;
USE SE;

CREATE TABLE Responsavel (
    cod_resp int auto_increment PRIMARY KEY,
    nome_resp varchar(50),
    telefone varchar(20),
    email varchar(50),
    endereco varchar(70)
);

CREATE TABLE Curso (
    cod_curso int auto_increment PRIMARY KEY,
    sigla varchar(10),
    nome_curso varchar(50)
);

CREATE TABLE Aluno (
    cod_aluno int auto_increment PRIMARY KEY,
    matricula varchar(20),
    nome varchar(50),
    rg char(10),
    email varchar(50),
    telefone varchar(20),
    endereco varchar(70),
    sexo char(1),
    data_nasc date,
    cod_curso int,
	cod_resp int,
   
    FOREIGN KEY(cod_curso) REFERENCES Curso(cod_curso) ON DELETE CASCADE,
    FOREIGN KEY(cod_resp) REFERENCES Responsavel(cod_resp) ON DELETE CASCADE
);

CREATE TABLE Turma (
    cod_turma int auto_increment PRIMARY KEY,
    nome_turma varchar(50),
    ano int,
    periodo varchar(50),
    cod_curso int,
   
FOREIGN KEY(cod_curso) REFERENCES Curso(cod_curso) ON DELETE CASCADE
    


);

CREATE TABLE Aluno_Turma(
    cod_aluno_turma int auto_increment PRIMARY KEY,
    data_matricula date,
    cod_aluno int,
    cod_turma int,
   
    FOREIGN KEY(cod_turma) REFERENCES Turma (cod_turma) ON DELETE CASCADE,
FOREIGN KEY(cod_aluno) REFERENCES Aluno(cod_aluno) ON DELETE CASCADE
);

CREATE TABLE Funcionario (
    cod_funcionario int auto_increment PRIMARY KEY,
    nome varchar(50),
    cargo varchar(50),
    login varchar(11),
    senha varchar(20)
);

CREATE TABLE Ocorrencia (
    cod_ocorrencia int auto_increment PRIMARY KEY,
    campus varchar(50),
    data_registro_ocorrencia date,
    resolucao varchar(50),
    data_acontecimento date,
    descricao_ocorrencia varchar(500),
    cod_aluno int,
    cod_funcionario int,

    FOREIGN KEY(cod_aluno) REFERENCES Aluno(cod_aluno) ON DELETE CASCADE,
    FOREIGN KEY(cod_funcionario) REFERENCES Funcionario(cod_funcionario) ON DELETE CASCADE
);

CREATE TABLE Penalidade (
    cod_penalidade int AUTO_INCREMENT PRIMARY KEY,
    tipo varchar(50),
    data_inicio date,
    qnt_dias int,
    cod_ocorrencia int,
   
FOREIGN KEY(cod_ocorrencia) REFERENCES Ocorrencia(cod_ocorrencia) ON DELETE CASCADE
);

    
-- 2)


insert into Responsavel(nome_resp,telefone,email,endereco)
values("Luan Santana","34997986954", "luansantana@gmail.com", "Rua do apocalipse, 190, Jardim das Palmeiras,Brasil" ),
( "Humberto Medeiros Coelho","34952486358", "humberto@gmail.com", "Rua do Advogado, 52, Nicovidas, Brasil" ),
( "Kauã Nogueira Reis","34932586450", "kauareis@gmail.com", "Rua Copacabana, 91, Entrevidas, Brasil" ),
( "Miguel Gomes Moreira","34969855412", "miguel@gmail.com", "Rua do Engenheiro, 852, Nicomedes, Brasil" ),
( "Luiz Henrique Nascimento","34985239602", "luiz@gmail.com", "Rua do Arroz, 1, Jardim das Flores, Brasil" ),
( "Luiza Felisberto Nascimento","34978961234", "luiza@outlook.com", "Rua do Feijão, 95, Jardim das Palmeiras, Brasil" ),
( "Maria Fernanda Souza","34925694159", "mafe@gmail.com", "Rua do Leão, 6, Zoológico, Brasil" ),
( "Amanda Miranda","34953285510", "amanda@gmail.com", "Rua do dentista, 10, Jardim das Palmeiras, Brasil" ),
( "Isadora  Carrijo Bacalá","34963254787", "isa@gmail.com", "Rua do Médico, 15, Saraiva, Brasil " ),
( "Rafaela Cruz","34915328460", "rafa@outlook.com", "Rua do Jesus, 110, Morada Nova, Brasil" );



insert into Curso(sigla,nome_curso)
values( "DS", "Desenvolvimento de Sistemas"),
( "CC", "Ciências da Computação"),
( "ADM", "Administração"),
( "MED", "Medicina"),
( "SI", "Sistemas da Informação"),
("RI", "Relações Internacionais");


insert into Aluno(matricula,nome,rg,email,telefone,endereco,sexo,data_nasc,cod_curso,cod_resp)
values ("0654","Mariodo Santana","MG7885561","mariodo@gmail.com","34992587789","Rua do apocalipse, 190, Jardim das Palmeiras,Brasil","M","2006-05-21",2,1),
("5587","Cândida Soares Coelho","MG0213654","candida@gmail.com","34998562145","Rua do Advogado, 52, Nicovidas, Brasil","F","2006-08-03",1,2),
        ("8745","Pedro Nogueira","MG5879851","pedro@gmail.com","34925631452","Rua Copacabana, 91, Entrevidas, Brasil","M","2005-02-28",3,3),
        ("9987","Isabel  Gomes Moreira","MG8745210","isabel@gmail.com","34985471256","Rua do Engenheiro, 852, Nicomedes, Brasil","F","2005-09-01",5,4),
        ("0214","Wander Nascimento","MG0987412","wander@gmail.com","34995687413","Rua do Arroz, 1, Jardim das Flores, Brasil","M","2006-12-28",2,5),
        ("3574","Elisa Felisberto","MG9657431","elisa@gmail.com","34985462356","Rua do Feijão, 95, Jardim das Palmeiras, Brasil","F","2006-11-05",1,6),
        ("5874","Mia Souza","MG5521436","mia@gmail.com","34987459623","Rua do Leão, 6, Zoológico, Brasil","F","2005-07-23",2,7),
        ("6654","Leonardo Miranda","MG1458796","leonardo@yahoo.com","34978541256","Rua do dentista, 10, Jardim das Palmeiras, Brasil","M","2006-10-05",6,8),
        ("3321","Samuel Carrijo Bacalá","MG4513578","samuel@yahoo.com","34989654123","Rua do Médico, 15, Saraiva, Brasil","M","2005-08-27",2,9),
        ("4423","Penélope Cruz","MG3215368","penelope@outlook.com","34987452145","Rua do Jesus, 110, Morada Nova, Brasil","F","2004-07-09",6,10);

insert into Turma(nome_turma,ano,periodo,cod_curso)
values("DS 1B",2022,"Integral",1),
("RI 2A",2020,"Integral",6),
("ADM 3C",2019,"Noturno",3),
("ADM 1B",2015,"Integral",3),
("CC 3B",2000,"Matutino",2),
("CC 3C",2002,"Integral",2),
("RI 1C",2001,"Noturno",6),
("MED 1A",1988,"Integral",4),
("SI 2C",2022, "Noturno",5),
("DS 2A",2021,"Matutino",1);

insert into Aluno_Turma(data_matricula,cod_aluno,cod_turma)
values("2020-12-25",1,2),
("2019-06-17",3,10),
("2020-04-30",9,10),
("2020-07-13",7,9),
("2020-09-18",6,4),
("2019-04-18",3,2),
("2020-09-18",2,6),
("2020-09-18",8,5),
("2020-09-18",10,3),
("2020-09-18",5,6);


insert into Funcionario(nome,cargo,login,senha)
values("José Almeida","Jardineiro","jose","jose123"),
("Gabriel Souza","Cozinheiro","gabriel","gabriel123"),
("Lara","Diretora","lara","lara123"),
( "Cricia","Supervisora","cricia","cricia123"),
( "Samia","Coordenadora","samia","samia123"),
( "Sansa Education","root","sansa","sansa123");


insert into Ocorrencia(campus,data_registro_ocorrencia,resolucao,data_acontecimento,descricao_ocorrencia,cod_aluno,cod_funcionario)
values( "campus A", "2023-05-10", "Em andamento", "2023-05-11", "O aluno se envolveu em uma briga durante o intervalo", 1,1),
( "campus B", "2023-05-15", "Concluída", "2023-05-16", "Foi relatado que o aluno estava envolvido em uma atividade de bullying", 2,1),
( "campus B", "2023-05-20", "Concluída", "2023-05-03", "O aluno foi pego colando durante a prova", 9,2),
( "campus A", "2023-05-22", "Em andamento", "2023-05-07", "O aluno foi pego vandalizando uma sala de aula após o horário de aula", 4,3),
( "campus C", "2023-05-23", "Concluída", "2023-05-08", "Houve um aluno que foi furtado no estacionamento da escola, no fim do período de aula", 10,3),
( "campus A", "2023-04-03", "Concluída", "2023-04-03", "O aluno destruiu a carteira do colega", 10,5),
( "campus B", "2023-06-20", "Em andamento", "2023-06-20", "O aluno empurrou a coordenadora", 7,4),
( "campus C", "2023-12-09", "Concluída", "2023-12-09", "O aluno pichou o banheiro", 10,1),
("campus A", "2023-05-28", "Em andamento", "2023-05-08", "O aluno relatou ser vítima de assédio verbal por parte de outro aluno durante uma atividade extracurricular", 7,4),
( "campus A", "2023-11-01", "Concluída", "2023-05-08", "O aluno quebrou a vidro do quadro.", 7,5);


insert into Penalidade (tipo,data_inicio,qnt_dias,cod_ocorrencia)
values("Advertência escrita", "2022-06-09", 0, 3),
("Advertência oral", "2022-12-09", 0, 4),
("Suspensão", "2022-05-04", 3, 1),
("Desligamento da matricula", "2022-02-09", 0, 2),
("Chamar responsáveis", "2022-06-09", 0, 6),
("Suspensão","2023-05-23",4 , 5),
("Suspensão","2023-06-20",6 ,7 ),
("Advertencia escrita","2023-12-09",3 ,8 ),
("Chamar responsáveis","2023-05-28",1 ,9 ),
("Suspensão","2023-11-01", 2,10);


