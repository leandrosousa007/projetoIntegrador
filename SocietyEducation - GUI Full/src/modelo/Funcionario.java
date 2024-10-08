/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author ssouz
 */
public class Funcionario {
    private int cod_funcionario;
    private String nome;
    private String cargo;

    public int getCod_funcionario() {
        return cod_funcionario;
    }

    public void setCod_funcionario(int cod_funcionario) {
        this.cod_funcionario = cod_funcionario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public Funcionario() {
    }

    public Funcionario(int cod_funcionario, String nome, String cargo) {
        this.cod_funcionario = cod_funcionario;
        this.nome = nome;
        this.cargo = cargo;
    }

    public Funcionario(int cod_funcionario) {
        this.cod_funcionario = cod_funcionario;
    }
    
    
    
    
}
