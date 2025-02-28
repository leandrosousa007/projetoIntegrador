/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.aplicacao.dao;

import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author ssouz
 */
public class Turma {
    private int cod_turma;
    private String nome_turma;
    private int ano;
    private String periodo;
    private int cod_curso;

    public int getCod_turma() {
        return cod_turma;
    }

    public void setCod_turma(int cod_turma) {
        this.cod_turma = cod_turma;
    }

    public String getNome_turma() {
        return nome_turma;
    }

    public void setNome_turma(String nome_turma) {
        this.nome_turma = nome_turma;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public int getCod_curso() {
        return cod_curso;
    }

    public void setCod_curso(int cod_curso) {
        this.cod_curso = cod_curso;
    }

    public Turma(int cod_turma, String nome_turma, int ano, String periodo, int cod_curso) {
        this.cod_turma = cod_turma;
        this.nome_turma = nome_turma;
        this.ano = ano;
        this.periodo = periodo;
        this.cod_curso = cod_curso;
    }

    public Turma() {
    }

    public Turma(int cod_turma) {
        this.cod_turma = cod_turma;
    }
    
    
}
