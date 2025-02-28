/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.aplicacao.model;

import java.sql.*;
import java.util.ArrayList;
import com.aplicacao.conexao.ConexaoMySQL;
import com.aplicacao.dao.Responsavel;
import java.util.logging.Level;
import java.util.logging.Logger;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author leand
 */
public class ResponsavelModel {
    
    public static void main(String[] args) {
     
     
    }

    public Responsavel consultarResponsavelPorCodigo(int codResponsavel) {
        ConexaoMySQL conexao = new ConexaoMySQL();
        Responsavel responsavel = new Responsavel();
        try (Connection conn = conexao.conectar();
                PreparedStatement stm = conn.prepareStatement("SELECT * FROM Responsavel WHERE cod_resp = ?")) {
            stm.setInt(1, codResponsavel);
            try (ResultSet resultado = stm.executeQuery()) {
                if (resultado.next()) {
                    responsavel.setCod_resp(resultado.getInt("cod_resp"));
                    responsavel.setNome_resp(resultado.getString("nome_resp"));
                    responsavel.setTelefone(resultado.getString("telefone"));
                    responsavel.setEmail(resultado.getString("email"));
                    responsavel.setEndereco(resultado.getString("endereco"));
            }
        }
    } catch (SQLException ex) {
        Logger.getLogger(ResponsavelModel.class.getName()).log(Level.SEVERE, null, ex);
    }
    return responsavel;
}

    
    
    public ArrayList<Responsavel> consultarResponsaveis() {
    ConexaoMySQL conexao = new ConexaoMySQL();
    ArrayList<Responsavel> responsaveis = new ArrayList<>();
    
    try (Connection conn = conexao.conectar();
         Statement stm = conn.createStatement();
         ResultSet resultado = stm.executeQuery("SELECT * FROM Responsavel ORDER BY cod_resp")) {
        
        while (resultado.next()) {
            Responsavel responsavel = new Responsavel();

            responsavel.setCod_resp(resultado.getInt("cod_resp"));
            responsavel.setNome_resp(resultado.getString("nome_resp")); // Corrigido para recuperar o nome do responsável
            responsavel.setTelefone(resultado.getString("telefone"));
            responsavel.setEmail(resultado.getString("email")); // Corrigido para recuperar o email do responsável
            responsavel.setEndereco(resultado.getString("endereco")); // Corrigido para recuperar o endereco do responsável
            responsaveis.add(responsavel);
        }
    } catch (SQLException ex) {
        Logger.getLogger(ResponsavelModel.class.getName()).log(Level.SEVERE, null, ex);
    }
    return responsaveis;
}
    
    

    public String inserirResponsavel(Responsavel responsavel) {//certo
        ConexaoMySQL conexao = new ConexaoMySQL();
        Connection conn = conexao.conectar();
        String resultado = "";
        
        try {

            String consulta ="INSERT INTO Responsavel (cod_resp, nome_resp, telefone, email, endereco) VALUES (?,?,?,?,?)";
            
            PreparedStatement stm = conn.prepareStatement(consulta);
            stm.setInt(1, responsavel.getCod_resp());
            stm.setString(2, responsavel.getNome_resp());
            stm.setString(3, responsavel.getTelefone());
            stm.setString(4, responsavel.getEmail());
            stm.setString(5, responsavel.getEndereco());
            
            stm.executeUpdate();
            resultado = "inserido";


        } catch (SQLException ex) {
            System.out.println(ex.getSQLState());
            resultado = "erro";
        }
        return resultado;
    }

    public void imprimirResponsavel(Responsavel responsavel) {
        System.out.println("Código do Responsavel: " + responsavel.getCod_resp() + "\n" + 
                       "Nome Responsavel: " + responsavel.getNome_resp() + "\n" +  
                       "RG: " + responsavel.getTelefone() + "\n" +
                       "Email: " + responsavel.getEmail() + "\n" +
                       "Endereco: " + responsavel.getEndereco());
}

    public void imprimirResponsavel(ArrayList<Responsavel> responsaveis) {
            for (Responsavel responsavel : responsaveis) { 
                System.out.println("Código do Responsavel: " + responsavel.getCod_resp() + "\n" + 
                       "Nome Responsavel: " + responsavel.getNome_resp() + "\n" +  
                       "RG: " + responsavel.getTelefone() + "\n" +
                       "Email: " + responsavel.getEmail() + "\n" +
                       "Endereco: " + responsavel.getEndereco());
    }
}



   public String alterarResponsavel(Responsavel responsavel) {
    ConexaoMySQL conexao = new ConexaoMySQL();
    Connection conn = null;
    String resultado = "";
    try {
        conn = conexao.conectar();
        String consulta = "UPDATE Responsavel SET nome_resp = ?, telefone = ?, email = ?, endereco = ? WHERE cod_resp = ?";
        PreparedStatement stm = conn.prepareStatement(consulta);

        stm.setString(1, responsavel.getNome_resp());
        stm.setString(2, responsavel.getTelefone());
        stm.setString(3, responsavel.getEmail());
        stm.setString(4, responsavel.getEndereco());
        stm.setInt(5, responsavel.getCod_resp());

        int linhasAfetadas = stm.executeUpdate();
        
        if (linhasAfetadas > 0) {
            resultado = "alterado";
        } else {
            resultado = "erro";
        }

    } catch (SQLException ex) {
        resultado = "erro";
        
    } finally {
        // Fechando a conexão após o uso
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException ex) {
                System.out.println("erro");
            }
        }
    }
    
    return resultado;
}
    
    
    

    public String removerResponsavel(int responsavel) {
    ConexaoMySQL conexao = new ConexaoMySQL();
    Connection conn = conexao.conectar();
    String resultado = "";
    try {
        String consulta = "DELETE FROM responsavel WHERE cod_resp = ?";

        PreparedStatement stm = conn.prepareStatement(consulta);
        stm.setInt(1, responsavel);
        
        stm.executeUpdate();
        resultado = "removido";
    } catch (SQLException ex) {
        System.out.println(ex.getSQLState());
        resultado = "erro";
    } 
    return resultado;
}
    
    

    public ResponsavelModel() {
    }
}
