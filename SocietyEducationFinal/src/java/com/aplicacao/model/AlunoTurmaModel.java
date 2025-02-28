/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.aplicacao.model;

import java.sql.*;
import java.util.ArrayList;
import com.aplicacao.conexao.ConexaoMySQL;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.aplicacao.dao.AlunoTurma;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author leand
 */
public class AlunoTurmaModel {
    
    public static void main(String[] args) {   
     
    }

    public AlunoTurma consultarAlunoTurmaPorCodigo(int codAlunoTurma) {
        ConexaoMySQL conexao = new ConexaoMySQL();
        AlunoTurma alunoTurma = new AlunoTurma();
        try (Connection conn = conexao.conectar();
                PreparedStatement stm = conn.prepareStatement("SELECT * FROM aluno_turma WHERE cod_aluno_turma = ?")) {
                stm.setInt(1,codAlunoTurma);
            try (ResultSet resultado = stm.executeQuery()) {
                if (resultado.next()) {
                    alunoTurma.setCod_aluno_turma(resultado.getInt("cod_aluno_turma"));
                   
               
                    LocalDate dataMatricula = resultado.getDate("data_matricula").toLocalDate();
                    alunoTurma.setData_matricula(dataMatricula);
                    
                    alunoTurma.setCod_aluno(resultado.getInt("cod_aluno"));
                    alunoTurma.setCod_turma(resultado.getInt("cod_turma"));
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(AlunoTurmaModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return alunoTurma;
    }
    
   public ArrayList<AlunoTurma> consultarAlunoTurma() {
    ConexaoMySQL conexao = new ConexaoMySQL();
    ArrayList<AlunoTurma> alunoTurmas = new ArrayList<>();
    
    try (Connection conn = conexao.conectar();
         Statement stm = conn.createStatement();
         ResultSet resultado = stm.executeQuery("SELECT * FROM aluno_turma ORDER BY cod_aluno_turma")) {
        
        while (resultado.next()) {
            AlunoTurma alunoTurma = new AlunoTurma();

            alunoTurma.setCod_aluno_turma(resultado.getInt("cod_aluno_turma"));
                   
            LocalDate dataMatricula = resultado.getDate("data_matricula").toLocalDate();
            alunoTurma.setData_matricula(dataMatricula);
                    
            alunoTurma.setCod_aluno(resultado.getInt("cod_aluno"));
            alunoTurma.setCod_turma(resultado.getInt("cod_turma"));
                    
            alunoTurmas.add(alunoTurma);
        }
    } catch (SQLException ex) {
        Logger.getLogger(AlunoTurmaModel.class.getName()).log(Level.SEVERE, null, ex);
    }
    return alunoTurmas;
}

public String inserirAlunoTurma(AlunoTurma alunoTurma) {
    ConexaoMySQL conexao = new ConexaoMySQL();
    Connection conn = null;
    PreparedStatement stm = null;
    String resultado = "";

    try {
        conn = conexao.conectar();
        String consulta = "INSERT INTO aluno_turma (cod_aluno_turma, data_matricula, cod_aluno, cod_turma) VALUES (?, ?, ?, ?)";

        stm = conn.prepareStatement(consulta);
        stm.setInt(1, alunoTurma.getCod_aluno_turma());
        
        if (alunoTurma.getData_matricula() != null) {
            java.sql.Date dataMatriculaSQL = java.sql.Date.valueOf(alunoTurma.getData_matricula());
            stm.setDate(2, dataMatriculaSQL);
        } else {
            stm.setNull(2, java.sql.Types.DATE);
        }
        
        stm.setInt(3, alunoTurma.getCod_aluno());
        stm.setInt(4, alunoTurma.getCod_turma());
        
        // Executando a inserção
        int linhasAfetadas = stm.executeUpdate();
        if (linhasAfetadas > 0) {
            resultado = "inserido";
        } else {
            resultado = "erro";
        }
    } catch (SQLException ex) {
        resultado = "erro" + ex.getMessage();
    } finally {
        // Fechando os recursos
        if (stm != null) {
            try {
                stm.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    return resultado;
}

    
   
public ArrayList<AlunoTurma> consultarAlunosTurmas() {
    ConexaoMySQL conexao = new ConexaoMySQL();
    ArrayList<AlunoTurma> alunosTurmas = new ArrayList<>();

    Connection conn = null;
    PreparedStatement stm = null;
    ResultSet resultado = null;

    try {
        conn = conexao.conectar();
        String query = "SELECT * FROM aluno_turma";
        stm = conn.prepareStatement(query);
        resultado = stm.executeQuery();

        while (resultado.next()) {
            AlunoTurma alunoTurma = new AlunoTurma();

            alunoTurma.setCod_aluno_turma(resultado.getInt("cod_aluno_turma"));
            alunoTurma.setData_matricula(resultado.getDate("data_matricula").toLocalDate());
            alunoTurma.setCod_aluno(resultado.getInt("cod_aluno"));
            alunoTurma.setCod_turma(resultado.getInt("cod_turma"));

            alunosTurmas.add(alunoTurma);
        }
    } catch (SQLException ex) {
        Logger.getLogger(AlunoTurmaModel.class.getName()).log(Level.SEVERE, null, ex);
    } finally {
        // Fechamos os recursos em um bloco finally para garantir que sejam fechados, mesmo em caso de exceção
        if (resultado != null) {
            try {
                resultado.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (stm != null) {
            try {
                stm.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    return alunosTurmas;
}

   

    public void imprimirAlunoTurma(AlunoTurma alunoTurma) {
        System.out.println("Código do AlunoTurma: " + alunoTurma.getCod_aluno_turma() + "\n" + 
                       "Data matricula: " + alunoTurma.getData_matricula() + "\n" +  
                       "Codigo aluno: " + alunoTurma.getCod_aluno() + "\n" + 
                       "Codigo turma: " + alunoTurma.getCod_turma());
}

    public void imprimirAlunoTurma(ArrayList<AlunoTurma> alunoTurmas) {
            for (AlunoTurma alunoTurma : alunoTurmas) { 
               System.out.println("Código do AlunoTurma: " + alunoTurma.getCod_aluno_turma() + "\n" + 
                       "Data matricula: " + alunoTurma.getData_matricula() + "\n" +  
                       "Codigo aluno: " + alunoTurma.getCod_aluno() + "\n" + 
                       "Codigo turma: " + alunoTurma.getCod_turma());
               
    }
}



   public String alterarAlunoTurma(AlunoTurma alunoTurma) {
    ConexaoMySQL conexao = new ConexaoMySQL();
    Connection conn = null;
    PreparedStatement stm = null;
    String resultado = "";

    try {
        conn = conexao.conectar();
        String consulta = "UPDATE aluno_turma SET data_matricula = ?, cod_aluno = ?, cod_turma = ? WHERE cod_aluno_turma = ?";
        stm = conn.prepareStatement(consulta);

        stm.setObject(1, alunoTurma.getData_matricula());
        stm.setInt(2, alunoTurma.getCod_aluno());
        stm.setInt(3, alunoTurma.getCod_turma());
        stm.setInt(4, alunoTurma.getCod_aluno_turma());

        int linhasAfetadas = stm.executeUpdate();
        if (linhasAfetadas > 0) {
            resultado = "alterado";
        } else {
            resultado = "erro";
        }
    } catch (SQLException ex) {
        resultado = "erro" + ex.getMessage();
    } finally {
        // Fechamos os recursos em um bloco finally para garantir que sejam fechados, mesmo em caso de exceção
        if (stm != null) {
            try {
                stm.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    return resultado;
}


    public String removerAlunoTurma(int codAlunoTurma) {
    ConexaoMySQL conexao = new ConexaoMySQL();
    Connection conn = null;
    PreparedStatement stm = null;
    String resultado = "";

    try {
        conn = conexao.conectar();
        // Consulta SQL para remover um registro da tabela aluno_turma com base no código do AlunoTurma
        String consulta = "DELETE FROM aluno_turma WHERE cod_aluno_turma = ?";

        stm = conn.prepareStatement(consulta);
        // Definindo o valor do parâmetro na consulta preparada
        stm.setInt(1, codAlunoTurma);
        
        // Executando a remoção
        int linhasAfetadas = stm.executeUpdate();
        if (linhasAfetadas > 0) {
            resultado = "removido";
        } else {
            resultado = "erro";
        }
    } catch (SQLException ex) {
        resultado = "erro" + ex.getMessage();
    } finally {
        // Fechando os recursos
        if (stm != null) {
            try {
                stm.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    return resultado;
}

    
    

    public AlunoTurmaModel() {
    }
}
