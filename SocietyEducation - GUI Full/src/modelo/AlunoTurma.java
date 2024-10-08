/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.time.LocalDate;

/**
 *
 * @author ssouz
 */
public class AlunoTurma {
    
    private int cod_aluno_turma;
    private LocalDate data_matricula;
    private int cod_aluno;
    private int cod_turma;

    public int getCod_aluno_turma() {
        return cod_aluno_turma;
    }

    public void setCod_aluno_turma(int cod_aluno_turma) {
        this.cod_aluno_turma = cod_aluno_turma;
    }

    public LocalDate getData_matricula() {
        return data_matricula;
    }

    public void setData_matricula(LocalDate data_matricula) {
        this.data_matricula = data_matricula;
    }

    public int getCod_aluno() {
        return cod_aluno;
    }

    public void setCod_aluno(int cod_aluno) {
        this.cod_aluno = cod_aluno;
    }

    public int getCod_turma() {
        return cod_turma;
    }

    public void setCod_turma(int cod_turma) {
        this.cod_turma = cod_turma;
    }

    public AlunoTurma() {
    }

    public AlunoTurma(int cod_aluno_turma, LocalDate data_matricula, int cod_aluno, int cod_turma) {
        this.cod_aluno_turma = cod_aluno_turma;
        this.data_matricula = data_matricula;
        this.cod_aluno = cod_aluno;
        this.cod_turma = cod_turma;
    }

    public AlunoTurma(int cod_aluno_turma) {
        this.cod_aluno_turma = cod_aluno_turma;
    }
    
    
    
}
