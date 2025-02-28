/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.aplicacao.model;

import java.sql.*;
import java.util.ArrayList;
import com.aplicacao.conexao.ConexaoMySQL;
import com.aplicacao.dao.Penalidade;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.time.LocalDate;


/**
 *
 * @author leand
 */
public class PenalidadeModel {
    
    public static void main(String[] args) {
      
        
       
      
     
    }

    public Penalidade consultarPenalidadePorCodigo(int codPenalidade) {
    ConexaoMySQL conexao = new ConexaoMySQL();
    Penalidade penalidade = new Penalidade();
    try (Connection conn = conexao.conectar();
            PreparedStatement stm = conn.prepareStatement("SELECT * FROM Penalidade WHERE cod_penalidade = ?")) {
            stm.setInt(1,codPenalidade);
        try (ResultSet resultado = stm.executeQuery()) {
            if (resultado.next()) {
                penalidade.setCod_penalidade(resultado.getInt("cod_penalidade"));
                penalidade.setTipo(resultado.getString("tipo"));
                penalidade.setQnt_dias(resultado.getInt("qnt_dias"));
                
                LocalDate data_inicio = resultado.getDate("data_inicio").toLocalDate();
                penalidade.setData_inicio(data_inicio);
                
                penalidade.setCod_ocorrencia(resultado.getInt("cod_ocorrencia"));
            }
        }
    } catch (SQLException ex) {
        Logger.getLogger(PenalidadeModel.class.getName()).log(Level.SEVERE, null, ex);
    }
    return penalidade;
}

    /*public ArrayList<Penalidade> consultarPenalidades() {//certo
        ConexaoMySQL conexao = new ConexaoMySQL();
        ArrayList<Penalidade> penalidades = new ArrayList<>();
       
        
        try (Connection conn = conexao.conectar();
             Statement stm = conn.createStatement();
             ResultSet resultado = stm.executeQuery("SELECT * FROM Penalidade ORDER BY cod_penalidade")) {
            while (resultado.next()) {
                Penalidade penalidade = new Penalidade();
  
                penalidade.setCod_penalidade(resultado.getInt("cod_penalidade"));
                    penalidade.setTipo(resultado.getString("tipo"));
                    penalidade.setQnt_dias(resultado.getInt("qnt_dias"));
                    
                    LocalDate data_inicio = resultado.getDate("data_inicio").toLocalDate();
                    penalidade.setData_inicio(data_inicio);
                    
                    penalidade.setCod_ocorrencia(resultado.getInt("cod_ocorrencia"));
                penalidades.add(penalidade);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PenalidadeModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return penalidades;
    }*/
    
    public ArrayList<Penalidade> consultarPenalidades() {
    ConexaoMySQL conexao = new ConexaoMySQL();
    ArrayList<Penalidade> penalidades = new ArrayList<>();
    
    
    try (Connection conn = conexao.conectar();
         Statement stm = conn.createStatement();
         ResultSet resultado = stm.executeQuery("SELECT * FROM Penalidade ORDER BY cod_penalidade")) {
        
        while (resultado.next()) {
            Penalidade penalidade = new Penalidade();

             penalidade.setCod_penalidade(resultado.getInt("cod_penalidade"));
                    penalidade.setTipo(resultado.getString("tipo"));
                    penalidade.setQnt_dias(resultado.getInt("qnt_dias"));
                    
                    LocalDate data_inicio = resultado.getDate("data_inicio").toLocalDate();
                    penalidade.setData_inicio(data_inicio);
                    
                    penalidade.setCod_ocorrencia(resultado.getInt("cod_ocorrencia"));
                    
            penalidades.add(penalidade); //Do codigo
        }
    } catch (SQLException ex) {
        Logger.getLogger(PenalidadeModel.class.getName()).log(Level.SEVERE, null, ex);
    }
    return penalidades;
}

