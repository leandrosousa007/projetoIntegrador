/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.aplicacao.dao;

import java.time.LocalDate;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author ssouz
 */
public class Ocorrencia {
    private int cod_ocorrencia;
    private String campus;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate data_registro_ocorrencia;
    private String resolucao;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate data_acontecimento;
    private String descricao_ocorrencia;
    private int cod_aluno;
    private int cod_funcionario;

    public int getCod_ocorrencia() {
        return cod_ocorrencia;
    }

    public void setCod_ocorrencia(int cod_ocorrencia) {
        this.cod_ocorrencia = cod_ocorrencia;
    }

    public String getCampus() {
        return campus;
    }

    public void setCampus(String campus) {
        this.campus = campus;
    }

    public LocalDate getData_registro_ocorrencia() {
        return data_registro_ocorrencia;
    }

    public void setData_registro_ocorrencia(LocalDate data_registro_ocorrencia) {
        this.data_registro_ocorrencia = data_registro_ocorrencia;
    }

    public String getResolucao() {
        return resolucao;
    }

    public void setResolucao(String resolucao) {
        this.resolucao = resolucao;
    }

    public LocalDate getData_acontecimento() {
        return data_acontecimento;
    }

    public void setData_acontecimento(LocalDate data_acontecimento) {
        this.data_acontecimento = data_acontecimento;
    }

    public String getDescricao_ocorrencia() {
        return descricao_ocorrencia;
    }

    public void setDescricao_ocorrencia(String descricao_ocorrencia) {
        this.descricao_ocorrencia = descricao_ocorrencia;
    }

    public int getCod_aluno() {
        return cod_aluno;
    }

    public void setCod_aluno(int cod_aluno) {
        this.cod_aluno = cod_aluno;
    }

    public int getCod_funcionario() {
        return cod_funcionario;
    }

    public void setCod_funcionario(int cod_funcionario) {
        this.cod_funcionario = cod_funcionario;
    }

    public Ocorrencia() {
    }

    public Ocorrencia(int cod_ocorrencia, String campus, LocalDate data_registro_ocorrencia, String resolucao, LocalDate data_acontecimento, String descricao_ocorrencia, int cod_aluno, int cod_funcionario) {
        this.cod_ocorrencia = cod_ocorrencia;
        this.campus = campus;
        this.data_registro_ocorrencia = data_registro_ocorrencia;
        this.resolucao = resolucao;
        this.data_acontecimento = data_acontecimento;
        this.descricao_ocorrencia = descricao_ocorrencia;
        this.cod_aluno = cod_aluno;
        this.cod_funcionario = cod_funcionario;
    }

    public Ocorrencia(int cod_ocorrencia) {
        this.cod_ocorrencia = cod_ocorrencia;
    }

    
    
    
}
