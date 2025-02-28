package com.aplicacao.model;

import java.sql.*;
import java.util.ArrayList;
import com.aplicacao.conexao.ConexaoMySQL;
import com.aplicacao.dao.Curso;
import java.util.logging.Level;
import java.util.logging.Logger;


public class CursoModel {

    public static void main(String[] args) {
       
       CursoModel teste = new CursoModel();
       Curso ins = new Curso();
        ins.setSigla("MK");
        ins.setNome_curso("monkey");
        

        String res = teste.inserirCurso(ins);
        System.out.println(res);
 
     
    }

    public Curso consultarCursoPorCodigo(int codCurso) {
        
        ConexaoMySQL conexao = new ConexaoMySQL();
        Curso curso = new Curso();
        
        try (Connection conn = conexao.conectar();
             PreparedStatement stm = conn.prepareStatement("SELECT * FROM Curso WHERE cod_curso = ?")) {
            stm.setInt(1, codCurso);
            try (ResultSet resultado = stm.executeQuery()) {
                if (resultado.next()) {
                    curso.setCod_curso(resultado.getInt("cod_curso"));
                    curso.setSigla(resultado.getString("sigla"));
                    curso.setNome_curso(resultado.getString("nome_curso"));
                }
                else {
                        curso = null;
                
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(CursoModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return curso;
    }

    public ArrayList<Curso> consultarCursos() {//certo
       
        ConexaoMySQL conexao = new ConexaoMySQL();
        ArrayList<Curso> cursos = new ArrayList<>();
        
        try (Connection conn = conexao.conectar();
             Statement stm = conn.createStatement();
             ResultSet resultado = stm.executeQuery("SELECT * FROM Curso ORDER BY cod_curso")) {
            while (resultado.next()) {
                Curso curso = new Curso();
                curso.setCod_curso(resultado.getInt("cod_curso"));
                curso.setSigla(resultado.getString("sigla"));
                curso.setNome_curso(resultado.getString("nome_curso"));
                cursos.add(curso);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CursoModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cursos;
    }

    public String inserirCurso(Curso curso) {//certo
        ConexaoMySQL conexao = new ConexaoMySQL();
        Connection conn = conexao.conectar();
        String resultado = "";
        
        try {
        if(curso.getSigla() != null && !curso.getSigla().isEmpty() && 
                curso.getNome_curso() != null && !curso.getNome_curso().isEmpty()) {
        
            String consulta ="INSERT INTO Curso (sigla, nome_curso) VALUES (?, ?)";
            
            PreparedStatement stm = conn.prepareStatement(consulta);
            stm.setString(1, curso.getSigla());
            stm.setString(2, curso.getNome_curso());
            
            stm.executeUpdate();
            resultado = "Curso Inserido com Sucesso!";
        
    // Proceder com a inserção
      } else {
                resultado = "Nome ou sigla do curso está vazio.";
      }

        } catch (SQLException ex) {
            System.out.println(ex.getSQLState());
            resultado = "erro";
        }
        return resultado;
    }

    public void imprimirCurso(Curso cursos){
        
        if(cursos != null){
        System.out.println("Codigo: " + cursos.getCod_curso() + "\n" + 
               "Nome: " +  cursos.getNome_curso() + "\n" +  
               "Sigla: " +  cursos.getSigla());
        }
        else{
                System.out.println("Curso não encontrado.");
   
        }
               
    }
    
    public void imprimirCursos(ArrayList<Curso> curso){
        for (Curso cursos : curso) { 
            System.out.println("Codigo: " + cursos.getCod_curso() + "\n" + 
               "Nome: " +  cursos.getNome_curso() + "\n" +  
               "Sigla: " +  cursos.getSigla());
            System.out.println("-------------------");
        }
    }


    public String alterarCurso(Curso curso) {//certo
        ConexaoMySQL conexao = new ConexaoMySQL();
        Connection conn = conexao.conectar();
        String resultado = "";
        try {
            String consulta = "UPDATE curso SET  nome_curso = ?, sigla =? where cod_curso = ?";
            PreparedStatement stm = conn.prepareStatement(consulta);
            
            stm.setString(1, curso.getNome_curso());
            stm.setString(2, curso.getSigla());      
            stm.setInt(3, curso.getCod_curso()); 
            
            stm.executeUpdate();
            resultado = "alterado";
       
        } catch (SQLException ex) {
          System.out.println(ex.getSQLState());
          resultado = "erro";
        } 
        return resultado;
    }

    public String removerCurso(int curso) {//certo
        ConexaoMySQL conexao = new ConexaoMySQL();
        Connection conn = conexao.conectar();
        String resultado = "";
        try {
            String consulta = "DELETE FROM curso WHERE cod_curso = ?";

            PreparedStatement stm = conn.prepareStatement(consulta);
            stm.setInt(1, curso);
            
            stm.executeUpdate();
            resultado = "removido";
        } catch (SQLException ex) {
          System.out.println(ex.getSQLState());
          resultado = "erro";
        } 
        return resultado;
    }
    
    

    public CursoModel() {
    }
}