    public String inserirPenalidade(Penalidade penalidade) {//certo
        ConexaoMySQL conexao = new ConexaoMySQL();
        Connection conn = conexao.conectar();
        String resultado = "";
        
        try {

            String consulta ="INSERT INTO Penalidade (cod_penalidade, tipo, data_inicio, qnt_dias, cod_ocorrencia) VALUES (?,?,?,?,?)";
            
            PreparedStatement stm = conn.prepareStatement(consulta);
            stm.setInt(1, penalidade.getCod_penalidade());
            stm.setString(2, penalidade.getTipo());
            stm.setObject(3, penalidade.getData_inicio());
            stm.setInt(4, penalidade.getQnt_dias());
            stm.setInt(5, penalidade.getCod_ocorrencia());
            
            stm.executeUpdate();
            resultado = "inserido";


        } catch (SQLException ex) {
            System.out.println(ex.getSQLState());
            resultado = "erro";
        }
        return resultado;
    }

    public void imprimirPenalidade(Penalidade penalidade) {
        System.out.println("Código do Penalidade: " + penalidade.getCod_penalidade() + "\n" + 
                       "Cod_penalidade: " + penalidade.getCod_penalidade() + "\n" +  
                       "Tipo: " + penalidade.getTipo() + "\n" + 
                       "data_inicio: " + penalidade.getData_inicio() + "\n" +
                       "qnt_dias: " + penalidade.getQnt_dias() + "\n" +
                       "Cod_ocorrencia: " + penalidade.getCod_ocorrencia());
}

    public void imprimirPenalidade(ArrayList<Penalidade> penalidades) {
            for (Penalidade penalidade : penalidades) { 
                System.out.println("Código do Penalidade: " + penalidade.getCod_penalidade() + "\n" + 
                       "Cod_penalidade: " + penalidade.getCod_penalidade() + "\n" +  
                       "Tipo: " + penalidade.getTipo() + "\n" + 
                       "data_inicio: " + penalidade.getData_inicio() + "\n" +
                       "qnt_dias: " + penalidade.getQnt_dias() + "\n" +
                       "Cod_ocorrencia: " + penalidade.getCod_ocorrencia());
    }
}



   public String alterarPenalidade(Penalidade penalidade) {
    ConexaoMySQL conexao = new ConexaoMySQL();
    Connection conn = conexao.conectar();
    String resultado = "";
    try {
        String consulta = "UPDATE penalidade SET tipo = ?, data_inicio = ?, qnt_dias = ?, cod_ocorrencia = ? WHERE cod_penalidade = ?";
        PreparedStatement stm = conn.prepareStatement(consulta);

        // Define os valores para os parâmetros do PreparedStatement
        stm.setString(1, penalidade.getTipo());
        stm.setObject(2, penalidade.getData_inicio());
        stm.setInt(3, penalidade.getQnt_dias());
        stm.setInt(4, penalidade.getCod_ocorrencia());
        stm.setInt(5, penalidade.getCod_penalidade()); // Este deve ser o último parâmetro

        // Executa a atualização no banco de dados
        stm.executeUpdate();
        resultado = "alterado";

    } catch (SQLException ex) {
        System.out.println(ex.getMessage());
        resultado = "erro";
    } finally {
        // Fecha a conexão com o banco de dados
        try {
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(PenalidadeModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    return resultado;
}

    public String removerPenalidade(int penalidade) {//certo
        ConexaoMySQL conexao = new ConexaoMySQL();
        Connection conn = conexao.conectar();
        String resultado = "";
        try {
            String consulta = "DELETE FROM penalidade WHERE cod_penalidade = ?";

            PreparedStatement stm = conn.prepareStatement(consulta);
            stm.setInt(1, penalidade);
            
            stm.executeUpdate();
            resultado = "removido";
        } catch (SQLException ex) {
          System.out.println(ex.getSQLState());
          resultado = "erro";
        } 
        return resultado;
    }
    
    public PenalidadeModel() {
    }
}
