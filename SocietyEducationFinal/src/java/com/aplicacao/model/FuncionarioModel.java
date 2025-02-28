/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.aplicacao.model;

import java.sql.*;
import java.util.ArrayList;
import com.aplicacao.conexao.ConexaoMySQL;
import com.aplicacao.dao.Funcionario;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author leand
 */
public class FuncionarioModel {
    
    public static void main(String[] args) {
     
    }

    public Funcionario consultarFuncionarioPorCodigo(int codFuncionario) {
        ConexaoMySQL conexao = new ConexaoMySQL();
        Funcionario funcionario = new Funcionario();
        try (Connection conn = conexao.conectar();
                PreparedStatement stm = conn.prepareStatement("SELECT * FROM Funcionario WHERE cod_funcionario = ?")) {
                stm.setInt(1,codFuncionario);
            try (ResultSet resultado = stm.executeQuery()) {
                if (resultado.next()) {
                    funcionario.setCod_funcionario(resultado.getInt("cod_funcionario"));
                    funcionario.setNome(resultado.getString("nome"));
                    funcionario.setCargo(resultado.getString("cargo"));
                    funcionario.setLogin(resultado.getString("login"));
                    funcionario.setSenha(resultado.getString("senha"));
                    
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(FuncionarioModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return funcionario;
    }

    
   public ArrayList<Funcionario> consultarFuncionarios() {
    ConexaoMySQL conexao = new ConexaoMySQL();
    ArrayList<Funcionario> funcionarios = new ArrayList<>();
    
    try (Connection conn = conexao.conectar();
         Statement stm = conn.createStatement();
         ResultSet resultado = stm.executeQuery("SELECT * FROM Funcionario ORDER BY cod_funcionario")) {
        
        while (resultado.next()) {
            Funcionario funcionario = new Funcionario();

            funcionario.setCod_funcionario(resultado.getInt("cod_funcionario"));
            funcionario.setNome(resultado.getString("nome"));
            funcionario.setCargo(resultado.getString("cargo"));
            funcionario.setLogin(resultado.getString("login"));
            funcionario.setSenha(resultado.getString("senha"));
            funcionarios.add(funcionario); // Adicionando o funcionário à lista
        }
    } catch (SQLException ex) {
        Logger.getLogger(FuncionarioModel.class.getName()).log(Level.SEVERE, null, ex);
    }
    
    return funcionarios;
}
    
   
   public String inserirFuncionario(Funcionario funcionario) {
    ConexaoMySQL conexao = new ConexaoMySQL();
    Connection conn = conexao.conectar();
    String resultado = "";
    
    try {
        if (funcionario.getNome() != null && !funcionario.getNome().isEmpty() && 
            funcionario.getCargo() != null && !funcionario.getCargo().isEmpty()) {

            String consulta = "INSERT INTO Funcionario (nome, cargo,login,senha) VALUES (?, ?,?,?)";
            
            PreparedStatement stm = conn.prepareStatement(consulta);
            stm.setString(1, funcionario.getNome());
            stm.setString(2, funcionario.getCargo());
            stm.setString(3, funcionario.getLogin());
            stm.setString(4, funcionario.getSenha());
            
            stm.executeUpdate();
            resultado = "inserido";

        } 

    } catch (SQLException ex) {
        resultado = "erro";
    }
    return resultado;
}
   

    public void imprimirFuncionario(Funcionario funcionario) {
        System.out.println("Código do Funcionario: " + funcionario.getCod_funcionario() + "\n" +   
                       "Nome: " + funcionario.getNome() + "\n" + 
                       "Cargo: " + funcionario.getCargo());
}

    public void imprimirFuncionario(ArrayList<Funcionario> funcionarios) {
            for (Funcionario funcionario : funcionarios) { 
                 System.out.println("Código do Funcionario: " + funcionario.getCod_funcionario() + "\n" +   
                       "Nome: " + funcionario.getNome() + "\n" + 
                       "Cargo: " + funcionario.getCargo());
                 
    }
}

   public String alterarFuncionario(Funcionario funcionario) {
    ConexaoMySQL conexao = new ConexaoMySQL();
    Connection conn = conexao.conectar();
    String resultado = "";
    try {
        String consulta = "UPDATE funcionario SET nome = ?, cargo = ?, login=?, senha=? WHERE cod_funcionario = ?";
        PreparedStatement stm = conn.prepareStatement(consulta);

        stm.setString(1, funcionario.getNome());
        stm.setString(2, funcionario.getCargo());
        stm.setString(3, funcionario.getSenha());
        stm.setString(4, funcionario.getLogin());
        
        stm.setInt(5, funcionario.getCod_funcionario());

        stm.executeUpdate();
        resultado = "alterado";

    } catch (SQLException ex) {
        System.out.println(ex.getMessage());
        resultado = "erro";
    }
    return resultado;
}

    public String removerFuncionario(int funcionario) {//certo
        ConexaoMySQL conexao = new ConexaoMySQL();
        Connection conn = conexao.conectar();
        String resultado = "";
        try {
            String consulta = "DELETE FROM funcionario WHERE cod_funcionario = ?";

            PreparedStatement stm = conn.prepareStatement(consulta);
            stm.setInt(1, funcionario);
            
            stm.executeUpdate();
            resultado = "removido";
        } catch (SQLException ex) {
          System.out.println(ex.getSQLState());
          resultado = "erro";
        } 
        return resultado;
    }
    
    public Funcionario validarCredenciais(String login, String senha) {
    Funcionario funcionario = null;
    ConexaoMySQL conexao = new ConexaoMySQL();
    Connection conn = conexao.conectar();
    
    try{
        
        String consulta = "SELECT * FROM Funcionario WHERE login = ? AND senha = ?";
        PreparedStatement stm = conn.prepareStatement(consulta);
        
        stm.setString(1, login);
        stm.setString(2, senha);

        try (ResultSet rs = stm .executeQuery()) {
            if (rs.next()) {
                funcionario = new Funcionario();
                funcionario.setCod_funcionario(rs.getInt("cod_funcionario"));
                funcionario.setNome(rs.getString("nome"));
                funcionario.setCargo(rs.getString("cargo"));
                funcionario.setLogin(rs.getString("login"));
                
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }

    return funcionario;
}



    public FuncionarioModel() {
    }
}
