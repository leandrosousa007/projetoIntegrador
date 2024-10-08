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
import modelo.Funcionario;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author leand
 */
public class FuncionarioControle {
    
    public static void main(String[] args) {
       FuncionarioControle teste = new FuncionarioControle();
        /*Funcionario ins = new Funcionario();
        ins.setNome("Leozin");
        ins.setMatricula("1234567");
        ins.setRg("80000");
        ins.setEmail("leo@gmail.com");
        ins.setTelefone("34996848289");
        ins.setEndereco("Rua da patria, 180");
        
        LocalDate dataNascimento = LocalDate.parse("2006-12-21");
        ins.setData_nasc(dataNascimento);
        
        ins.setSexo('M');
        ins.setCod_curso(1);
        ins.setCod_resp(2);
        
        String res = teste.inserirFuncionario(ins);
        System.out.println("Retorno: " + res);*/
        

        
       /* String res = teste.removerFuncionario(5); //Remover Funcionario
        System.out.println("removido : " + res);*/
        
       
      
     
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
                    funcionario.setNome(resultado.getString("Nome"));
                    funcionario.setCargo(resultado.getString("Cargo"));
                    
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(FuncionarioControle.class.getName()).log(Level.SEVERE, null, ex);
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
            funcionario.setNome(resultado.getString("Nome"));
            funcionario.setCargo(resultado.getString("Cargo"));
            
            funcionarios.add(funcionario); // Adicionando o funcionário à lista
        }
    } catch (SQLException ex) {
        Logger.getLogger(FuncionarioControle.class.getName()).log(Level.SEVERE, null, ex);
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

            String consulta = "INSERT INTO Funcionario (nome, cargo) VALUES (?, ?)";
            
            PreparedStatement stm = conn.prepareStatement(consulta);
            stm.setString(1, funcionario.getNome());
            stm.setString(2, funcionario.getCargo());
            
            stm.executeUpdate();
            resultado = "Funcionário inserido com sucesso.";

        } else {
            resultado = "O nome ou o cargo do funcionário está vazio.";
        }

    } catch (SQLException ex) {
        System.out.println(ex.getSQLState());
        resultado = "Erro ao inserir o funcionário.";
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
        String consulta = "UPDATE funcionario SET nome = ?, cargo = ? WHERE cod_funcionario = ?";
        PreparedStatement stm = conn.prepareStatement(consulta);

        stm.setString(1, funcionario.getNome());
        stm.setString(2, funcionario.getCargo());
        stm.setInt(3, funcionario.getCod_funcionario());

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
    
    

    public FuncionarioControle() {
    }
}
