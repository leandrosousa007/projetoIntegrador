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
public class Penalidade {
    private int cod_penalidade;
    private String tipo;
    private LocalDate data_inicio;
    private int qnt_dias;
    private int cod_ocorrencia;

    public int getCod_penalidade() {
        return cod_penalidade;
    }

    public void setCod_penalidade(int cod_penalidade) {
        this.cod_penalidade = cod_penalidade;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public LocalDate getData_inicio() {
        return data_inicio;
    }

    public void setData_inicio(LocalDate data_inicio) {
        this.data_inicio = data_inicio;
    }

    public int getQnt_dias() {
        return qnt_dias;
    }

    public void setQnt_dias(int qnt_dias) {
        this.qnt_dias = qnt_dias;
    }

    public int getCod_ocorrencia() {
        return cod_ocorrencia;
    }

    public void setCod_ocorrencia(int cod_ocorrencia) {
        this.cod_ocorrencia = cod_ocorrencia;
    }

    public Penalidade() {
    }

    public Penalidade(int cod_penalidade, String tipo, LocalDate data_inicio, int qnt_dias, int cod_ocorrencia) {
        this.cod_penalidade = cod_penalidade;
        this.tipo = tipo;
        this.data_inicio = data_inicio;
        this.qnt_dias = qnt_dias;
        this.cod_ocorrencia = cod_ocorrencia;
    }

    public Penalidade(int cod_penalidade) {
        this.cod_penalidade = cod_penalidade;
    }


}
