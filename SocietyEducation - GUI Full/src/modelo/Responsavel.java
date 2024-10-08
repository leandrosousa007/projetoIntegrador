/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author ssouz
 */
public class Responsavel {
    private int cod_resp;
    private String nome_resp;
    private String telefone;
    private String email;
    private String endereco;

    public int getCod_resp() {
        return cod_resp;
    }

    public void setCod_resp(int cod_resp) {
        this.cod_resp = cod_resp;
    }

    public String getNome_resp() {
        return nome_resp;
    }

    public void setNome_resp(String nome_resp) {
        this.nome_resp = nome_resp;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public Responsavel(int cod_resp, String nome_resp, String telefone, String email, String endereco) {
        this.cod_resp = cod_resp;
        this.nome_resp = nome_resp;
        this.telefone = telefone;
        this.email = email;
        this.endereco = endereco;
    }

    public Responsavel() {
    }

    public Responsavel(int cod_resp) {
        this.cod_resp = cod_resp;
    }
    
    
}
