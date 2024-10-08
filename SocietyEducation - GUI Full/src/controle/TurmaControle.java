/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controle;

import java.sql.*;
import java.util.ArrayList;
import conexao.ConexaoMySQL;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Turma;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author leand
 */
public class TurmaControle {
    
    public static void main(String[] args) {
       TurmaControle teste = new TurmaControle();
 
        
       
      
     
    }

    public Turma consultarTurmaPorCodigo(int codTurma) {
    ConexaoMySQL conexao = new ConexaoMySQL();
    Turma turma = new Turma();
    try (Connection conn = conexao.conectar();
            PreparedStatement stm = conn.prepareStatement("SELECT * FROM Turma WHERE cod_turma = ?")) {
            stm.setInt(1,codTurma);
        try (ResultSet resultado = stm.executeQuery()) {
            if (resultado.next()) {
                turma.setCod_turma(resultado.getInt("cod_turma"));
                turma.setNome_turma(resultado.getString("nome_turma"));
                turma.setAno(resultado.getInt("ano"));
                turma.setPeriodo(resultado.getString("periodo"));
                turma.setCod_curso(resultado.getInt("cod_curso"));
            }
        }
    } catch (SQLException ex) {
        Logger.getLogger(TurmaControle.class.getName()).log(Level.SEVERE, null, ex);
    }
    return turma;
}

    public ArrayList<Turma> consultarTurmas() {
    ConexaoMySQL conexao = new ConexaoMySQL();
    ArrayList<Turma> turmas = new ArrayList<>();
    
    try (Connection conn = conexao.conectar();
         Statement stm = conn.createStatement();
         ResultSet resultado = stm.executeQuery("SELECT * FROM Turma ORDER BY cod_turma")) {
        
        while (resultado.next()) {
            Turma turma = new Turma();

            turma.setCod_turma(resultado.getInt("cod_turma"));
            turma.setNome_turma(resultado.getString("nome_turma"));
            turma.setAno(resultado.getInt("ano")); 
            turma.setPeriodo(resultado.getString("periodo"));
            turma.setCod_curso(resultado.getInt("cod_curso"));

            turmas.add(turma);
        }
    } catch (SQLException ex) {
        Logger.getLogger(TurmaControle.class.getName()).log(Level.SEVERE, null, ex);
    }
    return turmas;
}

    public String inserirTurma(Turma turma) {//certo
        ConexaoMySQL conexao = new ConexaoMySQL();
        Connection conn = conexao.conectar();
        String resultado = "";
        
        try {

            String consulta ="INSERT INTO Turma ( nome_turma, ano, periodo, cod_curso) VALUES (?,?,?,?)";
            
            PreparedStatement stm = conn.prepareStatement(consulta);
            
            stm.setString(1, turma.getNome_turma());
            stm.setInt(2, turma.getAno());
            stm.setString(3, turma.getPeriodo());
            stm.setInt(4, turma.getCod_curso());
            
            stm.executeUpdate();
            resultado = "inserido";


        } catch (SQLException ex) {
            System.out.println(ex.getSQLState());
            resultado = "erro";
        }
        
        return resultado;
        
    }

    public void imprimirTurma(Turma turma) {
        System.out.println("Código do Turma: " + turma.getCod_turma() + "\n" + 
                       "Nome_turma: " + turma.getNome_turma() + "\n" +  
                       "Ano: " + turma.getAno() + "\n" + 
                       "Periodo: " + turma.getPeriodo() + "\n" +
                       "Cod_curso: " + turma.getCod_curso());
}

    public void imprimirTurmas(ArrayList<Turma> turmas) {
            for (Turma turma : turmas) { 
                System.out.println("Código do Turma: " + turma.getCod_turma() + "\n" + 
                       "Nome_turma: " + turma.getNome_turma() + "\n" +  
                       "Ano: " + turma.getAno() + "\n" + 
                       "Periodo: " + turma.getPeriodo() + "\n" +
                       "Cod_curso: " + turma.getCod_curso() +"\n"
                + "-------------------");
    }
}



   public String alterarTurma(Turma turma) {
    ConexaoMySQL conexao = new ConexaoMySQL();
    Connection conn = conexao.conectar();
    String resultado = "";
    try {
        // Verificar se o novo nome da turma já está em uso por outra turma (exceto a própria turma que está sendo atualizada)
        String consultaVerificacao = "SELECT COUNT(*) AS total FROM turma WHERE nome_turma = ? AND cod_turma != ?";
        PreparedStatement stmVerificacao = conn.prepareStatement(consultaVerificacao);
        stmVerificacao.setString(1, turma.getNome_turma());
        stmVerificacao.setInt(2, turma.getCod_turma());
        ResultSet rs = stmVerificacao.executeQuery();
        rs.next();
        int total = rs.getInt("total");
        if (total > 0) {
            return "Erro: O nome da turma já está em uso por outra turma.";
        }

        // Atualizar os dados da turma
        String consultaAtualizacao = "UPDATE turma SET nome_turma = ?, ano = ?, periodo = ?, cod_curso = ? WHERE cod_turma = ?";
        PreparedStatement stm = conn.prepareStatement(consultaAtualizacao);
        stm.setString(1, turma.getNome_turma());
        stm.setInt(2, turma.getAno());
        stm.setString(3, turma.getPeriodo());
        stm.setInt(4, turma.getCod_curso());
        stm.setInt(5, turma.getCod_turma());
        stm.executeUpdate();
        resultado = "Turma alterada com sucesso.";

    } catch (SQLException ex) {
        System.out.println("Erro SQL: " + ex.getMessage());
        resultado = "Erro ao alterar a turma.";
    } finally {
        try {
            conn.close();
        } catch (SQLException e) {
            System.out.println("Erro ao fechar a conexão: " + e.getMessage());
        }
    }
    return resultado;
}

    
    

    public String removerTurma(int turma) {//certo
        ConexaoMySQL conexao = new ConexaoMySQL();
        Connection conn = conexao.conectar();
        String resultado = "";
        try {
            String consulta = "DELETE FROM turma WHERE cod_turma = ?";

            PreparedStatement stm = conn.prepareStatement(consulta);
            stm.setInt(1, turma);
            
            stm.executeUpdate();
            resultado = "removido";
        } catch (SQLException ex) {
          System.out.println(ex.getSQLState());
          resultado = "erro";
        } 
        return resultado;
    }
    
    

    public TurmaControle() {
    }
}
