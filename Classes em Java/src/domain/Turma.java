package domain;

import java.util.List;

public class Turma {

private Integer codTurma;

private String ano;

private String periodo;

private Curso curso;

private List<Aluno> alunos;

public Turma(Integer codTurma, String ano, String periodo, Curso curso) {
    this.codTurma = codTurma;
    this.ano = ano;
    this.periodo = periodo;
    this.curso = curso;
}

public Integer getCodTurma() {
    return codTurma;
}

public void setCodTurma(Integer codTurma) {
    this.codTurma = codTurma;
}

public String getAno() {
    return ano;
}

public void setAno(String ano) {
    this.ano = ano;
}

public String getPeriodo() {
    return periodo;
}

public void setPeriodo(String periodo) {
    this.periodo = periodo;
}

public Curso getCurso() {
    return curso;
}

public void setCurso(Curso curso) {
    this.curso = curso;
}

public List<Aluno> getAlunos() {
    return alunos;
}

public void setAlunos(List<Aluno> alunos) {
    this.alunos = alunos;
}


@Override
public String toString() {
    return "Turma [codTurma=" + codTurma + ", ano=" + ano + ", periodo=" + periodo + ", curso=" + curso + ", alunos="
            + alunos + "]";
}



}
