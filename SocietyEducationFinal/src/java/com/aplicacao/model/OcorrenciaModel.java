/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.aplicacao.model;

import java.sql.*;
import java.util.ArrayList;
import com.aplicacao.conexao.ConexaoMySQL;
import com.aplicacao.dao.Ocorrencia;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author leand
 */
public class OcorrenciaModel {
    
    public static void main(String[] args) {
 
    }

    public Ocorrencia consultarOcorrenciaPorCodigo(int codOcorrencia) {
        ConexaoMySQL conexao = new ConexaoMySQL();
        Ocorrencia ocorrencia = new Ocorrencia();
        try (Connection conn = conexao.conectar();
                PreparedStatement stm = conn.prepareStatement("SELECT * FROM Ocorrencia WHERE cod_ocorrencia = ?")) {
                stm.setInt(1,codOcorrencia);
            try (ResultSet resultado = stm.executeQuery()) {
                if (resultado.next()) {
                    ocorrencia.setCod_ocorrencia(resultado.getInt("cod_ocorrencia"));
                    ocorrencia.setCampus(resultado.getString("Campus"));
                    ocorrencia.setResolucao(resultado.getString("resolucao"));
                    ocorrencia.setDescricao_ocorrencia(resultado.getString("descricao_ocorrencia"));
                    
                    LocalDate dataRegistroOcorrencia = resultado.getDate("data_registro_ocorrencia").toLocalDate();
                    ocorrencia.setData_registro_ocorrencia(dataRegistroOcorrencia);
                    
                    LocalDate dataAcontecimento = resultado.getDate("data_acontecimento").toLocalDate();
                    ocorrencia.setData_acontecimento(dataAcontecimento);
                    
                    ocorrencia.setCod_aluno(resultado.getInt("cod_aluno"));
                    ocorrencia.setCod_funcionario(resultado.getInt("cod_funcionario"));
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(OcorrenciaModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ocorrencia;
    }

 
    
    public ArrayList<Ocorrencia> consultarOcorrencias() {
    ConexaoMySQL conexao = new ConexaoMySQL();
    ArrayList<Ocorrencia> ocorrencias = new ArrayList<>();
    
    
    try (Connection conn = conexao.conectar();
         Statement stm = conn.createStatement();
         ResultSet resultado = stm.executeQuery("SELECT * FROM Ocorrencia ORDER BY cod_ocorrencia")) {
        
        while (resultado.next()) {
            Ocorrencia ocorrencia = new Ocorrencia();

            ocorrencia.setCod_ocorrencia(resultado.getInt("cod_ocorrencia"));
                    ocorrencia.setCampus(resultado.getString("Campus"));
                    ocorrencia.setResolucao(resultado.getString("resolucao"));
                    ocorrencia.setDescricao_ocorrencia(resultado.getString("descricao_ocorrencia"));
                    
                    LocalDate dataRegistroOcorrencia = resultado.getDate("data_registro_ocorrencia").toLocalDate();
                    ocorrencia.setData_registro_ocorrencia(dataRegistroOcorrencia);
                    
                    LocalDate dataAcontecimento = resultado.getDate("data_acontecimento").toLocalDate();
                    ocorrencia.setData_acontecimento(dataAcontecimento);
                    
                    ocorrencia.setCod_aluno(resultado.getInt("cod_aluno"));
                    ocorrencia.setCod_funcionario(resultado.getInt("cod_funcionario"));
                    
            ocorrencias.add(ocorrencia);
        }
    } catch (SQLException ex) {
        Logger.getLogger(OcorrenciaModel.class.getName()).log(Level.SEVERE, null, ex);
    }
    return ocorrencias;
}

    
     public String inserirOcorrencia(Ocorrencia ocorrencia) {
        ConexaoMySQL conexao = new ConexaoMySQL();
        Connection conn = conexao.conectar();
        String resultado = "";

        try {
            String consulta = "INSERT INTO Ocorrencia (Campus, resolucao, descricao_ocorrencia, data_registro_ocorrencia, data_acontecimento, cod_aluno, cod_funcionario) VALUES (?,?,?,?,?,?,?)";

            PreparedStatement stm = conn.prepareStatement(consulta);
            stm.setString(1, ocorrencia.getCampus());
            stm.setString(2, ocorrencia.getResolucao());
            stm.setString(3, ocorrencia.getDescricao_ocorrencia());
            stm.setObject(4, java.sql.Date.valueOf(ocorrencia.getData_registro_ocorrencia()));
            stm.setObject(5, java.sql.Date.valueOf(ocorrencia.getData_acontecimento()));
            stm.setInt(6, ocorrencia.getCod_aluno());
            stm.setInt(7, ocorrencia.getCod_funcionario());

            stm.executeUpdate();
            resultado = "inserido";

        } catch (SQLException ex) {
            System.out.println(ex.getSQLState());
            resultado = "erro";
        }
        return resultado;
    }
    

    public void imprimirOcorrencia(Ocorrencia ocorrencia) {
        System.out.println("Código do Ocorrencia: " + ocorrencia.getCod_ocorrencia() + "\n" + 
                       "Campus: " + ocorrencia.getCampus() + "\n" +  
                       "Data_registro_ocorrencia: " + ocorrencia.getData_registro_ocorrencia() + "\n" + 
                       "Resolucao: " + ocorrencia.getResolucao() + "\n" +
                       "Data_acontecimento: " + ocorrencia.getData_acontecimento() + "\n" +
                       "Cod_aluno: " + ocorrencia.getCod_aluno() + "\n" +
                       "Cod_funcionario: " + ocorrencia.getCod_funcionario());
}

    public void imprimirOcorrencia(ArrayList<Ocorrencia> ocorrencias) {
            for (Ocorrencia ocorrencia : ocorrencias) { 
                System.out.println("Código do Ocorrencia: " + ocorrencia.getCod_ocorrencia() + "\n" + 
                       "Campus: " + ocorrencia.getCampus() + "\n" +  
                       "Data_registro_ocorrencia: " + ocorrencia.getData_registro_ocorrencia() + "\n" + 
                       "Resolucao: " + ocorrencia.getResolucao() + "\n" +
                       "Data_acontecimento: " + ocorrencia.getData_acontecimento() + "\n" +
                       "Cod_aluno: " + ocorrencia.getCod_aluno() + "\n" +
                       "Cod_funcionario: " + ocorrencia.getCod_funcionario());
                                System.out.println("--------------------------------------");

    }
}



   public String alterarOcorrencia(Ocorrencia ocorrencia) {
    ConexaoMySQL conexao = new ConexaoMySQL();
    Connection conn = conexao.conectar();
    String resultado = "";

    try {
        String consulta = "UPDATE ocorrencia SET Campus = ?, resolucao = ?, descricao_ocorrencia = ?, data_registro_ocorrencia = ?, data_acontecimento = ?, cod_aluno = ?, cod_funcionario = ? WHERE cod_ocorrencia = ?";

        PreparedStatement stm = conn.prepareStatement(consulta);

        stm.setString(1, ocorrencia.getCampus());
        stm.setString(2, ocorrencia.getResolucao());
        stm.setString(3, ocorrencia.getDescricao_ocorrencia());
        stm.setObject(4, java.sql.Date.valueOf(LocalDate.now())); // Define a data de registro como a data atual
        stm.setObject(5, java.sql.Date.valueOf(ocorrencia.getData_acontecimento())); // Supondo que getData_acontecimento() retorne um objeto LocalDate
        stm.setInt(6, ocorrencia.getCod_aluno());
        stm.setInt(7, ocorrencia.getCod_funcionario());
        stm.setInt(8, ocorrencia.getCod_ocorrencia()); // Adicionei o código da ocorrência como último parâmetro

        stm.executeUpdate();
        resultado = "alterado";

    } catch (SQLException ex) {
        System.out.println(ex.getMessage());
        resultado = "erro";
    }

    return resultado;
}

    public String removerOcorrencia(int ocorrencia) {//certo
        ConexaoMySQL conexao = new ConexaoMySQL();
        Connection conn = conexao.conectar();
        String resultado = "";
        try {
            String consulta = "DELETE FROM ocorrencia WHERE cod_ocorrencia = ?";

            PreparedStatement stm = conn.prepareStatement(consulta);
            stm.setInt(1, ocorrencia);
            
            stm.executeUpdate();
            resultado = "removido";
        } catch (SQLException ex) {
          System.out.println(ex.getSQLState());
          resultado = "erro";
        } 
        return resultado;
    }
    
    

    public OcorrenciaModel() {
    }
}
