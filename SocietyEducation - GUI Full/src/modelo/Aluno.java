/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.time.LocalDate;

/**
 *
 * @author leand
 */
public class Aluno {
    private int cod_aluno;
    private String matricula;
    private String nome;
    private String rg;
    private String email;
    private String telefone;
    private String endereco;
    private char sexo;
    private LocalDate data_nasc;
    private int cod_curso;
    private int cod_resp;

    public int getCod_aluno() {
        return cod_aluno;
    }

    public void setCod_aluno(int cod_aluno) {
        this.cod_aluno = cod_aluno;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public LocalDate getData_nasc() {
        return data_nasc;
    }

    public void setData_nasc(LocalDate data_nasc) {
        this.data_nasc = data_nasc;
    }

    public int getCod_curso() {
        return cod_curso;
    }

    public void setCod_curso(int cod_curso) {
        this.cod_curso = cod_curso;
    }

    public int getCod_resp() {
        return cod_resp;
    }

    public void setCod_resp(int cod_resp) {
        this.cod_resp = cod_resp;
    }

    public Aluno(int cod_aluno, String matricula, String nome, String rg, String email, String telefone, String endereco, char sexo, LocalDate data_nasc, int cod_curso, int cod_resp) {
        this.cod_aluno = cod_aluno;
        this.matricula = matricula;
        this.nome = nome;
        this.rg = rg;
        this.email = email;
        this.telefone = telefone;
        this.endereco = endereco;
        this.sexo = sexo;
        this.data_nasc = data_nasc;
        this.cod_curso = cod_curso;
        this.cod_resp = cod_resp;
    }

    public Aluno(int cod_aluno) {
        this.cod_aluno = cod_aluno;
    }

    public Aluno() {
    }



}


